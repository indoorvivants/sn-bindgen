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
                  case Lang.Scala => println(scalaOutput.result)
                  case Lang.C     => println(cOutput.result)
            case Some(msg) =>
              error(msg)(using LoggingConfig.default)
              sys.exit(1)
    }
end Generate
