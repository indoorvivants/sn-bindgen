package bindgen

import bindgen.rendering.*

import java.io.{File, FileWriter}
import scala.scalanative.unsafe.*
import scala.util.Using

object Generate:
  def main(args: Array[String]): Unit =
    val arguments = args.takeWhile(_ != "--")
    val rest = args.drop(arguments.length + 1)
    Zone:
      CLI.command.parse(arguments, sys.env) match
        case Left(help) =>
          val (modified, code) =
            if help.errors.nonEmpty then help.copy(body = Nil) -> -1
            else help -> 0
          System.err.println(modified)
          sys.exit(code)
        case Right(suspendedConfig) =>
          val config = suspendedConfig.build(rest)
          validateConfig(config) match
            case None =>
              given Config = config.config
              val driver = InteractiveDriver.init.fold(handleError, identity)
              val result =
                driver
                  .createBinding(
                    config.context,
                    config.config.outputMode
                  )
                  .fold(handleError, identity)

              (result, config.config.outputMode) match
                case (RenderedOutput.Single(lb), OutputMode.StdOut) =>
                  config.config.outputChannel.stdoutLine(lb.result)

                case (RenderedOutput.Single(lb), OutputMode.SingleFile(f)) =>
                  val result = lb.result.trim()
                  if result.nonEmpty then
                    Using.resource(new FileWriter(f.value)) { fw =>
                      fw.write(result)
                    }
                    info(s"Generated ${f.value.toPath.toAbsolutePath()}")

                    if config.config.printFiles == PrintFiles.Yes then
                      config.config.outputChannel.stdoutLine(
                        f.value.toPath.toAbsolutePath().toString()
                      )
                  end if

                case (RenderedOutput.Multi(mp), OutputMode.MultiFile(d)) =>
                  val path = d.value.toPath()
                  mp.foreach { (sn, lb) =>
                    val result = lb.result.trim()
                    if result.nonEmpty then
                      val file = path.resolve(sn.value + ".scala")
                      Using.resource(new FileWriter(file.toFile)) { fw =>
                        fw.write(result)
                      }
                      info(s"Generated ${file.toAbsolutePath()}")
                      if config.config.printFiles == PrintFiles.Yes then
                        config.config.outputChannel.stdoutLine(
                          file.toAbsolutePath()
                        )
                    end if

                  }
              end match

            case Some(msg) =>
              config.config.outputChannel.stderr(msg + "\n")
              sys.exit(1)
          end match
  end main

  private def outputDiagnostic(diag: ClangDiagnostic)(using Config, Zone) =
    import ClangSeverity.*
    diag.severity match
      case Error | Fatal  => error(diag.message())
      case Warning        => warning(diag.message())
      case Ignored | Note => info(diag.message())

  private def handleError(b: BindingError)(using config: Config)(using Zone) =
    config.outputChannel.stderrLine(b.render)
    b match
      case BindingError.ClangErrors(errs) =>
        errs.foreach: diag =>
          outputDiagnostic(diag)

      case _ =>
    sys.exit(1)
  end handleError

end Generate
