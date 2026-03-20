package bindgen
package rendering

import bindgen.rendering.LineBuilder

case class Constants(enums: Seq[Def.Enum], macros: List[MacroDefinition])

opaque type StreamName = String
object StreamName extends opaque_newtypes.OpaqueString[StreamName]

enum RenderedOutput:
  case Single(lb: LineBuilder)
  case Multi(mp: Map[StreamName, LineBuilder])

enum Exported:
  case No
  case Yes(as: String)

enum RenderMode:
  case Objects, Files
