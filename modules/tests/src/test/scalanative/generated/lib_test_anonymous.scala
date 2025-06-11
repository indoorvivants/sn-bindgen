package lib_test_anonymous

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object structs:
  import _root_.lib_test_anonymous.structs.*
  import _root_.lib_test_anonymous.unions.*
  opaque type AnonymousNestedStruct =
    CStruct2[AnonymousNestedStruct.Union0, CInt]
  object AnonymousNestedStruct:
    opaque type Union0 = CArray[Byte, Nat._8]
    object Union0:
      opaque type Struct0 = CStruct2[CInt, CInt]
      object Struct0:
        given _tag: Tag[Struct0] = Tag.materializeCStruct2Tag[CInt, CInt]
        def apply()(using Zone): Ptr[Struct0] =
          scala.scalanative.unsafe.alloc[Struct0](1)
        def apply(hat: CInt, hat_mask: CInt)(using Zone): Ptr[Struct0] =
          val ____ptr = apply()
          (!____ptr).hat = hat
          (!____ptr).hat_mask = hat_mask
          ____ptr
        extension (struct: Struct0)
          def hat: CInt = struct._1
          def hat_=(value: CInt): Unit = !struct.at1 = value
          def hat_mask: CInt = struct._2
          def hat_mask_=(value: CInt): Unit = !struct.at2 = value
      end Struct0
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_button")
      def apply(button: CInt)(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CInt]].update(0, button)
        ___ptr
      @scala.annotation.targetName("apply_axis")
      def apply(axis: Float)(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Float]].update(0, axis)
        ___ptr
      @scala.annotation.targetName("apply_headgear")
      def apply(headgear: AnonymousNestedStruct.Union0.Struct0)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[AnonymousNestedStruct.Union0.Struct0]]
          .update(0, headgear)
        ___ptr
      end apply
      extension (struct: Union0)
        def button: CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
        def button_=(value: CInt): Unit =
          !struct.at(0).asInstanceOf[Ptr[CInt]] = value
        def axis: Float = !struct.at(0).asInstanceOf[Ptr[Float]]
        def axis_=(value: Float): Unit =
          !struct.at(0).asInstanceOf[Ptr[Float]] = value
        def headgear: AnonymousNestedStruct.Union0.Struct0 =
          !struct.at(0).asInstanceOf[Ptr[AnonymousNestedStruct.Union0.Struct0]]
        def headgear_=(value: AnonymousNestedStruct.Union0.Struct0): Unit =
          !struct
            .at(0)
            .asInstanceOf[Ptr[AnonymousNestedStruct.Union0.Struct0]] = value
      end extension
    end Union0
    given _tag: Tag[AnonymousNestedStruct] =
      Tag.materializeCStruct2Tag[AnonymousNestedStruct.Union0, CInt]
    def apply()(using Zone): Ptr[AnonymousNestedStruct] =
      scala.scalanative.unsafe.alloc[AnonymousNestedStruct](1)
    def apply(value: AnonymousNestedStruct.Union0, test: CInt)(using
        Zone
    ): Ptr[AnonymousNestedStruct] =
      val ____ptr = apply()
      (!____ptr).value = value
      (!____ptr).test = test
      ____ptr
    extension (struct: AnonymousNestedStruct)
      def value: AnonymousNestedStruct.Union0 = struct._1
      def value_=(value: AnonymousNestedStruct.Union0): Unit = !struct.at1 =
        value
      def test: CInt = struct._2
      def test_=(value: CInt): Unit = !struct.at2 = value
  end AnonymousNestedStruct
end structs

object unions:
  import _root_.lib_test_anonymous.structs.*
  import _root_.lib_test_anonymous.unions.*
  opaque type AnonymousNestedUnion = CArray[Byte, Nat._8]
  object AnonymousNestedUnion:
    opaque type Union0 = CArray[Byte, Nat._8]
    object Union0:
      opaque type Struct0 = CStruct2[CInt, CInt]
      object Struct0:
        given _tag: Tag[Struct0] = Tag.materializeCStruct2Tag[CInt, CInt]
        def apply()(using Zone): Ptr[Struct0] =
          scala.scalanative.unsafe.alloc[Struct0](1)
        def apply(hat: CInt, hat_mask: CInt)(using Zone): Ptr[Struct0] =
          val ____ptr = apply()
          (!____ptr).hat = hat
          (!____ptr).hat_mask = hat_mask
          ____ptr
        extension (struct: Struct0)
          def hat: CInt = struct._1
          def hat_=(value: CInt): Unit = !struct.at1 = value
          def hat_mask: CInt = struct._2
          def hat_mask_=(value: CInt): Unit = !struct.at2 = value
      end Struct0
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_button")
      def apply(button: CInt)(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CInt]].update(0, button)
        ___ptr
      @scala.annotation.targetName("apply_axis")
      def apply(axis: Float)(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[Float]].update(0, axis)
        ___ptr
      @scala.annotation.targetName("apply_headgear")
      def apply(headgear: AnonymousNestedUnion.Union0.Struct0)(using
          Zone
      ): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0)
          .asInstanceOf[Ptr[AnonymousNestedUnion.Union0.Struct0]]
          .update(0, headgear)
        ___ptr
      end apply
      extension (struct: Union0)
        def button: CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
        def button_=(value: CInt): Unit =
          !struct.at(0).asInstanceOf[Ptr[CInt]] = value
        def axis: Float = !struct.at(0).asInstanceOf[Ptr[Float]]
        def axis_=(value: Float): Unit =
          !struct.at(0).asInstanceOf[Ptr[Float]] = value
        def headgear: AnonymousNestedUnion.Union0.Struct0 =
          !struct.at(0).asInstanceOf[Ptr[AnonymousNestedUnion.Union0.Struct0]]
        def headgear_=(value: AnonymousNestedUnion.Union0.Struct0): Unit =
          !struct.at(0).asInstanceOf[Ptr[AnonymousNestedUnion.Union0.Struct0]] =
            value
      end extension
    end Union0
    given _tag: Tag[AnonymousNestedUnion] =
      Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
    def apply()(using Zone): Ptr[AnonymousNestedUnion] =
      val ___ptr =
        _root_.scala.scalanative.unsafe.alloc[AnonymousNestedUnion](1)
      ___ptr
    @scala.annotation.targetName("apply_value")
    def apply(value: AnonymousNestedUnion.Union0)(using
        Zone
    ): Ptr[AnonymousNestedUnion] =
      val ___ptr =
        _root_.scala.scalanative.unsafe.alloc[AnonymousNestedUnion](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[AnonymousNestedUnion.Union0]].update(0, value)
      ___ptr
    @scala.annotation.targetName("apply_test")
    def apply(test: CInt)(using Zone): Ptr[AnonymousNestedUnion] =
      val ___ptr =
        _root_.scala.scalanative.unsafe.alloc[AnonymousNestedUnion](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, test)
      ___ptr
    extension (struct: AnonymousNestedUnion)
      def value: AnonymousNestedUnion.Union0 =
        !struct.at(0).asInstanceOf[Ptr[AnonymousNestedUnion.Union0]]
      def value_=(value: AnonymousNestedUnion.Union0): Unit =
        !struct.at(0).asInstanceOf[Ptr[AnonymousNestedUnion.Union0]] = value
      def test: CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def test_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] =
        value
  end AnonymousNestedUnion
end unions

object types:
  export _root_.lib_test_anonymous.structs.*
  export _root_.lib_test_anonymous.unions.*

object all:
  export _root_.lib_test_anonymous.structs.AnonymousNestedStruct
  export _root_.lib_test_anonymous.unions.AnonymousNestedUnion
