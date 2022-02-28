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
    exclusivePrefix: List[ExclusivePrefix] = Nil
)

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

opaque type IndentationSize = Int
object IndentationSize extends bindgen.OpaqueNum[IndentationSize]

opaque type Indentation = Int
object Indentation extends bindgen.OpaqueNum[Indentation]

opaque type MinLogPriority = Int
object MinLogPriority extends bindgen.OpaqueNum[MinLogPriority]

trait BasicallyTheSame[A, T]:
  def apply(a: A): T

trait TotalWrapper[Newtype, Impl](using ev: Newtype =:= Impl):
  def raw(a: Newtype): Impl = ev.apply(a)
  def apply(s: Impl): Newtype = ev.flip.apply(s)
  given BasicallyTheSame[Newtype, Impl] = ev.apply(_)
  given BasicallyTheSame[Impl, Newtype] = ev.flip.apply(_)

  extension (a: Newtype)
    inline def value = raw(a)
    inline def into[X](inline other: TotalWrapper[X, Impl]): X =
      other.apply(raw(a))
    inline def map(inline f: Impl => Impl): Newtype = apply(f(raw(a)))
end TotalWrapper

inline given [A, T](using
    bts: BasicallyTheSame[T, A],
    ord: Ordering[A]
): Ordering[T] =
  Ordering.by(bts.apply)

trait OpaqueString[A](using A =:= String)
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
