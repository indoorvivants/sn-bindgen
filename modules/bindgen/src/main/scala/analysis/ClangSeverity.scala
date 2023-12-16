package bindgen

enum ClangSeverity:
  case Ignored
  case Note
  case Warning
  case Error
  case Fatal

  def isError =
    this match
      case Error => true
      case Fatal => true
      case _     => false
end ClangSeverity
