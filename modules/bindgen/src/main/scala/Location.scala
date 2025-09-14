package bindgen

import opaque_newtypes.*
import CDefinition.*
import CType.*

case class Location(isFromMainFile: Boolean, isFromSystemHeader: Boolean):
  inline def shouldBeIncluded: Boolean = isFromMainFile || !isFromSystemHeader

object Location:
  inline def systemHeader =
    Location(isFromMainFile = false, isFromSystemHeader = true)
