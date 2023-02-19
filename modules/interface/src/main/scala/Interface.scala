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

import Binding.Defaults

class Binding private (
    val headerFile: File,
    val packageName: String,
    val linkName: Option[String],
    val cImports: List[String],
    val clangFlags: List[String],
    val exclusivePrefixes: List[String],
    val logLevel: LogLevel,
    val systemIncludes: Includes,
    val noConstructor: Set[String],
    val opaqueStructs: Set[String],
    val multiFile: Boolean,
    val noComments: Boolean,
    val noLocation: Boolean,
    val externalPaths: Map[String, String],
    val externalNames: Map[String, String],
    val scalaFile: String,
    val cFile: String
) { self =>

  private def copy(
      headerFile: File = self.headerFile,
      packageName: String = self.packageName,
      linkName: Option[String] = self.linkName,
      cImports: List[String] = self.cImports,
      clangFlags: List[String] = self.clangFlags,
      exclusivePrefixes: List[String] = self.exclusivePrefixes,
      logLevel: LogLevel = self.logLevel,
      systemIncludes: Includes = self.systemIncludes,
      noConstructor: Set[String] = self.noConstructor,
      opaqueStructs: Set[String] = self.opaqueStructs,
      multiFile: Boolean = self.multiFile,
      noComments: Boolean = self.noComments,
      noLocation: Boolean = self.noLocation,
      externalPaths: Map[String, String] = self.externalPaths,
      externalNames: Map[String, String] = self.externalNames,
      scalaFile: String = self.scalaFile,
      cFile: String = self.cFile
  ) =
    new Binding(
      headerFile = headerFile,
      packageName = packageName,
      linkName = linkName,
      cImports = cImports,
      clangFlags = clangFlags,
      exclusivePrefixes = exclusivePrefixes,
      logLevel = logLevel,
      systemIncludes = systemIncludes,
      noConstructor = noConstructor,
      opaqueStructs = opaqueStructs,
      multiFile = multiFile,
      noComments = noComments,
      noLocation = noLocation,
      externalPaths = externalPaths,
      externalNames = externalNames,
      scalaFile = scalaFile,
      cFile = cFile
    )

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
    if (noComments && lang == BindingLang.Scala) flag("render.no-comments")
    if (noLocation && lang == BindingLang.Scala) flag("render.no-location")

    externalPaths.toList.sorted.map { case (filter, pkg) =>
      arg("render.external-path", s"$filter=$pkg")
    }

    externalNames.toList.sorted.map { case (filter, pkg) =>
      arg("render.external-name", s"$filter=$pkg")
    }

    sb.result()
  }

}

object Binding {
  def builder(header: File, packageName: String) =
    new Builder(
      new Binding(
        headerFile = header,
        packageName = packageName,
        linkName = Defaults.linkName,
        cImports = Defaults.cImports,
        clangFlags = Defaults.clangFlags,
        exclusivePrefixes = Defaults.exclusivePrefixes,
        logLevel = Defaults.logLevel,
        systemIncludes = Defaults.systemIncludes,
        noConstructor = Defaults.noConstructor,
        opaqueStructs = Defaults.opaqueStructs,
        multiFile = Defaults.multiFile,
        noComments = Defaults.noComments,
        noLocation = Defaults.noLocation,
        externalPaths = Defaults.externalPaths,
        externalNames = Defaults.externalNames,
        cFile = s"$packageName.c",
        scalaFile = s"$packageName.scala"
      )
    )

  class Builder private[Binding] (binding: Binding) {
    private def copy(f: Binding => Binding): Builder =
      new Builder(f(binding))

    def withLinkName(name: String) = copy(_.copy(linkName = Some(name)))

    def addCImport(header: String): Builder =
      copy(b => b.copy(cImports = b.cImports :+ header))
    def addCImports(headers: Seq[String]): Builder =
      copy(b => b.copy(cImports = b.cImports ++ headers))
    def withCImports(headers: Seq[String]): Builder =
      copy(b => b.copy(cImports = headers.toList))

    def addClangFlag(flag: String): Builder =
      copy(b => b.copy(clangFlags = b.clangFlags :+ flag))
    def addClangFlag(flags: Seq[String]): Builder =
      copy(b => b.copy(clangFlags = b.clangFlags ++ flags))
    def withClangFlags(flags: Seq[String]): Builder =
      copy(b => b.copy(clangFlags = flags.toList))

    def withLogLevel(level: LogLevel): Builder = copy(_.copy(logLevel = level))
    def withSystemIncludes(includes: Includes): Builder = copy(
      _.copy(systemIncludes = includes)
    )
    def withMultiFile(b: Boolean): Builder = copy(_.copy(multiFile = b))
    def withNoComments(b: Boolean): Builder = copy(_.copy(noComments = b))
    def withNoLocation(b: Boolean): Builder = copy(_.copy(noLocation = b))

    def withPackageName(name: String) = copy(_.copy(packageName = name))
    def withHeaderFile(header: File) = copy(_.copy(headerFile = header))

    def withNoConstructor(structs: Set[String]) = copy(
      _.copy(noConstructor = structs)
    )
    def withOpaqueStructs(structs: Set[String]) = copy(
      _.copy(opaqueStructs = structs)
    )

    def withExternalPaths(externals: Map[String, String]) = copy(
      _.copy(externalPaths = externals)
    )
    def addExternalPath(fileFilter: String, packageName: String) = copy(b =>
      b.copy(externalPaths = b.externalPaths.updated(fileFilter, packageName))
    )
    def addExternalPaths(externals: Map[String, String]) =
      copy(b => b.copy(externalPaths = b.externalPaths ++ externals))

    def withExternalNames(externals: Map[String, String]) = copy(
      _.copy(externalNames = externals)
    )
    def addExternalName(nameFilter: String, packageName: String) = copy(b =>
      b.copy(externalNames = b.externalNames.updated(nameFilter, packageName))
    )
    def addExternalNames(externals: Map[String, String]) =
      copy(b => b.copy(externalNames = b.externalNames ++ externals))

    def build: Binding = binding
  }

  object Defaults {
    val linkName = None
    val cImports = List.empty[String]
    val clangFlags = List.empty[String]
    val logLevel = LogLevel.Info
    val systemIncludes = Includes.ClangSearchPath
    val noConstructor = Set.empty[String]
    val opaqueStructs = Set.empty[String]
    val exclusivePrefixes = List.empty[String]
    val multiFile = false
    val noComments = false
    val noLocation = false
    val externalPaths = Map.empty[String, String]
    val externalNames = Map.empty[String, String]
  }

  def apply(headerFile: File, packageName: String): Binding =
    builder(headerFile, packageName).build

  @deprecated(
    "This method will be removed, please use the builder pattern instead" +
      " - Binding.builder(headerFile, packageName).withParam.build...",
    "0.0.16"
  )
  def apply(
      headerFile: File,
      packageName: String,
      linkName: Option[String] = Defaults.linkName,
      cImports: List[String] = Defaults.cImports,
      clangFlags: List[String] = Defaults.clangFlags,
      exclusivePrefixes: List[String] = Nil,
      logLevel: LogLevel = Defaults.logLevel,
      systemIncludes: Includes = Defaults.systemIncludes,
      noConstructor: Set[String] = Defaults.noConstructor,
      opaqueStructs: Set[String] = Defaults.opaqueStructs,
      multiFile: Boolean = Defaults.multiFile,
      noComments: Boolean = Defaults.noComments,
      noLocation: Boolean = Defaults.noLocation
  ): Binding = {
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
      multiFile = multiFile,
      noComments = noComments,
      noLocation = noLocation,
      externalPaths = Defaults.externalPaths,
      externalNames = Defaults.externalNames
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
