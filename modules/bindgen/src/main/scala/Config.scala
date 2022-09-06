package bindgen

case class Config(
    packageName: PackageName,
    headerFile: HeaderFile,
    linkName: Option[LinkName],
    indentSize: IndentationSize,
    indents: Indentation = Indentation(0),
    lang: Lang,
    cImports: List[CImport],
    clangFlags: List[ClangFlag] = Nil,
    quiet: Quiet = Quiet.No,
    minLogPriority: MinLogPriority = MinLogPriority(3),
    exclusivePrefix: List[ExclusivePrefix] = Nil,
    outputFile: Option[OutputFile],
    systemPathDetection: SystemPathDetection
)

enum SystemPathDetection:
  case FromLLVM(bin: LLVMBin)
  case FromClang(clang: ClangPath)
  case Auto, No

opaque type Quiet = Boolean
object Quiet extends YesNo[Quiet]

enum Lang:
  case Scala, C

opaque type ExclusivePrefix = String
object ExclusivePrefix extends bindgen.OpaqueString[ExclusivePrefix]

opaque type PackageName = String
object PackageName extends bindgen.OpaqueString[PackageName]

opaque type LinkName = String
object LinkName extends bindgen.OpaqueString[LinkName]

opaque type CImport = String
object CImport extends bindgen.OpaqueString[CImport]

opaque type ClangFlag = String
object ClangFlag extends bindgen.OpaqueString[ClangFlag]

opaque type HeaderFile = String
object HeaderFile extends bindgen.OpaqueString[HeaderFile]

opaque type OutputFile = String
object OutputFile extends bindgen.OpaqueString[OutputFile]

opaque type IndentationSize = Int
object IndentationSize extends bindgen.OpaqueNum[IndentationSize]

opaque type Indentation = Int
object Indentation extends bindgen.OpaqueNum[Indentation]

opaque type MinLogPriority = Int
object MinLogPriority extends bindgen.OpaqueNum[MinLogPriority]

opaque type LLVMBin = String
object LLVMBin extends bindgen.OpaqueString[LLVMBin]

opaque type ClangPath = String
object ClangPath extends bindgen.OpaqueString[ClangPath]
