package bindgen

import opaque_newtypes.*

import java.io.File
import scala.util.chaining.*

enum OutputMode:
  case StdOut
  case SingleFile(out: OutputFile)
  case MultiFile(out: OutputDirectory)

enum Flavour(val tag: String):
  case ScalaNative04 extends Flavour("scala-native04")
  case ScalaNative05 extends Flavour("scala-native05")

object Flavour:
  def fromString(raw: String) =
    if raw == ScalaNative04.tag then Some(ScalaNative04)
    else if raw == ScalaNative05.tag then Some(ScalaNative05)
    else None

  val all = values.toList

case class Config(
    linkName: Option[LinkName],
    indentSize: IndentationSize,
    indents: Indentation,
    bracesNotIndents: Braces,
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
    outputChannel: OutputChannel,
    tempDir: TempPath,
    excludeSystemPaths: List[SystemPath],
    flavour: Flavour
)

case class Context(
    packageName: PackageName,
    headerFile: HeaderFile,
    lang: Lang
)

object Config:
  inline def is[A](inline f: Config => A)(using conf: Config) =
    f(conf)
  def withDefaults() =
    Config(
      linkName = None,
      indentSize = defaults.indentSize,
      indents = defaults.indents,
      bracesNotIndents = Braces.No,
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
      outputChannel = OutputChannel.cli,
      tempDir = TempPath(sys.props("java.io.tmpdir")),
      excludeSystemPaths = Nil,
      flavour = Flavour.ScalaNative04
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

opaque type Braces = Boolean
object Braces extends YesNo[Braces]

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

opaque type SystemPath = String
object SystemPath extends OpaqueString[SystemPath]

opaque type HeaderFile = String
object HeaderFile extends OpaqueString[HeaderFile]

opaque type OutputFile = File
object OutputFile extends OpaqueFile[OutputFile]

opaque type TempPath = File
object TempPath extends OpaqueFile[TempPath]

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
