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
import scala.scalanative.runtime.libc

def outputDiagnostic(diag: CXDiagnostic)(using Config): Any => Unit =
  import CXDiagnosticSeverity as sev
  clang_getDiagnosticSeverity(diag) match
    case sev.CXDiagnostic_Error | sev.CXDiagnostic_Fatal  => error(_)
    case sev.CXDiagnostic_Warning                         => warning(_)
    case sev.CXDiagnostic_Ignored | sev.CXDiagnostic_Note => info(_)

def analyse(file: String)(using Zone)(using config: Config): Binding =
  val index = clang_createIndex(0, 0)

  val unit = createTranslationUnit(index, file)

  val (cxClientData, memory) = Captured.unsafe(BindingBuilder())

  val translationUnitCursor = clang_getTranslationUnitCursor(unit)

  if translationUnitCursor == CXCursor.NULL then
    throw Exception(
      s"Translation unit cursor is NULL, which indicates that libclang failed to do _something_ (there's no extra information)"
    )

  val visitor =
    CXCursorVisitor.apply {
      (cursor: CXCursor, parent: CXCursor, data: CXClientData) =>
        val (binding, conf) = !(data.unwrap[Captured[BindingBuilder]])

        given Config = conf

        zone {
          val loc = cursor.location

          val location = Location(loc.isFromMainFile, loc.isFromSystemHeader)

          val spell = cursor.spelling

          if cursor.kind == CXCursorKind.CXCursor_FunctionDecl then
            val function = visitFunction(cursor)
            binding.add(function, location)
          end if

          if cursor.kind == CXCursorKind.CXCursor_TypedefDecl then

            /** Definitions such as this: typedef enum MY_BOOL {m_false, m_true}
              * my_bool;
              */
            val typ = clang_getTypedefDeclUnderlyingType(cursor)
            val name = cursor.spelling
            val referencedType = clang_Type_getNamedType(typ)
            val typeDecl = clang_getTypeDeclaration(referencedType)

            if (referencedType.kind == CXTypeKind.CXType_Enum) then
              val en = visitEnum(typeDecl, true)
              binding.add(en, location)

              // If the typedef's name is different from the alias name,
              // we should add both definitions

              if !en.name.exists(_.value == name) then
                binding.add(
                  Def.Alias(name, constructType(typ)),
                  location
                )
            else if (referencedType.kind == CXTypeKind.CXType_Record) then
              val struct = visitStruct(typeDecl, name)

              val item =
                if typ.spelling.startsWith("union ") then
                  Def.Union(
                    struct.fields.map { case (n, f) =>
                      n.into(UnionParameterName) -> f
                    },
                    struct.name.into(UnionName),
                    struct.anonymous
                  )
                else struct

              if name != "" then binding.add(item, location)
            else if typ.kind != CXTypeKind.CXType_Invalid then
              val alias: Def.Alias =
                Def.Alias(name, constructType(typ))
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
            if name != "" then
              val en = visitStruct(cursor, name)
              val union = Def.Union(
                en.fields.map { case (n, f) =>
                  n.into(UnionParameterName) -> f
                },
                en.name.into(UnionName),
                en.anonymous
              )
              binding.add(union, location)
            end if
          end if

          if cursor.kind == CXCursorKind.CXCursor_StructDecl then
            val name = cursor.spelling
            if name != "" then
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

  try
    clang_visitChildren(
      translationUnitCursor,
      visitor,
      CXClientData.wrap(cxClientData)
    )

    clang_disposeTranslationUnit(unit)
    clang_disposeIndex(index)

    val binding: BindingBuilder = (!cxClientData)._1

    trace(
      "Binding information before adding system aliases:",
      binding.named.toList.sortBy(_._1.n).map { case (k, v) =>
        k.toString -> v
      }
    )

    addBuiltInAliases(binding)

    trace(
      "Binding information after adding system alises:",
      binding.named.toList.sortBy(_._1.n).map { case (k, v) =>
        k.toString -> v
      }
    )
    val closure = computeClosure(binding.named.filter { n =>
      val name = n._1.n

      if (config.exclusivePrefix.isEmpty) then true
      else config.exclusivePrefix.exists(ep => name.startsWith(ep.value))
    }.toMap)

    trace(s"Defined or used in main file: ${closure}")

    binding.named.filterInPlace((k, _) => closure.contains(k.n))
    binding.unnamed.filterInPlace(_.location.shouldBeIncluded)

    trace(
      "Binding information after computing closure:",
      binding.named.toList.sortBy(_._1.n).map { case (k, v) =>
        k.toString -> v
      }
    )

    binding.build
  finally memory.deallocate()
  end try

end analyse

def addBuiltInAliases(binding: BindingBuilder): BindingBuilder =
  val replaceTypes = DefTag.all - DefTag.Function
  BuiltinType.all.foreach { tpe =>
    val al = Def.Alias(tpe.short, CType.Reference(Name.BuiltIn(tpe)))
    replaceTypes.foreach { tg =>
      binding.named.get(DefName(tpe.short, tg)) match
        case Some(
              BindingDefinition(
                Def.Alias(
                  "va_list",
                  CType.Reference(
                    Name.Model("__builtin_va_list")
                  ) // whatever the hell happens on MacOS
                ),
                _
              )
            ) =>
          binding.remove(DefName(tpe.short, DefTag.Alias))
          binding.remove(DefName("__gnuc_va_list", DefTag.Alias))
          binding.remove(DefName("__builtin_va_list", DefTag.Alias))
          binding.remove(DefName("__darwin_va_list", DefTag.Alias))

          binding.add(al, location = Location.systemHeader)

        case Some(bd) =>
          if bd.location.isFromSystemHeader then
            binding.remove(DefName(tpe.short, tg))
            binding.add(al, location = Location.systemHeader)
        case None =>
    }
  }
  binding
end addBuiltInAliases

def createTranslationUnit(index: CXIndex, file: String)(using config: Config)(
    using Zone
) =
  info(s"Using following clang flags: ${summon[Config].clangFlags}")
  val filename = toCString(file)
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

  if unit == CXTranslationUnit.NULL then
    throw new Exception(
      "Translation unit is `null`, which is sort of a big problem"
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

    if severity == CXDiagnosticSeverity.CXDiagnostic_Error || severity == CXDiagnosticSeverity.CXDiagnostic_Fatal
    then errors += 1
  }

  if errors != 0 then
    throw Exception(
      s"$errors errors were reported by clang, the generation will be aborted as" + " the binding will likely be incomplete, broken, or both"
    )

  unit
end createTranslationUnit
