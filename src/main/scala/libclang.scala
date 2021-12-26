package libclang

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import scala.language.implicitConversions

object defs:
  opaque type CXIndex = Ptr[Byte]
  opaque type CXTranslationUnit = Ptr[Byte] // TODO: refine
  opaque type CXUnsavedFile = CStruct3[CString, CString, ULong]

  abstract class CEnum[T](using eq: T =:= Int):
    given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
    extension (t: T) def int: CInt = eq.apply(t)

  abstract class CEnumU[T](using eq: T =:= UInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]

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
  object CXKursorKind extends CEnum[CXCursorKind]:
    val CXCursor_UnexposedDecl: CXCursorKind = 1
    val CXCursor_StructDecl: CXCursorKind = 2
    val CXCursor_UnionDecl: CXCursorKind = 3
    val CXCursor_ClassDecl: CXCursorKind = 4
    val CXCursor_EnumDecl: CXCursorKind = 5
  end CXKursorKind

  opaque type CXStringImpl = CStruct2[Ptr[Byte], UInt]
  object CXStringImpl:
    given Tag[CXStringImpl] = Tag.materializeCStruct2Tag[Ptr[Byte], UInt]

  opaque type CXString = Ptr[CXStringImpl]
  object CXString extends Wrapper[CXStringImpl, CXString]:
    extension (cxs: CXString)
      def data: Ptr[Byte] = cxs._1
      def string(using Zone): String =
        val orig = clang_getCString(cxs)
        val str = fromCString(orig)
        clang_disposeString(cxs)
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

  export methods.*
  export wrappers.*

  object wrappers:
    def clang_getNullCursor()(implicit z: Zone) =
      val ptr = alloc[CXCursorImpl](1)
      wrap_getNullCursor(ptr)
      ptr

    def clang_getTranslationUnitCursor(unit: CXTranslationUnit)(using
        Zone
    ): CXCursor =
      val ptr = alloc[CXCursorImpl](1)
      wrap_getTranslationUnitCursor(ptr, unit)
      ptr

    def clang_hashCursor(curs: CXCursor): UInt = wrap_hashCursor(curs)
    def clang_visitChildren(curs: CXCursor): UInt = wrap_hashCursor(curs)
    def clang_getCursorSpelling(curs: CXCursor)(using Zone): CXString =
      val ptr = CXString.allocate(1)
      wrap_getCursorSpelling(curs, ptr)
      ptr
    def clang_getCursorKindSpelling(curs: CXCursorKind)(using Zone): CXString =
      val ptr = CXString.allocate(1)
      wrap_getCursorKindSpelling(curs, ptr)
      ptr

    def clang_getCursorType(curs: CXCursor)(using Zone): CXType =
      val ptr = CXType.allocate(1)
      wrap_getCursorType(curs, ptr)
      ptr

    def clang_getResultType(curs: CXType)(using Zone): CXType =
      val ptr = CXType.allocate(1)
      wrap_getResultType(curs, ptr)
      ptr

    def clang_getTypeSpelling(curs: CXType)(using Zone): CXString =
      val ptr = CXString.allocate(1)
      wrap_getTypeSpelling(curs, ptr)
      ptr
  end wrappers

  @extern
  object methods:
    def clang_createIndex(
        excludeDeclarationsFromPCH: CInt,
        displayDiagnostics: CInt
    ): CXIndex = extern

    def clang_parseTranslationUnit(
        CIdx: CXIndex,
        source_filename: CString,
        command_line_args: Ptr[CString],
        num_command_line_args: CUnsignedInt,
        unsaved_files: Ptr[CXUnsavedFile],
        num_unsaved_files: CUnsignedInt,
        options: CXTranslationUnit_Flags
    ): CXTranslationUnit = extern

    def clang_parseTranslationUnit2(
        CIdx: CXIndex,
        source_filename: CString,
        command_line_args: Ptr[CString],
        num_command_line_args: CUnsignedInt,
        unsaved_files: Ptr[CXUnsavedFile],
        num_unsaved_files: CUnsignedInt,
        options: CXTranslationUnit_Flags,
        out_TU: Ptr[CXTranslationUnit]
    ): CXErrorCode = extern

    def clang_disposeIndex(CIdx: CXIndex): Unit = extern
    def clang_disposeTranslationUnit(unit: CXTranslationUnit): Unit = extern
    def clang_getCursorKind(unit: CXCursor): CXCursorKind = extern
    def clang_getCursorLanguage(cursor: CXCursor): CXLanguageKind = extern

    private[libclang] def wrap_getNullCursor(ptr: CXCursor): Unit = extern

    private[libclang] def wrap_getCursorSpelling(
        cursor: CXCursor,
        str: CXString
    ): Unit = extern

    private[libclang] def wrap_getCursorKindSpelling(
        cursor: CXCursorKind,
        ptr: CXString
    ): Unit = extern

    private[libclang] def wrap_getTranslationUnitCursor(
        ptr: CXCursor,
        unit: CXTranslationUnit
    ): Unit = extern

    private[libclang] def wrap_getCursorType(
        ptr: CXCursor,
        unit: CXType
    ): Unit = extern

    private[libclang] def wrap_getResultType(
        ptr: CXType,
        unit: CXType
    ): Unit = extern
    
    private[libclang] def wrap_getTypeSpelling(
        ptr: CXType,
        unit: CXString
    ): Unit = extern

    private[libclang] def wrap_hashCursor(ptr: CXCursor): UInt = extern

    @name("wrap_visitChildren")
    def clang_visitChildren(
        parent: CXCursor,
        visitor: CXCursorVisitor,
        data: CXClientData
    ): UInt = extern

    @name("wrap_getCString")
    def clang_getCString(cxs: CXString): CString = extern

    @name("wrap_disposeString")
    def clang_disposeString(cxs: CXString): Unit = extern

  end methods
end defs
