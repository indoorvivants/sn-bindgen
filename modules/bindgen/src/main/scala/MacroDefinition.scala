package bindgen

import libclang.CXTokenKind

import scala.util.boundary

enum LiteralBase:
  case Dec, Hex, Binary, Oct

enum Sign:
  case Pos, Neg

enum MacroDefinition(_name: String):
  case Integral(
      name: String,
      sign: SignType,
      kind: MacroDefinition.AllowedIntegral,
      digits: String,
      value: Sign,
      lit: LiteralBase
  ) extends MacroDefinition(name)
  case Floating(
      name: String,
      digits: String,
      value: Sign,
      kind: FloatingBase
  ) extends MacroDefinition(name)

  case Unsupported(name: String, raw: String) extends MacroDefinition(name)
  case CStr(name: String, raw: String) extends MacroDefinition(name)

  def getName = _name
end MacroDefinition

object MacroDefinition:

  def fromTokens(name: String, tokens: List[(CXTokenKind, String)])(using
      Config
  ): MacroDefinition =
    val noComments = tokens.collect {
      case (tok, value) if tok != CXTokenKind.CXToken_Comment =>
        tok -> value
    }

    import CXTokenKind.*
    def withSign(tokens: List[(CXTokenKind, String)]) =
      tokens match
        case (CXToken_Literal, s"\"$rest\"") :: Nil =>
          boundary:
            for
              i <- 0 until rest.length
              c = rest(i)
            do
              if c == '"' && (i < 1 || rest(i - 1) != '\\') then
                boundary.break(None)

            Some(MacroDefinition.CStr(name, rest))

        case (CXToken_Punctuation, "-") :: (CXToken_Literal, digits) :: Nil =>
          val cleanDigits = "-" + digits.filterNot(_ == '\'')
          parseIntegral(cleanDigits).orElse(parseFloating(cleanDigits))
        case (CXToken_Literal, digits) :: Nil =>
          val cleanDigits = digits.filterNot(_ == '\'')
          parseIntegral(cleanDigits).orElse(parseFloating(cleanDigits))

        case _ =>
          None

    end withSign

    def parseIntegral(digits: String) =
      IntegerConstantParser
        .parse(digits)
        .toOption
        .map:
          case (
                sign,
                digits,
                (kind: MacroDefinition.AllowedIntegral, signed),
                lit
              ) =>
            MacroDefinition.Integral(name, signed, kind, digits, sign, lit)

    def parseFloating(digits: String) =
      FloatConstantParser
        .parse(digits)
        .toOption
        .map:
          case (
                digits,
                sign,
                base
              ) =>
            MacroDefinition.Floating(name, digits, sign, base)

    // This function assembles literals with apostrophes (e.g. 0'177'777) into a single literal
    // Clang sends this type of literal as multiple literal tokens that can contain apostrophes
    def coalesce(tokens: Seq[(CXTokenKind, String)]) =
      val (head, rest) = tokens match
        case (a @ (CXToken_Punctuation, "-")) :: rest =>
          (a :: rest, rest)
        case rest =>
          (Nil, rest)

      var newLiteral = ""

      boundary:
        rest.foreach:
          // Definition such as 0xFF'FF'FF'FFu produces token of all those 3 types :-/
          case (
                CXToken_Literal | CXToken_Punctuation | CXToken_Identifier,
                digs
              ) =>
            newLiteral += digs.replace("'", "")
          case _ =>
            boundary.break(None)

        if newLiteral == "" then boundary.break(None)
        withSign(head ++ List((CXToken_Literal, newLiteral)))
    end coalesce

    withSign(noComments)
      .orElse(coalesce(noComments))
      .getOrElse(
        MacroDefinition.Unsupported(name, noComments.map(_._2).mkString)
      )
  end fromTokens

  // private inline def isDigit(c: Char) =
  //   (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') ||
  //     (c >= 'A' && c <= 'F') || c == 'l' || c == 'L' ||
  //     c == 'u' || c == 'U' || c == 'x' || c == 'X' || c == 'B' || c == 'b'
  // end isDigit

  // private def parseFloating(
  //     name: String,
  //     value: Sign,
  //     digits: String
  // )(using Config): Option[MacroDefinition.Floating] =
  //   def floating(
  //       fb: FloatingBase,
  //       d: String
  //   ): Option[MacroDefinition.Floating] =
  //     Some(MacroDefinition.Floating(name, d, value, fb))
  //   boundary:
  //     def getKind(rest: String): (base: FloatingBase, rest: String) =
  //       lazy val dropped = rest.dropRight(1)
  //       rest.lastOption match
  //         case Some('f' | 'F')      => (FloatingBase.Float, dropped)
  //         case Some('l' | 'L')      => (FloatingBase.LongDouble, dropped)
  //         case Some(c) if c.isDigit => (FloatingBase.Double, rest)
  //         case None                 => (FloatingBase.Double, rest)
  //         case _                    => boundary.break(None)

  //     digits.toLowerCase() match
  //       case s"${significand}e$exp" =>
  //         val (sign, cleanedExp) = exp match
  //           case s"+$rest" => ("+", rest)
  //           case s"-$rest" => ("-", rest)
  //           case _         => ("", exp)

  //         trace(s"$name -- $sign -- $cleanedExp")

  //         val base = getKind(cleanedExp)

  //         val significandIsCorrect = significand.match
  //           case s"$first.$second" =>
  //             first.forall(_.isDigit) && second.forall(_.isDigit)
  //           case other => other.forall(_.isDigit)

  //         trace(s"$name -- $significand -- $base")

  //         if significandIsCorrect &&
  //           base.rest.forall(isDigit) &&
  //           base.rest.nonEmpty
  //         then
  //           val correctedSignificand =
  //             significand match
  //               case s".$rest" => s"0.$rest"
  //               case s"$rest." => s"$rest.0"

  //           floating(
  //             base.base,
  //             correctedSignificand + s"e$sign" +
  //               (if base.rest.isEmpty then "0" else base.rest)
  //           )
  //         else None
  //         end if

  //       case s"$significand.$rest" =>
  //         // basic decimal
  //         val base = getKind(rest)
  //         if significand.forall(_.isDigit) && base.rest.forall(isDigit) then
  //           floating(
  //             base.base,
  //             (if significand.isEmpty then "0" else significand) + "." +
  //               (if base.rest.isEmpty then "0" else base.rest)
  //           )
  //         else None

  //       case _ => None
  //     end match

  // end parseFloating

  // private def parseIntegral(name: String, value: Sign, digits: String) =
  //   def justDigits(digits: String) =
  //     val (suffix, cleanDigits) =
  //       var suff = ""
  //       var i = digits.length() - 1
  //       val allowed = Set('u', 'U', 'l', 'L')
  //       inline def stop = i <= 0 || !(allowed(digits(i)))
  //       while !stop do
  //         suff += digits(i)
  //         i -= 1
  //       (suff.toLowerCase(), digits.take(digits.length - suff.length))

  //     val signType =
  //       if suffix.contains('u') then SignType.Unsigned
  //       else SignType.Signed
  //     val intBase: AllowedIntegral =
  //       if suffix.contains("ll") then IntegralBase.LongLong
  //       else if suffix.contains('l') then IntegralBase.Long
  //       else IntegralBase.Int

  //     (digits = cleanDigits, signType = signType, int = intBase)
  //   end justDigits

  //   def integral(lit: LiteralBase, d: String) =
  //     val read = justDigits(d)
  //     Some(
  //       MacroDefinition.Integral(
  //         name,
  //         read.signType,
  //         read.int,
  //         read.digits,
  //         value,
  //         lit
  //       )
  //     )
  //   end integral

  //   def isHexDigit(c: Char) =
  //     c.isDigit || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')
  //   def isBinaryDigit(c: Char) = c == '0' || c == '1'

  //   def digitsMatching(pred: Char => Boolean, s: String) =
  //     val allowed = Set('u', 'U', 'l', 'L')
  //     val cleaned = s.reverse.dropWhile(allowed.contains)

  //     cleaned.forall(pred)

  //   digits match
  //     case s"0x$rest" if rest.nonEmpty && digitsMatching(isHexDigit, rest) =>
  //       integral(LiteralBase.Hex, rest)
  //     case s"0X$rest" if rest.nonEmpty && digitsMatching(isHexDigit, rest) =>
  //       integral(LiteralBase.Hex, rest)
  //     case s"0b$rest" if rest.nonEmpty && digitsMatching(isBinaryDigit, rest) =>
  //       integral(LiteralBase.Binary, rest)
  //     case s"0B$rest" if rest.nonEmpty && digitsMatching(isBinaryDigit, rest) =>
  //       integral(LiteralBase.Binary, rest)
  //     case s"0$rest" if rest.nonEmpty && digitsMatching(_.isDigit, rest) =>
  //       integral(LiteralBase.Oct, digits)
  //     case rest if rest.nonEmpty && digitsMatching(_.isDigit, rest) =>
  //       integral(LiteralBase.Dec, digits)
  //     case _ => None
  //   end match

  // end parseIntegral

  type AllowedIntegral =
    IntegralBase.Int.type | IntegralBase.Long.type | IntegralBase.LongLong.type
  type AllowedFloatingLiteral =
    LiteralBase.Dec.type | LiteralBase.Hex.type
end MacroDefinition
