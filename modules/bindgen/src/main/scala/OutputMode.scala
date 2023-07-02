package bindgen

import opaque_newtypes.*
import java.io.File
import scala.util.matching.Regex
import scala.util.chaining.*

enum OutputMode:
  case StdOut
  case SingleFile(out: OutputFile)
  case MultiFile(out: OutputDirectory)
