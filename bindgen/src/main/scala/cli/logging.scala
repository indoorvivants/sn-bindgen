package bindgen

case class LoggingConfig(minLogPriority: MinLogPriority)
object LoggingConfig:
  val default = LoggingConfig(MinLogPriority(LogLevel.priority(LogLevel.info)))
  given infer(using c: Config): LoggingConfig = LoggingConfig(c.minLogPriority)

inline def trace[A](inline msg: A)(using LoggingConfig): Unit =
  log(LogLevel.trace, msg)

inline def trace[A](inline msg: A, context: (String, Any)*)(using
    LoggingConfig
): Unit =
  log(LogLevel.trace, msg, context)

inline def info(inline msg: Any)(using LoggingConfig) =
  log(LogLevel.info, msg)

inline def warning(inline msg: Any)(using LoggingConfig) =
  log(LogLevel.warning, msg)

inline def error(msg: Any)(using LoggingConfig) =
  log(LogLevel.error, msg)

private inline def log[A](
    level: LogLevel,
    inline msg: A,
    context: Seq[(String, Any)] = Seq.empty
)(using
    lc: LoggingConfig
): Unit =
  import scala.compiletime.erasedValue
  if LogLevel.priority(level) >= lc.minLogPriority.value then
    errln(
      Console.BOLD + "[bindgen] " + Console.RESET +
        LogLevel
          .color(level) + s"${LogLevel.name(level)} " + Console.RESET + msg.toString
    )
    if context.nonEmpty then
      val fMaxLength = context.map(_._1).maxBy(_.length).length
      context.foreach { case (field, value) =>
        val offset = " " * (fMaxLength - field.length)
        errln("    " + offset + field + "  " + value)
      }
  end if
end log

enum LogLevel:
  case trace, info, warning, error

object LogLevel:
  import LogLevel as lev
  inline def priority(inline m: LogLevel): Int = m match
    case lev.trace   => 0
    case lev.info    => 1
    case lev.warning => 2
    case lev.error   => 3

  inline def color(inline m: LogLevel): String = m match
    case LogLevel.info    => Console.GREEN
    case LogLevel.trace   => Console.CYAN
    case LogLevel.warning => Console.YELLOW
    case LogLevel.error   => Console.RED

  inline def name(inline m: LogLevel): String = m match
    case LogLevel.info    => "info"
    case LogLevel.trace   => "trace"
    case LogLevel.warning => "warn"
    case LogLevel.error   => "error"

  val maxPriority = priority(LogLevel.trace)
end LogLevel
