package libclang

import defs.*
import types.*
import scala.scalanative.unsafe.Zone
import scala.annotation.targetName
import scala.scalanative.unsigned.*

object fluent:
  extension (cursor: CXCursor)
    def location(using Zone): CXSourceLocation = clang_getCursorLocation(cursor)
    def spelling(using Zone): String = clang_getCursorSpelling(cursor).string
    def tpe(using Zone): CXType = clang_getCursorType(cursor)

  extension (tpe: CXType)
    @targetName("tpe_spelling")
    def spelling(using Zone): String = clang_getTypeSpelling(tpe).string
    def kindSpelling(using Zone): String = clang_getTypeKindSpelling(
      tpe.kind
    ).string

  extension (loc: CXSourceLocation)
    def isFromMainFile: Boolean = clang_Location_isFromMainFile(loc) == 1.toUInt
end fluent
