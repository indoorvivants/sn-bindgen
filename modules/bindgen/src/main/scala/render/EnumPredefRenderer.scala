package bindgen
package rendering

class EnumPredefRenderer(
    base: Option[CType.NumericIntegral]
)(using Context, Config, AliasResolver):
  val safePackageName = packageName.split('.').last
  val intType: CType.NumericIntegral =
    base.getOrElse(CType.NumericIntegral(IntegralBase.Int, SignType.Signed))
  val renderedScalaType = scalaType(intType)
  val renderedTagName =
    val prefix = intType.sign match
      case SignType.Signed   => ""
      case SignType.Unsigned => "U"

    val bs = intType.base match
      case IntegralBase.Char     => "Byte"
      case IntegralBase.Short    => "Short"
      case IntegralBase.Int      => "Int"
      case IntegralBase.Long     => "Long"
      case IntegralBase.LongLong => "Long"

    prefix + bs
  end renderedTagName

  val traitName = enumBaseTraitName(intType)

  def render(lb: LineBuilder) =
    objectBlock(to(lb))(
      s"private[${safePackageName}] trait $traitName[T](using eq: T =:= $renderedScalaType)"
    ) {
      to(lb)(s"given Tag[T] = Tag.$renderedTagName.asInstanceOf[Tag[T]]")
      defBlock(to(lb))("extension (inline t: T)") {
        to(lb)(
          s"inline def value: $renderedScalaType = t.asInstanceOf[$renderedScalaType]"
        )
        if intType.base == IntegralBase.Int then
          to(lb)(s"inline def int: CInt = value.toInt")
        if intType.sign == SignType.Unsigned then
          to(lb)(s"inline def uint: CUnsignedInt = value")
      }
    }
end EnumPredefRenderer
