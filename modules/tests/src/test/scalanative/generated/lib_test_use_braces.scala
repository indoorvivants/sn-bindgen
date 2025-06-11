package lib_test_use_braces

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object predef:
  private[lib_test_use_braces] trait _BindgenEnumCUnsignedInt[T](using
      eq: T =:= CUnsignedInt
  ):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
    extension (inline t: T)
      inline def value: CUnsignedInt = eq.apply(t)
      inline def int: CInt = eq.apply(t).toInt
      inline def uint: CUnsignedInt = eq.apply(t)

object enumerations:
  import predef.*
  opaque type Bla = CUnsignedInt
  object Bla extends _BindgenEnumCUnsignedInt[Bla]:
    given _tag: Tag[Bla] = Tag.UInt
    inline def define(inline a: Long): Bla = a.toUInt
    val A = define(0)
    val B = define(1)
    inline def getName(inline value: Bla): Option[String] =
      inline value match
        case A => Some("A")
        case B => Some("B")
        case _ => _root_.scala.None
    extension (a: Bla)
      inline def &(b: Bla): Bla = a & b
      inline def |(b: Bla): Bla = a | b
      inline def is(b: Bla): Boolean = (a & b) == b
  end Bla
end enumerations

object aliases:
  import _root_.lib_test_use_braces.enumerations.*
  import _root_.lib_test_use_braces.predef.*
  import _root_.lib_test_use_braces.aliases.*
  import _root_.lib_test_use_braces.structs.*
  import _root_.lib_test_use_braces.unions.*
  type HelloAlias = Hello
  object HelloAlias:
    given _tag: Tag[HelloAlias] = Hello._tag
    inline def apply(inline o: Hello): HelloAlias = o
    extension (v: HelloAlias) inline def value: Hello = v

  opaque type Howdy = Float
  object Howdy:
    given _tag: Tag[Howdy] = Tag.Float
    inline def apply(inline o: Float): Howdy = o
    extension (v: Howdy) inline def value: Float = v
end aliases

object structs:
  import _root_.lib_test_use_braces.enumerations.*
  import _root_.lib_test_use_braces.predef.*
  import _root_.lib_test_use_braces.aliases.*
  import _root_.lib_test_use_braces.structs.*
  import _root_.lib_test_use_braces.unions.*
  opaque type Hello = CStruct2[CInt, Howdy]
  object Hello:
    given _tag: Tag[Hello] = Tag.materializeCStruct2Tag[CInt, Howdy]
    def apply()(using Zone): Ptr[Hello] =
      scala.scalanative.unsafe.alloc[Hello](1)
    def apply(bla: CInt, yes: Howdy)(using Zone): Ptr[Hello] =
      val ____ptr = apply()
      (!____ptr).bla = bla
      (!____ptr).yes = yes
      ____ptr
    extension (struct: Hello)
      def bla: CInt = struct._1
      def bla_=(value: CInt): Unit = !struct.at1 = value
      def yes: Howdy = struct._2
      def yes_=(value: Howdy): Unit = !struct.at2 = value
  end Hello
end structs

object unions:
  import _root_.lib_test_use_braces.enumerations.*
  import _root_.lib_test_use_braces.predef.*
  import _root_.lib_test_use_braces.aliases.*
  import _root_.lib_test_use_braces.structs.*
  import _root_.lib_test_use_braces.unions.*

  /** bindgen: --use-braces
    */
  opaque type Test = CArray[Byte, Nat._4]
  object Test:
    opaque type Struct0 = CStruct1[CInt]
    object Struct0:
      given _tag: Tag[Struct0] = Tag.materializeCStruct1Tag[CInt]
      def apply()(using Zone): Ptr[Struct0] =
        scala.scalanative.unsafe.alloc[Struct0](1)
      def apply(a: CInt)(using Zone): Ptr[Struct0] =
        val ____ptr = apply()
        (!____ptr).a = a
        ____ptr
      extension (struct: Struct0)
        def a: CInt = struct._1
        def a_=(value: CInt): Unit = !struct.at1 = value
    end Struct0
    given _tag: Tag[Test] = Tag.CArray[CChar, Nat._4](Tag.Byte, Tag.Nat4)
    def apply()(using Zone): Ptr[Test] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[Test](1)
      ___ptr
    @scala.annotation.targetName("apply_x")
    def apply(x: CInt)(using Zone): Ptr[Test] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[Test](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, x)
      ___ptr
    @scala.annotation.targetName("apply_y")
    def apply(y: CChar)(using Zone): Ptr[Test] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[Test](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CChar]].update(0, y)
      ___ptr
    @scala.annotation.targetName("apply_hello")
    def apply(hello: Test.Struct0)(using Zone): Ptr[Test] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[Test](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[Test.Struct0]].update(0, hello)
      ___ptr
    extension (struct: Test)
      def x: CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def x_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
      def y: CChar = !struct.at(0).asInstanceOf[Ptr[CChar]]
      def y_=(value: CChar): Unit = !struct.at(0).asInstanceOf[Ptr[CChar]] =
        value
      def hello: Test.Struct0 = !struct.at(0).asInstanceOf[Ptr[Test.Struct0]]
      def hello_=(value: Test.Struct0): Unit =
        !struct.at(0).asInstanceOf[Ptr[Test.Struct0]] = value
  end Test
end unions

@extern
private[lib_test_use_braces] object extern_functions:
  import _root_.lib_test_use_braces.enumerations.*
  import _root_.lib_test_use_braces.predef.*
  import _root_.lib_test_use_braces.aliases.*
  import _root_.lib_test_use_braces.structs.*
  import _root_.lib_test_use_braces.unions.*
  private[lib_test_use_braces] def __sn_wrap_lib_test_use_braces_naughty(
      st: Ptr[Hello]
  ): Unit = extern

  private[lib_test_use_braces] def __sn_wrap_lib_test_use_braces_run(
      i: CInt,
      h: Float,
      test: Ptr[HelloAlias],
      verify: Test
  ): CUnsignedInt = extern

  def nice(st: CChar): Unit = extern

  def test_varargs(i: CInt, rest: Any*): CInt = extern
end extern_functions

object functions:
  import _root_.lib_test_use_braces.enumerations.*
  import _root_.lib_test_use_braces.predef.*
  import _root_.lib_test_use_braces.aliases.*
  import _root_.lib_test_use_braces.structs.*
  import _root_.lib_test_use_braces.unions.*
  import extern_functions.*
  export extern_functions.*

  def naughty(st: Ptr[Hello]): Unit =
    __sn_wrap_lib_test_use_braces_naughty(st)

  def naughty(st: Hello)(using Zone): Unit =
    val __ptr_0: Ptr[Hello] = _root_.scala.scalanative.unsafe.alloc[Hello](1)
    !(__ptr_0 + 0) = st
    __sn_wrap_lib_test_use_braces_naughty((__ptr_0 + 0))

  def run(
      i: CInt,
      h: Float,
      test: Ptr[HelloAlias],
      verify: Test
  ): CUnsignedInt =
    __sn_wrap_lib_test_use_braces_run(i, h, test, verify)

  def run(i: CInt, h: Float, test: HelloAlias, verify: Test)(using
      Zone
  ): CUnsignedInt =
    val __ptr_0: Ptr[HelloAlias] =
      _root_.scala.scalanative.unsafe.alloc[HelloAlias](1)
    !(__ptr_0 + 0) = test
    __sn_wrap_lib_test_use_braces_run(i, h, (__ptr_0 + 0), verify)
end functions

object constants:
  val Constant1: CUnsignedInt = 0.toUInt
  val Constant2: CUnsignedInt = 1.toUInt

object types:
  export _root_.lib_test_use_braces.structs.*
  export _root_.lib_test_use_braces.aliases.*
  export _root_.lib_test_use_braces.unions.*
  export _root_.lib_test_use_braces.enumerations.*

object all:
  export _root_.lib_test_use_braces.enumerations.Bla
  export _root_.lib_test_use_braces.aliases.HelloAlias
  export _root_.lib_test_use_braces.aliases.Howdy
  export _root_.lib_test_use_braces.structs.Hello
  export _root_.lib_test_use_braces.unions.Test
  export _root_.lib_test_use_braces.functions.nice
  export _root_.lib_test_use_braces.functions.test_varargs
  export _root_.lib_test_use_braces.functions.naughty
  export _root_.lib_test_use_braces.functions.run
end all
