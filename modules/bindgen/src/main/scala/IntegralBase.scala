package bindgen

import opaque_newtypes.*
import CDefinition.*
import CType.*

enum IntegralBase derives io.circe.Codec.AsObject:
  case Char, Short, Int, Long, LongLong

object IntegralBase:
  given Ordering[IntegralBase] = Ordering.by:
    case IntegralBase.Char     => 0
    case IntegralBase.Short    => 1
    case IntegralBase.Int      => 2
    case IntegralBase.Long     => 3
    case IntegralBase.LongLong => 3

