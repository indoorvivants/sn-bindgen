package bindgen

import opaque_newtypes.*
import CDefinition.*
import CType.*

enum FloatingBase derives io.circe.Codec.AsObject:
  case Float, Double, LongDouble
