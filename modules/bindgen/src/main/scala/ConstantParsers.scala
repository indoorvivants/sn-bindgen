package bindgen

import parsley.Parsley
import parsley.character.*
import parsley.combinator.*
import parsley.syntax.character.{charLift, stringLift}
import parsley.syntax.zipped.*

import Parsley.atomic

private object shared:
  val sign = option(char('-').as(Sign.Neg)).map(_.getOrElse(Sign.Pos))
  val decimalString = stringOfSome(oneOf('0' to '9'))

object IntegerConstantParser:
  import shared.*
  val hexDigit = oneOf('0' to '9') | oneOf('a' to 'f') | oneOf('A' to 'F')
  val binDigit = oneOf('0', '1')
  val hexString = "0" *> ("x" | "X") *> stringOfSome(hexDigit)
  val qualifiers: Parsley[(MacroDefinition.AllowedIntegral, SignType)] =
    stringOfMany(oneOf('u', 'l', 'L', 'U')).map: f =>
      val lc = f.toLowerCase()
      val base: MacroDefinition.AllowedIntegral =
        if lc.contains("ll") then IntegralBase.LongLong
        else if lc.contains("l") then IntegralBase.Long
        else IntegralBase.Int
      val tpe = if lc.contains("u") then SignType.Unsigned else SignType.Signed
      (base, tpe)

  val hexNumber = (sign, hexString, qualifiers).zipped.map(_ :* LiteralBase.Hex)
  val binaryString = "0" *> ("b" | "B") *> stringOfSome(binDigit)
  val binaryNumber =
    (sign, binaryString, qualifiers).zipped.map(_ :* LiteralBase.Binary)
  val decimalNumber =
    (sign, decimalString, qualifiers).zipped.map(_ :* LiteralBase.Dec)
  val octalNumber =
    (sign, '0' *> decimalString, qualifiers).zipped.map(_ :* LiteralBase.Oct)

  val integralConstant =
    (atomic(hexNumber) |
      atomic(binaryNumber) |
      atomic(octalNumber) |
      decimalNumber) <* Parsley.eof

  def parse(n: String) = integralConstant.parse(n)
end IntegerConstantParser

object FloatConstantParser:
  import shared.*

  val qualifier =
    option(oneOf('f', 'F', 'l', 'L').map:
      case 'f' | 'F' => FloatingBase.Float
      case 'l' | 'L' => FloatingBase.LongDouble
    )
      .map(_.getOrElse(FloatingBase.Double))

  val decStringEmpty = stringOfMany(oneOf('0' to '9'))
  val sign = option(oneOf('-', '+').map:
    case '-' => Sign.Neg
    case '+' => Sign.Pos
  ).map(_.getOrElse(Sign.Pos))

  val exponent =
    ('e' <|> 'E') *> (sign, decimalString, qualifier).zipped

  val floatParser =
    ((
      (sign, decStringEmpty, option("."), decStringEmpty).zipped,
      exponent | qualifier
    ).zipped <* Parsley.eof).map:
      case ((signMaybe, significand, dotMaybe, rest), exponentOrQualifier) =>
        var basePart = ""
        dotMaybe match
          case Some(_) =>
            if significand.isEmpty then basePart += "0."
            else basePart += significand + "."

            if rest.isEmpty then basePart += "0"
            else basePart += rest
          case None =>
            basePart += significand
        end match

        val floating = exponentOrQualifier match
          case f: FloatingBase => f
          case (expSign, exp, qualifier) =>
            basePart += "e" + (if expSign == Sign.Neg then "-" else "") + exp
            qualifier

        (basePart, signMaybe, floating)

  def parse(n: String) = floatParser.parse(n)
end FloatConstantParser
