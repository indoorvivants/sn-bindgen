package bindgen

import opaque_newtypes.*

import Def.*
import scala.annotation.static

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

case class Meta(
    comment: Option[CommentText],
    file: Option[DefinitionFile]
)
object Meta:
  def empty: Meta = Meta(None, None)

enum FieldName:
  case Anon(idx: Int)
  case Value(name: String)

  def get = this match
    case Anon(_)     => None
    case Value(name) => Some(name)

enum FieldSpec:
  case Known(name: String, tpe: CType)
  case Anon(nameHint: Option[String], unsafeId: Int)
  case AnonArray(nameHint: Option[String], size: Long, unsafeId: Int)

case class DeepField(
    name: String,
    typ: CType,
    fieldPath: String
)

case class ResolvedStruct(
    fields: List[(StructParameterName, CType)],
    name: StructName,
    fqn: StructName,
    anonymous: Vector[ResolvedUnion | ResolvedStruct | ResolvedEnum],
    staticSize: Long,
    deepFields: List[DeepField],
    meta: Meta
):
  val typ =
    CType.Struct(
      fields.map(_._2),
      hints = Hints(staticSize),
      fieldNames = fields.map(_._1.value)
    )
end ResolvedStruct

case class ResolvedUnion(
    fields: List[(UnionParameterName, CType)],
    name: UnionName,
    fqn: UnionName,
    anonymous: Vector[ResolvedUnion | ResolvedStruct | ResolvedEnum],
    staticSize: Long,
    meta: Meta
):
  val typ =
    CType.Union(
      fields.map(_._2),
      hints = Hints(staticSize)
    )
end ResolvedUnion

case class ResolvedEnum(
    values: List[(String, Long)],
    name: EnumName,
    fqn: EnumName,
    intType: Option[CType.NumericIntegral],
    meta: Meta
):
  val typ = CType.Enum(intType.get)

enum Def(meta: Meta):
  case Enum(
      values: List[(String, Long)],
      name: Option[EnumName],
      intType: Option[CType.NumericIntegral],
      meta: Meta
  ) extends Def(meta)

  case Struct(
      fields: List[FieldSpec],
      name: Option[StructName],
      anonymous: List[Def.Union | Def.Struct | Def.Enum],
      staticSize: Long,
      meta: Meta
  ) extends Def(meta)

  case Union(
      fields: List[FieldSpec],
      name: Option[UnionName],
      anonymous: List[Def.Union | Def.Struct | Def.Enum],
      staticSize: Long,
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
      case u: Union          => u.name.map(n => DefName(n.value, DefTag.Union))
      case f: Function       => Some(DefName(f.name.value, DefTag.Function))
      case s: Struct         => s.name.map(n => DefName(n.value, DefTag.Struct))
      case e: Enum =>
        e.name.map(enumName => DefName(enumName.value, DefTag.Enum))

  // lazy val resolvedType: CType = this match
  //   case Enum(values, name, intType, meta) => CType.Enum(intType.get)
  //   case Struct(fields, name, anonymous, staticSize, meta) =>
  //     val namer =
  //       var unions = 0
  //       var structs = 0
  //       (
  //         structName = (n: Option[StructName]) =>
  //           n.getOrElse({
  //             val s = StructName(s"Struct$structs")
  //             structs += 1;
  //             s
  //           }),
  //         unionName = (n: Option[UnionName]) =>
  //           n.getOrElse({
  //             val s = UnionName(s"Struct$unions")
  //             unions += 1;
  //             s
  //           })
  //       )
  //     end namer
  //     ???

  //   case Union(fields, name, anonymous, staticSize, meta) => ???
  //   case Function(
  //         name,
  //         returnType,
  //         parameters,
  //         originalCType,
  //         numArguments,
  //         variadic,
  //         meta
  //       ) =>
  //     ???
  //   case Alias(name, underlying, meta) => ???
end Def

// end Def

// object Def:
// def typeOf(d: Def) = d.resolvedType
// def typeOf(d: Function): CType.Function =
//   CType.Function(
//     d.returnType,
//     d.parameters.map { case fp =>
//       CType.Parameter(Some(ParameterName(fp.name)), fp.typ)
//     }.toList
//   )
// def typeOf(d: Union): CType.Union =
//   CType.Union(d.fields.map(_._2).toList, Hints(d.staticSize))
// def typeOf(d: Struct): CType.Struct =
//   CType.Struct(d.fields.map(_._2).toList, Hints(d.staticSize))
// def typeOf(d: Enum): CType.Enum =
//   CType.Enum(d.intType.get)
// end Def

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
