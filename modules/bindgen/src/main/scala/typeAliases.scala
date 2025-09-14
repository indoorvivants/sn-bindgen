package bindgen
import opaque_newtypes.*
import io.circe.Codec

opaque type StructParameterName = String
object StructParameterName extends OpaqueString[StructParameterName]

opaque type UnionParameterName = String
object UnionParameterName extends OpaqueString[UnionParameterName]

opaque type ParameterName = String
object ParameterName extends OpaqueString[ParameterName]

opaque type UnionName = String
object UnionName extends OpaqueString[UnionName]

opaque type FunctionName = String
object FunctionName extends OpaqueString[FunctionName]

opaque type EnumName = String
object EnumName extends OpaqueString[EnumName]

opaque type StructName = String
object StructName extends OpaqueString[StructName]

opaque type CommentText = String
object CommentText extends OpaqueString[CommentText]

opaque type DefinitionFile = String
object DefinitionFile extends OpaqueString[DefinitionFile]

