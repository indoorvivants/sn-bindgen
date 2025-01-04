package bindgen

import libclang.*

import scala.scalanative.unsafe.*

import fluent.*

def extractMetadata(cursor: CXCursor)(using Zone) =
  val file = stackalloc[CXFile]()
  clang_getSpellingLocation(
    clang_getCursorLocation(cursor),
    file,
    null,
    null,
    null
  )

  Meta(
    comment = Option(clang_Cursor_getBriefCommentText(cursor))
      .map(_.string)
      .filter(_ != null)
      .map(CommentText(_)),
    file = Option(clang_getFileName(!file).string)
      .filter(_ != null)
      .map(DefinitionFile(_))
  )
end extractMetadata
