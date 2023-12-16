package bindgen

enum BindingError:
  case FailedToCreateTranslationUnit
  case FailedToCreateTranslationUnitCursor
  case ClangErrors(diagnostics: List[ClangDiagnostic])
  case FailedToDetectSystemHeaders(msg: String)

  def render = this match
    case FailedToCreateTranslationUnit => 
      "Failed to create translation unit"
    case FailedToCreateTranslationUnitCursor =>
      "Failed to create translation unit cursor"
    case ClangErrors(diagnostics) =>
      s"Clang reported [${diagnostics.count(_.severity.isError)}] errors"
    case FailedToDetectSystemHeaders(msg) =>
      s"Failed to detect system headers: $msg"
  

