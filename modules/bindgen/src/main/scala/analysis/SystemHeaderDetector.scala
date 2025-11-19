package bindgen

import java.nio.file.{Path, Paths}

class SystemHeaderDetector(
    clangInfo: ClangInfo,
    excludeSystemPaths: List[SystemPath]
):
  private val mut = collection.mutable.Map.empty[String, Boolean]
  private val includes = clangInfo.includePaths.map(Paths.get(_))
  private val excludes = excludeSystemPaths.map(_.value).map(Paths.get(_))

  println(clangInfo)
  println(excludeSystemPaths)

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
