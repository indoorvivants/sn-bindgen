package bindgen

import libclang.*

import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import fluent.*

def visitStructOld(cursor: CXCursor, name: Option[String])(using
    Config,
    Zone
): Def.Struct =
  val (ptr, memory) = Captured.unsafe[StructCollector](
    StructCollector(
      struct = DefBuilder.Struct(
        fields = ListBuffer.empty,
        name = name.filter(_.nonEmpty).map(StructName(_)),
        anonymous = ListBuffer.empty,
        meta = extractMetadata(cursor),
        anonymousFieldStructMapping = ListBuffer.empty,
        staticSize = clang_Type_getSizeOf(clang_getCursorType(cursor))
      ),
      numAnonymous = 0,
      lastAction = None
    )
  )

  trace(s"visitStruct: ${cursor.spelling}")

  val visitor = CXCursorVisitorPtr {
    (cursorPtr: Ptr[CXCursor], parentPtr: Ptr[CXCursor], d: CXClientData) =>
      val (collector, config) = !d.unwrap[Captured[StructCollector]]
      given Config = config
      val cursor = !cursorPtr

      Zone {

        val builder = collector.struct
        trace(s"Cursor kind: ${cursor.kind.spelling}")
        trace(
          s"Cursor: ${cursor.spelling}, ptr = ${cursorPtr.toLong}, parent = ${cursorPtr.toLong}"
        )
        if cursor.kind == CXCursorKind.CXCursor_FieldDecl then
          val fieldName =
            clang_getCursorSpelling(cursor).string
          val typ = clang_getCursorType(cursor)
          val decl = clang_getTypeDeclaration(typ)
          val isAnonymous = clang_Cursor_isAnonymous(decl) == 1.toUInt

          trace(s"Field name: $fieldName, ${builder.anonymous}, $parentPtr")
          trace(
            s"typ spelling: ${typ.kindSpelling}, ${decl.spelling}, anonymous $isAnonymous"
          )
          if isAnonymous then
            val last = builder.anonymous.size
            val fieldSpec = FieldSpec.Anon(
              nameHint = Option(fieldName).filter(_.nonEmpty),
              last - 1
            )

            builder.fields.addOne(fieldSpec)

            // builder.anonymousFieldStructMapping.find(
            //   _._2.value == nestedName
            // ) match
            //   case None =>
            //     builder.fields.addOne(fieldSpec)
            //   case Some(idx) =>
            //     builder.fields.update(idx._1, fieldSpec)
            //     builder.anonymousFieldStructMapping.filterInPlace(_ != idx)
          else if typ.kind == CXTypeKind.CXType_ConstantArray
          then
            val speculateType = constructType(clang_getArrayElementType(typ))
            trace(
              s"when array: $speculateType, ${typ.spelling}"
            )
            speculateType match
              case _: CType.Struct | _: CType.Union |
                  CType.Reference(Name.Unnamed) =>
                val last =
                  builder.anonymous.size // .apply(collector.numAnonymous)
                // val nestedName = last match
                //   case un: Def.Union  => un.name.value
                //   case st: Def.Struct => st.name.value
                val numElements = clang_getArraySize(typ)

                builder.fields.addOne(
                  FieldSpec.AnonArray(
                    nameHint = Option(fieldName).filter(_.nonEmpty),
                    size = numElements,
                    unsafeId = last - 1
                  )
                )

              // val fieldSpec =
              //   fieldName -> constArrayType(
              //     CType.Reference(
              //       Name.Model(builder.name.value + "." + nestedName)
              //     ),
              //     numElements
              //   )

              // builder.anonymousFieldStructMapping.find(
              //   _._2.value == nestedName
              // ) match
              //   case None =>
              //     builder.fields.addOne(fieldSpec)
              //   case Some(idx) =>
              //     builder.fields.update(idx._1, fieldSpec)
              //     builder.anonymousFieldStructMapping.filterInPlace(_ != idx)

              case _ =>
                builder.fields.addOne(
                  FieldSpec.Known(
                    fieldName,
                    constructType(
                      clang_getCursorType(cursor)
                    )
                  )
                )
            end match
          else
            builder.fields.addOne(
              FieldSpec.Known(
                fieldName,
                constructType(
                  clang_getCursorType(cursor)
                )
              )
            )
          end if

          CXChildVisitResult.CXChildVisit_Continue
        else if cursor.kind == CXCursorKind.CXCursor_UnionDecl then
          // val nestedName = "Union" + builder.anonymous.size
          val str = visitStruct(cursor, None)

          trace(
            s"visiting anonymous union ${{
                clang_getCursorSpelling(cursor).string
              }}"
          )

          val newValue = clang_Type_getSizeOf(clang_getCursorType(cursor))
          builder.anonymous.addOne(
            Def.Union(
              fields = str.fields,
              name = None,
              anonymous = str.anonymous,
              meta = extractMetadata(cursor),
              staticSize = newValue
            )
          )
          builder.fields.addOne(
            FieldSpec.Anon(
              nameHint = None,
              unsafeId = builder.anonymous.size - 1
            )
          )
          // builder.anonymousFieldStructMapping.addOne(
          //   builder.fields.size -> StructName(nestedName)
          // )
          // builder.fields.addOne(
          //   StructParameterName("") -> CType.Union(
          //     str.fields.map(_._2),
          //     Hints(newValue)
          //   )
          // )
          // builder.fields.addOne(
          //   FieldSpec.Anon(None, builder.anonymous.size - 1)
          // )
          //

          CXChildVisitResult.CXChildVisit_Continue
        else if cursor.kind == CXCursorKind.CXCursor_StructDecl then
          trace(
            s"visiting anonymous struct ${{ clang_getCursorSpelling(cursor) }}"
          )

          val nestedName = "Struct" + builder.anonymous.size
          val str = visitStruct(cursor, None)
          trace(
            s"Size of $nestedName: ${clang_Type_getSizeOf(clang_getCursorType(cursor))}"
          )
          val newValue = clang_Type_getSizeOf(clang_getCursorType(cursor))

          builder.anonymous.addOne(
            removeFAM(
              Def.Struct(
                fields = str.fields,
                name = None,
                anonymous = str.anonymous,
                meta = extractMetadata(cursor),
                staticSize = newValue
              ),
              Some(cursor.spelling)
            )
          )
          // builder.anonymousFieldStructMapping.addOne(
          //   builder.fields.size -> StructName(nestedName)
          // )
          // builder.fields.addOne(
          //   StructParameterName("") -> CType.Struct(
          //     str.fields.map(_._2),
          //     Hints(newValue)
          //   )
          // )
          //
          // builder.fields.addOne(
          //   FieldSpec.Anon(None, builder.anonymous.size - 1)
          // )

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

  Zone {
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
end visitStructOld

def removeFAM(model: Def.Struct, name: Option[String] = None)(using
    Config
): Def.Struct =

  val hasFlexibleArrayMember = model.fields.lastOption.collectFirst {
    case FieldSpec.Known(_, CType.IncompleteArray(_)) => true
  }.isDefined

  if hasFlexibleArrayMember then
    warning(
      s"Struct '${name.getOrElse(model.name)}' has a Flexible Array Member, so it was dropped from the definition. " +
        "See https://github.com/indoorvivants/sn-bindgen/issues/62 for details"
    )

    model.copy(fields = model.fields.dropRight(1))
  else model

end removeFAM
