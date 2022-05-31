package bindgen

import libclang.defs.*
import libclang.enumerations.*
import libclang.types.*

import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import scalanative.libc.*

class StructCollector(val struct: DefBuilder.Struct, var numAnonymous: Int)

def visitStruct(cursor: CXCursor, name: String)(using
    Zone,
    Config
): Def.Struct =
  val mem = Captured.allocate[StructCollector](
    StructCollector(
      DefBuilder.Struct(ListBuffer.empty, StructName(name), ListBuffer.empty),
      0
    )
  )

  clang_visitChildren(
    cursor,
    CXCursorVisitor { (cursor: CXCursor, parent: CXCursor, d: CXClientData) =>
      val (collector, zone, config) = !d.unwrap[Captured[StructCollector]]
      given Zone = zone
      given Config = config

      val builder = collector.struct
      if cursor.kind == CXCursorKind.CXCursor_FieldDecl then
        val fieldName =
          StructParameterName(clang_getCursorSpelling(cursor).string)
        val typ = clang_getCursorType(cursor)
        val decl = clang_getTypeDeclaration(typ)
        val isAnonymous = clang_Cursor_isAnonymous(decl) == 1.toUInt
        if isAnonymous then
          val last = builder.anonymous.apply(collector.numAnonymous)
          val nestedName = last match
            case un: Def.Union  => un.name.value
            case st: Def.Struct => st.name.value
          builder.fields.addOne(
            fieldName -> CType.Reference(
              Name.Model(builder.name.value + "." + nestedName)
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
        val nestedName = "Union" + builder.anonymous.size
        val str = visitStruct(cursor, builder.name.value + "." + nestedName)
        builder.anonymous.addOne(
          Def.Union(
            str.fields.map { case (n, field) =>
              n.into(UnionParameterName) -> field
            },
            UnionName(nestedName),
            str.anonymous
          )
        )
        CXChildVisitResult.CXChildVisit_Continue
      else if cursor.kind == CXCursorKind.CXCursor_StructDecl then
        val nestedName = "Struct" + builder.anonymous.size
        val str = visitStruct(cursor, builder.name.value + "." + nestedName)
        builder.anonymous.addOne(
          Def.Struct(
            str.fields,
            StructName(nestedName),
            str.anonymous
          )
        )
        CXChildVisitResult.CXChildVisit_Continue
      else CXChildVisitResult.CXChildVisit_Continue
      end if
    },
    CXClientData.wrap(mem)
  )

  (!mem)._1.struct.build
end visitStruct
