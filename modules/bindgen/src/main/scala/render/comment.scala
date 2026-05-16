package bindgen
package rendering

def renderComment(line: Appender, meta: Meta)(using config: Config) =
  val hasDoc = meta.comment.nonEmpty
  val shouldRenderComment =
    config.rendering.comments == RenderComments.Yes && hasDoc

  val shouldRenderLocation = config.rendering.location == RenderLocation.Yes

  if shouldRenderLocation then
    meta.file.foreach { file =>
      line(s"// [bindgen] header: $file")
    }

  if shouldRenderComment then
    meta.comment.foreach: comm =>
      comm.value.linesIterator.foreach(line(_))
end renderComment
