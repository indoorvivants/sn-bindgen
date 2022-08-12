package bindgen

import bindgen.CType.Parameter
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.Tag
import scala.scalanative.unsigned.ULong
import Def.*
import CType.*

object DefTag:
  import DefTag.*
  def all = Set(Union, Alias, Struct, Function, Enum)

enum DefTag:
  case Union, Alias, Struct, Function, Enum
