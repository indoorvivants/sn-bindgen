package bindgen

import bindgen.CType.Parameter

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.Tag
import scala.scalanative.unsigned.ULong

import opaque_newtypes.*

import Def.*

case class Location(isFromMainFile: Boolean, isFromSystemHeader: Boolean):
  inline def shouldBeIncluded: Boolean = isFromMainFile || !isFromSystemHeader

object Location:
  inline def systemHeader =
    Location(isFromMainFile = false, isFromSystemHeader = true)

case class BindingDefinition(item: Def, location: Location)

case class DefName(n: String, tg: DefTag)

opaque type FunctionName = String
object FunctionName extends OpaqueString[FunctionName]

opaque type EnumName = String
object EnumName extends OpaqueString[EnumName]

opaque type StructName = String
object StructName extends OpaqueString[StructName]

opaque type CommentText = String
object CommentText extends OpaqueString[CommentText]

opaque type DefinitionFile = String
object DefinitionFile extends OpaqueString[DefinitionFile]

case class Meta(comment: Option[CommentText], file: Option[DefinitionFile])
object Meta:
  def empty: Meta = Meta(None, None)

enum Def(meta: Meta):
  case Enum(
      values: List[(String, Long)],
      name: Option[EnumName],
      intType: Option[CType.NumericIntegral],
      meta: Meta
  ) extends Def(meta)

  case Struct(
      fields: List[(StructParameterName, CType)],
      name: StructName,
      anonymous: List[Def.Union | Def.Struct | Def.Enum],
      meta: Meta
  ) extends Def(meta)

  case Union(
      fields: List[(UnionParameterName, CType)],
      name: UnionName,
      anonymous: List[Def.Union | Def.Struct | Def.Enum],
      meta: Meta
  ) extends Def(meta)
  case Function(
      name: FunctionName,
      returnType: CType,
      parameters: List[FunctionParameter],
      originalCType: OriginalCType,
      numArguments: Int,
      variadic: Boolean,
      meta: Meta
  ) extends Def(meta)
  case Alias(name: String, underlying: CType, meta: Meta) extends Def(meta)

  def metadata: Meta = meta

  def defName: Option[DefName] =
    this match
      case Alias(name, _, _) => Some(DefName(name, DefTag.Alias))
      case u: Union          => Some(DefName(u.name.value, DefTag.Union))
      case f: Function       => Some(DefName(f.name.value, DefTag.Function))
      case s: Struct         => Some(DefName(s.name.value, DefTag.Struct))
      case e: Enum =>
        e.name.map(enumName => DefName(enumName.value, DefTag.Enum))
end Def

object Def:
  def typeOf(d: Function): CType.Function =
    CType.Function(
      d.returnType,
      d.parameters.map { case fp =>
        Parameter(Some(ParameterName(fp.name)), fp.typ)
      }.toList
    )
  def typeOf(d: Union): CType.Union =
    CType.Union(d.fields.map(_._2).toList)
  def typeOf(d: Struct): CType.Struct =
    CType.Struct(d.fields.map(_._2).toList)
  def typeOf(d: Enum): CType.Enum =
    CType.Enum(d.intType.get)
end Def

case class FunctionParameter(
    name: String,
    typ: CType,
    originalTyp: OriginalCType,
    generatedName: Boolean
)

case class OriginalCType(typ: CType, s: String)

enum Name:
  case Model(value: String, meta: Meta = Meta.empty)
  case BuiltIn(value: BuiltinType)
  case Unnamed

import CType.*

enum SignType:
  case Signed, Unsigned

opaque type StructParameterName = String
object StructParameterName extends OpaqueString[StructParameterName]

opaque type UnionParameterName = String
object UnionParameterName extends OpaqueString[UnionParameterName]

opaque type ParameterName = String
object ParameterName extends OpaqueString[ParameterName]

opaque type UnionName = String
object UnionName extends OpaqueString[UnionName]

enum IntegralBase:
  case Char, Short, Int, Long, LongLong

enum FloatingBase:
  case Float, Double, LongDouble
