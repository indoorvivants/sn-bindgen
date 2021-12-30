package libtesting

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*

object predef:  
  abstract class CEnum[T](using eq: T =:= Int):
    given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
    extension (t: T) def int: CInt = eq.apply(t)
  
  abstract class CEnumU[T](using eq: T =:= UInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
        
object types:
  import predef.*
  opaque type CXTLSKind = CUnsignedInt
  object CXTLSKind extends CEnumU[CXTLSKind]:
    inline def define(inline a: Long): CXTLSKind = a.toUInt
    val CXTLS_None = define(0)
    val CXTLS_Dynamic = define(1)
    val CXTLS_Static = define(2)

  opaque type CXTypeKind = CUnsignedInt
  object CXTypeKind extends CEnumU[CXTypeKind]:
    inline def define(inline a: Long): CXTypeKind = a.toUInt
    val bla = define(1)

  opaque type CXIdxDeclInfoFlags = CUnsignedInt
  object CXIdxDeclInfoFlags extends CEnumU[CXIdxDeclInfoFlags]:
    inline def define(inline a: Long): CXIdxDeclInfoFlags = a.toUInt
    val CXIdxDeclFlag_Skipped = define(1)

  opaque type Hello = CInt
  object Hello: 
    given _tag: Tag[Hello] = Tag.Int
    inline def apply(inline o: CInt): Hello = o
  opaque type __builtin_va_list = Ptr[CChar]
  object __builtin_va_list: 
    given _tag: Tag[__builtin_va_list] = Tag.Ptr[CChar](Tag.Byte)
    inline def apply(inline o: Ptr[CChar]): __builtin_va_list = o

  opaque type CXType = CStruct2[CArray[Ptr[Byte], Nat._2], CUnsignedInt]
  object CXType:
    given _tag: Tag[CXType] = Tag.materializeCStruct2Tag[CArray[Ptr[Byte], Nat._2], CUnsignedInt]
    extension (struct: CXType)
      def ptr_data: CArray[Ptr[Byte], Nat._2] = struct._1
      def int_data: CUnsignedInt = struct._2
  opaque type CXUnsavedFile = CStruct4[Ptr[CUnsignedChar], Ptr[CUnsignedChar], CUnsignedLongInt, CChar]
  object CXUnsavedFile:
    given _tag: Tag[CXUnsavedFile] = Tag.materializeCStruct4Tag[Ptr[CUnsignedChar], Ptr[CUnsignedChar], CUnsignedLongInt, CChar]
    extension (struct: CXUnsavedFile)
      def Filename: Ptr[CUnsignedChar] = struct._1
      def Contents: Ptr[CUnsignedChar] = struct._2
      def Length: CUnsignedLongInt = struct._3
      def hello: CChar = struct._4

  opaque type point = CStruct2[CInt, CInt]
  object point:
    given _tag: Tag[point] = Tag.materializeCStruct2Tag[CInt, CInt]
    extension (struct: point)
      def x: CInt = struct._1
      def y: CInt = struct._2

  opaque type bigStruct = CArray[Byte, Nat.Digit3[Nat._1, Nat._2, Nat._8]]
  object bigStruct:
    given _tag: Tag[bigStruct] = Tag.CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]](Tag.Byte, Tag.Digit3[Nat._1, Nat._2, Nat._8](Tag.Nat1, Tag.Nat2, Tag.Nat8))
    extension (struct: bigStruct)
      def one: CLongInt = !struct.at(0).asInstanceOf[Ptr[CLongInt]]
      def two: CUnsignedChar = !struct.at(8).asInstanceOf[Ptr[CUnsignedChar]]
      def three: CInt = !struct.at(12).asInstanceOf[Ptr[CInt]]
      def four: Float = !struct.at(16).asInstanceOf[Ptr[Float]]
      def five: Double = !struct.at(24).asInstanceOf[Ptr[Double]]
      def six: point = !struct.at(32).asInstanceOf[Ptr[point]]
      def seven: Ptr[point] = !struct.at(40).asInstanceOf[Ptr[Ptr[point]]]
      def eight: CInt = !struct.at(48).asInstanceOf[Ptr[CInt]]
      def nine: CInt = !struct.at(52).asInstanceOf[Ptr[CInt]]
      def ten: CInt = !struct.at(56).asInstanceOf[Ptr[CInt]]
      def eleven: CInt = !struct.at(60).asInstanceOf[Ptr[CInt]]
      def twelve: CInt = !struct.at(64).asInstanceOf[Ptr[CInt]]
      def thirteen: CInt = !struct.at(68).asInstanceOf[Ptr[CInt]]
      def fourteen: CInt = !struct.at(72).asInstanceOf[Ptr[CInt]]
      def fifteen: CInt = !struct.at(76).asInstanceOf[Ptr[CInt]]
      def sixteen: CInt = !struct.at(80).asInstanceOf[Ptr[CInt]]
      def seventeen: CInt = !struct.at(84).asInstanceOf[Ptr[CInt]]
      def eighteen: CInt = !struct.at(88).asInstanceOf[Ptr[CInt]]
      def nineteen: CInt = !struct.at(92).asInstanceOf[Ptr[CInt]]
      def twenty: CInt = !struct.at(96).asInstanceOf[Ptr[CInt]]
      def twentyOne: CInt = !struct.at(100).asInstanceOf[Ptr[CInt]]
      def twentyTwo: CInt = !struct.at(104).asInstanceOf[Ptr[CInt]]
      def twentyThree: CInt = !struct.at(108).asInstanceOf[Ptr[CInt]]
      def twentyFive: myUn = !struct.at(112).asInstanceOf[Ptr[myUn]]
      def twentySix: CInt = !struct.at(120).asInstanceOf[Ptr[CInt]]

  opaque type CXCursor = CStruct3[CXTypeKind, CArray[Ptr[Byte], Nat._2], CUnsignedInt]
  object CXCursor:
    given _tag: Tag[CXCursor] = Tag.materializeCStruct3Tag[CXTypeKind, CArray[Ptr[Byte], Nat._2], CUnsignedInt]
    extension (struct: CXCursor)
      def kind: CXTypeKind = struct._1
      def data: CArray[Ptr[Byte], Nat._2] = struct._2
      def test: CUnsignedInt = struct._3

  opaque type myUn = CArray[Byte, Nat._8]
  object myUn:
    given _tag: Tag[myUn] = Tag.CArray[CChar, Nat._8](Tag.Byte, Tag.Nat8)
    extension (struct: myUn)
      def i: CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
      def t: Double = !struct.at(0).asInstanceOf[Ptr[Double]]
      def p: point = !struct.at(0).asInstanceOf[Ptr[point]]

@extern
object functions: 
  import types.*

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def clang_getCursorType(hel: CInt, C: CXCursor, types: CArray[Ptr[CXType], Nat._3], idx: Ptr[Double]): CXType = extern

