package bindgen

import bindgen.rendering.*

import java.io.File
import java.io.FileWriter
import scala.collection.mutable
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import scalanative.libc.*
import scala.util.Using.apply
import scala.util.Using

inline def zone[A](inline f: Zone ?=> A) = Zone.apply(z => f(using z))

object Generate:
  def main(args: Array[String]): Unit =
    zone {
      CLI.command.parse(args) match
        case Left(help) =>
          val (modified, code) =
            if help.errors.nonEmpty then help.copy(body = Nil) -> -1
            else help -> 0
          System.err.println(modified)
          sys.exit(code)
        case Right(config) =>
          validateConfig(config) match
            case None =>
              given Config = config
              val result =
                binding(
                  analyse(config.headerFile.value),
                  config.lang,
                  config.outputMode
                )

              (result, config.outputMode) match
                case (RenderedOutput.Single(lb), OutputMode.StdOut) =>
                  config.outputChannel.stdoutLine(lb.result)

                case (RenderedOutput.Single(lb), OutputMode.SingleFile(f)) =>
                  Using.resource(new FileWriter(f.value)) { fw =>
                    fw.write(lb.result)
                  }
                  info(s"Generated ${f.value.toPath.toAbsolutePath()}")

                  if config.printFiles == PrintFiles.Yes then
                    config.outputChannel.stdoutLine(
                      f.value.toPath.toAbsolutePath().toString()
                    )

                case (RenderedOutput.Multi(mp), OutputMode.MultiFile(d)) =>
                  val path = d.value.toPath()
                  mp.foreach { (sn, lb) =>
                    val file = path.resolve(sn.value + ".scala")
                    Using.resource(new FileWriter(file.toFile)) { fw =>
                      fw.write(lb.result)
                    }
                    info(s"Generated ${file.toAbsolutePath()}")
                    if config.printFiles == PrintFiles.Yes then
                      config.outputChannel.stdoutLine(
                        file.toAbsolutePath()
                      )

                  }
              end match

            case Some(msg) =>
              config.outputChannel.stderr(msg + "\n")
              sys.exit(1)
    }

end Generate
