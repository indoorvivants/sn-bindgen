package bindgen

import _root_.libclang.structs.*
import _root_.libclang.enumerations.*
import _root_.libclang.aliases.*
import _root_.libclang.functions.*
import _root_.libclang.fluent.*
import java.io.FileWriter
import java.nio.file.Files
import scala.collection.mutable
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import scala.scalanative.runtime.libc
import libclang.fluent.string

class SystemHeaderDetector(clangInfo: ClangInfo):
  private val mut = collection.mutable.Map.empty[String, Boolean]

  def isSystem(filename: String): Boolean =
    val path = java.nio.file.Paths.get(filename)
    mut.getOrElseUpdate(
      filename,
      clangInfo.includePaths.exists { ip =>
        path.startsWith(ip)
      }
    )
end SystemHeaderDetector
