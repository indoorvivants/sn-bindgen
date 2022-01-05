package libtest

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*

object predef:  
  abstract class CEnum[T](using eq: T =:= Int):
    given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
    extension (t: T) def int: CInt = eq.apply(t)
  
  abstract class CEnumU[T](using eq: T =:= UInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
    extension (t: T)
     def int: CInt = eq.apply(t).toInt
     def uint: CUnsignedInt = eq.apply(t)
      
object types:
  import predef.*
  opaque type CURLMSG = CUnsignedInt
  object CURLMSG extends CEnumU[CURLMSG]:
    inline def define(inline a: Long): CURLMSG = a.toUInt
    val OK = define(1)
    val NOK = define(2)
  opaque type CURLcode = CInt
  object CURLcode: 
    given _tag: Tag[CURLcode] = Tag.Int
    inline def apply(inline o: CInt): CURLcode = o

  opaque type __builtin_va_list = CString
  object __builtin_va_list: 
    given _tag: Tag[__builtin_va_list] = Tag.Ptr[CChar](Tag.Byte)
    inline def apply(inline o: CString): __builtin_va_list = o
  opaque type CURLMsg = CStruct4[CURLMSG, Ptr[Byte], CURLMsg.Union0, CURLMsg.Struct1]
  object CURLMsg:
    opaque type Union0 = CArray[Byte, Nat._8]
    object Union0:
      given _tag: Tag[Union0] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
      extension (struct: Union0)
        def whatever: Ptr[Byte] = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]]
        def result: CURLcode = !struct.at(0).asInstanceOf[Ptr[CURLcode]]
    opaque type Struct1 = CStruct2[Ptr[Byte], CURLMSG]
    object Struct1:
      given _tag: Tag[Struct1] = Tag.materializeCStruct2Tag[Ptr[Byte], CURLMSG]
      def apply()(using Zone): Ptr[Struct1] = scala.scalanative.unsafe.alloc[Struct1](1)
      def apply(test: Ptr[Byte], msg_code: CURLMSG)(using Zone): Ptr[Struct1] = 
        val ____ptr = apply()
        (!____ptr).test = test
        (!____ptr).msg_code = msg_code
        ____ptr
      extension (struct: Struct1)
        def test: Ptr[Byte] = struct._1
        def test_=(value: Ptr[Byte]): Unit = !struct.at1 = value
        def msg_code: CURLMSG = struct._2
        def msg_code_=(value: CURLMSG): Unit = !struct.at2 = value
    given _tag: Tag[CURLMsg] = Tag.materializeCStruct4Tag[CURLMSG, Ptr[Byte], CURLMsg.Union0, CURLMsg.Struct1]
    def apply()(using Zone): Ptr[CURLMsg] = scala.scalanative.unsafe.alloc[CURLMsg](1)
    def apply(msg: CURLMSG, easy_handle: Ptr[Byte], union_data: CURLMsg.Union0, struct_data: CURLMsg.Struct1)(using Zone): Ptr[CURLMsg] = 
      val ____ptr = apply()
      (!____ptr).msg = msg
      (!____ptr).easy_handle = easy_handle
      (!____ptr).union_data = union_data
      (!____ptr).struct_data = struct_data
      ____ptr
    extension (struct: CURLMsg)
      def msg: CURLMSG = struct._1
      def msg_=(value: CURLMSG): Unit = !struct.at1 = value
      def easy_handle: Ptr[Byte] = struct._2
      def easy_handle_=(value: Ptr[Byte]): Unit = !struct.at2 = value
      def union_data: CURLMsg.Union0 = struct._3
      def union_data_=(value: CURLMsg.Union0): Unit = !struct.at3 = value
      def struct_data: CURLMsg.Struct1 = struct._4
      def struct_data_=(value: CURLMsg.Struct1): Unit = !struct.at4 = value

