package bindgen

import scala.collection.mutable.ListBuffer

object Def:
  import scala.collection.mutable
  case class Binding(
    var enums: mutable.Set[Enum],
    var structs: mutable.Set[Struct],
    var functions: mutable.Set[Function]
    )
  case class Enum(
      var values: ListBuffer[(String, Long)],
      var name: String,
      var intType: Option[CType.NumericIntegral]
  )
  case class Struct(var fields: ListBuffer[(String, CType)], var name: String)
  case class Function(
      var name: String,
      var returnType: CType,
      var parameters: ListBuffer[(String, CType)],
      var tpe: CFunctionType
  )
end Def

enum CFunctionType:
  case Extern

enum CType:
  case Arr(of: CType, size: Option[Int])
  case Pointer(of: CType)
  case Enum(underlying: NumericIntegral)
  case Struct(fields: List[CType])
  case Function(returnType: CType, parameters: List[CType.Parameter])
  case Union(constituents: List[CType.UnionPart])

  case Void
  case Bool

  case NumericIntegral(base: IntegralBase, sign: SignType)
  case NumericReal(base: FloatingBase)
  case NumericComplex(base: FloatingBase)

  case Typedef(name: String)
end CType

enum SignType:
  case Signed, Unsigned

object CType:
  case class Parameter(name: Option[String], of: CType)
  case class UnionPart(name: String, of: CType)

  val Int: NumericIntegral = CType.NumericIntegral(IntegralBase.Int, SignType.Signed)

enum IntegralBase:
  case Char, Short, Int, Long, LongLong

enum FloatingBase:
  case Float, Double, LongDouble
