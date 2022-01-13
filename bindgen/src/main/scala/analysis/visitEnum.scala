package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*
import libclang.enumerations.*
import scala.collection.mutable

def visitEnum(cursor: CXCursor, isTypeDef: Boolean)(using Zone, Config) =
  val mem = Captured.allocate[Def.Enum](
    Def.Enum(
      mutable.ListBuffer.empty,
      name = None,
      intType =
        Option(constructType(clang_getEnumDeclIntegerType(cursor))).collect {
          case n: CType.NumericIntegral => n
        }
    )
  )
  val typ = clang_getCursorType(cursor)
  val name = clang_getTypeSpelling(typ).string
  if clang_Cursor_isAnonymous(cursor) == 0.toUInt then
    (!mem)._1.name = Some(
      if name.startsWith("enum ") then name.drop(5) else name
    )

  clang_visitChildren(
    cursor,
    CXCursorVisitor { (cursor: CXCursor, parent: CXCursor, d: CXClientData) =>
      val (ref, zone, config) = !d.unwrap[Captured[Def.Enum]]
      given Zone = zone
      given Config = config
      if cursor.kind == CXCursorKind.CXCursor_EnumConstantDecl then
        val enumConstant = clang_getCursorSpelling(cursor).string
        ref.values.addOne(
          enumConstant -> clang_getEnumConstantDeclValue(cursor)
        )
        CXChildVisitResult.CXChildVisit_Continue
      else CXChildVisitResult.CXChildVisit_Recurse
    },
    CXClientData.wrap(mem)
  )
  (!mem)._1
end visitEnum
