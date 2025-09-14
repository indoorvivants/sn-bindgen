package bindgen

import opaque_newtypes.*

case class OriginalCType(typ: CType, representation: String) derives io.circe.Codec.AsObject
