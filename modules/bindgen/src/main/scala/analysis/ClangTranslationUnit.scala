package bindgen

import libclang.*

import scala.util.boundary

import scalanative.unsafe.*
import scalanative.unsigned.*
import boundary.break
import boundary.Label

object ClangTranslationUnit:
  def create(
      index: CXIndex,
      file: String,
      clangInfo: ClangInfo
  )(using
      config: Config
  )(using
      Zone
  ): Either[BindingError, CXTranslationUnit] =
    val extraClangFlags =
      clangInfo.includePaths
        .map(ip => s"-I$ip")
        .map(ClangFlag(_))

    val allClangFlags = (config.clangFlags ++ extraClangFlags).distinct

    info(s"Using following clang flags", allClangFlags)
    val filename = toCString(file)
    val l = List.newBuilder[String]
    import CXTranslationUnit_Flags as flags

    val mem =
      val ptr = alloc[CString](allClangFlags.size)
      (0 until allClangFlags.size).foreach { i =>
        ptr(i) = toCString(allClangFlags(i).value)
      }

      ptr

    val unit = clang_parseTranslationUnit(
      index,
      filename,
      mem,
      allClangFlags.size,
      null,
      0.toUInt,
      CXTranslationUnit_Flags.CXTranslationUnit_None.uint
    )

    boundary:
      if unit == null.asInstanceOf[CXTranslationUnit] then
        break(Left(BindingError.FailedToCreateTranslationUnit))

      trace("Successfully created a translation unit")

      var errors = 0
      val numDiagnostics = clang_getNumDiagnostics(unit).toInt

      trace(s"Clang reported $numDiagnostics diagnostics")

      val diagnostics = new Array[ClangDiagnostic](numDiagnostics)

      (0 until numDiagnostics).foreach { diagId =>
        val diag = ClangDiagnostic(clang_getDiagnostic(unit, diagId.toUInt))

        diagnostics(diagId) = diag

        if diag.severity == ClangSeverity.Error || diag.severity == ClangSeverity.Fatal
        then errors += 1

      }

      if errors != 0 then
        break(Left(BindingError.ClangErrors(diagnostics.toList)))

      Right(unit)
  end create

  def getCursor(cursor: CXTranslationUnit)(using Zone) =
    val curs = clang_getTranslationUnitCursor(cursor)

    if curs == null.asInstanceOf then
      Left(BindingError.FailedToCreateTranslationUnitCursor)
    else Right(curs)

end ClangTranslationUnit
