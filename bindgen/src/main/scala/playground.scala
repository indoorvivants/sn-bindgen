package bindgen_playground

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import scala.collection.mutable

object predef:
  abstract class CEnum[T](using eq: T =:= Int):
    given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
    extension (t: T) def int: CInt = eq.apply(t)

  abstract class CEnumU[T](using eq: T =:= UInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]

object enumerations:
  import predef.*
  opaque type CXTypeKind = CUnsignedInt
  object CXTypeKind extends CEnumU[CXTypeKind]:
    transparent inline def define(inline a: Long): CXTypeKind = a.toUInt
    val bla = define(1)
object structs:
  import predef.*, enumerations.*
  opaque type CXType = CStruct2[CArray[Ptr[Byte], Nat._2], CUnsignedInt]
  object CXType:
    extension (struct: CXType)
      def ptr_data: CArray[Ptr[Byte], Nat._2] = struct._1
      def int_data: CUnsignedInt = struct._2
  opaque type CXCursor = CStruct2[CXTypeKind, CArray[Ptr[Byte], Nat._2]]
  object CXCursor:
    extension (struct: CXCursor)
      def kind: CXTypeKind = struct._1
      def data: CArray[Ptr[Byte], Nat._2] = struct._2
