package bindgen

import os.ProcessOutput

import scalatags.Text.all.*

object BindgenRender:
  lazy val binary =
    val resource = getClass.getResource("/bindgen.binary.path")
    val path = scala.io.Source.fromURL(resource).mkString.trim
    path

  def escapeHtml(s: String): String =
    val pattern = """([&<>"])""".r
    val replacements =
      Map("&" -> "&amp;", "<" -> "&lt;", ">" -> "&gt;", "\"" -> "&quot;")
    pattern.replaceAllIn(s, m => replacements(m.group(1)))
  end escapeHtml

  private def sideBySide(
      filename: String,
      cSource: String,
      scalaSource: String,
      generatedCSource: Option[String] = None
  ) =
    val genCCode = generatedCSource
      .map { cs =>
        s"""
          |**Generated `C` code**
          |```c
          |${cs}
          |```
          """.trim.stripMargin
      }
      .getOrElse("")

    s"""
    |
    |
    |<div class = "flex-col w-full gap-4">
    |<div class = "w-12/12">
    |
    |**Source `C` code**
    |```c
    |${cSource}
    |```
    |
    |</div>
    |
    |<div class = "w-12/12">
    |
    |**Generated `Scala` code**
    |```scala
    |${scalaSource}
    |```
    |
    |$genCCode
    |
    |</div>
    |</div>
    |
    """.stripMargin

  end sideBySide

  def safe(s: String) =
    s.replace(">", "&gt;")
      .replace("<", "&lt;")
      .replace("#", "&#35;")
      .replace('"'.toString(), "&quot;")

  def render(
      cSource: String,
      packageName: String,
      extra: String*
  ): String = render(cSource, packageName, None, extra*)

  def render(
      cSource: String,
      packageName: String,
      filename: Option[String],
      extra: String*
  ): String =
    val p = os.temp.apply(cSource, deleteOnExit = false, suffix = "header.h")
    val cmd =
      Seq(
        binary,
        "--package",
        packageName,
        "--header",
        p.toString,
        "--scala"
      ) ++ extra
    val cmdC =
      Seq(
        binary,
        "--package",
        packageName,
        "--header",
        p.toString,
        "--c"
      ) ++ extra

    val generatedScala = StringBuilder()

    scala.util.Try(
      os.proc(cmd)
        .call(
          os.pwd,
          stdout =
            ProcessOutput.Readlines(str => generatedScala.append(str + "\n"))
        )
    )
    val generatedC = StringBuilder()

    scala.util.Try(
      os.proc(cmdC)
        .call(
          os.pwd,
          stdout = ProcessOutput.Readlines(str => generatedC.append(str + "\n"))
        )
    )

    val hasC =
      generatedC.result.trim.nonEmpty // generatedC.result.linesIterator.exists(_.trim != "<br>")

    sideBySide(
      filename.getOrElse("C file"),
      cSource,
      generatedScala.result,
      Option.when(hasC)(generatedC.result)
    )
  end render

  def help() =
    "<pre><code class='hljs language-text'>" +
      safe(
        os.proc(Seq(binary, "--help"))
          .call(mergeErrIntoOut = true, check = false)
          .out
          .text()
      ) + "</code></pre>"

end BindgenRender
