package bindgen
package rendering

import bindgen.*

import CType.*

def alias(model: Def.Alias, line: Appender)(using
    AliasResolver,
    Config
): Exported =
  val (underlyingType, enableConstructor) =
    model.underlying match
      case Pointer(Reference(Name.Unnamed)) =>
        Pointer(CType.Struct(Nil, Hints(0L))) -> false
      case other => other -> true

  val isOpaque = underlyingType match
    case _: Reference | _: Function | Void => false
    case _                                 => true

  val isFunctionPointer = underlyingType match
    case Pointer(f: Function) => true
    case _                    => false

  val modifier = if isOpaque then "opaque " else ""

  val voidPtr = summon[Config].flavour match
    case Flavour.ScalaNative04 => "Ptr[?]"
    case Flavour.ScalaNative05 => "CVoidPtr"

  renderComment(line, model.meta)
  line(s"${modifier}type ${model.name} = ${scalaType(underlyingType)}")
  line(s"object ${sanitiseBeforeColon(model.name)}: ")
  nest {
    model.underlying match
      case Reference(Name.BuiltIn(name)) =>
        line(s"val _tag: Tag[${model.name}] = summon[Tag[${name.full}]]")
      case _ =>
        line(s"given _tag: Tag[${model.name}] = ${scalaTag(underlyingType)}")

    if isFunctionPointer then
      line(
        s"inline def fromPtr(ptr: Ptr[Byte] | $voidPtr): ${model.name} = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])"
      )
    end if

    if enableConstructor then

      line(
        s"inline def apply(inline o: ${scalaType(underlyingType)}): ${model.name} = o"
      )
      line(s"extension (v: ${model.name})")
      nest {
        line(s"inline def value: ${scalaType(underlyingType)} = v")
        if isFunctionPointer then
          line(s"inline def toPtr: $voidPtr = CFuncPtr.toPtr(v)")
        end if
      }
    end if
  }

  Exported.Yes(model.name)

end alias
