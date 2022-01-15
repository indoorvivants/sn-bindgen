package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*
import libclang.fluent.*
import libclang.enumerations.*
import scala.collection.mutable
import java.nio.file.Files
import java.io.FileWriter
import cats.data.NestedInstances0

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
  type Data = (Binding, Config, Zone)
  CVarArgList

  val cxClientData = Captured.allocate[Binding](
    Binding(
      enums = mutable.Set.empty,
      structs = mutable.Set.empty,
      unions = mutable.Set.empty,
      functions = mutable.Set.empty,
      aliases = mutable.Set.empty,
      mainFileNames = mutable.Set.empty
    )
  )

  val translationUnitCursor = clang_getTranslationUnitCursor(unit)

  clang_visitChildren(
    translationUnitCursor,
    CXCursorVisitor.apply {
      (cursor: CXCursor, parent: CXCursor, data: CXClientData) =>
        val (binding, zone, conf) = !(data.unwrap[Captured[Binding]])

        given Config = conf
        given Zone = zone

        val loc = cursor.location
        if cursor.kind == CXCursorKind.CXCursor_FunctionDecl then
          val function = visitFunction(cursor)
          if cursor.location.isFromMainFile then
            definitionClosure(function).foreach(binding.mainFileNames.add)
          binding.functions.addOne(function)
        end if

        if cursor.kind == CXCursorKind.CXCursor_TypedefDecl then
          val typ = clang_getTypedefDeclUnderlyingType(cursor)
          val name = cursor.spelling
          val referencedType = clang_Type_getNamedType(typ)
          val typeDecl = clang_getTypeDeclaration(referencedType)
          if (referencedType.kind == CXTypeKind.CXType_Enum) then
            val en = visitEnum(typeDecl, true)
            if cursor.location.isFromMainFile then
              definitionClosure(en).foreach(binding.mainFileNames.add)
            binding.enums.addOne(en)
          else if (referencedType.kind == CXTypeKind.CXType_Record) then
            val struct = visitStruct(typeDecl, name)

            if cursor.location.isFromMainFile then
              definitionClosure(struct).foreach(binding.mainFileNames.add)

            if clang_getTypeSpelling(typ).string.startsWith("union ") then
              binding.unions.addOne(Def.Union(struct.fields, struct.name))
            else if name != "" then
              binding.structs.filterInPlace(_.name != name)
              binding.structs.addOne(visitStruct(typeDecl, name))
          else
            val alias: Def.Alias =
              Def.Alias(name, constructType(typ))
            val canonical = clang_getCanonicalType(typ)

            trace(
              s"Alias $alias, aliased type is $typ, canonical type is ${canonical.spelling}"
            )

            if cursor.location.isFromMainFile then
              definitionClosure(alias).foreach(binding.mainFileNames.add)

            binding.aliases.addOne(alias)
          end if
        end if

        if cursor.kind == CXCursorKind.CXCursor_UnionDecl then
          val name = clang_getCursorSpelling(cursor).string
          if name != "" then
            val en = visitStruct(cursor, name)
            if cursor.location.isFromMainFile then
              definitionClosure(en).foreach(binding.mainFileNames.add)

            binding.unions.addOne(Def.Union(en.fields, en.name))

        if cursor.kind == CXCursorKind.CXCursor_StructDecl then
          val name = clang_getCursorSpelling(cursor).string
          if name != "" then
            binding.structs.filterInPlace(_.name != name)
            val en = visitStruct(cursor, name)
            if cursor.location.isFromMainFile then
              definitionClosure(en).foreach(binding.mainFileNames.add)
            binding.structs.addOne(en)

        if cursor.kind == CXCursorKind.CXCursor_EnumDecl then
          val en = visitEnum(
            cursor,
            clang_getCursorType(
              parent
            ).kind == CXTypeKind.CXType_Typedef
          )

          if cursor.location.isFromMainFile then
            definitionClosure(en).foreach(binding.mainFileNames.add)
          binding.enums.addOne(en)
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

  trace(s"Defined or used in main file: ${binding.mainFileNames}")

  def allowed(f: Def) =
    f.defName.isEmpty || f.defName.exists { nm =>
      !BuiltIn.aliasNames.contains(nm) && binding.mainFileNames.contains(nm)
    }

  binding.functions.filterInPlace(allowed)
  binding.aliases.filterInPlace(allowed)
  binding.structs.filterInPlace(allowed)
  binding.enums.filterInPlace(allowed)
  binding.unions.filterInPlace(allowed)

  trace("Binding information:")
  binding.aliases.foreach { a =>
    trace(s"alias $a")
  }
  binding.functions.foreach { a =>
    trace(s"function $a")
  }
  binding.structs.foreach { a =>
    trace(s"struct $a")
  }
  binding.enums.foreach { a =>
    trace(s"enum $a")
  }
  binding.unions.foreach { a =>
    trace(s"union $a")
  }

  BuiltIn.add(binding)
end analyse

object BuiltIn:
  def add(binding: Binding): Binding =
    aliases.foldLeft[Binding](binding) { case (b, alias) =>
      if b.mainFileNames.contains(alias.name) then
        b.aliases.addOne(alias)
        b
      else b
    }

  val aliases: Set[Def.Alias] = BuiltinType.all
    .map[Def.Alias] { tpe =>
      Def.Alias(tpe.short, CType.Reference(Name.BuiltIn(tpe)))
    }
    .toSet
  val aliasNames = aliases.map(_.name)
end BuiltIn

extension (seq: Seq[String])
  private[bindgen] def toCArray(using Zone): Ptr[CString] =
    val mem = alloc[CString](seq.size)
    (0 until seq.size).foreach { i =>
      mem(i) = toCString(seq(i))
    }

    mem
