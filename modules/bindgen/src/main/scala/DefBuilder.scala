package bindgen

import bindgen.CType.Parameter
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.Tag
import scala.scalanative.unsigned.ULong
import Def.*
import CType.*
import scala.collection.immutable.DefaultMap

sealed trait DefBuilder[Builds]:
  import DefBuilder.*
  def build: Builds =
    this match
      case e: Enum => Def.Enum(e.values.result(), e.name, e.intType, e.meta)
      case e: Struct =>
        Def.Struct(e.fields.result(), e.name, e.anonymous.result(), e.meta)
      case e: Union =>
        Def.Union(e.fields.result, e.name, e.anonymous.result(), e.meta)
      case e: Function =>
        import e.*
        Def.Function(
          name,
          returnType,
          parameters.result(),
          originalCType,
          numArguments,
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
      var fields: ListBuffer[(StructParameterName, CType)],
      var name: StructName,
      var anonymous: ListBuffer[Def.Union | Def.Struct],
      var meta: Meta
  ) extends DefBuilder[Def.Struct]

  case class Union(
      var fields: ListBuffer[(UnionParameterName, CType)],
      var name: UnionName,
      var anonymous: ListBuffer[Def.Union | Def.Struct],
      var meta: Meta
  ) extends DefBuilder[Def.Union]

  case class Function(
      var name: FunctionName,
      var returnType: CType,
      var parameters: ListBuffer[FunctionParameter],
      val originalCType: OriginalCType,
      var numArguments: Int,
      var meta: Meta
  ) extends DefBuilder[Def.Function]

  case class Alias(name: String, underlying: CType)
      extends DefBuilder[Def.Alias]

end DefBuilder
