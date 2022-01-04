package bindgen

import com.monovore.decline.Opts

object CLI:
  import com.monovore.decline.*
  import cats.implicits.*
  import cats.syntax.all.*

  private val headerfile = Opts
    .option[String](
      "header",
      help = "C header file with definitions you want bindings for"
    )
    .map(HeaderFile.apply)

  private val packageName = Opts
    .option[String](
      "package",
      help = "Package name (Scala) for generated code"
    )
    .map(PackageName.apply)

  private val linkName = Opts
    .option[String](
      "link-name",
      help =
        "Library name for linkage (i.e. 'clang' is equivalent to -lclang flag)"
    )
    .map(LinkName.apply)
    .orNone

  private val cImport = Opts
    .options[String](
      "c-import",
      help = "List of C imports to add to generated C file " +
        "(at the very least you will need the header file for the library itself)"
    )
    .map(_.toList)
    .withDefault(Nil)
    .map(_.map(CImport.apply))

  private val indentationSize = Opts
    .option[Int](
      "indentation-size",
      help = "number of spaces used for indentation (default: 2)"
    )
    .withDefault(2)
    .map(IndentationSize.apply)

  private val isScala =
    Opts.flag("scala", help = "Generate Scala part of the binding").orFalse
  private val isC =
    Opts.flag("c", help = "Generate C part of the binding").orFalse

  private val lang: Opts[Lang] = (isScala, isC).mapN { case (scala, c) =>
    if scala then Lang.Scala else Lang.C
  }

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
    .map(_.map(ClangFlag.apply))

  private val minLogPriority = List(
    "trace" -> LogLevel.trace,
    "info" -> LogLevel.info,
    "warning" -> LogLevel.warning,
    "error" -> LogLevel.error
  ).map { case (name, level) =>
    val extra = if name == "warning" then " (this is the default)" else ""
    Opts
      .flag(s"$name", help = s"Output '$name' log messages or above$extra")
      .map(_ => LogLevel.priority(level))
      .orNone
  }.reduce(_.orElse(_))
    .map(_.getOrElse(LogLevel.priority(LogLevel.warning)))
    .map(MinLogPriority.apply)

  private val indentation = Opts
    .option[Int](
      "base-indentation",
      help = "Base indentation of generated Scala code (default: 0)",
      visibility = Visibility.Partial
    )
    .withDefault(0)
    .map(Indentation.apply)

  val command = Command(
    name = "bindgen",
    header = "Generate Scala 3 native bindings from C header files"
  ) {
    (
      packageName,
      headerfile,
      linkName,
      indentationSize,
      indentation,
      lang,
      cImport,
      clangFlag,
      quiet,
      minLogPriority
    ).mapN(Config.apply)
  }
end CLI

// def trace(msg: Any)(using Config) =
//   log(LogLevel.trace, msg)

// def info(msg: Any)(using Config) =
//   log(LogLevel.info, msg)

// def warning(msg: Any)(using Config) =
//   log(LogLevel.warning, msg)

// def error(msg: Any)(using Config) =
//   log(LogLevel.error, msg)

// private def log(level: LogLevel, msg: Any)(using Config) =
//   if LogLevel.priority(level) >= summon[Config].minLogPriority.value then
//     errln(
//       Console.BOLD + "[bindgen] " + Console.RESET +
//         LogLevel
//           .color(level) + s"${LogLevel.name(level)} " + Console.RESET + msg.toString
//     )

// enum LogLevel:
//   case trace, info, warning, error

// object LogLevel:
//   import LogLevel as lev
//   inline def priority(inline m: LogLevel): Int = m match
//     case lev.trace   => 0
//     case lev.info    => 1
//     case lev.warning => 2
//     case lev.error   => 3

//   inline def color(inline m: LogLevel): String = m match
//     case LogLevel.info    => Console.GREEN
//     case LogLevel.trace   => Console.BLUE
//     case LogLevel.warning => Console.YELLOW
//     case LogLevel.error   => Console.RED

//   inline def name(inline m: LogLevel): String = m match
//     case LogLevel.info    => "info"
//     case LogLevel.trace   => "trace"
//     case LogLevel.warning => "warn"
//     case LogLevel.error   => "error"

//   val maxPriority = priority(LogLevel.trace)
// end LogLevel


