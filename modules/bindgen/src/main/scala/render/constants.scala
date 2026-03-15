package bindgen
package rendering

def constants(model: Constants, line: Appender)(using
    Config,
    AliasResolver
): List[Exported] =
  val exports = List.newBuilder[Exported]

  model.enums.foreach { e =>
    val numericType = e.intType.getOrElse(CType.Int)
    val st = scalaType(numericType)

    e.values.foreach { case (name, value) =>
      exports += Exported.Yes(name)
      if numericType.sign == SignType.Signed then
        line(s"val $name: $st = $value")
      else
        val extension = numericType.base match
          case IntegralBase.Int                          => "Int"
          case IntegralBase.Long | IntegralBase.LongLong => "Long"
          case IntegralBase.Short                        => "Short"
          case IntegralBase.Char                         => "Byte"
        line(s"val $name: $st = $value.toU$extension")
    }
    line("")
  }

  if model.macros.nonEmpty then
    if model.enums.nonEmpty then line("")
    model.macros.foreach:
      case MacroDefinition.Floating(name, sign, digits, value, kind) => ???
      case a @ MacroDefinition.Integral(name, sign, kind, digits, value, lit) =>
        exports += Exported.Yes(name)
        val signStr = if value == Sign.Neg then "-" else ""

        import SignType.*, IntegralBase.*,
          LiteralBase.{None as NoLiteral, Hex, Binary, Oct}

        enum Inlining:
          case Yes, No

        import Inlining.*

        import java.lang.Long as JLong

        val (inlining: Inlining, repr: String, comment: Option[String]) =
          (sign, kind, lit) match
            case (Signed, Int, NoLiteral) => (Yes, signStr + digits, None)
            case (Signed, Long, NoLiteral) =>
              (Yes, signStr + digits + "L", None)
            case (Signed, LongLong, NoLiteral) =>
              (Yes, signStr + digits + "L", None)
            case (Signed, Int, Hex) => (Yes, signStr + "0x" + digits, None)
            case (Signed, Long, Hex) =>
              (Yes, signStr + "0x" + digits + "L", None)
            case (Signed, LongLong, Hex) =>
              (Yes, signStr + "0x" + digits + "L", None)

            case (Signed, Int, Binary) =>
              (
                Yes,
                signStr + Integer.parseInt(digits, 2).toString,
                Some(s"Converted from binary: $signStr$digits")
              )
            case (Signed, Long, Binary) =>
              (
                Yes,
                signStr + JLong.parseLong(digits, 2).toString,
                Some(s"Converted from binary: $signStr$digits")
              )
            case (Signed, LongLong, Binary) =>
              (
                Yes,
                signStr + JLong.parseLong(digits, 2).toString,
                Some(s"Converted from binary: $signStr$digits")
              )

            case (Signed, Int, Oct) =>
              (
                Yes,
                signStr + Integer.parseInt(digits, 8).toString,
                Some(s"Converted from octal: $signStr$digits")
              )
            case (Signed, Long, Oct) =>
              (
                Yes,
                signStr + JLong.parseLong(digits, 8).toString,
                Some(s"Converted from octal: $signStr$digits")
              )
            case (Signed, LongLong, Oct) =>
              (
                Yes,
                signStr + JLong.parseLong(digits, 8).toString,
                Some(s"Converted from octal: $signStr$digits")
              )

            case (Unsigned, Int, NoLiteral) =>
              (
                No,
                s"UInt.valueOf(${Integer.parseUnsignedInt(digits)})",
                Some(s"Converted from unsigned int: $digits")
              )
            case (Unsigned, Long, NoLiteral) =>
              (
                No,
                s"ULong.valueOf(${JLong.parseUnsignedLong(digits)}L)",
                Some(s"Converted from unsigned long: $digits")
              )
            case (Unsigned, LongLong, NoLiteral) =>
              (
                No,
                s"ULong.valueOf(${JLong.parseUnsignedLong(digits)}L)",
                Some(s"Converted from unsigned long: $digits")
              )

            case (Unsigned, Int, Hex) =>
              (
                No,
                s"UInt.valueOf(${Integer.parseUnsignedInt(java.math.BigInteger(digits, 16).toString)})",
                Some(s"Converted from unsigned hex int: $digits")
              )
            case (Unsigned, Long, Hex) =>
              (
                No,
                s"ULong.valueOf(${JLong.parseUnsignedLong(java.math.BigInteger(digits, 16).toString)})",
                Some(s"Converted from unsigned hex long: $digits")
              )
            case (Unsigned, LongLong, Hex) =>
              (
                No,
                s"ULong.valueOf(${JLong.parseUnsignedLong(java.math.BigInteger(digits, 16).toString)})",
                Some(s"Converted from unsigned hex long: $digits")
              )
            case (Unsigned, Int, Binary) =>
              (
                No,
                s"UInt.valueOf(${Integer.parseUnsignedInt(java.math.BigInteger(digits, 2).toString)})",
                Some(s"Converted from unsigned binary int: $digits")
              )
            case (Unsigned, Long, Binary) =>
              (
                No,
                s"ULong.valueOf(${JLong.parseUnsignedLong(java.math.BigInteger(digits, 2).toString)})",
                Some(s"Converted from unsigned binary long: $digits")
              )
            case (Unsigned, LongLong, Binary) =>
              (
                No,
                s"ULong.valueOf(${JLong.parseUnsignedLong(java.math.BigInteger(digits, 2).toString)})",
                Some(s"Converted from unsigned binary long: $digits")
              )

            case (Unsigned, Int, Oct) =>
              (
                No,
                s"UInt.valueOf(${Integer.parseUnsignedInt(java.math.BigInteger(digits, 8).toString)})",
                Some(s"Converted from unsigned octal int: $digits")
              )
            case (Unsigned, Long, Oct) =>
              (
                No,
                s"ULong.valueOf(${JLong.parseUnsignedLong(java.math.BigInteger(digits, 8).toString)})",
                Some(s"Converted from unsigned octal long: $digits")
              )
            case (Unsigned, LongLong, Oct) =>
              (
                No,
                s"ULong.valueOf(${JLong.parseUnsignedLong(java.math.BigInteger(digits, 8).toString)})",
                Some(s"Converted from unsigned octal long: $digits")
              )

        comment.foreach: com =>
          line("/**")
          line(s"* $com")
          line("*/")

        if inlining == Yes then line(s"inline val $name = $repr")
        else line(s"val $name = $repr")
  end if

  exports.result()
end constants
