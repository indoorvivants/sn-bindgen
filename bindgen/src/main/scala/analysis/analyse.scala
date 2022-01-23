package bindgen

import libclang.defs.*
import libclang.enumerations.*
import libclang.fluent.*
import libclang.types.*

import java.io.FileWriter
import java.nio.file.Files
import scala.collection.mutable
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import scalanative.libc.*

def outputDiagnostic(diag: CXDiagnostic)(using Config): Any => Unit =
  import CXDiagnosticSeverity as sev
  clang_getDiagnosticSeverity(diag) match
    case sev.CXDiagnostic_Error | sev.CXDiagnostic_Fatal  => error(_)
    case sev.CXDiagnostic_Warning                         => warning(_)
    case sev.CXDiagnostic_Ignored | sev.CXDiagnostic_Note => info(_)

def analyse(file: String)(using Zone)(using config: Config): Binding =
  info(s"Using following clang flags: ${summon[Config].clangFlags}")
  val filename = toCString(file)
  val index = clang_createIndex(0, 0)
  val l = List.newBuilder[String]
  import CXTranslationUnit_Flags as flags

  val mem =
    val seq = config.clangFlags
    val ptr = alloc[CString](seq.size)
    (0 until seq.size).foreach { i =>
      ptr(i) = toCString(seq(i).value)
    }

    ptr

  val unit = clang_parseTranslationUnit(
    index,
    filename,
    mem,
    config.clangFlags.size.toUInt,
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

  val cxClientData = Captured.allocate[Binding](
    Binding()
  )

  val translationUnitCursor = clang_getTranslationUnitCursor(unit)

  if translationUnitCursor == CXCursor.NULL then
    throw Exception(
      s"Translation unit cursor is NULL, which indicates that libclang failed to do _something_ (there's no extra information)"
    )

  // if clang_getCursorKind(
  //     translationUnitCursor
  //   ) != CXCursorKind.CXCursor_TranslationUnit
  // then
  //   throw Exception(
  //     s"Translation unit cursor is of unexpected type: ${clang_getCursorKindSpelling(clang_getCursorKind(translationUnitCursor)).string}, " +
  //       s"\n must be ${clang_getCursorKindSpelling(CXCursorKind.CXCursor_TranslationUnit).string}"
  //   )

  clang_visitChildren(
    translationUnitCursor,
    CXCursorVisitor.apply {
      (cursor: CXCursor, parent: CXCursor, data: CXClientData) =>
        val (binding, zone, conf) = !(data.unwrap[Captured[Binding]])

        given Config = conf
        given Zone = zone

        val loc = cursor.location
        val isFromMainFile = loc.isFromMainFile

        if cursor.kind == CXCursorKind.CXCursor_FunctionDecl then
          val function = visitFunction(cursor)
          binding.add(function, isFromMainFile)
        end if

        if cursor.kind == CXCursorKind.CXCursor_TypedefDecl then
          val typ = clang_getTypedefDeclUnderlyingType(cursor)
          val name = cursor.spelling
          val referencedType = clang_Type_getNamedType(typ)
          val typeDecl = clang_getTypeDeclaration(referencedType)
          if (referencedType.kind == CXTypeKind.CXType_Enum) then
            val en = visitEnum(typeDecl, true)
            binding.add(en, isFromMainFile)
          else if (referencedType.kind == CXTypeKind.CXType_Record) then
            val struct = visitStruct(typeDecl, name)

            val item =
              if typ.spelling.startsWith("union ") then
                Def.Union(struct.fields, struct.name)
              else struct

            if name != "" then binding.add(item, isFromMainFile)
          else
            val alias: Def.Alias =
              Def.Alias(name, constructType(typ))
            val canonical = clang_getCanonicalType(typ)

            binding.add(alias, isFromMainFile)
          end if
        end if

        if cursor.kind == CXCursorKind.CXCursor_UnionDecl then
          val name = clang_getCursorSpelling(cursor).string
          if name != "" then
            val en = visitStruct(cursor, name)
            val union = Def.Union(en.fields, en.name)
            binding.add(union, isFromMainFile)
        end if

        if cursor.kind == CXCursorKind.CXCursor_StructDecl then
          val name = cursor.spelling
          if name != "" then
            val en = visitStruct(cursor, name)
            binding.add(en, isFromMainFile)
        end if

        if cursor.kind == CXCursorKind.CXCursor_EnumDecl then
          val en = visitEnum(
            cursor,
            clang_getCursorType(
              parent
            ).kind == CXTypeKind.CXType_Typedef
          )

          binding.add(en, isFromMainFile)
        end if

        if cursor.kind == CXCursorKind.CXCursor_TypedefDecl then
          CXChildVisitResult.CXChildVisit_Continue
        else CXChildVisitResult.CXChildVisit_Recurse
    },
    CXClientData.wrap(cxClientData)
  )

  clang_disposeTranslationUnit(unit)
  clang_disposeIndex(index)

  val binding = (!cxClientData)._1
  addBuiltInAliases(binding)
  val closure = computeClosure(binding.named.toMap)

  trace(s"Defined or used in main file: ${closure}")

  binding.named.filterInPlace((k, _) => closure.contains(k))

  trace("Binding information:")
  binding.named.toList.sortBy(_._1).foreach { case (k, v) =>
    trace(s"'$k': $v")
  }

  binding
end analyse

def addBuiltInAliases(binding: Binding): Binding =
  BuiltinType.all.foreach { tpe =>
    val al = Def.Alias(tpe.short, CType.Reference(Name.BuiltIn(tpe)))
    binding.add(al, isFromMainFile = false)
  }
  binding
