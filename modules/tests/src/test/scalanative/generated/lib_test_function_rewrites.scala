package lib_test_function_rewrites

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object structs:
  import _root_.lib_test_function_rewrites.structs.*
  opaque type AllocationTest = CStruct2[CString, CInt]
  object AllocationTest:
    given _tag: Tag[AllocationTest] = Tag.materializeCStruct2Tag[CString, CInt]
    def apply()(using Zone): Ptr[AllocationTest] = scala.scalanative.unsafe.alloc[AllocationTest](1)
    def apply(str : CString, i : CInt)(using Zone): Ptr[AllocationTest] = 
      val ____ptr = apply()
      (!____ptr).str = str
      (!____ptr).i = i
      ____ptr
    extension (struct: AllocationTest)
      def str : CString = struct._1
      def str_=(value: CString): Unit = !struct.at1 = value
      def i : CInt = struct._2
      def i_=(value: CInt): Unit = !struct.at2 = value

  opaque type FunctionRewriteStruct = CStruct2[CInt, Float]
  object FunctionRewriteStruct:
    given _tag: Tag[FunctionRewriteStruct] = Tag.materializeCStruct2Tag[CInt, Float]
    def apply()(using Zone): Ptr[FunctionRewriteStruct] = scala.scalanative.unsafe.alloc[FunctionRewriteStruct](1)
    def apply(i : CInt, b : Float)(using Zone): Ptr[FunctionRewriteStruct] = 
      val ____ptr = apply()
      (!____ptr).i = i
      (!____ptr).b = b
      ____ptr
    extension (struct: FunctionRewriteStruct)
      def i : CInt = struct._1
      def i_=(value: CInt): Unit = !struct.at1 = value
      def b : Float = struct._2
      def b_=(value: Float): Unit = !struct.at2 = value


@extern
private[lib_test_function_rewrites] object extern_functions:
  import _root_.lib_test_function_rewrites.structs.*
  private[lib_test_function_rewrites] def __sn_wrap_lib_test_function_rewrites_rewrite_bad_func(a : Ptr[FunctionRewriteStruct], b : Ptr[FunctionRewriteStruct], __return : Ptr[FunctionRewriteStruct]): Unit = extern

  private[lib_test_function_rewrites] def __sn_wrap_lib_test_function_rewrites_rewrite_better_func(a : Ptr[FunctionRewriteStruct], b : Ptr[FunctionRewriteStruct]): CInt = extern

  private[lib_test_function_rewrites] def __sn_wrap_lib_test_function_rewrites_rewrite_without_allocations(a : Ptr[FunctionRewriteStruct], b : Ptr[FunctionRewriteStruct], c : Ptr[AllocationTest], i : CInt, __return : Ptr[FunctionRewriteStruct]): Unit = extern

  def rewrite_good_func(a : Ptr[FunctionRewriteStruct], b : Ptr[FunctionRewriteStruct], i : CInt): Ptr[FunctionRewriteStruct] = extern


object functions:
  import _root_.lib_test_function_rewrites.structs.*
  import extern_functions.*
  export extern_functions.*

  def rewrite_bad_func(a : Ptr[FunctionRewriteStruct], b : Ptr[FunctionRewriteStruct])(__return : Ptr[FunctionRewriteStruct]): Unit = 
    __sn_wrap_lib_test_function_rewrites_rewrite_bad_func(a, b, __return)

  def rewrite_bad_func(a : Ptr[FunctionRewriteStruct], b : Ptr[FunctionRewriteStruct])(using Zone): FunctionRewriteStruct = 
    val __ptr_0: Ptr[FunctionRewriteStruct] = _root_.scala.scalanative.unsafe.alloc[FunctionRewriteStruct](1)
    __sn_wrap_lib_test_function_rewrites_rewrite_bad_func(a, b, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  def rewrite_bad_func(a : FunctionRewriteStruct, b : FunctionRewriteStruct)(using Zone): FunctionRewriteStruct = 
    val __ptr_0: Ptr[FunctionRewriteStruct] = _root_.scala.scalanative.unsafe.alloc[FunctionRewriteStruct](3)
    !(__ptr_0 + 0) = a
    !(__ptr_0 + 1) = b
    __sn_wrap_lib_test_function_rewrites_rewrite_bad_func((__ptr_0 + 0), (__ptr_0 + 1), (__ptr_0 + 2))
    !(__ptr_0 + 2)

  def rewrite_better_func(a : Ptr[FunctionRewriteStruct], b : Ptr[FunctionRewriteStruct]): CInt = 
    __sn_wrap_lib_test_function_rewrites_rewrite_better_func(a, b)

  def rewrite_better_func(a : FunctionRewriteStruct, b : FunctionRewriteStruct)(using Zone): CInt = 
    val __ptr_0: Ptr[FunctionRewriteStruct] = _root_.scala.scalanative.unsafe.alloc[FunctionRewriteStruct](2)
    !(__ptr_0 + 0) = a
    !(__ptr_0 + 1) = b
    __sn_wrap_lib_test_function_rewrites_rewrite_better_func((__ptr_0 + 0), (__ptr_0 + 1))

  def rewrite_without_allocations(a : Ptr[FunctionRewriteStruct], b : Ptr[FunctionRewriteStruct], c : Ptr[AllocationTest], i : CInt)(__return : Ptr[FunctionRewriteStruct]): Unit = 
    __sn_wrap_lib_test_function_rewrites_rewrite_without_allocations(a, b, c, i, __return)

  def rewrite_without_allocations(a : FunctionRewriteStruct, b : FunctionRewriteStruct, c : AllocationTest, i : CInt)(using Zone): FunctionRewriteStruct = 
    val __ptr_0: Ptr[AllocationTest] = _root_.scala.scalanative.unsafe.alloc[AllocationTest](1)
    val __ptr_1: Ptr[FunctionRewriteStruct] = _root_.scala.scalanative.unsafe.alloc[FunctionRewriteStruct](3)
    !(__ptr_1 + 0) = a
    !(__ptr_1 + 1) = b
    !(__ptr_0 + 0) = c
    __sn_wrap_lib_test_function_rewrites_rewrite_without_allocations((__ptr_1 + 0), (__ptr_1 + 1), (__ptr_0 + 0), i, (__ptr_1 + 2))
    !(__ptr_1 + 2)

  def rewrite_without_allocations(a : Ptr[FunctionRewriteStruct], b : Ptr[FunctionRewriteStruct], c : Ptr[AllocationTest], i : CInt)(using Zone): FunctionRewriteStruct = 
    val __ptr_0: Ptr[FunctionRewriteStruct] = _root_.scala.scalanative.unsafe.alloc[FunctionRewriteStruct](1)
    __sn_wrap_lib_test_function_rewrites_rewrite_without_allocations(a, b, c, i, (__ptr_0 + 0))
    !(__ptr_0 + 0)

object types:
  export _root_.lib_test_function_rewrites.structs.*

object all:
  export _root_.lib_test_function_rewrites.structs.AllocationTest
  export _root_.lib_test_function_rewrites.structs.FunctionRewriteStruct
  export _root_.lib_test_function_rewrites.functions.rewrite_good_func
  export _root_.lib_test_function_rewrites.functions.rewrite_bad_func
  export _root_.lib_test_function_rewrites.functions.rewrite_better_func
  export _root_.lib_test_function_rewrites.functions.rewrite_without_allocations