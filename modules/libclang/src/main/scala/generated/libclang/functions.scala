package libclang
package functions

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

import _root_.libclang.enumerations.*
import _root_.libclang.aliases.*
import _root_.libclang.structs.*

@extern
private[libclang] object extern_functions:
  private[libclang] def __sn_wrap_libclang_clang_CXCursorSet_contains(
      cset: CXCursorSet,
      cursor: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_CXCursorSet_insert(
      cset: CXCursorSet,
      cursor: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_CXXConstructor_isConvertingConstructor(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_CXXConstructor_isCopyConstructor(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_CXXConstructor_isDefaultConstructor(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_CXXConstructor_isMoveConstructor(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_CXXField_isMutable(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_CXXMethod_isConst(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_CXXMethod_isDefaulted(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_CXXMethod_isPureVirtual(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_CXXMethod_isStatic(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_CXXMethod_isVirtual(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_CXXRecord_isAbstract(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_Evaluate(
      C: Ptr[CXCursor]
  ): CXEvalResult = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getArgument(
      C: Ptr[CXCursor],
      i: CUnsignedInt,
      __return: Ptr[CXCursor]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getBriefCommentText(
      C: Ptr[CXCursor],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getCXXManglings(
      _0: Ptr[CXCursor]
  ): Ptr[CXStringSet] = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getCommentRange(
      C: Ptr[CXCursor],
      __return: Ptr[CXSourceRange]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getMangling(
      _0: Ptr[CXCursor],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getModule(
      C: Ptr[CXCursor]
  ): CXModule = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getNumArguments(
      C: Ptr[CXCursor]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getNumTemplateArguments(
      C: Ptr[CXCursor]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getObjCDeclQualifiers(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getObjCManglings(
      _0: Ptr[CXCursor]
  ): Ptr[CXStringSet] = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getObjCPropertyAttributes(
      C: Ptr[CXCursor],
      reserved: CUnsignedInt
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getObjCPropertyGetterName(
      C: Ptr[CXCursor],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getObjCPropertySetterName(
      C: Ptr[CXCursor],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getObjCSelectorIndex(
      _0: Ptr[CXCursor]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getOffsetOfField(
      C: Ptr[CXCursor]
  ): CLongLong = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getRawCommentText(
      C: Ptr[CXCursor],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getReceiverType(
      C: Ptr[CXCursor],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getSpellingNameRange(
      _0: Ptr[CXCursor],
      pieceIndex: CUnsignedInt,
      options: CUnsignedInt,
      __return: Ptr[CXSourceRange]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getStorageClass(
      _0: Ptr[CXCursor]
  ): CX_StorageClass = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getTemplateArgumentKind(
      C: Ptr[CXCursor],
      I: CUnsignedInt
  ): CXTemplateArgumentKind = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getTemplateArgumentType(
      C: Ptr[CXCursor],
      I: CUnsignedInt,
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getTemplateArgumentUnsignedValue(
      C: Ptr[CXCursor],
      I: CUnsignedInt
  ): CUnsignedLongLong = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getTemplateArgumentValue(
      C: Ptr[CXCursor],
      I: CUnsignedInt
  ): CLongLong = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getTranslationUnit(
      _0: Ptr[CXCursor]
  ): CXTranslationUnit = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_getVarDeclInitializer(
      cursor: Ptr[CXCursor],
      __return: Ptr[CXCursor]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_hasAttrs(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_hasVarDeclExternalStorage(
      cursor: Ptr[CXCursor]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_hasVarDeclGlobalStorage(
      cursor: Ptr[CXCursor]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_isAnonymous(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_isAnonymousRecordDecl(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_isBitField(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_isDynamicCall(
      C: Ptr[CXCursor]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_isExternalSymbol(
      C: Ptr[CXCursor],
      language: Ptr[CXString],
      definedIn: Ptr[CXString],
      isGenerated: Ptr[CUnsignedInt]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_isFunctionInlined(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_isInlineNamespace(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_isMacroBuiltin(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_isMacroFunctionLike(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_isNull(
      cursor: Ptr[CXCursor]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_isObjCOptional(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Cursor_isVariadic(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_EnumDecl_isScoped(
      C: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_File_tryGetRealPathName(
      file: CXFile,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Location_isFromMainFile(
      location: Ptr[CXSourceLocation]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Location_isInSystemHeader(
      location: Ptr[CXSourceLocation]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Module_getFullName(
      Module: CXModule,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Module_getName(
      Module: CXModule,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Range_isNull(
      range: Ptr[CXSourceRange]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_TargetInfo_getTriple(
      Info: CXTargetInfo,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getAlignOf(
      T: Ptr[CXType]
  ): CLongLong = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getCXXRefQualifier(
      T: Ptr[CXType]
  ): CXRefQualifierKind = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getClassType(
      T: Ptr[CXType],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getModifiedType(
      T: Ptr[CXType],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getNamedType(
      T: Ptr[CXType],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getNullability(
      T: Ptr[CXType]
  ): CXTypeNullabilityKind = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getNumObjCProtocolRefs(
      T: Ptr[CXType]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getNumObjCTypeArgs(
      T: Ptr[CXType]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getNumTemplateArguments(
      T: Ptr[CXType]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getObjCEncoding(
      `type`: Ptr[CXType],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getObjCObjectBaseType(
      T: Ptr[CXType],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getObjCProtocolDecl(
      T: Ptr[CXType],
      i: CUnsignedInt,
      __return: Ptr[CXCursor]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getObjCTypeArg(
      T: Ptr[CXType],
      i: CUnsignedInt,
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getOffsetOf(
      T: Ptr[CXType],
      S: CString
  ): CLongLong = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getSizeOf(
      T: Ptr[CXType]
  ): CLongLong = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getTemplateArgumentAsType(
      T: Ptr[CXType],
      i: CUnsignedInt,
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_getValueType(
      CT: Ptr[CXType],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_isTransparentTagTypedef(
      T: Ptr[CXType]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_Type_visitFields(
      T: Ptr[CXType],
      visitor: CXFieldVisitor,
      client_data: CXClientData
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_codeCompleteGetContainerUSR(
      Results: Ptr[CXCodeCompleteResults],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_codeCompleteGetObjCSelector(
      Results: Ptr[CXCodeCompleteResults],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_constructUSR_ObjCCategory(
      class_name: CString,
      category_name: CString,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_constructUSR_ObjCClass(
      class_name: CString,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_constructUSR_ObjCIvar(
      name: CString,
      classUSR: Ptr[CXString],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_constructUSR_ObjCMethod(
      name: CString,
      isInstanceMethod: CUnsignedInt,
      classUSR: Ptr[CXString],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_constructUSR_ObjCProperty(
      property: CString,
      classUSR: Ptr[CXString],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_constructUSR_ObjCProtocol(
      protocol_name: CString,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_disposeCXTUResourceUsage(
      usage: Ptr[CXTUResourceUsage]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_disposeString(
      string: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_equalCursors(
      _0: Ptr[CXCursor],
      _1: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_equalLocations(
      loc1: Ptr[CXSourceLocation],
      loc2: Ptr[CXSourceLocation]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_equalRanges(
      range1: Ptr[CXSourceRange],
      range2: Ptr[CXSourceRange]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_equalTypes(
      A: Ptr[CXType],
      B: Ptr[CXType]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_findIncludesInFile(
      TU: CXTranslationUnit,
      file: CXFile,
      visitor: Ptr[CXCursorAndRangeVisitor]
  ): CXResult = extern

  private[libclang] def __sn_wrap_libclang_clang_findReferencesInFile(
      cursor: Ptr[CXCursor],
      file: CXFile,
      visitor: Ptr[CXCursorAndRangeVisitor]
  ): CXResult = extern

  private[libclang] def __sn_wrap_libclang_clang_formatDiagnostic(
      Diagnostic: CXDiagnostic,
      Options: CUnsignedInt,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getAddressSpace(
      T: Ptr[CXType]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_getArgType(
      T: Ptr[CXType],
      i: CUnsignedInt,
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getArrayElementType(
      T: Ptr[CXType],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getArraySize(
      T: Ptr[CXType]
  ): CLongLong = extern

  private[libclang] def __sn_wrap_libclang_clang_getCString(
      string: Ptr[CXString]
  ): CString = extern

  private[libclang] def __sn_wrap_libclang_clang_getCXTUResourceUsage(
      TU: CXTranslationUnit,
      __return: Ptr[CXTUResourceUsage]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCXXAccessSpecifier(
      _0: Ptr[CXCursor]
  ): CX_CXXAccessSpecifier = extern

  private[libclang] def __sn_wrap_libclang_clang_getCanonicalCursor(
      _0: Ptr[CXCursor],
      __return: Ptr[CXCursor]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCanonicalType(
      T: Ptr[CXType],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getClangVersion(
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCompletionAnnotation(
      completion_string: CXCompletionString,
      annotation_number: CUnsignedInt,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCompletionBriefComment(
      completion_string: CXCompletionString,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCompletionChunkText(
      completion_string: CXCompletionString,
      chunk_number: CUnsignedInt,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCompletionFixIt(
      results: Ptr[CXCodeCompleteResults],
      completion_index: CUnsignedInt,
      fixit_index: CUnsignedInt,
      replacement_range: Ptr[CXSourceRange],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCompletionParent(
      completion_string: CXCompletionString,
      kind: Ptr[CXCursorKind],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursor(
      _0: CXTranslationUnit,
      _1: Ptr[CXSourceLocation],
      __return: Ptr[CXCursor]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorAvailability(
      cursor: Ptr[CXCursor]
  ): CXAvailabilityKind = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorCompletionString(
      cursor: Ptr[CXCursor]
  ): CXCompletionString = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorDefinition(
      _0: Ptr[CXCursor],
      __return: Ptr[CXCursor]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorDisplayName(
      _0: Ptr[CXCursor],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorExceptionSpecificationType(
      C: Ptr[CXCursor]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorExtent(
      _0: Ptr[CXCursor],
      __return: Ptr[CXSourceRange]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorKind(
      _0: Ptr[CXCursor]
  ): CXCursorKind = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorKindSpelling(
      Kind: CXCursorKind,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorLanguage(
      cursor: Ptr[CXCursor]
  ): CXLanguageKind = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorLexicalParent(
      cursor: Ptr[CXCursor],
      __return: Ptr[CXCursor]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorLinkage(
      cursor: Ptr[CXCursor]
  ): CXLinkageKind = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorLocation(
      _0: Ptr[CXCursor],
      __return: Ptr[CXSourceLocation]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorPlatformAvailability(
      cursor: Ptr[CXCursor],
      always_deprecated: Ptr[CInt],
      deprecated_message: Ptr[CXString],
      always_unavailable: Ptr[CInt],
      unavailable_message: Ptr[CXString],
      availability: Ptr[CXPlatformAvailability],
      availability_size: CInt
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorPrettyPrinted(
      Cursor: Ptr[CXCursor],
      Policy: CXPrintingPolicy,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorPrintingPolicy(
      _0: Ptr[CXCursor]
  ): CXPrintingPolicy = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorReferenceNameRange(
      C: Ptr[CXCursor],
      NameFlags: CUnsignedInt,
      PieceIndex: CUnsignedInt,
      __return: Ptr[CXSourceRange]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorReferenced(
      _0: Ptr[CXCursor],
      __return: Ptr[CXCursor]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorResultType(
      C: Ptr[CXCursor],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorSemanticParent(
      cursor: Ptr[CXCursor],
      __return: Ptr[CXCursor]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorSpelling(
      _0: Ptr[CXCursor],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorTLSKind(
      cursor: Ptr[CXCursor]
  ): CXTLSKind = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorType(
      C: Ptr[CXCursor],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorUSR(
      _0: Ptr[CXCursor],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getCursorVisibility(
      cursor: Ptr[CXCursor]
  ): CXVisibilityKind = extern

  private[libclang] def __sn_wrap_libclang_clang_getDeclObjCTypeEncoding(
      C: Ptr[CXCursor],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getDefinitionSpellingAndExtent(
      _0: Ptr[CXCursor],
      startBuf: Ptr[CString],
      endBuf: Ptr[CString],
      startLine: Ptr[CUnsignedInt],
      startColumn: Ptr[CUnsignedInt],
      endLine: Ptr[CUnsignedInt],
      endColumn: Ptr[CUnsignedInt]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getDiagnosticCategoryName(
      Category: CUnsignedInt,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getDiagnosticCategoryText(
      _0: CXDiagnostic,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getDiagnosticFixIt(
      Diagnostic: CXDiagnostic,
      FixIt: CUnsignedInt,
      ReplacementRange: Ptr[CXSourceRange],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getDiagnosticLocation(
      _0: CXDiagnostic,
      __return: Ptr[CXSourceLocation]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getDiagnosticOption(
      Diag: CXDiagnostic,
      Disable: Ptr[CXString],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getDiagnosticRange(
      Diagnostic: CXDiagnostic,
      Range: CUnsignedInt,
      __return: Ptr[CXSourceRange]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getDiagnosticSpelling(
      _0: CXDiagnostic,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getElementType(
      T: Ptr[CXType],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getEnumConstantDeclUnsignedValue(
      C: Ptr[CXCursor]
  ): CUnsignedLongLong = extern

  private[libclang] def __sn_wrap_libclang_clang_getEnumConstantDeclValue(
      C: Ptr[CXCursor]
  ): CLongLong = extern

  private[libclang] def __sn_wrap_libclang_clang_getEnumDeclIntegerType(
      C: Ptr[CXCursor],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getExceptionSpecificationType(
      T: Ptr[CXType]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_getExpansionLocation(
      location: Ptr[CXSourceLocation],
      file: Ptr[CXFile],
      line: Ptr[CUnsignedInt],
      column: Ptr[CUnsignedInt],
      offset: Ptr[CUnsignedInt]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getFieldDeclBitWidth(
      C: Ptr[CXCursor]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_getFileLocation(
      location: Ptr[CXSourceLocation],
      file: Ptr[CXFile],
      line: Ptr[CUnsignedInt],
      column: Ptr[CUnsignedInt],
      offset: Ptr[CUnsignedInt]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getFileName(
      SFile: CXFile,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getFunctionTypeCallingConv(
      T: Ptr[CXType]
  ): CXCallingConv = extern

  private[libclang] def __sn_wrap_libclang_clang_getIBOutletCollectionType(
      _0: Ptr[CXCursor],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getIncludedFile(
      cursor: Ptr[CXCursor]
  ): CXFile = extern

  private[libclang] def __sn_wrap_libclang_clang_getInstantiationLocation(
      location: Ptr[CXSourceLocation],
      file: Ptr[CXFile],
      line: Ptr[CUnsignedInt],
      column: Ptr[CUnsignedInt],
      offset: Ptr[CUnsignedInt]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getLocation(
      tu: CXTranslationUnit,
      file: CXFile,
      line: CUnsignedInt,
      column: CUnsignedInt,
      __return: Ptr[CXSourceLocation]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getLocationForOffset(
      tu: CXTranslationUnit,
      file: CXFile,
      offset: CUnsignedInt,
      __return: Ptr[CXSourceLocation]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getNullCursor(
      __return: Ptr[CXCursor]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getNullLocation(
      __return: Ptr[CXSourceLocation]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getNullRange(
      __return: Ptr[CXSourceRange]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getNumArgTypes(
      T: Ptr[CXType]
  ): CInt = extern

  private[libclang] def __sn_wrap_libclang_clang_getNumElements(
      T: Ptr[CXType]
  ): CLongLong = extern

  private[libclang] def __sn_wrap_libclang_clang_getNumOverloadedDecls(
      cursor: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_getOverloadedDecl(
      cursor: Ptr[CXCursor],
      index: CUnsignedInt,
      __return: Ptr[CXCursor]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getOverriddenCursors(
      cursor: Ptr[CXCursor],
      overridden: Ptr[Ptr[CXCursor]],
      num_overridden: Ptr[CUnsignedInt]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getPointeeType(
      T: Ptr[CXType],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getPresumedLocation(
      location: Ptr[CXSourceLocation],
      filename: Ptr[CXString],
      line: Ptr[CUnsignedInt],
      column: Ptr[CUnsignedInt]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getRange(
      begin: Ptr[CXSourceLocation],
      end: Ptr[CXSourceLocation],
      __return: Ptr[CXSourceRange]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getRangeEnd(
      range: Ptr[CXSourceRange],
      __return: Ptr[CXSourceLocation]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getRangeStart(
      range: Ptr[CXSourceRange],
      __return: Ptr[CXSourceLocation]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getResultType(
      T: Ptr[CXType],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getSpecializedCursorTemplate(
      C: Ptr[CXCursor],
      __return: Ptr[CXCursor]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getSpellingLocation(
      location: Ptr[CXSourceLocation],
      file: Ptr[CXFile],
      line: Ptr[CUnsignedInt],
      column: Ptr[CUnsignedInt],
      offset: Ptr[CUnsignedInt]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getTemplateCursorKind(
      C: Ptr[CXCursor]
  ): CXCursorKind = extern

  private[libclang] def __sn_wrap_libclang_clang_getToken(
      TU: CXTranslationUnit,
      Location: Ptr[CXSourceLocation]
  ): Ptr[CXToken] = extern

  private[libclang] def __sn_wrap_libclang_clang_getTokenExtent(
      _0: CXTranslationUnit,
      _1: Ptr[CXToken],
      __return: Ptr[CXSourceRange]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getTokenKind(
      _0: Ptr[CXToken]
  ): CXTokenKind = extern

  private[libclang] def __sn_wrap_libclang_clang_getTokenLocation(
      _0: CXTranslationUnit,
      _1: Ptr[CXToken],
      __return: Ptr[CXSourceLocation]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getTokenSpelling(
      _0: CXTranslationUnit,
      _1: Ptr[CXToken],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getTranslationUnitCursor(
      _0: CXTranslationUnit,
      __return: Ptr[CXCursor]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getTranslationUnitSpelling(
      CTUnit: CXTranslationUnit,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getTypeDeclaration(
      T: Ptr[CXType],
      __return: Ptr[CXCursor]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getTypeKindSpelling(
      K: CXTypeKind,
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getTypeSpelling(
      CT: Ptr[CXType],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getTypedefDeclUnderlyingType(
      C: Ptr[CXCursor],
      __return: Ptr[CXType]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_getTypedefName(
      CT: Ptr[CXType],
      __return: Ptr[CXString]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_hashCursor(
      _0: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_indexLoc_getCXSourceLocation(
      loc: Ptr[CXIdxLoc],
      __return: Ptr[CXSourceLocation]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_indexLoc_getFileLocation(
      loc: Ptr[CXIdxLoc],
      indexFile: Ptr[CXIdxClientFile],
      file: Ptr[CXFile],
      line: Ptr[CUnsignedInt],
      column: Ptr[CUnsignedInt],
      offset: Ptr[CUnsignedInt]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_isConstQualifiedType(
      T: Ptr[CXType]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_isCursorDefinition(
      _0: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_isFunctionTypeVariadic(
      T: Ptr[CXType]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_isInvalidDeclaration(
      _0: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_isPODType(
      T: Ptr[CXType]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_isRestrictQualifiedType(
      T: Ptr[CXType]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_isVirtualBase(
      _0: Ptr[CXCursor]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_isVolatileQualifiedType(
      T: Ptr[CXType]
  ): CUnsignedInt = extern

  private[libclang] def __sn_wrap_libclang_clang_tokenize(
      TU: CXTranslationUnit,
      Range: Ptr[CXSourceRange],
      Tokens: Ptr[Ptr[CXToken]],
      NumTokens: Ptr[CUnsignedInt]
  ): Unit = extern

  private[libclang] def __sn_wrap_libclang_clang_visitChildren(
      parent: Ptr[CXCursor],
      visitor: CXCursorVisitor,
      client_data: CXClientData
  ): CUnsignedInt = extern

  def clang_CXIndex_getGlobalOptions(_0: CXIndex): CUnsignedInt = extern

  def clang_CXIndex_setGlobalOptions(_0: CXIndex, options: CUnsignedInt): Unit =
    extern

  def clang_CXIndex_setInvocationEmissionPathOption(
      _0: CXIndex,
      Path: CString
  ): Unit = extern

  def clang_EvalResult_dispose(E: CXEvalResult): Unit = extern

  def clang_EvalResult_getAsDouble(E: CXEvalResult): Double = extern

  def clang_EvalResult_getAsInt(E: CXEvalResult): CInt = extern

  def clang_EvalResult_getAsLongLong(E: CXEvalResult): CLongLong = extern

  def clang_EvalResult_getAsStr(E: CXEvalResult): CString = extern

  def clang_EvalResult_getAsUnsigned(E: CXEvalResult): CUnsignedLongLong =
    extern

  def clang_EvalResult_getKind(E: CXEvalResult): CXEvalResultKind = extern

  def clang_EvalResult_isUnsignedInt(E: CXEvalResult): CUnsignedInt = extern

  def clang_File_isEqual(file1: CXFile, file2: CXFile): CInt = extern

  def clang_IndexAction_create(CIdx: CXIndex): CXIndexAction = extern

  def clang_IndexAction_dispose(_0: CXIndexAction): Unit = extern

  def clang_ModuleMapDescriptor_create(
      options: CUnsignedInt
  ): CXModuleMapDescriptor = extern

  def clang_ModuleMapDescriptor_dispose(_0: CXModuleMapDescriptor): Unit =
    extern

  def clang_ModuleMapDescriptor_setFrameworkModuleName(
      _0: CXModuleMapDescriptor,
      name: CString
  ): CXErrorCode = extern

  def clang_ModuleMapDescriptor_setUmbrellaHeader(
      _0: CXModuleMapDescriptor,
      name: CString
  ): CXErrorCode = extern

  def clang_ModuleMapDescriptor_writeToBuffer(
      _0: CXModuleMapDescriptor,
      options: CUnsignedInt,
      out_buffer_ptr: Ptr[CString],
      out_buffer_size: Ptr[CUnsignedInt]
  ): CXErrorCode = extern

  def clang_Module_getASTFile(Module: CXModule): CXFile = extern

  def clang_Module_getNumTopLevelHeaders(
      _0: CXTranslationUnit,
      Module: CXModule
  ): CUnsignedInt = extern

  def clang_Module_getParent(Module: CXModule): CXModule = extern

  def clang_Module_getTopLevelHeader(
      _0: CXTranslationUnit,
      Module: CXModule,
      Index: CUnsignedInt
  ): CXFile = extern

  def clang_Module_isSystem(Module: CXModule): CInt = extern

  def clang_PrintingPolicy_dispose(Policy: CXPrintingPolicy): Unit = extern

  def clang_PrintingPolicy_getProperty(
      Policy: CXPrintingPolicy,
      Property: CXPrintingPolicyProperty
  ): CUnsignedInt = extern

  def clang_PrintingPolicy_setProperty(
      Policy: CXPrintingPolicy,
      Property: CXPrintingPolicyProperty,
      Value: CUnsignedInt
  ): Unit = extern

  def clang_TargetInfo_dispose(Info: CXTargetInfo): Unit = extern

  def clang_TargetInfo_getPointerWidth(Info: CXTargetInfo): CInt = extern

  def clang_VirtualFileOverlay_addFileMapping(
      _0: CXVirtualFileOverlay,
      virtualPath: CString,
      realPath: CString
  ): CXErrorCode = extern

  def clang_VirtualFileOverlay_create(
      options: CUnsignedInt
  ): CXVirtualFileOverlay = extern

  def clang_VirtualFileOverlay_dispose(_0: CXVirtualFileOverlay): Unit = extern

  def clang_VirtualFileOverlay_setCaseSensitivity(
      _0: CXVirtualFileOverlay,
      caseSensitive: CInt
  ): CXErrorCode = extern

  def clang_VirtualFileOverlay_writeToBuffer(
      _0: CXVirtualFileOverlay,
      options: CUnsignedInt,
      out_buffer_ptr: Ptr[CString],
      out_buffer_size: Ptr[CUnsignedInt]
  ): CXErrorCode = extern

  def clang_annotateTokens(
      TU: CXTranslationUnit,
      Tokens: Ptr[CXToken],
      NumTokens: CUnsignedInt,
      Cursors: Ptr[CXCursor]
  ): Unit = extern

  def clang_codeCompleteAt(
      TU: CXTranslationUnit,
      complete_filename: CString,
      complete_line: CUnsignedInt,
      complete_column: CUnsignedInt,
      unsaved_files: Ptr[CXUnsavedFile],
      num_unsaved_files: CUnsignedInt,
      options: CUnsignedInt
  ): Ptr[CXCodeCompleteResults] = extern

  def clang_codeCompleteGetContainerKind(
      Results: Ptr[CXCodeCompleteResults],
      IsIncomplete: Ptr[CUnsignedInt]
  ): CXCursorKind = extern

  def clang_codeCompleteGetContexts(
      Results: Ptr[CXCodeCompleteResults]
  ): CUnsignedLongLong = extern

  def clang_codeCompleteGetDiagnostic(
      Results: Ptr[CXCodeCompleteResults],
      Index: CUnsignedInt
  ): CXDiagnostic = extern

  def clang_codeCompleteGetNumDiagnostics(
      Results: Ptr[CXCodeCompleteResults]
  ): CUnsignedInt = extern

  def clang_createCXCursorSet(): CXCursorSet = extern

  def clang_createIndex(
      excludeDeclarationsFromPCH: CInt,
      displayDiagnostics: CInt
  ): CXIndex = extern

  def clang_createTranslationUnit(
      CIdx: CXIndex,
      ast_filename: CString
  ): CXTranslationUnit = extern

  def clang_createTranslationUnit2(
      CIdx: CXIndex,
      ast_filename: CString,
      out_TU: Ptr[CXTranslationUnit]
  ): CXErrorCode = extern

  def clang_createTranslationUnitFromSourceFile(
      CIdx: CXIndex,
      source_filename: CString,
      num_clang_command_line_args: CInt,
      clang_command_line_args: Ptr[CString],
      num_unsaved_files: CUnsignedInt,
      unsaved_files: Ptr[CXUnsavedFile]
  ): CXTranslationUnit = extern

  def clang_defaultCodeCompleteOptions(): CUnsignedInt = extern

  def clang_defaultDiagnosticDisplayOptions(): CUnsignedInt = extern

  def clang_defaultEditingTranslationUnitOptions(): CUnsignedInt = extern

  def clang_defaultReparseOptions(TU: CXTranslationUnit): CUnsignedInt = extern

  def clang_defaultSaveOptions(TU: CXTranslationUnit): CUnsignedInt = extern

  def clang_disposeCXCursorSet(cset: CXCursorSet): Unit = extern

  def clang_disposeCXPlatformAvailability(
      availability: Ptr[CXPlatformAvailability]
  ): Unit = extern

  def clang_disposeCodeCompleteResults(
      Results: Ptr[CXCodeCompleteResults]
  ): Unit = extern

  def clang_disposeDiagnostic(Diagnostic: CXDiagnostic): Unit = extern

  def clang_disposeDiagnosticSet(Diags: CXDiagnosticSet): Unit = extern

  def clang_disposeIndex(index: CXIndex): Unit = extern

  def clang_disposeOverriddenCursors(overridden: Ptr[CXCursor]): Unit = extern

  def clang_disposeSourceRangeList(ranges: Ptr[CXSourceRangeList]): Unit =
    extern

  def clang_disposeStringSet(set: Ptr[CXStringSet]): Unit = extern

  def clang_disposeTokens(
      TU: CXTranslationUnit,
      Tokens: Ptr[CXToken],
      NumTokens: CUnsignedInt
  ): Unit = extern

  def clang_disposeTranslationUnit(_0: CXTranslationUnit): Unit = extern

  def clang_enableStackTraces(): Unit = extern

  def clang_executeOnThread(
      fn: CFuncPtr1[Ptr[Byte], Unit],
      user_data: Ptr[Byte],
      stack_size: CUnsignedInt
  ): Unit = extern

  def clang_free(buffer: Ptr[Byte]): Unit = extern

  def clang_getAllSkippedRanges(tu: CXTranslationUnit): Ptr[CXSourceRangeList] =
    extern

  def clang_getBuildSessionTimestamp(): CUnsignedLongLong = extern

  def clang_getChildDiagnostics(D: CXDiagnostic): CXDiagnosticSet = extern

  def clang_getCompletionAvailability(
      completion_string: CXCompletionString
  ): CXAvailabilityKind = extern

  def clang_getCompletionChunkCompletionString(
      completion_string: CXCompletionString,
      chunk_number: CUnsignedInt
  ): CXCompletionString = extern

  def clang_getCompletionChunkKind(
      completion_string: CXCompletionString,
      chunk_number: CUnsignedInt
  ): CXCompletionChunkKind = extern

  def clang_getCompletionNumAnnotations(
      completion_string: CXCompletionString
  ): CUnsignedInt = extern

  def clang_getCompletionNumFixIts(
      results: Ptr[CXCodeCompleteResults],
      completion_index: CUnsignedInt
  ): CUnsignedInt = extern

  def clang_getCompletionPriority(
      completion_string: CXCompletionString
  ): CUnsignedInt = extern

  def clang_getDiagnostic(
      Unit: CXTranslationUnit,
      Index: CUnsignedInt
  ): CXDiagnostic = extern

  def clang_getDiagnosticCategory(_0: CXDiagnostic): CUnsignedInt = extern

  def clang_getDiagnosticInSet(
      Diags: CXDiagnosticSet,
      Index: CUnsignedInt
  ): CXDiagnostic = extern

  def clang_getDiagnosticNumFixIts(Diagnostic: CXDiagnostic): CUnsignedInt =
    extern

  def clang_getDiagnosticNumRanges(_0: CXDiagnostic): CUnsignedInt = extern

  def clang_getDiagnosticSetFromTU(Unit: CXTranslationUnit): CXDiagnosticSet =
    extern

  def clang_getDiagnosticSeverity(_0: CXDiagnostic): CXDiagnosticSeverity =
    extern

  def clang_getFile(tu: CXTranslationUnit, file_name: CString): CXFile = extern

  def clang_getFileContents(
      tu: CXTranslationUnit,
      file: CXFile,
      size: Ptr[size_t]
  ): CString = extern

  def clang_getFileTime(SFile: CXFile): time_t = extern

  def clang_getFileUniqueID(file: CXFile, outID: Ptr[CXFileUniqueID]): CInt =
    extern

  def clang_getInclusions(
      tu: CXTranslationUnit,
      visitor: CXInclusionVisitor,
      client_data: CXClientData
  ): Unit = extern

  def clang_getModuleForFile(_0: CXTranslationUnit, _1: CXFile): CXModule =
    extern

  def clang_getNumCompletionChunks(
      completion_string: CXCompletionString
  ): CUnsignedInt = extern

  def clang_getNumDiagnostics(Unit: CXTranslationUnit): CUnsignedInt = extern

  def clang_getNumDiagnosticsInSet(Diags: CXDiagnosticSet): CUnsignedInt =
    extern

  def clang_getRemappings(path: CString): CXRemapping = extern

  def clang_getRemappingsFromFileList(
      filePaths: Ptr[CString],
      numFiles: CUnsignedInt
  ): CXRemapping = extern

  def clang_getSkippedRanges(
      tu: CXTranslationUnit,
      file: CXFile
  ): Ptr[CXSourceRangeList] = extern

  def clang_getTUResourceUsageName(kind: CXTUResourceUsageKind): CString =
    extern

  def clang_getTranslationUnitTargetInfo(
      CTUnit: CXTranslationUnit
  ): CXTargetInfo = extern

  def clang_indexSourceFile(
      _0: CXIndexAction,
      client_data: CXClientData,
      index_callbacks: Ptr[IndexerCallbacks],
      index_callbacks_size: CUnsignedInt,
      index_options: CUnsignedInt,
      source_filename: CString,
      command_line_args: Ptr[CString],
      num_command_line_args: CInt,
      unsaved_files: Ptr[CXUnsavedFile],
      num_unsaved_files: CUnsignedInt,
      out_TU: Ptr[CXTranslationUnit],
      TU_options: CUnsignedInt
  ): CInt = extern

  def clang_indexSourceFileFullArgv(
      _0: CXIndexAction,
      client_data: CXClientData,
      index_callbacks: Ptr[IndexerCallbacks],
      index_callbacks_size: CUnsignedInt,
      index_options: CUnsignedInt,
      source_filename: CString,
      command_line_args: Ptr[CString],
      num_command_line_args: CInt,
      unsaved_files: Ptr[CXUnsavedFile],
      num_unsaved_files: CUnsignedInt,
      out_TU: Ptr[CXTranslationUnit],
      TU_options: CUnsignedInt
  ): CInt = extern

  def clang_indexTranslationUnit(
      _0: CXIndexAction,
      client_data: CXClientData,
      index_callbacks: Ptr[IndexerCallbacks],
      index_callbacks_size: CUnsignedInt,
      index_options: CUnsignedInt,
      _5: CXTranslationUnit
  ): CInt = extern

  def clang_index_getCXXClassDeclInfo(
      _0: Ptr[CXIdxDeclInfo]
  ): Ptr[CXIdxCXXClassDeclInfo] = extern

  def clang_index_getClientContainer(
      _0: Ptr[CXIdxContainerInfo]
  ): CXIdxClientContainer = extern

  def clang_index_getClientEntity(_0: Ptr[CXIdxEntityInfo]): CXIdxClientEntity =
    extern

  def clang_index_getIBOutletCollectionAttrInfo(
      _0: Ptr[CXIdxAttrInfo]
  ): Ptr[CXIdxIBOutletCollectionAttrInfo] = extern

  def clang_index_getObjCCategoryDeclInfo(
      _0: Ptr[CXIdxDeclInfo]
  ): Ptr[CXIdxObjCCategoryDeclInfo] = extern

  def clang_index_getObjCContainerDeclInfo(
      _0: Ptr[CXIdxDeclInfo]
  ): Ptr[CXIdxObjCContainerDeclInfo] = extern

  def clang_index_getObjCInterfaceDeclInfo(
      _0: Ptr[CXIdxDeclInfo]
  ): Ptr[CXIdxObjCInterfaceDeclInfo] = extern

  def clang_index_getObjCPropertyDeclInfo(
      _0: Ptr[CXIdxDeclInfo]
  ): Ptr[CXIdxObjCPropertyDeclInfo] = extern

  def clang_index_getObjCProtocolRefListInfo(
      _0: Ptr[CXIdxDeclInfo]
  ): Ptr[CXIdxObjCProtocolRefListInfo] = extern

  def clang_index_isEntityObjCContainerKind(_0: CXIdxEntityKind): CInt = extern

  def clang_index_setClientContainer(
      _0: Ptr[CXIdxContainerInfo],
      _1: CXIdxClientContainer
  ): Unit = extern

  def clang_index_setClientEntity(
      _0: Ptr[CXIdxEntityInfo],
      _1: CXIdxClientEntity
  ): Unit = extern

  def clang_isAttribute(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isDeclaration(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isExpression(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isFileMultipleIncludeGuarded(
      tu: CXTranslationUnit,
      file: CXFile
  ): CUnsignedInt = extern

  def clang_isInvalid(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isPreprocessing(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isReference(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isStatement(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isTranslationUnit(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isUnexposed(_0: CXCursorKind): CUnsignedInt = extern

  def clang_loadDiagnostics(
      file: CString,
      error: Ptr[CXLoadDiag_Error],
      errorString: Ptr[CXString]
  ): CXDiagnosticSet = extern

  def clang_parseTranslationUnit(
      CIdx: CXIndex,
      source_filename: CString,
      command_line_args: Ptr[CString],
      num_command_line_args: CInt,
      unsaved_files: Ptr[CXUnsavedFile],
      num_unsaved_files: CUnsignedInt,
      options: CUnsignedInt
  ): CXTranslationUnit = extern

  def clang_parseTranslationUnit2(
      CIdx: CXIndex,
      source_filename: CString,
      command_line_args: Ptr[CString],
      num_command_line_args: CInt,
      unsaved_files: Ptr[CXUnsavedFile],
      num_unsaved_files: CUnsignedInt,
      options: CUnsignedInt,
      out_TU: Ptr[CXTranslationUnit]
  ): CXErrorCode = extern

  def clang_parseTranslationUnit2FullArgv(
      CIdx: CXIndex,
      source_filename: CString,
      command_line_args: Ptr[CString],
      num_command_line_args: CInt,
      unsaved_files: Ptr[CXUnsavedFile],
      num_unsaved_files: CUnsignedInt,
      options: CUnsignedInt,
      out_TU: Ptr[CXTranslationUnit]
  ): CXErrorCode = extern

  def clang_remap_dispose(_0: CXRemapping): Unit = extern

  def clang_remap_getFilenames(
      _0: CXRemapping,
      index: CUnsignedInt,
      original: Ptr[CXString],
      transformed: Ptr[CXString]
  ): Unit = extern

  def clang_remap_getNumFiles(_0: CXRemapping): CUnsignedInt = extern

  def clang_reparseTranslationUnit(
      TU: CXTranslationUnit,
      num_unsaved_files: CUnsignedInt,
      unsaved_files: Ptr[CXUnsavedFile],
      options: CUnsignedInt
  ): CInt = extern

  def clang_saveTranslationUnit(
      TU: CXTranslationUnit,
      FileName: CString,
      options: CUnsignedInt
  ): CInt = extern

  def clang_sortCodeCompletionResults(
      Results: Ptr[CXCompletionResult],
      NumResults: CUnsignedInt
  ): Unit = extern

  def clang_suspendTranslationUnit(_0: CXTranslationUnit): CUnsignedInt = extern

  def clang_toggleCrashRecovery(isEnabled: CUnsignedInt): Unit = extern
end extern_functions

import extern_functions.*
export extern_functions.*

def clang_CXCursorSet_contains(
    cset: CXCursorSet,
    cursor: Ptr[CXCursor]
): CUnsignedInt =
  __sn_wrap_libclang_clang_CXCursorSet_contains(cset, cursor)

def clang_CXCursorSet_contains(cset: CXCursorSet, cursor: CXCursor)(using
    Zone
): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_CXCursorSet_contains(cset, (__ptr_0 + 0))

def clang_CXCursorSet_insert(cset: CXCursorSet, cursor: CXCursor)(using
    Zone
): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_CXCursorSet_insert(cset, (__ptr_0 + 0))

def clang_CXCursorSet_insert(
    cset: CXCursorSet,
    cursor: Ptr[CXCursor]
): CUnsignedInt =
  __sn_wrap_libclang_clang_CXCursorSet_insert(cset, cursor)

def clang_CXXConstructor_isConvertingConstructor(
    C: Ptr[CXCursor]
): CUnsignedInt =
  __sn_wrap_libclang_clang_CXXConstructor_isConvertingConstructor(C)

def clang_CXXConstructor_isConvertingConstructor(C: CXCursor)(using
    Zone
): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXConstructor_isConvertingConstructor((__ptr_0 + 0))

def clang_CXXConstructor_isCopyConstructor(C: CXCursor)(using
    Zone
): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXConstructor_isCopyConstructor((__ptr_0 + 0))

def clang_CXXConstructor_isCopyConstructor(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_CXXConstructor_isCopyConstructor(C)

def clang_CXXConstructor_isDefaultConstructor(C: CXCursor)(using
    Zone
): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXConstructor_isDefaultConstructor((__ptr_0 + 0))

def clang_CXXConstructor_isDefaultConstructor(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_CXXConstructor_isDefaultConstructor(C)

def clang_CXXConstructor_isMoveConstructor(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_CXXConstructor_isMoveConstructor(C)

def clang_CXXConstructor_isMoveConstructor(C: CXCursor)(using
    Zone
): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXConstructor_isMoveConstructor((__ptr_0 + 0))

def clang_CXXField_isMutable(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXField_isMutable((__ptr_0 + 0))

def clang_CXXField_isMutable(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_CXXField_isMutable(C)

def clang_CXXMethod_isConst(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_CXXMethod_isConst(C)

def clang_CXXMethod_isConst(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXMethod_isConst((__ptr_0 + 0))

def clang_CXXMethod_isDefaulted(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_CXXMethod_isDefaulted(C)

def clang_CXXMethod_isDefaulted(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXMethod_isDefaulted((__ptr_0 + 0))

def clang_CXXMethod_isPureVirtual(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_CXXMethod_isPureVirtual(C)

def clang_CXXMethod_isPureVirtual(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXMethod_isPureVirtual((__ptr_0 + 0))

def clang_CXXMethod_isStatic(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_CXXMethod_isStatic(C)

def clang_CXXMethod_isStatic(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXMethod_isStatic((__ptr_0 + 0))

def clang_CXXMethod_isVirtual(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_CXXMethod_isVirtual(C)

def clang_CXXMethod_isVirtual(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXMethod_isVirtual((__ptr_0 + 0))

def clang_CXXRecord_isAbstract(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXRecord_isAbstract((__ptr_0 + 0))

def clang_CXXRecord_isAbstract(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_CXXRecord_isAbstract(C)

def clang_Cursor_Evaluate(C: CXCursor)(using Zone): CXEvalResult =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_Evaluate((__ptr_0 + 0))

def clang_Cursor_Evaluate(C: Ptr[CXCursor]): CXEvalResult =
  __sn_wrap_libclang_clang_Cursor_Evaluate(C)

def clang_Cursor_getArgument(C: CXCursor, i: CUnsignedInt)(using
    Zone
): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getArgument((__ptr_0 + 0), i, (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_Cursor_getArgument(C: Ptr[CXCursor], i: CUnsignedInt)(using
    Zone
): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_Cursor_getArgument(C, i, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Cursor_getArgument(C: Ptr[CXCursor], i: CUnsignedInt)(
    __return: Ptr[CXCursor]
): Unit =
  __sn_wrap_libclang_clang_Cursor_getArgument(C, i, __return)

def clang_Cursor_getBriefCommentText(C: CXCursor)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getBriefCommentText(
    (__ptr_1 + 0),
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_Cursor_getBriefCommentText

def clang_Cursor_getBriefCommentText(C: Ptr[CXCursor])(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Cursor_getBriefCommentText(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Cursor_getBriefCommentText(C: Ptr[CXCursor])(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_Cursor_getBriefCommentText(C, __return)

def clang_Cursor_getCXXManglings(_0: CXCursor)(using Zone): Ptr[CXStringSet] =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_Cursor_getCXXManglings((__ptr_0 + 0))

def clang_Cursor_getCXXManglings(_0: Ptr[CXCursor]): Ptr[CXStringSet] =
  __sn_wrap_libclang_clang_Cursor_getCXXManglings(_0)

def clang_Cursor_getCommentRange(C: CXCursor)(using Zone): CXSourceRange =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getCommentRange((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Cursor_getCommentRange(C: Ptr[CXCursor])(
    __return: Ptr[CXSourceRange]
): Unit =
  __sn_wrap_libclang_clang_Cursor_getCommentRange(C, __return)

def clang_Cursor_getCommentRange(C: Ptr[CXCursor])(using Zone): CXSourceRange =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_Cursor_getCommentRange(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Cursor_getMangling(_0: Ptr[CXCursor])(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_Cursor_getMangling(_0, __return)

def clang_Cursor_getMangling(_0: CXCursor)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = _0
  __sn_wrap_libclang_clang_Cursor_getMangling((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Cursor_getMangling(_0: Ptr[CXCursor])(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Cursor_getMangling(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Cursor_getModule(C: Ptr[CXCursor]): CXModule =
  __sn_wrap_libclang_clang_Cursor_getModule(C)

def clang_Cursor_getModule(C: CXCursor)(using Zone): CXModule =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getModule((__ptr_0 + 0))

def clang_Cursor_getNumArguments(C: CXCursor)(using Zone): CInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getNumArguments((__ptr_0 + 0))

def clang_Cursor_getNumArguments(C: Ptr[CXCursor]): CInt =
  __sn_wrap_libclang_clang_Cursor_getNumArguments(C)

def clang_Cursor_getNumTemplateArguments(C: Ptr[CXCursor]): CInt =
  __sn_wrap_libclang_clang_Cursor_getNumTemplateArguments(C)

def clang_Cursor_getNumTemplateArguments(C: CXCursor)(using Zone): CInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getNumTemplateArguments((__ptr_0 + 0))

def clang_Cursor_getObjCDeclQualifiers(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getObjCDeclQualifiers((__ptr_0 + 0))

def clang_Cursor_getObjCDeclQualifiers(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_Cursor_getObjCDeclQualifiers(C)

def clang_Cursor_getObjCManglings(_0: CXCursor)(using Zone): Ptr[CXStringSet] =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_Cursor_getObjCManglings((__ptr_0 + 0))

def clang_Cursor_getObjCManglings(_0: Ptr[CXCursor]): Ptr[CXStringSet] =
  __sn_wrap_libclang_clang_Cursor_getObjCManglings(_0)

def clang_Cursor_getObjCPropertyAttributes(C: CXCursor, reserved: CUnsignedInt)(
    using Zone
): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getObjCPropertyAttributes(
    (__ptr_0 + 0),
    reserved
  )
end clang_Cursor_getObjCPropertyAttributes

def clang_Cursor_getObjCPropertyAttributes(
    C: Ptr[CXCursor],
    reserved: CUnsignedInt
): CUnsignedInt =
  __sn_wrap_libclang_clang_Cursor_getObjCPropertyAttributes(C, reserved)

def clang_Cursor_getObjCPropertyGetterName(C: CXCursor)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getObjCPropertyGetterName(
    (__ptr_1 + 0),
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_Cursor_getObjCPropertyGetterName

def clang_Cursor_getObjCPropertyGetterName(C: Ptr[CXCursor])(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_Cursor_getObjCPropertyGetterName(C, __return)

def clang_Cursor_getObjCPropertyGetterName(C: Ptr[CXCursor])(using
    Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Cursor_getObjCPropertyGetterName(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Cursor_getObjCPropertySetterName(C: CXCursor)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getObjCPropertySetterName(
    (__ptr_1 + 0),
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_Cursor_getObjCPropertySetterName

def clang_Cursor_getObjCPropertySetterName(C: Ptr[CXCursor])(using
    Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Cursor_getObjCPropertySetterName(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Cursor_getObjCPropertySetterName(C: Ptr[CXCursor])(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_Cursor_getObjCPropertySetterName(C, __return)

def clang_Cursor_getObjCSelectorIndex(_0: Ptr[CXCursor]): CInt =
  __sn_wrap_libclang_clang_Cursor_getObjCSelectorIndex(_0)

def clang_Cursor_getObjCSelectorIndex(_0: CXCursor)(using Zone): CInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_Cursor_getObjCSelectorIndex((__ptr_0 + 0))

def clang_Cursor_getOffsetOfField(C: CXCursor)(using Zone): CLongLong =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getOffsetOfField((__ptr_0 + 0))

def clang_Cursor_getOffsetOfField(C: Ptr[CXCursor]): CLongLong =
  __sn_wrap_libclang_clang_Cursor_getOffsetOfField(C)

def clang_Cursor_getRawCommentText(C: Ptr[CXCursor])(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_Cursor_getRawCommentText(C, __return)

def clang_Cursor_getRawCommentText(C: CXCursor)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getRawCommentText(
    (__ptr_1 + 0),
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_Cursor_getRawCommentText

def clang_Cursor_getRawCommentText(C: Ptr[CXCursor])(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Cursor_getRawCommentText(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Cursor_getReceiverType(C: CXCursor)(using Zone): CXType =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getReceiverType((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

def clang_Cursor_getReceiverType(C: Ptr[CXCursor])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Cursor_getReceiverType(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Cursor_getReceiverType(C: Ptr[CXCursor])(
    __return: Ptr[CXType]
): Unit =
  __sn_wrap_libclang_clang_Cursor_getReceiverType(C, __return)

def clang_Cursor_getSpellingNameRange(
    _0: Ptr[CXCursor],
    pieceIndex: CUnsignedInt,
    options: CUnsignedInt
)(using Zone): CXSourceRange =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_Cursor_getSpellingNameRange(
    _0,
    pieceIndex,
    options,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_Cursor_getSpellingNameRange

def clang_Cursor_getSpellingNameRange(
    _0: CXCursor,
    pieceIndex: CUnsignedInt,
    options: CUnsignedInt
)(using Zone): CXSourceRange =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = _0
  __sn_wrap_libclang_clang_Cursor_getSpellingNameRange(
    (__ptr_1 + 0),
    pieceIndex,
    options,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_Cursor_getSpellingNameRange

def clang_Cursor_getSpellingNameRange(
    _0: Ptr[CXCursor],
    pieceIndex: CUnsignedInt,
    options: CUnsignedInt
)(__return: Ptr[CXSourceRange]): Unit =
  __sn_wrap_libclang_clang_Cursor_getSpellingNameRange(
    _0,
    pieceIndex,
    options,
    __return
  )

def clang_Cursor_getStorageClass(_0: CXCursor)(using Zone): CX_StorageClass =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_Cursor_getStorageClass((__ptr_0 + 0))

def clang_Cursor_getStorageClass(_0: Ptr[CXCursor]): CX_StorageClass =
  __sn_wrap_libclang_clang_Cursor_getStorageClass(_0)

def clang_Cursor_getTemplateArgumentKind(
    C: Ptr[CXCursor],
    I: CUnsignedInt
): CXTemplateArgumentKind =
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentKind(C, I)

def clang_Cursor_getTemplateArgumentKind(C: CXCursor, I: CUnsignedInt)(using
    Zone
): CXTemplateArgumentKind =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentKind((__ptr_0 + 0), I)

def clang_Cursor_getTemplateArgumentType(C: Ptr[CXCursor], I: CUnsignedInt)(
    using Zone
): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentType(C, I, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Cursor_getTemplateArgumentType(C: CXCursor, I: CUnsignedInt)(using
    Zone
): CXType =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentType(
    (__ptr_0 + 0),
    I,
    (__ptr_1 + 0)
  )
  !(__ptr_1 + 0)
end clang_Cursor_getTemplateArgumentType

def clang_Cursor_getTemplateArgumentType(C: Ptr[CXCursor], I: CUnsignedInt)(
    __return: Ptr[CXType]
): Unit =
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentType(C, I, __return)

def clang_Cursor_getTemplateArgumentUnsignedValue(
    C: Ptr[CXCursor],
    I: CUnsignedInt
): CUnsignedLongLong =
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentUnsignedValue(C, I)

def clang_Cursor_getTemplateArgumentUnsignedValue(C: CXCursor, I: CUnsignedInt)(
    using Zone
): CUnsignedLongLong =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentUnsignedValue(
    (__ptr_0 + 0),
    I
  )
end clang_Cursor_getTemplateArgumentUnsignedValue

def clang_Cursor_getTemplateArgumentValue(
    C: Ptr[CXCursor],
    I: CUnsignedInt
): CLongLong =
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentValue(C, I)

def clang_Cursor_getTemplateArgumentValue(C: CXCursor, I: CUnsignedInt)(using
    Zone
): CLongLong =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentValue((__ptr_0 + 0), I)

def clang_Cursor_getTranslationUnit(_0: CXCursor)(using
    Zone
): CXTranslationUnit =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_Cursor_getTranslationUnit((__ptr_0 + 0))

def clang_Cursor_getTranslationUnit(_0: Ptr[CXCursor]): CXTranslationUnit =
  __sn_wrap_libclang_clang_Cursor_getTranslationUnit(_0)

def clang_Cursor_getVarDeclInitializer(cursor: Ptr[CXCursor])(using
    Zone
): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_Cursor_getVarDeclInitializer(cursor, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Cursor_getVarDeclInitializer(cursor: Ptr[CXCursor])(
    __return: Ptr[CXCursor]
): Unit =
  __sn_wrap_libclang_clang_Cursor_getVarDeclInitializer(cursor, __return)

def clang_Cursor_getVarDeclInitializer(cursor: CXCursor)(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_Cursor_getVarDeclInitializer(
    (__ptr_0 + 0),
    (__ptr_0 + 1)
  )
  !(__ptr_0 + 1)

def clang_Cursor_hasAttrs(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_Cursor_hasAttrs(C)

def clang_Cursor_hasAttrs(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_hasAttrs((__ptr_0 + 0))

def clang_Cursor_hasVarDeclExternalStorage(cursor: CXCursor)(using Zone): CInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_Cursor_hasVarDeclExternalStorage((__ptr_0 + 0))

def clang_Cursor_hasVarDeclExternalStorage(cursor: Ptr[CXCursor]): CInt =
  __sn_wrap_libclang_clang_Cursor_hasVarDeclExternalStorage(cursor)

def clang_Cursor_hasVarDeclGlobalStorage(cursor: Ptr[CXCursor]): CInt =
  __sn_wrap_libclang_clang_Cursor_hasVarDeclGlobalStorage(cursor)

def clang_Cursor_hasVarDeclGlobalStorage(cursor: CXCursor)(using Zone): CInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_Cursor_hasVarDeclGlobalStorage((__ptr_0 + 0))

def clang_Cursor_isAnonymous(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isAnonymous((__ptr_0 + 0))

def clang_Cursor_isAnonymous(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_Cursor_isAnonymous(C)

def clang_Cursor_isAnonymousRecordDecl(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isAnonymousRecordDecl((__ptr_0 + 0))

def clang_Cursor_isAnonymousRecordDecl(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_Cursor_isAnonymousRecordDecl(C)

def clang_Cursor_isBitField(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_Cursor_isBitField(C)

def clang_Cursor_isBitField(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isBitField((__ptr_0 + 0))

def clang_Cursor_isDynamicCall(C: Ptr[CXCursor]): CInt =
  __sn_wrap_libclang_clang_Cursor_isDynamicCall(C)

def clang_Cursor_isDynamicCall(C: CXCursor)(using Zone): CInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isDynamicCall((__ptr_0 + 0))

def clang_Cursor_isExternalSymbol(
    C: Ptr[CXCursor],
    language: Ptr[CXString],
    definedIn: Ptr[CXString],
    isGenerated: Ptr[CUnsignedInt]
): CUnsignedInt =
  __sn_wrap_libclang_clang_Cursor_isExternalSymbol(
    C,
    language,
    definedIn,
    isGenerated
  )

def clang_Cursor_isExternalSymbol(
    C: CXCursor,
    language: Ptr[CXString],
    definedIn: Ptr[CXString],
    isGenerated: Ptr[CUnsignedInt]
)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isExternalSymbol(
    (__ptr_0 + 0),
    language,
    definedIn,
    isGenerated
  )
end clang_Cursor_isExternalSymbol

def clang_Cursor_isFunctionInlined(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isFunctionInlined((__ptr_0 + 0))

def clang_Cursor_isFunctionInlined(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_Cursor_isFunctionInlined(C)

def clang_Cursor_isInlineNamespace(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_Cursor_isInlineNamespace(C)

def clang_Cursor_isInlineNamespace(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isInlineNamespace((__ptr_0 + 0))

def clang_Cursor_isMacroBuiltin(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isMacroBuiltin((__ptr_0 + 0))

def clang_Cursor_isMacroBuiltin(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_Cursor_isMacroBuiltin(C)

def clang_Cursor_isMacroFunctionLike(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_Cursor_isMacroFunctionLike(C)

def clang_Cursor_isMacroFunctionLike(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isMacroFunctionLike((__ptr_0 + 0))

def clang_Cursor_isNull(cursor: CXCursor)(using Zone): CInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_Cursor_isNull((__ptr_0 + 0))

def clang_Cursor_isNull(cursor: Ptr[CXCursor]): CInt =
  __sn_wrap_libclang_clang_Cursor_isNull(cursor)

def clang_Cursor_isObjCOptional(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_Cursor_isObjCOptional(C)

def clang_Cursor_isObjCOptional(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isObjCOptional((__ptr_0 + 0))

def clang_Cursor_isVariadic(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isVariadic((__ptr_0 + 0))

def clang_Cursor_isVariadic(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_Cursor_isVariadic(C)

def clang_EnumDecl_isScoped(C: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_EnumDecl_isScoped(C)

def clang_EnumDecl_isScoped(C: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_EnumDecl_isScoped((__ptr_0 + 0))

def clang_File_tryGetRealPathName(file: CXFile)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_File_tryGetRealPathName(file, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_File_tryGetRealPathName(file: CXFile)(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_File_tryGetRealPathName(file, __return)

def clang_Location_isFromMainFile(location: CXSourceLocation)(using
    Zone
): CInt =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = location
  __sn_wrap_libclang_clang_Location_isFromMainFile((__ptr_0 + 0))

def clang_Location_isFromMainFile(location: Ptr[CXSourceLocation]): CInt =
  __sn_wrap_libclang_clang_Location_isFromMainFile(location)

def clang_Location_isInSystemHeader(location: Ptr[CXSourceLocation]): CInt =
  __sn_wrap_libclang_clang_Location_isInSystemHeader(location)

def clang_Location_isInSystemHeader(location: CXSourceLocation)(using
    Zone
): CInt =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = location
  __sn_wrap_libclang_clang_Location_isInSystemHeader((__ptr_0 + 0))

def clang_Module_getFullName(Module: CXModule)(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_Module_getFullName(Module, __return)

def clang_Module_getFullName(Module: CXModule)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Module_getFullName(Module, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Module_getName(Module: CXModule)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Module_getName(Module, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Module_getName(Module: CXModule)(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_Module_getName(Module, __return)

def clang_Range_isNull(range: Ptr[CXSourceRange]): CInt =
  __sn_wrap_libclang_clang_Range_isNull(range)

def clang_Range_isNull(range: CXSourceRange)(using Zone): CInt =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  !(__ptr_0 + 0) = range
  __sn_wrap_libclang_clang_Range_isNull((__ptr_0 + 0))

def clang_TargetInfo_getTriple(Info: CXTargetInfo)(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_TargetInfo_getTriple(Info, __return)

def clang_TargetInfo_getTriple(Info: CXTargetInfo)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_TargetInfo_getTriple(Info, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Type_getAlignOf(T: Ptr[CXType]): CLongLong =
  __sn_wrap_libclang_clang_Type_getAlignOf(T)

def clang_Type_getAlignOf(T: CXType)(using Zone): CLongLong =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getAlignOf((__ptr_0 + 0))

def clang_Type_getCXXRefQualifier(T: Ptr[CXType]): CXRefQualifierKind =
  __sn_wrap_libclang_clang_Type_getCXXRefQualifier(T)

def clang_Type_getCXXRefQualifier(T: CXType)(using Zone): CXRefQualifierKind =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getCXXRefQualifier((__ptr_0 + 0))

def clang_Type_getClassType(T: CXType)(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getClassType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_Type_getClassType(T: Ptr[CXType])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Type_getClassType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Type_getClassType(T: Ptr[CXType])(__return: Ptr[CXType]): Unit =
  __sn_wrap_libclang_clang_Type_getClassType(T, __return)

def clang_Type_getModifiedType(T: Ptr[CXType])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Type_getModifiedType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Type_getModifiedType(T: Ptr[CXType])(__return: Ptr[CXType]): Unit =
  __sn_wrap_libclang_clang_Type_getModifiedType(T, __return)

def clang_Type_getModifiedType(T: CXType)(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getModifiedType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_Type_getNamedType(T: CXType)(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getNamedType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_Type_getNamedType(T: Ptr[CXType])(__return: Ptr[CXType]): Unit =
  __sn_wrap_libclang_clang_Type_getNamedType(T, __return)

def clang_Type_getNamedType(T: Ptr[CXType])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Type_getNamedType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Type_getNullability(T: Ptr[CXType]): CXTypeNullabilityKind =
  __sn_wrap_libclang_clang_Type_getNullability(T)

def clang_Type_getNullability(T: CXType)(using Zone): CXTypeNullabilityKind =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getNullability((__ptr_0 + 0))

def clang_Type_getNumObjCProtocolRefs(T: Ptr[CXType]): CUnsignedInt =
  __sn_wrap_libclang_clang_Type_getNumObjCProtocolRefs(T)

def clang_Type_getNumObjCProtocolRefs(T: CXType)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getNumObjCProtocolRefs((__ptr_0 + 0))

def clang_Type_getNumObjCTypeArgs(T: CXType)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getNumObjCTypeArgs((__ptr_0 + 0))

def clang_Type_getNumObjCTypeArgs(T: Ptr[CXType]): CUnsignedInt =
  __sn_wrap_libclang_clang_Type_getNumObjCTypeArgs(T)

def clang_Type_getNumTemplateArguments(T: CXType)(using Zone): CInt =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getNumTemplateArguments((__ptr_0 + 0))

def clang_Type_getNumTemplateArguments(T: Ptr[CXType]): CInt =
  __sn_wrap_libclang_clang_Type_getNumTemplateArguments(T)

def clang_Type_getObjCEncoding(`type`: CXType)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  val __ptr_1: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_1 + 0) = `type`
  __sn_wrap_libclang_clang_Type_getObjCEncoding((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Type_getObjCEncoding(`type`: Ptr[CXType])(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Type_getObjCEncoding(`type`, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Type_getObjCEncoding(`type`: Ptr[CXType])(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_Type_getObjCEncoding(`type`, __return)

def clang_Type_getObjCObjectBaseType(T: Ptr[CXType])(
    __return: Ptr[CXType]
): Unit =
  __sn_wrap_libclang_clang_Type_getObjCObjectBaseType(T, __return)

def clang_Type_getObjCObjectBaseType(T: CXType)(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getObjCObjectBaseType(
    (__ptr_0 + 0),
    (__ptr_0 + 1)
  )
  !(__ptr_0 + 1)

def clang_Type_getObjCObjectBaseType(T: Ptr[CXType])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Type_getObjCObjectBaseType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Type_getObjCProtocolDecl(T: Ptr[CXType], i: CUnsignedInt)(
    __return: Ptr[CXCursor]
): Unit =
  __sn_wrap_libclang_clang_Type_getObjCProtocolDecl(T, i, __return)

def clang_Type_getObjCProtocolDecl(T: Ptr[CXType], i: CUnsignedInt)(using
    Zone
): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_Type_getObjCProtocolDecl(T, i, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Type_getObjCProtocolDecl(T: CXType, i: CUnsignedInt)(using
    Zone
): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_1 + 0) = T
  __sn_wrap_libclang_clang_Type_getObjCProtocolDecl(
    (__ptr_1 + 0),
    i,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_Type_getObjCProtocolDecl

def clang_Type_getObjCTypeArg(T: Ptr[CXType], i: CUnsignedInt)(using
    Zone
): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Type_getObjCTypeArg(T, i, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Type_getObjCTypeArg(T: Ptr[CXType], i: CUnsignedInt)(
    __return: Ptr[CXType]
): Unit =
  __sn_wrap_libclang_clang_Type_getObjCTypeArg(T, i, __return)

def clang_Type_getObjCTypeArg(T: CXType, i: CUnsignedInt)(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getObjCTypeArg((__ptr_0 + 0), i, (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_Type_getOffsetOf(T: CXType, S: CString)(using Zone): CLongLong =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getOffsetOf((__ptr_0 + 0), S)

def clang_Type_getOffsetOf(T: Ptr[CXType], S: CString): CLongLong =
  __sn_wrap_libclang_clang_Type_getOffsetOf(T, S)

def clang_Type_getSizeOf(T: Ptr[CXType]): CLongLong =
  __sn_wrap_libclang_clang_Type_getSizeOf(T)

def clang_Type_getSizeOf(T: CXType)(using Zone): CLongLong =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getSizeOf((__ptr_0 + 0))

def clang_Type_getTemplateArgumentAsType(T: CXType, i: CUnsignedInt)(using
    Zone
): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getTemplateArgumentAsType(
    (__ptr_0 + 0),
    i,
    (__ptr_0 + 1)
  )
  !(__ptr_0 + 1)
end clang_Type_getTemplateArgumentAsType

def clang_Type_getTemplateArgumentAsType(T: Ptr[CXType], i: CUnsignedInt)(
    __return: Ptr[CXType]
): Unit =
  __sn_wrap_libclang_clang_Type_getTemplateArgumentAsType(T, i, __return)

def clang_Type_getTemplateArgumentAsType(T: Ptr[CXType], i: CUnsignedInt)(using
    Zone
): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Type_getTemplateArgumentAsType(T, i, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Type_getValueType(CT: Ptr[CXType])(__return: Ptr[CXType]): Unit =
  __sn_wrap_libclang_clang_Type_getValueType(CT, __return)

def clang_Type_getValueType(CT: Ptr[CXType])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Type_getValueType(CT, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_Type_getValueType(CT: CXType)(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = CT
  __sn_wrap_libclang_clang_Type_getValueType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_Type_isTransparentTagTypedef(T: CXType)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_isTransparentTagTypedef((__ptr_0 + 0))

def clang_Type_isTransparentTagTypedef(T: Ptr[CXType]): CUnsignedInt =
  __sn_wrap_libclang_clang_Type_isTransparentTagTypedef(T)

def clang_Type_visitFields(
    T: CXType,
    visitor: CXFieldVisitor,
    client_data: CXClientData
)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_visitFields((__ptr_0 + 0), visitor, client_data)

def clang_Type_visitFields(
    T: Ptr[CXType],
    visitor: CXFieldVisitor,
    client_data: CXClientData
): CUnsignedInt =
  __sn_wrap_libclang_clang_Type_visitFields(T, visitor, client_data)

def clang_codeCompleteGetContainerUSR(Results: Ptr[CXCodeCompleteResults])(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_codeCompleteGetContainerUSR(Results, __return)

def clang_codeCompleteGetContainerUSR(Results: Ptr[CXCodeCompleteResults])(using
    Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_codeCompleteGetContainerUSR(Results, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_codeCompleteGetObjCSelector(Results: Ptr[CXCodeCompleteResults])(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_codeCompleteGetObjCSelector(Results, __return)

def clang_codeCompleteGetObjCSelector(Results: Ptr[CXCodeCompleteResults])(using
    Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_codeCompleteGetObjCSelector(Results, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_constructUSR_ObjCCategory(
    class_name: CString,
    category_name: CString
)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_constructUSR_ObjCCategory(
    class_name,
    category_name,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_constructUSR_ObjCCategory

def clang_constructUSR_ObjCCategory(
    class_name: CString,
    category_name: CString
)(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_constructUSR_ObjCCategory(
    class_name,
    category_name,
    __return
  )

def clang_constructUSR_ObjCClass(class_name: CString)(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_constructUSR_ObjCClass(class_name, __return)

def clang_constructUSR_ObjCClass(class_name: CString)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_constructUSR_ObjCClass(class_name, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_constructUSR_ObjCIvar(name: CString, classUSR: Ptr[CXString])(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_constructUSR_ObjCIvar(name, classUSR, __return)

def clang_constructUSR_ObjCIvar(name: CString, classUSR: Ptr[CXString])(using
    Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_constructUSR_ObjCIvar(name, classUSR, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_constructUSR_ObjCIvar(name: CString, classUSR: CXString)(using
    Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](2)
  !(__ptr_0 + 0) = classUSR
  __sn_wrap_libclang_clang_constructUSR_ObjCIvar(
    name,
    (__ptr_0 + 0),
    (__ptr_0 + 1)
  )
  !(__ptr_0 + 1)
end clang_constructUSR_ObjCIvar

def clang_constructUSR_ObjCMethod(
    name: CString,
    isInstanceMethod: CUnsignedInt,
    classUSR: Ptr[CXString]
)(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_constructUSR_ObjCMethod(
    name,
    isInstanceMethod,
    classUSR,
    __return
  )

def clang_constructUSR_ObjCMethod(
    name: CString,
    isInstanceMethod: CUnsignedInt,
    classUSR: Ptr[CXString]
)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_constructUSR_ObjCMethod(
    name,
    isInstanceMethod,
    classUSR,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_constructUSR_ObjCMethod

def clang_constructUSR_ObjCMethod(
    name: CString,
    isInstanceMethod: CUnsignedInt,
    classUSR: CXString
)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](2)
  !(__ptr_0 + 0) = classUSR
  __sn_wrap_libclang_clang_constructUSR_ObjCMethod(
    name,
    isInstanceMethod,
    (__ptr_0 + 0),
    (__ptr_0 + 1)
  )
  !(__ptr_0 + 1)
end clang_constructUSR_ObjCMethod

def clang_constructUSR_ObjCProperty(property: CString, classUSR: Ptr[CXString])(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_constructUSR_ObjCProperty(
    property,
    classUSR,
    __return
  )

def clang_constructUSR_ObjCProperty(property: CString, classUSR: Ptr[CXString])(
    using Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_constructUSR_ObjCProperty(
    property,
    classUSR,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_constructUSR_ObjCProperty

def clang_constructUSR_ObjCProperty(property: CString, classUSR: CXString)(using
    Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](2)
  !(__ptr_0 + 0) = classUSR
  __sn_wrap_libclang_clang_constructUSR_ObjCProperty(
    property,
    (__ptr_0 + 0),
    (__ptr_0 + 1)
  )
  !(__ptr_0 + 1)
end clang_constructUSR_ObjCProperty

def clang_constructUSR_ObjCProtocol(protocol_name: CString)(using
    Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_constructUSR_ObjCProtocol(
    protocol_name,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_constructUSR_ObjCProtocol

def clang_constructUSR_ObjCProtocol(protocol_name: CString)(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_constructUSR_ObjCProtocol(protocol_name, __return)

def clang_disposeCXTUResourceUsage(usage: Ptr[CXTUResourceUsage]): Unit =
  __sn_wrap_libclang_clang_disposeCXTUResourceUsage(usage)

def clang_disposeCXTUResourceUsage(usage: CXTUResourceUsage)(using Zone): Unit =
  val __ptr_0: Ptr[CXTUResourceUsage] = alloc[CXTUResourceUsage](1)
  !(__ptr_0 + 0) = usage
  __sn_wrap_libclang_clang_disposeCXTUResourceUsage((__ptr_0 + 0))

def clang_disposeString(string: CXString)(using Zone): Unit =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = string
  __sn_wrap_libclang_clang_disposeString((__ptr_0 + 0))

def clang_disposeString(string: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_disposeString(string)

def clang_equalCursors(_0: Ptr[CXCursor], _1: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_equalCursors(_0, _1)

def clang_equalCursors(_0: CXCursor, _1: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = _0
  !(__ptr_0 + 1) = _1
  __sn_wrap_libclang_clang_equalCursors((__ptr_0 + 0), (__ptr_0 + 1))

def clang_equalLocations(loc1: CXSourceLocation, loc2: CXSourceLocation)(using
    Zone
): CUnsignedInt =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](2)
  !(__ptr_0 + 0) = loc1
  !(__ptr_0 + 1) = loc2
  __sn_wrap_libclang_clang_equalLocations((__ptr_0 + 0), (__ptr_0 + 1))

def clang_equalLocations(
    loc1: Ptr[CXSourceLocation],
    loc2: Ptr[CXSourceLocation]
): CUnsignedInt =
  __sn_wrap_libclang_clang_equalLocations(loc1, loc2)

def clang_equalRanges(
    range1: Ptr[CXSourceRange],
    range2: Ptr[CXSourceRange]
): CUnsignedInt =
  __sn_wrap_libclang_clang_equalRanges(range1, range2)

def clang_equalRanges(range1: CXSourceRange, range2: CXSourceRange)(using
    Zone
): CUnsignedInt =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](2)
  !(__ptr_0 + 0) = range1
  !(__ptr_0 + 1) = range2
  __sn_wrap_libclang_clang_equalRanges((__ptr_0 + 0), (__ptr_0 + 1))

def clang_equalTypes(A: CXType, B: CXType)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = A
  !(__ptr_0 + 1) = B
  __sn_wrap_libclang_clang_equalTypes((__ptr_0 + 0), (__ptr_0 + 1))

def clang_equalTypes(A: Ptr[CXType], B: Ptr[CXType]): CUnsignedInt =
  __sn_wrap_libclang_clang_equalTypes(A, B)

def clang_findIncludesInFile(
    TU: CXTranslationUnit,
    file: CXFile,
    visitor: CXCursorAndRangeVisitor
)(using Zone): CXResult =
  val __ptr_0: Ptr[CXCursorAndRangeVisitor] = alloc[CXCursorAndRangeVisitor](1)
  !(__ptr_0 + 0) = visitor
  __sn_wrap_libclang_clang_findIncludesInFile(TU, file, (__ptr_0 + 0))

def clang_findIncludesInFile(
    TU: CXTranslationUnit,
    file: CXFile,
    visitor: Ptr[CXCursorAndRangeVisitor]
): CXResult =
  __sn_wrap_libclang_clang_findIncludesInFile(TU, file, visitor)

def clang_findReferencesInFile(
    cursor: Ptr[CXCursor],
    file: CXFile,
    visitor: Ptr[CXCursorAndRangeVisitor]
): CXResult =
  __sn_wrap_libclang_clang_findReferencesInFile(cursor, file, visitor)

def clang_findReferencesInFile(
    cursor: CXCursor,
    file: CXFile,
    visitor: CXCursorAndRangeVisitor
)(using Zone): CXResult =
  val __ptr_0: Ptr[CXCursorAndRangeVisitor] = alloc[CXCursorAndRangeVisitor](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = cursor
  !(__ptr_0 + 0) = visitor
  __sn_wrap_libclang_clang_findReferencesInFile(
    (__ptr_1 + 0),
    file,
    (__ptr_0 + 0)
  )
end clang_findReferencesInFile

def clang_formatDiagnostic(Diagnostic: CXDiagnostic, Options: CUnsignedInt)(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_formatDiagnostic(Diagnostic, Options, __return)

def clang_formatDiagnostic(Diagnostic: CXDiagnostic, Options: CUnsignedInt)(
    using Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_formatDiagnostic(Diagnostic, Options, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getAddressSpace(T: Ptr[CXType]): CUnsignedInt =
  __sn_wrap_libclang_clang_getAddressSpace(T)

def clang_getAddressSpace(T: CXType)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getAddressSpace((__ptr_0 + 0))

def clang_getArgType(T: Ptr[CXType], i: CUnsignedInt)(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getArgType(T, i, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getArgType(T: CXType, i: CUnsignedInt)(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getArgType((__ptr_0 + 0), i, (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_getArgType(T: Ptr[CXType], i: CUnsignedInt)(
    __return: Ptr[CXType]
): Unit =
  __sn_wrap_libclang_clang_getArgType(T, i, __return)

def clang_getArrayElementType(T: Ptr[CXType])(__return: Ptr[CXType]): Unit =
  __sn_wrap_libclang_clang_getArrayElementType(T, __return)

def clang_getArrayElementType(T: Ptr[CXType])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getArrayElementType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getArrayElementType(T: CXType)(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getArrayElementType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_getArraySize(T: CXType)(using Zone): CLongLong =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getArraySize((__ptr_0 + 0))

def clang_getArraySize(T: Ptr[CXType]): CLongLong =
  __sn_wrap_libclang_clang_getArraySize(T)

def clang_getCString(string: CXString)(using Zone): CString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = string
  __sn_wrap_libclang_clang_getCString((__ptr_0 + 0))

def clang_getCString(string: Ptr[CXString]): CString =
  __sn_wrap_libclang_clang_getCString(string)

def clang_getCXTUResourceUsage(TU: CXTranslationUnit)(
    __return: Ptr[CXTUResourceUsage]
): Unit =
  __sn_wrap_libclang_clang_getCXTUResourceUsage(TU, __return)

def clang_getCXTUResourceUsage(TU: CXTranslationUnit)(using
    Zone
): CXTUResourceUsage =
  val __ptr_0: Ptr[CXTUResourceUsage] = alloc[CXTUResourceUsage](1)
  __sn_wrap_libclang_clang_getCXTUResourceUsage(TU, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCXXAccessSpecifier(_0: Ptr[CXCursor]): CX_CXXAccessSpecifier =
  __sn_wrap_libclang_clang_getCXXAccessSpecifier(_0)

def clang_getCXXAccessSpecifier(_0: CXCursor)(using
    Zone
): CX_CXXAccessSpecifier =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCXXAccessSpecifier((__ptr_0 + 0))

def clang_getCanonicalCursor(_0: Ptr[CXCursor])(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getCanonicalCursor(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCanonicalCursor(_0: Ptr[CXCursor])(__return: Ptr[CXCursor]): Unit =
  __sn_wrap_libclang_clang_getCanonicalCursor(_0, __return)

def clang_getCanonicalCursor(_0: CXCursor)(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCanonicalCursor((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_getCanonicalType(T: Ptr[CXType])(__return: Ptr[CXType]): Unit =
  __sn_wrap_libclang_clang_getCanonicalType(T, __return)

def clang_getCanonicalType(T: CXType)(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getCanonicalType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_getCanonicalType(T: Ptr[CXType])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getCanonicalType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getClangVersion()(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_getClangVersion(__return)

def clang_getClangVersion()(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getClangVersion((__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCompletionAnnotation(
    completion_string: CXCompletionString,
    annotation_number: CUnsignedInt
)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCompletionAnnotation(
    completion_string,
    annotation_number,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_getCompletionAnnotation

def clang_getCompletionAnnotation(
    completion_string: CXCompletionString,
    annotation_number: CUnsignedInt
)(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_getCompletionAnnotation(
    completion_string,
    annotation_number,
    __return
  )

def clang_getCompletionBriefComment(completion_string: CXCompletionString)(using
    Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCompletionBriefComment(
    completion_string,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_getCompletionBriefComment

def clang_getCompletionBriefComment(
    completion_string: CXCompletionString
)(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_getCompletionBriefComment(
    completion_string,
    __return
  )

def clang_getCompletionChunkText(
    completion_string: CXCompletionString,
    chunk_number: CUnsignedInt
)(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_getCompletionChunkText(
    completion_string,
    chunk_number,
    __return
  )

def clang_getCompletionChunkText(
    completion_string: CXCompletionString,
    chunk_number: CUnsignedInt
)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCompletionChunkText(
    completion_string,
    chunk_number,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_getCompletionChunkText

def clang_getCompletionFixIt(
    results: Ptr[CXCodeCompleteResults],
    completion_index: CUnsignedInt,
    fixit_index: CUnsignedInt,
    replacement_range: Ptr[CXSourceRange]
)(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_getCompletionFixIt(
    results,
    completion_index,
    fixit_index,
    replacement_range,
    __return
  )

def clang_getCompletionFixIt(
    results: Ptr[CXCodeCompleteResults],
    completion_index: CUnsignedInt,
    fixit_index: CUnsignedInt,
    replacement_range: Ptr[CXSourceRange]
)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCompletionFixIt(
    results,
    completion_index,
    fixit_index,
    replacement_range,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_getCompletionFixIt

def clang_getCompletionParent(
    completion_string: CXCompletionString,
    kind: Ptr[CXCursorKind]
)(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_getCompletionParent(
    completion_string,
    kind,
    __return
  )

def clang_getCompletionParent(
    completion_string: CXCompletionString,
    kind: Ptr[CXCursorKind]
)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCompletionParent(
    completion_string,
    kind,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_getCompletionParent

def clang_getCursor(_0: CXTranslationUnit, _1: Ptr[CXSourceLocation])(using
    Zone
): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getCursor(_0, _1, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursor(_0: CXTranslationUnit, _1: CXSourceLocation)(using
    Zone
): CXCursor =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _1
  __sn_wrap_libclang_clang_getCursor(_0, (__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

def clang_getCursor(_0: CXTranslationUnit, _1: Ptr[CXSourceLocation])(
    __return: Ptr[CXCursor]
): Unit =
  __sn_wrap_libclang_clang_getCursor(_0, _1, __return)

def clang_getCursorAvailability(cursor: Ptr[CXCursor]): CXAvailabilityKind =
  __sn_wrap_libclang_clang_getCursorAvailability(cursor)

def clang_getCursorAvailability(cursor: CXCursor)(using
    Zone
): CXAvailabilityKind =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorAvailability((__ptr_0 + 0))

def clang_getCursorCompletionString(cursor: CXCursor)(using
    Zone
): CXCompletionString =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorCompletionString((__ptr_0 + 0))

def clang_getCursorCompletionString(cursor: Ptr[CXCursor]): CXCompletionString =
  __sn_wrap_libclang_clang_getCursorCompletionString(cursor)

def clang_getCursorDefinition(_0: Ptr[CXCursor])(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getCursorDefinition(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorDefinition(_0: Ptr[CXCursor])(
    __return: Ptr[CXCursor]
): Unit =
  __sn_wrap_libclang_clang_getCursorDefinition(_0, __return)

def clang_getCursorDefinition(_0: CXCursor)(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCursorDefinition((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_getCursorDisplayName(_0: Ptr[CXCursor])(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_getCursorDisplayName(_0, __return)

def clang_getCursorDisplayName(_0: CXCursor)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = _0
  __sn_wrap_libclang_clang_getCursorDisplayName((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorDisplayName(_0: Ptr[CXCursor])(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCursorDisplayName(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorExceptionSpecificationType(C: Ptr[CXCursor]): CInt =
  __sn_wrap_libclang_clang_getCursorExceptionSpecificationType(C)

def clang_getCursorExceptionSpecificationType(C: CXCursor)(using Zone): CInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getCursorExceptionSpecificationType((__ptr_0 + 0))

def clang_getCursorExtent(_0: CXCursor)(using Zone): CXSourceRange =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = _0
  __sn_wrap_libclang_clang_getCursorExtent((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorExtent(_0: Ptr[CXCursor])(using Zone): CXSourceRange =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_getCursorExtent(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorExtent(_0: Ptr[CXCursor])(
    __return: Ptr[CXSourceRange]
): Unit =
  __sn_wrap_libclang_clang_getCursorExtent(_0, __return)

def clang_getCursorKind(_0: Ptr[CXCursor]): CXCursorKind =
  __sn_wrap_libclang_clang_getCursorKind(_0)

def clang_getCursorKind(_0: CXCursor)(using Zone): CXCursorKind =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCursorKind((__ptr_0 + 0))

def clang_getCursorKindSpelling(Kind: CXCursorKind)(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_getCursorKindSpelling(Kind, __return)

def clang_getCursorKindSpelling(Kind: CXCursorKind)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCursorKindSpelling(Kind, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorLanguage(cursor: Ptr[CXCursor]): CXLanguageKind =
  __sn_wrap_libclang_clang_getCursorLanguage(cursor)

def clang_getCursorLanguage(cursor: CXCursor)(using Zone): CXLanguageKind =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorLanguage((__ptr_0 + 0))

def clang_getCursorLexicalParent(cursor: Ptr[CXCursor])(
    __return: Ptr[CXCursor]
): Unit =
  __sn_wrap_libclang_clang_getCursorLexicalParent(cursor, __return)

def clang_getCursorLexicalParent(cursor: Ptr[CXCursor])(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getCursorLexicalParent(cursor, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorLexicalParent(cursor: CXCursor)(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorLexicalParent((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_getCursorLinkage(cursor: Ptr[CXCursor]): CXLinkageKind =
  __sn_wrap_libclang_clang_getCursorLinkage(cursor)

def clang_getCursorLinkage(cursor: CXCursor)(using Zone): CXLinkageKind =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorLinkage((__ptr_0 + 0))

def clang_getCursorLocation(_0: Ptr[CXCursor])(using Zone): CXSourceLocation =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getCursorLocation(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorLocation(_0: Ptr[CXCursor])(
    __return: Ptr[CXSourceLocation]
): Unit =
  __sn_wrap_libclang_clang_getCursorLocation(_0, __return)

def clang_getCursorLocation(_0: CXCursor)(using Zone): CXSourceLocation =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = _0
  __sn_wrap_libclang_clang_getCursorLocation((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorPlatformAvailability(
    cursor: Ptr[CXCursor],
    always_deprecated: Ptr[CInt],
    deprecated_message: Ptr[CXString],
    always_unavailable: Ptr[CInt],
    unavailable_message: Ptr[CXString],
    availability: Ptr[CXPlatformAvailability],
    availability_size: CInt
): CInt =
  __sn_wrap_libclang_clang_getCursorPlatformAvailability(
    cursor,
    always_deprecated,
    deprecated_message,
    always_unavailable,
    unavailable_message,
    availability,
    availability_size
  )

def clang_getCursorPlatformAvailability(
    cursor: CXCursor,
    always_deprecated: Ptr[CInt],
    deprecated_message: Ptr[CXString],
    always_unavailable: Ptr[CInt],
    unavailable_message: Ptr[CXString],
    availability: Ptr[CXPlatformAvailability],
    availability_size: CInt
)(using Zone): CInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorPlatformAvailability(
    (__ptr_0 + 0),
    always_deprecated,
    deprecated_message,
    always_unavailable,
    unavailable_message,
    availability,
    availability_size
  )
end clang_getCursorPlatformAvailability

def clang_getCursorPrettyPrinted(
    Cursor: Ptr[CXCursor],
    Policy: CXPrintingPolicy
)(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_getCursorPrettyPrinted(Cursor, Policy, __return)

def clang_getCursorPrettyPrinted(Cursor: CXCursor, Policy: CXPrintingPolicy)(
    using Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = Cursor
  __sn_wrap_libclang_clang_getCursorPrettyPrinted(
    (__ptr_1 + 0),
    Policy,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_getCursorPrettyPrinted

def clang_getCursorPrettyPrinted(
    Cursor: Ptr[CXCursor],
    Policy: CXPrintingPolicy
)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCursorPrettyPrinted(Cursor, Policy, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorPrintingPolicy(_0: CXCursor)(using Zone): CXPrintingPolicy =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCursorPrintingPolicy((__ptr_0 + 0))

def clang_getCursorPrintingPolicy(_0: Ptr[CXCursor]): CXPrintingPolicy =
  __sn_wrap_libclang_clang_getCursorPrintingPolicy(_0)

def clang_getCursorReferenceNameRange(
    C: Ptr[CXCursor],
    NameFlags: CUnsignedInt,
    PieceIndex: CUnsignedInt
)(using Zone): CXSourceRange =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_getCursorReferenceNameRange(
    C,
    NameFlags,
    PieceIndex,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_getCursorReferenceNameRange

def clang_getCursorReferenceNameRange(
    C: CXCursor,
    NameFlags: CUnsignedInt,
    PieceIndex: CUnsignedInt
)(using Zone): CXSourceRange =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_getCursorReferenceNameRange(
    (__ptr_1 + 0),
    NameFlags,
    PieceIndex,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_getCursorReferenceNameRange

def clang_getCursorReferenceNameRange(
    C: Ptr[CXCursor],
    NameFlags: CUnsignedInt,
    PieceIndex: CUnsignedInt
)(__return: Ptr[CXSourceRange]): Unit =
  __sn_wrap_libclang_clang_getCursorReferenceNameRange(
    C,
    NameFlags,
    PieceIndex,
    __return
  )

def clang_getCursorReferenced(_0: CXCursor)(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCursorReferenced((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_getCursorReferenced(_0: Ptr[CXCursor])(
    __return: Ptr[CXCursor]
): Unit =
  __sn_wrap_libclang_clang_getCursorReferenced(_0, __return)

def clang_getCursorReferenced(_0: Ptr[CXCursor])(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getCursorReferenced(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorResultType(C: CXCursor)(using Zone): CXType =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getCursorResultType((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

def clang_getCursorResultType(C: Ptr[CXCursor])(__return: Ptr[CXType]): Unit =
  __sn_wrap_libclang_clang_getCursorResultType(C, __return)

def clang_getCursorResultType(C: Ptr[CXCursor])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getCursorResultType(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorSemanticParent(cursor: Ptr[CXCursor])(
    __return: Ptr[CXCursor]
): Unit =
  __sn_wrap_libclang_clang_getCursorSemanticParent(cursor, __return)

def clang_getCursorSemanticParent(cursor: CXCursor)(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorSemanticParent((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_getCursorSemanticParent(cursor: Ptr[CXCursor])(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getCursorSemanticParent(cursor, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorSpelling(_0: Ptr[CXCursor])(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_getCursorSpelling(_0, __return)

def clang_getCursorSpelling(_0: Ptr[CXCursor])(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCursorSpelling(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorSpelling(_0: CXCursor)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = _0
  __sn_wrap_libclang_clang_getCursorSpelling((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorTLSKind(cursor: CXCursor)(using Zone): CXTLSKind =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorTLSKind((__ptr_0 + 0))

def clang_getCursorTLSKind(cursor: Ptr[CXCursor]): CXTLSKind =
  __sn_wrap_libclang_clang_getCursorTLSKind(cursor)

def clang_getCursorType(C: Ptr[CXCursor])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getCursorType(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorType(C: CXCursor)(using Zone): CXType =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getCursorType((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

def clang_getCursorType(C: Ptr[CXCursor])(__return: Ptr[CXType]): Unit =
  __sn_wrap_libclang_clang_getCursorType(C, __return)

def clang_getCursorUSR(_0: Ptr[CXCursor])(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCursorUSR(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorUSR(_0: CXCursor)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = _0
  __sn_wrap_libclang_clang_getCursorUSR((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getCursorUSR(_0: Ptr[CXCursor])(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_getCursorUSR(_0, __return)

def clang_getCursorVisibility(cursor: Ptr[CXCursor]): CXVisibilityKind =
  __sn_wrap_libclang_clang_getCursorVisibility(cursor)

def clang_getCursorVisibility(cursor: CXCursor)(using Zone): CXVisibilityKind =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorVisibility((__ptr_0 + 0))

def clang_getDeclObjCTypeEncoding(C: CXCursor)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_getDeclObjCTypeEncoding((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getDeclObjCTypeEncoding(C: Ptr[CXCursor])(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_getDeclObjCTypeEncoding(C, __return)

def clang_getDeclObjCTypeEncoding(C: Ptr[CXCursor])(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getDeclObjCTypeEncoding(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getDefinitionSpellingAndExtent(
    _0: Ptr[CXCursor],
    startBuf: Ptr[CString],
    endBuf: Ptr[CString],
    startLine: Ptr[CUnsignedInt],
    startColumn: Ptr[CUnsignedInt],
    endLine: Ptr[CUnsignedInt],
    endColumn: Ptr[CUnsignedInt]
): Unit =
  __sn_wrap_libclang_clang_getDefinitionSpellingAndExtent(
    _0,
    startBuf,
    endBuf,
    startLine,
    startColumn,
    endLine,
    endColumn
  )

def clang_getDefinitionSpellingAndExtent(
    _0: CXCursor,
    startBuf: Ptr[CString],
    endBuf: Ptr[CString],
    startLine: Ptr[CUnsignedInt],
    startColumn: Ptr[CUnsignedInt],
    endLine: Ptr[CUnsignedInt],
    endColumn: Ptr[CUnsignedInt]
)(using Zone): Unit =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getDefinitionSpellingAndExtent(
    (__ptr_0 + 0),
    startBuf,
    endBuf,
    startLine,
    startColumn,
    endLine,
    endColumn
  )
end clang_getDefinitionSpellingAndExtent

def clang_getDiagnosticCategoryName(Category: CUnsignedInt)(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_getDiagnosticCategoryName(Category, __return)

def clang_getDiagnosticCategoryName(Category: CUnsignedInt)(using
    Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getDiagnosticCategoryName(Category, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getDiagnosticCategoryText(_0: CXDiagnostic)(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_getDiagnosticCategoryText(_0, __return)

def clang_getDiagnosticCategoryText(_0: CXDiagnostic)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getDiagnosticCategoryText(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getDiagnosticFixIt(
    Diagnostic: CXDiagnostic,
    FixIt: CUnsignedInt,
    ReplacementRange: Ptr[CXSourceRange]
)(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_getDiagnosticFixIt(
    Diagnostic,
    FixIt,
    ReplacementRange,
    __return
  )

def clang_getDiagnosticFixIt(
    Diagnostic: CXDiagnostic,
    FixIt: CUnsignedInt,
    ReplacementRange: Ptr[CXSourceRange]
)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getDiagnosticFixIt(
    Diagnostic,
    FixIt,
    ReplacementRange,
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_getDiagnosticFixIt

def clang_getDiagnosticLocation(_0: CXDiagnostic)(using
    Zone
): CXSourceLocation =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getDiagnosticLocation(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getDiagnosticLocation(_0: CXDiagnostic)(
    __return: Ptr[CXSourceLocation]
): Unit =
  __sn_wrap_libclang_clang_getDiagnosticLocation(_0, __return)

def clang_getDiagnosticOption(Diag: CXDiagnostic, Disable: Ptr[CXString])(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_getDiagnosticOption(Diag, Disable, __return)

def clang_getDiagnosticOption(Diag: CXDiagnostic, Disable: Ptr[CXString])(using
    Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getDiagnosticOption(Diag, Disable, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getDiagnosticRange(Diagnostic: CXDiagnostic, Range: CUnsignedInt)(
    __return: Ptr[CXSourceRange]
): Unit =
  __sn_wrap_libclang_clang_getDiagnosticRange(Diagnostic, Range, __return)

def clang_getDiagnosticRange(Diagnostic: CXDiagnostic, Range: CUnsignedInt)(
    using Zone
): CXSourceRange =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_getDiagnosticRange(Diagnostic, Range, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getDiagnosticSpelling(_0: CXDiagnostic)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getDiagnosticSpelling(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getDiagnosticSpelling(_0: CXDiagnostic)(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_getDiagnosticSpelling(_0, __return)

def clang_getElementType(T: Ptr[CXType])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getElementType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getElementType(T: CXType)(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getElementType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_getElementType(T: Ptr[CXType])(__return: Ptr[CXType]): Unit =
  __sn_wrap_libclang_clang_getElementType(T, __return)

def clang_getEnumConstantDeclUnsignedValue(
    C: Ptr[CXCursor]
): CUnsignedLongLong =
  __sn_wrap_libclang_clang_getEnumConstantDeclUnsignedValue(C)

def clang_getEnumConstantDeclUnsignedValue(C: CXCursor)(using
    Zone
): CUnsignedLongLong =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getEnumConstantDeclUnsignedValue((__ptr_0 + 0))

def clang_getEnumConstantDeclValue(C: Ptr[CXCursor]): CLongLong =
  __sn_wrap_libclang_clang_getEnumConstantDeclValue(C)

def clang_getEnumConstantDeclValue(C: CXCursor)(using Zone): CLongLong =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getEnumConstantDeclValue((__ptr_0 + 0))

def clang_getEnumDeclIntegerType(C: CXCursor)(using Zone): CXType =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getEnumDeclIntegerType((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

def clang_getEnumDeclIntegerType(C: Ptr[CXCursor])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getEnumDeclIntegerType(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getEnumDeclIntegerType(C: Ptr[CXCursor])(
    __return: Ptr[CXType]
): Unit =
  __sn_wrap_libclang_clang_getEnumDeclIntegerType(C, __return)

def clang_getExceptionSpecificationType(T: Ptr[CXType]): CInt =
  __sn_wrap_libclang_clang_getExceptionSpecificationType(T)

def clang_getExceptionSpecificationType(T: CXType)(using Zone): CInt =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getExceptionSpecificationType((__ptr_0 + 0))

def clang_getExpansionLocation(
    location: CXSourceLocation,
    file: Ptr[CXFile],
    line: Ptr[CUnsignedInt],
    column: Ptr[CUnsignedInt],
    offset: Ptr[CUnsignedInt]
)(using Zone): Unit =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = location
  __sn_wrap_libclang_clang_getExpansionLocation(
    (__ptr_0 + 0),
    file,
    line,
    column,
    offset
  )
end clang_getExpansionLocation

def clang_getExpansionLocation(
    location: Ptr[CXSourceLocation],
    file: Ptr[CXFile],
    line: Ptr[CUnsignedInt],
    column: Ptr[CUnsignedInt],
    offset: Ptr[CUnsignedInt]
): Unit =
  __sn_wrap_libclang_clang_getExpansionLocation(
    location,
    file,
    line,
    column,
    offset
  )

def clang_getFieldDeclBitWidth(C: CXCursor)(using Zone): CInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getFieldDeclBitWidth((__ptr_0 + 0))

def clang_getFieldDeclBitWidth(C: Ptr[CXCursor]): CInt =
  __sn_wrap_libclang_clang_getFieldDeclBitWidth(C)

def clang_getFileLocation(
    location: CXSourceLocation,
    file: Ptr[CXFile],
    line: Ptr[CUnsignedInt],
    column: Ptr[CUnsignedInt],
    offset: Ptr[CUnsignedInt]
)(using Zone): Unit =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = location
  __sn_wrap_libclang_clang_getFileLocation(
    (__ptr_0 + 0),
    file,
    line,
    column,
    offset
  )
end clang_getFileLocation

def clang_getFileLocation(
    location: Ptr[CXSourceLocation],
    file: Ptr[CXFile],
    line: Ptr[CUnsignedInt],
    column: Ptr[CUnsignedInt],
    offset: Ptr[CUnsignedInt]
): Unit =
  __sn_wrap_libclang_clang_getFileLocation(location, file, line, column, offset)

def clang_getFileName(SFile: CXFile)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getFileName(SFile, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getFileName(SFile: CXFile)(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_getFileName(SFile, __return)

def clang_getFunctionTypeCallingConv(T: CXType)(using Zone): CXCallingConv =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getFunctionTypeCallingConv((__ptr_0 + 0))

def clang_getFunctionTypeCallingConv(T: Ptr[CXType]): CXCallingConv =
  __sn_wrap_libclang_clang_getFunctionTypeCallingConv(T)

def clang_getIBOutletCollectionType(_0: Ptr[CXCursor])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getIBOutletCollectionType(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getIBOutletCollectionType(_0: CXCursor)(using Zone): CXType =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getIBOutletCollectionType(
    (__ptr_0 + 0),
    (__ptr_1 + 0)
  )
  !(__ptr_1 + 0)
end clang_getIBOutletCollectionType

def clang_getIBOutletCollectionType(_0: Ptr[CXCursor])(
    __return: Ptr[CXType]
): Unit =
  __sn_wrap_libclang_clang_getIBOutletCollectionType(_0, __return)

def clang_getIncludedFile(cursor: Ptr[CXCursor]): CXFile =
  __sn_wrap_libclang_clang_getIncludedFile(cursor)

def clang_getIncludedFile(cursor: CXCursor)(using Zone): CXFile =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getIncludedFile((__ptr_0 + 0))

def clang_getInstantiationLocation(
    location: Ptr[CXSourceLocation],
    file: Ptr[CXFile],
    line: Ptr[CUnsignedInt],
    column: Ptr[CUnsignedInt],
    offset: Ptr[CUnsignedInt]
): Unit =
  __sn_wrap_libclang_clang_getInstantiationLocation(
    location,
    file,
    line,
    column,
    offset
  )

def clang_getInstantiationLocation(
    location: CXSourceLocation,
    file: Ptr[CXFile],
    line: Ptr[CUnsignedInt],
    column: Ptr[CUnsignedInt],
    offset: Ptr[CUnsignedInt]
)(using Zone): Unit =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = location
  __sn_wrap_libclang_clang_getInstantiationLocation(
    (__ptr_0 + 0),
    file,
    line,
    column,
    offset
  )
end clang_getInstantiationLocation

def clang_getLocation(
    tu: CXTranslationUnit,
    file: CXFile,
    line: CUnsignedInt,
    column: CUnsignedInt
)(__return: Ptr[CXSourceLocation]): Unit =
  __sn_wrap_libclang_clang_getLocation(tu, file, line, column, __return)

def clang_getLocation(
    tu: CXTranslationUnit,
    file: CXFile,
    line: CUnsignedInt,
    column: CUnsignedInt
)(using Zone): CXSourceLocation =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getLocation(tu, file, line, column, (__ptr_0 + 0))
  !(__ptr_0 + 0)
end clang_getLocation

def clang_getLocationForOffset(
    tu: CXTranslationUnit,
    file: CXFile,
    offset: CUnsignedInt
)(using Zone): CXSourceLocation =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getLocationForOffset(tu, file, offset, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getLocationForOffset(
    tu: CXTranslationUnit,
    file: CXFile,
    offset: CUnsignedInt
)(__return: Ptr[CXSourceLocation]): Unit =
  __sn_wrap_libclang_clang_getLocationForOffset(tu, file, offset, __return)

def clang_getNullCursor()(__return: Ptr[CXCursor]): Unit =
  __sn_wrap_libclang_clang_getNullCursor(__return)

def clang_getNullCursor()(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getNullCursor((__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getNullLocation()(__return: Ptr[CXSourceLocation]): Unit =
  __sn_wrap_libclang_clang_getNullLocation(__return)

def clang_getNullLocation()(using Zone): CXSourceLocation =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getNullLocation((__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getNullRange()(using Zone): CXSourceRange =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_getNullRange((__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getNullRange()(__return: Ptr[CXSourceRange]): Unit =
  __sn_wrap_libclang_clang_getNullRange(__return)

def clang_getNumArgTypes(T: Ptr[CXType]): CInt =
  __sn_wrap_libclang_clang_getNumArgTypes(T)

def clang_getNumArgTypes(T: CXType)(using Zone): CInt =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getNumArgTypes((__ptr_0 + 0))

def clang_getNumElements(T: CXType)(using Zone): CLongLong =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getNumElements((__ptr_0 + 0))

def clang_getNumElements(T: Ptr[CXType]): CLongLong =
  __sn_wrap_libclang_clang_getNumElements(T)

def clang_getNumOverloadedDecls(cursor: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getNumOverloadedDecls((__ptr_0 + 0))

def clang_getNumOverloadedDecls(cursor: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_getNumOverloadedDecls(cursor)

def clang_getOverloadedDecl(cursor: CXCursor, index: CUnsignedInt)(using
    Zone
): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getOverloadedDecl(
    (__ptr_0 + 0),
    index,
    (__ptr_0 + 1)
  )
  !(__ptr_0 + 1)
end clang_getOverloadedDecl

def clang_getOverloadedDecl(cursor: Ptr[CXCursor], index: CUnsignedInt)(
    __return: Ptr[CXCursor]
): Unit =
  __sn_wrap_libclang_clang_getOverloadedDecl(cursor, index, __return)

def clang_getOverloadedDecl(cursor: Ptr[CXCursor], index: CUnsignedInt)(using
    Zone
): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getOverloadedDecl(cursor, index, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getOverriddenCursors(
    cursor: Ptr[CXCursor],
    overridden: Ptr[Ptr[CXCursor]],
    num_overridden: Ptr[CUnsignedInt]
): Unit =
  __sn_wrap_libclang_clang_getOverriddenCursors(
    cursor,
    overridden,
    num_overridden
  )

def clang_getOverriddenCursors(
    cursor: CXCursor,
    overridden: Ptr[Ptr[CXCursor]],
    num_overridden: Ptr[CUnsignedInt]
)(using Zone): Unit =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getOverriddenCursors(
    (__ptr_0 + 0),
    overridden,
    num_overridden
  )
end clang_getOverriddenCursors

def clang_getPointeeType(T: Ptr[CXType])(__return: Ptr[CXType]): Unit =
  __sn_wrap_libclang_clang_getPointeeType(T, __return)

def clang_getPointeeType(T: Ptr[CXType])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getPointeeType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getPointeeType(T: CXType)(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getPointeeType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_getPresumedLocation(
    location: CXSourceLocation,
    filename: Ptr[CXString],
    line: Ptr[CUnsignedInt],
    column: Ptr[CUnsignedInt]
)(using Zone): Unit =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = location
  __sn_wrap_libclang_clang_getPresumedLocation(
    (__ptr_0 + 0),
    filename,
    line,
    column
  )
end clang_getPresumedLocation

def clang_getPresumedLocation(
    location: Ptr[CXSourceLocation],
    filename: Ptr[CXString],
    line: Ptr[CUnsignedInt],
    column: Ptr[CUnsignedInt]
): Unit =
  __sn_wrap_libclang_clang_getPresumedLocation(location, filename, line, column)

def clang_getRange(begin: CXSourceLocation, end: CXSourceLocation)(using
    Zone
): CXSourceRange =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  val __ptr_1: Ptr[CXSourceLocation] = alloc[CXSourceLocation](2)
  !(__ptr_1 + 0) = begin
  !(__ptr_1 + 1) = end
  __sn_wrap_libclang_clang_getRange((__ptr_1 + 0), (__ptr_1 + 1), (__ptr_0 + 0))
  !(__ptr_0 + 0)
end clang_getRange

def clang_getRange(begin: Ptr[CXSourceLocation], end: Ptr[CXSourceLocation])(
    using Zone
): CXSourceRange =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_getRange(begin, end, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getRange(begin: Ptr[CXSourceLocation], end: Ptr[CXSourceLocation])(
    __return: Ptr[CXSourceRange]
): Unit =
  __sn_wrap_libclang_clang_getRange(begin, end, __return)

def clang_getRangeEnd(range: CXSourceRange)(using Zone): CXSourceLocation =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  val __ptr_1: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = range
  __sn_wrap_libclang_clang_getRangeEnd((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

def clang_getRangeEnd(range: Ptr[CXSourceRange])(
    __return: Ptr[CXSourceLocation]
): Unit =
  __sn_wrap_libclang_clang_getRangeEnd(range, __return)

def clang_getRangeEnd(range: Ptr[CXSourceRange])(using Zone): CXSourceLocation =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getRangeEnd(range, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getRangeStart(range: Ptr[CXSourceRange])(using
    Zone
): CXSourceLocation =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getRangeStart(range, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getRangeStart(range: CXSourceRange)(using Zone): CXSourceLocation =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  val __ptr_1: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = range
  __sn_wrap_libclang_clang_getRangeStart((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

def clang_getRangeStart(range: Ptr[CXSourceRange])(
    __return: Ptr[CXSourceLocation]
): Unit =
  __sn_wrap_libclang_clang_getRangeStart(range, __return)

def clang_getResultType(T: CXType)(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getResultType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

def clang_getResultType(T: Ptr[CXType])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getResultType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getResultType(T: Ptr[CXType])(__return: Ptr[CXType]): Unit =
  __sn_wrap_libclang_clang_getResultType(T, __return)

def clang_getSpecializedCursorTemplate(C: CXCursor)(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getSpecializedCursorTemplate(
    (__ptr_0 + 0),
    (__ptr_0 + 1)
  )
  !(__ptr_0 + 1)

def clang_getSpecializedCursorTemplate(C: Ptr[CXCursor])(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getSpecializedCursorTemplate(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getSpecializedCursorTemplate(C: Ptr[CXCursor])(
    __return: Ptr[CXCursor]
): Unit =
  __sn_wrap_libclang_clang_getSpecializedCursorTemplate(C, __return)

def clang_getSpellingLocation(
    location: CXSourceLocation,
    file: Ptr[CXFile],
    line: Ptr[CUnsignedInt],
    column: Ptr[CUnsignedInt],
    offset: Ptr[CUnsignedInt]
)(using Zone): Unit =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = location
  __sn_wrap_libclang_clang_getSpellingLocation(
    (__ptr_0 + 0),
    file,
    line,
    column,
    offset
  )
end clang_getSpellingLocation

def clang_getSpellingLocation(
    location: Ptr[CXSourceLocation],
    file: Ptr[CXFile],
    line: Ptr[CUnsignedInt],
    column: Ptr[CUnsignedInt],
    offset: Ptr[CUnsignedInt]
): Unit =
  __sn_wrap_libclang_clang_getSpellingLocation(
    location,
    file,
    line,
    column,
    offset
  )

def clang_getTemplateCursorKind(C: Ptr[CXCursor]): CXCursorKind =
  __sn_wrap_libclang_clang_getTemplateCursorKind(C)

def clang_getTemplateCursorKind(C: CXCursor)(using Zone): CXCursorKind =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getTemplateCursorKind((__ptr_0 + 0))

def clang_getToken(
    TU: CXTranslationUnit,
    Location: Ptr[CXSourceLocation]
): Ptr[CXToken] =
  __sn_wrap_libclang_clang_getToken(TU, Location)

def clang_getToken(TU: CXTranslationUnit, Location: CXSourceLocation)(using
    Zone
): Ptr[CXToken] =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = Location
  __sn_wrap_libclang_clang_getToken(TU, (__ptr_0 + 0))

def clang_getTokenExtent(_0: CXTranslationUnit, _1: Ptr[CXToken])(using
    Zone
): CXSourceRange =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_getTokenExtent(_0, _1, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getTokenExtent(_0: CXTranslationUnit, _1: CXToken)(using
    Zone
): CXSourceRange =
  val __ptr_0: Ptr[CXToken] = alloc[CXToken](1)
  val __ptr_1: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  !(__ptr_0 + 0) = _1
  __sn_wrap_libclang_clang_getTokenExtent(_0, (__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

def clang_getTokenExtent(_0: CXTranslationUnit, _1: Ptr[CXToken])(
    __return: Ptr[CXSourceRange]
): Unit =
  __sn_wrap_libclang_clang_getTokenExtent(_0, _1, __return)

def clang_getTokenKind(_0: Ptr[CXToken]): CXTokenKind =
  __sn_wrap_libclang_clang_getTokenKind(_0)

def clang_getTokenKind(_0: CXToken)(using Zone): CXTokenKind =
  val __ptr_0: Ptr[CXToken] = alloc[CXToken](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getTokenKind((__ptr_0 + 0))

def clang_getTokenLocation(_0: CXTranslationUnit, _1: CXToken)(using
    Zone
): CXSourceLocation =
  val __ptr_0: Ptr[CXToken] = alloc[CXToken](1)
  val __ptr_1: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = _1
  __sn_wrap_libclang_clang_getTokenLocation(_0, (__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

def clang_getTokenLocation(_0: CXTranslationUnit, _1: Ptr[CXToken])(
    __return: Ptr[CXSourceLocation]
): Unit =
  __sn_wrap_libclang_clang_getTokenLocation(_0, _1, __return)

def clang_getTokenLocation(_0: CXTranslationUnit, _1: Ptr[CXToken])(using
    Zone
): CXSourceLocation =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getTokenLocation(_0, _1, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getTokenSpelling(_0: CXTranslationUnit, _1: Ptr[CXToken])(using
    Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getTokenSpelling(_0, _1, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getTokenSpelling(_0: CXTranslationUnit, _1: CXToken)(using
    Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  val __ptr_1: Ptr[CXToken] = alloc[CXToken](1)
  !(__ptr_1 + 0) = _1
  __sn_wrap_libclang_clang_getTokenSpelling(_0, (__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getTokenSpelling(_0: CXTranslationUnit, _1: Ptr[CXToken])(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_getTokenSpelling(_0, _1, __return)

def clang_getTranslationUnitCursor(_0: CXTranslationUnit)(
    __return: Ptr[CXCursor]
): Unit =
  __sn_wrap_libclang_clang_getTranslationUnitCursor(_0, __return)

def clang_getTranslationUnitCursor(_0: CXTranslationUnit)(using
    Zone
): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getTranslationUnitCursor(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getTranslationUnitSpelling(CTUnit: CXTranslationUnit)(using
    Zone
): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getTranslationUnitSpelling(CTUnit, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getTranslationUnitSpelling(CTUnit: CXTranslationUnit)(
    __return: Ptr[CXString]
): Unit =
  __sn_wrap_libclang_clang_getTranslationUnitSpelling(CTUnit, __return)

def clang_getTypeDeclaration(T: Ptr[CXType])(__return: Ptr[CXCursor]): Unit =
  __sn_wrap_libclang_clang_getTypeDeclaration(T, __return)

def clang_getTypeDeclaration(T: CXType)(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_1 + 0) = T
  __sn_wrap_libclang_clang_getTypeDeclaration((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getTypeDeclaration(T: Ptr[CXType])(using Zone): CXCursor =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getTypeDeclaration(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getTypeKindSpelling(K: CXTypeKind)(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_getTypeKindSpelling(K, __return)

def clang_getTypeKindSpelling(K: CXTypeKind)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getTypeKindSpelling(K, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getTypeSpelling(CT: Ptr[CXType])(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_getTypeSpelling(CT, __return)

def clang_getTypeSpelling(CT: CXType)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  val __ptr_1: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_1 + 0) = CT
  __sn_wrap_libclang_clang_getTypeSpelling((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getTypeSpelling(CT: Ptr[CXType])(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getTypeSpelling(CT, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getTypedefDeclUnderlyingType(C: Ptr[CXCursor])(
    __return: Ptr[CXType]
): Unit =
  __sn_wrap_libclang_clang_getTypedefDeclUnderlyingType(C, __return)

def clang_getTypedefDeclUnderlyingType(C: Ptr[CXCursor])(using Zone): CXType =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getTypedefDeclUnderlyingType(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getTypedefDeclUnderlyingType(C: CXCursor)(using Zone): CXType =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getTypedefDeclUnderlyingType(
    (__ptr_0 + 0),
    (__ptr_1 + 0)
  )
  !(__ptr_1 + 0)
end clang_getTypedefDeclUnderlyingType

def clang_getTypedefName(CT: Ptr[CXType])(__return: Ptr[CXString]): Unit =
  __sn_wrap_libclang_clang_getTypedefName(CT, __return)

def clang_getTypedefName(CT: CXType)(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  val __ptr_1: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_1 + 0) = CT
  __sn_wrap_libclang_clang_getTypedefName((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_getTypedefName(CT: Ptr[CXType])(using Zone): CXString =
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getTypedefName(CT, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_hashCursor(_0: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_hashCursor((__ptr_0 + 0))

def clang_hashCursor(_0: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_hashCursor(_0)

def clang_indexLoc_getCXSourceLocation(loc: Ptr[CXIdxLoc])(
    __return: Ptr[CXSourceLocation]
): Unit =
  __sn_wrap_libclang_clang_indexLoc_getCXSourceLocation(loc, __return)

def clang_indexLoc_getCXSourceLocation(loc: Ptr[CXIdxLoc])(using
    Zone
): CXSourceLocation =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_indexLoc_getCXSourceLocation(loc, (__ptr_0 + 0))
  !(__ptr_0 + 0)

def clang_indexLoc_getCXSourceLocation(loc: CXIdxLoc)(using
    Zone
): CXSourceLocation =
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  val __ptr_1: Ptr[CXIdxLoc] = alloc[CXIdxLoc](1)
  !(__ptr_1 + 0) = loc
  __sn_wrap_libclang_clang_indexLoc_getCXSourceLocation(
    (__ptr_1 + 0),
    (__ptr_0 + 0)
  )
  !(__ptr_0 + 0)
end clang_indexLoc_getCXSourceLocation

def clang_indexLoc_getFileLocation(
    loc: Ptr[CXIdxLoc],
    indexFile: Ptr[CXIdxClientFile],
    file: Ptr[CXFile],
    line: Ptr[CUnsignedInt],
    column: Ptr[CUnsignedInt],
    offset: Ptr[CUnsignedInt]
): Unit =
  __sn_wrap_libclang_clang_indexLoc_getFileLocation(
    loc,
    indexFile,
    file,
    line,
    column,
    offset
  )

def clang_indexLoc_getFileLocation(
    loc: CXIdxLoc,
    indexFile: Ptr[CXIdxClientFile],
    file: Ptr[CXFile],
    line: Ptr[CUnsignedInt],
    column: Ptr[CUnsignedInt],
    offset: Ptr[CUnsignedInt]
)(using Zone): Unit =
  val __ptr_0: Ptr[CXIdxLoc] = alloc[CXIdxLoc](1)
  !(__ptr_0 + 0) = loc
  __sn_wrap_libclang_clang_indexLoc_getFileLocation(
    (__ptr_0 + 0),
    indexFile,
    file,
    line,
    column,
    offset
  )
end clang_indexLoc_getFileLocation

def clang_isConstQualifiedType(T: Ptr[CXType]): CUnsignedInt =
  __sn_wrap_libclang_clang_isConstQualifiedType(T)

def clang_isConstQualifiedType(T: CXType)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_isConstQualifiedType((__ptr_0 + 0))

def clang_isCursorDefinition(_0: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_isCursorDefinition((__ptr_0 + 0))

def clang_isCursorDefinition(_0: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_isCursorDefinition(_0)

def clang_isFunctionTypeVariadic(T: Ptr[CXType]): CUnsignedInt =
  __sn_wrap_libclang_clang_isFunctionTypeVariadic(T)

def clang_isFunctionTypeVariadic(T: CXType)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_isFunctionTypeVariadic((__ptr_0 + 0))

def clang_isInvalidDeclaration(_0: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_isInvalidDeclaration((__ptr_0 + 0))

def clang_isInvalidDeclaration(_0: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_isInvalidDeclaration(_0)

def clang_isPODType(T: CXType)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_isPODType((__ptr_0 + 0))

def clang_isPODType(T: Ptr[CXType]): CUnsignedInt =
  __sn_wrap_libclang_clang_isPODType(T)

def clang_isRestrictQualifiedType(T: Ptr[CXType]): CUnsignedInt =
  __sn_wrap_libclang_clang_isRestrictQualifiedType(T)

def clang_isRestrictQualifiedType(T: CXType)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_isRestrictQualifiedType((__ptr_0 + 0))

def clang_isVirtualBase(_0: CXCursor)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_isVirtualBase((__ptr_0 + 0))

def clang_isVirtualBase(_0: Ptr[CXCursor]): CUnsignedInt =
  __sn_wrap_libclang_clang_isVirtualBase(_0)

def clang_isVolatileQualifiedType(T: CXType)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_isVolatileQualifiedType((__ptr_0 + 0))

def clang_isVolatileQualifiedType(T: Ptr[CXType]): CUnsignedInt =
  __sn_wrap_libclang_clang_isVolatileQualifiedType(T)

def clang_tokenize(
    TU: CXTranslationUnit,
    Range: CXSourceRange,
    Tokens: Ptr[Ptr[CXToken]],
    NumTokens: Ptr[CUnsignedInt]
)(using Zone): Unit =
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  !(__ptr_0 + 0) = Range
  __sn_wrap_libclang_clang_tokenize(TU, (__ptr_0 + 0), Tokens, NumTokens)
end clang_tokenize

def clang_tokenize(
    TU: CXTranslationUnit,
    Range: Ptr[CXSourceRange],
    Tokens: Ptr[Ptr[CXToken]],
    NumTokens: Ptr[CUnsignedInt]
): Unit =
  __sn_wrap_libclang_clang_tokenize(TU, Range, Tokens, NumTokens)

def clang_visitChildren(
    parent: Ptr[CXCursor],
    visitor: CXCursorVisitor,
    client_data: CXClientData
): CUnsignedInt =
  __sn_wrap_libclang_clang_visitChildren(parent, visitor, client_data)

def clang_visitChildren(
    parent: CXCursor,
    visitor: CXCursorVisitor,
    client_data: CXClientData
)(using Zone): CUnsignedInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = parent
  __sn_wrap_libclang_clang_visitChildren((__ptr_0 + 0), visitor, client_data)
