package lib_test_varags

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object structs:
  import _root_.lib_test_varags.structs.*
  opaque type VaragsStruct = CStruct2[CInt, CChar]
  object VaragsStruct:
    given _tag: Tag[VaragsStruct] = Tag.materializeCStruct2Tag[CInt, CChar]
    def apply()(using Zone): Ptr[VaragsStruct] =
      scala.scalanative.unsafe.alloc[VaragsStruct](1)
    def apply(a: CInt, c: CChar)(using Zone): Ptr[VaragsStruct] =
      val ____ptr = apply()
      (!____ptr).a = a
      (!____ptr).c = c
      ____ptr
    extension (struct: VaragsStruct)
      def a: CInt = struct._1
      def a_=(value: CInt): Unit = !struct.at1 = value
      def c: CChar = struct._2
      def c_=(value: CChar): Unit = !struct.at2 = value
  end VaragsStruct
end structs

@extern
private[lib_test_varags] object extern_functions:
  import _root_.lib_test_varags.structs.*
  def test_my_ptrs(vs: Ptr[VaragsStruct], count: CInt, rest: Any*): CInt =
    extern

  def test_my_sum(count: CInt, rest: Any*): CInt = extern

object functions:
  import _root_.lib_test_varags.structs.*
  import extern_functions.*
  export extern_functions.*

object types:
  export _root_.lib_test_varags.structs.*

object all:
  export _root_.lib_test_varags.structs.VaragsStruct
  export _root_.lib_test_varags.functions.test_my_ptrs
  export _root_.lib_test_varags.functions.test_my_sum
