package bindgen.rendering

import bindgen.*

def renderName(name: Name.Model)(using config: Config) =
  val nameMatches = config.rendering.matchesPackage(_.externalNames)(name.value)
  val pathMatches = name.meta.file.map(_.value).flatMap { f =>
    config.rendering.matchesPackage(_.externalPaths)(f)
  }

  (nameMatches orElse pathMatches)
    .map(_._2.value)
    .map { pkgName =>
      s"_root_.$pkgName.${name.value}"
    }
    .getOrElse(name.value)
end renderName

def scalaNumericType(typ: CType.NumericIntegral) =
  import IntegralBase.*
  import SignType.*
  val bs =
    typ.base match
      case Char     => "Char"
      case Short    => "Short"
      case Int      => "Int"
      case Long     => "LongInt"
      case LongLong => "LongLong"

  val prefix = typ.sign match
    case Signed   => "C"
    case Unsigned => "CUnsigned"

  prefix + bs
end scalaNumericType

def scalaType(typ: CType)(using AliasResolver, Config): String =
  import CType.*
  typ match
    case Reference(n: Name.Model) =>
      renderName(n)
    case Reference(Name.BuiltIn(name)) => name.full
    case Pointer(to)                   =>
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
    case ni: NumericIntegral   => scalaNumericType(ni)
    case Function(ret, params) =>
      val args = params.size
      val types =
        (params.map(_.of) ++ List(ret))
          .map(scalaType)
          .mkString("[", ", ", "]")
      s"CFuncPtr$args$types"

    case at @ Struct(fields, hints) =>
      if fields.size > 22 then
        s"CArray[Byte, ${natDigits(hints.staticSize.toInt)}]"
      else if fields.nonEmpty then
        val parameters = fields.map(scalaType).mkString("[", ", ", "]")
        s"CStruct${fields.size}$parameters"
      else "CStruct0"

    case at @ Union(fields, hints) =>
      s"CArray[Byte, ${natDigits(hints.staticSize.toInt)}]"

    case Arr(of, size) =>
      size match
        case Some(cnt) => s"CArray[${scalaType(of)}, ${natDigits(cnt)}]"
        case None      => s"Ptr[${scalaType(of)}]"

    case IncompleteArray(of) => s"Ptr[${scalaType(of)}]"

    case Void =>
      "Unit"
    case Bool => "Boolean"

  end match
end scalaType

def structArrayType(ct: CType.Struct)(using Config, AliasResolver) =
  CType.Arr(CType.Byte, Some(ct.hints.staticSize.toInt))

def natDigits(i: Long): String =
  if i <= 0 then "Nat._0"
  else if i <= 9 then s"Nat._$i"
  else
    val digits = i.toString.toIterator.toList
    val rendered = digits.map("Nat._" + _).mkString(", ")
    s"Nat.Digit${digits.size}[$rendered]"
