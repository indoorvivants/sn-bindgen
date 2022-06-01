package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*
import libclang.enumerations.*
import scala.collection.mutable

def visitEnum(cursor: CXCursor, isTypeDef: Boolean)(using
    Zone,
    Config
): bindgen.Def.Enum =
  val intType =
    Option(constructType(clang_getEnumDeclIntegerType(cursor))).collect {
      case n: CType.NumericIntegral => n
    }

  val (ptr, memory) = Captured.unsafe[DefBuilder.Enum](
    DefBuilder.Enum(
      mutable.ListBuffer.empty,
      name = None,
      intType = intType
    )
  )
  val typ = clang_getCursorType(cursor)
  val name = clang_getTypeSpelling(typ).string

  if clang_Cursor_isAnonymous(cursor) == 0.toUInt then
    (!ptr)._1.name = Some(
      EnumName(if name.startsWith("enum ") then name.drop(5) else name)
    )

  val visitor =
    CXCursorVisitor { (cursor: CXCursor, parent: CXCursor, d: CXClientData) =>
      val (ref, config) = !d.unwrap[Captured[DefBuilder.Enum]]

      given Config = config

      zone {
        if cursor.kind == CXCursorKind.CXCursor_EnumConstantDecl then
          val enumConstant = clang_getCursorSpelling(cursor).string
          ref.values.addOne(
            enumConstant -> clang_getEnumConstantDeclValue(cursor)
          )
          CXChildVisitResult.CXChildVisit_Continue
        else CXChildVisitResult.CXChildVisit_Recurse
      }
    }

  try
    clang_visitChildren(
      cursor,
      visitor,
      CXClientData.wrap(ptr)
    )
    (!ptr)._1.build
  finally memory.deallocate()
end visitEnum
