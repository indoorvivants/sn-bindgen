package bindgen

import CType.*

import ParameterName.given

case class Hints(staticSize: Long) derives io.circe.Codec.AsObject

enum CType derives io.circe.Codec.AsObject:
  case Arr(of: CType, size: Option[Long])
  case Pointer(of: CType)
  case Enum(underlying: NumericIntegral)
  case Struct(fields: List[CType], hints: Hints)
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

given io.circe.Codec[CType.NumericIntegral] = ???
  //summon[io.circe.Codec[CType]].asInstanceOf

given Ordering[CType.NumericIntegral] = Ordering.by(s => (s.base, s.sign))

object CType:
  case class Parameter(name: Option[ParameterName], of: CType)
      derives io.circe.Codec.AsObject

  val Int: NumericIntegral =
    CType.NumericIntegral(IntegralBase.Int, SignType.Signed)

  val UnsignedChar: NumericIntegral =
    CType.NumericIntegral(IntegralBase.Char, SignType.Unsigned)

  val Byte = CType.NumericIntegral(IntegralBase.Char, SignType.Signed)
end CType
