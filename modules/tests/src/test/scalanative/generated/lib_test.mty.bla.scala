package lib_test.mty.bla

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

@extern
private[bla] object extern_functions:
  /** bindgen-package: lib_test.mty.bla
    */
  def help_me(c: CChar): CInt = extern

object functions:
  import extern_functions.*
  export extern_functions.*

object all:
  export _root_.lib_test.mty.bla.functions.help_me
