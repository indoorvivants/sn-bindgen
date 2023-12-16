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
    printFiles: PrintFiles,
    exportMode: ExportMode,
    outputChannel: OutputChannel
)

object Config:
  def withDefaults(
      headerFile: HeaderFile,
      packageName: PackageName,
      lang: Lang,
      outputChannel: OutputChannel
  ) =
    Config(
      packageName = packageName,
      headerFile = headerFile,
      linkName = None,
      indentSize = defaults.indentSize,
      indents = defaults.indents,
      lang = lang,
      cImports = Nil,
      clangFlags = Nil,
      quiet = Quiet.No,
      minLogPriority = MinLogPriority(LogLevel.priority(LogLevel.warning)),
      exclusivePrefix = Nil,
      systemPathDetection = SystemPathDetection.Auto,
      rendering = RenderingConfig.withDefaults,
      outputMode = OutputMode.StdOut,
      printFiles = PrintFiles.No,
      exportMode = ExportMode.No,
      outputChannel = outputChannel
    )
  object defaults:
    val indentSize = IndentationSize(3)
    val indents = Indentation(0)
end Config

enum SystemPathDetection:
  case FromLLVM(bin: LLVMBin)
  case FromClang(clang: ClangPath)
  case Auto, No

opaque type ExportMode = Boolean
object ExportMode extends YesNo[ExportMode]

opaque type PrintFiles = Boolean
object PrintFiles extends YesNo[PrintFiles]

opaque type RenderComments = Boolean
object RenderComments extends YesNo[RenderComments]

opaque type RenderLocation = Boolean
object RenderLocation extends YesNo[RenderLocation]

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
