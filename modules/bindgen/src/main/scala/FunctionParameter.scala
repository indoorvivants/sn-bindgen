package bindgen

import opaque_newtypes.*
import CDefinition.*
import CType.*

case class FunctionParameter(
    name: String,
    typ: CType,
    originalTyp: OriginalCType,
    generatedName: Boolean
) derives io.circe.Codec.AsObject
