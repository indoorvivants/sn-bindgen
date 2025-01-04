package bindgen.rendering

import bindgen.*

case class TypeImports(
    enums: Boolean,
    aliases: Boolean,
    structs: Boolean,
    unions: Boolean
):
  def render(out: LineBuilder)(using Config, Context) =

    val addImport = (s: String) => to(out)(s"import _root_.$packageName.$s.*")

    if enums then
      addImport("enumerations")
      addImport("predef")
    if aliases then addImport("aliases")
    if structs then addImport("structs")
    if unions then addImport("unions")

  end render
end TypeImports
