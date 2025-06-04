package lib_test_scala_keywords

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object structs:
  import _root_.lib_test_scala_keywords.structs.*
  import _root_.lib_test_scala_keywords.unions.*
  opaque type StructKeywords = CStruct10[CChar, CLongInt, Ptr[Byte], Ptr[CInt], CInt, CInt, CInt, CInt, CInt, CInt]
  object StructKeywords:
    given _tag: Tag[StructKeywords] = Tag.materializeCStruct10Tag[CChar, CLongInt, Ptr[Byte], Ptr[CInt], CInt, CInt, CInt, CInt, CInt, CInt]
    def apply()(using Zone): Ptr[StructKeywords] = scala.scalanative.unsafe.alloc[StructKeywords](1)
    def apply(`object` : CChar, `final` : CLongInt, `class` : Ptr[Byte], `def` : Ptr[CInt], `val` : CInt, `var` : CInt, `new` : CInt, _notify : CInt, _wait : CInt, `macro` : CInt)(using Zone): Ptr[StructKeywords] = 
      val ____ptr = apply()
      (!____ptr).`object` = `object`
      (!____ptr).`final` = `final`
      (!____ptr).`class` = `class`
      (!____ptr).`def` = `def`
      (!____ptr).`val` = `val`
      (!____ptr).`var` = `var`
      (!____ptr).`new` = `new`
      (!____ptr)._notify = _notify
      (!____ptr)._wait = _wait
      (!____ptr).`macro` = `macro`
      ____ptr
    extension (struct: StructKeywords)
      def `object` : CChar = struct._1
      def object_=(value: CChar): Unit = !struct.at1 = value
      def `final` : CLongInt = struct._2
      def final_=(value: CLongInt): Unit = !struct.at2 = value
      def `class` : Ptr[Byte] = struct._3
      def class_=(value: Ptr[Byte]): Unit = !struct.at3 = value
      def `def` : Ptr[CInt] = struct._4
      def def_=(value: Ptr[CInt]): Unit = !struct.at4 = value
      def `val` : CInt = struct._5
      def val_=(value: CInt): Unit = !struct.at5 = value
      def `var` : CInt = struct._6
      def var_=(value: CInt): Unit = !struct.at6 = value
      def `new` : CInt = struct._7
      def new_=(value: CInt): Unit = !struct.at7 = value
      def _notify : CInt = struct._8
      def _notify_=(value: CInt): Unit = !struct.at8 = value
      def _wait : CInt = struct._9
      def _wait_=(value: CInt): Unit = !struct.at9 = value
      def `macro` : CInt = struct._10
      def macro_=(value: CInt): Unit = !struct.at10 = value

  opaque type test_keywords_struct = CStruct10[CChar, CLongInt, Ptr[Byte], Ptr[CInt], CInt, CInt, CInt, CInt, CInt, CInt]
  object test_keywords_struct:
    given _tag: Tag[test_keywords_struct] = Tag.materializeCStruct10Tag[CChar, CLongInt, Ptr[Byte], Ptr[CInt], CInt, CInt, CInt, CInt, CInt, CInt]
    def apply()(using Zone): Ptr[test_keywords_struct] = scala.scalanative.unsafe.alloc[test_keywords_struct](1)
    def apply(`object` : CChar, `final` : CLongInt, `class` : Ptr[Byte], `def` : Ptr[CInt], `val` : CInt, `var` : CInt, `new` : CInt, _notify : CInt, _wait : CInt, `macro` : CInt)(using Zone): Ptr[test_keywords_struct] = 
      val ____ptr = apply()
      (!____ptr).`object` = `object`
      (!____ptr).`final` = `final`
      (!____ptr).`class` = `class`
      (!____ptr).`def` = `def`
      (!____ptr).`val` = `val`
      (!____ptr).`var` = `var`
      (!____ptr).`new` = `new`
      (!____ptr)._notify = _notify
      (!____ptr)._wait = _wait
      (!____ptr).`macro` = `macro`
      ____ptr
    extension (struct: test_keywords_struct)
      def `object` : CChar = struct._1
      def object_=(value: CChar): Unit = !struct.at1 = value
      def `final` : CLongInt = struct._2
      def final_=(value: CLongInt): Unit = !struct.at2 = value
      def `class` : Ptr[Byte] = struct._3
      def class_=(value: Ptr[Byte]): Unit = !struct.at3 = value
      def `def` : Ptr[CInt] = struct._4
      def def_=(value: Ptr[CInt]): Unit = !struct.at4 = value
      def `val` : CInt = struct._5
      def val_=(value: CInt): Unit = !struct.at5 = value
      def `var` : CInt = struct._6
      def var_=(value: CInt): Unit = !struct.at6 = value
      def `new` : CInt = struct._7
      def new_=(value: CInt): Unit = !struct.at7 = value
      def _notify : CInt = struct._8
      def _notify_=(value: CInt): Unit = !struct.at8 = value
      def _wait : CInt = struct._9
      def _wait_=(value: CInt): Unit = !struct.at9 = value
      def `macro` : CInt = struct._10
      def macro_=(value: CInt): Unit = !struct.at10 = value

object unions:
  import _root_.lib_test_scala_keywords.structs.*
  import _root_.lib_test_scala_keywords.unions.*
  opaque type UnionKeywords = CArray[Byte, Nat._8]
  object UnionKeywords:
    given _tag: Tag[UnionKeywords] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
    def apply()(using Zone): Ptr[UnionKeywords] = 
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionKeywords](1)
      ___ptr
    @scala.annotation.targetName("apply_object")
    def apply(`object`: CChar)(using Zone): Ptr[UnionKeywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionKeywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CChar]].update(0, `object`)
      ___ptr
    @scala.annotation.targetName("apply_final")
    def apply(`final`: CLongInt)(using Zone): Ptr[UnionKeywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionKeywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CLongInt]].update(0, `final`)
      ___ptr
    @scala.annotation.targetName("apply_class")
    def apply(`class`: Ptr[Byte])(using Zone): Ptr[UnionKeywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionKeywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[Ptr[Byte]]].update(0, `class`)
      ___ptr
    @scala.annotation.targetName("apply_def")
    def apply(`def`: Ptr[CInt])(using Zone): Ptr[UnionKeywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionKeywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[Ptr[CInt]]].update(0, `def`)
      ___ptr
    @scala.annotation.targetName("apply_val")
    def apply(`val`: CInt)(using Zone): Ptr[UnionKeywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionKeywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, `val`)
      ___ptr
    @scala.annotation.targetName("apply_var")
    def apply(`var`: CInt)(using Zone): Ptr[UnionKeywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionKeywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, `var`)
      ___ptr
    @scala.annotation.targetName("apply_new")
    def apply(`new`: CInt)(using Zone): Ptr[UnionKeywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionKeywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, `new`)
      ___ptr
    @scala.annotation.targetName("apply_notify")
    def apply(_notify: CInt)(using Zone): Ptr[UnionKeywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionKeywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, _notify)
      ___ptr
    @scala.annotation.targetName("apply_wait")
    def apply(_wait: CInt)(using Zone): Ptr[UnionKeywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionKeywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, _wait)
      ___ptr
    @scala.annotation.targetName("apply_macro")
    def apply(`macro`: CInt)(using Zone): Ptr[UnionKeywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[UnionKeywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, `macro`)
      ___ptr
    extension (struct: UnionKeywords)
      def `object` : CChar = !struct.at(0).asInstanceOf[Ptr[CChar]]
      def object_=(value: CChar): Unit = !struct.at(0).asInstanceOf[Ptr[CChar]] = value
      def `final` : CLongInt = !struct.at(0).asInstanceOf[Ptr[CLongInt]]
      def final_=(value: CLongInt): Unit = !struct.at(0).asInstanceOf[Ptr[CLongInt]] = value
      def `class` : Ptr[Byte] = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]]
      def class_=(value: Ptr[Byte]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]] = value
      def `def` : Ptr[CInt] = !struct.at(0).asInstanceOf[Ptr[Ptr[CInt]]]
      def def_=(value: Ptr[CInt]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[CInt]]] = value
      def `val` : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def val_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
      def `var` : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def var_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
      def `new` : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def new_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
      def _notify : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def _notify_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
      def _wait : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def _wait_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
      def `macro` : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def macro_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value

  opaque type test_keywords = CArray[Byte, Nat._8]
  object test_keywords:
    given _tag: Tag[test_keywords] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
    def apply()(using Zone): Ptr[test_keywords] = 
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[test_keywords](1)
      ___ptr
    @scala.annotation.targetName("apply_object")
    def apply(`object`: CChar)(using Zone): Ptr[test_keywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[test_keywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CChar]].update(0, `object`)
      ___ptr
    @scala.annotation.targetName("apply_final")
    def apply(`final`: CLongInt)(using Zone): Ptr[test_keywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[test_keywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CLongInt]].update(0, `final`)
      ___ptr
    @scala.annotation.targetName("apply_class")
    def apply(`class`: Ptr[Byte])(using Zone): Ptr[test_keywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[test_keywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[Ptr[Byte]]].update(0, `class`)
      ___ptr
    @scala.annotation.targetName("apply_def")
    def apply(`def`: Ptr[CInt])(using Zone): Ptr[test_keywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[test_keywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[Ptr[CInt]]].update(0, `def`)
      ___ptr
    @scala.annotation.targetName("apply_val")
    def apply(`val`: CInt)(using Zone): Ptr[test_keywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[test_keywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, `val`)
      ___ptr
    @scala.annotation.targetName("apply_var")
    def apply(`var`: CInt)(using Zone): Ptr[test_keywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[test_keywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, `var`)
      ___ptr
    @scala.annotation.targetName("apply_new")
    def apply(`new`: CInt)(using Zone): Ptr[test_keywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[test_keywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, `new`)
      ___ptr
    @scala.annotation.targetName("apply_notify")
    def apply(_notify: CInt)(using Zone): Ptr[test_keywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[test_keywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, _notify)
      ___ptr
    @scala.annotation.targetName("apply_wait")
    def apply(_wait: CInt)(using Zone): Ptr[test_keywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[test_keywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, _wait)
      ___ptr
    @scala.annotation.targetName("apply_macro")
    def apply(`macro`: CInt)(using Zone): Ptr[test_keywords] =
      val ___ptr = _root_.scala.scalanative.unsafe.alloc[test_keywords](1)
      val un = !___ptr
      un.at(0).asInstanceOf[Ptr[CInt]].update(0, `macro`)
      ___ptr
    extension (struct: test_keywords)
      def `object` : CChar = !struct.at(0).asInstanceOf[Ptr[CChar]]
      def object_=(value: CChar): Unit = !struct.at(0).asInstanceOf[Ptr[CChar]] = value
      def `final` : CLongInt = !struct.at(0).asInstanceOf[Ptr[CLongInt]]
      def final_=(value: CLongInt): Unit = !struct.at(0).asInstanceOf[Ptr[CLongInt]] = value
      def `class` : Ptr[Byte] = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]]
      def class_=(value: Ptr[Byte]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]] = value
      def `def` : Ptr[CInt] = !struct.at(0).asInstanceOf[Ptr[Ptr[CInt]]]
      def def_=(value: Ptr[CInt]): Unit = !struct.at(0).asInstanceOf[Ptr[Ptr[CInt]]] = value
      def `val` : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def val_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
      def `var` : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def var_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
      def `new` : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def new_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
      def _notify : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def _notify_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
      def _wait : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def _wait_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
      def `macro` : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def macro_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value


@extern
private[lib_test_scala_keywords] object extern_functions:
  import _root_.lib_test_scala_keywords.structs.*
  import _root_.lib_test_scala_keywords.unions.*
  private[lib_test_scala_keywords] def __sn_wrap_lib_test_scala_keywords_test_alloc_collision(alloc : CInt, the_struct : Ptr[StructKeywords]): Unit = extern

  def test_keywords(`def` : CInt, `class` : CInt, `final` : CInt, `object` : CInt): CInt = extern


object functions:
  import _root_.lib_test_scala_keywords.structs.*
  import _root_.lib_test_scala_keywords.unions.*
  import extern_functions.*
  export extern_functions.*

  def test_alloc_collision(alloc : CInt, the_struct : Ptr[StructKeywords]): Unit = 
    __sn_wrap_lib_test_scala_keywords_test_alloc_collision(alloc, the_struct)

  def test_alloc_collision(alloc : CInt, the_struct : StructKeywords)(using Zone): Unit = 
    val __ptr_0: Ptr[StructKeywords] = _root_.scala.scalanative.unsafe.alloc[StructKeywords](1)
    !(__ptr_0 + 0) = the_struct
    __sn_wrap_lib_test_scala_keywords_test_alloc_collision(alloc, (__ptr_0 + 0))

object types:
  export _root_.lib_test_scala_keywords.structs.*
  export _root_.lib_test_scala_keywords.unions.*

object all:
  export _root_.lib_test_scala_keywords.structs.StructKeywords
  export _root_.lib_test_scala_keywords.structs.test_keywords_struct
  export _root_.lib_test_scala_keywords.unions.UnionKeywords
  export _root_.lib_test_scala_keywords.unions.test_keywords
  export _root_.lib_test_scala_keywords.functions.test_keywords
  export _root_.lib_test_scala_keywords.functions.test_alloc_collision