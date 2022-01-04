package bindgen
package rendering

import bindgen.*
import scala.scalanative.unsafe.CFuncPtr

def alias(model: Def.Alias, line: Appender)(using AliasResolver, Config) =
  val underlyingType = scalaType(model.underlying)
  import CType.*
  val isOpaque = model.underlying match
    case _: Typedef | _: RecordRef | _: Function | Void => false
    case _                                              => true

  model.underlying match
    case Pointer(Function(retType, params)) =>
      info(s"Checking $model for cycles: ")
      info(isCyclical(model.underlying, model.name))
    case _ =>

  val modifier = if isOpaque then "opaque " else ""
  line(s"${modifier}type ${model.name} = $underlyingType")
  line(s"object ${model.name}: ")
  nest {
    line(s"given _tag: Tag[${model.name}] = ${scalaTag(model.underlying)}")
    if isOpaque then
      line(s"inline def apply(inline o: $underlyingType): ${model.name} = o")
  }

end alias
