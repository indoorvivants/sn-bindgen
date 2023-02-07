package bindgen.interface

import java.io.*
import java.lang.ProcessBuilder.Redirect
import java.nio.file.*
import scala.sys.process.ProcessLogger
import scala.util.control.NonFatal

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
    systemIncludes: Includes,
    noConstructor: Set[String],
    opaqueStructs: Set[String],
    multiFile: Boolean
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

    if (noConstructor.nonEmpty)
      arg("render.no-constructor", noConstructor.toList.sorted.mkString(","))

    if (opaqueStructs.nonEmpty)
      arg("render.opaque-structs", opaqueStructs.toList.sorted.mkString(","))

    flag(logLevel.str)
    if (lang == BindingLang.Scala)
      flag("scala")
    else
      flag("c")

    if (multiFile && lang == BindingLang.Scala) flag("multi-file")

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
      systemIncludes: Includes = Includes.ClangSearchPath,
      noConstructor: Set[String] = Set.empty,
      opaqueStructs: Set[String] = Set.empty,
      multiFile: Boolean = false
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
      logLevel = logLevel,
      systemIncludes = systemIncludes,
      noConstructor = noConstructor,
      opaqueStructs = opaqueStructs,
      multiFile = multiFile
    )
  }
}

sealed trait Includes extends Product with Serializable
object Includes {
  case object ClangSearchPath extends Includes
  case object None extends Includes
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
        .getLines
        .foreach(errPrintln(_))

      io.Source
        .fromInputStream(process.getInputStream())
        .getLines
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
