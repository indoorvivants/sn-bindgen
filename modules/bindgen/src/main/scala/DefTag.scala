package bindgen

enum DefTag:
  case Union, Alias, Struct, Function, Enum, Variable

object DefTag:
  def all = Set(Union, Alias, Struct, Function, Enum, Variable)
