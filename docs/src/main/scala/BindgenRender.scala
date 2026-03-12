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
          |<div class = "bindgen-generated-c">
          |<div class = "bindgen-generated-c-title">Glue C code</div>
          |
          |```c
          |${cs}
          |```
          |
          |</div>
          """.trim.stripMargin
      }
      .getOrElse("")

    s"""
    |
    |
    |<div class = "bindgen-comparison-container">
    |
    |<div class = "bindgen-original-c">
    |<div class = "bindgen-original-c-title">C code</div>
    |
    |```c
    |${cSource}
    |```
    |
    |</div>
    |</div>
    |
    |<div class = "bindgen-generated">
    |<div class = "bindgen-generated-scala">
    | <div class = "bindgen-generated-scala-title">Scala code</div>
    |
    |```scala
    |${scalaSource}
    |```
    |
    | </div>
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
        "--scala",
        "--render.no-location"
      ) ++ extra
    val cmdC =
      Seq(
        binary,
        "--package",
        packageName,
        "--header",
        p.toString,
        "--c",
        "--render.no-location"
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
          .call(
            mergeErrIntoOut = true,
            check = false,
            env = Map("NO_COLOR" -> "true")
          )
          .out
          .text()
      ) + "</code></pre>"

end BindgenRender
