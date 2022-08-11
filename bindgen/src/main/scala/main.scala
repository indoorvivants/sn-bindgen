package bindgen

import bindgen.rendering.*
import libclang.defs.*
import libclang.enumerations.*
import libclang.types.*

import java.io.File
import java.io.FileWriter
import scala.collection.mutable
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import scalanative.libc.*
import scala.util.Using.apply
import scala.util.Using

inline def errln(inline a: Any) = System.err.println(a)

inline def zone[A](inline f: Zone ?=> A) = Zone.apply(z => f(using z))

object Generate:
  def main(args: Array[String]): Unit =
    zone {
      CLI.command.parse(args) match
        case Left(help) =>
          System.err.println(help)
          sys.exit(1)
        case Right(config) =>
          validateConfig(config) match
            case None =>
              given Config = config
              val b = analyse(config.headerFile.value)

              val scalaOutput = LineBuilder()
              val cOutput = LineBuilder()

              binding(b, scalaOutput, cOutput)

              if config.quiet == Quiet.No then
                config.lang match
                  case Lang.Scala =>
                    writeTo(config.outputFile, scalaOutput)
                  case Lang.C => writeTo(config.outputFile, cOutput)
            case Some(msg) =>
              error(msg)(using LoggingConfig.default)
              sys.exit(1)
    }

  private def writeTo(out: Option[OutputFile], lb: LineBuilder) =
    out match
      case None => print(lb.result)
      case Some(out) =>
        val f = new File(out.value)
        Using.resource(new FileWriter(f)) { fw =>
          fw.write(lb.result)
        }

end Generate
