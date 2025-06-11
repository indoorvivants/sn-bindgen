package lib_test_struct_passing

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object structs:
  import _root_.lib_test_struct_passing.structs.*
  opaque type FunctionArg = CStruct2[CInt, CString]
  object FunctionArg:
    given _tag: Tag[FunctionArg] = Tag.materializeCStruct2Tag[CInt, CString]
    def apply()(using Zone): Ptr[FunctionArg] = scala.scalanative.unsafe.alloc[FunctionArg](1)
    def apply(i : CInt, str : CString)(using Zone): Ptr[FunctionArg] =
      val ____ptr = apply()
      (!____ptr).i = i
      (!____ptr).str = str
      ____ptr
    extension (struct: FunctionArg)
      def i : CInt = struct._1
      def i_=(value: CInt): Unit = !struct.at1 = value
      def str : CString = struct._2
      def str_=(value: CString): Unit = !struct.at2 = value


@extern
private[lib_test_struct_passing] object extern_functions:
  import _root_.lib_test_struct_passing.structs.*
  private[lib_test_struct_passing] def __sn_wrap_lib_test_struct_passing_function_returning_struct(value : CInt, __return : Ptr[FunctionArg]): Unit = extern

  private[lib_test_struct_passing] def __sn_wrap_lib_test_struct_passing_function_taking_struct1(arg : Ptr[FunctionArg]): CInt = extern

  private[lib_test_struct_passing] def __sn_wrap_lib_test_struct_passing_function_taking_struct2(arg1 : Ptr[FunctionArg], arg2 : Ptr[FunctionArg]): CInt = extern


object functions:
  import _root_.lib_test_struct_passing.structs.*
  import extern_functions.*
  export extern_functions.*

  def function_returning_struct(value : CInt)(__return : Ptr[FunctionArg]): Unit =
    __sn_wrap_lib_test_struct_passing_function_returning_struct(value, __return)

  def function_returning_struct(value : CInt)(using Zone): FunctionArg =
    val __ptr_0: Ptr[FunctionArg] = _root_.scala.scalanative.unsafe.alloc[FunctionArg](1)
    __sn_wrap_lib_test_struct_passing_function_returning_struct(value, (__ptr_0 + 0))
    !(__ptr_0 + 0)

  def function_taking_struct1(arg : FunctionArg)(using Zone): CInt =
    val __ptr_0: Ptr[FunctionArg] = _root_.scala.scalanative.unsafe.alloc[FunctionArg](1)
    !(__ptr_0 + 0) = arg
    __sn_wrap_lib_test_struct_passing_function_taking_struct1((__ptr_0 + 0))

  def function_taking_struct1(arg : Ptr[FunctionArg]): CInt =
    __sn_wrap_lib_test_struct_passing_function_taking_struct1(arg)

  def function_taking_struct2(arg1 : Ptr[FunctionArg], arg2 : Ptr[FunctionArg]): CInt =
    __sn_wrap_lib_test_struct_passing_function_taking_struct2(arg1, arg2)

  def function_taking_struct2(arg1 : FunctionArg, arg2 : FunctionArg)(using Zone): CInt =
    val __ptr_0: Ptr[FunctionArg] = _root_.scala.scalanative.unsafe.alloc[FunctionArg](2)
    !(__ptr_0 + 0) = arg1
    !(__ptr_0 + 1) = arg2
    __sn_wrap_lib_test_struct_passing_function_taking_struct2((__ptr_0 + 0), (__ptr_0 + 1))

object types:
  export _root_.lib_test_struct_passing.structs.*

object all:
  export _root_.lib_test_struct_passing.structs.FunctionArg
  export _root_.lib_test_struct_passing.functions.function_returning_struct
  export _root_.lib_test_struct_passing.functions.function_taking_struct1
  export _root_.lib_test_struct_passing.functions.function_taking_struct2