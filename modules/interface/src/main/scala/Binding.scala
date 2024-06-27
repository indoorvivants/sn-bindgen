package bindgen.interface

import java.io.*
import java.lang.ProcessBuilder.Redirect
import java.nio.file.*
import scala.sys.process.ProcessLogger
import scala.util.control.NonFatal

import BindingLang.*
import Utils.*
import Binding.Defaults
import bindgen.interface.Flavour.ScalaNative04
import bindgen.interface.Flavour.ScalaNative05

class Binding private (
    impl: Binding.BindingArgs
) { self =>

  def headerFile: File = impl.headerFile
  def packageName: String = impl.packageName
  def linkName: Option[String] = impl.linkName
  def cImports: List[String] = impl.cImports
  def clangFlags: List[String] = impl.clangFlags
  def exclusivePrefixes: List[String] = impl.exclusivePrefixes
  def logLevel: LogLevel = impl.logLevel
  def systemIncludes: Includes = impl.systemIncludes
  def noConstructor: Set[String] = impl.noConstructor
  def opaqueStructs: Set[String] = impl.opaqueStructs
  def multiFile: Boolean = impl.multiFile
  def noComments: Boolean = impl.noComments
  def noLocation: Boolean = impl.noLocation
  def exportMode: Boolean = impl.exportMode
  def externalPaths: Map[String, String] = impl.externalPaths
  def externalNames: Map[String, String] = impl.externalNames
  def bindgenArguments: List[String] = impl.bindgenArguments
  def excludeSystemPaths: List[Path] = impl.excludeSystemPaths
  def scalaFile: String = impl.scalaFile
  def cFile: String = impl.cFile
  def flavour: Option[Flavour] = impl.flavour

  def withLinkName(name: String) = copy(_.copy(linkName = Some(name)))

  def addCImport(header: String): Binding =
    copy(b => b.copy(cImports = b.cImports :+ header))

  def addCImports(headers: Seq[String]): Binding =
    copy(b => b.copy(cImports = b.cImports ++ headers))

  def withCImports(headers: Seq[String]): Binding =
    copy(b => b.copy(cImports = headers.toList))

  def addClangFlag(flag: String): Binding =
    copy(b => b.copy(clangFlags = b.clangFlags :+ flag))

  def addClangFlag(flags: Seq[String]): Binding =
    copy(b => b.copy(clangFlags = b.clangFlags ++ flags))

  def withClangFlags(flags: Seq[String]): Binding =
    copy(b => b.copy(clangFlags = flags.toList))

  def withLogLevel(level: LogLevel): Binding = copy(_.copy(logLevel = level))

  def withSystemIncludes(includes: Includes): Binding = copy(
    _.copy(systemIncludes = includes)
  )
  def withMultiFile(b: Boolean): Binding = copy(_.copy(multiFile = b))

  def withNoComments(b: Boolean): Binding = copy(_.copy(noComments = b))

  def withNoLocation(b: Boolean): Binding = copy(_.copy(noLocation = b))

  def withExport(b: Boolean): Binding = copy(_.copy(exportMode = b))

  def withPackageName(name: String) = copy(_.copy(packageName = name))

  def withHeaderFile(header: File) = copy(_.copy(headerFile = header))

  def withNoConstructor(structs: Set[String]): Binding = copy(
    _.copy(noConstructor = structs)
  )

  def withOpaqueStructs(structs: Set[String]): Binding = copy(
    _.copy(opaqueStructs = structs)
  )

  def withExternalPaths(externals: Map[String, String]): Binding = copy(
    _.copy(externalPaths = externals)
  )

  def addExternalPath(fileFilter: String, packageName: String): Binding =
    copy(b =>
      b.copy(externalPaths = b.externalPaths.updated(fileFilter, packageName))
    )

  def addExternalPaths(externals: Map[String, String]): Binding =
    copy(b => b.copy(externalPaths = b.externalPaths ++ externals))

  def withExternalNames(externals: Map[String, String]): Binding = copy(
    _.copy(externalNames = externals)
  )

  def withFlavour(flavour: Flavour): Binding =
    copy(b => b.copy(flavour = Some(flavour)))

  def addExternalName(nameFilter: String, packageName: String): Binding =
    copy(b =>
      b.copy(externalNames = b.externalNames.updated(nameFilter, packageName))
    )

  def addExternalNames(externals: Map[String, String]): Binding =
    copy(b => b.copy(externalNames = b.externalNames ++ externals))

  def addExcludedSystemPath(path: Path): Binding =
    copy(b => b.copy(excludeSystemPaths = b.excludeSystemPaths :+ path))

  def withExcludedSystemPaths(paths: List[Path]): Binding =
    copy(b => b.copy(excludeSystemPaths = paths))

  def withBindgenArguments(arguments: List[String]): Binding =
    copy(_.copy(bindgenArguments = arguments))

  def addBindgenArgument(argument: String): Binding =
    copy(b => b.copy(bindgenArguments = b.bindgenArguments :+ argument))

  def addBindgenArguments(arguments: List[String]): Binding =
    copy(b => b.copy(bindgenArguments = b.bindgenArguments ++ arguments))

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
    if (exportMode && lang == BindingLang.Scala) flag("export")

    externalPaths.toList.sorted.map { case (filter, pkg) =>
      arg("render.external-path", s"$filter=$pkg")
    }

    externalNames.toList.sorted.map { case (filter, pkg) =>
      arg("render.external-name", s"$filter=$pkg")
    }

    excludeSystemPaths.map { case path =>
      arg("exclude-system-path", path.toString())
    }

    flavour.foreach { flavour =>
      arg("flavour", flavour.tag)
    }

    sb ++= bindgenArguments

    sb.result()
  }

  private def copy(f: Binding.BindingArgs => Binding.BindingArgs) =
    new Binding(f(impl))

  @deprecated(
    "The binding builder is deprecated. This method is only preserved for ease of migration. " +
      "You can safely remove the call to this method. " +
      "This method will be removed in 0.1.0",
    "0.0.24"
  )
  def build: Binding = this

}

object Binding {
  def apply(header: File, packageName: String): Binding =
    new Binding(
      BindingArgs(
        headerFile = header,
        packageName = packageName,
        cFile = s"$packageName.c",
        scalaFile = s"$packageName.scala"
      )
    )

  @deprecated(
    "The binding builder is deprecated. This method is only preserved for ease of migration. " +
      "Use `apply(...)` and call builder methods on binding directly. " +
      "This method will be removed in 0.1.0",
    "0.0.24"
  )
  def builder(header: File, packageName: String): Binding =
    apply(header, packageName)

  @deprecated(
    "This method will be removed, please use the builder pattern instead" +
      " - Binding(headerFile, packageName).withParam(...).withOtherParam(...)...",
    "0.0.23"
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
    apply(headerFile, packageName).copy(
      _.copy(
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
        noLocation = noLocation
      )
    )
  }

  private[interface] case class BindingArgs(
      headerFile: File,
      packageName: String,
      linkName: Option[String] = Defaults.linkName,
      cImports: List[String] = Defaults.cImports,
      clangFlags: List[String] = Defaults.clangFlags,
      exclusivePrefixes: List[String] = Defaults.exclusivePrefixes,
      logLevel: LogLevel = Defaults.logLevel,
      systemIncludes: Includes = Defaults.systemIncludes,
      noConstructor: Set[String] = Defaults.noConstructor,
      opaqueStructs: Set[String] = Defaults.opaqueStructs,
      multiFile: Boolean = Defaults.multiFile,
      noComments: Boolean = Defaults.noComments,
      noLocation: Boolean = Defaults.noLocation,
      exportMode: Boolean = Defaults.exportMode,
      externalPaths: Map[String, String] = Defaults.externalPaths,
      externalNames: Map[String, String] = Defaults.externalNames,
      bindgenArguments: List[String] = Defaults.bindgenArguments,
      excludeSystemPaths: List[Path] = Defaults.excludeSystemPaths,
      flavour: Option[Flavour] = None,
      scalaFile: String,
      cFile: String
  ) {
    override def toString(): String =
      classOf[BindingArgs]
        .getDeclaredFields()
        .map(field => field.getName())
        .toList
        .zip(productIterator.toList)
        .map { case (name, value) =>
          s"$name = $value"
        }
        .mkString(productPrefix + "(", ", ", ")")
  }

  private[interface] object Defaults {
    val linkName = None
    val cImports = List.empty[String]
    val clangFlags = List.empty[String]
    val logLevel = LogLevel.Warn
    val systemIncludes = Includes.ClangSearchPath
    val noConstructor = Set.empty[String]
    val opaqueStructs = Set.empty[String]
    val exclusivePrefixes = List.empty[String]
    val multiFile = false
    val noComments = false
    val noLocation = false
    val externalPaths = Map.empty[String, String]
    val externalNames = Map.empty[String, String]
    val bindgenArguments = List.empty[String]
    val excludeSystemPaths = List.empty[Path]
    val exportMode = false
    val flavour = Flavour.ScalaNative04
  }

}
