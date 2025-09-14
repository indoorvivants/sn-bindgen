package bindgen

import libclang.*

import scalanative.unsafe.*
import fluent.*

object ClangVisitor:
  val visitor =
    CXCursorVisitorPtr.apply {
      (
          cursorPtr: Ptr[CXCursor],
          parentPtr: Ptr[CXCursor],
          data: CXClientData
      ) =>
        val ((systemDetector, binding), conf) =
          !(data.unwrap[Captured[(SystemHeaderDetector, BindingBuilder)]])

        val cursor = !cursorPtr
        val parent = !parentPtr

        given Config = conf

        Zone {

          val loc = cursor.location

          val location = Location(
            loc.isFromMainFile,
            loc.isFromSystemHeader || systemDetector.isSystem(loc.getFilename)
          )

          if cursor.kind == CXCursorKind.CXCursor_FunctionDecl then
            val function = visitFunction(cursor)

            binding.add(function, location)
          end if

          if cursor.kind == CXCursorKind.CXCursor_TypedefDecl then

            /** Definitions such as this: typedef enum MY_BOOL {m_false, m_true}
              * my_bool;
              */
            val typ = clang_getTypedefDeclUnderlyingType(cursorPtr)
            val name = cursor.spelling
            val referencedType = clang_Type_getNamedType(typ)
            val typeDecl = clang_getTypeDeclaration(referencedType)

            if referencedType.kind == CXTypeKind.CXType_Enum then
              val en = visitEnum(typeDecl, true)
              binding.add(en, location)

              // If the typedef's name is different from the alias name,
              // we should add both definitions

              if !en.name.exists(_.value == name) then
                binding.add(
                  CDefinition.Alias(
                    name,
                    constructType(typ),
                    extractMetadata(cursor)
                  ),
                  location
                )
              end if
            else if referencedType.kind == CXTypeKind.CXType_Record then
              val struct = visitStruct(typeDecl, name)

              val item =
                if typ.spelling.startsWith("union ") then
                  CDefinition.Union(
                    fields = struct.fields.map { case (n, f) =>
                      n.into(UnionParameterName) -> f
                    },
                    name = struct.name.into(UnionName),
                    anonymous = struct.anonymous,
                    meta = extractMetadata(typeDecl),
                    staticSize = struct.staticSize
                  )
                else struct

              if name != "" then binding.add(item, location)
            else if typ.kind != CXTypeKind.CXType_Invalid then
              val alias: CDefinition.Alias =
                CDefinition.Alias(
                  name,
                  constructType(typ),
                  extractMetadata(cursor)
                )
              val canonical = clang_getCanonicalType(typ)

              binding.add(alias, location)
            else
              error(
                s"Unexpected type `${typ.spelling}` of kind `${typ.kindSpelling}`"
              )
            end if
          end if

          if cursor.kind == CXCursorKind.CXCursor_UnionDecl then
            val name = clang_getCursorSpelling(cursor).string
            val isAnonymous = clang_Cursor_isAnonymous(cursor).toInt != 0
            if name != "" && !isAnonymous then
              val en = visitStruct(cursor, name)
              val union = CDefinition.Union(
                fields = en.fields.map { case (n, f) =>
                  n.into(UnionParameterName) -> f
                },
                name = en.name.into(UnionName),
                anonymous = en.anonymous,
                meta = extractMetadata(cursor),
                staticSize = en.staticSize
              )
              binding.add(union, location)
            end if
          end if

          if cursor.kind == CXCursorKind.CXCursor_StructDecl then
            val name = cursor.spelling
            val isAnonymous = clang_Cursor_isAnonymous(cursor).toInt != 0
            trace(s"Cursor: [${cursor.spelling}], ${isAnonymous}")
            if name != "" && !isAnonymous then
              val en = visitStruct(cursor, name)
              binding.add(en, location)
          end if

          if cursor.kind == CXCursorKind.CXCursor_EnumDecl then
            val en = visitEnum(
              cursor,
              clang_getCursorType(
                parent
              ).kind == CXTypeKind.CXType_Typedef
            )

            binding.add(en, location)
          end if

          if cursor.kind == CXCursorKind.CXCursor_TypedefDecl then
            CXChildVisitResult.CXChildVisit_Continue
          else CXChildVisitResult.CXChildVisit_Recurse
        }
    }
end ClangVisitor
