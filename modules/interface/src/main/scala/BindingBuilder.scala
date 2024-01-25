package bindgen.interface

import java.io.*
import java.lang.ProcessBuilder.Redirect
import java.nio.file.*
import scala.sys.process.ProcessLogger
import scala.util.control.NonFatal
import BindingLang.*
import Utils.*
import Binding.Defaults

class BindingBuilder(
    binary: File,
    errPrintln: String => Unit = s => System.err.println(s)
) {
  assert(
    Files.exists(binary.toPath),
    s"Bindgen: specified binary [$binary] doesn't exist!"
  )
  assert(
    Files.isRegularFile(binary.toPath),
    s"Bindgen: specified binary [$binary] is not a regular file!"
  )

  def generate(
      bindings: Seq[Binding],
      destinationDir: File,
      lang: BindingLang,
      clangPath: Option[Path]
  ): Seq[File] = {

    val files = Seq.newBuilder[File]

    bindings.foreach { binding =>
      import scala.sys.process.Process

      val destinationFilename = lang match {
        case Scala => binding.scalaFile
        case C     => binding.cFile
      }

      val destination = if (!binding.multiFile || lang == BindingLang.C) {
        val destinationFilename = lang match {
          case Scala => binding.scalaFile
          case C     => binding.cFile
        }

        destinationDir / destinationFilename
      } else {
        val dir = destinationDir / binding.packageName

        Files.createDirectories(dir.toPath)

        dir
      }

      val platformArgs =
        if (binding.systemIncludes == Includes.None) {
          List("--no-system")
        } else {
          clangPath match {
            case None        => Nil
            case Some(value) => List("--clang-path", value.toString)
          }
        }

      val outputArgs =
        Seq("--out", destination.toPath().toString(), "--print-files")

      val cmd =
        binary.toString :: binding.toCommand(lang) ++ platformArgs ++ outputArgs

      val escapeArgs = cmd
        .map { arg =>
          if (arg contains ' ') s"'$arg'"
          else arg
        }
        .mkString(" ")

      val stderr = List.newBuilder[String]
      val stdout = List.newBuilder[String]

      val logger = ProcessLogger.apply(
        (o: String) => stdout += o,
        (e: String) => stderr += e
      )

      val process = new java.lang.ProcessBuilder(cmd*)
        .start()

      io.Source
        .fromInputStream(process.getErrorStream())
        .getLines()
        .foreach(errPrintln(_))

      io.Source
        .fromInputStream(process.getInputStream())
        .getLines()
        .foreach(logger.out(_))

      val result = process.waitFor()

      files ++= stdout
        .result()
        .map { path => new File(path) }
        .filter(_.isFile())

      if (result == 0) {
        errPrintln(
          s"Successfully regenerated binding ($lang) for ${binding.packageName}, $result"
        )
      } else {
        val code = destination.hashCode().toHexString.toUpperCase()
        errPrintln(
          s"(FAILED [$code]) Executing [$escapeArgs]"
        )

        stderr.result().foreach(errPrintln)

        throw new Exception(
          s"Process [$escapeArgs] failed with code $result"
        )
      }
    }
    files.result()
  }
}
