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

  type AllowedIntegral =
    IntegralBase.Int.type | IntegralBase.Long.type | IntegralBase.LongLong.type
  type AllowedFloatingLiteral =
    LiteralBase.Dec.type | LiteralBase.Hex.type
end MacroDefinition
