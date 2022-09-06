package bindgen

case class LoggingConfig(minLogPriority: MinLogPriority)
object LoggingConfig:
  val default = LoggingConfig(MinLogPriority(LogLevel.priority(LogLevel.info)))
  given infer(using c: Config): LoggingConfig = LoggingConfig(c.minLogPriority)

val trace = new LogBuilder(LogLevel.trace)
val info = new LogBuilder(LogLevel.info)
val warning = new LogBuilder(LogLevel.warning)
val error = new LogBuilder(LogLevel.error)

class LogBuilder(level: LogLevel):
  def apply(msg: Any)(using LoggingConfig) =
    log(level, msg)

  def apply(msg: Any, context: Seq[(String, Any)])(using LoggingConfig) =
    log(level, msg, context)

  @scala.annotation.targetName("apply_strings")
  def apply(msg: Any, context: Seq[Any])(using LoggingConfig) =
    log(level, msg, context.map("" -> _.toString))
end LogBuilder

private inline def log[A](
    level: LogLevel,
    msg: A,
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
        val filler = " " * fMaxLength
        value.toString
          .grouped(15000)
          .zipWithIndex
          .map { case (valueLine, idx) =>
            if idx == 0 then
              errln(
                "    " + offset + Console.BOLD + field + Console.RESET + "  " + valueLine
              )
            else errln("    " + offset + filler + "  " + valueLine)
          }
          .toVector
      }
    end if
  end if
end log

enum LogLevel:
  case trace, info, warning, error

object LogLevel:
  import LogLevel as lev
  def priority(m: LogLevel): Int = m match
    case lev.trace   => 0
    case lev.info    => 1
    case lev.warning => 2
    case lev.error   => 3

  def color(m: LogLevel): String = m match
    case LogLevel.info    => Console.GREEN
    case LogLevel.trace   => Console.CYAN
    case LogLevel.warning => Console.YELLOW
    case LogLevel.error   => Console.RED

  def name(m: LogLevel): String = m match
    case LogLevel.info    => "info"
    case LogLevel.trace   => "trace"
    case LogLevel.warning => "warn"
    case LogLevel.error   => "error"

  val maxPriority = priority(LogLevel.trace)
end LogLevel
