package bindgen

import CType.*

case class Hints(staticSize: Long)

enum CType:
  case Arr(of: CType, size: Option[Long])
  case Pointer(of: CType)
  case Enum(underlying: NumericIntegral)
  case Struct(fields: List[CType], hints: Hints, fieldNames: List[String] = Nil)
  case Union(fields: List[CType], hints: Hints)
  case Function(returnType: CType, parameters: List[CType.Parameter])
  case IncompleteArray(of: CType)

  case Void
  case Bool

  case NumericIntegral(base: IntegralBase, sign: SignType)
  case NumericReal(base: FloatingBase)
  case NumericComplex(base: FloatingBase)

  case Reference(name: Name)
end CType

given Ordering[SignType] = Ordering.by:
  case SignType.Signed   => 0
  case SignType.Unsigned => 1

given Ordering[IntegralBase] = Ordering.by:
  case IntegralBase.Char     => 0
  case IntegralBase.Short    => 1
  case IntegralBase.Int      => 2
  case IntegralBase.Long     => 3
  case IntegralBase.LongLong => 3

given Ordering[CType.NumericIntegral] = Ordering.by(s => (s.base, s.sign))

object CType:
  case class Parameter(name: Option[ParameterName], of: CType)

  val Int: NumericIntegral =
    CType.NumericIntegral(IntegralBase.Int, SignType.Signed)

  val UnsignedChar: NumericIntegral =
    CType.NumericIntegral(IntegralBase.Char, SignType.Unsigned)

  val Byte = CType.NumericIntegral(IntegralBase.Char, SignType.Signed)
end CType
