package bindgen

enum DefTag:
  case Union, Alias, Struct, Function, Enum

object DefTag:
  def all = Set(Union, Alias, Struct, Function, Enum)
