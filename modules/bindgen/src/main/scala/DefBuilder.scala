package bindgen

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

import CDefinition.*
import CType.*

sealed trait DefBuilder[Builds]:
  import DefBuilder.*
  def build: Builds =
    this match
      case e: Enum => CDefinition.Enum(e.values.result(), e.name, e.intType, e.meta)
      case e: Struct =>
        CDefinition.Struct(
          e.fields.result(),
          e.name,
          e.anonymous.result(),
          e.staticSize,
          e.meta
        )
      case e: Union =>
        CDefinition.Union(
          e.fields.result,
          e.name,
          e.anonymous.result(),
          e.staticSize,
          e.meta
        )
      case e: Function =>
        import e.*
        CDefinition.Function(
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
      var meta: Metadata
  ) extends DefBuilder[CDefinition.Enum]

  case class Struct(
      var fields: ListBuffer[(StructParameterName, CType)],
      var name: StructName,
      var anonymous: ListBuffer[CDefinition.Union | CDefinition.Struct | CDefinition.Enum],
      var staticSize: Long,
      var meta: Metadata,
      var anonymousFieldStructMapping: ListBuffer[(Int, StructName)]
  ) extends DefBuilder[CDefinition.Struct]

  case class Union(
      var fields: ListBuffer[(UnionParameterName, CType)],
      var name: UnionName,
      var anonymous: ListBuffer[CDefinition.Union | CDefinition.Struct | CDefinition.Enum],
      var staticSize: Long,
      var meta: Metadata
  ) extends DefBuilder[CDefinition.Union]

  case class Function(
      var name: FunctionName,
      var returnType: CType,
      var parameters: ListBuffer[FunctionParameter],
      val originalCType: OriginalCType,
      var numArguments: Int,
      var variadic: Boolean,
      var meta: Metadata
  ) extends DefBuilder[CDefinition.Function]

  case class Alias(name: String, underlying: CType)
      extends DefBuilder[CDefinition.Alias]

end DefBuilder
