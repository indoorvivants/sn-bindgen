package lib_test_aliases

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object aliases:
  import _root_.lib_test_aliases.aliases.*
  import _root_.lib_test_aliases.structs.*
  opaque type TestFunctionPointer = CFuncPtr1[Ptr[TestStruct], CInt]
  object TestFunctionPointer:
    given _tag: Tag[TestFunctionPointer] = Tag.materializeCFuncPtr1[Ptr[TestStruct], CInt]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): TestFunctionPointer = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr1[Ptr[TestStruct], CInt]): TestFunctionPointer = o
    extension (v: TestFunctionPointer)
      inline def value: CFuncPtr1[Ptr[TestStruct], CInt] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

  type alias_of_an_alias = hello_alias
  object alias_of_an_alias:
    given _tag: Tag[alias_of_an_alias] = hello_alias._tag
    inline def apply(inline o: hello_alias): alias_of_an_alias = o
    extension (v: alias_of_an_alias)
      inline def value: hello_alias = v

  opaque type hello_alias = CInt
  object hello_alias:
    given _tag: Tag[hello_alias] = Tag.Int
    inline def apply(inline o: CInt): hello_alias = o
    extension (v: hello_alias)
      inline def value: CInt = v

object structs:
  import _root_.lib_test_aliases.aliases.*
  import _root_.lib_test_aliases.structs.*
  opaque type AliasesRef = CStruct1[AliasesRef.Union0]
  object AliasesRef:
    opaque type Union0 = CArray[Byte, Nat._8]
    object Union0:
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_bla")
      def apply(bla: CString)(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CString]].update(0, bla)
        ___ptr
      @scala.annotation.targetName("apply_foo")
      def apply(foo: CInt)(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CInt]].update(0, foo)
        ___ptr
      extension (struct: Union0)
        def bla : CString = !struct.at(0).asInstanceOf[Ptr[CString]]
        def bla_=(value: CString): Unit = !struct.at(0).asInstanceOf[Ptr[CString]] = value
        def foo : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
        def foo_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
    given _tag: Tag[AliasesRef] = Tag.materializeCStruct1Tag[AliasesRef.Union0]
    def apply()(using Zone): Ptr[AliasesRef] = scala.scalanative.unsafe.alloc[AliasesRef](1)
    def apply(help : AliasesRef.Union0)(using Zone): Ptr[AliasesRef] =
      val ____ptr = apply()
      (!____ptr).help = help
      ____ptr
    extension (struct: AliasesRef)
      def help : AliasesRef.Union0 = struct._1
      def help_=(value: AliasesRef.Union0): Unit = !struct.at1 = value

  opaque type TestAliases = CStruct2[TestAliases.Union0, Ptr[AliasesRef]]
  object TestAliases:
    opaque type Union0 = CArray[Byte, Nat._8]
    object Union0:
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      def apply()(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        ___ptr
      @scala.annotation.targetName("apply_help")
      def apply(help: CLongInt)(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CLongInt]].update(0, help)
        ___ptr
      @scala.annotation.targetName("apply_key")
      def apply(key: CString)(using Zone): Ptr[Union0] =
        val ___ptr = _root_.scala.scalanative.unsafe.alloc[Union0](1)
        val un = !___ptr
        un.at(0).asInstanceOf[Ptr[CString]].update(0, key)
        ___ptr
      extension (struct: Union0)
        def help : CLongInt = !struct.at(0).asInstanceOf[Ptr[CLongInt]]
        def help_=(value: CLongInt): Unit = !struct.at(0).asInstanceOf[Ptr[CLongInt]] = value
        def key : CString = !struct.at(0).asInstanceOf[Ptr[CString]]
        def key_=(value: CString): Unit = !struct.at(0).asInstanceOf[Ptr[CString]] = value
    given _tag: Tag[TestAliases] = Tag.materializeCStruct2Tag[TestAliases.Union0, Ptr[AliasesRef]]
    def apply()(using Zone): Ptr[TestAliases] = scala.scalanative.unsafe.alloc[TestAliases](1)
    def apply(field1 : TestAliases.Union0, field2 : Ptr[AliasesRef])(using Zone): Ptr[TestAliases] =
      val ____ptr = apply()
      (!____ptr).field1 = field1
      (!____ptr).field2 = field2
      ____ptr
    extension (struct: TestAliases)
      def field1 : TestAliases.Union0 = struct._1
      def field1_=(value: TestAliases.Union0): Unit = !struct.at1 = value
      def field2 : Ptr[AliasesRef] = struct._2
      def field2_=(value: Ptr[AliasesRef]): Unit = !struct.at2 = value

  opaque type TestStruct = CStruct1[CInt]
  object TestStruct:
    given _tag: Tag[TestStruct] = Tag.materializeCStruct1Tag[CInt]
    def apply()(using Zone): Ptr[TestStruct] = scala.scalanative.unsafe.alloc[TestStruct](1)
    def apply(_ne : CInt)(using Zone): Ptr[TestStruct] =
      val ____ptr = apply()
      (!____ptr)._ne = _ne
      ____ptr
    extension (struct: TestStruct)
      def _ne : CInt = struct._1
      def _ne_=(value: CInt): Unit = !struct.at1 = value


@extern
private[lib_test_aliases] object extern_functions:
  import _root_.lib_test_aliases.aliases.*
  import _root_.lib_test_aliases.structs.*
  def higher_order_function(n : CInt, handler : TestFunctionPointer, container : Ptr[TestStruct]): CInt = extern


object functions:
  import _root_.lib_test_aliases.aliases.*
  import _root_.lib_test_aliases.structs.*
  import extern_functions.*
  export extern_functions.*

object types:
  export _root_.lib_test_aliases.structs.*
  export _root_.lib_test_aliases.aliases.*

object all:
  export _root_.lib_test_aliases.aliases.TestFunctionPointer
  export _root_.lib_test_aliases.aliases.alias_of_an_alias
  export _root_.lib_test_aliases.aliases.hello_alias
  export _root_.lib_test_aliases.structs.AliasesRef
  export _root_.lib_test_aliases.structs.TestAliases
  export _root_.lib_test_aliases.structs.TestStruct
  export _root_.lib_test_aliases.functions.higher_order_function