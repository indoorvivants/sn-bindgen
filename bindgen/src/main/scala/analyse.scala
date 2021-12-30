package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*
import libclang.enumerations.*
import scala.collection.mutable

inline def errln(inline a: Any) = System.err.println(a)

def addBuiltin(binding: Def.Binding): Def.Binding =
  binding.copy(aliases =
    binding.aliases
      .addOne(Def.Alias("__builtin_va_list", CType.Pointer(CType.Byte)))
  //   .addOne(Def.Alias("ssize_t", BuiltinType.ssize_t))
  //   .addOne(Def.Alias("uint32_t", BuiltinType.uint32_t))
  //   .addOne(Def.Alias("uint8_t", BuiltinType.uint8_t))
  )

def analyse(file: String)(using Zone): Def.Binding =
  val filename = toCString(file)
  val index = clang_createIndex(0, 0)
  val l = List.newBuilder[String]
  val flags =
    CXTranslationUnit_Flags.CXTranslationUnit_SkipFunctionBodies // | CXTranslationUnit_Flags.CXTranslationUnit_SingleFileParse
  val unit = clang_parseTranslationUnit(
    index,
    filename,
    null,
    0.toUInt,
    null,
    0.toUInt,
    flags
  )
  val bindingMem = stackalloc[Def.Binding](1)
  !bindingMem = Def.Binding(
    enums = mutable.Set.empty,
    structs = mutable.Set.empty,
    unions = mutable.Set.empty,
    functions = mutable.Set.empty,
    aliases = mutable.Set.empty
  )

  clang_visitChildren(
    clang_getTranslationUnitCursor(unit),
    CXCursorVisitor {
      (cursor: CXCursor, parent: CXCursor, data: CXClientData) =>
        zone {
          val binding = !(data.unwrap[Def.Binding])
          val loc = clang_getCursorLocation(cursor)
          val isFromMainFile =
            true // clang_Location_isFromMainFile(loc) == 1.toUInt
          if isFromMainFile then
            if cursor.kind == CXCursorKind.CXCursor_FunctionDecl then
              val function = visitFunction(cursor)
              binding.functions.addOne(function)
            end if

            if cursor.kind == CXCursorKind.CXCursor_TypedefDecl then
              val typ = clang_getTypedefDeclUnderlyingType(cursor)
              val name = clang_getCursorSpelling(cursor).string
              val referencedType = clang_Type_getNamedType(typ)
              val typeDecl = clang_getTypeDeclaration(referencedType)
              if (referencedType.kind == CXTypeKind.CXType_Enum) then
                binding.enums.addOne(visitEnum(typeDecl, true))
              else if (referencedType.kind == CXTypeKind.CXType_Record) then
                val struct = visitStruct(typeDecl, name)
                if clang_getTypeSpelling(typ).string.startsWith("union ") then
                  binding.unions.addOne(Def.Union(struct.fields, struct.name))
                else binding.structs.addOne(visitStruct(typeDecl, name))
              else binding.aliases.addOne(Def.Alias(name, constructType(typ)))
              end if
            end if

            // errln(
            //   s"Cursor (${clang_getCursorSpelling(cursor).string}): ${clang_getCursorKindSpelling(cursor.kind).string}"
            // )

            if cursor.kind == CXCursorKind.CXCursor_UnionDecl then
              val name = clang_getCursorSpelling(cursor).string
              if name != "" then
                val struct = visitStruct(cursor, name)

                binding.unions.addOne(Def.Union(struct.fields, struct.name))

            if cursor.kind == CXCursorKind.CXCursor_StructDecl then
              val name = clang_getCursorSpelling(cursor).string
              // errln(s"Defined $name")
              if name != "" && (!binding.structs.exists(_.name == name)) then
                binding.structs.addOne(visitStruct(cursor, name))

            if cursor.kind == CXCursorKind.CXCursor_EnumDecl then
              binding.enums.addOne(
                visitEnum(
                  cursor,
                  clang_getCursorType(
                    parent
                  ).kind == CXTypeKind.CXType_Typedef
                )
              )
            end if

            if cursor.kind == CXCursorKind.CXCursor_TypedefDecl then
              CXChildVisitResult.CXChildVisit_Continue
            else CXChildVisitResult.CXChildVisit_Recurse
          else CXChildVisitResult.CXChildVisit_Continue
          end if
        }

    },
    CXClientData.wrap(bindingMem)
  )

  clang_disposeTranslationUnit(unit)
  clang_disposeIndex(index)

  addBuiltin(!bindingMem)
end analyse
