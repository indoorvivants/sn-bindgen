package bindgen.interface

import java.io.File
import java.nio.file.Paths
import java.io.FileWriter
import scala.util.control.NonFatal
import scala.sys.process.ProcessLogger
import java.nio.file.Files
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.FileOutputStream
import java.io.Writer
import java.nio.file.Path

sealed trait BindingLang extends Product with Serializable
object BindingLang {
  case object Scala extends BindingLang
  case object C extends BindingLang
}

sealed abstract class LogLevel(val str: String)
    extends Product
    with Serializable
object LogLevel {
  case object Trace extends LogLevel("trace")
  case object Info extends LogLevel("info")
  case object Warn extends LogLevel("warning")
  case object Error extends LogLevel("error")

  def apply(str: String): Option[LogLevel] =
    try {
      Option {
        str.toLowerCase match {
          case "trace"   => Trace
          case "info"    => Info
          case "warning" => Warn
          case "error"   => Error
        }
      }
    } catch { case _: MatchError => None }
}

import BindingLang.*
object Utils {
  private[interface] implicit class FileOps(val f: File) extends AnyVal {
    def /(other: String): File = {
      val result = Paths.get(f.toPath.toString, other).toFile
      Files.createDirectories(f.toPath())
      result
    }
  }
  private[interface] def fileWriter(destination: File)(f: Writer => Unit) = {
    var fw: Option[BufferedWriter] = None
    try {
      fw = Option(
        new BufferedWriter(
          new OutputStreamWriter(new FileOutputStream(destination))
        )
      )

      fw.foreach(f)
    } catch {
      case NonFatal(ex) => fw.foreach(_.close()); throw ex
    } finally {
      fw.foreach(_.close())
    }
  }
}

import Utils.*

case class Binding private (
    headerFile: File,
    packageName: String,
    scalaFile: String,
    cFile: String,
    linkName: Option[String],
    cImports: List[String],
    clangFlags: List[String],
    exclusivePrefixes: List[String],
    logLevel: LogLevel,
    systemIncludes: List[Includes]
) {
  def toCommand(lang: BindingLang): List[String] = {
    val sb = List.newBuilder[String]

    def arg(name: String, value: String) =
      sb ++= Seq(s"--$name", value)

    def flag(name: String) =
      sb += s"--$name"

    arg(
      "header",
      headerFile.toPath().toAbsolutePath().toString
    )
    arg("package", packageName)
    linkName.foreach { link =>
      arg("link-name", link)
    }
    cImports.foreach { cimp =>
      arg("c-import", cimp)
    }
    clangFlags.foreach { clangFlag =>
      arg("clang", clangFlag)
    }
    exclusivePrefixes.foreach { prefix =>
      arg("exclusive-prefix", prefix)
    }
    flag(logLevel.str)
    if (lang == BindingLang.Scala)
      flag("scala")
    else
      flag("c")

    sb.result()
  }

}

object Binding {
  def apply(
      headerFile: File,
      packageName: String,
      linkName: Option[String] = None,
      cImports: List[String] = Nil,
      clangFlags: List[String] = Nil,
      exclusivePrefixes: List[String] = Nil,
      logLevel: LogLevel = LogLevel.Info,
      systemIncludes: List[Includes] = List(Includes.ClangSearchPath)
  ) = {
    new Binding(
      headerFile = headerFile,
      packageName = packageName,
      linkName = linkName,
      cFile = s"$packageName.c",
      scalaFile = s"$packageName.scala",
      cImports = cImports,
      clangFlags = clangFlags,
      exclusivePrefixes = exclusivePrefixes,
      logLevel = LogLevel.Info,
      systemIncludes = systemIncludes
    )
  }
}

sealed trait Includes extends Product with Serializable
object Includes {
  case object ClangSearchPath extends Includes
  case object LLVMSources extends Includes
}

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
      ci: Platform.ClangInfo
  ): Seq[File] = {

    val files = Seq.newBuilder[File]

    bindings.foreach { binding =>
      import scala.sys.process.Process

      val destinationFilename = lang match {
        case Scala => binding.scalaFile
        case C     => binding.cFile
      }

      val destination = destinationDir / destinationFilename
      val platformArgs =
        if (binding.systemIncludes.contains(Includes.ClangSearchPath))
          ci.includePaths.flatMap(path => List("--clang-include", path))
        else Nil
      val outputArgs = Seq("--out", destination.toPath().toString())
      val cmd =
        binary.toString :: binding.toCommand(lang) ++ platformArgs ++ outputArgs

      val escapeArgs = cmd
        .map { arg =>
          if (arg contains ' ') s"'$arg'"
          else arg
        }
        .mkString(" ")

      val buf = List.newBuilder[String]
      val logger = ProcessLogger.apply(
        (o: String) => {
          buf += o
        },
        (e: String) => errPrintln(e)
      )

      val result = Process(cmd).run(logger).exitValue()

      if (result == 0) {
        errPrintln(
          s"Successfully regenerated binding ($lang) for ${binding.packageName}, $result"
        )

        files += destination
      } else {
        val code = destination.hashCode().toHexString.toUpperCase()
        errPrintln(
          s"(FAILED [$code]) Executing [$escapeArgs]"
        )

        buf.result().foreach { l =>
          errPrintln(s"/*$code*/  " + l)
        }

        throw new Exception(
          s"Process [$escapeArgs] failed with code $result"
        )
      }
    }
    files.result()
  }
}
