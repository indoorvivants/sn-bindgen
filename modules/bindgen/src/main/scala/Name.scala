package bindgen

import opaque_newtypes.*
import CDefinition.*
import CType.*

enum Name derives io.circe.Codec.AsObject:
  case Model(value: String, meta: Metadata = Metadata.empty)
  case BuiltIn(value: BuiltinType)
  case Unnamed
