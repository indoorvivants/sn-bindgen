package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*
import libclang.enumerations.*
import scala.collection.mutable.ListBuffer

class StructCollector(val struct: Def.Struct, var numAnonymous: Int)

def visitStruct(cursor: CXCursor, name: String)(using
    Zone,
    Config
): Def.Struct =
  val mem = Captured.allocate[StructCollector](
    StructCollector(Def.Struct(ListBuffer.empty, name, ListBuffer.empty), 0)
  )

  clang_visitChildren(
    cursor,
    CXCursorVisitor { (cursor: CXCursor, parent: CXCursor, d: CXClientData) =>
      // zone {
      val (collector, zone, config) = !d.unwrap[Captured[StructCollector]]
      given Zone = zone
      given Config = config

      val builder = collector.struct
      if cursor.kind == CXCursorKind.CXCursor_FieldDecl then
        val fieldName = clang_getCursorSpelling(cursor).string
        val typ = clang_getCursorType(cursor)
        val decl = clang_getTypeDeclaration(typ)
        val isAnonymous = clang_Cursor_isAnonymous(decl) == 1.toUInt
        if isAnonymous then
          // errln(
          //   s"anonymous type: ${builder.name} / $fieldName: ${constructType(clang_getCursorType(cursor))} "
          // )
          val last = builder.anonymous.apply(collector.numAnonymous)
          val nestedName = last match
            case un: Def.Union  => un.name
            case st: Def.Struct => st.name
          builder.fields.addOne(
            fieldName -> CType.Reference(
              Name.Model(s"${builder.name}.$nestedName")
            )
          )
          collector.numAnonymous += 1
        else
          builder.fields.addOne(
            fieldName -> constructType(clang_getCursorType(cursor))
          )
        end if

        CXChildVisitResult.CXChildVisit_Continue
      else if cursor.kind == CXCursorKind.CXCursor_UnionDecl then
        // errln(s"Union: " + clang_getCursorSpelling(cursor).string)
        val str = visitStruct(cursor, "Union")
        builder.anonymous.addOne(
          Def.Union(
            str.fields,
            "Union" + builder.anonymous.size
          )
        )
        CXChildVisitResult.CXChildVisit_Continue
      else if cursor.kind == CXCursorKind.CXCursor_StructDecl then
        // errln(s"Struct: " + clang_getCursorSpelling(cursor).string)
        val str = visitStruct(cursor, "Union")
        builder.anonymous.addOne(
          Def.Struct(
            str.fields,
            "Struct" + builder.anonymous.size,
            str.anonymous
          )
        )
        CXChildVisitResult.CXChildVisit_Continue
      else CXChildVisitResult.CXChildVisit_Continue
      end if
    // }
    },
    CXClientData.wrap(mem)
  )

  (!mem)._1.struct
end visitStruct
