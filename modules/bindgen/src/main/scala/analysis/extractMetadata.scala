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
    .flatMap:
      // regular javadoc style comment
      case trimmed if (trimmed.startsWith("/*") && trimmed.endsWith("*/")) =>
        Some(trimmed)
      case trimmed =>
        val lines = trimmed.linesIterator.toList.map(_.trim)
        if lines.forall(l => l.startsWith("///") || l.isEmpty) then
          Some(
            "/**\n" + lines
              .map("*" + _.stripPrefix("///"))
              .mkString("\n") + "\n*/"
          )
        else if lines.forall(l => l.startsWith("//!") || l.isEmpty) then
          Some(
            "/**\n" + lines
              .map("*" + _.stripPrefix("//!"))
              .mkString("\n") + "\n*/"
          )
        else None
        end if

  Meta(
    comment = rawComment.map(CommentTextWithMarkers(_)),
    file = Option(clang_getFileName(!file).string)
      .filter(_ != null)
      .map(DefinitionFile(_))
  )
end extractMetadata
