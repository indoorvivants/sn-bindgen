package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*
import libclang.enumerations.*
import scala.collection.mutable
import java.io.FileWriter
import java.io.File
import bindgen.rendering.*

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
          given Config = config
          val b = analyse(config.headerFile.value)

          val scalaOutput = StringBuilder()
          val cOutput = StringBuilder()

          binding(b, scalaOutput, cOutput)

          if config.quiet == Quiet.No then
            config.lang match
              case Lang.Scala => println(scalaOutput.result)
              case Lang.C     => println(cOutput.result)
    }
end Generate
