package bindgen
package rendering

import bindgen.*
import scala.scalanative.unsafe.CFuncPtr

import CType.*

def alias(model: Def.Alias, line: Appender)(using AliasResolver, Config) =
  val (underlyingType, enableConstructor) =
    model.underlying match
      case Pointer(Reference(Name.Unnamed)) =>
        Pointer(CType.Struct(Nil)) -> false
      case other => other -> true

  import CType.*
  val isOpaque = underlyingType match
    case _: Reference | _: Function | Void => false
    case _                                 => true

  val modifier = if isOpaque then "opaque " else ""
  line(s"${modifier}type ${model.name} = ${scalaType(underlyingType)}")
  line(s"object ${sanitiseBeforeColon(model.name)}: ")
  nest {
    model.underlying match
      case Reference(Name.BuiltIn(name)) =>
        line(s"val _tag: Tag[${model.name}] = summon[Tag[${name.full}]]")
      case _ =>
        line(s"given _tag: Tag[${model.name}] = ${scalaTag(underlyingType)}")
    if enableConstructor then
      line(
        s"inline def apply(inline o: ${scalaType(underlyingType)}): ${model.name} = o"
      )
      line(s"extension (v: ${model.name})")
      nest {
        line(s"inline def value: ${scalaType(underlyingType)} = v")
      }
  }

end alias
