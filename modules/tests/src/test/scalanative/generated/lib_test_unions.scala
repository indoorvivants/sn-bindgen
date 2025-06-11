package lib_test_unions

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object structs:
  import _root_.lib_test_unions.structs.*
  import _root_.lib_test_unions.unions.*
  opaque type StructWithUnionArray = CStruct3[
    CInt,
    StructWithUnionArray.Union0,
    CArray[StructWithUnionArray.Union1, Nat._2]
  ]
  object StructWithUnionArray:
    opaque type Union0 = CArray[Byte, Nat._8]
    object Union0:
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_test")
      def apply(test: CLongInt)(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CLongInt]].update(0, test)
        ___ptr
      @scala.annotation.targetName("apply_help")
      def apply(help: CString)(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CString]].update(0, help)
        ___ptr
      extension (struct: Union0)
        def test: CLongInt = !struct.at(0).asInstanceOf[Ptr[CLongInt]]
        def test_=(value: CLongInt): Unit =
          !struct.at(0).asInstanceOf[Ptr[CLongInt]] = value
        def help: CString = !struct.at(0).asInstanceOf[Ptr[CString]]
        def help_=(value: CString): Unit =
          !struct.at(0).asInstanceOf[Ptr[CString]] = value
    end Union0
    opaque type Union1 = CArray[Byte, Nat._8]
    object Union1:
      given _tag: Tag[Union1] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      def apply()(using Zone): Ptr[Union1] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union1](1)
        ___ptr
      @scala.annotation.targetName("apply_test")
      def apply(test: CLongInt)(using Zone): Ptr[Union1] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union1](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CLongInt]].update(0, test)
        ___ptr
      @scala.annotation.targetName("apply_help")
      def apply(help: CString)(using Zone): Ptr[Union1] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union1](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CString]].update(0, help)
        ___ptr
      extension (struct: Union1)
        def test: CLongInt = !struct.at(0).asInstanceOf[Ptr[CLongInt]]
        def test_=(value: CLongInt): Unit =
          !struct.at(0).asInstanceOf[Ptr[CLongInt]] = value
        def help: CString = !struct.at(0).asInstanceOf[Ptr[CString]]
        def help_=(value: CString): Unit =
          !struct.at(0).asInstanceOf[Ptr[CString]] = value
    end Union1
    given _tag: Tag[StructWithUnionArray] =
      Tag.materializeCStruct3Tag[CInt, StructWithUnionArray.Union0, CArray[
        StructWithUnionArray.Union1,
        Nat._2
      ]]
    def apply()(using Zone): Ptr[StructWithUnionArray] =
      scala.scalanative.unsafe.alloc[StructWithUnionArray](1)
    def apply(
        g_type: CInt,
        yo: StructWithUnionArray.Union0,
        data: CArray[StructWithUnionArray.Union1, Nat._2]
    )(using Zone): Ptr[StructWithUnionArray] =
      val ____ptr = apply()
      (!____ptr).g_type = g_type
      (!____ptr).yo = yo
      (!____ptr).data = data
      ____ptr
    end apply
    extension (struct: StructWithUnionArray)
      def g_type: CInt = struct._1
      def g_type_=(value: CInt): Unit = !struct.at1 = value
      def yo: StructWithUnionArray.Union0 = struct._2
      def yo_=(value: StructWithUnionArray.Union0): Unit = !struct.at2 = value
      def data: CArray[StructWithUnionArray.Union1, Nat._2] = struct._3
      def data_=(value: CArray[StructWithUnionArray.Union1, Nat._2]): Unit =
        !struct.at3 = value
  end StructWithUnionArray

  opaque type struct_with_union_array = CStruct3[
    CInt,
    struct_with_union_array.Union0,
    CArray[struct_with_union_array.Union1, Nat._2]
  ]
  object struct_with_union_array:
    opaque type Union0 = CArray[Byte, Nat._8]
    object Union0:
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_test")
      def apply(test: CLongInt)(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CLongInt]].update(0, test)
        ___ptr
      @scala.annotation.targetName("apply_help")
      def apply(help: CString)(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CString]].update(0, help)
        ___ptr
      extension (struct: Union0)
        def test: CLongInt = !struct.at(0).asInstanceOf[Ptr[CLongInt]]
        def test_=(value: CLongInt): Unit =
          !struct.at(0).asInstanceOf[Ptr[CLongInt]] = value
        def help: CString = !struct.at(0).asInstanceOf[Ptr[CString]]
        def help_=(value: CString): Unit =
          !struct.at(0).asInstanceOf[Ptr[CString]] = value
    end Union0
    opaque type Union1 = CArray[Byte, Nat._8]
    object Union1:
      given _tag: Tag[Union1] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      def apply()(using Zone): Ptr[Union1] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union1](1)
        ___ptr
      @scala.annotation.targetName("apply_test")
      def apply(test: CLongInt)(using Zone): Ptr[Union1] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union1](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CLongInt]].update(0, test)
        ___ptr
      @scala.annotation.targetName("apply_help")
      def apply(help: CString)(using Zone): Ptr[Union1] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union1](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CString]].update(0, help)
        ___ptr
      extension (struct: Union1)
        def test: CLongInt = !struct.at(0).asInstanceOf[Ptr[CLongInt]]
        def test_=(value: CLongInt): Unit =
          !struct.at(0).asInstanceOf[Ptr[CLongInt]] = value
        def help: CString = !struct.at(0).asInstanceOf[Ptr[CString]]
        def help_=(value: CString): Unit =
          !struct.at(0).asInstanceOf[Ptr[CString]] = value
    end Union1
    given _tag: Tag[struct_with_union_array] =
      Tag.materializeCStruct3Tag[CInt, struct_with_union_array.Union0, CArray[
        struct_with_union_array.Union1,
        Nat._2
      ]]
    def apply()(using Zone): Ptr[struct_with_union_array] =
      scala.scalanative.unsafe.alloc[struct_with_union_array](1)
    def apply(
        g_type: CInt,
        yo: struct_with_union_array.Union0,
        data: CArray[struct_with_union_array.Union1, Nat._2]
    )(using Zone): Ptr[struct_with_union_array] =
      val ____ptr = apply()
      (!____ptr).g_type = g_type
      (!____ptr).yo = yo
      (!____ptr).data = data
      ____ptr
    end apply
    extension (struct: struct_with_union_array)
      def g_type: CInt = struct._1
      def g_type_=(value: CInt): Unit = !struct.at1 = value
      def yo: struct_with_union_array.Union0 = struct._2
      def yo_=(value: struct_with_union_array.Union0): Unit = !struct.at2 =
        value
      def data: CArray[struct_with_union_array.Union1, Nat._2] = struct._3
      def data_=(value: CArray[struct_with_union_array.Union1, Nat._2]): Unit =
        !struct.at3 = value
  end struct_with_union_array
end structs

object unions:
  import _root_.lib_test_unions.structs.*
  import _root_.lib_test_unions.unions.*
  opaque type UnionEmpty = CArray[Byte, Nat._0]
  object UnionEmpty:
    given _tag: Tag[UnionEmpty] = Tag.CArray[CChar, Nat._0](Tag.Byte, Tag.Nat0)

  opaque type UnionOverlapping =
    CArray[Byte, Nat.Digit3[Nat._2, Nat._8, Nat._0]]
  object UnionOverlapping:
    given _tag: Tag[UnionOverlapping] =
      Tag.CArray[CChar, Nat.Digit3[Nat._2, Nat._8, Nat._0]](
        Tag.Byte,
        Tag.Digit3[Nat._2, Nat._8, Nat._0](Tag.Nat2, Tag.Nat8, Tag.Nat0)
      )
    def apply()(using Zone): Ptr[UnionOverlapping] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionOverlapping](1)
      ___ptr
    @scala.annotation.targetName("apply_p")
    def apply(p: CArray[CLongInt, Nat.Digit2[Nat._3, Nat._5]])(using
        Zone
    ): Ptr[UnionOverlapping] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionOverlapping](1)
      val un = !___ptr
      un.at(0)
        .asInstanceOf[Ptr[CArray[CLongInt, Nat.Digit2[Nat._3, Nat._5]]]]
        .update(0, p)
      ___ptr
    end apply
    @scala.annotation.targetName("apply_d")
    def apply(d: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]])(using
        Zone
    ): Ptr[UnionOverlapping] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionOverlapping](1)
      val un = !___ptr
      un.at(0)
        .asInstanceOf[Ptr[CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]]
        .update(0, d)
      ___ptr
    end apply
    extension (struct: UnionOverlapping)
      def p: CArray[CLongInt, Nat.Digit2[Nat._3, Nat._5]] = !struct
        .at(0)
        .asInstanceOf[Ptr[CArray[CLongInt, Nat.Digit2[Nat._3, Nat._5]]]]
      def p_=(value: CArray[CLongInt, Nat.Digit2[Nat._3, Nat._5]]): Unit =
        !struct
          .at(0)
          .asInstanceOf[Ptr[CArray[CLongInt, Nat.Digit2[Nat._3, Nat._5]]]] =
          value
      def d: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]] = !struct
        .at(0)
        .asInstanceOf[Ptr[CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]]
      def d_=(value: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]): Unit = !struct
        .at(0)
        .asInstanceOf[Ptr[CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]] = value
    end extension
  end UnionOverlapping

  opaque type UnionSimple = CArray[Byte, Nat._8]
  object UnionSimple:
    given _tag: Tag[UnionSimple] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
    def apply()(using Zone): Ptr[UnionSimple] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionSimple](1)
      ___ptr
    @scala.annotation.targetName("apply_i")
    def apply(i: CUnsignedInt)(using Zone): Ptr[UnionSimple] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionSimple](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CUnsignedInt]].update(0, i)
      ___ptr
    @scala.annotation.targetName("apply_b")
    def apply(b: Float)(using Zone): Ptr[UnionSimple] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionSimple](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[Float]].update(0, b)
      ___ptr
    @scala.annotation.targetName("apply_s")
    def apply(s: CString)(using Zone): Ptr[UnionSimple] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionSimple](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CString]].update(0, s)
      ___ptr
    extension (struct: UnionSimple)
      def i: CUnsignedInt = !struct.at(0).asInstanceOf[Ptr[CUnsignedInt]]
      def i_=(value: CUnsignedInt): Unit =
        !struct.at(0).asInstanceOf[Ptr[CUnsignedInt]] = value
      def b: Float = !struct.at(0).asInstanceOf[Ptr[Float]]
      def b_=(value: Float): Unit = !struct.at(0).asInstanceOf[Ptr[Float]] =
        value
      def s: CString = !struct.at(0).asInstanceOf[Ptr[CString]]
      def s_=(value: CString): Unit = !struct.at(0).asInstanceOf[Ptr[CString]] =
        value
    end extension
  end UnionSimple

  opaque type empty_union = CArray[Byte, Nat._0]
  object empty_union:
    given _tag: Tag[empty_union] = Tag.CArray[CChar, Nat._0](Tag.Byte, Tag.Nat0)
end unions

object types:
  export _root_.lib_test_unions.structs.*
  export _root_.lib_test_unions.unions.*

object all:
  export _root_.lib_test_unions.structs.StructWithUnionArray
  export _root_.lib_test_unions.structs.struct_with_union_array
  export _root_.lib_test_unions.unions.UnionEmpty
  export _root_.lib_test_unions.unions.UnionOverlapping
  export _root_.lib_test_unions.unions.UnionSimple
  export _root_.lib_test_unions.unions.empty_union
