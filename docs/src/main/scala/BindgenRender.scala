package bindgen

import os.ProcessOutput

object BindgenRender:
  lazy val binary = sys.env("BINDGEN_BINARY")

  private def sideBySide(
      filename: String,
      cSource: String,
      scalaSource: String,
      generatedCSource: Option[String] = None
  ) =
    val head =
      """<div style = "display:flex;width:100%; font-size:16px; justify-content: space-between;">"""
    val c =
      s"""<div style = "width: 40%; text-align: left"><b>$filename</b><pre><code class = "hljs language-c">""" + cSource
        .replace("\n", "<br />") + "</pre></code></div>"
    val scala =
      """<div style = "overflow: scroll;"><b>Generated Scala</b><div style = "max-height:400px"><pre><code class = "hljs language-scala">""" + scalaSource + "</code></pre></div></div>"
    val foot = "</div>"

    val generatedC =
      generatedCSource.map { code =>
        """<div style = "overflow: scroll;"><b>Generated C</b><div style = "max-height:400px"><pre><code class = "hljs">""" + code + "</code></pre></div></div>"
      }

    head + c + """<div style = "width:55%">""" + scala + generatedC.getOrElse(
      ""
    ) + "</div>" + foot
  end sideBySide

  def safe(s: String) =
    s.replace(">", "&gt;").replace("<", "&lt;").replace("#", "&#35;")

  def render(
      cSource: String,
      packageName: String,
      filename: Option[String] = None
  ) =
    val p = os.temp.apply(cSource, deleteOnExit = false, suffix = "header.h")
    val cmd =
      Seq(binary, "--package", packageName, "--header", p.toString, "--scala")
    val cmdC =
      Seq(binary, "--package", packageName, "--header", p.toString, "--c")

    val generatedScala = StringBuilder()

    scala.util.Try(
      os.proc(cmd)
        .call(
          os.pwd,
          stdout =
            ProcessOutput.Readlines(str => generatedScala.append(str + "<br>"))
        )
    )
    val generatedC = StringBuilder()

    scala.util.Try(
      os.proc(cmdC)
        .call(
          os.pwd,
          stdout = ProcessOutput.Readlines(str =>
            generatedC.append(safe(str) + "<br>")
          )
        )
    )

    val hasC =
      generatedC.result.linesIterator.exists(_.trim != "<br>")

    sideBySide(
      filename.getOrElse("C header"),
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
