import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import scala.language.implicitConversions
import libclang.defs.*

@main def hello =
  val filename = c"header.c"

  Zone { implicit z =>
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
    import CXCursor.*
    println(cursor.kind)
    val ptr =
      CXCursorVisitor { (c: CXCursor, parent: CXCursor, _: CXClientData) =>
        println(c)

        CXChildVisitResult.CXChildVisit_Recurse
      }

    println(ptr.raw.apply(CXCursor.NULL, CXCursor.NULL, CXClientData.NULL))
    clang_visitChildren(
      cursor,
      ptr,
      CXClientData.NULL
    )
    clang_disposeTranslationUnit(unit)
    clang_disposeIndex(index)
  }
end hello
