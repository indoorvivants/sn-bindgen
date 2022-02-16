package libclang

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import scala.language.implicitConversions

abstract class CEnum[T](using eq: T =:= Int):
  given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
  extension (t: T) def int: CInt = eq.apply(t)

abstract class CEnumU[T](using eq: T =:= UInt):
  given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]

object defs:
  export methods.*
  export wrappers.*

  import enumerations.*
  import types.*

  object wrappers:
    def clang_getNullCursor()(implicit z: Zone) =
      val ptr = CXCursor.allocate(1)
      wrap_getNullCursor(ptr)
      ptr

    def clang_getTranslationUnitCursor(unit: CXTranslationUnit)(using
        Zone
    ): CXCursor =
      val ptr = CXCursor.allocate(1)
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

    def clang_getEnumDeclIntegerType(curs: CXCursor)(using Zone): CXType =
      val ptr = CXType.allocate(1)
      wrap_getEnumDeclIntegerType(curs, ptr)
      ptr

    def clang_getTypedefDeclUnderlyingType(curs: CXCursor)(using Zone): CXType =
      val ptr = CXType.allocate(1)
      wrap_getTypedefDeclUnderlyingType(curs, ptr)
      ptr

    def clang_getTypeSpelling(curs: CXType)(using Zone): CXString =
      val ptr = CXString.allocate(1)
      wrap_getTypeSpelling(curs, ptr)
      ptr

    def clang_getTypeKindSpelling(curs: CXTypeKind)(using Zone): CXString =
      val ptr = CXString.allocate(1)
      wrap_getTypeKindSpelling(curs, ptr)
      ptr

    def clang_getTypedefName(curs: CXType)(using Zone): CXString =
      val ptr = CXString.allocate(1)
      wrap_getTypedefName(curs, ptr)
      ptr

    def clang_getPointeeType(curs: CXType)(using Zone): CXType =
      val ptr = CXType.allocate(1)
      wrap_getPointeeType(curs, ptr)
      ptr

    def clang_getArrayElementType(curs: CXType)(using Zone): CXType =
      val ptr = CXType.allocate(1)
      wrap_getArrayElementType(curs, ptr)
      ptr
    def clang_getArgType(curs: CXType, idx: CInt)(using Zone): CXType =
      val ptr = CXType.allocate(1)
      wrap_getArgType(curs, ptr, idx)
      ptr

    def clang_Type_getNamedType(curs: CXType)(using Zone): CXType =
      val ptr = CXType.allocate(1)
      wrap_Type_getNamedType(curs, ptr)
      ptr
    def clang_getCanonicalType(curs: CXType)(using Zone): CXType =
      val ptr = CXType.allocate(1)
      wrap_getCanonicalType(curs, ptr)
      ptr

    def clang_getTypeDeclaration(curs: CXType)(using Zone): CXCursor =
      val ptr = CXCursor.allocate(1)
      wrap_getTypeDeclaration(curs, ptr)
      ptr

    def clang_getCursorLocation(curs: CXCursor)(using Zone): CXSourceLocation =
      val ptr = CXSourceLocation.allocate(1)
      wrap_getCursorLocation(curs, ptr)
      ptr

    def clang_formatDiagnostic(
        curs: CXDiagnostic,
        options: CUnsignedInt = 0.toUInt
    )(using Zone): CXString =
      val ptr = CXString.allocate(1)
      wrap_formatDiagnostic(curs, ptr, options)
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
    def clang_getDiagnostic(
        unit: CXTranslationUnit,
        idx: CUnsignedInt
    ): CXDiagnostic = extern
    def clang_getNumDiagnostics(unit: CXTranslationUnit): CUnsignedInt = extern
    def clang_getDiagnosticSeverity(unit: CXDiagnostic): CXDiagnosticSeverity =
      extern

    def clang_isFunctionTypeVariadic(typ: CXType): CUnsignedInt = extern

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

    private[libclang] def wrap_getEnumDeclIntegerType(
        cursor: CXCursor,
        result: CXType
    ): Unit = extern

    private[libclang] def wrap_getTypedefDeclUnderlyingType(
        cursor: CXCursor,
        result: CXType
    ): Unit = extern

    private[libclang] def wrap_getTypeSpelling(
        ptr: CXType,
        unit: CXString
    ): Unit = extern

    private[libclang] def wrap_getTypeKindSpelling(
        ptr: CXTypeKind,
        unit: CXString
    ): Unit = extern

    private[libclang] def wrap_getTypedefName(
        ptr: CXType,
        unit: CXString
    ): Unit = extern

    private[libclang] def wrap_getPointeeType(
        ptr: CXType,
        unit: CXType
    ): Unit = extern

    private[libclang] def wrap_getArrayElementType(
        ptr: CXType,
        unit: CXType
    ): Unit = extern

    private[libclang] def wrap_Type_getNamedType(
        ptr: CXType,
        unit: CXType
    ): Unit = extern

    private[libclang] def wrap_getCanonicalType(
        ptr: CXType,
        unit: CXType
    ): Unit = extern

    private[libclang] def wrap_getTypeDeclaration(
        ptr: CXType,
        unit: CXCursor
    ): Unit = extern

    private[libclang] def wrap_getArgType(
        functionType: CXType,
        elementType: CXType,
        idx: CInt
    ): Unit = extern

    private[libclang] def wrap_getCursorLocation(
        curs: CXCursor,
        loc: CXSourceLocation
    ): Unit = extern

    private[libclang] def wrap_formatDiagnostic(
        curs: CXDiagnostic,
        loc: CXString,
        options: CUnsignedInt
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

    @name("wrap_getEnumConstantDeclValue")
    def clang_getEnumConstantDeclValue(curs: CXCursor): CLongLong = extern

    @name("wrap_getNumArgTypes")
    def clang_getNumArgTypes(curs: CXType): CInt = extern

    @name("wrap_getArraySize")
    def clang_getArraySize(curs: CXType): CInt = extern

    @name("wrap_Cursor_isAnonymousRecordDecl")
    def clang_Cursor_isAnonymousRecordDecl(curs: CXCursor): CUnsignedInt =
      extern

    @name("wrap_Cursor_isAnonymous")
    def clang_Cursor_isAnonymous(curs: CXCursor): CUnsignedInt =
      extern

    @name("wrap_Location_isFromMainFile")
    def clang_Location_isFromMainFile(curs: CXSourceLocation): CUnsignedInt =
      extern

    @name("wrap_Location_isInSystemHeader")
    def clang_Location_isInSystemHeader(curs: CXSourceLocation): CUnsignedInt =
      extern
  end methods
end defs
