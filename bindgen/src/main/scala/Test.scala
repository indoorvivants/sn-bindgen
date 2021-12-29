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

inline def zone[A](inline f: Zone ?=> A) = Zone.apply(z => f(using z))

@main def out(packageName: String, file: String) =
  zone {
    val binding = analyse(file)
    val sb = StringBuilder()
    render.binding(packageName, binding, sb)(using Config(indentSize = 2))
    println(sb.result)
  }

// @main def out(packageName: String, file: String, targetFile: String) =
//   zone {
//     val binding = analyse(file)
//     val sb = StringBuilder()
//     render.binding(packageName, binding, sb)(using Config(indentSize = 2))
//     val fw =
//       new FileWriter(new File(s"bindgen/src/test/scala/$targetFile.scala"))
//     sb.result.linesWithSeparators.foreach { line =>
//       fw.write(line)
//     }
//   }
