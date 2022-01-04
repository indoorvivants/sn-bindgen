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
    minLogPriority: MinLogPriority = MinLogPriority(3)
)

opaque type Quiet = Boolean
object Quiet extends YesNo[Quiet]

enum Lang:
  case Scala, C

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

opaque type IndentationSize = Int
object IndentationSize extends bindgen.OpaqueNum[IndentationSize]

opaque type Indentation = Int
object Indentation extends bindgen.OpaqueNum[Indentation]

opaque type MinLogPriority = Int
object MinLogPriority extends bindgen.OpaqueNum[MinLogPriority]

trait BasicallyTheSame[A, T]:
  def apply(a: A): T

abstract class TotalWrapper[A, T](using ev: A =:= T):
  def raw(a: A): T = ev.apply(a)
  def apply(s: T): A = ev.flip.apply(s)
  given BasicallyTheSame[A, T] = ev.apply(_)
  given BasicallyTheSame[T, A] = ev.flip.apply(_)

  extension (a: A)
    inline def value = raw(a)
    inline def into[A1](inline other: TotalWrapper[A1, T]): A1 = other(a.value)
    inline def map(inline f: T => T): A = apply(f(raw(a)))
end TotalWrapper

abstract class OpaqueString[A](using A =:= String)
    extends bindgen.TotalWrapper[A, String]

abstract class OpaqueNum[A](using A =:= Int)
    extends bindgen.TotalWrapper[A, Int]

abstract class YesNo[A](using ev: Boolean =:= A):
  val Yes: A = ev.apply(true)
  val No: A = ev.apply(false)
  given BasicallyTheSame[A, Boolean] = _ == Yes
  given BasicallyTheSame[Boolean, A] = if _ then Yes else No

  inline def apply(inline b: Boolean): A = ev.apply(b)

  extension (inline a: A) inline def value: Boolean = a == Yes
end YesNo
