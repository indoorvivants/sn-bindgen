package bindgen

import bindgen.CType.Parameter

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.Tag
import scala.scalanative.unsigned.ULong

import Def.*

case class BindingDefinition(item: Def, isFromMainFile: Boolean)

enum DefTag:
  case Union, Alias, Struct, Function, Enum
object DefTag:
  import DefTag.*
  def all = Set(Union, Alias, Struct, Function, Enum)

case class DefName(n: String, tg: DefTag)

case class Binding(
    var named: mutable.Map[DefName, BindingDefinition] = mutable.Map.empty
):
  def add(item: Def, isFromMainFile: Boolean) =
    item.defName.foreach { n =>
      named.addOne(n -> BindingDefinition(item, isFromMainFile))
    }
    this

  def remove(name: DefName): Binding =
    named.remove(name)
    this
  def aliases: Set[Def.Alias] = named.collect {
    case (k, BindingDefinition(item: Def.Alias, _)) => item
  }.toSet

  def unions: Set[Def.Union] = named.collect {
    case (k, BindingDefinition(item: Def.Union, _)) => item
  }.toSet
  def structs: Set[Def.Struct] = named.collect {
    case (k, BindingDefinition(item: Def.Struct, _)) => item
  }.toSet
  def enums: Set[Def.Enum] = named.collect {
    case (k, BindingDefinition(item: Def.Enum, _)) => item
  }.toSet

  def functions: Set[Def.Function] = named.collect {
    case (k, BindingDefinition(item: Def.Function, _)) => item
  }.toSet
end Binding

enum Def:
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
      val originalCType: OriginalCType
  )
  case Alias(name: String, underlying: CType)

  def defName: Option[DefName] =
    this match
      case Alias(name, _) => Some(DefName(name, DefTag.Alias))
      case Union(_, name) => Some(DefName(name, DefTag.Union))
      case f: Function    => Some(DefName(f.name, DefTag.Function))
      case s: Struct      => Some(DefName(s.name, DefTag.Struct))
      case e: Enum        => e.name.map(DefName(_, DefTag.Enum))
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

  case Reference(name: Name)
end CType

enum Name:
  case Model(value: String)
  case BuiltIn(value: BuiltinType)

import CType.*

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
