package bindgen

object render:
  def enumeration(model: Def.Enum, appendLine: String => Unit)(using
      config: Config
  ) =
    val values = List.newBuilder[(String, String)]
    val opaqueType = model.name
    val finalizer = if model.values.nonEmpty then ":" else ""
    appendLine(s"opaque type $opaqueType = Int") // TODO refine
    appendLine(s"object $opaqueType extends CEnum[$opaqueType]$finalizer")

    model.values.foreach { case (constName, value) =>
      val lhs = s"val $constName: $opaqueType"
      val rhs = value.toString

      appendLine(indent + lhs + " = " + rhs)
    }
  end enumeration
  def indent(using c: Config): String = " " * c.indent
end render

case class Config(indent: Int = 2)
