package bindgen

case class LoggingConfig(minLogPriority: MinLogPriority)

object LoggingConfig:
  val default = LoggingConfig(
    DefaultPriority
  )

  inline def DefaultPriority = MinLogPriority(
    LogLevel.priority(LogLevel.warning)
  )

  given inferLoggingConfig(using c: Config): LoggingConfig =
    LoggingConfig(c.minLogPriority)
end LoggingConfig
