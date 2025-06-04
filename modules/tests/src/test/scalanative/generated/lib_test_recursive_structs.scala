package lib_test_recursive_structs

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object aliases:
  import _root_.lib_test_recursive_structs.aliases.*
  import _root_.lib_test_recursive_structs.structs.*
  opaque type hello_func = CFuncPtr1[Ptr[Recursive_Struct2], Unit]
  object hello_func: 
    given _tag: Tag[hello_func] = Tag.materializeCFuncPtr1[Ptr[Recursive_Struct2], Unit]
    inline def fromPtr(ptr: Ptr[Byte] | CVoidPtr): hello_func = CFuncPtr.fromPtr(ptr.asInstanceOf[Ptr[Byte]])
    inline def apply(inline o: CFuncPtr1[Ptr[Recursive_Struct2], Unit]): hello_func = o
    extension (v: hello_func)
      inline def value: CFuncPtr1[Ptr[Recursive_Struct2], Unit] = v
      inline def toPtr: CVoidPtr = CFuncPtr.toPtr(v)

object structs:
  import _root_.lib_test_recursive_structs.aliases.*
  import _root_.lib_test_recursive_structs.structs.*
  opaque type Ptr_Recursive = CStruct2[Double, Ptr[Byte]]
  object Ptr_Recursive:
    given _tag: Tag[Ptr_Recursive] = Tag.materializeCStruct2Tag[Double, Ptr[Byte]]
    def apply()(using Zone): Ptr[Ptr_Recursive] = scala.scalanative.unsafe.alloc[Ptr_Recursive](1)
    def apply(d : Double, elements : Ptr[Ptr[Ptr_Recursive]])(using Zone): Ptr[Ptr_Recursive] = 
      val ____ptr = apply()
      (!____ptr).d = d
      (!____ptr).elements = elements
      ____ptr
    extension (struct: Ptr_Recursive)
      def d : Double = struct._1
      def d_=(value: Double): Unit = !struct.at1 = value
      def elements : Ptr[Ptr[Ptr_Recursive]] = struct._2.asInstanceOf[Ptr[Ptr[Ptr_Recursive]]]
      def elements_=(value: Ptr[Ptr[Ptr_Recursive]]): Unit = !struct.at2 = value.asInstanceOf[Ptr[Byte]]

  opaque type Ptr_Recursive2 = CStruct2[Double, Ptr[Byte]]
  object Ptr_Recursive2:
    given _tag: Tag[Ptr_Recursive2] = Tag.materializeCStruct2Tag[Double, Ptr[Byte]]
    def apply()(using Zone): Ptr[Ptr_Recursive2] = scala.scalanative.unsafe.alloc[Ptr_Recursive2](1)
    def apply(d : Double, elements : Ptr[Ptr[Ptr[Ptr_Recursive2]]])(using Zone): Ptr[Ptr_Recursive2] = 
      val ____ptr = apply()
      (!____ptr).d = d
      (!____ptr).elements = elements
      ____ptr
    extension (struct: Ptr_Recursive2)
      def d : Double = struct._1
      def d_=(value: Double): Unit = !struct.at1 = value
      def elements : Ptr[Ptr[Ptr[Ptr_Recursive2]]] = struct._2.asInstanceOf[Ptr[Ptr[Ptr[Ptr_Recursive2]]]]
      def elements_=(value: Ptr[Ptr[Ptr[Ptr_Recursive2]]]): Unit = !struct.at2 = value.asInstanceOf[Ptr[Byte]]

  opaque type Ptr_Recursive_Array = CStruct2[CArray[Ptr[Byte], Nat._3], CInt]
  object Ptr_Recursive_Array:
    given _tag: Tag[Ptr_Recursive_Array] = Tag.materializeCStruct2Tag[CArray[Ptr[Byte], Nat._3], CInt]
    def apply()(using Zone): Ptr[Ptr_Recursive_Array] = scala.scalanative.unsafe.alloc[Ptr_Recursive_Array](1)
    def apply(opt : CArray[Ptr[Ptr_Recursive_Array], Nat._3], _ne : CInt)(using Zone): Ptr[Ptr_Recursive_Array] = 
      val ____ptr = apply()
      (!____ptr).opt = opt
      (!____ptr)._ne = _ne
      ____ptr
    extension (struct: Ptr_Recursive_Array)
      def opt : CArray[Ptr[Ptr_Recursive_Array], Nat._3] = struct._1.asInstanceOf[CArray[Ptr[Ptr_Recursive_Array], Nat._3]]
      def opt_=(value: CArray[Ptr[Ptr_Recursive_Array], Nat._3]): Unit = !struct.at1 = value.asInstanceOf[CArray[Ptr[Byte], Nat._3]]
      def _ne : CInt = struct._2
      def _ne_=(value: CInt): Unit = !struct.at2 = value

  opaque type Recrusive_Simple = CStruct2[Ptr[Byte], Double]
  object Recrusive_Simple:
    given _tag: Tag[Recrusive_Simple] = Tag.materializeCStruct2Tag[Ptr[Byte], Double]
    def apply()(using Zone): Ptr[Recrusive_Simple] = scala.scalanative.unsafe.alloc[Recrusive_Simple](1)
    def apply(hello : Ptr[Recrusive_Simple], d : Double)(using Zone): Ptr[Recrusive_Simple] = 
      val ____ptr = apply()
      (!____ptr).hello = hello
      (!____ptr).d = d
      ____ptr
    extension (struct: Recrusive_Simple)
      def hello : Ptr[Recrusive_Simple] = struct._1.asInstanceOf[Ptr[Recrusive_Simple]]
      def hello_=(value: Ptr[Recrusive_Simple]): Unit = !struct.at1 = value.asInstanceOf[Ptr[Byte]]
      def d : Double = struct._2
      def d_=(value: Double): Unit = !struct.at2 = value

  opaque type Recrusive_Struct1 = CStruct2[Ptr[Byte], Double]
  object Recrusive_Struct1:
    given _tag: Tag[Recrusive_Struct1] = Tag.materializeCStruct2Tag[Ptr[Byte], Double]
    def apply()(using Zone): Ptr[Recrusive_Struct1] = scala.scalanative.unsafe.alloc[Recrusive_Struct1](1)
    def apply(hello : Ptr[Recursive_Struct3], d : Double)(using Zone): Ptr[Recrusive_Struct1] = 
      val ____ptr = apply()
      (!____ptr).hello = hello
      (!____ptr).d = d
      ____ptr
    extension (struct: Recrusive_Struct1)
      def hello : Ptr[Recursive_Struct3] = struct._1.asInstanceOf[Ptr[Recursive_Struct3]]
      def hello_=(value: Ptr[Recursive_Struct3]): Unit = !struct.at1 = value.asInstanceOf[Ptr[Byte]]
      def d : Double = struct._2
      def d_=(value: Double): Unit = !struct.at2 = value

  opaque type Recursive_Func = CStruct3[Double, CFuncPtr1[Ptr[Byte], Unit], CInt]
  object Recursive_Func:
    given _tag: Tag[Recursive_Func] = Tag.materializeCStruct3Tag[Double, CFuncPtr1[Ptr[Byte], Unit], CInt]
    def apply()(using Zone): Ptr[Recursive_Func] = scala.scalanative.unsafe.alloc[Recursive_Func](1)
    def apply(d : Double, free : CFuncPtr1[Ptr[Recursive_Func], Unit], freed : CInt)(using Zone): Ptr[Recursive_Func] = 
      val ____ptr = apply()
      (!____ptr).d = d
      (!____ptr).free = free
      (!____ptr).freed = freed
      ____ptr
    extension (struct: Recursive_Func)
      def d : Double = struct._1
      def d_=(value: Double): Unit = !struct.at1 = value
      def free : CFuncPtr1[Ptr[Recursive_Func], Unit] = struct._2.asInstanceOf[CFuncPtr1[Ptr[Recursive_Func], Unit]]
      def free_=(value: CFuncPtr1[Ptr[Recursive_Func], Unit]): Unit = !struct.at2 = value.asInstanceOf[CFuncPtr1[Ptr[Byte], Unit]]
      def freed : CInt = struct._3
      def freed_=(value: CInt): Unit = !struct.at3 = value

  opaque type Recursive_Struct2 = CStruct3[CStruct0, Ptr[Byte], CString]
  object Recursive_Struct2:
    opaque type Struct0 = CStruct0
    object Struct0:
      given _tag: Tag[Struct0] = Tag.materializeCStruct0Tag
    given _tag: Tag[Recursive_Struct2] = Tag.materializeCStruct3Tag[CStruct0, Ptr[Byte], CString]
    def apply()(using Zone): Ptr[Recursive_Struct2] = scala.scalanative.unsafe.alloc[Recursive_Struct2](1)
    def apply(hello2 : Ptr[Recrusive_Struct1], str : CString)(using Zone): Ptr[Recursive_Struct2] = 
      val ____ptr = apply()
      (!____ptr).hello2 = hello2
      (!____ptr).str = str
      ____ptr
    extension (struct: Recursive_Struct2)
      def hello2 : Ptr[Recrusive_Struct1] = struct._2.asInstanceOf[Ptr[Recrusive_Struct1]]
      def hello2_=(value: Ptr[Recrusive_Struct1]): Unit = !struct.at2 = value.asInstanceOf[Ptr[Byte]]
      def str : CString = struct._3
      def str_=(value: CString): Unit = !struct.at3 = value

  opaque type Recursive_Struct3 = CStruct2[Ptr[Byte], CInt]
  object Recursive_Struct3:
    given _tag: Tag[Recursive_Struct3] = Tag.materializeCStruct2Tag[Ptr[Byte], CInt]
    def apply()(using Zone): Ptr[Recursive_Struct3] = scala.scalanative.unsafe.alloc[Recursive_Struct3](1)
    def apply(handler : hello_func, two : CInt)(using Zone): Ptr[Recursive_Struct3] = 
      val ____ptr = apply()
      (!____ptr).handler = handler
      (!____ptr).two = two
      ____ptr
    extension (struct: Recursive_Struct3)
      def handler : hello_func = struct._1.asInstanceOf[hello_func]
      def handler_=(value: hello_func): Unit = !struct.at1 = value.asInstanceOf[Ptr[Byte]]
      def two : CInt = struct._2
      def two_=(value: CInt): Unit = !struct.at2 = value

object types:
  export _root_.lib_test_recursive_structs.structs.*
  export _root_.lib_test_recursive_structs.aliases.*

object all:
  export _root_.lib_test_recursive_structs.aliases.hello_func
  export _root_.lib_test_recursive_structs.structs.Ptr_Recursive
  export _root_.lib_test_recursive_structs.structs.Ptr_Recursive2
  export _root_.lib_test_recursive_structs.structs.Ptr_Recursive_Array
  export _root_.lib_test_recursive_structs.structs.Recrusive_Simple
  export _root_.lib_test_recursive_structs.structs.Recrusive_Struct1
  export _root_.lib_test_recursive_structs.structs.Recursive_Func
  export _root_.lib_test_recursive_structs.structs.Recursive_Struct2
  export _root_.lib_test_recursive_structs.structs.Recursive_Struct3