package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import scala.collection.mutable

import libclang.*, fluent.*

def visitEnum(rootCursor: CXCursor, isTypeDef: Boolean)(using
    Zone,
    Config
): bindgen.Def.Enum =
  val intType =
    Option(constructType(clang_getEnumDeclIntegerType(rootCursor))).collect {
      case n: CType.NumericIntegral => n
    }

  val (ptr, memory) = Captured.unsafe[DefBuilder.Enum](
    DefBuilder.Enum(
      mutable.ListBuffer.empty,
      name = None,
      intType = intType,
      meta = extractMetadata(rootCursor)
    )
  )
  val typ = clang_getCursorType(rootCursor)
  val name = clang_getTypeSpelling(typ).string

  if clang_Cursor_isAnonymous(rootCursor) == 0.toUInt then
    (!ptr)._1.name = Some(
      EnumName(if name.startsWith("enum ") then name.drop(5) else name)
    )

  val visitor =
    CXCursorVisitorPtr {
      (cursorPtr: Ptr[CXCursor], parent: Ptr[CXCursor], d: CXClientData) =>
        val (ref, config) = !d.unwrap[Captured[DefBuilder.Enum]]
        val cursor = !cursorPtr

        given Config = config

        zone {
          if cursor.kind == CXCursorKind.CXCursor_EnumConstantDecl then
            val enumConstant = clang_getCursorSpelling(cursorPtr).string
            ref.values.addOne(
              enumConstant -> clang_getEnumConstantDeclValue(cursorPtr)
            )
            CXChildVisitResult.CXChildVisit_Continue
          else CXChildVisitResult.CXChildVisit_Recurse
        }
    }

  try
    libclang.fluent.clang_visitChildren(
      rootCursor,
      visitor,
      CXClientData.wrap(ptr)
    )
    (!ptr)._1.build
  finally memory.deallocate()
end visitEnum
