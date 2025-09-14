package bindgen

import opaque_newtypes.*
import CDefinition.*
import CType.*

enum SignType derives io.circe.Codec.AsObject:
  case Signed, Unsigned

object SignType:
  given Ordering[SignType] = Ordering.by:
    case SignType.Signed   => 0
    case SignType.Unsigned => 1

