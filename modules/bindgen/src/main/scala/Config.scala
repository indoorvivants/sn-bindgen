package bindgen

import opaque_newtypes.*
import java.io.File
import scala.util.matching.Regex
import scala.util.chaining.*

enum OutputMode:
  case StdOut
  case SingleFile(out: OutputFile)
  case MultiFile(out: OutputDirectory)

case class Config(
    packageName: PackageName,
    headerFile: HeaderFile,
    linkName: Option[LinkName],
    indentSize: IndentationSize,
    indents: Indentation,
    lang: Lang,
    cImports: List[CImport],
    clangFlags: List[ClangFlag],
    quiet: Quiet,
    minLogPriority: MinLogPriority,
    exclusivePrefix: List[ExclusivePrefix] = Nil,
    systemPathDetection: SystemPathDetection,
    rendering: RenderingConfig,
    outputMode: OutputMode,
    printFiles: PrintFiles
)

enum SystemPathDetection:
  case FromLLVM(bin: LLVMBin)
  case FromClang(clang: ClangPath)
  case Auto, No

opaque type PrintFiles = Boolean
object PrintFiles extends YesNo[PrintFiles]

opaque type Quiet = Boolean
object Quiet extends YesNo[Quiet]

opaque type MultiFile = Boolean
object MultiFile extends YesNo[MultiFile]

enum Lang:
  case Scala, C

opaque type ExclusivePrefix = String
object ExclusivePrefix extends OpaqueString[ExclusivePrefix]

opaque type PackageName = String
object PackageName extends OpaqueString[PackageName]

opaque type LinkName = String
object LinkName extends OpaqueString[LinkName]

opaque type CImport = String
object CImport extends OpaqueString[CImport]

opaque type ClangFlag = String
object ClangFlag extends OpaqueString[ClangFlag]

opaque type HeaderFile = String
object HeaderFile extends OpaqueString[HeaderFile]

opaque type OutputFile = File
object OutputFile extends OpaqueFile[OutputFile]

opaque type OutputDirectory = File
object OutputDirectory extends OpaqueFile[OutputDirectory]

opaque type IndentationSize = Int
object IndentationSize extends OpaqueInt[IndentationSize]

opaque type Indentation = Int
object Indentation extends OpaqueInt[Indentation]

opaque type MinLogPriority = Int
object MinLogPriority extends OpaqueInt[MinLogPriority]

opaque type LLVMBin = String
object LLVMBin extends OpaqueString[LLVMBin]

opaque type ClangPath = String
object ClangPath extends OpaqueString[ClangPath]

trait OpaqueFile[A] extends TotalWrapper[A, File]:
  inline def apply(s: String): A = apply(new File(s))
