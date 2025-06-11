package lib_test_underscore_names

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object structs:
  import _root_.lib_test_underscore_names.structs.*
  import _root_.lib_test_underscore_names.unions.*
  opaque type UnderscoreNamesStruct = CStruct3[CInt, CLongInt, CString]
  object UnderscoreNamesStruct:
    given _tag: Tag[UnderscoreNamesStruct] =
      Tag.materializeCStruct3Tag[CInt, CLongInt, CString]
    def apply()(using Zone): Ptr[UnderscoreNamesStruct] =
      scala.scalanative.unsafe.alloc[UnderscoreNamesStruct](1)
    def apply(`x_`: CInt, `hello_`: CLongInt, $underscore: CString)(using
        Zone
    ): Ptr[UnderscoreNamesStruct] =
      val ____ptr = apply()
      (!____ptr).`x_` = `x_`
      (!____ptr).`hello_` = `hello_`
      (!____ptr).$underscore = $underscore
      ____ptr
    extension (struct: UnderscoreNamesStruct)
      def `x_`: CInt = struct._1
      def x__=(value: CInt): Unit = !struct.at1 = value
      def `hello_`: CLongInt = struct._2
      def hello__=(value: CLongInt): Unit = !struct.at2 = value
      def $underscore: CString = struct._3
      def $underscore_=(value: CString): Unit = !struct.at3 = value
  end UnderscoreNamesStruct

  opaque type UnderscoreNamesStruct_ = CStruct1[CInt]
  object UnderscoreNamesStruct_ :
    given _tag: Tag[UnderscoreNamesStruct_] = Tag.materializeCStruct1Tag[CInt]
    def apply()(using Zone): Ptr[UnderscoreNamesStruct_] =
      scala.scalanative.unsafe.alloc[UnderscoreNamesStruct_](1)
    def apply(`x_`: CInt)(using Zone): Ptr[UnderscoreNamesStruct_] =
      val ____ptr = apply()
      (!____ptr).`x_` = `x_`
      ____ptr
    extension (struct: UnderscoreNamesStruct_)
      def `x_`: CInt = struct._1
      def x__=(value: CInt): Unit = !struct.at1 = value
  end UnderscoreNamesStruct_
end structs

object unions:
  import _root_.lib_test_underscore_names.structs.*
  import _root_.lib_test_underscore_names.unions.*
  opaque type UnderscoreNamesUnion = CArray[Byte, Nat._8]
  object UnderscoreNamesUnion:
    given _tag: Tag[UnderscoreNamesUnion] =
      Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
    def apply()(using Zone): Ptr[UnderscoreNamesUnion] =
      val ___ptr =
        _root_.scala.scalanative.unsafe.alloc[UnderscoreNamesUnion](1)
      ___ptr
    @scala.annotation.targetName("apply_x_")
    def apply(`x_`: CInt)(using Zone): Ptr[UnderscoreNamesUnion] =
      val ___ptr =
        _root_.scala.scalanative.unsafe.alloc[UnderscoreNamesUnion](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, `x_`)
      ___ptr
    @scala.annotation.targetName("apply_hello_")
    def apply(`hello_`: CLongInt)(using Zone): Ptr[UnderscoreNamesUnion] =
      val ___ptr =
        _root_.scala.scalanative.unsafe.alloc[UnderscoreNamesUnion](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CLongInt]].update(0, `hello_`)
      ___ptr
    @scala.annotation.targetName("apply__")
    def apply($underscore: CString)(using Zone): Ptr[UnderscoreNamesUnion] =
      val ___ptr =
        _root_.scala.scalanative.unsafe.alloc[UnderscoreNamesUnion](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CString]].update(0, $underscore)
      ___ptr
    extension (struct: UnderscoreNamesUnion)
      def `x_`: CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def x__=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] =
        value
      def `hello_`: CLongInt = !struct.at(0).asInstanceOf[Ptr[CLongInt]]
      def hello__=(value: CLongInt): Unit =
        !struct.at(0).asInstanceOf[Ptr[CLongInt]] = value
      def $underscore: CString = !struct.at(0).asInstanceOf[Ptr[CString]]
      def $underscore_=(value: CString): Unit =
        !struct.at(0).asInstanceOf[Ptr[CString]] = value
    end extension
  end UnderscoreNamesUnion
end unions

object types:
  export _root_.lib_test_underscore_names.structs.*
  export _root_.lib_test_underscore_names.unions.*

object all:
  export _root_.lib_test_underscore_names.structs.UnderscoreNamesStruct
  export _root_.lib_test_underscore_names.structs.UnderscoreNamesStruct_
  export _root_.lib_test_underscore_names.unions.UnderscoreNamesUnion
