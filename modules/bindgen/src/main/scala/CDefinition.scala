package bindgen

import opaque_newtypes.*
import io.circe.Codec
import io.circe.Decoder

case class BindingDefinition(item: CDefinition, location: Location)

case class DefName(n: String, tg: CDefinitionTag)

inline given deriveCodec[A, T](using
    bts: SameRuntimeType[T, A],
    original: => Codec[A]
): Codec[T] =
  original.iemap(a => Right(a.asInstanceOf[T]))(_.asInstanceOf[A])

import EnumName.given

inline given Codec[CDefinition.Union | CDefinition.Struct | CDefinition.Enum] = 
  ???


enum CDefinition(meta: Metadata) derives io.circe.Codec.AsObject:
  case Enum(
      values: List[(String, Long)],
      name: Option[EnumName],
      intType: Option[CType.NumericIntegral],
      meta: Metadata
  ) extends CDefinition(meta)

  case Struct(
      fields: List[(StructParameterName, CType)],
      name: StructName,
      anonymous: List[CDefinition.Union | CDefinition.Struct | CDefinition.Enum],
      staticSize: Long,
      meta: Metadata
  ) extends CDefinition(meta)

  case Union(
      fields: List[(UnionParameterName, CType)],
      name: UnionName,
      anonymous: List[CDefinition.Union | CDefinition.Struct | CDefinition.Enum],
      staticSize: Long,
      meta: Metadata
  ) extends CDefinition(meta)

  case Function(
      name: FunctionName,
      returnType: CType,
      parameters: List[FunctionParameter],
      originalCType: OriginalCType,
      numArguments: Int,
      variadic: Boolean,
      meta: Metadata
  ) extends CDefinition(meta)

  case Alias(name: String, underlying: CType, meta: Metadata) extends CDefinition(meta)

  def metadata: Metadata = meta

  def defName: Option[DefName] =
    this match
      case Alias(name, _, _) => Some(DefName(name, CDefinitionTag.Alias))
      case u: Union          => Some(DefName(u.name.value, CDefinitionTag.Union))
      case f: Function       => Some(DefName(f.name.value, CDefinitionTag.Function))
      case s: Struct         => Some(DefName(s.name.value, CDefinitionTag.Struct))
      case e: Enum =>
        e.name.map(enumName => DefName(enumName.value, CDefinitionTag.Enum))
end CDefinition

object CDefinition:
  def typeOf(d: Function): CType.Function =
    CType.Function(
      d.returnType,
      d.parameters.map { case fp =>
        CType.Parameter(Some(ParameterName(fp.name)), fp.typ)
      }.toList
    )
  def typeOf(d: Union): CType.Union =
    CType.Union(d.fields.map(_._2).toList, Hints(d.staticSize))
  def typeOf(d: Struct): CType.Struct =
    CType.Struct(d.fields.map(_._2).toList, Hints(d.staticSize))
  def typeOf(d: Enum): CType.Enum =
    CType.Enum(d.intType.get)
end CDefinition

