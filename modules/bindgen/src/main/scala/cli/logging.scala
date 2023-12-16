package bindgen

val trace = new LogBuilder(LogLevel.trace)
val info = new LogBuilder(LogLevel.info)
val warning = new LogBuilder(LogLevel.warning)
val error = new LogBuilder(LogLevel.error)

class LogBuilder(level: LogLevel):
  def apply(msg: Any)(using config: Config) =
    config.outputChannel.log(
      LoggingConfig.inferLoggingConfig,
      level,
      msg
    )

  def apply(msg: Any, context: Seq[(String, Any)])(using config: Config) =
    config.outputChannel.log(
      LoggingConfig.inferLoggingConfig,
      level,
      msg,
      context
    )

  @scala.annotation.targetName("apply_strings")
  def apply(msg: Any, context: Seq[Any])(using config: Config) =
    config.outputChannel.log(
      LoggingConfig.inferLoggingConfig,
      level,
      msg,
      context.map("" -> _.toString)
    )

end LogBuilder

inline def consoleLogger[A](
    level: LogLevel,
    msg: A,
    context: Seq[(String, Any)] = Seq.empty,
    lc: LoggingConfig,
    stderr: String => Unit
): Unit =
  import scala.compiletime.erasedValue
  if LogLevel.priority(level) >= lc.minLogPriority.value then
    stderr(
      Console.BOLD + "[bindgen] " + Console.RESET +
        LogLevel
          .color(level) + s"${LogLevel.name(level)} " + Console.RESET + msg.toString + "\n"
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
              stderr(
                "    " + offset + Console.BOLD + field + Console.RESET + "  " + valueLine + "\n"
              )
            else stderr("    " + offset + filler + "  " + valueLine)
          }
          .toVector
      }
    end if
  end if
end consoleLogger
