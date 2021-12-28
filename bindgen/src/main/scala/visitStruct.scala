package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*
import libclang.enumerations.*
import scala.collection.mutable.ListBuffer

def visitStruct(cursor: CXCursor, name: String)(using Zone): Def.Struct =
  val mem = stackalloc[Def.Struct](1)
  !mem = Def.Struct(ListBuffer.empty, name)
  // zone {
    // println(s"Deez nuts ($name): " + clang_getCursorSpelling(cursor).string)
    // println(constructType(clang_getCursorType(cursor)))
    // println(clang_Cursor_isAnonymousRecordDecl(cursor))
    // println(clang_Cursor_isAnonymous(cursor))
  // }
  clang_visitChildren(
    cursor,
    CXCursorVisitor { (cursor: CXCursor, parent: CXCursor, d: CXClientData) =>
      zone {
        if cursor.kind == CXCursorKind.CXCursor_FieldDecl then
          val s = clang_getCursorSpelling(cursor).string
          val builder = !d.unwrap[Def.Struct]
          // println(s"$s: ${constructType(clang_getCursorType(cursor))}")

          builder.fields.addOne(s -> constructType(clang_getCursorType(cursor)))
          CXChildVisitResult.CXChildVisit_Continue
        else CXChildVisitResult.CXChildVisit_Recurse
      }
    },
    CXClientData.wrap(mem)
  )

  (!mem)
end visitStruct
