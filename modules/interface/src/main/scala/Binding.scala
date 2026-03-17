package bindgen.interface

import java.io.*
import java.nio.file.*

class Binding private (
    impl: Binding.BindingArgs
) { self =>

  /** Path to the main header file being processed
    */
  def headerFile: File = impl.headerFile

  /** Name of the package under which all the definitions will be placed */
  def packageName: String = impl.packageName

  /** Name of the native library the external functions are intended to be
    * linked with. This puts a `@link` annotation on the extern_funcitons
    * object, which gets transformed into a `-l<name>` flag when linking the
    * project
    */
  def linkName: Option[String] = impl.linkName

  /** List of raw C imports to be added to generated C glue code (if there is
    * any)
    */
  def cImports: List[String] = impl.cImports

  /** Flags passed to clang during header analysis stage
    */
  def clangFlags: List[String] = impl.clangFlags
  def exclusivePrefixes: List[String] = impl.exclusivePrefixes
  def logLevel: LogLevel = impl.logLevel

  /** See [[Includes]]. Controls how much discovery bindgen will do to find out
    * the necessary default headers that clang itself adds implicitly to any
    * compilation.
    *
    * @return
    */
  def systemIncludes: Includes = impl.systemIncludes

  /** Wildcard matchers or full names of structs for which no constructor will
    * be rendered – large number of paramters somehow causes issues during
    * compilation.
    */
  def noConstructor: Set[String] = impl.noConstructor

  /** Wildcard matchers or full names of structs which won't will be rendered as
    * `CStructN[...]` but rather erased to a flat CArray with field offsets
    * recovered by extra logic.
    *
    * Sometimes required when Scala compiler generates method signatures too big
    * to fit on the JVM during compilation phase.
    */
  def opaqueStructs: Set[String] = impl.opaqueStructs

  /** Wildcard matchers or full names of macros that bindgen will attempt to
    * render as Scala constants
    */
  def macroDefinitions: Set[String] = impl.macroDefinitions

  /** When true, bindgen won't render unsupported macros as a compile-time only
    * artifact (one you can't use, but at least you can find it by name and see
    * what the C definition was)
    */
  def onlyValidMacros: Boolean = impl.onlyValidMacros

  /** Whether the bindings are rendered as multiple files under the same package
    * (without exports)
    *
    * @return
    */
  def multiFile: Boolean = impl.multiFile

  /** Whether comments are rendered in generated code or not
    */
  def noComments: Boolean = impl.noComments

  /** Whether the header file locations for definitions are rendered in
    * generated code or not.
    *
    * @return
    */
  def noLocation: Boolean = impl.noLocation

  /** This flag controls whether bindings are intended to be exported as an
    * interface to a Scala Native library. See
    * [[https://sn-bindgen.indoorvivants.com/exports/index.html]] for more
    * details.
    *
    * @return
    */
  def exportMode: Boolean = impl.exportMode

  /** A mapping between path name patterns and package names which define
    * whether C definitions from matching header paths should be rendered as
    * references to another package instead of being fully analysed and rendered
    * inline.
    *
    * Example:
    *
    * `Map("*\graphene-1.0\*" -> "sn.bindgen.graphene")` means that should at
    * some point we encounter a definition in a path that matches this glob
    * (let's say `GrapheneComponent` in
    * `/usr/lib/include/graphene-1.0/graphene.h`, which is included from the
    * main header file), it won't be read and rendered, but instead a single
    * reference to `sn.bindgen.graphene.` will be emitted.
    *
    * See
    * [[https://sn-bindgen.indoorvivants.com/cookbook/index.html#advanced-splitting-the-binding-into-multiple-packages]]
    * for details.
    *
    * @return
    */
  def externalPaths: Map[String, String] = impl.externalPaths

  /** A mapping between C definition name patterns and package names which
    * define whether matching C definitions should be rendered as references to
    * another package instead of being fully analysed and rendered inline.
    *
    * Example:
    *
    * `Map("Gtk*" -> "sn.bindgen.gtk")` means that when a reference to, let's
    * say, GtkWidget is encountered in the bindings, it won't be read and
    * rendered, but instead a single reference to `sn.bindgen.gtk.GtkWidget`
    * will be emitted.
    *
    * See
    * [[https://sn-bindgen.indoorvivants.com/cookbook/index.html#advanced-splitting-the-binding-into-multiple-packages]]
    * for details.
    *
    * @return
    */
  def externalNames: Map[String, String] = impl.externalNames

  /** A list of raw CLI arguments to be passed to bindgen. This is an escape
    * hatch in case the interface does not have specialised methods for the
    * feature or flag you want.
    *
    * @return
    */
  def bindgenArguments: List[String] = impl.bindgenArguments

  /** List of paths that should not be treated as system paths. Definitions in
    * system paths are only rendered when some other definition from the main
    * header file is referencing them.
    *
    * The logic for system path detection is brittle, so sometimes it's easier
    * to just exclude a path.
    *
    * @return
    */
  def excludeSystemPaths: List[Path] = impl.excludeSystemPaths

  /** Name of the Scala file for generated bindings. By default it's
    * [[packageName]].scala. This name only has effect when bindings are
    * generated as a single file.
    *
    * @return
    */
  def scalaFile: String = impl.scalaFile

  /** Name of the C file for generated bindings (if they require any glue code).
    * By default it's [[packageName]].c
    *
    * @return
    */
  def cFile: String = impl.cFile

  /** See [[Flavour]. Allows controlling whether the bindings are intended to be
    * compiled with Scala Native 0.5 or 0.4.
    */
  def flavour: Option[Flavour] = impl.flavour

  /** Whether significant indentation or braces are used in the generated code
    *
    * @return
    */
  def useBraces: Boolean = impl.useBraces

  /** See [[linkName]]. This method overwrites the value with a new one
    */
  def withLinkName(name: String) = copy(_.copy(linkName = Some(name)))

  /** See [[cImports]]. This method appends a raw import to the end of current
    * ones.
    */
  def addCImport(header: String): Binding =
    copy(b => b.copy(cImports = b.cImports :+ header))

  /** See [[cImports]]. This method appends a raw imports to the end of current
    * ones.
    */

  def addCImports(headers: Seq[String]): Binding =
    copy(b => b.copy(cImports = b.cImports ++ headers))

  /** See [[cImports]]. This method overwrites the list of imports with a new
    * one
    */
  def withCImports(headers: Seq[String]): Binding =
    copy(b => b.copy(cImports = headers.toList))

  /** See [[clangFlags]]. This method appends flag to the end of current ones.
    *
    * @param flag
    * @return
    */
  def addClangFlag(flag: String): Binding =
    copy(b => b.copy(clangFlags = b.clangFlags :+ flag))

  /** See [[clangFlags]]. This method appends new flags to the end of current
    * ones.
    *
    * @param flags
    * @return
    */
  def addClangFlag(flags: Seq[String]): Binding =
    copy(b => b.copy(clangFlags = b.clangFlags ++ flags))

  /** See [[clangFlags]]. This method overwrites list of flags with a new one
    *
    * @param flags
    * @return
    */
  def withClangFlags(flags: Seq[String]): Binding =
    copy(b => b.copy(clangFlags = flags.toList))

  def withLogLevel(level: LogLevel): Binding = copy(_.copy(logLevel = level))

  /** See [[systemIncludes]]
    *
    * @param includes
    * @return
    */
  def withSystemIncludes(includes: Includes): Binding = copy(
    _.copy(systemIncludes = includes)
  )

  def withMultiFile(b: Boolean): Binding = copy(_.copy(multiFile = b))

  /** See [[noComments]]
    *
    * @param b
    * @return
    */
  def withNoComments(b: Boolean): Binding = copy(_.copy(noComments = b))

  /** See [[noLocation]]
    *
    * @param b
    * @return
    */
  def withNoLocation(b: Boolean): Binding = copy(_.copy(noLocation = b))

  /** See [[exportMode]].
    *
    * @param b
    * @return
    */
  def withExport(b: Boolean): Binding = copy(_.copy(exportMode = b))

  /** See [[packageName]]
    *
    * @param name
    * @return
    */
  def withPackageName(name: String) = copy(_.copy(packageName = name))

  /** See [[headerFile]]
    *
    * @param header
    * @return
    */
  def withHeaderFile(header: File) = copy(_.copy(headerFile = header))

  /** See [[noConstructor]]
    * @param structs
    * @return
    */
  def withNoConstructor(structs: Set[String]): Binding = copy(
    _.copy(noConstructor = structs)
  )

  /** See [[opaqueStructs]]
    * @param structs
    * @return
    */
  def withOpaqueStructs(structs: Set[String]): Binding = copy(
    _.copy(opaqueStructs = structs)
  )

  /** See [[macroDefinitions]]
    *
    * @param names
    * @return
    */
  def withMacros(names: Set[String]): Binding = copy(
    _.copy(macroDefinitions = names)
  )

  /** See [[onlyValidMacros]]
    *
    * @param b
    * @return
    */
  def withOnlyValidMacros(b: Boolean): Binding = copy(
    _.copy(onlyValidMacros = b)
  )

  /** See [[externalPaths]]
    *
    * @param externals
    * @return
    */
  def withExternalPaths(externals: Map[String, String]): Binding = copy(
    _.copy(externalPaths = externals)
  )

  /** See [[externalPaths]]
    *
    * @param externals
    * @return
    */
  def addExternalPath(fileFilter: String, packageName: String): Binding =
    copy(b =>
      b.copy(externalPaths = b.externalPaths.updated(fileFilter, packageName))
    )

  /** See [[externalPaths]]
    *
    * @param externals
    * @return
    */
  def addExternalPaths(externals: Map[String, String]): Binding =
    copy(b => b.copy(externalPaths = b.externalPaths ++ externals))

  /** See [[externalNames]]
    *
    * @param externals
    * @return
    */
  def withExternalNames(externals: Map[String, String]): Binding = copy(
    _.copy(externalNames = externals)
  )

  /** See [[externalNames]]
    *
    * @param externals
    * @return
    */
  def addExternalName(nameFilter: String, packageName: String): Binding =
    copy(b =>
      b.copy(externalNames = b.externalNames.updated(nameFilter, packageName))
    )

  /** See [[externalNames]]
    *
    * @param externals
    * @return
    */
  def addExternalNames(externals: Map[String, String]): Binding =
    copy(b => b.copy(externalNames = b.externalNames ++ externals))

  /** See [[flavour]]
    *
    * @param flavour
    * @return
    */
  def withFlavour(flavour: Flavour): Binding =
    copy(b => b.copy(flavour = Some(flavour)))

  /** See [[excludeSystemPaths]]
    *
    * @param path
    * @return
    */
  def addExcludedSystemPath(path: Path): Binding =
    copy(b => b.copy(excludeSystemPaths = b.excludeSystemPaths :+ path))

  /** See [[excludeSystemPaths]]
    *
    * @param path
    * @return
    */
  def withExcludedSystemPaths(paths: List[Path]): Binding =
    copy(b => b.copy(excludeSystemPaths = paths))

  /** See [[bindgenArguments]]
    *
    * @param arguments
    * @return
    */
  def withBindgenArguments(arguments: List[String]): Binding =
    copy(_.copy(bindgenArguments = arguments))

  /** See [[bindgenArguments]]
    *
    * @param arguments
    * @return
    */
  def addBindgenArgument(argument: String): Binding =
    copy(b => b.copy(bindgenArguments = b.bindgenArguments :+ argument))

  /** See [[bindgenArguments]]
    *
    * @param arguments
    * @return
    */
  def addBindgenArguments(arguments: List[String]): Binding =
    copy(b => b.copy(bindgenArguments = b.bindgenArguments ++ arguments))

  /** See [[useBraces]].
    *
    * @param b
    * @return
    */
  def withBraces(b: Boolean): Binding =
    copy(_.copy(useBraces = b))

  /** Produces a full list of CLI arguments that bindgen should be invoked with,
    * for a given output language
    *
    * @param lang
    * @return
    */
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

    if (macroDefinitions.nonEmpty)
      arg("macros", macroDefinitions.toList.sorted.mkString(","))

    flag(logLevel.str)
    if (lang == BindingLang.Scala)
      flag("scala")
    else
      flag("c")

    if (useBraces && lang == BindingLang.Scala) flag("use-braces")
    if (multiFile && lang == BindingLang.Scala) flag("multi-file")
    if (noComments && lang == BindingLang.Scala) flag("render.no-comments")
    if (noLocation && lang == BindingLang.Scala) flag("render.no-location")
    if (onlyValidMacros && lang == BindingLang.Scala)
      flag("render.only-valid-macros")
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
      macroDefinitions: Set[String] = Defaults.macroDefinitions,
      onlyValidMacros: Boolean = Defaults.onlyValidMacros,
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
      cFile: String,
      useBraces: Boolean = Defaults.useBraces
  )

  private[interface] object Defaults {
    val linkName = None
    val cImports = List.empty[String]
    val clangFlags = List.empty[String]
    val logLevel = LogLevel.Warn
    val systemIncludes = Includes.ClangSearchPath
    val noConstructor = Set.empty[String]
    val opaqueStructs = Set.empty[String]
    val macroDefinitions = Set.empty[String]
    val onlyValidMacros = false
    val exclusivePrefixes = List.empty[String]
    val multiFile = false
    val noComments = false
    val noLocation = false
    val externalPaths = Map.empty[String, String]
    val externalNames = Map.empty[String, String]
    val bindgenArguments = List.empty[String]
    val excludeSystemPaths = List.empty[Path]
    val exportMode = false
    val flavour = Flavour.ScalaNative05
    val useBraces = false
  }

}
