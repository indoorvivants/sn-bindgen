package bindgen

enum CDefinitionTag:
  case Union, Alias, Struct, Function, Enum

object CDefinitionTag:
  def all = Set(Union, Alias, Struct, Function, Enum)
