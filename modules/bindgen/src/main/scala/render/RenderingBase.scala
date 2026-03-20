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

  def createCStream(using Config, Context) =
    val lb = LineBuilder()
    lb.appendLine(
      s"// This file was generated using sn-bindgen ${BuildInfo.version}: https://sn-bindgen.indoorvivants.com/"
    )
    lb.emptyLine
    lb
  end createCStream

  def interspeseWithNewlines[T, A](out: LineBuilder, seq: Seq[T])(
      f: T => A
  ): Seq[A] =
    val res = Seq.newBuilder[A]
    seq.zipWithIndex.foreach { case (item, i) =>
      res += f(item)
      if i != seq.length - 1 then out.emptyLine
    }
    res.result()

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
