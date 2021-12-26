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
  abstract class CEnumU[T](using eq: T =:= UInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]

  object CXUnsafeFile:
    extension (cxuf: CXUnsavedFile)
      def Filename = cxuf._1
      def Context = cxuf._2
      def Length = cxuf._3

  opaque type CXTranslationUnit_Flags = CUnsignedInt
  object CXTranslationUnit_Flags extends CEnumU[CXTranslationUnit_Flags]:
    private type T = CXTranslationUnit_Flags
    private val zero = 0x00.toUInt
    val CXTranslationUnit_None: T = zero

  opaque type CXCursor = CStruct3[CXCursorKind, CInt, CArray[Ptr[Byte], Nat._3]]
  object CXCursor:
    val NULL: CXCursor = null
    extension (cursor: CXCursor)
      def kind: CXCursorKind = cursor._1
      def xdata: CInt = cursor._2

    given Tag[CXCursor] =
      Tag
        .materializeCStruct3Tag[CXCursorKind, CInt, CArray[Ptr[Byte], Nat._3]]

  opaque type CXCursorKind = CInt
  object CXKursorKind extends CEnum[CXCursorKind]:
    val CXCursor_UnexposedDecl: CXCursorKind = 1
    val CXCursor_StructDecl: CXCursorKind = 2
    val CXCursor_UnionDecl: CXCursorKind = 3
    val CXCursor_ClassDecl: CXCursorKind = 4
    val CXCursor_EnumDecl: CXCursorKind = 5
  end CXKursorKind

  opaque type CXChildVisitResult = Int
  object CXChildVisitResult extends CEnum[CXChildVisitResult]:
    val CXChildVisit_Break: CXChildVisitResult = 0
    val CXChildVisit_Continue: CXChildVisitResult = 1
    val CXChildVisit_Recurse: CXChildVisitResult = 2
  end CXChildVisitResult

  type CXClientData = Ptr[Byte]
  object CXClientData:
    val NULL: CXClientData = null
    given Tag[CXClientData] =
      Tag
        .materializePtrTag[Byte](using Tag.Byte)
        .asInstanceOf[Tag[CXClientData]]

  opaque type CXCursorVisitor =
    CFuncPtr3[CXCursor, CXCursor, CXClientData, CXChildVisitResult]

  object CXCursorVisitor:
    inline def apply(
        inline f: (CXCursor, CXCursor, CXClientData) => CXChildVisitResult
    ): CXCursorVisitor = CFuncPtr3.fromScalaFunction(f)

    extension (v: CXCursorVisitor)
      inline def raw
          : CFuncPtr3[CXCursor, CXCursor, CXClientData, CXChildVisitResult] = v

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
      val ptr = alloc[CXCursor](1)
      wrap_getNullCursor(ptr)
      !ptr

    def clang_getTranslationUnitCursor(unit: CXTranslationUnit)(implicit
        z: Zone
    ): CXCursor =
      val ptr = alloc[CXCursor](1)
      wrap_getTranslationUnitCursor(ptr, unit)
      !ptr
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
    def clang_getCursorKind(unit: CXCursor): Unit = extern
    def clang_getCursorLanguage(cursor: CXCursor): CXLanguageKind = extern

    @name("scalanative_clang_getNullCursor")
    private[libclang] def wrap_getNullCursor(ptr: Ptr[CXCursor]): Unit = extern

    @name("scalanative_clang_getTranslationUnitCursor")
    private[libclang] def wrap_getTranslationUnitCursor(
        ptr: Ptr[CXCursor],
        unit: CXTranslationUnit
    ): Unit = extern

    def clang_visitChildren(
        parent: CXCursor,
        visitor: CXCursorVisitor,
        data: CXClientData
    ): Unit = extern
  end methods
end defs
