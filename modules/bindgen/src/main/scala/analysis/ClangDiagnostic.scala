package bindgen

import libclang.*

import fluent.*
import scalanative.unsafe.*

case class ClangDiagnostic private (
    severity: ClangSeverity,
    private val raw: CXDiagnostic
):
  private var _message: String = null

  private val formatOptions =
    (CXDiagnosticDisplayOptions.CXDiagnostic_DisplaySourceLocation | CXDiagnosticDisplayOptions.CXDiagnostic_DisplayColumn).uint

  def message()(using Zone): String =
    if _message != null then _message
    else
      _message = clang_formatDiagnostic(raw, formatOptions).string
      _message
end ClangDiagnostic

object ClangDiagnostic:
  def apply(diag: CXDiagnostic): ClangDiagnostic =
    val sev = clang_getDiagnosticSeverity(diag)

    import CXDiagnosticSeverity.*

    val severity = sev match
      case CXDiagnostic_Error   => ClangSeverity.Error
      case CXDiagnostic_Fatal   => ClangSeverity.Fatal
      case CXDiagnostic_Warning => ClangSeverity.Warning
      case CXDiagnostic_Ignored => ClangSeverity.Ignored
      case CXDiagnostic_Note    => ClangSeverity.Note

    new ClangDiagnostic(severity, diag)
  end apply
end ClangDiagnostic
