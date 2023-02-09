package bindgen.rendering

import bindgen.*
import scala.collection.mutable.ListBuffer
import opaque_newtypes.given
import scala.collection.mutable

case class TypeImports(
    enums: Boolean,
    aliases: Boolean,
    structs: Boolean,
    unions: Boolean
):
  def render(out: LineBuilder)(using Config) =
    var any = false
    val imp = (s: String) =>
      any = true
      to(out)(s"import _root_.$packageName.$s.*")
    if enums then imp("enumerations")
    if aliases then imp("aliases")
    if structs then imp("structs")
    if unions then imp("unions")
    if any then out.emptyLine
  end render
end TypeImports
