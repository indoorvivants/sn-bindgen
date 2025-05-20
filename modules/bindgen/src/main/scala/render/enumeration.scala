package bindgen
package rendering

def enumeration(model: Def.Enum, line: Appender)(using
    Config,
    AliasResolver
) =
  val values = List.newBuilder[(String, String)]
  val opaqueType = model.name.get
  val numericType = model.intType.getOrElse(CType.Int)
  val enumSuffix = if numericType.sign == SignType.Unsigned then "U" else ""
  val underlyingTypeRender = scalaType(numericType)
  val traitName = enumBaseTraitName(numericType)

  val openDelimiter =
    if summon[Config].bracesNotIndents.value then " {" else ":"
  val openDefDelimiter =
    if summon[Config].bracesNotIndents.value then "{" else ""
  def appendCloseDelimiter(): Unit =
    if summon[Config].bracesNotIndents.value then line("}") else ()

  renderComment(line, model.meta)
  line(s"opaque type $opaqueType = $underlyingTypeRender")
  line(s"object $opaqueType extends $traitName[$opaqueType]$openDelimiter")

  nest {
    line(s"given _tag: Tag[$opaqueType] = ${scalaTag(numericType)}")
    if numericType.sign == SignType.Signed then
      line(
        s"inline def define(inline a: $underlyingTypeRender): $opaqueType = a"
      )
    else
      val extension = numericType.base match
        case IntegralBase.Int                          => "Int"
        case IntegralBase.Long | IntegralBase.LongLong => "Long"
        case IntegralBase.Short                        => "Short"
        case IntegralBase.Char                         => "Byte"
      line(
        s"inline def define(inline a: Long): $opaqueType = a.toU$extension"
      )
    end if
    model.values.foreach { case (constName, value) =>
      val lhs = s"val ${escape(constName)}"
      val rhs = "define(" + value.toString + ")"

      line(lhs + " = " + rhs)
    }
    line(
      s"inline def getName(inline value: $opaqueType): Option[String] = $openDefDelimiter"
    )
    nest {
      line(s"inline value match $openDefDelimiter")
      nest {
        model.values.foreach { case (constName, value) =>
          line(s"""case ${escape(constName)} => Some("${escape(constName)}")""")
        }
        line("case _ => _root_.scala.None")
      }
      appendCloseDelimiter()
    }
    appendCloseDelimiter()
    line(s"extension (a: $opaqueType) $openDefDelimiter")
    def wrap(exp: String) =
      numericType match
        case CType.NumericIntegral(
              bindgen.IntegralBase.Char,
              SignType.Signed
            ) =>
          s"(($exp) & 0xff).toByte"
        case CType.NumericIntegral(
              bindgen.IntegralBase.Char,
              SignType.Unsigned
            ) =>
          s"(($exp) & 0xff.toUInt).toUByte"
        case _ => exp

    nest {
      line(s"inline def &(b: $opaqueType): $opaqueType = ${wrap("a & b")}")
      line(s"inline def |(b: $opaqueType): $opaqueType = ${wrap("a | b")}")
      line(s"inline def is(b: $opaqueType): Boolean = (a & b) == b")
    }
    appendCloseDelimiter()
  }
  appendCloseDelimiter()

  Exported.Yes(opaqueType.value)
end enumeration
