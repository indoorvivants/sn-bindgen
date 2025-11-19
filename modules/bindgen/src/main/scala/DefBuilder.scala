package bindgen

import scala.collection.mutable.ListBuffer

sealed trait DefBuilder[Builds]:
  import DefBuilder.*
  def build: Builds =
    this match
      case e: Enum => Def.Enum(e.values.result(), e.name, e.intType, e.meta)
      case e: Struct =>
        Def.Struct(
          e.fields.result(),
          e.name,
          e.anonymous.result(),
          e.staticSize,
          e.meta
        )
      case e: Union =>
        Def.Union(
          e.fields.result,
          e.name,
          e.anonymous.result(),
          e.staticSize,
          e.meta
        )
      case e: Function =>
        import e.*
        Def.Function(
          name,
          returnType,
          parameters.result(),
          originalCType,
          numArguments,
          variadic,
          meta
        )
end DefBuilder

object DefBuilder:
  case class Enum(
      var values: ListBuffer[(String, Long)],
      var name: Option[EnumName],
      var intType: Option[CType.NumericIntegral],
      var meta: Meta
  ) extends DefBuilder[Def.Enum]

  case class Struct(
      var fields: ListBuffer[FieldSpec],
      var name: Option[StructName],
      var anonymous: ListBuffer[Def.Union | Def.Struct | Def.Enum],
      var staticSize: Long,
      var meta: Meta,
      var anonymousFieldStructMapping: ListBuffer[(Int, StructName)]
  ) extends DefBuilder[Def.Struct]

  case class Union(
      var fields: ListBuffer[FieldSpec],
      var name: Option[UnionName],
      var anonymous: ListBuffer[Def.Union | Def.Struct | Def.Enum],
      var staticSize: Long,
      var meta: Meta
  ) extends DefBuilder[Def.Union]

  case class Function(
      var name: FunctionName,
      var returnType: CType,
      var parameters: ListBuffer[FunctionParameter],
      val originalCType: OriginalCType,
      var numArguments: Int,
      var variadic: Boolean,
      var meta: Meta
  ) extends DefBuilder[Def.Function]

  case class Alias(name: String, underlying: CType)
      extends DefBuilder[Def.Alias]

end DefBuilder
