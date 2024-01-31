package bindgen

import libclang.*, fluent.*

import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import scalanative.libc.*

class StructCollector(val struct: DefBuilder.Struct, var numAnonymous: Int)

def visitStruct(cursor: CXCursor, name: String)(using
    Config,
    Zone
): Def.Struct =
  val (ptr, memory) = Captured.unsafe[StructCollector](
    StructCollector(
      struct = DefBuilder.Struct(
        fields = ListBuffer.empty,
        name = StructName(name),
        anonymous = ListBuffer.empty,
        meta = extractMetadata(cursor)
      ),
      numAnonymous = 0
    )
  )

  trace(s"visitStruct: ${cursor.spelling}")

  val visitor = CXCursorVisitorPtr {
    (cursorPtr: Ptr[CXCursor], parentPtr: Ptr[CXCursor], d: CXClientData) =>
      val (collector, config) = !d.unwrap[Captured[StructCollector]]
      given Config = config
      val cursor = !cursorPtr

      zone {

        val builder = collector.struct
        trace(s"Cursor kind: ${cursor.kind.spelling}")
        trace(s"Cursor: ${cursor.spelling}")
        if cursor.kind == CXCursorKind.CXCursor_FieldDecl then
          val fieldName =
            StructParameterName(clang_getCursorSpelling(cursor).string)
          val typ = clang_getCursorType(cursor)
          val decl = clang_getTypeDeclaration(typ)
          val isAnonymous = clang_Cursor_isAnonymous(decl) == 1.toUInt

          trace(s"Field name: $fieldName, ${builder.anonymous}")
          trace(
            s"typ spelling: ${typ.kindSpelling}, ${decl.spelling}, anonymous $isAnonymous"
          )
          if isAnonymous then
            val last = builder.anonymous.apply(collector.numAnonymous)
            val nestedName = last match
              case un: Def.Union  => un.name.value
              case st: Def.Struct => st.name.value
              case en: Def.Enum   => en.name.get.value
            builder.fields.addOne(
              fieldName -> CType.Reference(
                Name.Model(builder.name.value + "." + nestedName)
              )
            )
            collector.numAnonymous += 1
          else if typ.kind == CXTypeKind.CXType_ConstantArray && builder.anonymous.size > collector.numAnonymous
          then
            val last = builder.anonymous.apply(collector.numAnonymous)
            val nestedName = last match
              case un: Def.Union  => un.name.value
              case st: Def.Struct => st.name.value
            val numElements = clang_getArraySize(typ)

            builder.fields.addOne(
              fieldName -> constArrayType(
                CType.Reference(
                  Name.Model(builder.name.value + "." + nestedName)
                ),
                numElements
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
              fields = str.fields.map { case (n, field) =>
                n.into(UnionParameterName) -> field
              },
              name = UnionName(nestedName),
              anonymous = str.anonymous,
              meta = extractMetadata(cursor)
            )
          )
          CXChildVisitResult.CXChildVisit_Continue
        else if cursor.kind == CXCursorKind.CXCursor_StructDecl then
          val nestedName = "Struct" + builder.anonymous.size
          val str = visitStruct(cursor, builder.name.value + "." + nestedName)
          builder.anonymous.addOne(
            removeFAM(
              Def.Struct(
                fields = str.fields,
                name = StructName(nestedName),
                anonymous = str.anonymous,
                meta = extractMetadata(cursor)
              ),
              Some(cursor.spelling)
            )
          )
          CXChildVisitResult.CXChildVisit_Continue
        else if cursor.kind == CXCursorKind.CXCursor_EnumDecl then
          val nestedName = "Enum" + builder.anonymous.size
          val str: Def.Enum =
            visitEnum(cursor, isTypeDef = true)
              .copy(name = Some(EnumName(nestedName)))
          builder.anonymous.addOne(
            str
          )
          CXChildVisitResult.CXChildVisit_Continue
        else CXChildVisitResult.CXChildVisit_Continue
        end if
      }
  }

  zone {
    try
      libclang.fluent.clang_visitChildren(
        cursor,
        visitor,
        CXClientData.wrap(ptr)
      )

      removeFAM((!ptr)._1.struct.build)
    finally memory.deallocate()
    end try
  }
end visitStruct

def removeFAM(model: Def.Struct, name: Option[String] = None)(using
    Config
): Def.Struct =

  val hasFlexibleArrayMember = model.fields.lastOption.collectFirst {
    case (_, CType.IncompleteArray(_)) => true
  }.isDefined

  if hasFlexibleArrayMember then
    warning(
      s"Struct '${name.getOrElse(model.name)}' has a Flexible Array Member, so it was dropped from the definition. " +
        "See https://github.com/indoorvivants/sn-bindgen/issues/62 for details"
    )

    model.copy(fields = model.fields.dropRight(1))
  else model

end removeFAM
