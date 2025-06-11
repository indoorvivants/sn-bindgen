package lib_test_functions

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

@extern
private[lib_test_functions] object extern_functions:
  def test1(x: Double, y: Double): CInt = extern

object functions:
  import extern_functions.*
  export extern_functions.*

object all:
  export _root_.lib_test_functions.functions.test1
