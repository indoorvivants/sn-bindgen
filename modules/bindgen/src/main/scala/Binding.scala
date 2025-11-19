package bindgen

import bindgen.rendering.NameResolver

import Def.*

case class Binding(
    aliases: Set[Def.Alias],
    unions: Set[Def.Union],
    structs: Set[Def.Struct],
    enums: Set[Def.Enum],
    functions: Set[Def.Function],
    unnamedEnums: Set[Def.Enum]
):
  lazy val all =
    (aliases ++ unions.map(NameResolver.resolveUnion) ++
      structs.map(NameResolver.resolveStruct) ++
      enums.map(
        NameResolver.resolveEnum
      ) ++ functions).toSeq

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
