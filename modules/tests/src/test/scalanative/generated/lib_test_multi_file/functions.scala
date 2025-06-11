package lib_test_multi_file

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

@extern private[lib_test_multi_file] def __sn_wrap_lib_test_multi_file_naughty(st : Ptr[Hello]): Unit = extern

@extern private[lib_test_multi_file] def __sn_wrap_lib_test_multi_file_run(i : CInt, h : Float, test : Ptr[HelloAlias], verify : Test): CUnsignedInt = extern

@extern def nice(st : CChar): Unit = extern

@extern def test_varargs(i : CInt, rest: Any*): CInt = extern

def naughty(st : Ptr[Hello]): Unit =
  __sn_wrap_lib_test_multi_file_naughty(st)

def naughty(st : Hello)(using Zone): Unit =
  val __ptr_0: Ptr[Hello] = _root_.scala.scalanative.unsafe.alloc[Hello](1)
  !(__ptr_0 + 0) = st
  __sn_wrap_lib_test_multi_file_naughty((__ptr_0 + 0))

def run(i : CInt, h : Float, test : Ptr[HelloAlias], verify : Test): CUnsignedInt =
  __sn_wrap_lib_test_multi_file_run(i, h, test, verify)

def run(i : CInt, h : Float, test : HelloAlias, verify : Test)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[HelloAlias] = _root_.scala.scalanative.unsafe.alloc[HelloAlias](1)
  !(__ptr_0 + 0) = test
  __sn_wrap_lib_test_multi_file_run(i, h, (__ptr_0 + 0), verify)