package lib_test_structs

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object predef:
  private[lib_test_structs] trait _BindgenEnumCUnsignedInt[T](using
      eq: T =:= CUnsignedInt
  ):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
    extension (inline t: T)
      inline def value: CUnsignedInt = eq.apply(t)
      inline def int: CInt = eq.apply(t).toInt
      inline def uint: CUnsignedInt = eq.apply(t)

object enumerations:
  import predef.*

  /** bindgen: --render.opaque-structs StructComplexOpaque
    */
  opaque type my_bool = CUnsignedInt
  object my_bool extends _BindgenEnumCUnsignedInt[my_bool]:
    given _tag: Tag[my_bool] = Tag.UInt
    inline def define(inline a: Long): my_bool = a.toUInt
    val m_false = define(0)
    val m_true = define(1)
    inline def getName(inline value: my_bool): Option[String] =
      inline value match
        case m_false => Some("m_false")
        case m_true  => Some("m_true")
        case _       => _root_.scala.None
    extension (a: my_bool)
      inline def &(b: my_bool): my_bool = a & b
      inline def |(b: my_bool): my_bool = a | b
      inline def is(b: my_bool): Boolean = (a & b) == b
  end my_bool
end enumerations

object structs:
  import _root_.lib_test_structs.enumerations.*
  import _root_.lib_test_structs.predef.*
  import _root_.lib_test_structs.structs.*
  type StructAnonymousB = {
    def str: CString
  }
  opaque type StructAnonymous <: StructAnonymousB =
    CStruct3[CInt, StructAnonymous.Union0, StructAnonymous.Struct1]
  object StructAnonymous:
    opaque type Union0 = CArray[Byte, Nat._8]
    object Union0:
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_str")
      def apply(str: CString)(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CString]].update(0, str)
        ___ptr
      @scala.annotation.targetName("apply_num")
      def apply(num: CInt)(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CInt]].update(0, num)
        ___ptr
      extension (struct: Union0)
        def str: CString = !struct.at(0).asInstanceOf[Ptr[CString]]
        def str_=(value: CString): Unit =
          !struct.at(0).asInstanceOf[Ptr[CString]] = value
        def num: CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
        def num_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] =
          value
    end Union0
    opaque type Struct1 = CStruct2[CString, CString]
    object Struct1:
      given _tag: Tag[Struct1] = Tag.materializeCStruct2Tag[CString, CString]
      def apply()(using Zone): Ptr[Struct1] =
        scala.scalanative.unsafe.alloc[Struct1](1)
      def apply(key: CString, value: CString)(using Zone): Ptr[Struct1] =
        val ____ptr = apply()
        (!____ptr).key = key
        (!____ptr).value = value
        ____ptr
      extension (struct: Struct1)
        def key: CString = struct._1
        def key_=(value: CString): Unit = !struct.at1 = value
        def value: CString = struct._2
        def value_=(value: CString): Unit = !struct.at2 = value
    end Struct1
    given _tag: Tag[StructAnonymous] = Tag.materializeCStruct3Tag[
      CInt,
      StructAnonymous.Union0,
      StructAnonymous.Struct1
    ]
    def apply()(using Zone): Ptr[StructAnonymous] =
      scala.scalanative.unsafe.alloc[StructAnonymous](1)
    def apply(
        x: CInt,
        context: StructAnonymous.Union0,
        header: StructAnonymous.Struct1
    )(using Zone): Ptr[StructAnonymous] =
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).context = context
      (!____ptr).header = header
      ____ptr
    end apply
    extension (struct: StructAnonymous)
      def x: CInt = struct._1
      def x_=(value: CInt): Unit = !struct.at1 = value
      def context: StructAnonymous.Union0 = struct._2
      def context_=(value: StructAnonymous.Union0): Unit = !struct.at2 = value
      def header: StructAnonymous.Struct1 = struct._3
      def header_=(value: StructAnonymous.Struct1): Unit = !struct.at3 = value
  end StructAnonymous

  opaque type StructComplex = CStruct8[
    StructSimple,
    StructSimple,
    CInt,
    StructComplex.Struct0,
    my_bool,
    StructComplex.Struct1,
    CString,
    CArray[CInt, Nat.Digit2[Nat._2, Nat._5]]
  ]
  object StructComplex:
    opaque type Struct0 = CStruct1[CChar]
    object Struct0:
      given _tag: Tag[Struct0] = Tag.materializeCStruct1Tag[CChar]
      def apply()(using Zone): Ptr[Struct0] =
        scala.scalanative.unsafe.alloc[Struct0](1)
      def apply(yo: CChar)(using Zone): Ptr[Struct0] =
        val ____ptr = apply()
        (!____ptr).yo = yo
        ____ptr
      extension (struct: Struct0)
        def yo: CChar = struct._1
        def yo_=(value: CChar): Unit = !struct.at1 = value
    end Struct0
    opaque type Struct1 = CStruct1[CInt]
    object Struct1:
      given _tag: Tag[Struct1] = Tag.materializeCStruct1Tag[CInt]
      def apply()(using Zone): Ptr[Struct1] =
        scala.scalanative.unsafe.alloc[Struct1](1)
      def apply(HELLO: CInt)(using Zone): Ptr[Struct1] =
        val ____ptr = apply()
        (!____ptr).HELLO = HELLO
        ____ptr
      extension (struct: Struct1)
        def HELLO: CInt = struct._1
        def HELLO_=(value: CInt): Unit = !struct.at1 = value
    end Struct1
    given _tag: Tag[StructComplex] = Tag.materializeCStruct8Tag[
      StructSimple,
      StructSimple,
      CInt,
      StructComplex.Struct0,
      my_bool,
      StructComplex.Struct1,
      CString,
      CArray[CInt, Nat.Digit2[Nat._2, Nat._5]]
    ]
    def apply()(using Zone): Ptr[StructComplex] =
      scala.scalanative.unsafe.alloc[StructComplex](1)
    def apply(
        p1: StructSimple,
        p2: StructSimple,
        x: CInt,
        kiss: StructComplex.Struct0,
        flag: my_bool,
        yass: StructComplex.Struct1,
        bla: CString,
        test: CArray[CInt, Nat.Digit2[Nat._2, Nat._5]]
    )(using Zone): Ptr[StructComplex] =
      val ____ptr = apply()
      (!____ptr).p1 = p1
      (!____ptr).p2 = p2
      (!____ptr).x = x
      (!____ptr).kiss = kiss
      (!____ptr).flag = flag
      (!____ptr).yass = yass
      (!____ptr).bla = bla
      (!____ptr).test = test
      ____ptr
    end apply
    extension (struct: StructComplex)
      def p1: StructSimple = struct._1
      def p1_=(value: StructSimple): Unit = !struct.at1 = value
      def p2: StructSimple = struct._2
      def p2_=(value: StructSimple): Unit = !struct.at2 = value
      def x: CInt = struct._3
      def x_=(value: CInt): Unit = !struct.at3 = value
      def kiss: StructComplex.Struct0 = struct._4
      def kiss_=(value: StructComplex.Struct0): Unit = !struct.at4 = value
      def flag: my_bool = struct._5
      def flag_=(value: my_bool): Unit = !struct.at5 = value
      def yass: StructComplex.Struct1 = struct._6
      def yass_=(value: StructComplex.Struct1): Unit = !struct.at6 = value
      def bla: CString = struct._7
      def bla_=(value: CString): Unit = !struct.at7 = value
      def test: CArray[CInt, Nat.Digit2[Nat._2, Nat._5]] = struct._8
      def test_=(value: CArray[CInt, Nat.Digit2[Nat._2, Nat._5]]): Unit =
        !struct.at8 = value
    end extension
  end StructComplex

  opaque type StructComplexOpaque =
    CArray[CChar, Nat.Digit3[Nat._2, Nat._1, Nat._6]]
  object StructComplexOpaque:
    opaque type Struct0 = CStruct1[CChar]
    object Struct0:
      given _tag: Tag[Struct0] = Tag.materializeCStruct1Tag[CChar]
      def apply()(using Zone): Ptr[Struct0] =
        scala.scalanative.unsafe.alloc[Struct0](1)
      def apply(yo: CChar)(using Zone): Ptr[Struct0] =
        val ____ptr = apply()
        (!____ptr).yo = yo
        ____ptr
      extension (struct: Struct0)
        def yo: CChar = struct._1
        def yo_=(value: CChar): Unit = !struct.at1 = value
    end Struct0
    opaque type Struct1 = CStruct1[CInt]
    object Struct1:
      given _tag: Tag[Struct1] = Tag.materializeCStruct1Tag[CInt]
      def apply()(using Zone): Ptr[Struct1] =
        scala.scalanative.unsafe.alloc[Struct1](1)
      def apply(HELLO: CInt)(using Zone): Ptr[Struct1] =
        val ____ptr = apply()
        (!____ptr).HELLO = HELLO
        ____ptr
      extension (struct: Struct1)
        def HELLO: CInt = struct._1
        def HELLO_=(value: CInt): Unit = !struct.at1 = value
    end Struct1
    opaque type Union2 = CArray[Byte, Nat._8]
    object Union2:
      given _tag: Tag[Union2] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      def apply()(using Zone): Ptr[Union2] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union2](1)
        ___ptr
      @scala.annotation.targetName("apply_u0")
      def apply(u0: CInt)(using Zone): Ptr[Union2] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union2](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CInt]].update(0, u0)
        ___ptr
      @scala.annotation.targetName("apply_u1")
      def apply(u1: CLongInt)(using Zone): Ptr[Union2] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union2](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CLongInt]].update(0, u1)
        ___ptr
      extension (struct: Union2)
        def u0: CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
        def u0_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] =
          value
        def u1: CLongInt = !struct.at(0).asInstanceOf[Ptr[CLongInt]]
        def u1_=(value: CLongInt): Unit =
          !struct.at(0).asInstanceOf[Ptr[CLongInt]] = value
    end Union2
    opaque type Union3 = CArray[Byte, Nat._8]
    object Union3:
      given _tag: Tag[Union3] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      def apply()(using Zone): Ptr[Union3] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union3](1)
        ___ptr
      @scala.annotation.targetName("apply_r0")
      def apply(r0: CInt)(using Zone): Ptr[Union3] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union3](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CInt]].update(0, r0)
        ___ptr
      @scala.annotation.targetName("apply_r1")
      def apply(r1: CLongInt)(using Zone): Ptr[Union3] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union3](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CLongInt]].update(0, r1)
        ___ptr
      extension (struct: Union3)
        def r0: CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
        def r0_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] =
          value
        def r1: CLongInt = !struct.at(0).asInstanceOf[Ptr[CLongInt]]
        def r1_=(value: CLongInt): Unit =
          !struct.at(0).asInstanceOf[Ptr[CLongInt]] = value
    end Union3
    opaque type Union4 = CArray[Byte, Nat._8]
    object Union4:
      given _tag: Tag[Union4] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      def apply()(using Zone): Ptr[Union4] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union4](1)
        ___ptr
      @scala.annotation.targetName("apply_u0")
      def apply(u0: CInt)(using Zone): Ptr[Union4] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union4](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CInt]].update(0, u0)
        ___ptr
      @scala.annotation.targetName("apply_u1")
      def apply(u1: CLongInt)(using Zone): Ptr[Union4] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union4](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CLongInt]].update(0, u1)
        ___ptr
      extension (struct: Union4)
        def u0: CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
        def u0_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] =
          value
        def u1: CLongInt = !struct.at(0).asInstanceOf[Ptr[CLongInt]]
        def u1_=(value: CLongInt): Unit =
          !struct.at(0).asInstanceOf[Ptr[CLongInt]] = value
    end Union4
    given _tag: Tag[StructComplexOpaque] =
      Tag.CArray[CChar, Nat.Digit3[Nat._2, Nat._1, Nat._6]](
        Tag.Byte,
        Tag.Digit3[Nat._2, Nat._1, Nat._6](Tag.Nat2, Tag.Nat1, Tag.Nat6)
      )
    def apply()(using Zone): Ptr[StructComplexOpaque] =
      scala.scalanative.unsafe.alloc[StructComplexOpaque](1)
    def apply(
        p1: StructSimple,
        p2: StructSimple,
        x: CInt,
        kiss: StructComplexOpaque.Struct0,
        flag: my_bool,
        yass: StructComplexOpaque.Struct1,
        bla: CString,
        test: CArray[CInt, Nat.Digit2[Nat._2, Nat._5]],
        flan: CArray[StructComplexOpaque.Union3, Nat._2],
        y: Double,
        top: StructComplexOpaque.Union4
    )(using Zone): Ptr[StructComplexOpaque] =
      val ____ptr = apply()
      (!____ptr).p1 = p1
      (!____ptr).p2 = p2
      (!____ptr).x = x
      (!____ptr).kiss = kiss
      (!____ptr).flag = flag
      (!____ptr).yass = yass
      (!____ptr).bla = bla
      (!____ptr).test = test
      (!____ptr).flan = flan
      (!____ptr).y = y
      (!____ptr).top = top
      ____ptr
    end apply
    extension (struct: StructComplexOpaque)
      def p1: StructSimple =
        !struct.at(offsets(0)).asInstanceOf[Ptr[StructSimple]]
      def p1_=(value: StructSimple): Unit =
        !struct.at(offsets(0)).asInstanceOf[Ptr[StructSimple]] = value
      def p2: StructSimple =
        !struct.at(offsets(1)).asInstanceOf[Ptr[StructSimple]]
      def p2_=(value: StructSimple): Unit =
        !struct.at(offsets(1)).asInstanceOf[Ptr[StructSimple]] = value
      def x: CInt = !struct.at(offsets(2)).asInstanceOf[Ptr[CInt]]
      def x_=(value: CInt): Unit =
        !struct.at(offsets(2)).asInstanceOf[Ptr[CInt]] = value
      def kiss: StructComplexOpaque.Struct0 =
        !struct.at(offsets(3)).asInstanceOf[Ptr[StructComplexOpaque.Struct0]]
      def kiss_=(value: StructComplexOpaque.Struct0): Unit =
        !struct.at(offsets(3)).asInstanceOf[Ptr[StructComplexOpaque.Struct0]] =
          value
      def flag: my_bool = !struct.at(offsets(4)).asInstanceOf[Ptr[my_bool]]
      def flag_=(value: my_bool): Unit =
        !struct.at(offsets(4)).asInstanceOf[Ptr[my_bool]] = value
      def yass: StructComplexOpaque.Struct1 =
        !struct.at(offsets(5)).asInstanceOf[Ptr[StructComplexOpaque.Struct1]]
      def yass_=(value: StructComplexOpaque.Struct1): Unit =
        !struct.at(offsets(5)).asInstanceOf[Ptr[StructComplexOpaque.Struct1]] =
          value
      def bla: CString = !struct.at(offsets(6)).asInstanceOf[Ptr[CString]]
      def bla_=(value: CString): Unit =
        !struct.at(offsets(6)).asInstanceOf[Ptr[CString]] = value
      def test: CArray[CInt, Nat.Digit2[Nat._2, Nat._5]] = !struct
        .at(offsets(8))
        .asInstanceOf[Ptr[CArray[CInt, Nat.Digit2[Nat._2, Nat._5]]]]
      def test_=(value: CArray[CInt, Nat.Digit2[Nat._2, Nat._5]]): Unit =
        !struct
          .at(offsets(8))
          .asInstanceOf[Ptr[CArray[CInt, Nat.Digit2[Nat._2, Nat._5]]]] = value
      def flan: CArray[StructComplexOpaque.Union3, Nat._2] = !struct
        .at(offsets(9))
        .asInstanceOf[Ptr[CArray[StructComplexOpaque.Union3, Nat._2]]]
      def flan_=(value: CArray[StructComplexOpaque.Union3, Nat._2]): Unit =
        !struct
          .at(offsets(9))
          .asInstanceOf[Ptr[CArray[StructComplexOpaque.Union3, Nat._2]]] = value
      def y: Double = !struct.at(offsets(10)).asInstanceOf[Ptr[Double]]
      def y_=(value: Double): Unit =
        !struct.at(offsets(10)).asInstanceOf[Ptr[Double]] = value
      def top: StructComplexOpaque.Union4 =
        !struct.at(offsets(11)).asInstanceOf[Ptr[StructComplexOpaque.Union4]]
      def top_=(value: StructComplexOpaque.Union4): Unit =
        !struct.at(offsets(11)).asInstanceOf[Ptr[StructComplexOpaque.Union4]] =
          value
    end extension
    val offsets: Array[Int] =
      val res = Array.ofDim[Int](12)
      def align(offset: Int, alignment: Int) =
        val alignmentMask = alignment - 1
        val padding =
          if (offset & alignmentMask) == 0 then 0
          else alignment - (offset & alignmentMask)
        offset + padding

      res(0) = align(0, alignmentof[StructSimple].toInt)
      res(1) = align(
        res(0) + sizeof[StructSimple].toInt,
        alignmentof[StructSimple].toInt
      )
      res(2) =
        align(res(1) + sizeof[StructSimple].toInt, alignmentof[CInt].toInt)
      res(3) = align(
        res(2) + sizeof[CInt].toInt,
        alignmentof[StructComplexOpaque.Struct0].toInt
      )
      res(4) = align(
        res(3) + sizeof[StructComplexOpaque.Struct0].toInt,
        alignmentof[my_bool].toInt
      )
      res(5) = align(
        res(4) + sizeof[my_bool].toInt,
        alignmentof[StructComplexOpaque.Struct1].toInt
      )
      res(6) = align(
        res(5) + sizeof[StructComplexOpaque.Struct1].toInt,
        alignmentof[CString].toInt
      )
      res(7) = align(
        res(6) + sizeof[CString].toInt,
        Array(alignmentof[CInt].toInt, alignmentof[CLongInt].toInt).max
      )
      res(8) = align(
        res(7) + sizeof[CArray[Byte, Nat._8]].toInt,
        alignmentof[CInt].toInt
      )
      res(9) = align(
        res(8) + sizeof[CArray[CInt, Nat.Digit2[Nat._2, Nat._5]]].toInt,
        Array(alignmentof[CInt].toInt, alignmentof[CLongInt].toInt).max
      )
      res(10) = align(
        res(9) + sizeof[CArray[StructComplexOpaque.Union3, Nat._2]].toInt,
        alignmentof[Double].toInt
      )
      res(11) = align(
        res(10) + sizeof[Double].toInt,
        Array(alignmentof[CInt].toInt, alignmentof[CLongInt].toInt).max
      )
      res
    end offsets
  end StructComplexOpaque

  opaque type StructSimple = CStruct4[CInt, CInt, CString, CString]
  object StructSimple:
    given _tag: Tag[StructSimple] =
      Tag.materializeCStruct4Tag[CInt, CInt, CString, CString]
    def apply()(using Zone): Ptr[StructSimple] =
      scala.scalanative.unsafe.alloc[StructSimple](1)
    def apply(x: CInt, y: CInt, s1: CString, s2: CString)(using
        Zone
    ): Ptr[StructSimple] =
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).s1 = s1
      (!____ptr).s2 = s2
      ____ptr
    extension (struct: StructSimple)
      def x: CInt = struct._1
      def x_=(value: CInt): Unit = !struct.at1 = value
      def y: CInt = struct._2
      def y_=(value: CInt): Unit = !struct.at2 = value
      def s1: CString = struct._3
      def s1_=(value: CString): Unit = !struct.at3 = value
      def s2: CString = struct._4
      def s2_=(value: CString): Unit = !struct.at4 = value
  end StructSimple
end structs

@extern
private[lib_test_structs] object extern_functions:
  import _root_.lib_test_structs.enumerations.*
  import _root_.lib_test_structs.predef.*
  import _root_.lib_test_structs.structs.*
  def write_offsets(offsets: Ptr[CInt]): Unit = extern

object functions:
  import _root_.lib_test_structs.enumerations.*
  import _root_.lib_test_structs.predef.*
  import _root_.lib_test_structs.structs.*
  import extern_functions.*
  export extern_functions.*

object types:
  export _root_.lib_test_structs.structs.*
  export _root_.lib_test_structs.enumerations.*

object all:
  export _root_.lib_test_structs.enumerations.my_bool
  export _root_.lib_test_structs.structs.StructAnonymous
  export _root_.lib_test_structs.structs.StructComplex
  export _root_.lib_test_structs.structs.StructComplexOpaque
  export _root_.lib_test_structs.structs.StructSimple
  export _root_.lib_test_structs.functions.write_offsets
