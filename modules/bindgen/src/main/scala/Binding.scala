package bindgen

import Def.*
import CType.*

case class Binding(
    aliases: Set[Def.Alias],
    unions: Set[Def.Union],
    structs: Set[Def.Struct],
    enums: Set[Def.Enum],
    functions: Set[Def.Function],
    unnamedEnums: Set[Def.Enum]
):
  lazy val all = (aliases ++ unions ++ structs ++ enums ++ functions).toSeq

  def filterAll(f: Def => Boolean) =
    copy(
      aliases = aliases.filter(f),
      unions = unions.filter(f),
      structs = structs.filter(f),
      enums = enums.filter(f),
      functions = functions.filter(f),
      unnamedEnums = unnamedEnums.filter(f)
    )
end Binding
