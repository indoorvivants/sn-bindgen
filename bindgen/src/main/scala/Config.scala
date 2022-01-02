package bindgen

case class Config(
    packageName: PackageName,
    linkName: Option[LinkName],
    indentSize: IndentationSize,
    indents: Indentation = Indentation(0),
    lang: Lang,
    cImports: List[CImport]
)

enum Lang:
  case Scala, C

opaque type PackageName = String
object PackageName extends bindgen.OpaqueString[PackageName]

opaque type LinkName = String
object LinkName extends bindgen.OpaqueString[LinkName]

opaque type CImport = String
object CImport extends bindgen.OpaqueString[CImport]

opaque type IndentationSize = Int
object IndentationSize extends bindgen.OpaqueNum[IndentationSize]

opaque type Indentation = Int
object Indentation extends bindgen.OpaqueNum[Indentation]

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
