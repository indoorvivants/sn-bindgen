package bindgen

import libclang.*

import scala.scalanative.unsafe.*

import fluent.*

def visitVariable(cursor: CXCursor)(using Zone, Config): Def.Variable =
  val typ = clang_getCursorType(cursor)
  val name = clang_getCursorSpelling(cursor).string
  val isConst = clang_isConstQualifiedType(typ).toInt != 0

  Def.Variable(
    name = name,
    typ = constructType(typ),
    isConst = isConst,
    meta = extractMetadata(cursor)
  )
end visitVariable
