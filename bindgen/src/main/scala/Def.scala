package bindgen

import scala.collection.mutable.ListBuffer
import bindgen.CType.Parameter
import scala.collection.mutable

enum Def:
  case Binding(
      var enums: mutable.Set[Enum],
      var structs: mutable.Set[Struct],
      var unions: mutable.Set[Union],
      var functions: mutable.Set[Function],
      var aliases: mutable.Set[Alias],
      var mainFileNames: mutable.Set[String]
  )
  case Enum(
      var values: ListBuffer[(String, Long)],
      var name: Option[String],
      var intType: Option[CType.NumericIntegral]
  )
  case Struct(
      var fields: ListBuffer[(String, CType)],
      var name: String,
      var anonymous: ListBuffer[Def.Union | Def.Struct]
  )
  case Union(var fields: ListBuffer[(String, CType)], var name: String)
  case Function(
      var name: String,
      var returnType: CType,
      var parameters: ListBuffer[FunctionParameter],
      var tpe: CFunctionType,
      val originalCType: OriginalCType
  )
  case Alias(name: String, underlying: CType)

end Def

object Def:
  def typeOf(d: Function): CType.Function =
    CType.Function(
      d.returnType,
      d.parameters.map { case fp =>
        Parameter(Some(fp.name), fp.typ)
      }.toList
    )
  def typeOf(d: Union): CType.Union =
    CType.Union(d.fields.map(_._2).toList)
  def typeOf(d: Struct): CType.Struct =
    CType.Struct(d.fields.map(_._2).toList)
end Def

case class FunctionParameter(
    name: String,
    typ: CType,
    originalTyp: OriginalCType,
    generatedName: Boolean
)

case class OriginalCType(typ: CType, s: String)

enum CFunctionType:
  case Extern
  case ExternRename(name: String, internal: Boolean, original: String)
  case Delegate(parameters: Set[Int], withReturn: Boolean, delegateTo: String)

enum CType:
  case Arr(of: CType, size: Option[Int])
  case Pointer(of: CType)
  case Enum(underlying: NumericIntegral)
  case Struct(fields: List[CType])
  case Union(fields: List[CType])
  case Function(returnType: CType, parameters: List[CType.Parameter])

  case Void
  case Bool

  case NumericIntegral(base: IntegralBase, sign: SignType)
  case NumericReal(base: FloatingBase)
  case NumericComplex(base: FloatingBase)

  case Typedef(name: String)
  case RecordRef(name: String)
end CType

import CType.*

// TODO: this will not work on a 32 architecture. Need to reference UWord somehow.
object BuiltinType:
  val size_t = NumericIntegral(IntegralBase.Long, SignType.Unsigned)
  val ssize_t = NumericIntegral(IntegralBase.Long, SignType.Signed)
  val uint32_t = NumericIntegral(IntegralBase.Int, SignType.Unsigned)
  val uint8_t = NumericIntegral(IntegralBase.Char, SignType.Unsigned)

enum SignType:
  case Signed, Unsigned

object CType:
  case class Parameter(name: Option[String], of: CType)
  case class UnionPart(name: String, of: CType)

  val Int: NumericIntegral =
    CType.NumericIntegral(IntegralBase.Int, SignType.Signed)

  val UnsignedChar: NumericIntegral =
    CType.NumericIntegral(IntegralBase.Char, SignType.Unsigned)

  val Byte = CType.NumericIntegral(IntegralBase.Char, SignType.Signed)
end CType

enum IntegralBase:
  case Char, Short, Int, Long, LongLong

enum FloatingBase:
  case Float, Double, LongDouble
