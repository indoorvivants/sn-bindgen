package lib_test_unnamed

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object aliases:
  import _root_.lib_test_unnamed.aliases.*
  opaque type _XPrivateDisplay = Ptr[CStruct0]
  object _XPrivateDisplay:
    given _tag: Tag[_XPrivateDisplay] =
      Tag.Ptr[CStruct0](Tag.materializeCStruct0Tag)

object types:
  export _root_.lib_test_unnamed.aliases.*

object all:
  export _root_.lib_test_unnamed.aliases._XPrivateDisplay
