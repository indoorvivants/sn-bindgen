import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*

inline def zone(inline f: Zone ?=> Unit) = Zone.apply(z => f(using z))

@main def hello(file: String) =
  zone {
    val filename = toCString(file)
    val index = clang_createIndex(0, 0)
    val l = List.newBuilder[String]
    val unit = clang_parseTranslationUnit(
      index,
      filename,
      null,
      0.toUInt,
      null,
      0.toUInt,
      CXTranslationUnit_Flags.CXTranslationUnit_None
    )

    val cursor = clang_getTranslationUnitCursor(unit)
    val storage = CXString.allocate(1)

    val ptr =
      clang_visitChildren(
        cursor,
        CXCursorVisitor { (cursor: CXCursor, parent: CXCursor, _: CXClientData) =>
          zone { 
            val spelling = clang_getCursorSpelling(cursor).string
            val typ = clang_getCursorKindSpelling(cursor.kind).string
            val t = clang_getCursorType(cursor)
            val spelling_typ = clang_getTypeSpelling(t).string
            println(
              s"Cursor kind is ${cursor.kind}\n Name of cursor is $spelling\n and the type is $typ, type is '$spelling_typ'"
            )
          }

          if cursor.kind == CXCursorKind.CXCursor_StructDecl then
            visitStruct(cursor)
            CXChildVisitResult.CXChildVisit_Continue
          else CXChildVisitResult.CXChildVisit_Recurse
        },
        CXClientData.NULL
      )

    clang_disposeTranslationUnit(unit)
    clang_disposeIndex(index)
  }
end hello

def visitStruct(cursor: CXCursor)(using z: Zone) =
  val l = List.newBuilder[String]
  zone {
    println(clang_getTypeSpelling(clang_getCursorType(cursor)).string)
    clang_visitChildren(
      cursor,
      CXCursorVisitor { (cursor: CXCursor, parent: CXCursor, _: CXClientData) =>
        zone {
          if cursor.kind == CXCursorKind.CXCursor_FieldDecl then
            val s = clang_getCursorSpelling(cursor).string
            println(s)
            println(z.isOpen)
        }

        CXChildVisitResult.CXChildVisit_Recurse

      },
      CXClientData.NULL
    )
  }
end visitStruct
