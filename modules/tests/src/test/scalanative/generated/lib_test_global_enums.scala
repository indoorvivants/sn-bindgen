package lib_test_global_enums

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object constants:
  val HELLO: CUnsignedInt = 25.toUInt
  val BYEBYE: CUnsignedInt = 11.toUInt
  
  val HOW: CInt = -1
  val DOESTHIS: CInt = -2
  val WORK: CInt = 0