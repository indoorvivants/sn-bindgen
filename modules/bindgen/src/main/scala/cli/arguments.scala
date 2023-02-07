package bindgen

import com.monovore.decline.Opts
import java.io.File

object CLI:
  import com.monovore.decline.*
  import cats.implicits.*
  import cats.syntax.all.*

  private val headerfile = Opts
    .option[String](
      "header",
      help = "C header file with definitions you want bindings for"
    )
    .map(HeaderFile(_))

  private val packageName = Opts
    .option[String](
      "package",
      help = "Package name (Scala) for generated code"
    )
    .map(PackageName(_))

  private val outputFile = Opts
    .option[String](
      "out",
      help =
        "Path to file where code will be generated. If not provided, result is sent to STDOUT"
    )
    .map(OutputFile.apply(_))
    .orNone

  private val linkName = Opts
    .option[String](
      "link-name",
      help =
        "Library name for linkage (i.e. 'clang' is equivalent to -lclang flag)"
    )
    .map(LinkName.apply(_))
    .orNone

  private val multiFile = Opts
    .flag(
      "multi-file",
      help =
        "Produce binding in multiple files, which should improve compilation times if the number of types/functions is large"
    )
    .orFalse
    .map(MultiFile(_))

  private val cImport = Opts
    .options[String](
      "c-import",
      help = "List of C imports to add to generated C file " +
        "(at the very least you will need the header file for the library itself)"
    )
    .map(_.toList)
    .withDefault(Nil)
    .map(_.map(CImport.apply(_)))

  private val indentationSize = Opts
    .option[Int](
      "indentation-size",
      help = "number of spaces used for indentation (default: 2)",
      visibility = Visibility.Partial
    )
    .withDefault(2)
    .map(IndentationSize.apply(_))

  private val isScala =
    Opts.flag("scala", help = "Generate Scala part of the binding").orFalse

  private val isC =
    Opts.flag("c", help = "Generate C part of the binding").orFalse

  private val lang: Opts[Lang] = (isScala, isC).mapN { case (scala, c) =>
    if scala then Lang.Scala else Lang.C
  }

  private val printFiles =
    Opts
      .flag(
        "print-files",
        help =
          "(internal use only) Output to stdout the files written by bindgen, 1 per line",
        visibility = Visibility.Partial
      )
      .orFalse
      .map(PrintFiles(_))

  private val quiet =
    Opts
      .flag(
        "quiet",
        help =
          "Don't output the binding to STDOUT (if you are debugging, for example)"
      )
      .orFalse
      .map(Quiet.apply(_))

  private val clangFlag = Opts
    .options[String](
      "clang",
      help = "List of flags to pass directly to Clang"
    )
    .map(_.toList)
    .withDefault(Nil)
    .map(_.map(ClangFlag.apply(_)))

  private val clangInclude = Opts
    .options[String](
      "clang-include",
      help = "List of include paths passed to Clang"
    )
    .map(_.toList)
    .withDefault(Nil)
    .map(_.map(s => ClangFlag.apply(s"-I$s")))

  private val minLogPriority = List(
    "trace" -> LogLevel.trace,
    "info" -> LogLevel.info,
    "warning" -> LogLevel.warning,
    "error" -> LogLevel.error
  ).map { case (name, level) =>
    val extra = if name == "warning" then " (this is the default)" else ""
    Opts
      .flag(s"$name", help = s"Output '$name' log messages or above$extra")
      .map(_ => MinLogPriority(LogLevel.priority(level)))
      .orNone
  }.reduce(_.orElse(_))
    .map(_.getOrElse(LoggingConfig.default.minLogPriority))

  private val exclusivePrefix = Opts
    .options[String](
      "exclusive-prefix",
      help =
        "When provided, only definitions that start with this prefix will be" +
          "rendered",
      visibility = Visibility.Partial
    )
    .map(_.toList)
    .withDefault(Nil)
    .map(_.map(ExclusivePrefix.apply(_)))

  private val indentation = Opts
    .option[Int](
      "base-indentation",
      help = "Base indentation of generated Scala code (default: 0)",
      visibility = Visibility.Partial
    )
    .withDefault(0)
    .map(Indentation.apply(_))

  private val llvmBin = Opts
    .option[String](
      "llvm-bin",
      help = "Path to the LLVM installation bin/ folder\n" +
        "If provided, the clang binary from that folder will be used to\n" +
        "figure out system headers folders"
    )
    .map(LLVMBin.apply(_))
    .map(SystemPathDetection.FromLLVM.apply)

  private val clangPath = Opts
    .option[String](
      "clang-path",
      help = "Path to the Clang executable\n" +
        "If provided, the binary will be used \n" +
        "figure out system headers folders"
    )
    .map(ClangPath.apply(_))
    .map(SystemPathDetection.FromClang.apply)

  val noSystemHeaders = Opts
    .flag(
      "no-system",
      help =
        "Do NOT attempt to find clang binary and use it to figure out system headers\n" +
          "Note that this puts the responsibility of providing paths to common system headers on you\n" +
          "You can use --clang-include option for that"
    )
    .as(SystemPathDetection.No)

  private val systemPathsDetection =
    llvmBin
      .orElse(clangPath)
      .orElse(noSystemHeaders)
      .withDefault(SystemPathDetection.Auto)

  private val renderingConfig =
    val noConstructor = Opts
      .option[String](
        "render.no-constructor",
        help =
          "Comma-separated list of names (or wildcards) of structs, for which to NOT render the constructor\n" + "(apply method that takes all the parameters), useful when \n" + "you see a 'UTF8 string too large while running genBCode'\n" +
            """examples: 
            --render.no-constructor _GFileOutputStreamClass,_GFileIface
            --render.no-constructor 'nk_context,nk_style*'"""
      )
      .map(_.split(",").toSet.map(RenderingConfig.NameFilter(_)))
      .withDefault(Set.empty)

    val opaqueStruct = Opts
      .option[String](
        "render.opaque-structs",
        help =
          "Comma-separated list of names (or wildcards) of structs, which will be rendered as CArray[...], rather than precise CStruct* - \n" +
            "this can be necessary to circumvent the UTF8 string too large issue\n" +
            """examples: 
            --render.opaque-struct_GFileOutputStreamClass,_GFileIface
            --render.opaque-struct 'nk_context,nk_style*'"""
      )
      .map(_.split(",").toSet.map(RenderingConfig.NameFilter(_)))
      .withDefault(Set.empty)

    (noConstructor, opaqueStruct).mapN { case (nc, os) =>
      RenderingConfig(noConstructor = nc, opaqueStruct = os)
    }
  end renderingConfig

  val outputMode: Opts[OutputMode] =
    (outputFile, multiFile).tupled.mapValidated {
      case (None, MultiFile.Yes) =>
        "In multi-file mode, --out parameter is required, and it has to point to an existing folder".invalidNel
      case (None, MultiFile.No) =>
        OutputMode.StdOut.validNel
      case (Some(f), MultiFile.No) =>
        OutputMode.SingleFile(f).validNel

      case (Some(f), MultiFile.Yes) =>
        if f.value.isDirectory then
          OutputMode.MultiFile(OutputDirectory(f.value)).validNel
        else
          "In multi-file mode, the --out parameter must be an existing directory".invalidNel

    }

  val command = Command(
    name = s"bindgen",
    header = "Generate Scala 3 native bindings from C header files" +
      s"\nVersion: ${BuildInfo.version}\nBuilt using Scala ${BuildInfo.scalaVersion} and Scala Native ${BuildInfo.nativeVersion}"
  ) {
    (
      packageName,
      headerfile,
      linkName,
      indentationSize,
      indentation,
      lang,
      cImport,
      (clangInclude, clangFlag).mapN(_ ++ _),
      quiet,
      minLogPriority,
      exclusivePrefix,
      systemPathsDetection,
      renderingConfig,
      outputMode,
      printFiles
    ).mapN(Config.apply)
  }
end CLI
