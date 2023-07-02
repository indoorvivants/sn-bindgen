package bindgen

import opaque_newtypes.*
import java.io.File
import scala.util.matching.Regex
import scala.util.chaining.*

enum SystemPathDetection:
  case FromLLVM(bin: LLVMBin)
  case FromClang(clang: ClangPath)
  case Auto, No

