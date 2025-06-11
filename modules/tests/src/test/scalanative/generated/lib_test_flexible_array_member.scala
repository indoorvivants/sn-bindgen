package lib_test_flexible_array_member

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object structs:
  import _root_.lib_test_flexible_array_member.structs.*
  import _root_.lib_test_flexible_array_member.unions.*
  opaque type FAM = CStruct1[CInt]
  object FAM:
    given _tag: Tag[FAM] = Tag.materializeCStruct1Tag[CInt]
    def apply()(using Zone): Ptr[FAM] = scala.scalanative.unsafe.alloc[FAM](1)
    def apply(len: CInt)(using Zone): Ptr[FAM] =
      val ____ptr = apply()
      (!____ptr).len = len
      ____ptr
    extension (struct: FAM)
      def len: CInt = struct._1
      def len_=(value: CInt): Unit = !struct.at1 = value
  end FAM
end structs

object unions:
  import _root_.lib_test_flexible_array_member.structs.*
  import _root_.lib_test_flexible_array_member.unions.*
  opaque type FAM_union = CArray[Byte, Nat._4]
  object FAM_union:
    opaque type Struct0 = CStruct1[CInt]
    object Struct0:
      given _tag: Tag[Struct0] = Tag.materializeCStruct1Tag[CInt]
      def apply()(using Zone): Ptr[Struct0] =
        scala.scalanative.unsafe.alloc[Struct0](1)
      def apply(va_header: CInt)(using Zone): Ptr[Struct0] =
        val ____ptr = apply()
        (!____ptr).va_header = va_header
        ____ptr
      extension (struct: Struct0)
        def va_header: CInt = struct._1
        def va_header_=(value: CInt): Unit = !struct.at1 = value
    end Struct0
    given _tag: Tag[FAM_union] = Tag.CArray[CChar, Nat._4](Tag.Byte, Tag.Nat4)
    def apply()(using Zone): Ptr[FAM_union] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[FAM_union](1)
      ___ptr
    @scala.annotation.targetName("apply_va_compressed")
    def apply(va_compressed: FAM_union.Struct0)(using Zone): Ptr[FAM_union] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[FAM_union](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[FAM_union.Struct0]].update(0, va_compressed)
      ___ptr
    extension (struct: FAM_union)
      def va_compressed: FAM_union.Struct0 =
        !struct.at(0).asInstanceOf[Ptr[FAM_union.Struct0]]
      def va_compressed_=(value: FAM_union.Struct0): Unit =
        !struct.at(0).asInstanceOf[Ptr[FAM_union.Struct0]] = value
  end FAM_union
end unions

object types:
  export _root_.lib_test_flexible_array_member.structs.*
  export _root_.lib_test_flexible_array_member.unions.*

object all:
  export _root_.lib_test_flexible_array_member.structs.FAM
  export _root_.lib_test_flexible_array_member.unions.FAM_union
