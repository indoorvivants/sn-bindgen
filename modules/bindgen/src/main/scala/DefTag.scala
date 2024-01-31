package bindgen

enum DefTag:
  case Union, Alias, Struct, Function, Enum

object DefTag:
  import DefTag.*
  def all = Set(Union, Alias, Struct, Function, Enum)
