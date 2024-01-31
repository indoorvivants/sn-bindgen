package bindgen

import java.io.FileWriter
import java.nio.file.Files
import scala.collection.mutable
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import scala.scalanative.runtime.libc
import libclang.fluent.string
import java.nio.file.Path
import java.nio.file.Paths

class SystemHeaderDetector(
    clangInfo: ClangInfo,
    excludeSystemPaths: List[SystemPath]
):
  private val mut = collection.mutable.Map.empty[String, Boolean]
  private val includes = clangInfo.includePaths.map(Paths.get(_))
  private val excludes = excludeSystemPaths.map(_.value).map(Paths.get(_))

  def isSystem(filename: String): Boolean =
    val path = java.nio.file.Paths.get(filename)

    def isChild(ip: Path) = path.startsWith(ip)

    val isInExcludedLocation = excludes.exists(isChild)
    val isInSystemLocation = includes.exists(isChild)

    mut.getOrElseUpdate(
      filename,
      if isInExcludedLocation then false else isInSystemLocation
    )
  end isSystem
end SystemHeaderDetector
