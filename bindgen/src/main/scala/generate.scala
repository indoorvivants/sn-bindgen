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

@main def generate(
    packageName: String,
    cImports: String,
    linkName: String,
    file: String,
    lang: String
) =
  zone {
    val language = if (lang.toLowerCase == "scala") then Lang.Scala else Lang.C
    given Config = Config(
      indentSize = IndentationSize(2),
      packageName = PackageName(packageName),
      linkName = Some(LinkName(linkName)),
      lang = language,
      cImports = cImports.split(",").toList.map(CImport.apply)
    )
    val b = analyse(file)

    val scalaOutput = StringBuilder()
    val cOutput = StringBuilder()

    binding(b, scalaOutput, cOutput)

    language match
      case Lang.Scala => println(scalaOutput.result)
      case Lang.C     => println(cOutput.result)
  }
