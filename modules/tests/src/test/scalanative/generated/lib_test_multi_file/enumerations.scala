package lib_test_multi_file

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

private[lib_test_multi_file] trait _BindgenEnumCUnsignedInt[T](using eq: T =:= CUnsignedInt):
  given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
  extension (inline t: T)
    inline def value: CUnsignedInt = eq.apply(t)
    inline def int: CInt = eq.apply(t).toInt
    inline def uint: CUnsignedInt = eq.apply(t)
opaque type Bla = CUnsignedInt
object Bla extends _BindgenEnumCUnsignedInt[Bla]:
  given _tag: Tag[Bla] = Tag.UInt
  inline def define(inline a: Long): Bla = a.toUInt
  val A = define(0)
  val B = define(1)
  inline def getName(inline value: Bla): Option[String] =
    inline value match
      case A => Some("A")
      case B => Some("B")
      case _ => _root_.scala.None
  extension (a: Bla)
    inline def &(b: Bla): Bla = a & b
    inline def |(b: Bla): Bla = a | b
    inline def is(b: Bla): Boolean = (a & b) == b