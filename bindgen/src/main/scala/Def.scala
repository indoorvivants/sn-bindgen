package bindgen

import scala.collection.mutable.ListBuffer
import bindgen.CType.Parameter
import scala.collection.mutable
import Def.*
import scala.scalanative.unsigned.ULong
import scala.scalanative.unsafe.Tag

case class BindingDefinition(item: Def, isFromMainFile: Boolean)

case class Binding(
    // var enums: mutable.Set[Enum] = mutable.Set.empty,
    // var structs: mutable.Set[Struct] = mutable.Set.empty,
    // var unions: mutable.Set[Union] = mutable.Set.empty,
    // var functions: mutable.Set[Function] = mutable.Set.empty,
    // var aliases: mutable.Set[Alias] = mutable.Set.empty,
    // var mainFileNames: mutable.Set[String] = mutable.Set.empty,
    var named: mutable.Map[String, BindingDefinition] = mutable.Map.empty
):
  def add(item: Def, isFromMainFile: Boolean) =
    item.defName.foreach { n =>
      named.addOne(n -> BindingDefinition(item, isFromMainFile))
    }
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
      var tpe: CFunctionType,
      val originalCType: OriginalCType
  )
  case Alias(name: String, underlying: CType)

  def defName: Option[String] =
    this match
      case Alias(name, _) => Some(name)
      case Union(_, name) => Some(name)
      case f: Function    => Some(f.name)
      case s: Struct      => Some(s.name)
      case e: Enum        => e.name

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
