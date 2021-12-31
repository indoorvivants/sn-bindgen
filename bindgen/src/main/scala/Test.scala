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

@main def out(
    packageName: String,
    linkName: String,
    file: String,
    lang: String
) =
  zone {
    val b = analyse(file)
    val language = if (lang.toLowerCase == "scala") then Lang.Scala else Lang.C

    val scalaOutput = StringBuilder()
    val cOutput = StringBuilder()

    given Config = Config(
      indentSize = 2,
      packageName = packageName,
      linkName = Some(linkName),
      lang = language
    )
    binding(b, scalaOutput, cOutput)

    errln(language)
    language match
      case Lang.Scala => println(scalaOutput.result)
      case Lang.C     => println(cOutput.result)
  }
