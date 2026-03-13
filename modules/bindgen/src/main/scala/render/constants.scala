package bindgen
package rendering

def constants(model: Constants, line: Appender)(using
    Config,
    AliasResolver
) =
  model.enums.foreach { e =>
    val numericType = e.intType.getOrElse(CType.Int)
    val st = scalaType(numericType)

    e.values.foreach { case (name, value) =>
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
        val signStr = if value == Sign.Neg then "-" else ""
        val (baseStr, newDigits, comment) = lit match
          case LiteralBase.None => ("", digits, Option.empty[String])
          case LiteralBase.Hex  => ("0x", digits, None)
          case LiteralBase.Binary =>
            (
              "",
              Integer.parseInt(digits, 2).toString,
              Some(s"Converted from binary: $signStr${digits}")
            )

        val postStr = kind match
          case IntegralBase.Int      => ""
          case IntegralBase.Long     => "L"
          case IntegralBase.LongLong => "L"

        comment.foreach: com =>
          line("/**")
          line(s"* $com")
          line("*/")
        sign match
          case SignType.Signed =>
            line(s"inline val $name = $signStr$baseStr$newDigits$postStr")
          case SignType.Unsigned =>
            val (accessor, parsedDigits, comment) = kind match
              case IntegralBase.Int =>
                (
                  "UInt",
                  Integer.parseUnsignedInt(newDigits).toString,
                  s"Parsed from unsigned int: $newDigits"
                )
              case IntegralBase.Long | IntegralBase.LongLong =>
                (
                  "ULong",
                  java.lang.Long.parseUnsignedLong(newDigits).toString,
                  s"Parsed from unsigned long: $newDigits"
                )

            line("/**")
            line(s"* $comment")
            line("*/")

            line(
              s"val $name = $signStr$accessor.valueOf($baseStr$parsedDigits)"
            )
        end match

  end if
end constants
