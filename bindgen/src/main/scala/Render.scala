package bindgen

object render:
  def enumeration(model: Def.Enum, line: Appender)(using
      Config
  ) =
    val values = List.newBuilder[(String, String)]
    val opaqueType = model.name
    val finalizer = if model.values.nonEmpty then ":" else ""
    val numericType = model.intType.getOrElse(CType.Int)
    val enumSuffix = if numericType.sign == SignType.Unsigned then "U" else ""
    val underlyingTypeRender = scalaType(numericType)
    line(s"opaque type $opaqueType = $underlyingTypeRender")
    line(s"object $opaqueType extends CEnum$enumSuffix[$opaqueType]$finalizer")

    nest {
      if numericType.sign == SignType.Signed then
        line(s"inline def define(inline a: $underlyingTypeRender) = a")
      else
        val extension = numericType.base match
          case IntegralBase.Int   => "Int"
          case IntegralBase.Long  => "Long"
          case IntegralBase.Short => "Short"
          case IntegralBase.Char  => "Byte"
        line(
          s"transparent inline def define(inline a: Long): $opaqueType = a.toU$extension"
        )
      end if
      model.values.foreach { case (constName, value) =>
        val lhs = s"val $constName"
        val rhs = "define(" + value.toString + ")"

        line(lhs + " = " + rhs)
      }
    }
  end enumeration

  def struct(model: Def.Struct, line: Appender)(using Config) =
    val structName = model.name
    val tpe = scalaType(CType.Struct(model.fields.map(_._2).toList))
    line(s"opaque type $structName = $tpe")
    line(s"object $structName:")
    nest {
      line(s"extension (struct: $structName)")
      nest {
        model.fields.zipWithIndex.foreach {
          case ((fieldName, fieldType), idx) =>
            line(
              s"def $fieldName: ${scalaType(fieldType)} = struct._${idx + 1}"
            )
        }
      }
    }
  end struct

  def scalaType(typ: CType)(using Config): String =
    import CType.*
    typ match
      case Typedef(name) => name
      case Pointer(to) =>
        to match
          case Void  => "Ptr[Byte]" // there's no void type on SN
          case other => s"Ptr[${scalaType(other)}]"
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

      case Struct(fields) =>
        s"CStruct${fields.size}[${fields.map(scalaType).mkString(", ")}]"

      case Arr(of, size) =>
        size match
          case Some(cnt) => s"CArray[${scalaType(of)}, ${natDigits(cnt)}]"
          case None      => s"Ptr[${scalaType(of)}]"

      case Void =>
        "void"

    end match
  end scalaType

  def natDigits(i: Int): String =
    if i <= 9 then s"Nat._$i"
    else
      val digits = i.toString.iterator.toList.map("_" + _).mkString(", ")
      s"Nat.Digit${digits.size}[$digits]"

  def indent(using c: Config): String = (" " * (c.indentSize * c.indents))
  def nest(f: Config ?=> Unit)(using config: Config) = f(using
    Config(config.indentSize, indents = config.indents + 1)
  )
  def to(sb: java.lang.StringBuilder)(using config: Config): Appender =
    line => sb.append(indent(using config) + line + "\n")

  type Appender = Config ?=> String => Unit
end render

case class Config(indentSize: Int = 2, indents: Int = 0)
