package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*
import libclang.enumerations.*
import scala.collection.mutable

def visitEnum(cursor: CXCursor, isTypeDef: Boolean)(using Zone) =
  val mem = stackalloc[Def.Enum](1)
  !mem = Def.Enum(mutable.ListBuffer.empty, name = "", intType = None)
  zone {
    (!mem).intType =
      Option(constructType(clang_getEnumDeclIntegerType(cursor))).collect {
        case n: CType.NumericIntegral => n
      }
    val typ = clang_getCursorType(cursor)
    val name = clang_getTypeSpelling(typ).string
    (!mem).name = if name.startsWith("enum ") then name.drop(5) else name
  }

  clang_visitChildren(
    cursor,
    CXCursorVisitor { (cursor: CXCursor, parent: CXCursor, d: CXClientData) =>
      zone {
        if cursor.kind == CXCursorKind.CXCursor_EnumConstantDecl then
          val s = clang_getCursorSpelling(cursor).string
          val ref = !d.unwrap[Def.Enum]
          ref.values.addOne(
            s -> clang_getEnumConstantDeclValue(cursor)
          )
          CXChildVisitResult.CXChildVisit_Continue
        else CXChildVisitResult.CXChildVisit_Recurse
      }
    },
    CXClientData.wrap(mem)
  )
  !mem
end visitEnum
