package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*
import libclang.enumerations.*
import scala.collection.mutable

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
    functions = mutable.Set.empty,
    aliases = mutable.Set.empty
  )

  clang_visitChildren(
    clang_getTranslationUnitCursor(unit),
    CXCursorVisitor {
      (cursor: CXCursor, parent: CXCursor, data: CXClientData) =>
        val binding = !(data.unwrap[Def.Binding])
        zone {
          try
            val loc = clang_getCursorLocation(cursor)
            println(clang_Location_isFromMainFile(loc))

            if cursor.kind == CXCursorKind.CXCursor_FunctionDecl then
              val function = visitFunction(cursor)
              binding.functions.add(function)
              System.err.println("Defined func: " + function)

            if cursor.kind == CXCursorKind.CXCursor_TypedefDecl then
              val typ = clang_getTypedefDeclUnderlyingType(cursor)
              val name = clang_getCursorSpelling(cursor).string
              val referencedType = clang_Type_getNamedType(typ)
              val typeDecl = clang_getTypeDeclaration(referencedType)
              if (referencedType.kind == CXTypeKind.CXType_Enum) then
                binding.enums.add(visitEnum(typeDecl, true))
              else if (referencedType.kind == CXTypeKind.CXType_Record) then
                binding.structs.add(visitStruct(typeDecl, name))
              else binding.aliases.add(Def.Alias(name, constructType(typ)))
              end if
            end if

            if cursor.kind == CXCursorKind.CXCursor_EnumDecl then
              binding.enums.add(
                visitEnum(
                  cursor,
                  clang_getCursorType(parent).kind == CXTypeKind.CXType_Typedef
                )
              )
          catch case exc => println(s"Failed analysis with $exc")
        }
        if cursor.kind == CXCursorKind.CXCursor_TypedefDecl then
          CXChildVisitResult.CXChildVisit_Continue
        else CXChildVisitResult.CXChildVisit_Recurse
    },
    CXClientData.wrap(bindingMem)
  )

  clang_disposeTranslationUnit(unit)
  clang_disposeIndex(index)

  !bindingMem
end analyse
