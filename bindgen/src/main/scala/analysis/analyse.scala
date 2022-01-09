package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*
import libclang.enumerations.*
import scala.collection.mutable
import java.nio.file.Files
import java.io.FileWriter
import cats.data.NestedInstances0

def addBuiltin(binding: Def.Binding): Def.Binding =
  binding.copy(aliases =
    binding.aliases
      .addOne(Def.Alias("__builtin_va_list", CType.Pointer(CType.Byte)))
  )

def outputDiagnostic(diag: CXDiagnostic)(using Config): Any => Unit =
  import CXDiagnosticSeverity as sev
  clang_getDiagnosticSeverity(diag) match
    case sev.CXDiagnostic_Error | sev.CXDiagnostic_Fatal  => error(_)
    case sev.CXDiagnostic_Warning                         => warning(_)
    case sev.CXDiagnostic_Ignored | sev.CXDiagnostic_Note => info(_)

def analyse(file: String)(using Zone, Config): Def.Binding =
  info(s"Using following clang flags: ${summon[Config].clangFlags}")
  val filename = toCString(file)
  val index = clang_createIndex(0, 0)
  val l = List.newBuilder[String]
  import CXTranslationUnit_Flags as flags

  val unit = clang_parseTranslationUnit(
    index,
    filename,
    summon[Config].clangFlags.map(_.value).toCArray,
    summon[Config].clangFlags.size.toUInt,
    null,
    0.toUInt,
    flags.CXTranslationUnit_None
  )

  trace("Successfully created a translation unit")

  var errors = 0
  val numDiagnostics = clang_getNumDiagnostics(unit).toInt

  trace(s"Clang reported $numDiagnostics diagnostics")

  (0 until numDiagnostics).foreach { diagId =>
    val diag = clang_getDiagnostic(unit, diagId.toUInt)

    import CXDiagnosticDisplayOptions as flags
    outputDiagnostic(diag)(
      "clang: " +
        clang_formatDiagnostic(
          diag,
          0.toUInt
        ).string
    )

    val severity = clang_getDiagnosticSeverity(diag)

    if severity == CXDiagnosticSeverity.CXDiagnostic_Error || severity == CXDiagnosticSeverity.CXDiagnostic_Fatal then
      errors += 1
  }

  if errors != 0 then
    throw Exception(
      s"$errors errors were reported by clang, the generation will be aborted as" + " the binding will likely be incomplete, broken, or both"
    )

  val bindingMem = alloc[Def.Binding](1)
  !bindingMem = Def.Binding(
    enums = mutable.Set.empty,
    structs = mutable.Set.empty,
    unions = mutable.Set.empty,
    functions = mutable.Set.empty,
    aliases = mutable.Set.empty
  )

  val translationUnitCursor = clang_getTranslationUnitCursor(unit)

  clang_visitChildren(
    translationUnitCursor,
    CXCursorVisitor.apply {
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
                else if name != "" then
                  binding.structs.filterInPlace(_.name != name)
                  binding.structs.addOne(visitStruct(typeDecl, name))
              else binding.aliases.addOne(Def.Alias(name, constructType(typ)))
              end if
            end if

            if cursor.kind == CXCursorKind.CXCursor_UnionDecl then
              val name = clang_getCursorSpelling(cursor).string
              if name != "" then
                val struct = visitStruct(cursor, name)

                binding.unions.addOne(Def.Union(struct.fields, struct.name))

            if cursor.kind == CXCursorKind.CXCursor_StructDecl then
              val name = clang_getCursorSpelling(cursor).string
              if name != "" then
                binding.structs.filterInPlace(_.name != name)
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

  val binding = !bindingMem

  addBuiltin(!bindingMem)
end analyse
extension (seq: Seq[String])
  private[bindgen] def toCArray(using Zone): Ptr[CString] =
    val mem = alloc[CString](seq.size)
    (0 until seq.size).foreach { i =>
      mem(i) = toCString(seq(i))
    }

    mem
