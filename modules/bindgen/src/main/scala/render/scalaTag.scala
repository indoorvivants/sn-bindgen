package bindgen.rendering

import bindgen.*

def scalaTag(typ: CType)(using AliasResolver, Config): String =
  import CType.*
  typ match
    case model @ Struct(fields, _, _) if fields.size <= 22 =>
      val paramTypes = model.fields.map(scalaType).mkString(", ")

      if model.fields.size > 0 then
        s"Tag.materializeCStruct${model.fields.size}Tag[$paramTypes]"
      else "Tag.materializeCStruct0Tag"

    case struct: Struct =>
      scalaTag(Arr(CType.Byte, Some(struct.hints.staticSize)))

    case union: Union =>
      scalaTag(Arr(CType.Byte, Some(union.hints.staticSize)))

    case n: NumericIntegral =>
      import IntegralBase.*
      import SignType.*
      val base = n.base match
        case Char => "Byte"
        case Int  => "Int"
        case Long =>
          if Config.is(_.flavour == Flavour.ScalaNative05) then "Size"
          else "Long"
        case LongLong => "Long"
        case Short    => "Short"

      val sign = n.sign match
        case Unsigned => "U"
        case _        => ""

      s"Tag.$sign$base"
    case Reference(name: Name.Model) => s"${renderName(name)}._tag"

    case Function(ret, params) =>
      val paramTypes =
        (params.map(_.of) ++ List(ret))
      val paramTypesRendered = paramTypes.map(scalaType).mkString(", ")
      s"Tag.materializeCFuncPtr${paramTypes.size - 1}[$paramTypesRendered]"

    case n: NumericReal =>
      n.base match
        case FloatingBase.Float => "Tag.Float"
        case _                  => "Tag.Double"

    case Pointer(Void)           => s"Tag.Ptr(Tag.Byte)"
    case Pointer(func: Function) => scalaTag(func)
    case Pointer(of) =>
      s"Tag.Ptr[${scalaType(of)}](${scalaTag(of)})"

    case Arr(tpe, Some(n)) =>
      s"Tag.CArray[${scalaType(tpe)}, ${natDigits(n)}](${scalaTag(tpe)}, ${natDigitsTag(n)})"
    case Void => s"Tag.Unit"
    case Bool => s"Tag.Boolean"
  end match
end scalaTag

def natDigitsTag(i: Long): String =
  if i <= 0 then s"Tag.Nat0"
  else if i <= 9 then s"Tag.Nat$i"
  else
    val digits = i.toString.toIterator.toList
    val renderedTypes = digits.map("Nat._" + _).mkString(", ")
    val renderedTags = digits.map("Tag.Nat" + _).mkString(", ")
    s"Tag.Digit${digits.size}[$renderedTypes]($renderedTags)"
