package lib_test_closure

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object aliases:
  import _root_.lib_test_closure.aliases.*
  import _root_.lib_test_closure.structs.*
  type uint32_t = scala.scalanative.unsigned.UInt
  object uint32_t:
    val _tag: Tag[uint32_t] = summon[Tag[scala.scalanative.unsigned.UInt]]
    inline def apply(inline o: scala.scalanative.unsigned.UInt): uint32_t = o
    extension (v: uint32_t)
      inline def value: scala.scalanative.unsigned.UInt = v

object structs:
  import _root_.lib_test_closure.aliases.*
  import _root_.lib_test_closure.structs.*
  opaque type ClosureStruct = CStruct1[uint32_t]
  object ClosureStruct:
    given _tag: Tag[ClosureStruct] = Tag.materializeCStruct1Tag[uint32_t]
    def apply()(using Zone): Ptr[ClosureStruct] =
      scala.scalanative.unsafe.alloc[ClosureStruct](1)
    def apply(test: uint32_t)(using Zone): Ptr[ClosureStruct] =
      val ____ptr = apply()
      (!____ptr).test = test
      ____ptr
    extension (struct: ClosureStruct)
      def test: uint32_t = struct._1
      def test_=(value: uint32_t): Unit = !struct.at1 = value
  end ClosureStruct
end structs

object types:
  export _root_.lib_test_closure.structs.*
  export _root_.lib_test_closure.aliases.*

object all:
  export _root_.lib_test_closure.aliases.uint32_t
  export _root_.lib_test_closure.structs.ClosureStruct
