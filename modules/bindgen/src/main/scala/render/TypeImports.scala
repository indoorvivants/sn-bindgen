package bindgen.rendering

import bindgen.*

case class TypeImports(
    anonEnums: Boolean,
    enums: Boolean,
    aliases: Boolean,
    structs: Boolean,
    unions: Boolean
):
  def render(out: LineBuilder)(using Config, Context) =

    val addImport = (s: String) => to(out)(s"import _root_.$packageName.$s.*")

    // anonymous enums are rendered directly next to structs, so they need a predef import there
    if anonEnums || enums then addImport("predef")
    if enums then addImport("enumerations")
    if aliases then addImport("aliases")
    if structs then addImport("structs")
    if unions then addImport("unions")

  end render
end TypeImports
