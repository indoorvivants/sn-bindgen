package bindgen.rendering

import bindgen.*

def scalaType(typ: CType)(using AliasResolver): String =
  import CType.*
  typ match
    case Typedef(name)   => name
    case RecordRef(name) => name
    case Pointer(to) =>
      to match
        case Void       => "Ptr[Byte]" // there's no void type on SN
        case CType.Byte => "CString"
        // a pointer to a function should be collapsed to CFuncPtr
        case f: Function => scalaType(f)
        case other       => s"Ptr[${scalaType(other)}]"
    case NumericReal(base) =>
      base match
        case FloatingBase.Float      => "Float"
        case FloatingBase.Double     => "Double"
        case FloatingBase.LongDouble => "Double"
    case NumericIntegral(base, signType) =>
      import IntegralBase.*
      import SignType.*
      val bs =
        base match
          case Char     => "Char"
          case Short    => "Short"
          case Int      => "Int"
          case Long     => "LongInt"
          case LongLong => "LongLong"

      val prefix = signType match
        case Signed   => "C"
        case Unsigned => "CUnsigned"

      prefix + bs
    case Function(ret, params) =>
      val args = params.size
      val types =
        (params.map(_.of) ++ List(ret))
          .map(scalaType)
          .mkString("[", ", ", "]")
      s"CFuncPtr$args$types"

    case at @ Struct(fields) =>
      if fields.size > 22 then
        s"CArray[Byte, ${natDigits(staticSize(at).toInt)}]"
      else if fields.nonEmpty then
        val parameters = fields.map(scalaType).mkString("[", ", ", "]")
        s"CStruct${fields.size}$parameters"
      else "CStruct0"

    case at @ Union(fields) =>
      s"CArray[Byte, ${natDigits(staticSize(at).toInt)}]"

    case Arr(of, size) =>
      size match
        case Some(cnt) => s"CArray[${scalaType(of)}, ${natDigits(cnt)}]"
        case None      => s"Ptr[${scalaType(of)}]"

    case Void =>
      "Unit"
    case Bool => "Boolean"

  end match
end scalaType

def natDigits(i: Int): String =
  if i <= 9 then s"Nat._$i"
  else
    val digits = i.toString.toIterator.toList
    val rendered = digits.map("Nat._" + _).mkString(", ")
    s"Nat.Digit${digits.size}[$rendered]"
