package bindgen.rendering

import bindgen.*

def enumeration(model: Def.Enum, line: Appender)(using
    Config,
    AliasResolver
) =
  val values = List.newBuilder[(String, String)]
  val opaqueType = model.name.get
  val numericType = model.intType.getOrElse(CType.Int)
  val enumSuffix = if numericType.sign == SignType.Unsigned then "U" else ""
  val underlyingTypeRender = scalaType(numericType)
  line(s"opaque type $opaqueType = $underlyingTypeRender")
  line(s"object $opaqueType extends CEnum$enumSuffix[$opaqueType]:")

  nest {
    if numericType.sign == SignType.Signed then
      line(
        s"inline def define(inline a: $underlyingTypeRender): $opaqueType = a"
      )
    else
      val extension = numericType.base match
        case IntegralBase.Int   => "Int"
        case IntegralBase.Long  => "Long"
        case IntegralBase.Short => "Short"
        case IntegralBase.Char  => "Byte"
      line(
        s"inline def define(inline a: Long): $opaqueType = a.toU$extension"
      )
    end if
    model.values.foreach { case (constName, value) =>
      val lhs = s"val $constName"
      val rhs = "define(" + value.toString + ")"

      line(lhs + " = " + rhs)
    }
  }
end enumeration

