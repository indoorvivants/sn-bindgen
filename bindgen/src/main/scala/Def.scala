package bindgen

import scala.collection.mutable.ListBuffer

object Def:
  import scala.collection.mutable
  case class Binding(var enums: mutable.Set[Enum])
  case class Enum(
      var values: ListBuffer[(String, Long)],
      var name: String,
      var intType: String
  )
