package bindgen

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
