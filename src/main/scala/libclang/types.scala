package libclang

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*

object types:
  opaque type CXIndex = Ptr[Byte]
  opaque type CXTranslationUnit = Ptr[Byte] // TODO: refine
  opaque type CXUnsavedFile = CStruct3[CString, CString, ULong]

  object CXUnsafeFile:
    extension (cxuf: CXUnsavedFile)
      inline def Filename = cxuf._1
      inline def Context = cxuf._2
      inline def Length = cxuf._3

  opaque type CXTranslationUnit_Flags = CUnsignedInt
  object CXTranslationUnit_Flags extends CEnumU[CXTranslationUnit_Flags]:
    private type T = CXTranslationUnit_Flags
    private val zero = 0x00.toUInt
    val CXTranslationUnit_None: T = zero

  abstract class Wrapper[T, W <: Ptr[T]](using tg: Tag[T]):
    given Tag[W] = Tag.Ptr(tg).asInstanceOf[Tag[W]]
    inline def allocate(inline n: CSSize)(using zone: Zone): W =
      alloc[T](n)(using tg, zone).asInstanceOf[W]

  opaque type CXCursorImpl =
    CStruct3[CXCursorKind, CInt, CArray[Ptr[Byte], Nat._3]]
  opaque type CXCursor = Ptr[CXCursorImpl]
  object CXCursor extends Wrapper[CXCursorImpl, CXCursor]:
    val NULL: CXCursor = null
    extension (cursor: CXCursor)
      def kind: CXCursorKind = cursor._1
      def xdata: CInt = cursor._2

    given Tag[CXCursor] =
      Tag.Ptr(
        Tag
          .materializeCStruct3Tag[CXCursorKind, CInt, CArray[Ptr[Byte], Nat._3]]
      )
  end CXCursor

  opaque type CXCursorKind = CInt
  object CXCursorKind extends CEnum[CXCursorKind]:
    val CXCursor_UnexposedDecl: CXCursorKind = 1
    val CXCursor_StructDecl: CXCursorKind = 2
    val CXCursor_UnionDecl: CXCursorKind = 3
    val CXCursor_ClassDecl: CXCursorKind = 4
    val CXCursor_EnumDecl: CXCursorKind = 5
    val CXCursor_FieldDecl: CXCursorKind = 6
  end CXCursorKind

  opaque type CXStringImpl = CStruct2[Ptr[Byte], UInt]
  object CXStringImpl:
    given Tag[CXStringImpl] = Tag.materializeCStruct2Tag[Ptr[Byte], UInt]

  opaque type CXString = Ptr[CXStringImpl]
  object CXString extends Wrapper[CXStringImpl, CXString]:
    extension (cxs: CXString)
      def data: Ptr[Byte] = cxs._1
      def string(using Zone): String =
        val orig = defs.clang_getCString(cxs)
        val str = fromCString(orig)
        defs.clang_disposeString(cxs)
        str

  opaque type CXTypeKind = Int
  object CXTypeKind extends CEnum[CXTypeKind]

  opaque type CXTypeImpl = CStruct2[CXTypeKind, CArray[Ptr[Byte], Nat._2]]
  opaque type CXType = Ptr[CXTypeImpl]
  object CXType extends Wrapper[CXTypeImpl, CXType]:
    extension (t: CXType) def kind: CXTypeKind = t._1

  opaque type CXChildVisitResult = Int
  object CXChildVisitResult extends CEnum[CXChildVisitResult]:
    val CXChildVisit_Break: CXChildVisitResult = 0
    val CXChildVisit_Continue: CXChildVisitResult = 1
    val CXChildVisit_Recurse: CXChildVisitResult = 2
  end CXChildVisitResult

  opaque type CXClientData = Ptr[Byte]
  object CXClientData:
    val NULL: CXClientData = null
    given Tag[CXClientData] =
      Tag
        .materializePtrTag[Byte](using Tag.Byte)

  opaque type CXCursorVisitor =
    CFuncPtr3[CXCursor, CXCursor, CXClientData, CXChildVisitResult]

  object CXCursorVisitor:
    inline def apply(
        inline f: (CXCursor, CXCursor, CXClientData) => CXChildVisitResult
    ): CXCursorVisitor = CFuncPtr3.fromScalaFunction(f)

  opaque type CXLanguageKind = Int
  object CXLanguageKind extends CEnum[CXErrorCode]:
    val CXLanguage_Invalid: CXLanguageKind = 0
    val CXLanguage_C: CXLanguageKind = 1
    val CXLanguage_ObjC: CXLanguageKind = 2
    val CXLanguage_CPlusPlus: CXLanguageKind = 3

  opaque type CXErrorCode = Int
  object CXErrorCode extends CEnum[CXErrorCode]:
    val CXError_Success: CXErrorCode = 0
    val CXError_Failure: CXErrorCode = 1
    val CXError_Crashed: CXErrorCode = 2
    val CXError_InvalidArgument: CXErrorCode = 3
    val CXError_ASTReadError: CXErrorCode = 4
end types

