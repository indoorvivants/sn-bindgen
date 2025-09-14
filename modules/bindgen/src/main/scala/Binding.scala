package bindgen

import CDefinition.*
import CType.*

case class Binding(
    aliases: Set[CDefinition.Alias],
    unions: Set[CDefinition.Union],
    structs: Set[CDefinition.Struct],
    enums: Set[CDefinition.Enum],
    functions: Set[CDefinition.Function],
    unnamedEnums: Set[CDefinition.Enum]
):
  lazy val all = (aliases ++ unions ++ structs ++ enums ++ functions).toSeq

  def filterAll(f: CDefinition => Boolean) =
    copy(
      aliases = aliases.filter(f),
      unions = unions.filter(f),
      structs = structs.filter(f),
      enums = enums.filter(f),
      functions = functions.filter(f),
      unnamedEnums = unnamedEnums.filter(f)
    )
end Binding
