package bindgen

trait OutputChannel:
  def log[A](
      lc: LoggingConfig,
      level: LogLevel,
      msg: A,
      context: Seq[(String, Any)] = Seq.empty
  ): Unit

  def stdout[A](msg: A): Unit
  def stderr[A](msg: A): Unit
  def stdoutLine[A](msg: A): Unit = stdout(msg.toString() + "\n")
  def stderrLine[A](msg: A): Unit = stderr(msg.toString() + "\n")
end OutputChannel

object OutputChannel:
  def cli = new OutputChannel:
    override inline def log[A](
        lc: LoggingConfig,
        level: LogLevel,
        msg: A,
        context: Seq[(String, Any)]
    ): Unit = consoleLogger(level, msg, context, lc, stderr(_))

    override inline def stdout[A](msg: A): Unit =
      print(msg)

    override inline def stderr[A](msg: A): Unit =
      System.err.print(msg)
end OutputChannel
