package bindgen
package rendering

trait RenderingBase:
  def createScalaStream(using Config, Context) =
    val lb = LineBuilder()
    lb.appendLine(s"package $packageName")
    lb.emptyLine
    lb.appendLine(
      s"// This file was generated using sn-bindgen ${BuildInfo.version}: https://sn-bindgen.indoorvivants.com/"
    )
    lb.emptyLine
    lb.append("""
      |import _root_.scala.scalanative.unsafe.*
      |import _root_.scala.scalanative.unsigned.*
      |import _root_.scala.scalanative.libc.*
      |import _root_.scala.scalanative.*
      """.stripMargin.trim)
    lb.emptyLines(2)

    lb
  end createScalaStream

  // wraps a block in the supplied object/class/trait if the render mode is such
  def maybeObjectBlock(out: LineBuilder, mode: RenderMode)(
      objectHeader: String
  )(
      f: Config ?=> Unit
  )(using Config) =
    lazy val openDelimiter: String =
      if summon[Config].useBraces.value then " {" else ":"
    lazy val closeDelimiter: Option[String] =
      if summon[Config].useBraces.value then Some("}") else None

    if mode == RenderMode.Objects then to(out)(s"$objectHeader$openDelimiter")
    nestIf(mode == RenderMode.Objects) {
      f
    }
    if mode == RenderMode.Objects then closeDelimiter.foreach(to(out))
  end maybeObjectBlock
end RenderingBase
