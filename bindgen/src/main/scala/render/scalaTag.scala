package bindgen.rendering

import bindgen.*

def scalaTag(typ: CType)(using AliasResolver): String =
  import CType.*
  typ match
    case model @ Struct(fields) if fields.size <= 22 =>
      val paramTypes = model.fields.map(scalaType).mkString(", ")
      s"Tag.materializeCStruct${model.fields.size}Tag[$paramTypes]"

    case struct @ Struct(fields) =>
      scalaTag(Arr(CType.Byte, Some(staticSize(struct).toInt)))

    case union @ Union(fields) =>
      scalaTag(Arr(CType.Byte, Some(staticSize(union).toInt)))

    case n: NumericIntegral =>
      import IntegralBase.*
      import SignType.*
      val base = n.base match
        case Char            => "Byte"
        case Int             => "Int"
        case Long | LongLong => "Long"
        case Short           => "Short"

      val sign = n.sign match
        case Unsigned => "U"
        case _        => ""

      s"Tag.$sign$base"
    case Typedef(n) => s"$n._tag"

    case RecordRef(n) => s"$n._tag"
    case Function(ret, params) =>
      val paramTypes =
        (params.map(_.of) ++ List(ret))
      val paramTypesRendered = paramTypes.map(scalaType).mkString(", ")
      s"Tag.materializeCFuncPtr${paramTypes.size - 1}[$paramTypesRendered]"

    case n: NumericReal =>
      n.base match
        case FloatingBase.Float => "Tag.Float"
        case _                  => "Tag.Double"

    case Pointer(Void) => s"Tag.Ptr(Tag.Byte)"

    case Pointer(of) =>
      s"Tag.Ptr[${scalaType(of)}](${scalaTag(of)})"

    case Arr(tpe, Some(n)) =>
      s"Tag.CArray[${scalaType(tpe)}, ${natDigits(n)}](${scalaTag(tpe)}, ${natDigitsTag(n)})"
    case Void => s"Tag.Unit"
  end match
end scalaTag

def natDigitsTag(i: Int): String =
  if i <= 9 then s"Tag.Nat$i"
  else
    val digits = i.toString.toIterator.toList
    val renderedTypes = digits.map("Nat._" + _).mkString(", ")
    val renderedTags = digits.map("Tag.Nat" + _).mkString(", ")
    s"Tag.Digit${digits.size}[$renderedTypes]($renderedTags)"
