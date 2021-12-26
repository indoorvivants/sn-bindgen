import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import scala.language.implicitConversions
import libclang.defs.*

@main def hello(file: String) =

  inline def zone(inline f: Zone ?=> Unit) = Zone.apply(z => f(using z))

  zone {
    val filename = toCString(file)
    val index = clang_createIndex(0, 0)
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
        CXCursorVisitor {
          (cursor: CXCursor, parent: CXCursor, _: CXClientData) =>
            zone {
              val spelling = clang_getCursorSpelling(cursor).string
              val typ = clang_getCursorKindSpelling(cursor.kind).string
              println(
                s"Cursor kind is ${cursor.kind} Name of cursor is $spelling and the type is $typ"
              )
            }

            CXChildVisitResult.CXChildVisit_Recurse
        },
        CXClientData.NULL
      )

    clang_disposeTranslationUnit(unit)
    clang_disposeIndex(index)
  }
end hello
