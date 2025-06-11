package bindgen

import libclang.*
import scalanative.unsafe.*

// inspired from https://joshpeterson.github.io/blog/2017/identifying-a-forward-declaration-with-libclang/
def isForwardDeclaration(cursor: CXCursor): Boolean =
  Zone:
    val definition = clang_getCursorDefinition(cursor)
    val isNull = clang_equalCursors(definition, clang_getNullCursor()) != 0
    if isNull then true
    else clang_equalCursors(cursor, definition) == 0
