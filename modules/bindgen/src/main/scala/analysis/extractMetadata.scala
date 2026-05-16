package bindgen

import libclang.*

import scala.scalanative.unsafe.*

import fluent.*

def extractMetadata(cursor: CXCursor)(using Zone, Config) =
  val file = stackalloc[CXFile]()
  clang_getSpellingLocation(
    clang_getCursorLocation(cursor),
    file,
    null,
    null,
    null
  )

  val rawComment = Option(clang_Cursor_getRawCommentText(cursor))
    .map(_.string)
    .filter(_ != null)
    .map(_.trim.stripTrailing())
    .filter: trimmed =>
      trimmed.startsWith("/*") && trimmed.endsWith("*/")

  Meta(
    comment = rawComment.map(CommentTextWithMarkers(_)),
    file = Option(clang_getFileName(!file).string)
      .filter(_ != null)
      .map(DefinitionFile(_))
  )
end extractMetadata
