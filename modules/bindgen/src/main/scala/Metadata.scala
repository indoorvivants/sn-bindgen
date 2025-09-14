package bindgen

import opaque_newtypes.*
import CDefinition.*
import CType.* 

import CommentText.given
import DefinitionFile.given

case class Metadata(
    comment: Option[CommentText],
    file: Option[DefinitionFile]
) derives io.circe.Codec.AsObject

object Metadata:
  def empty: Metadata = Metadata(None, None)
