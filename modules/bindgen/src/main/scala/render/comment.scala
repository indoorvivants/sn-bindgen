package bindgen
package rendering

def renderComment(line: Appender, meta: Meta)(using config: Config) =
  val hasDoc = meta.comment.exists(_.value.trim().nonEmpty)
  val shouldRenderComment =
    config.rendering.comments == RenderComments.Yes && hasDoc

  val shouldRenderLocation = config.rendering.location == RenderLocation.Yes

  if shouldRenderComment || shouldRenderLocation then
    if meta.comment.nonEmpty || meta.file.nonEmpty then line("/**")

    if shouldRenderComment then
      meta.comment.foreach { comment =>
        val lines = comment.value.linesIterator
        lines.foreach { l => line(" * " + l) }

      }

    meta.file.foreach { file =>
      if shouldRenderLocation then
        if meta.comment.nonEmpty && shouldRenderComment then line("")
        line(s" * [bindgen] header: $file")
    }
    if meta.comment.nonEmpty || meta.file.nonEmpty then line("*/")
  end if
end renderComment
