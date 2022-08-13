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
end constants
