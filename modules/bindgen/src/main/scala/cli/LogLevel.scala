package bindgen

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
