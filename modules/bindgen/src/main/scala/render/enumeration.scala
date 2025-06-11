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

  renderComment(line, model.meta)
  line(s"opaque type $opaqueType = $underlyingTypeRender")
  objectBlock(line)(s"object $opaqueType extends $traitName[$opaqueType]") {
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
    defBlock(line)(
      s"inline def getName(inline value: $opaqueType): Option[String] ="
    ) {
      defBlock(line)("inline value match") {
        model.values.foreach { case (constName, value) =>
          line(s"""case ${escape(constName)} => Some("${escape(constName)}")""")
        }
        line("case _ => _root_.scala.None")
      }
    }
    defBlock(line)(s"extension (a: $opaqueType)") {
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

      line(s"inline def &(b: $opaqueType): $opaqueType = ${wrap("a & b")}")
      line(s"inline def |(b: $opaqueType): $opaqueType = ${wrap("a | b")}")
      line(s"inline def is(b: $opaqueType): Boolean = (a & b) == b")
    }
  }

  Exported.Yes(opaqueType.value)
end enumeration
