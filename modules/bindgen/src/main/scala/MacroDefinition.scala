package bindgen

import libclang.CXTokenKind

import scala.util.boundary

enum LiteralBase:
  case None, Hex, Binary, Oct

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
      sign: SignType,
      digits: String,
      value: Sign,
      kind: FloatingBase
  ) extends MacroDefinition(name)

  def getName = _name
end MacroDefinition

object MacroDefinition:
  private type AllowedIntegral = IntegralBase.Int.type |
    IntegralBase.Long.type | IntegralBase.LongLong.type
  def fromTokens(name: String, tokens: List[(CXTokenKind, String)])(using
      Config
  ) =
    val noComments = tokens.collect {
      case (tok, value) if tok != CXTokenKind.CXToken_Comment =>
        tok -> value
    }

    def justDigits(digits: String) =
      val (suffix, cleanDigits) =
        var suff = ""
        var i = digits.length() - 1
        val allowed = Set('u', 'U', 'l', 'L')
        inline def stop = i <= 0 || !(allowed(digits(i)))
        while !stop do
          suff += digits(i)
          i -= 1
        (suff.toLowerCase(), digits.take(digits.length - suff.length))

      info(suffix)

      val signType =
        if suffix.contains('u') then SignType.Unsigned
        else SignType.Signed
      val intBase: AllowedIntegral =
        if suffix.contains("ll") then IntegralBase.LongLong
        else if suffix.contains('l') then IntegralBase.Long
        else IntegralBase.Int

      (digits = cleanDigits, signType = signType, int = intBase)
    end justDigits

    inline def isDigit(c: Char) =
      (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || c == 'l' || c == 'L' || c == 'u' || c == 'U'

    def produce(value: Sign, digits: String) =
      def integral(lit: LiteralBase, d: String) =
        val read = justDigits(d)
        Some(
          MacroDefinition.Integral(
            name,
            read.signType,
            read.int,
            read.digits,
            value,
            lit
          )
        )
      end integral

      digits match
        case s"0x$rest" =>
          integral(LiteralBase.Hex, rest)
        case s"0X$rest" =>
          integral(LiteralBase.Hex, rest)
        case s"0b$rest" =>
          integral(LiteralBase.Binary, rest)
        case s"0B$rest" =>
          integral(LiteralBase.Binary, rest)
        case s"0$rest" if rest.nonEmpty && rest.forall(isDigit) =>
          integral(LiteralBase.Oct, digits)
        case rest if rest.forall(isDigit) =>
          integral(LiteralBase.None, digits)
        case _ => None
      end match
    end produce

    import CXTokenKind.*
    def withSign(tokens: List[(CXTokenKind, String)]) =
      tokens match
        case (CXToken_Punctuation, "-") :: (CXToken_Literal, digits) :: Nil =>
          produce(Sign.Neg, digits.filterNot(_ == '\''))
        case (CXToken_Literal, digits) :: Nil =>
          produce(Sign.Pos, digits.filterNot(_ == '\''))

        case other =>
          warning(
            s"Macro constant $name is ignored as it can't be parsed: ${other.map(_._2).mkString}"
          )
          None

    end withSign

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
          case (CXToken_Literal, digs)
              if digs.forall(d => isDigit(d) || d == '\'') =>
            newLiteral += digs.replace("'", "")
          case _ => boundary.break(None)

        if newLiteral == "" then boundary.break(None)
        withSign(head ++ List((CXToken_Literal, newLiteral)))
    end coalesce

    withSign(noComments).orElse(coalesce(noComments))
  end fromTokens
end MacroDefinition
