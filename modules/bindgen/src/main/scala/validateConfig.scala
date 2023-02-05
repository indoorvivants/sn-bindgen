package bindgen

import java.io.File

private def fileExists(file: File) =
  if file.exists && file.isFile then None
  else if file.isDirectory then
    Option(s"'$file' is a directory, but should be a file")
  else Option(s"'$file' doesn't exist!")

private def noLinkNameInMultiFileMode(config: Option[LinkName]) = None

def validateConfig(config: Config): Option[String] =
  fileExists(new File(config.headerFile.value)) orElse
    noLinkNameInMultiFileMode(config.linkName)
