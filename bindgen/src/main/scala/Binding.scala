package bindgen

import bindgen.CType.Parameter
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.Tag
import scala.scalanative.unsigned.ULong
import Def.*
import CType.*

case class Binding(
    aliases: Set[Def.Alias],
    unions: Set[Def.Union],
    structs: Set[Def.Struct],
    enums: Set[Def.Enum],
    functions: Set[Def.Function]
):
  lazy val all = (aliases ++ unions ++ structs ++ enums ++ functions).toSeq
