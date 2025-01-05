package libclang

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*



@extern private[libclang] def __sn_wrap_libclang_clang_CXCursorSet_contains(cset : CXCursorSet, cursor : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXCursorSet_insert(cset : CXCursorSet, cursor : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXConstructor_isConvertingConstructor(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXConstructor_isCopyConstructor(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXConstructor_isDefaultConstructor(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXConstructor_isMoveConstructor(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXField_isMutable(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXMethod_isConst(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXMethod_isCopyAssignmentOperator(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXMethod_isDefaulted(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXMethod_isDeleted(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXMethod_isExplicit(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXMethod_isMoveAssignmentOperator(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXMethod_isPureVirtual(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXMethod_isStatic(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXMethod_isVirtual(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_CXXRecord_isAbstract(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_Evaluate(C : Ptr[CXCursor]): CXEvalResult = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getArgument(C : Ptr[CXCursor], i : CUnsignedInt, __return : Ptr[CXCursor]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getBinaryOpcode(C : Ptr[CXCursor]): CX_BinaryOperatorKind = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getBinaryOpcodeStr(Op : CX_BinaryOperatorKind, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getBriefCommentText(C : Ptr[CXCursor], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getCXXManglings(_0 : Ptr[CXCursor]): Ptr[CXStringSet] = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getCommentRange(C : Ptr[CXCursor], __return : Ptr[CXSourceRange]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getMangling(_0 : Ptr[CXCursor], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getModule(C : Ptr[CXCursor]): CXModule = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getNumArguments(C : Ptr[CXCursor]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getNumTemplateArguments(C : Ptr[CXCursor]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getObjCDeclQualifiers(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getObjCManglings(_0 : Ptr[CXCursor]): Ptr[CXStringSet] = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getObjCPropertyAttributes(C : Ptr[CXCursor], reserved : CUnsignedInt): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getObjCPropertyGetterName(C : Ptr[CXCursor], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getObjCPropertySetterName(C : Ptr[CXCursor], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getObjCSelectorIndex(_0 : Ptr[CXCursor]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getOffsetOfField(C : Ptr[CXCursor]): CLongLong = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getRawCommentText(C : Ptr[CXCursor], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getReceiverType(C : Ptr[CXCursor], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getSpellingNameRange(_0 : Ptr[CXCursor], pieceIndex : CUnsignedInt, options : CUnsignedInt, __return : Ptr[CXSourceRange]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getStorageClass(_0 : Ptr[CXCursor]): CX_StorageClass = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getTemplateArgumentKind(C : Ptr[CXCursor], I : CUnsignedInt): CXTemplateArgumentKind = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getTemplateArgumentType(C : Ptr[CXCursor], I : CUnsignedInt, __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getTemplateArgumentUnsignedValue(C : Ptr[CXCursor], I : CUnsignedInt): CUnsignedLongLong = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getTemplateArgumentValue(C : Ptr[CXCursor], I : CUnsignedInt): CLongLong = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getTranslationUnit(_0 : Ptr[CXCursor]): CXTranslationUnit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_getVarDeclInitializer(cursor : Ptr[CXCursor], __return : Ptr[CXCursor]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_hasAttrs(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_hasVarDeclExternalStorage(cursor : Ptr[CXCursor]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_hasVarDeclGlobalStorage(cursor : Ptr[CXCursor]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_isAnonymous(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_isAnonymousRecordDecl(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_isBitField(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_isDynamicCall(C : Ptr[CXCursor]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_isExternalSymbol(C : Ptr[CXCursor], language : Ptr[CXString], definedIn : Ptr[CXString], isGenerated : Ptr[CUnsignedInt]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_isFunctionInlined(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_isInlineNamespace(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_isMacroBuiltin(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_isMacroFunctionLike(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_isNull(cursor : Ptr[CXCursor]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_isObjCOptional(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Cursor_isVariadic(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_EnumDecl_isScoped(C : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_File_tryGetRealPathName(file : CXFile, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Location_isFromMainFile(location : Ptr[CXSourceLocation]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Location_isInSystemHeader(location : Ptr[CXSourceLocation]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Module_getFullName(Module : CXModule, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Module_getName(Module : CXModule, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Range_isNull(range : Ptr[CXSourceRange]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_TargetInfo_getTriple(Info : CXTargetInfo, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getAlignOf(T : Ptr[CXType]): CLongLong = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getCXXRefQualifier(T : Ptr[CXType]): CXRefQualifierKind = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getClassType(T : Ptr[CXType], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getModifiedType(T : Ptr[CXType], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getNamedType(T : Ptr[CXType], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getNullability(T : Ptr[CXType]): CXTypeNullabilityKind = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getNumObjCProtocolRefs(T : Ptr[CXType]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getNumObjCTypeArgs(T : Ptr[CXType]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getNumTemplateArguments(T : Ptr[CXType]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getObjCEncoding(`type` : Ptr[CXType], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getObjCObjectBaseType(T : Ptr[CXType], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getObjCProtocolDecl(T : Ptr[CXType], i : CUnsignedInt, __return : Ptr[CXCursor]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getObjCTypeArg(T : Ptr[CXType], i : CUnsignedInt, __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getOffsetOf(T : Ptr[CXType], S : CString): CLongLong = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getSizeOf(T : Ptr[CXType]): CLongLong = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getTemplateArgumentAsType(T : Ptr[CXType], i : CUnsignedInt, __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_getValueType(CT : Ptr[CXType], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_isTransparentTagTypedef(T : Ptr[CXType]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_Type_visitFields(T : Ptr[CXType], visitor : CXFieldVisitor, client_data : CXClientData): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_codeCompleteGetContainerUSR(Results : Ptr[CXCodeCompleteResults], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_codeCompleteGetObjCSelector(Results : Ptr[CXCodeCompleteResults], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_constructUSR_ObjCCategory(class_name : CString, category_name : CString, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_constructUSR_ObjCClass(class_name : CString, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_constructUSR_ObjCIvar(name : CString, classUSR : Ptr[CXString], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_constructUSR_ObjCMethod(name : CString, isInstanceMethod : CUnsignedInt, classUSR : Ptr[CXString], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_constructUSR_ObjCProperty(property : CString, classUSR : Ptr[CXString], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_constructUSR_ObjCProtocol(protocol_name : CString, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_disposeCXTUResourceUsage(usage : Ptr[CXTUResourceUsage]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_disposeString(string : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_equalCursors(_0 : Ptr[CXCursor], _1 : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_equalLocations(loc1 : Ptr[CXSourceLocation], loc2 : Ptr[CXSourceLocation]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_equalRanges(range1 : Ptr[CXSourceRange], range2 : Ptr[CXSourceRange]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_equalTypes(A : Ptr[CXType], B : Ptr[CXType]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_findIncludesInFile(TU : CXTranslationUnit, file : CXFile, visitor : Ptr[CXCursorAndRangeVisitor]): CXResult = extern

@extern private[libclang] def __sn_wrap_libclang_clang_findReferencesInFile(cursor : Ptr[CXCursor], file : CXFile, visitor : Ptr[CXCursorAndRangeVisitor]): CXResult = extern

@extern private[libclang] def __sn_wrap_libclang_clang_findReferencesInFileWithBlock(_0 : Ptr[CXCursor], _1 : CXFile, _2 : CXCursorAndRangeVisitorBlock): CXResult = extern

@extern private[libclang] def __sn_wrap_libclang_clang_formatDiagnostic(Diagnostic : CXDiagnostic, Options : CUnsignedInt, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getAddressSpace(T : Ptr[CXType]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getArgType(T : Ptr[CXType], i : CUnsignedInt, __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getArrayElementType(T : Ptr[CXType], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getArraySize(T : Ptr[CXType]): CLongLong = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getBinaryOperatorKindSpelling(kind : CXBinaryOperatorKind, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCString(string : Ptr[CXString]): CString = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCXTUResourceUsage(TU : CXTranslationUnit, __return : Ptr[CXTUResourceUsage]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCXXAccessSpecifier(_0 : Ptr[CXCursor]): CX_CXXAccessSpecifier = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCanonicalCursor(_0 : Ptr[CXCursor], __return : Ptr[CXCursor]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCanonicalType(T : Ptr[CXType], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getClangVersion(__return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCompletionAnnotation(completion_string : CXCompletionString, annotation_number : CUnsignedInt, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCompletionBriefComment(completion_string : CXCompletionString, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCompletionChunkText(completion_string : CXCompletionString, chunk_number : CUnsignedInt, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCompletionFixIt(results : Ptr[CXCodeCompleteResults], completion_index : CUnsignedInt, fixit_index : CUnsignedInt, replacement_range : Ptr[CXSourceRange], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCompletionParent(completion_string : CXCompletionString, kind : Ptr[CXCursorKind], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursor(_0 : CXTranslationUnit, _1 : Ptr[CXSourceLocation], __return : Ptr[CXCursor]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorAvailability(cursor : Ptr[CXCursor]): CXAvailabilityKind = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorBinaryOperatorKind(cursor : Ptr[CXCursor]): CXBinaryOperatorKind = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorCompletionString(cursor : Ptr[CXCursor]): CXCompletionString = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorDefinition(_0 : Ptr[CXCursor], __return : Ptr[CXCursor]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorDisplayName(_0 : Ptr[CXCursor], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorExceptionSpecificationType(C : Ptr[CXCursor]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorExtent(_0 : Ptr[CXCursor], __return : Ptr[CXSourceRange]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorKind(_0 : Ptr[CXCursor]): CXCursorKind = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorKindSpelling(Kind : CXCursorKind, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorLanguage(cursor : Ptr[CXCursor]): CXLanguageKind = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorLexicalParent(cursor : Ptr[CXCursor], __return : Ptr[CXCursor]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorLinkage(cursor : Ptr[CXCursor]): CXLinkageKind = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorLocation(_0 : Ptr[CXCursor], __return : Ptr[CXSourceLocation]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorPlatformAvailability(cursor : Ptr[CXCursor], always_deprecated : Ptr[CInt], deprecated_message : Ptr[CXString], always_unavailable : Ptr[CInt], unavailable_message : Ptr[CXString], availability : Ptr[CXPlatformAvailability], availability_size : CInt): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorPrettyPrinted(Cursor : Ptr[CXCursor], Policy : CXPrintingPolicy, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorPrintingPolicy(_0 : Ptr[CXCursor]): CXPrintingPolicy = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorReferenceNameRange(C : Ptr[CXCursor], NameFlags : CUnsignedInt, PieceIndex : CUnsignedInt, __return : Ptr[CXSourceRange]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorReferenced(_0 : Ptr[CXCursor], __return : Ptr[CXCursor]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorResultType(C : Ptr[CXCursor], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorSemanticParent(cursor : Ptr[CXCursor], __return : Ptr[CXCursor]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorSpelling(_0 : Ptr[CXCursor], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorTLSKind(cursor : Ptr[CXCursor]): CXTLSKind = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorType(C : Ptr[CXCursor], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorUSR(_0 : Ptr[CXCursor], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorUnaryOperatorKind(cursor : Ptr[CXCursor]): CXUnaryOperatorKind = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getCursorVisibility(cursor : Ptr[CXCursor]): CXVisibilityKind = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getDeclObjCTypeEncoding(C : Ptr[CXCursor], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getDefinitionSpellingAndExtent(_0 : Ptr[CXCursor], startBuf : Ptr[CString], endBuf : Ptr[CString], startLine : Ptr[CUnsignedInt], startColumn : Ptr[CUnsignedInt], endLine : Ptr[CUnsignedInt], endColumn : Ptr[CUnsignedInt]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getDiagnosticCategoryName(Category : CUnsignedInt, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getDiagnosticCategoryText(_0 : CXDiagnostic, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getDiagnosticFixIt(Diagnostic : CXDiagnostic, FixIt : CUnsignedInt, ReplacementRange : Ptr[CXSourceRange], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getDiagnosticLocation(_0 : CXDiagnostic, __return : Ptr[CXSourceLocation]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getDiagnosticOption(Diag : CXDiagnostic, Disable : Ptr[CXString], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getDiagnosticRange(Diagnostic : CXDiagnostic, Range : CUnsignedInt, __return : Ptr[CXSourceRange]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getDiagnosticSpelling(_0 : CXDiagnostic, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getElementType(T : Ptr[CXType], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getEnumConstantDeclUnsignedValue(C : Ptr[CXCursor]): CUnsignedLongLong = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getEnumConstantDeclValue(C : Ptr[CXCursor]): CLongLong = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getEnumDeclIntegerType(C : Ptr[CXCursor], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getExceptionSpecificationType(T : Ptr[CXType]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getExpansionLocation(location : Ptr[CXSourceLocation], file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getFieldDeclBitWidth(C : Ptr[CXCursor]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getFileLocation(location : Ptr[CXSourceLocation], file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getFileName(SFile : CXFile, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getFunctionTypeCallingConv(T : Ptr[CXType]): CXCallingConv = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getIBOutletCollectionType(_0 : Ptr[CXCursor], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getIncludedFile(cursor : Ptr[CXCursor]): CXFile = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getInstantiationLocation(location : Ptr[CXSourceLocation], file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getLocation(tu : CXTranslationUnit, file : CXFile, line : CUnsignedInt, column : CUnsignedInt, __return : Ptr[CXSourceLocation]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getLocationForOffset(tu : CXTranslationUnit, file : CXFile, offset : CUnsignedInt, __return : Ptr[CXSourceLocation]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getNonReferenceType(CT : Ptr[CXType], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getNullCursor(__return : Ptr[CXCursor]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getNullLocation(__return : Ptr[CXSourceLocation]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getNullRange(__return : Ptr[CXSourceRange]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getNumArgTypes(T : Ptr[CXType]): CInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getNumElements(T : Ptr[CXType]): CLongLong = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getNumOverloadedDecls(cursor : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getOverloadedDecl(cursor : Ptr[CXCursor], index : CUnsignedInt, __return : Ptr[CXCursor]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getOverriddenCursors(cursor : Ptr[CXCursor], overridden : Ptr[Ptr[CXCursor]], num_overridden : Ptr[CUnsignedInt]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getPointeeType(T : Ptr[CXType], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getPresumedLocation(location : Ptr[CXSourceLocation], filename : Ptr[CXString], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getRange(begin : Ptr[CXSourceLocation], end : Ptr[CXSourceLocation], __return : Ptr[CXSourceRange]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getRangeEnd(range : Ptr[CXSourceRange], __return : Ptr[CXSourceLocation]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getRangeStart(range : Ptr[CXSourceRange], __return : Ptr[CXSourceLocation]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getResultType(T : Ptr[CXType], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getSpecializedCursorTemplate(C : Ptr[CXCursor], __return : Ptr[CXCursor]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getSpellingLocation(location : Ptr[CXSourceLocation], file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getTemplateCursorKind(C : Ptr[CXCursor]): CXCursorKind = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getToken(TU : CXTranslationUnit, Location : Ptr[CXSourceLocation]): Ptr[CXToken] = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getTokenExtent(_0 : CXTranslationUnit, _1 : Ptr[CXToken], __return : Ptr[CXSourceRange]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getTokenKind(_0 : Ptr[CXToken]): CXTokenKind = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getTokenLocation(_0 : CXTranslationUnit, _1 : Ptr[CXToken], __return : Ptr[CXSourceLocation]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getTokenSpelling(_0 : CXTranslationUnit, _1 : Ptr[CXToken], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getTranslationUnitCursor(_0 : CXTranslationUnit, __return : Ptr[CXCursor]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getTranslationUnitSpelling(CTUnit : CXTranslationUnit, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getTypeDeclaration(T : Ptr[CXType], __return : Ptr[CXCursor]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getTypeKindSpelling(K : CXTypeKind, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getTypeSpelling(CT : Ptr[CXType], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getTypedefDeclUnderlyingType(C : Ptr[CXCursor], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getTypedefName(CT : Ptr[CXType], __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getUnaryOperatorKindSpelling(kind : CXUnaryOperatorKind, __return : Ptr[CXString]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_getUnqualifiedType(CT : Ptr[CXType], __return : Ptr[CXType]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_hashCursor(_0 : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_indexLoc_getCXSourceLocation(loc : Ptr[CXIdxLoc], __return : Ptr[CXSourceLocation]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_indexLoc_getFileLocation(loc : Ptr[CXIdxLoc], indexFile : Ptr[CXIdxClientFile], file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_isConstQualifiedType(T : Ptr[CXType]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_isCursorDefinition(_0 : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_isFunctionTypeVariadic(T : Ptr[CXType]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_isInvalidDeclaration(_0 : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_isPODType(T : Ptr[CXType]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_isRestrictQualifiedType(T : Ptr[CXType]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_isVirtualBase(_0 : Ptr[CXCursor]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_isVolatileQualifiedType(T : Ptr[CXType]): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_tokenize(TU : CXTranslationUnit, Range : Ptr[CXSourceRange], Tokens : Ptr[Ptr[CXToken]], NumTokens : Ptr[CUnsignedInt]): Unit = extern

@extern private[libclang] def __sn_wrap_libclang_clang_visitChildren(parent : Ptr[CXCursor], visitor : CXCursorVisitor, client_data : CXClientData): CUnsignedInt = extern

@extern private[libclang] def __sn_wrap_libclang_clang_visitChildrenWithBlock(parent : Ptr[CXCursor], block : CXCursorVisitorBlock): CUnsignedInt = extern

/**
 * Gets the general options associated with a CXIndex.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_CXIndex_getGlobalOptions(_0 : CXIndex): CUnsignedInt = extern

/**
 * Sets general options associated with a CXIndex.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_CXIndex_setGlobalOptions(_0 : CXIndex, options : CUnsignedInt): Unit = extern

/**
 * Sets the invocation emission path option in a CXIndex.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_CXIndex_setInvocationEmissionPathOption(_0 : CXIndex, Path : CString): Unit = extern

/**
 * Disposes the created Eval memory.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_EvalResult_dispose(E : CXEvalResult): Unit = extern

/**
 * Returns the evaluation result as double if the kind is double.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_EvalResult_getAsDouble(E : CXEvalResult): Double = extern

/**
 * Returns the evaluation result as integer if the kind is Int.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_EvalResult_getAsInt(E : CXEvalResult): CInt = extern

/**
 * Returns the evaluation result as a long long integer if the kind is Int. This prevents overflows that may happen if the result is returned with clang_EvalResult_getAsInt.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_EvalResult_getAsLongLong(E : CXEvalResult): CLongLong = extern

/**
 * Returns the evaluation result as a constant string if the kind is other than Int or float. User must not free this pointer, instead call clang_EvalResult_dispose on the CXEvalResult returned by clang_Cursor_Evaluate.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_EvalResult_getAsStr(E : CXEvalResult): CString = extern

/**
 * Returns the evaluation result as an unsigned integer if the kind is Int and clang_EvalResult_isUnsignedInt is non-zero.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_EvalResult_getAsUnsigned(E : CXEvalResult): CUnsignedLongLong = extern

/**
 * Returns the kind of the evaluated result.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_EvalResult_getKind(E : CXEvalResult): CXEvalResultKind = extern

/**
 * Returns a non-zero value if the kind is Int and the evaluation result resulted in an unsigned integer.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_EvalResult_isUnsignedInt(E : CXEvalResult): CUnsignedInt = extern

/**
 * Returns non-zero if the file1 and file2 point to the same file, or they are both NULL.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXFile.h
*/
@extern def clang_File_isEqual(file1 : CXFile, file2 : CXFile): CInt = extern

/**
 * An indexing action/session, to be applied to one or multiple translation units.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_IndexAction_create(CIdx : CXIndex): CXIndexAction = extern

/**
 * Destroy the given index action.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_IndexAction_dispose(_0 : CXIndexAction): Unit = extern

/**
 * Create a CXModuleMapDescriptor object. Must be disposed with clang_ModuleMapDescriptor_dispose().

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/BuildSystem.h
*/
@extern def clang_ModuleMapDescriptor_create(options : CUnsignedInt): CXModuleMapDescriptor = extern

/**
 * Dispose a CXModuleMapDescriptor object.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/BuildSystem.h
*/
@extern def clang_ModuleMapDescriptor_dispose(_0 : CXModuleMapDescriptor): Unit = extern

/**
 * Sets the framework module name that the module.modulemap describes.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/BuildSystem.h
*/
@extern def clang_ModuleMapDescriptor_setFrameworkModuleName(_0 : CXModuleMapDescriptor, name : CString): CXErrorCode = extern

/**
 * Sets the umbrella header name that the module.modulemap describes.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/BuildSystem.h
*/
@extern def clang_ModuleMapDescriptor_setUmbrellaHeader(_0 : CXModuleMapDescriptor, name : CString): CXErrorCode = extern

/**
 * Write out the CXModuleMapDescriptor object to a char buffer.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/BuildSystem.h
*/
@extern def clang_ModuleMapDescriptor_writeToBuffer(_0 : CXModuleMapDescriptor, options : CUnsignedInt, out_buffer_ptr : Ptr[CString], out_buffer_size : Ptr[CUnsignedInt]): CXErrorCode = extern

/**
 * Returns the module file where the provided module object came from.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_Module_getASTFile(Module : CXModule): CXFile = extern

/**
 * Returns the number of top level headers associated with this module.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_Module_getNumTopLevelHeaders(_0 : CXTranslationUnit, Module : CXModule): CUnsignedInt = extern

/**
 * Returns the parent of a sub-module or NULL if the given module is top-level, e.g. for 'std.vector' it will return the 'std' module.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_Module_getParent(Module : CXModule): CXModule = extern

/**
 * Returns the specified top level header associated with the module.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_Module_getTopLevelHeader(_0 : CXTranslationUnit, Module : CXModule, Index : CUnsignedInt): CXFile = extern

/**
 * Returns non-zero if the module is a system one.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_Module_isSystem(Module : CXModule): CInt = extern

/**
 * Release a printing policy.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_PrintingPolicy_dispose(Policy : CXPrintingPolicy): Unit = extern

/**
 * Get a property value for the given printing policy.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_PrintingPolicy_getProperty(Policy : CXPrintingPolicy, Property : CXPrintingPolicyProperty): CUnsignedInt = extern

/**
 * Set a property value for the given printing policy.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_PrintingPolicy_setProperty(Policy : CXPrintingPolicy, Property : CXPrintingPolicyProperty, Value : CUnsignedInt): Unit = extern

/**
 * Destroy the CXTargetInfo object.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_TargetInfo_dispose(Info : CXTargetInfo): Unit = extern

/**
 * Get the pointer width of the target in bits.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_TargetInfo_getPointerWidth(Info : CXTargetInfo): CInt = extern

/**
 * Map an absolute virtual file path to an absolute real one. The virtual path must be canonicalized (not contain "."/"..").

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/BuildSystem.h
*/
@extern def clang_VirtualFileOverlay_addFileMapping(_0 : CXVirtualFileOverlay, virtualPath : CString, realPath : CString): CXErrorCode = extern

/**
 * Create a CXVirtualFileOverlay object. Must be disposed with clang_VirtualFileOverlay_dispose().

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/BuildSystem.h
*/
@extern def clang_VirtualFileOverlay_create(options : CUnsignedInt): CXVirtualFileOverlay = extern

/**
 * Dispose a CXVirtualFileOverlay object.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/BuildSystem.h
*/
@extern def clang_VirtualFileOverlay_dispose(_0 : CXVirtualFileOverlay): Unit = extern

/**
 * Set the case sensitivity for the CXVirtualFileOverlay object. The CXVirtualFileOverlay object is case-sensitive by default, this option can be used to override the default.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/BuildSystem.h
*/
@extern def clang_VirtualFileOverlay_setCaseSensitivity(_0 : CXVirtualFileOverlay, caseSensitive : CInt): CXErrorCode = extern

/**
 * Write out the CXVirtualFileOverlay object to a char buffer.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/BuildSystem.h
*/
@extern def clang_VirtualFileOverlay_writeToBuffer(_0 : CXVirtualFileOverlay, options : CUnsignedInt, out_buffer_ptr : Ptr[CString], out_buffer_size : Ptr[CUnsignedInt]): CXErrorCode = extern

/**
 * Annotate the given set of tokens by providing cursors for each token that can be mapped to a specific entity within the abstract syntax tree.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_annotateTokens(TU : CXTranslationUnit, Tokens : Ptr[CXToken], NumTokens : CUnsignedInt, Cursors : Ptr[CXCursor]): Unit = extern

/**
 * Perform code completion at a given location in a translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_codeCompleteAt(TU : CXTranslationUnit, complete_filename : CString, complete_line : CUnsignedInt, complete_column : CUnsignedInt, unsaved_files : Ptr[CXUnsavedFile], num_unsaved_files : CUnsignedInt, options : CUnsignedInt): Ptr[CXCodeCompleteResults] = extern

/**
 * Returns the cursor kind for the container for the current code completion context. The container is only guaranteed to be set for contexts where a container exists (i.e. member accesses or Objective-C message sends); if there is not a container, this function will return CXCursor_InvalidCode.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_codeCompleteGetContainerKind(Results : Ptr[CXCodeCompleteResults], IsIncomplete : Ptr[CUnsignedInt]): CXCursorKind = extern

/**
 * Determines what completions are appropriate for the context the given code completion.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_codeCompleteGetContexts(Results : Ptr[CXCodeCompleteResults]): CUnsignedLongLong = extern

/**
 * Retrieve a diagnostic associated with the given code completion.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_codeCompleteGetDiagnostic(Results : Ptr[CXCodeCompleteResults], Index : CUnsignedInt): CXDiagnostic = extern

/**
 * Determine the number of diagnostics produced prior to the location where code completion was performed.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_codeCompleteGetNumDiagnostics(Results : Ptr[CXCodeCompleteResults]): CUnsignedInt = extern

/**
 * Creates an empty CXCursorSet.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_createCXCursorSet(): CXCursorSet = extern

/**
 * Provides a shared context for creating translation units.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_createIndex(excludeDeclarationsFromPCH : CInt, displayDiagnostics : CInt): CXIndex = extern

/**
 * Provides a shared context for creating translation units.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_createIndexWithOptions(options : Ptr[CXIndexOptions]): CXIndex = extern

/**
 * Same as clang_createTranslationUnit2, but returns the CXTranslationUnit instead of an error code. In case of an error this routine returns a NULL CXTranslationUnit, without further detailed error codes.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_createTranslationUnit(CIdx : CXIndex, ast_filename : CString): CXTranslationUnit = extern

/**
 * Create a translation unit from an AST file ( -emit-ast).

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_createTranslationUnit2(CIdx : CXIndex, ast_filename : CString, out_TU : Ptr[CXTranslationUnit]): CXErrorCode = extern

/**
 * Return the CXTranslationUnit for a given source file and the provided command line arguments one would pass to the compiler.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_createTranslationUnitFromSourceFile(CIdx : CXIndex, source_filename : CString, num_clang_command_line_args : CInt, clang_command_line_args : Ptr[CString], num_unsaved_files : CUnsignedInt, unsaved_files : Ptr[CXUnsavedFile]): CXTranslationUnit = extern

/**
 * Returns a default set of code-completion options that can be passed to clang_codeCompleteAt().

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_defaultCodeCompleteOptions(): CUnsignedInt = extern

/**
 * Retrieve the set of display options most similar to the default behavior of the clang compiler.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
@extern def clang_defaultDiagnosticDisplayOptions(): CUnsignedInt = extern

/**
 * Returns the set of flags that is suitable for parsing a translation unit that is being edited.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_defaultEditingTranslationUnitOptions(): CUnsignedInt = extern

/**
 * Returns the set of flags that is suitable for reparsing a translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_defaultReparseOptions(TU : CXTranslationUnit): CUnsignedInt = extern

/**
 * Returns the set of flags that is suitable for saving a translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_defaultSaveOptions(TU : CXTranslationUnit): CUnsignedInt = extern

/**
 * Disposes a CXCursorSet and releases its associated memory.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_disposeCXCursorSet(cset : CXCursorSet): Unit = extern

/**
 * Free the memory associated with a CXPlatformAvailability structure.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_disposeCXPlatformAvailability(availability : Ptr[CXPlatformAvailability]): Unit = extern

/**
 * Free the given set of code-completion results.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_disposeCodeCompleteResults(Results : Ptr[CXCodeCompleteResults]): Unit = extern

/**
 * Destroy a diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
@extern def clang_disposeDiagnostic(Diagnostic : CXDiagnostic): Unit = extern

/**
 * Release a CXDiagnosticSet and all of its contained diagnostics.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
@extern def clang_disposeDiagnosticSet(Diags : CXDiagnosticSet): Unit = extern

/**
 * Destroy the given index.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_disposeIndex(index : CXIndex): Unit = extern

/**
 * Free the set of overridden cursors returned by clang_getOverriddenCursors().

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_disposeOverriddenCursors(overridden : Ptr[CXCursor]): Unit = extern

/**
 * Destroy the given CXSourceRangeList.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
@extern def clang_disposeSourceRangeList(ranges : Ptr[CXSourceRangeList]): Unit = extern

/**
 * Free the given string set.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXString.h
*/
@extern def clang_disposeStringSet(set : Ptr[CXStringSet]): Unit = extern

/**
 * Free the given set of tokens.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_disposeTokens(TU : CXTranslationUnit, Tokens : Ptr[CXToken], NumTokens : CUnsignedInt): Unit = extern

/**
 * Destroy the specified CXTranslationUnit object.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_disposeTranslationUnit(_0 : CXTranslationUnit): Unit = extern

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_enableStackTraces(): Unit = extern

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_executeOnThread(fn : CFuncPtr1[Ptr[Byte], Unit], user_data : Ptr[Byte], stack_size : CUnsignedInt): Unit = extern

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_findIncludesInFileWithBlock(_0 : CXTranslationUnit, _1 : CXFile, _2 : CXCursorAndRangeVisitorBlock): CXResult = extern

/**
 * free memory allocated by libclang, such as the buffer returned by CXVirtualFileOverlay() or clang_ModuleMapDescriptor_writeToBuffer().

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/BuildSystem.h
*/
@extern def clang_free(buffer : Ptr[Byte]): Unit = extern

/**
 * Retrieve all ranges from all files that were skipped by the preprocessor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getAllSkippedRanges(tu : CXTranslationUnit): Ptr[CXSourceRangeList] = extern

/**
 * Return the timestamp for use with Clang's -fbuild-session-timestamp= option.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/BuildSystem.h
*/
@extern def clang_getBuildSessionTimestamp(): CUnsignedLongLong = extern

/**
 * Retrieve the child diagnostics of a CXDiagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
@extern def clang_getChildDiagnostics(D : CXDiagnostic): CXDiagnosticSet = extern

/**
 * Determine the availability of the entity that this code-completion string refers to.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getCompletionAvailability(completion_string : CXCompletionString): CXAvailabilityKind = extern

/**
 * Retrieve the completion string associated with a particular chunk within a completion string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getCompletionChunkCompletionString(completion_string : CXCompletionString, chunk_number : CUnsignedInt): CXCompletionString = extern

/**
 * Determine the kind of a particular chunk within a completion string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getCompletionChunkKind(completion_string : CXCompletionString, chunk_number : CUnsignedInt): CXCompletionChunkKind = extern

/**
 * Retrieve the number of annotations associated with the given completion string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getCompletionNumAnnotations(completion_string : CXCompletionString): CUnsignedInt = extern

/**
 * Retrieve the number of fix-its for the given completion index.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getCompletionNumFixIts(results : Ptr[CXCodeCompleteResults], completion_index : CUnsignedInt): CUnsignedInt = extern

/**
 * Determine the priority of this code completion.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getCompletionPriority(completion_string : CXCompletionString): CUnsignedInt = extern

/**
 * Retrieve a diagnostic associated with the given translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getDiagnostic(Unit : CXTranslationUnit, Index : CUnsignedInt): CXDiagnostic = extern

/**
 * Retrieve the category number for this diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
@extern def clang_getDiagnosticCategory(_0 : CXDiagnostic): CUnsignedInt = extern

/**
 * Retrieve a diagnostic associated with the given CXDiagnosticSet.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
@extern def clang_getDiagnosticInSet(Diags : CXDiagnosticSet, Index : CUnsignedInt): CXDiagnostic = extern

/**
 * Determine the number of fix-it hints associated with the given diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
@extern def clang_getDiagnosticNumFixIts(Diagnostic : CXDiagnostic): CUnsignedInt = extern

/**
 * Determine the number of source ranges associated with the given diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
@extern def clang_getDiagnosticNumRanges(_0 : CXDiagnostic): CUnsignedInt = extern

/**
 * Retrieve the complete set of diagnostics associated with a translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getDiagnosticSetFromTU(Unit : CXTranslationUnit): CXDiagnosticSet = extern

/**
 * Determine the severity of the given diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
@extern def clang_getDiagnosticSeverity(_0 : CXDiagnostic): CXDiagnosticSeverity = extern

/**
 * Retrieve a file handle within the given translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getFile(tu : CXTranslationUnit, file_name : CString): CXFile = extern

/**
 * Retrieve the buffer associated with the given file.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getFileContents(tu : CXTranslationUnit, file : CXFile, size : Ptr[size_t]): CString = extern

/**
 * Retrieve the last modification time of the given file.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXFile.h
*/
@extern def clang_getFileTime(SFile : CXFile): time_t = extern

/**
 * Retrieve the unique ID for the given file.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXFile.h
*/
@extern def clang_getFileUniqueID(file : CXFile, outID : Ptr[CXFileUniqueID]): CInt = extern

/**
 * Visit the set of preprocessor inclusions in a translation unit. The visitor function is called with the provided data for every included file. This does not include headers included by the PCH file (unless one is inspecting the inclusions in the PCH file itself).

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getInclusions(tu : CXTranslationUnit, visitor : CXInclusionVisitor, client_data : CXClientData): Unit = extern

/**
 * Given a CXFile header file, return the module that contains it, if one exists.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getModuleForFile(_0 : CXTranslationUnit, _1 : CXFile): CXModule = extern

/**
 * Retrieve the number of chunks in the given code-completion string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getNumCompletionChunks(completion_string : CXCompletionString): CUnsignedInt = extern

/**
 * Determine the number of diagnostics produced for the given translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getNumDiagnostics(Unit : CXTranslationUnit): CUnsignedInt = extern

/**
 * Determine the number of diagnostics in a CXDiagnosticSet.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
@extern def clang_getNumDiagnosticsInSet(Diags : CXDiagnosticSet): CUnsignedInt = extern

/**
 * Retrieve a remapping.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getRemappings(path : CString): CXRemapping = extern

/**
 * Retrieve a remapping.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getRemappingsFromFileList(filePaths : Ptr[CString], numFiles : CUnsignedInt): CXRemapping = extern

/**
 * Retrieve all ranges that were skipped by the preprocessor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getSkippedRanges(tu : CXTranslationUnit, file : CXFile): Ptr[CXSourceRangeList] = extern

/**
 * Returns the human-readable null-terminated C string that represents the name of the memory category. This string should never be freed.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getTUResourceUsageName(kind : CXTUResourceUsageKind): CString = extern

/**
 * Get target information for this translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_getTranslationUnitTargetInfo(CTUnit : CXTranslationUnit): CXTargetInfo = extern

/**
 * Index the given source file and the translation unit corresponding to that file via callbacks implemented through #IndexerCallbacks.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_indexSourceFile(_0 : CXIndexAction, client_data : CXClientData, index_callbacks : Ptr[IndexerCallbacks], index_callbacks_size : CUnsignedInt, index_options : CUnsignedInt, source_filename : CString, command_line_args : Ptr[CString], num_command_line_args : CInt, unsaved_files : Ptr[CXUnsavedFile], num_unsaved_files : CUnsignedInt, out_TU : Ptr[CXTranslationUnit], TU_options : CUnsignedInt): CInt = extern

/**
 * Same as clang_indexSourceFile but requires a full command line for command_line_args including argv[0]. This is useful if the standard library paths are relative to the binary.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_indexSourceFileFullArgv(_0 : CXIndexAction, client_data : CXClientData, index_callbacks : Ptr[IndexerCallbacks], index_callbacks_size : CUnsignedInt, index_options : CUnsignedInt, source_filename : CString, command_line_args : Ptr[CString], num_command_line_args : CInt, unsaved_files : Ptr[CXUnsavedFile], num_unsaved_files : CUnsignedInt, out_TU : Ptr[CXTranslationUnit], TU_options : CUnsignedInt): CInt = extern

/**
 * Index the given translation unit via callbacks implemented through #IndexerCallbacks.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_indexTranslationUnit(_0 : CXIndexAction, client_data : CXClientData, index_callbacks : Ptr[IndexerCallbacks], index_callbacks_size : CUnsignedInt, index_options : CUnsignedInt, _5 : CXTranslationUnit): CInt = extern

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_index_getCXXClassDeclInfo(_0 : Ptr[CXIdxDeclInfo]): Ptr[CXIdxCXXClassDeclInfo] = extern

/**
 * For retrieving a custom CXIdxClientContainer attached to a container.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_index_getClientContainer(_0 : Ptr[CXIdxContainerInfo]): CXIdxClientContainer = extern

/**
 * For retrieving a custom CXIdxClientEntity attached to an entity.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_index_getClientEntity(_0 : Ptr[CXIdxEntityInfo]): CXIdxClientEntity = extern

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_index_getIBOutletCollectionAttrInfo(_0 : Ptr[CXIdxAttrInfo]): Ptr[CXIdxIBOutletCollectionAttrInfo] = extern

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_index_getObjCCategoryDeclInfo(_0 : Ptr[CXIdxDeclInfo]): Ptr[CXIdxObjCCategoryDeclInfo] = extern

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_index_getObjCContainerDeclInfo(_0 : Ptr[CXIdxDeclInfo]): Ptr[CXIdxObjCContainerDeclInfo] = extern

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_index_getObjCInterfaceDeclInfo(_0 : Ptr[CXIdxDeclInfo]): Ptr[CXIdxObjCInterfaceDeclInfo] = extern

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_index_getObjCPropertyDeclInfo(_0 : Ptr[CXIdxDeclInfo]): Ptr[CXIdxObjCPropertyDeclInfo] = extern

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_index_getObjCProtocolRefListInfo(_0 : Ptr[CXIdxDeclInfo]): Ptr[CXIdxObjCProtocolRefListInfo] = extern

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_index_isEntityObjCContainerKind(_0 : CXIdxEntityKind): CInt = extern

/**
 * For setting a custom CXIdxClientContainer attached to a container.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_index_setClientContainer(_0 : Ptr[CXIdxContainerInfo], _1 : CXIdxClientContainer): Unit = extern

/**
 * For setting a custom CXIdxClientEntity attached to an entity.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_index_setClientEntity(_0 : Ptr[CXIdxEntityInfo], _1 : CXIdxClientEntity): Unit = extern

/**
 * Determine whether the given cursor kind represents an attribute.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_isAttribute(_0 : CXCursorKind): CUnsignedInt = extern

/**
 * Determine whether the given cursor kind represents a declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_isDeclaration(_0 : CXCursorKind): CUnsignedInt = extern

/**
 * Determine whether the given cursor kind represents an expression.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_isExpression(_0 : CXCursorKind): CUnsignedInt = extern

/**
 * Determine whether the given header is guarded against multiple inclusions, either with the conventional #ifndef/#define/#endif macro guards or with #pragma once.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_isFileMultipleIncludeGuarded(tu : CXTranslationUnit, file : CXFile): CUnsignedInt = extern

/**
 * Determine whether the given cursor kind represents an invalid cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_isInvalid(_0 : CXCursorKind): CUnsignedInt = extern

/**
 * * Determine whether the given cursor represents a preprocessing element, such as a preprocessor directive or macro instantiation.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_isPreprocessing(_0 : CXCursorKind): CUnsignedInt = extern

/**
 * Determine whether the given cursor kind represents a simple reference.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_isReference(_0 : CXCursorKind): CUnsignedInt = extern

/**
 * Determine whether the given cursor kind represents a statement.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_isStatement(_0 : CXCursorKind): CUnsignedInt = extern

/**
 * Determine whether the given cursor kind represents a translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_isTranslationUnit(_0 : CXCursorKind): CUnsignedInt = extern

/**
 * * Determine whether the given cursor represents a currently unexposed piece of the AST (e.g., CXCursor_UnexposedStmt).

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_isUnexposed(_0 : CXCursorKind): CUnsignedInt = extern

/**
 * Deserialize a set of diagnostics from a Clang diagnostics bitcode file.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
@extern def clang_loadDiagnostics(file : CString, error : Ptr[CXLoadDiag_Error], errorString : Ptr[CXString]): CXDiagnosticSet = extern

/**
 * Same as clang_parseTranslationUnit2, but returns the CXTranslationUnit instead of an error code. In case of an error this routine returns a NULL CXTranslationUnit, without further detailed error codes.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_parseTranslationUnit(CIdx : CXIndex, source_filename : CString, command_line_args : Ptr[CString], num_command_line_args : CInt, unsaved_files : Ptr[CXUnsavedFile], num_unsaved_files : CUnsignedInt, options : CUnsignedInt): CXTranslationUnit = extern

/**
 * Parse the given source file and the translation unit corresponding to that file.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_parseTranslationUnit2(CIdx : CXIndex, source_filename : CString, command_line_args : Ptr[CString], num_command_line_args : CInt, unsaved_files : Ptr[CXUnsavedFile], num_unsaved_files : CUnsignedInt, options : CUnsignedInt, out_TU : Ptr[CXTranslationUnit]): CXErrorCode = extern

/**
 * Same as clang_parseTranslationUnit2 but requires a full command line for command_line_args including argv[0]. This is useful if the standard library paths are relative to the binary.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_parseTranslationUnit2FullArgv(CIdx : CXIndex, source_filename : CString, command_line_args : Ptr[CString], num_command_line_args : CInt, unsaved_files : Ptr[CXUnsavedFile], num_unsaved_files : CUnsignedInt, options : CUnsignedInt, out_TU : Ptr[CXTranslationUnit]): CXErrorCode = extern

/**
 * Dispose the remapping.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_remap_dispose(_0 : CXRemapping): Unit = extern

/**
 * Get the original and the associated filename from the remapping.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_remap_getFilenames(_0 : CXRemapping, index : CUnsignedInt, original : Ptr[CXString], transformed : Ptr[CXString]): Unit = extern

/**
 * Determine the number of remappings.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_remap_getNumFiles(_0 : CXRemapping): CUnsignedInt = extern

/**
 * Reparse the source files that produced this translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_reparseTranslationUnit(TU : CXTranslationUnit, num_unsaved_files : CUnsignedInt, unsaved_files : Ptr[CXUnsavedFile], options : CUnsignedInt): CInt = extern

/**
 * Saves a translation unit into a serialized representation of that translation unit on disk.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_saveTranslationUnit(TU : CXTranslationUnit, FileName : CString, options : CUnsignedInt): CInt = extern

/**
 * Sort the code-completion results in case-insensitive alphabetical order.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_sortCodeCompletionResults(Results : Ptr[CXCompletionResult], NumResults : CUnsignedInt): Unit = extern

/**
 * Suspend a translation unit in order to free memory associated with it.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_suspendTranslationUnit(_0 : CXTranslationUnit): CUnsignedInt = extern

/**
 * Enable/disable crash recovery.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
@extern def clang_toggleCrashRecovery(isEnabled : CUnsignedInt): Unit = extern

/**
 * Queries a CXCursorSet to see if it contains a specific CXCursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXCursorSet_contains(cset : CXCursorSet, cursor : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_CXCursorSet_contains(cset, (__ptr_0 + 0))

/**
 * Queries a CXCursorSet to see if it contains a specific CXCursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXCursorSet_contains(cset : CXCursorSet, cursor : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXCursorSet_contains(cset, cursor)

/**
 * Inserts a CXCursor into a CXCursorSet.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXCursorSet_insert(cset : CXCursorSet, cursor : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_CXCursorSet_insert(cset, (__ptr_0 + 0))

/**
 * Inserts a CXCursor into a CXCursorSet.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXCursorSet_insert(cset : CXCursorSet, cursor : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXCursorSet_insert(cset, cursor)

/**
 * Determine if a C++ constructor is a converting constructor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXConstructor_isConvertingConstructor(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXConstructor_isConvertingConstructor((__ptr_0 + 0))

/**
 * Determine if a C++ constructor is a converting constructor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXConstructor_isConvertingConstructor(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXConstructor_isConvertingConstructor(C)

/**
 * Determine if a C++ constructor is a copy constructor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXConstructor_isCopyConstructor(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXConstructor_isCopyConstructor(C)

/**
 * Determine if a C++ constructor is a copy constructor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXConstructor_isCopyConstructor(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXConstructor_isCopyConstructor((__ptr_0 + 0))

/**
 * Determine if a C++ constructor is the default constructor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXConstructor_isDefaultConstructor(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXConstructor_isDefaultConstructor((__ptr_0 + 0))

/**
 * Determine if a C++ constructor is the default constructor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXConstructor_isDefaultConstructor(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXConstructor_isDefaultConstructor(C)

/**
 * Determine if a C++ constructor is a move constructor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXConstructor_isMoveConstructor(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXConstructor_isMoveConstructor(C)

/**
 * Determine if a C++ constructor is a move constructor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXConstructor_isMoveConstructor(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXConstructor_isMoveConstructor((__ptr_0 + 0))

/**
 * Determine if a C++ field is declared 'mutable'.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXField_isMutable(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXField_isMutable((__ptr_0 + 0))

/**
 * Determine if a C++ field is declared 'mutable'.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXField_isMutable(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXField_isMutable(C)

/**
 * Determine if a C++ member function or member function template is declared 'const'.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isConst(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXMethod_isConst(C)

/**
 * Determine if a C++ member function or member function template is declared 'const'.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isConst(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXMethod_isConst((__ptr_0 + 0))

/**
 * Determine if a C++ member function is a copy-assignment operator, returning 1 if such is the case and 0 otherwise.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isCopyAssignmentOperator(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXMethod_isCopyAssignmentOperator((__ptr_0 + 0))

/**
 * Determine if a C++ member function is a copy-assignment operator, returning 1 if such is the case and 0 otherwise.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isCopyAssignmentOperator(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXMethod_isCopyAssignmentOperator(C)

/**
 * Determine if a C++ method is declared '= default'.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isDefaulted(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXMethod_isDefaulted((__ptr_0 + 0))

/**
 * Determine if a C++ method is declared '= default'.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isDefaulted(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXMethod_isDefaulted(C)

/**
 * Determine if a C++ method is declared '= delete'.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isDeleted(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXMethod_isDeleted((__ptr_0 + 0))

/**
 * Determine if a C++ method is declared '= delete'.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isDeleted(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXMethod_isDeleted(C)

/**
 * Determines if a C++ constructor or conversion function was declared explicit, returning 1 if such is the case and 0 otherwise.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isExplicit(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXMethod_isExplicit((__ptr_0 + 0))

/**
 * Determines if a C++ constructor or conversion function was declared explicit, returning 1 if such is the case and 0 otherwise.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isExplicit(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXMethod_isExplicit(C)

/**
 * Determine if a C++ member function is a move-assignment operator, returning 1 if such is the case and 0 otherwise.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isMoveAssignmentOperator(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXMethod_isMoveAssignmentOperator(C)

/**
 * Determine if a C++ member function is a move-assignment operator, returning 1 if such is the case and 0 otherwise.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isMoveAssignmentOperator(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXMethod_isMoveAssignmentOperator((__ptr_0 + 0))

/**
 * Determine if a C++ member function or member function template is pure virtual.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isPureVirtual(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXMethod_isPureVirtual(C)

/**
 * Determine if a C++ member function or member function template is pure virtual.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isPureVirtual(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXMethod_isPureVirtual((__ptr_0 + 0))

/**
 * Determine if a C++ member function or member function template is declared 'static'.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isStatic(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXMethod_isStatic(C)

/**
 * Determine if a C++ member function or member function template is declared 'static'.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isStatic(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXMethod_isStatic((__ptr_0 + 0))

/**
 * Determine if a C++ member function or member function template is explicitly declared 'virtual' or if it overrides a virtual method from one of the base classes.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isVirtual(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXMethod_isVirtual(C)

/**
 * Determine if a C++ member function or member function template is explicitly declared 'virtual' or if it overrides a virtual method from one of the base classes.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXMethod_isVirtual(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXMethod_isVirtual((__ptr_0 + 0))

/**
 * Determine if a C++ record is abstract, i.e. whether a class or struct has a pure virtual member function.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXRecord_isAbstract(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_CXXRecord_isAbstract((__ptr_0 + 0))

/**
 * Determine if a C++ record is abstract, i.e. whether a class or struct has a pure virtual member function.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_CXXRecord_isAbstract(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_CXXRecord_isAbstract(C)

/**
 * If cursor is a statement declaration tries to evaluate the statement and if its variable, tries to evaluate its initializer, into its corresponding type. If it's an expression, tries to evaluate the expression.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_Evaluate(C : CXCursor)(using Zone): CXEvalResult = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_Evaluate((__ptr_0 + 0))

/**
 * If cursor is a statement declaration tries to evaluate the statement and if its variable, tries to evaluate its initializer, into its corresponding type. If it's an expression, tries to evaluate the expression.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_Evaluate(C : Ptr[CXCursor]): CXEvalResult = 
  __sn_wrap_libclang_clang_Cursor_Evaluate(C)

/**
 * Retrieve the argument cursor of a function or method.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getArgument(C : CXCursor, i : CUnsignedInt)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getArgument((__ptr_0 + 0), i, (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Retrieve the argument cursor of a function or method.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getArgument(C : Ptr[CXCursor], i : CUnsignedInt)(__return : Ptr[CXCursor]): Unit = 
  __sn_wrap_libclang_clang_Cursor_getArgument(C, i, __return)

/**
 * Retrieve the argument cursor of a function or method.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getArgument(C : Ptr[CXCursor], i : CUnsignedInt)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_Cursor_getArgument(C, i, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Returns the operator code for the binary operator.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getBinaryOpcode(C : CXCursor)(using Zone): CX_BinaryOperatorKind = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getBinaryOpcode((__ptr_0 + 0))

/**
 * Returns the operator code for the binary operator.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getBinaryOpcode(C : Ptr[CXCursor]): CX_BinaryOperatorKind = 
  __sn_wrap_libclang_clang_Cursor_getBinaryOpcode(C)

/**
 * Returns a string containing the spelling of the binary operator.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getBinaryOpcodeStr(Op : CX_BinaryOperatorKind)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Cursor_getBinaryOpcodeStr(Op, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Returns a string containing the spelling of the binary operator.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getBinaryOpcodeStr(Op : CX_BinaryOperatorKind)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_Cursor_getBinaryOpcodeStr(Op, __return)

/**
 * Given a cursor that represents a documentable entity (e.g., declaration), return the associated first paragraph.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getBriefCommentText(C : Ptr[CXCursor])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Cursor_getBriefCommentText(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Given a cursor that represents a documentable entity (e.g., declaration), return the associated first paragraph.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getBriefCommentText(C : CXCursor)(using Zone): CXString = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getBriefCommentText((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Given a cursor that represents a documentable entity (e.g., declaration), return the associated first paragraph.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getBriefCommentText(C : Ptr[CXCursor])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_Cursor_getBriefCommentText(C, __return)

/**
 * Retrieve the CXStrings representing the mangled symbols of the C++ constructor or destructor at the cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getCXXManglings(_0 : Ptr[CXCursor]): Ptr[CXStringSet] = 
  __sn_wrap_libclang_clang_Cursor_getCXXManglings(_0)

/**
 * Retrieve the CXStrings representing the mangled symbols of the C++ constructor or destructor at the cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getCXXManglings(_0 : CXCursor)(using Zone): Ptr[CXStringSet] = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_Cursor_getCXXManglings((__ptr_0 + 0))

/**
 * Given a cursor that represents a declaration, return the associated comment's source range. The range may include multiple consecutive comments with whitespace in between.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getCommentRange(C : Ptr[CXCursor])(__return : Ptr[CXSourceRange]): Unit = 
  __sn_wrap_libclang_clang_Cursor_getCommentRange(C, __return)

/**
 * Given a cursor that represents a declaration, return the associated comment's source range. The range may include multiple consecutive comments with whitespace in between.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getCommentRange(C : Ptr[CXCursor])(using Zone): CXSourceRange = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_Cursor_getCommentRange(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Given a cursor that represents a declaration, return the associated comment's source range. The range may include multiple consecutive comments with whitespace in between.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getCommentRange(C : CXCursor)(using Zone): CXSourceRange = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getCommentRange((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the CXString representing the mangled name of the cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getMangling(_0 : Ptr[CXCursor])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Cursor_getMangling(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the CXString representing the mangled name of the cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getMangling(_0 : Ptr[CXCursor])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_Cursor_getMangling(_0, __return)

/**
 * Retrieve the CXString representing the mangled name of the cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getMangling(_0 : CXCursor)(using Zone): CXString = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_Cursor_getMangling((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Given a CXCursor_ModuleImportDecl cursor, return the associated module.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getModule(C : CXCursor)(using Zone): CXModule = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getModule((__ptr_0 + 0))

/**
 * Given a CXCursor_ModuleImportDecl cursor, return the associated module.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getModule(C : Ptr[CXCursor]): CXModule = 
  __sn_wrap_libclang_clang_Cursor_getModule(C)

/**
 * Retrieve the number of non-variadic arguments associated with a given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getNumArguments(C : Ptr[CXCursor]): CInt = 
  __sn_wrap_libclang_clang_Cursor_getNumArguments(C)

/**
 * Retrieve the number of non-variadic arguments associated with a given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getNumArguments(C : CXCursor)(using Zone): CInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getNumArguments((__ptr_0 + 0))

/**
 * Returns the number of template args of a function, struct, or class decl representing a template specialization.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getNumTemplateArguments(C : Ptr[CXCursor]): CInt = 
  __sn_wrap_libclang_clang_Cursor_getNumTemplateArguments(C)

/**
 * Returns the number of template args of a function, struct, or class decl representing a template specialization.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getNumTemplateArguments(C : CXCursor)(using Zone): CInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getNumTemplateArguments((__ptr_0 + 0))

/**
 * Given a cursor that represents an Objective-C method or parameter declaration, return the associated Objective-C qualifiers for the return type or the parameter respectively. The bits are formed from CXObjCDeclQualifierKind.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getObjCDeclQualifiers(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Cursor_getObjCDeclQualifiers(C)

/**
 * Given a cursor that represents an Objective-C method or parameter declaration, return the associated Objective-C qualifiers for the return type or the parameter respectively. The bits are formed from CXObjCDeclQualifierKind.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getObjCDeclQualifiers(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getObjCDeclQualifiers((__ptr_0 + 0))

/**
 * Retrieve the CXStrings representing the mangled symbols of the ObjC class interface or implementation at the cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getObjCManglings(_0 : CXCursor)(using Zone): Ptr[CXStringSet] = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_Cursor_getObjCManglings((__ptr_0 + 0))

/**
 * Retrieve the CXStrings representing the mangled symbols of the ObjC class interface or implementation at the cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getObjCManglings(_0 : Ptr[CXCursor]): Ptr[CXStringSet] = 
  __sn_wrap_libclang_clang_Cursor_getObjCManglings(_0)

/**
 * Given a cursor that represents a property declaration, return the associated property attributes. The bits are formed from CXObjCPropertyAttrKind.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getObjCPropertyAttributes(C : Ptr[CXCursor], reserved : CUnsignedInt): CUnsignedInt = 
  __sn_wrap_libclang_clang_Cursor_getObjCPropertyAttributes(C, reserved)

/**
 * Given a cursor that represents a property declaration, return the associated property attributes. The bits are formed from CXObjCPropertyAttrKind.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getObjCPropertyAttributes(C : CXCursor, reserved : CUnsignedInt)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getObjCPropertyAttributes((__ptr_0 + 0), reserved)

/**
 * Given a cursor that represents a property declaration, return the name of the method that implements the getter.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getObjCPropertyGetterName(C : Ptr[CXCursor])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Cursor_getObjCPropertyGetterName(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Given a cursor that represents a property declaration, return the name of the method that implements the getter.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getObjCPropertyGetterName(C : Ptr[CXCursor])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_Cursor_getObjCPropertyGetterName(C, __return)

/**
 * Given a cursor that represents a property declaration, return the name of the method that implements the getter.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getObjCPropertyGetterName(C : CXCursor)(using Zone): CXString = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getObjCPropertyGetterName((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Given a cursor that represents a property declaration, return the name of the method that implements the setter, if any.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getObjCPropertySetterName(C : Ptr[CXCursor])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Cursor_getObjCPropertySetterName(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Given a cursor that represents a property declaration, return the name of the method that implements the setter, if any.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getObjCPropertySetterName(C : Ptr[CXCursor])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_Cursor_getObjCPropertySetterName(C, __return)

/**
 * Given a cursor that represents a property declaration, return the name of the method that implements the setter, if any.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getObjCPropertySetterName(C : CXCursor)(using Zone): CXString = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getObjCPropertySetterName((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * If the cursor points to a selector identifier in an Objective-C method or message expression, this returns the selector index.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getObjCSelectorIndex(_0 : CXCursor)(using Zone): CInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_Cursor_getObjCSelectorIndex((__ptr_0 + 0))

/**
 * If the cursor points to a selector identifier in an Objective-C method or message expression, this returns the selector index.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getObjCSelectorIndex(_0 : Ptr[CXCursor]): CInt = 
  __sn_wrap_libclang_clang_Cursor_getObjCSelectorIndex(_0)

/**
 * Return the offset of the field represented by the Cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getOffsetOfField(C : Ptr[CXCursor]): CLongLong = 
  __sn_wrap_libclang_clang_Cursor_getOffsetOfField(C)

/**
 * Return the offset of the field represented by the Cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getOffsetOfField(C : CXCursor)(using Zone): CLongLong = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getOffsetOfField((__ptr_0 + 0))

/**
 * Given a cursor that represents a declaration, return the associated comment text, including comment markers.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getRawCommentText(C : Ptr[CXCursor])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Cursor_getRawCommentText(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Given a cursor that represents a declaration, return the associated comment text, including comment markers.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getRawCommentText(C : Ptr[CXCursor])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_Cursor_getRawCommentText(C, __return)

/**
 * Given a cursor that represents a declaration, return the associated comment text, including comment markers.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getRawCommentText(C : CXCursor)(using Zone): CXString = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getRawCommentText((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Given a cursor pointing to an Objective-C message or property reference, or C++ method call, returns the CXType of the receiver.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getReceiverType(C : CXCursor)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getReceiverType((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Given a cursor pointing to an Objective-C message or property reference, or C++ method call, returns the CXType of the receiver.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getReceiverType(C : Ptr[CXCursor])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Cursor_getReceiverType(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Given a cursor pointing to an Objective-C message or property reference, or C++ method call, returns the CXType of the receiver.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getReceiverType(C : Ptr[CXCursor])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_Cursor_getReceiverType(C, __return)

/**
 * Retrieve a range for a piece that forms the cursors spelling name. Most of the times there is only one range for the complete spelling but for Objective-C methods and Objective-C message expressions, there are multiple pieces for each selector identifier.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getSpellingNameRange(_0 : Ptr[CXCursor], pieceIndex : CUnsignedInt, options : CUnsignedInt)(using Zone): CXSourceRange = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_Cursor_getSpellingNameRange(_0, pieceIndex, options, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a range for a piece that forms the cursors spelling name. Most of the times there is only one range for the complete spelling but for Objective-C methods and Objective-C message expressions, there are multiple pieces for each selector identifier.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getSpellingNameRange(_0 : Ptr[CXCursor], pieceIndex : CUnsignedInt, options : CUnsignedInt)(__return : Ptr[CXSourceRange]): Unit = 
  __sn_wrap_libclang_clang_Cursor_getSpellingNameRange(_0, pieceIndex, options, __return)

/**
 * Retrieve a range for a piece that forms the cursors spelling name. Most of the times there is only one range for the complete spelling but for Objective-C methods and Objective-C message expressions, there are multiple pieces for each selector identifier.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getSpellingNameRange(_0 : CXCursor, pieceIndex : CUnsignedInt, options : CUnsignedInt)(using Zone): CXSourceRange = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = _0
  __sn_wrap_libclang_clang_Cursor_getSpellingNameRange((__ptr_1 + 0), pieceIndex, options, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Returns the storage class for a function or variable declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getStorageClass(_0 : Ptr[CXCursor]): CX_StorageClass = 
  __sn_wrap_libclang_clang_Cursor_getStorageClass(_0)

/**
 * Returns the storage class for a function or variable declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getStorageClass(_0 : CXCursor)(using Zone): CX_StorageClass = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_Cursor_getStorageClass((__ptr_0 + 0))

/**
 * Retrieve the kind of the I'th template argument of the CXCursor C.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getTemplateArgumentKind(C : Ptr[CXCursor], I : CUnsignedInt): CXTemplateArgumentKind = 
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentKind(C, I)

/**
 * Retrieve the kind of the I'th template argument of the CXCursor C.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getTemplateArgumentKind(C : CXCursor, I : CUnsignedInt)(using Zone): CXTemplateArgumentKind = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentKind((__ptr_0 + 0), I)

/**
 * Retrieve a CXType representing the type of a TemplateArgument of a function decl representing a template specialization.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getTemplateArgumentType(C : Ptr[CXCursor], I : CUnsignedInt)(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentType(C, I, __return)

/**
 * Retrieve a CXType representing the type of a TemplateArgument of a function decl representing a template specialization.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getTemplateArgumentType(C : CXCursor, I : CUnsignedInt)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentType((__ptr_1 + 0), I, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a CXType representing the type of a TemplateArgument of a function decl representing a template specialization.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getTemplateArgumentType(C : Ptr[CXCursor], I : CUnsignedInt)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentType(C, I, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the value of an Integral TemplateArgument (of a function decl representing a template specialization) as an unsigned long long.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getTemplateArgumentUnsignedValue(C : Ptr[CXCursor], I : CUnsignedInt): CUnsignedLongLong = 
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentUnsignedValue(C, I)

/**
 * Retrieve the value of an Integral TemplateArgument (of a function decl representing a template specialization) as an unsigned long long.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getTemplateArgumentUnsignedValue(C : CXCursor, I : CUnsignedInt)(using Zone): CUnsignedLongLong = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentUnsignedValue((__ptr_0 + 0), I)

/**
 * Retrieve the value of an Integral TemplateArgument (of a function decl representing a template specialization) as a signed long long.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getTemplateArgumentValue(C : Ptr[CXCursor], I : CUnsignedInt): CLongLong = 
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentValue(C, I)

/**
 * Retrieve the value of an Integral TemplateArgument (of a function decl representing a template specialization) as a signed long long.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getTemplateArgumentValue(C : CXCursor, I : CUnsignedInt)(using Zone): CLongLong = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_getTemplateArgumentValue((__ptr_0 + 0), I)

/**
 * Returns the translation unit that a cursor originated from.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getTranslationUnit(_0 : Ptr[CXCursor]): CXTranslationUnit = 
  __sn_wrap_libclang_clang_Cursor_getTranslationUnit(_0)

/**
 * Returns the translation unit that a cursor originated from.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getTranslationUnit(_0 : CXCursor)(using Zone): CXTranslationUnit = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_Cursor_getTranslationUnit((__ptr_0 + 0))

/**
 * If cursor refers to a variable declaration and it has initializer returns cursor referring to the initializer otherwise return null cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getVarDeclInitializer(cursor : CXCursor)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_Cursor_getVarDeclInitializer((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * If cursor refers to a variable declaration and it has initializer returns cursor referring to the initializer otherwise return null cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getVarDeclInitializer(cursor : Ptr[CXCursor])(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_Cursor_getVarDeclInitializer(cursor, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * If cursor refers to a variable declaration and it has initializer returns cursor referring to the initializer otherwise return null cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_getVarDeclInitializer(cursor : Ptr[CXCursor])(__return : Ptr[CXCursor]): Unit = 
  __sn_wrap_libclang_clang_Cursor_getVarDeclInitializer(cursor, __return)

/**
 * Determine whether the given cursor has any attributes.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_hasAttrs(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_hasAttrs((__ptr_0 + 0))

/**
 * Determine whether the given cursor has any attributes.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_hasAttrs(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Cursor_hasAttrs(C)

/**
 * If cursor refers to a variable declaration that has external storage returns 1. If cursor refers to a variable declaration that doesn't have external storage returns 0. Otherwise returns -1.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_hasVarDeclExternalStorage(cursor : CXCursor)(using Zone): CInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_Cursor_hasVarDeclExternalStorage((__ptr_0 + 0))

/**
 * If cursor refers to a variable declaration that has external storage returns 1. If cursor refers to a variable declaration that doesn't have external storage returns 0. Otherwise returns -1.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_hasVarDeclExternalStorage(cursor : Ptr[CXCursor]): CInt = 
  __sn_wrap_libclang_clang_Cursor_hasVarDeclExternalStorage(cursor)

/**
 * If cursor refers to a variable declaration that has global storage returns 1. If cursor refers to a variable declaration that doesn't have global storage returns 0. Otherwise returns -1.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_hasVarDeclGlobalStorage(cursor : CXCursor)(using Zone): CInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_Cursor_hasVarDeclGlobalStorage((__ptr_0 + 0))

/**
 * If cursor refers to a variable declaration that has global storage returns 1. If cursor refers to a variable declaration that doesn't have global storage returns 0. Otherwise returns -1.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_hasVarDeclGlobalStorage(cursor : Ptr[CXCursor]): CInt = 
  __sn_wrap_libclang_clang_Cursor_hasVarDeclGlobalStorage(cursor)

/**
 * Determine whether the given cursor represents an anonymous tag or namespace

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isAnonymous(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isAnonymous((__ptr_0 + 0))

/**
 * Determine whether the given cursor represents an anonymous tag or namespace

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isAnonymous(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Cursor_isAnonymous(C)

/**
 * Determine whether the given cursor represents an anonymous record declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isAnonymousRecordDecl(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isAnonymousRecordDecl((__ptr_0 + 0))

/**
 * Determine whether the given cursor represents an anonymous record declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isAnonymousRecordDecl(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Cursor_isAnonymousRecordDecl(C)

/**
 * Returns non-zero if the cursor specifies a Record member that is a bit-field.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isBitField(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isBitField((__ptr_0 + 0))

/**
 * Returns non-zero if the cursor specifies a Record member that is a bit-field.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isBitField(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Cursor_isBitField(C)

/**
 * Given a cursor pointing to a C++ method call or an Objective-C message, returns non-zero if the method/message is "dynamic", meaning:

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isDynamicCall(C : Ptr[CXCursor]): CInt = 
  __sn_wrap_libclang_clang_Cursor_isDynamicCall(C)

/**
 * Given a cursor pointing to a C++ method call or an Objective-C message, returns non-zero if the method/message is "dynamic", meaning:

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isDynamicCall(C : CXCursor)(using Zone): CInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isDynamicCall((__ptr_0 + 0))

/**
 * Returns non-zero if the given cursor points to a symbol marked with external_source_symbol attribute.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isExternalSymbol(C : CXCursor, language : Ptr[CXString], definedIn : Ptr[CXString], isGenerated : Ptr[CUnsignedInt])(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isExternalSymbol((__ptr_0 + 0), language, definedIn, isGenerated)

/**
 * Returns non-zero if the given cursor points to a symbol marked with external_source_symbol attribute.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isExternalSymbol(C : Ptr[CXCursor], language : Ptr[CXString], definedIn : Ptr[CXString], isGenerated : Ptr[CUnsignedInt]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Cursor_isExternalSymbol(C, language, definedIn, isGenerated)

/**
 * Determine whether a CXCursor that is a function declaration, is an inline declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isFunctionInlined(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Cursor_isFunctionInlined(C)

/**
 * Determine whether a CXCursor that is a function declaration, is an inline declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isFunctionInlined(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isFunctionInlined((__ptr_0 + 0))

/**
 * Determine whether the given cursor represents an inline namespace declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isInlineNamespace(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isInlineNamespace((__ptr_0 + 0))

/**
 * Determine whether the given cursor represents an inline namespace declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isInlineNamespace(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Cursor_isInlineNamespace(C)

/**
 * Determine whether a CXCursor that is a macro, is a builtin one.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isMacroBuiltin(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Cursor_isMacroBuiltin(C)

/**
 * Determine whether a CXCursor that is a macro, is a builtin one.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isMacroBuiltin(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isMacroBuiltin((__ptr_0 + 0))

/**
 * Determine whether a CXCursor that is a macro, is function like.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isMacroFunctionLike(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isMacroFunctionLike((__ptr_0 + 0))

/**
 * Determine whether a CXCursor that is a macro, is function like.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isMacroFunctionLike(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Cursor_isMacroFunctionLike(C)

/**
 * Returns non-zero if cursor is null.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isNull(cursor : CXCursor)(using Zone): CInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_Cursor_isNull((__ptr_0 + 0))

/**
 * Returns non-zero if cursor is null.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isNull(cursor : Ptr[CXCursor]): CInt = 
  __sn_wrap_libclang_clang_Cursor_isNull(cursor)

/**
 * Given a cursor that represents an Objective-C method or property declaration, return non-zero if the declaration was affected by "\@optional". Returns zero if the cursor is not such a declaration or it is "\@required".

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isObjCOptional(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isObjCOptional((__ptr_0 + 0))

/**
 * Given a cursor that represents an Objective-C method or property declaration, return non-zero if the declaration was affected by "\@optional". Returns zero if the cursor is not such a declaration or it is "\@required".

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isObjCOptional(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Cursor_isObjCOptional(C)

/**
 * Returns non-zero if the given cursor is a variadic function or method.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isVariadic(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Cursor_isVariadic(C)

/**
 * Returns non-zero if the given cursor is a variadic function or method.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Cursor_isVariadic(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_Cursor_isVariadic((__ptr_0 + 0))

/**
 * Determine if an enum declaration refers to a scoped enum.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_EnumDecl_isScoped(C : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_EnumDecl_isScoped((__ptr_0 + 0))

/**
 * Determine if an enum declaration refers to a scoped enum.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_EnumDecl_isScoped(C : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_EnumDecl_isScoped(C)

/**
 * Returns the real path name of file.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXFile.h
*/
def clang_File_tryGetRealPathName(file : CXFile)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_File_tryGetRealPathName(file, __return)

/**
 * Returns the real path name of file.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXFile.h
*/
def clang_File_tryGetRealPathName(file : CXFile)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_File_tryGetRealPathName(file, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Returns non-zero if the given source location is in the main file of the corresponding translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_Location_isFromMainFile(location : CXSourceLocation)(using Zone): CInt = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = location
  __sn_wrap_libclang_clang_Location_isFromMainFile((__ptr_0 + 0))

/**
 * Returns non-zero if the given source location is in the main file of the corresponding translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_Location_isFromMainFile(location : Ptr[CXSourceLocation]): CInt = 
  __sn_wrap_libclang_clang_Location_isFromMainFile(location)

/**
 * Returns non-zero if the given source location is in a system header.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_Location_isInSystemHeader(location : CXSourceLocation)(using Zone): CInt = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = location
  __sn_wrap_libclang_clang_Location_isInSystemHeader((__ptr_0 + 0))

/**
 * Returns non-zero if the given source location is in a system header.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_Location_isInSystemHeader(location : Ptr[CXSourceLocation]): CInt = 
  __sn_wrap_libclang_clang_Location_isInSystemHeader(location)

/**
 * Returns the full name of the module, e.g. "std.vector".

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Module_getFullName(Module : CXModule)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Module_getFullName(Module, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Returns the full name of the module, e.g. "std.vector".

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Module_getFullName(Module : CXModule)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_Module_getFullName(Module, __return)

/**
 * Returns the name of the module, e.g. for the 'std.vector' sub-module it will return "vector".

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Module_getName(Module : CXModule)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Module_getName(Module, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Returns the name of the module, e.g. for the 'std.vector' sub-module it will return "vector".

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Module_getName(Module : CXModule)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_Module_getName(Module, __return)

/**
 * Returns non-zero if range is null.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_Range_isNull(range : CXSourceRange)(using Zone): CInt = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  !(__ptr_0 + 0) = range
  __sn_wrap_libclang_clang_Range_isNull((__ptr_0 + 0))

/**
 * Returns non-zero if range is null.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_Range_isNull(range : Ptr[CXSourceRange]): CInt = 
  __sn_wrap_libclang_clang_Range_isNull(range)

/**
 * Get the normalized target triple as a string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_TargetInfo_getTriple(Info : CXTargetInfo)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_TargetInfo_getTriple(Info, __return)

/**
 * Get the normalized target triple as a string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_TargetInfo_getTriple(Info : CXTargetInfo)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_TargetInfo_getTriple(Info, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Return the alignment of a type in bytes as per C++[expr.alignof] standard.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getAlignOf(T : Ptr[CXType]): CLongLong = 
  __sn_wrap_libclang_clang_Type_getAlignOf(T)

/**
 * Return the alignment of a type in bytes as per C++[expr.alignof] standard.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getAlignOf(T : CXType)(using Zone): CLongLong = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getAlignOf((__ptr_0 + 0))

/**
 * Retrieve the ref-qualifier kind of a function or method.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getCXXRefQualifier(T : CXType)(using Zone): CXRefQualifierKind = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getCXXRefQualifier((__ptr_0 + 0))

/**
 * Retrieve the ref-qualifier kind of a function or method.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getCXXRefQualifier(T : Ptr[CXType]): CXRefQualifierKind = 
  __sn_wrap_libclang_clang_Type_getCXXRefQualifier(T)

/**
 * Return the class type of an member pointer type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getClassType(T : Ptr[CXType])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Type_getClassType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Return the class type of an member pointer type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getClassType(T : Ptr[CXType])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_Type_getClassType(T, __return)

/**
 * Return the class type of an member pointer type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getClassType(T : CXType)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getClassType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Return the type that was modified by this attributed type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getModifiedType(T : Ptr[CXType])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_Type_getModifiedType(T, __return)

/**
 * Return the type that was modified by this attributed type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getModifiedType(T : Ptr[CXType])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Type_getModifiedType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Return the type that was modified by this attributed type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getModifiedType(T : CXType)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getModifiedType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Retrieve the type named by the qualified-id.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getNamedType(T : Ptr[CXType])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Type_getNamedType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the type named by the qualified-id.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getNamedType(T : CXType)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getNamedType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Retrieve the type named by the qualified-id.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getNamedType(T : Ptr[CXType])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_Type_getNamedType(T, __return)

/**
 * Retrieve the nullability kind of a pointer type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getNullability(T : Ptr[CXType]): CXTypeNullabilityKind = 
  __sn_wrap_libclang_clang_Type_getNullability(T)

/**
 * Retrieve the nullability kind of a pointer type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getNullability(T : CXType)(using Zone): CXTypeNullabilityKind = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getNullability((__ptr_0 + 0))

/**
 * Retrieve the number of protocol references associated with an ObjC object/id.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getNumObjCProtocolRefs(T : Ptr[CXType]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Type_getNumObjCProtocolRefs(T)

/**
 * Retrieve the number of protocol references associated with an ObjC object/id.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getNumObjCProtocolRefs(T : CXType)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getNumObjCProtocolRefs((__ptr_0 + 0))

/**
 * Retrieve the number of type arguments associated with an ObjC object.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getNumObjCTypeArgs(T : Ptr[CXType]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Type_getNumObjCTypeArgs(T)

/**
 * Retrieve the number of type arguments associated with an ObjC object.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getNumObjCTypeArgs(T : CXType)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getNumObjCTypeArgs((__ptr_0 + 0))

/**
 * Returns the number of template arguments for given template specialization, or -1 if type T is not a template specialization.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getNumTemplateArguments(T : Ptr[CXType]): CInt = 
  __sn_wrap_libclang_clang_Type_getNumTemplateArguments(T)

/**
 * Returns the number of template arguments for given template specialization, or -1 if type T is not a template specialization.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getNumTemplateArguments(T : CXType)(using Zone): CInt = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getNumTemplateArguments((__ptr_0 + 0))

/**
 * Returns the Objective-C type encoding for the specified CXType.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getObjCEncoding(`type` : Ptr[CXType])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_Type_getObjCEncoding(`type`, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Returns the Objective-C type encoding for the specified CXType.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getObjCEncoding(`type` : CXType)(using Zone): CXString = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  val __ptr_1: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = `type`
  __sn_wrap_libclang_clang_Type_getObjCEncoding((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Returns the Objective-C type encoding for the specified CXType.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getObjCEncoding(`type` : Ptr[CXType])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_Type_getObjCEncoding(`type`, __return)

/**
 * Retrieves the base type of the ObjCObjectType.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getObjCObjectBaseType(T : Ptr[CXType])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_Type_getObjCObjectBaseType(T, __return)

/**
 * Retrieves the base type of the ObjCObjectType.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getObjCObjectBaseType(T : CXType)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getObjCObjectBaseType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Retrieves the base type of the ObjCObjectType.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getObjCObjectBaseType(T : Ptr[CXType])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Type_getObjCObjectBaseType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the decl for a protocol reference for an ObjC object/id.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getObjCProtocolDecl(T : CXType, i : CUnsignedInt)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getObjCProtocolDecl((__ptr_0 + 0), i, (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Retrieve the decl for a protocol reference for an ObjC object/id.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getObjCProtocolDecl(T : Ptr[CXType], i : CUnsignedInt)(__return : Ptr[CXCursor]): Unit = 
  __sn_wrap_libclang_clang_Type_getObjCProtocolDecl(T, i, __return)

/**
 * Retrieve the decl for a protocol reference for an ObjC object/id.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getObjCProtocolDecl(T : Ptr[CXType], i : CUnsignedInt)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_Type_getObjCProtocolDecl(T, i, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a type argument associated with an ObjC object.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getObjCTypeArg(T : Ptr[CXType], i : CUnsignedInt)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Type_getObjCTypeArg(T, i, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a type argument associated with an ObjC object.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getObjCTypeArg(T : CXType, i : CUnsignedInt)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getObjCTypeArg((__ptr_0 + 0), i, (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Retrieve a type argument associated with an ObjC object.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getObjCTypeArg(T : Ptr[CXType], i : CUnsignedInt)(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_Type_getObjCTypeArg(T, i, __return)

/**
 * Return the offset of a field named S in a record of type T in bits as it would be returned by __offsetof__ as per C++11[18.2p4]

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getOffsetOf(T : CXType, S : CString)(using Zone): CLongLong = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getOffsetOf((__ptr_0 + 0), S)

/**
 * Return the offset of a field named S in a record of type T in bits as it would be returned by __offsetof__ as per C++11[18.2p4]

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getOffsetOf(T : Ptr[CXType], S : CString): CLongLong = 
  __sn_wrap_libclang_clang_Type_getOffsetOf(T, S)

/**
 * Return the size of a type in bytes as per C++[expr.sizeof] standard.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getSizeOf(T : CXType)(using Zone): CLongLong = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getSizeOf((__ptr_0 + 0))

/**
 * Return the size of a type in bytes as per C++[expr.sizeof] standard.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getSizeOf(T : Ptr[CXType]): CLongLong = 
  __sn_wrap_libclang_clang_Type_getSizeOf(T)

/**
 * Returns the type template argument of a template class specialization at given index.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getTemplateArgumentAsType(T : CXType, i : CUnsignedInt)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_getTemplateArgumentAsType((__ptr_0 + 0), i, (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Returns the type template argument of a template class specialization at given index.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getTemplateArgumentAsType(T : Ptr[CXType], i : CUnsignedInt)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Type_getTemplateArgumentAsType(T, i, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Returns the type template argument of a template class specialization at given index.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getTemplateArgumentAsType(T : Ptr[CXType], i : CUnsignedInt)(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_Type_getTemplateArgumentAsType(T, i, __return)

/**
 * Gets the type contained by this atomic type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getValueType(CT : Ptr[CXType])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_Type_getValueType(CT, __return)

/**
 * Gets the type contained by this atomic type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getValueType(CT : CXType)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = CT
  __sn_wrap_libclang_clang_Type_getValueType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Gets the type contained by this atomic type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_getValueType(CT : Ptr[CXType])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_Type_getValueType(CT, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Determine if a typedef is 'transparent' tag.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_isTransparentTagTypedef(T : CXType)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_isTransparentTagTypedef((__ptr_0 + 0))

/**
 * Determine if a typedef is 'transparent' tag.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_isTransparentTagTypedef(T : Ptr[CXType]): CUnsignedInt = 
  __sn_wrap_libclang_clang_Type_isTransparentTagTypedef(T)

/**
 * Visit the fields of a particular type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_visitFields(T : Ptr[CXType], visitor : CXFieldVisitor, client_data : CXClientData): CUnsignedInt = 
  __sn_wrap_libclang_clang_Type_visitFields(T, visitor, client_data)

/**
 * Visit the fields of a particular type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_Type_visitFields(T : CXType, visitor : CXFieldVisitor, client_data : CXClientData)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_Type_visitFields((__ptr_0 + 0), visitor, client_data)

/**
 * Returns the USR for the container for the current code completion context. If there is not a container for the current context, this function will return the empty string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_codeCompleteGetContainerUSR(Results : Ptr[CXCodeCompleteResults])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_codeCompleteGetContainerUSR(Results, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Returns the USR for the container for the current code completion context. If there is not a container for the current context, this function will return the empty string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_codeCompleteGetContainerUSR(Results : Ptr[CXCodeCompleteResults])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_codeCompleteGetContainerUSR(Results, __return)

/**
 * Returns the currently-entered selector for an Objective-C message send, formatted like "initWithFoo:bar:". Only guaranteed to return a non-empty string for CXCompletionContext_ObjCInstanceMessage and CXCompletionContext_ObjCClassMessage.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_codeCompleteGetObjCSelector(Results : Ptr[CXCodeCompleteResults])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_codeCompleteGetObjCSelector(Results, __return)

/**
 * Returns the currently-entered selector for an Objective-C message send, formatted like "initWithFoo:bar:". Only guaranteed to return a non-empty string for CXCompletionContext_ObjCInstanceMessage and CXCompletionContext_ObjCClassMessage.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_codeCompleteGetObjCSelector(Results : Ptr[CXCodeCompleteResults])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_codeCompleteGetObjCSelector(Results, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Construct a USR for a specified Objective-C category.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCCategory(class_name : CString, category_name : CString)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_constructUSR_ObjCCategory(class_name, category_name, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Construct a USR for a specified Objective-C category.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCCategory(class_name : CString, category_name : CString)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_constructUSR_ObjCCategory(class_name, category_name, __return)

/**
 * Construct a USR for a specified Objective-C class.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCClass(class_name : CString)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_constructUSR_ObjCClass(class_name, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Construct a USR for a specified Objective-C class.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCClass(class_name : CString)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_constructUSR_ObjCClass(class_name, __return)

/**
 * Construct a USR for a specified Objective-C instance variable and the USR for its containing class.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCIvar(name : CString, classUSR : Ptr[CXString])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_constructUSR_ObjCIvar(name, classUSR, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Construct a USR for a specified Objective-C instance variable and the USR for its containing class.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCIvar(name : CString, classUSR : Ptr[CXString])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_constructUSR_ObjCIvar(name, classUSR, __return)

/**
 * Construct a USR for a specified Objective-C instance variable and the USR for its containing class.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCIvar(name : CString, classUSR : CXString)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](2)
  !(__ptr_0 + 0) = classUSR
  __sn_wrap_libclang_clang_constructUSR_ObjCIvar(name, (__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Construct a USR for a specified Objective-C method and the USR for its containing class.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCMethod(name : CString, isInstanceMethod : CUnsignedInt, classUSR : Ptr[CXString])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_constructUSR_ObjCMethod(name, isInstanceMethod, classUSR, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Construct a USR for a specified Objective-C method and the USR for its containing class.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCMethod(name : CString, isInstanceMethod : CUnsignedInt, classUSR : CXString)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](2)
  !(__ptr_0 + 0) = classUSR
  __sn_wrap_libclang_clang_constructUSR_ObjCMethod(name, isInstanceMethod, (__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Construct a USR for a specified Objective-C method and the USR for its containing class.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCMethod(name : CString, isInstanceMethod : CUnsignedInt, classUSR : Ptr[CXString])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_constructUSR_ObjCMethod(name, isInstanceMethod, classUSR, __return)

/**
 * Construct a USR for a specified Objective-C property and the USR for its containing class.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCProperty(property : CString, classUSR : Ptr[CXString])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_constructUSR_ObjCProperty(property, classUSR, __return)

/**
 * Construct a USR for a specified Objective-C property and the USR for its containing class.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCProperty(property : CString, classUSR : CXString)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](2)
  !(__ptr_0 + 0) = classUSR
  __sn_wrap_libclang_clang_constructUSR_ObjCProperty(property, (__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Construct a USR for a specified Objective-C property and the USR for its containing class.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCProperty(property : CString, classUSR : Ptr[CXString])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_constructUSR_ObjCProperty(property, classUSR, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Construct a USR for a specified Objective-C protocol.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCProtocol(protocol_name : CString)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_constructUSR_ObjCProtocol(protocol_name, __return)

/**
 * Construct a USR for a specified Objective-C protocol.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_constructUSR_ObjCProtocol(protocol_name : CString)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_constructUSR_ObjCProtocol(protocol_name, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_disposeCXTUResourceUsage(usage : Ptr[CXTUResourceUsage]): Unit = 
  __sn_wrap_libclang_clang_disposeCXTUResourceUsage(usage)

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_disposeCXTUResourceUsage(usage : CXTUResourceUsage)(using Zone): Unit = 
  val __ptr_0: Ptr[CXTUResourceUsage] = alloc[CXTUResourceUsage](1)
  !(__ptr_0 + 0) = usage
  __sn_wrap_libclang_clang_disposeCXTUResourceUsage((__ptr_0 + 0))

/**
 * Free the given string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXString.h
*/
def clang_disposeString(string : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_disposeString(string)

/**
 * Free the given string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXString.h
*/
def clang_disposeString(string : CXString)(using Zone): Unit = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = string
  __sn_wrap_libclang_clang_disposeString((__ptr_0 + 0))

/**
 * Determine whether two cursors are equivalent.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_equalCursors(_0 : Ptr[CXCursor], _1 : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_equalCursors(_0, _1)

/**
 * Determine whether two cursors are equivalent.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_equalCursors(_0 : CXCursor, _1 : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = _0
  !(__ptr_0 + 1) = _1
  __sn_wrap_libclang_clang_equalCursors((__ptr_0 + 0), (__ptr_0 + 1))

/**
 * Determine whether two source locations, which must refer into the same translation unit, refer to exactly the same point in the source code.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_equalLocations(loc1 : Ptr[CXSourceLocation], loc2 : Ptr[CXSourceLocation]): CUnsignedInt = 
  __sn_wrap_libclang_clang_equalLocations(loc1, loc2)

/**
 * Determine whether two source locations, which must refer into the same translation unit, refer to exactly the same point in the source code.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_equalLocations(loc1 : CXSourceLocation, loc2 : CXSourceLocation)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](2)
  !(__ptr_0 + 0) = loc1
  !(__ptr_0 + 1) = loc2
  __sn_wrap_libclang_clang_equalLocations((__ptr_0 + 0), (__ptr_0 + 1))

/**
 * Determine whether two ranges are equivalent.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_equalRanges(range1 : Ptr[CXSourceRange], range2 : Ptr[CXSourceRange]): CUnsignedInt = 
  __sn_wrap_libclang_clang_equalRanges(range1, range2)

/**
 * Determine whether two ranges are equivalent.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_equalRanges(range1 : CXSourceRange, range2 : CXSourceRange)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](2)
  !(__ptr_0 + 0) = range1
  !(__ptr_0 + 1) = range2
  __sn_wrap_libclang_clang_equalRanges((__ptr_0 + 0), (__ptr_0 + 1))

/**
 * Determine whether two CXTypes represent the same type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_equalTypes(A : Ptr[CXType], B : Ptr[CXType]): CUnsignedInt = 
  __sn_wrap_libclang_clang_equalTypes(A, B)

/**
 * Determine whether two CXTypes represent the same type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_equalTypes(A : CXType, B : CXType)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = A
  !(__ptr_0 + 1) = B
  __sn_wrap_libclang_clang_equalTypes((__ptr_0 + 0), (__ptr_0 + 1))

/**
 * Find #import/#include directives in a specific file.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_findIncludesInFile(TU : CXTranslationUnit, file : CXFile, visitor : Ptr[CXCursorAndRangeVisitor]): CXResult = 
  __sn_wrap_libclang_clang_findIncludesInFile(TU, file, visitor)

/**
 * Find #import/#include directives in a specific file.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_findIncludesInFile(TU : CXTranslationUnit, file : CXFile, visitor : CXCursorAndRangeVisitor)(using Zone): CXResult = 
  val __ptr_0: Ptr[CXCursorAndRangeVisitor] = alloc[CXCursorAndRangeVisitor](1)
  !(__ptr_0 + 0) = visitor
  __sn_wrap_libclang_clang_findIncludesInFile(TU, file, (__ptr_0 + 0))

/**
 * Find references of a declaration in a specific file.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_findReferencesInFile(cursor : CXCursor, file : CXFile, visitor : CXCursorAndRangeVisitor)(using Zone): CXResult = 
  val __ptr_0: Ptr[CXCursorAndRangeVisitor] = alloc[CXCursorAndRangeVisitor](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = cursor
  !(__ptr_0 + 0) = visitor
  __sn_wrap_libclang_clang_findReferencesInFile((__ptr_1 + 0), file, (__ptr_0 + 0))

/**
 * Find references of a declaration in a specific file.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_findReferencesInFile(cursor : Ptr[CXCursor], file : CXFile, visitor : Ptr[CXCursorAndRangeVisitor]): CXResult = 
  __sn_wrap_libclang_clang_findReferencesInFile(cursor, file, visitor)

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_findReferencesInFileWithBlock(_0 : CXCursor, _1 : CXFile, _2 : CXCursorAndRangeVisitorBlock)(using Zone): CXResult = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_findReferencesInFileWithBlock((__ptr_0 + 0), _1, _2)

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_findReferencesInFileWithBlock(_0 : Ptr[CXCursor], _1 : CXFile, _2 : CXCursorAndRangeVisitorBlock): CXResult = 
  __sn_wrap_libclang_clang_findReferencesInFileWithBlock(_0, _1, _2)

/**
 * Format the given diagnostic in a manner that is suitable for display.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_formatDiagnostic(Diagnostic : CXDiagnostic, Options : CUnsignedInt)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_formatDiagnostic(Diagnostic, Options, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Format the given diagnostic in a manner that is suitable for display.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_formatDiagnostic(Diagnostic : CXDiagnostic, Options : CUnsignedInt)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_formatDiagnostic(Diagnostic, Options, __return)

/**
 * Returns the address space of the given type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getAddressSpace(T : Ptr[CXType]): CUnsignedInt = 
  __sn_wrap_libclang_clang_getAddressSpace(T)

/**
 * Returns the address space of the given type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getAddressSpace(T : CXType)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getAddressSpace((__ptr_0 + 0))

/**
 * Retrieve the type of a parameter of a function type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getArgType(T : CXType, i : CUnsignedInt)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getArgType((__ptr_0 + 0), i, (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Retrieve the type of a parameter of a function type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getArgType(T : Ptr[CXType], i : CUnsignedInt)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getArgType(T, i, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the type of a parameter of a function type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getArgType(T : Ptr[CXType], i : CUnsignedInt)(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_getArgType(T, i, __return)

/**
 * Return the element type of an array type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getArrayElementType(T : CXType)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getArrayElementType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Return the element type of an array type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getArrayElementType(T : Ptr[CXType])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_getArrayElementType(T, __return)

/**
 * Return the element type of an array type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getArrayElementType(T : Ptr[CXType])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getArrayElementType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Return the array size of a constant array.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getArraySize(T : CXType)(using Zone): CLongLong = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getArraySize((__ptr_0 + 0))

/**
 * Return the array size of a constant array.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getArraySize(T : Ptr[CXType]): CLongLong = 
  __sn_wrap_libclang_clang_getArraySize(T)

/**
 * Retrieve the spelling of a given CXBinaryOperatorKind.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getBinaryOperatorKindSpelling(kind : CXBinaryOperatorKind)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getBinaryOperatorKindSpelling(kind, __return)

/**
 * Retrieve the spelling of a given CXBinaryOperatorKind.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getBinaryOperatorKindSpelling(kind : CXBinaryOperatorKind)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getBinaryOperatorKindSpelling(kind, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the character data associated with the given string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXString.h
*/
def clang_getCString(string : Ptr[CXString]): CString = 
  __sn_wrap_libclang_clang_getCString(string)

/**
 * Retrieve the character data associated with the given string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXString.h
*/
def clang_getCString(string : CXString)(using Zone): CString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = string
  __sn_wrap_libclang_clang_getCString((__ptr_0 + 0))

/**
 * Return the memory usage of a translation unit. This object should be released with clang_disposeCXTUResourceUsage().

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCXTUResourceUsage(TU : CXTranslationUnit)(using Zone): CXTUResourceUsage = 
  val __ptr_0: Ptr[CXTUResourceUsage] = alloc[CXTUResourceUsage](1)
  __sn_wrap_libclang_clang_getCXTUResourceUsage(TU, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Return the memory usage of a translation unit. This object should be released with clang_disposeCXTUResourceUsage().

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCXTUResourceUsage(TU : CXTranslationUnit)(__return : Ptr[CXTUResourceUsage]): Unit = 
  __sn_wrap_libclang_clang_getCXTUResourceUsage(TU, __return)

/**
 * Returns the access control level for the referenced object.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCXXAccessSpecifier(_0 : Ptr[CXCursor]): CX_CXXAccessSpecifier = 
  __sn_wrap_libclang_clang_getCXXAccessSpecifier(_0)

/**
 * Returns the access control level for the referenced object.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCXXAccessSpecifier(_0 : CXCursor)(using Zone): CX_CXXAccessSpecifier = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCXXAccessSpecifier((__ptr_0 + 0))

/**
 * Retrieve the canonical cursor corresponding to the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCanonicalCursor(_0 : Ptr[CXCursor])(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getCanonicalCursor(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the canonical cursor corresponding to the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCanonicalCursor(_0 : CXCursor)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCanonicalCursor((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Retrieve the canonical cursor corresponding to the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCanonicalCursor(_0 : Ptr[CXCursor])(__return : Ptr[CXCursor]): Unit = 
  __sn_wrap_libclang_clang_getCanonicalCursor(_0, __return)

/**
 * Return the canonical type for a CXType.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCanonicalType(T : Ptr[CXType])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_getCanonicalType(T, __return)

/**
 * Return the canonical type for a CXType.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCanonicalType(T : Ptr[CXType])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getCanonicalType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Return the canonical type for a CXType.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCanonicalType(T : CXType)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getCanonicalType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Return a version string, suitable for showing to a user, but not intended to be parsed (the format is not guaranteed to be stable).

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getClangVersion()(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getClangVersion((__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Return a version string, suitable for showing to a user, but not intended to be parsed (the format is not guaranteed to be stable).

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getClangVersion()(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getClangVersion(__return)

/**
 * Retrieve the annotation associated with the given completion string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCompletionAnnotation(completion_string : CXCompletionString, annotation_number : CUnsignedInt)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getCompletionAnnotation(completion_string, annotation_number, __return)

/**
 * Retrieve the annotation associated with the given completion string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCompletionAnnotation(completion_string : CXCompletionString, annotation_number : CUnsignedInt)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCompletionAnnotation(completion_string, annotation_number, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the brief documentation comment attached to the declaration that corresponds to the given completion string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCompletionBriefComment(completion_string : CXCompletionString)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCompletionBriefComment(completion_string, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the brief documentation comment attached to the declaration that corresponds to the given completion string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCompletionBriefComment(completion_string : CXCompletionString)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getCompletionBriefComment(completion_string, __return)

/**
 * Retrieve the text associated with a particular chunk within a completion string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCompletionChunkText(completion_string : CXCompletionString, chunk_number : CUnsignedInt)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getCompletionChunkText(completion_string, chunk_number, __return)

/**
 * Retrieve the text associated with a particular chunk within a completion string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCompletionChunkText(completion_string : CXCompletionString, chunk_number : CUnsignedInt)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCompletionChunkText(completion_string, chunk_number, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Fix-its that *must* be applied before inserting the text for the corresponding completion.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCompletionFixIt(results : Ptr[CXCodeCompleteResults], completion_index : CUnsignedInt, fixit_index : CUnsignedInt, replacement_range : Ptr[CXSourceRange])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCompletionFixIt(results, completion_index, fixit_index, replacement_range, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Fix-its that *must* be applied before inserting the text for the corresponding completion.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCompletionFixIt(results : Ptr[CXCodeCompleteResults], completion_index : CUnsignedInt, fixit_index : CUnsignedInt, replacement_range : Ptr[CXSourceRange])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getCompletionFixIt(results, completion_index, fixit_index, replacement_range, __return)

/**
 * Retrieve the parent context of the given completion string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCompletionParent(completion_string : CXCompletionString, kind : Ptr[CXCursorKind])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getCompletionParent(completion_string, kind, __return)

/**
 * Retrieve the parent context of the given completion string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCompletionParent(completion_string : CXCompletionString, kind : Ptr[CXCursorKind])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCompletionParent(completion_string, kind, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Map a source location to the cursor that describes the entity at that location in the source code.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursor(_0 : CXTranslationUnit, _1 : Ptr[CXSourceLocation])(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getCursor(_0, _1, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Map a source location to the cursor that describes the entity at that location in the source code.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursor(_0 : CXTranslationUnit, _1 : CXSourceLocation)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _1
  __sn_wrap_libclang_clang_getCursor(_0, (__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Map a source location to the cursor that describes the entity at that location in the source code.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursor(_0 : CXTranslationUnit, _1 : Ptr[CXSourceLocation])(__return : Ptr[CXCursor]): Unit = 
  __sn_wrap_libclang_clang_getCursor(_0, _1, __return)

/**
 * Determine the availability of the entity that this cursor refers to, taking the current target platform into account.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorAvailability(cursor : Ptr[CXCursor]): CXAvailabilityKind = 
  __sn_wrap_libclang_clang_getCursorAvailability(cursor)

/**
 * Determine the availability of the entity that this cursor refers to, taking the current target platform into account.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorAvailability(cursor : CXCursor)(using Zone): CXAvailabilityKind = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorAvailability((__ptr_0 + 0))

/**
 * Retrieve the binary operator kind of this cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorBinaryOperatorKind(cursor : CXCursor)(using Zone): CXBinaryOperatorKind = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorBinaryOperatorKind((__ptr_0 + 0))

/**
 * Retrieve the binary operator kind of this cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorBinaryOperatorKind(cursor : Ptr[CXCursor]): CXBinaryOperatorKind = 
  __sn_wrap_libclang_clang_getCursorBinaryOperatorKind(cursor)

/**
 * Retrieve a completion string for an arbitrary declaration or macro definition cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorCompletionString(cursor : CXCursor)(using Zone): CXCompletionString = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorCompletionString((__ptr_0 + 0))

/**
 * Retrieve a completion string for an arbitrary declaration or macro definition cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorCompletionString(cursor : Ptr[CXCursor]): CXCompletionString = 
  __sn_wrap_libclang_clang_getCursorCompletionString(cursor)

/**
 * For a cursor that is either a reference to or a declaration of some entity, retrieve a cursor that describes the definition of that entity.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorDefinition(_0 : CXCursor)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCursorDefinition((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * For a cursor that is either a reference to or a declaration of some entity, retrieve a cursor that describes the definition of that entity.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorDefinition(_0 : Ptr[CXCursor])(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getCursorDefinition(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * For a cursor that is either a reference to or a declaration of some entity, retrieve a cursor that describes the definition of that entity.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorDefinition(_0 : Ptr[CXCursor])(__return : Ptr[CXCursor]): Unit = 
  __sn_wrap_libclang_clang_getCursorDefinition(_0, __return)

/**
 * Retrieve the display name for the entity referenced by this cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorDisplayName(_0 : Ptr[CXCursor])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCursorDisplayName(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the display name for the entity referenced by this cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorDisplayName(_0 : CXCursor)(using Zone): CXString = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCursorDisplayName((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Retrieve the display name for the entity referenced by this cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorDisplayName(_0 : Ptr[CXCursor])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getCursorDisplayName(_0, __return)

/**
 * Retrieve the exception specification type associated with a given cursor. This is a value of type CXCursor_ExceptionSpecificationKind.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorExceptionSpecificationType(C : CXCursor)(using Zone): CInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getCursorExceptionSpecificationType((__ptr_0 + 0))

/**
 * Retrieve the exception specification type associated with a given cursor. This is a value of type CXCursor_ExceptionSpecificationKind.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorExceptionSpecificationType(C : Ptr[CXCursor]): CInt = 
  __sn_wrap_libclang_clang_getCursorExceptionSpecificationType(C)

/**
 * Retrieve the physical extent of the source construct referenced by the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorExtent(_0 : CXCursor)(using Zone): CXSourceRange = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = _0
  __sn_wrap_libclang_clang_getCursorExtent((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the physical extent of the source construct referenced by the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorExtent(_0 : Ptr[CXCursor])(using Zone): CXSourceRange = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_getCursorExtent(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the physical extent of the source construct referenced by the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorExtent(_0 : Ptr[CXCursor])(__return : Ptr[CXSourceRange]): Unit = 
  __sn_wrap_libclang_clang_getCursorExtent(_0, __return)

/**
 * Retrieve the kind of the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorKind(_0 : CXCursor)(using Zone): CXCursorKind = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCursorKind((__ptr_0 + 0))

/**
 * Retrieve the kind of the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorKind(_0 : Ptr[CXCursor]): CXCursorKind = 
  __sn_wrap_libclang_clang_getCursorKind(_0)

/**
 * These routines are used for testing and debugging, only, and should not be relied upon.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorKindSpelling(Kind : CXCursorKind)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCursorKindSpelling(Kind, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * These routines are used for testing and debugging, only, and should not be relied upon.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorKindSpelling(Kind : CXCursorKind)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getCursorKindSpelling(Kind, __return)

/**
 * Determine the "language" of the entity referred to by a given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorLanguage(cursor : CXCursor)(using Zone): CXLanguageKind = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorLanguage((__ptr_0 + 0))

/**
 * Determine the "language" of the entity referred to by a given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorLanguage(cursor : Ptr[CXCursor]): CXLanguageKind = 
  __sn_wrap_libclang_clang_getCursorLanguage(cursor)

/**
 * Determine the lexical parent of the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorLexicalParent(cursor : CXCursor)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorLexicalParent((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Determine the lexical parent of the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorLexicalParent(cursor : Ptr[CXCursor])(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getCursorLexicalParent(cursor, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Determine the lexical parent of the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorLexicalParent(cursor : Ptr[CXCursor])(__return : Ptr[CXCursor]): Unit = 
  __sn_wrap_libclang_clang_getCursorLexicalParent(cursor, __return)

/**
 * Determine the linkage of the entity referred to by a given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorLinkage(cursor : CXCursor)(using Zone): CXLinkageKind = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorLinkage((__ptr_0 + 0))

/**
 * Determine the linkage of the entity referred to by a given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorLinkage(cursor : Ptr[CXCursor]): CXLinkageKind = 
  __sn_wrap_libclang_clang_getCursorLinkage(cursor)

/**
 * Retrieve the physical location of the source constructor referenced by the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorLocation(_0 : CXCursor)(using Zone): CXSourceLocation = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = _0
  __sn_wrap_libclang_clang_getCursorLocation((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the physical location of the source constructor referenced by the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorLocation(_0 : Ptr[CXCursor])(__return : Ptr[CXSourceLocation]): Unit = 
  __sn_wrap_libclang_clang_getCursorLocation(_0, __return)

/**
 * Retrieve the physical location of the source constructor referenced by the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorLocation(_0 : Ptr[CXCursor])(using Zone): CXSourceLocation = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getCursorLocation(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Determine the availability of the entity that this cursor refers to on any platforms for which availability information is known.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorPlatformAvailability(cursor : CXCursor, always_deprecated : Ptr[CInt], deprecated_message : Ptr[CXString], always_unavailable : Ptr[CInt], unavailable_message : Ptr[CXString], availability : Ptr[CXPlatformAvailability], availability_size : CInt)(using Zone): CInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorPlatformAvailability((__ptr_0 + 0), always_deprecated, deprecated_message, always_unavailable, unavailable_message, availability, availability_size)

/**
 * Determine the availability of the entity that this cursor refers to on any platforms for which availability information is known.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorPlatformAvailability(cursor : Ptr[CXCursor], always_deprecated : Ptr[CInt], deprecated_message : Ptr[CXString], always_unavailable : Ptr[CInt], unavailable_message : Ptr[CXString], availability : Ptr[CXPlatformAvailability], availability_size : CInt): CInt = 
  __sn_wrap_libclang_clang_getCursorPlatformAvailability(cursor, always_deprecated, deprecated_message, always_unavailable, unavailable_message, availability, availability_size)

/**
 * Pretty print declarations.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorPrettyPrinted(Cursor : Ptr[CXCursor], Policy : CXPrintingPolicy)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getCursorPrettyPrinted(Cursor, Policy, __return)

/**
 * Pretty print declarations.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorPrettyPrinted(Cursor : Ptr[CXCursor], Policy : CXPrintingPolicy)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCursorPrettyPrinted(Cursor, Policy, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Pretty print declarations.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorPrettyPrinted(Cursor : CXCursor, Policy : CXPrintingPolicy)(using Zone): CXString = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = Cursor
  __sn_wrap_libclang_clang_getCursorPrettyPrinted((__ptr_0 + 0), Policy, (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Retrieve the default policy for the cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorPrintingPolicy(_0 : Ptr[CXCursor]): CXPrintingPolicy = 
  __sn_wrap_libclang_clang_getCursorPrintingPolicy(_0)

/**
 * Retrieve the default policy for the cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorPrintingPolicy(_0 : CXCursor)(using Zone): CXPrintingPolicy = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCursorPrintingPolicy((__ptr_0 + 0))

/**
 * Given a cursor that references something else, return the source range covering that reference.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorReferenceNameRange(C : Ptr[CXCursor], NameFlags : CUnsignedInt, PieceIndex : CUnsignedInt)(__return : Ptr[CXSourceRange]): Unit = 
  __sn_wrap_libclang_clang_getCursorReferenceNameRange(C, NameFlags, PieceIndex, __return)

/**
 * Given a cursor that references something else, return the source range covering that reference.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorReferenceNameRange(C : Ptr[CXCursor], NameFlags : CUnsignedInt, PieceIndex : CUnsignedInt)(using Zone): CXSourceRange = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_getCursorReferenceNameRange(C, NameFlags, PieceIndex, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Given a cursor that references something else, return the source range covering that reference.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorReferenceNameRange(C : CXCursor, NameFlags : CUnsignedInt, PieceIndex : CUnsignedInt)(using Zone): CXSourceRange = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_getCursorReferenceNameRange((__ptr_1 + 0), NameFlags, PieceIndex, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * For a cursor that is a reference, retrieve a cursor representing the entity that it references.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorReferenced(_0 : CXCursor)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCursorReferenced((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * For a cursor that is a reference, retrieve a cursor representing the entity that it references.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorReferenced(_0 : Ptr[CXCursor])(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getCursorReferenced(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * For a cursor that is a reference, retrieve a cursor representing the entity that it references.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorReferenced(_0 : Ptr[CXCursor])(__return : Ptr[CXCursor]): Unit = 
  __sn_wrap_libclang_clang_getCursorReferenced(_0, __return)

/**
 * Retrieve the return type associated with a given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorResultType(C : Ptr[CXCursor])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getCursorResultType(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the return type associated with a given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorResultType(C : CXCursor)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_getCursorResultType((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the return type associated with a given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorResultType(C : Ptr[CXCursor])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_getCursorResultType(C, __return)

/**
 * Determine the semantic parent of the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorSemanticParent(cursor : Ptr[CXCursor])(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getCursorSemanticParent(cursor, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Determine the semantic parent of the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorSemanticParent(cursor : CXCursor)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorSemanticParent((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Determine the semantic parent of the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorSemanticParent(cursor : Ptr[CXCursor])(__return : Ptr[CXCursor]): Unit = 
  __sn_wrap_libclang_clang_getCursorSemanticParent(cursor, __return)

/**
 * Retrieve a name for the entity referenced by this cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorSpelling(_0 : Ptr[CXCursor])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getCursorSpelling(_0, __return)

/**
 * Retrieve a name for the entity referenced by this cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorSpelling(_0 : Ptr[CXCursor])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCursorSpelling(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a name for the entity referenced by this cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorSpelling(_0 : CXCursor)(using Zone): CXString = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCursorSpelling((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Determine the "thread-local storage (TLS) kind" of the declaration referred to by a cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorTLSKind(cursor : CXCursor)(using Zone): CXTLSKind = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorTLSKind((__ptr_0 + 0))

/**
 * Determine the "thread-local storage (TLS) kind" of the declaration referred to by a cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorTLSKind(cursor : Ptr[CXCursor]): CXTLSKind = 
  __sn_wrap_libclang_clang_getCursorTLSKind(cursor)

/**
 * Retrieve the type of a CXCursor (if any).

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorType(C : CXCursor)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_getCursorType((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the type of a CXCursor (if any).

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorType(C : Ptr[CXCursor])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_getCursorType(C, __return)

/**
 * Retrieve the type of a CXCursor (if any).

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorType(C : Ptr[CXCursor])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getCursorType(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a Unified Symbol Resolution (USR) for the entity referenced by the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorUSR(_0 : Ptr[CXCursor])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getCursorUSR(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a Unified Symbol Resolution (USR) for the entity referenced by the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorUSR(_0 : CXCursor)(using Zone): CXString = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getCursorUSR((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Retrieve a Unified Symbol Resolution (USR) for the entity referenced by the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorUSR(_0 : Ptr[CXCursor])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getCursorUSR(_0, __return)

/**
 * Retrieve the unary operator kind of this cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorUnaryOperatorKind(cursor : Ptr[CXCursor]): CXUnaryOperatorKind = 
  __sn_wrap_libclang_clang_getCursorUnaryOperatorKind(cursor)

/**
 * Retrieve the unary operator kind of this cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorUnaryOperatorKind(cursor : CXCursor)(using Zone): CXUnaryOperatorKind = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorUnaryOperatorKind((__ptr_0 + 0))

/**
 * Describe the visibility of the entity referred to by a cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorVisibility(cursor : Ptr[CXCursor]): CXVisibilityKind = 
  __sn_wrap_libclang_clang_getCursorVisibility(cursor)

/**
 * Describe the visibility of the entity referred to by a cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getCursorVisibility(cursor : CXCursor)(using Zone): CXVisibilityKind = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getCursorVisibility((__ptr_0 + 0))

/**
 * Returns the Objective-C type encoding for the specified declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getDeclObjCTypeEncoding(C : Ptr[CXCursor])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getDeclObjCTypeEncoding(C, __return)

/**
 * Returns the Objective-C type encoding for the specified declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getDeclObjCTypeEncoding(C : Ptr[CXCursor])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getDeclObjCTypeEncoding(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Returns the Objective-C type encoding for the specified declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getDeclObjCTypeEncoding(C : CXCursor)(using Zone): CXString = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  val __ptr_1: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getDeclObjCTypeEncoding((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getDefinitionSpellingAndExtent(_0 : Ptr[CXCursor], startBuf : Ptr[CString], endBuf : Ptr[CString], startLine : Ptr[CUnsignedInt], startColumn : Ptr[CUnsignedInt], endLine : Ptr[CUnsignedInt], endColumn : Ptr[CUnsignedInt]): Unit = 
  __sn_wrap_libclang_clang_getDefinitionSpellingAndExtent(_0, startBuf, endBuf, startLine, startColumn, endLine, endColumn)

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getDefinitionSpellingAndExtent(_0 : CXCursor, startBuf : Ptr[CString], endBuf : Ptr[CString], startLine : Ptr[CUnsignedInt], startColumn : Ptr[CUnsignedInt], endLine : Ptr[CUnsignedInt], endColumn : Ptr[CUnsignedInt])(using Zone): Unit = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getDefinitionSpellingAndExtent((__ptr_0 + 0), startBuf, endBuf, startLine, startColumn, endLine, endColumn)

/**
 * Retrieve the name of a particular diagnostic category. This is now deprecated. Use clang_getDiagnosticCategoryText() instead.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_getDiagnosticCategoryName(Category : CUnsignedInt)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getDiagnosticCategoryName(Category, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the name of a particular diagnostic category. This is now deprecated. Use clang_getDiagnosticCategoryText() instead.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_getDiagnosticCategoryName(Category : CUnsignedInt)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getDiagnosticCategoryName(Category, __return)

/**
 * Retrieve the diagnostic category text for a given diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_getDiagnosticCategoryText(_0 : CXDiagnostic)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getDiagnosticCategoryText(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the diagnostic category text for a given diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_getDiagnosticCategoryText(_0 : CXDiagnostic)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getDiagnosticCategoryText(_0, __return)

/**
 * Retrieve the replacement information for a given fix-it.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_getDiagnosticFixIt(Diagnostic : CXDiagnostic, FixIt : CUnsignedInt, ReplacementRange : Ptr[CXSourceRange])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getDiagnosticFixIt(Diagnostic, FixIt, ReplacementRange, __return)

/**
 * Retrieve the replacement information for a given fix-it.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_getDiagnosticFixIt(Diagnostic : CXDiagnostic, FixIt : CUnsignedInt, ReplacementRange : Ptr[CXSourceRange])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getDiagnosticFixIt(Diagnostic, FixIt, ReplacementRange, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the source location of the given diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_getDiagnosticLocation(_0 : CXDiagnostic)(__return : Ptr[CXSourceLocation]): Unit = 
  __sn_wrap_libclang_clang_getDiagnosticLocation(_0, __return)

/**
 * Retrieve the source location of the given diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_getDiagnosticLocation(_0 : CXDiagnostic)(using Zone): CXSourceLocation = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getDiagnosticLocation(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the name of the command-line option that enabled this diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_getDiagnosticOption(Diag : CXDiagnostic, Disable : Ptr[CXString])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getDiagnosticOption(Diag, Disable, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the name of the command-line option that enabled this diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_getDiagnosticOption(Diag : CXDiagnostic, Disable : Ptr[CXString])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getDiagnosticOption(Diag, Disable, __return)

/**
 * Retrieve a source range associated with the diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_getDiagnosticRange(Diagnostic : CXDiagnostic, Range : CUnsignedInt)(using Zone): CXSourceRange = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_getDiagnosticRange(Diagnostic, Range, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a source range associated with the diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_getDiagnosticRange(Diagnostic : CXDiagnostic, Range : CUnsignedInt)(__return : Ptr[CXSourceRange]): Unit = 
  __sn_wrap_libclang_clang_getDiagnosticRange(Diagnostic, Range, __return)

/**
 * Retrieve the text of the given diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_getDiagnosticSpelling(_0 : CXDiagnostic)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getDiagnosticSpelling(_0, __return)

/**
 * Retrieve the text of the given diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
def clang_getDiagnosticSpelling(_0 : CXDiagnostic)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getDiagnosticSpelling(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Return the element type of an array, complex, or vector type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getElementType(T : Ptr[CXType])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_getElementType(T, __return)

/**
 * Return the element type of an array, complex, or vector type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getElementType(T : CXType)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getElementType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Return the element type of an array, complex, or vector type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getElementType(T : Ptr[CXType])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getElementType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the integer value of an enum constant declaration as an unsigned long long.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getEnumConstantDeclUnsignedValue(C : Ptr[CXCursor]): CUnsignedLongLong = 
  __sn_wrap_libclang_clang_getEnumConstantDeclUnsignedValue(C)

/**
 * Retrieve the integer value of an enum constant declaration as an unsigned long long.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getEnumConstantDeclUnsignedValue(C : CXCursor)(using Zone): CUnsignedLongLong = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getEnumConstantDeclUnsignedValue((__ptr_0 + 0))

/**
 * Retrieve the integer value of an enum constant declaration as a signed long long.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getEnumConstantDeclValue(C : Ptr[CXCursor]): CLongLong = 
  __sn_wrap_libclang_clang_getEnumConstantDeclValue(C)

/**
 * Retrieve the integer value of an enum constant declaration as a signed long long.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getEnumConstantDeclValue(C : CXCursor)(using Zone): CLongLong = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getEnumConstantDeclValue((__ptr_0 + 0))

/**
 * Retrieve the integer type of an enum declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getEnumDeclIntegerType(C : CXCursor)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_getEnumDeclIntegerType((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the integer type of an enum declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getEnumDeclIntegerType(C : Ptr[CXCursor])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getEnumDeclIntegerType(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the integer type of an enum declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getEnumDeclIntegerType(C : Ptr[CXCursor])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_getEnumDeclIntegerType(C, __return)

/**
 * Retrieve the exception specification type associated with a function type. This is a value of type CXCursor_ExceptionSpecificationKind.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getExceptionSpecificationType(T : Ptr[CXType]): CInt = 
  __sn_wrap_libclang_clang_getExceptionSpecificationType(T)

/**
 * Retrieve the exception specification type associated with a function type. This is a value of type CXCursor_ExceptionSpecificationKind.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getExceptionSpecificationType(T : CXType)(using Zone): CInt = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getExceptionSpecificationType((__ptr_0 + 0))

/**
 * Retrieve the file, line, column, and offset represented by the given source location.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getExpansionLocation(location : Ptr[CXSourceLocation], file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt]): Unit = 
  __sn_wrap_libclang_clang_getExpansionLocation(location, file, line, column, offset)

/**
 * Retrieve the file, line, column, and offset represented by the given source location.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getExpansionLocation(location : CXSourceLocation, file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt])(using Zone): Unit = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = location
  __sn_wrap_libclang_clang_getExpansionLocation((__ptr_0 + 0), file, line, column, offset)

/**
 * Retrieve the bit width of a bit-field declaration as an integer.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getFieldDeclBitWidth(C : Ptr[CXCursor]): CInt = 
  __sn_wrap_libclang_clang_getFieldDeclBitWidth(C)

/**
 * Retrieve the bit width of a bit-field declaration as an integer.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getFieldDeclBitWidth(C : CXCursor)(using Zone): CInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getFieldDeclBitWidth((__ptr_0 + 0))

/**
 * Retrieve the file, line, column, and offset represented by the given source location.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getFileLocation(location : CXSourceLocation, file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt])(using Zone): Unit = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = location
  __sn_wrap_libclang_clang_getFileLocation((__ptr_0 + 0), file, line, column, offset)

/**
 * Retrieve the file, line, column, and offset represented by the given source location.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getFileLocation(location : Ptr[CXSourceLocation], file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt]): Unit = 
  __sn_wrap_libclang_clang_getFileLocation(location, file, line, column, offset)

/**
 * Retrieve the complete file and path name of the given file.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXFile.h
*/
def clang_getFileName(SFile : CXFile)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getFileName(SFile, __return)

/**
 * Retrieve the complete file and path name of the given file.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXFile.h
*/
def clang_getFileName(SFile : CXFile)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getFileName(SFile, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the calling convention associated with a function type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getFunctionTypeCallingConv(T : CXType)(using Zone): CXCallingConv = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getFunctionTypeCallingConv((__ptr_0 + 0))

/**
 * Retrieve the calling convention associated with a function type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getFunctionTypeCallingConv(T : Ptr[CXType]): CXCallingConv = 
  __sn_wrap_libclang_clang_getFunctionTypeCallingConv(T)

/**
 * For cursors representing an iboutletcollection attribute, this function returns the collection element type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getIBOutletCollectionType(_0 : CXCursor)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = _0
  __sn_wrap_libclang_clang_getIBOutletCollectionType((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * For cursors representing an iboutletcollection attribute, this function returns the collection element type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getIBOutletCollectionType(_0 : Ptr[CXCursor])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getIBOutletCollectionType(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * For cursors representing an iboutletcollection attribute, this function returns the collection element type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getIBOutletCollectionType(_0 : Ptr[CXCursor])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_getIBOutletCollectionType(_0, __return)

/**
 * Retrieve the file that is included by the given inclusion directive cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getIncludedFile(cursor : CXCursor)(using Zone): CXFile = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getIncludedFile((__ptr_0 + 0))

/**
 * Retrieve the file that is included by the given inclusion directive cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getIncludedFile(cursor : Ptr[CXCursor]): CXFile = 
  __sn_wrap_libclang_clang_getIncludedFile(cursor)

/**
 * Legacy API to retrieve the file, line, column, and offset represented by the given source location.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getInstantiationLocation(location : CXSourceLocation, file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt])(using Zone): Unit = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = location
  __sn_wrap_libclang_clang_getInstantiationLocation((__ptr_0 + 0), file, line, column, offset)

/**
 * Legacy API to retrieve the file, line, column, and offset represented by the given source location.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getInstantiationLocation(location : Ptr[CXSourceLocation], file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt]): Unit = 
  __sn_wrap_libclang_clang_getInstantiationLocation(location, file, line, column, offset)

/**
 * Retrieves the source location associated with a given file/line/column in a particular translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getLocation(tu : CXTranslationUnit, file : CXFile, line : CUnsignedInt, column : CUnsignedInt)(using Zone): CXSourceLocation = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getLocation(tu, file, line, column, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieves the source location associated with a given file/line/column in a particular translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getLocation(tu : CXTranslationUnit, file : CXFile, line : CUnsignedInt, column : CUnsignedInt)(__return : Ptr[CXSourceLocation]): Unit = 
  __sn_wrap_libclang_clang_getLocation(tu, file, line, column, __return)

/**
 * Retrieves the source location associated with a given character offset in a particular translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getLocationForOffset(tu : CXTranslationUnit, file : CXFile, offset : CUnsignedInt)(__return : Ptr[CXSourceLocation]): Unit = 
  __sn_wrap_libclang_clang_getLocationForOffset(tu, file, offset, __return)

/**
 * Retrieves the source location associated with a given character offset in a particular translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getLocationForOffset(tu : CXTranslationUnit, file : CXFile, offset : CUnsignedInt)(using Zone): CXSourceLocation = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getLocationForOffset(tu, file, offset, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * For reference types (e.g., "const int&"), returns the type that the reference refers to (e.g "const int").

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getNonReferenceType(CT : Ptr[CXType])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_getNonReferenceType(CT, __return)

/**
 * For reference types (e.g., "const int&"), returns the type that the reference refers to (e.g "const int").

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getNonReferenceType(CT : Ptr[CXType])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getNonReferenceType(CT, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * For reference types (e.g., "const int&"), returns the type that the reference refers to (e.g "const int").

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getNonReferenceType(CT : CXType)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = CT
  __sn_wrap_libclang_clang_getNonReferenceType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Retrieve the NULL cursor, which represents no entity.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getNullCursor()(__return : Ptr[CXCursor]): Unit = 
  __sn_wrap_libclang_clang_getNullCursor(__return)

/**
 * Retrieve the NULL cursor, which represents no entity.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getNullCursor()(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getNullCursor((__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a NULL (invalid) source location.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getNullLocation()(__return : Ptr[CXSourceLocation]): Unit = 
  __sn_wrap_libclang_clang_getNullLocation(__return)

/**
 * Retrieve a NULL (invalid) source location.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getNullLocation()(using Zone): CXSourceLocation = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getNullLocation((__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a NULL (invalid) source range.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getNullRange()(using Zone): CXSourceRange = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_getNullRange((__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a NULL (invalid) source range.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getNullRange()(__return : Ptr[CXSourceRange]): Unit = 
  __sn_wrap_libclang_clang_getNullRange(__return)

/**
 * Retrieve the number of non-variadic parameters associated with a function type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getNumArgTypes(T : Ptr[CXType]): CInt = 
  __sn_wrap_libclang_clang_getNumArgTypes(T)

/**
 * Retrieve the number of non-variadic parameters associated with a function type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getNumArgTypes(T : CXType)(using Zone): CInt = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getNumArgTypes((__ptr_0 + 0))

/**
 * Return the number of elements of an array or vector type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getNumElements(T : CXType)(using Zone): CLongLong = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getNumElements((__ptr_0 + 0))

/**
 * Return the number of elements of an array or vector type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getNumElements(T : Ptr[CXType]): CLongLong = 
  __sn_wrap_libclang_clang_getNumElements(T)

/**
 * Determine the number of overloaded declarations referenced by a CXCursor_OverloadedDeclRef cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getNumOverloadedDecls(cursor : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_getNumOverloadedDecls(cursor)

/**
 * Determine the number of overloaded declarations referenced by a CXCursor_OverloadedDeclRef cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getNumOverloadedDecls(cursor : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getNumOverloadedDecls((__ptr_0 + 0))

/**
 * Retrieve a cursor for one of the overloaded declarations referenced by a CXCursor_OverloadedDeclRef cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getOverloadedDecl(cursor : Ptr[CXCursor], index : CUnsignedInt)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getOverloadedDecl(cursor, index, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a cursor for one of the overloaded declarations referenced by a CXCursor_OverloadedDeclRef cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getOverloadedDecl(cursor : CXCursor, index : CUnsignedInt)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getOverloadedDecl((__ptr_0 + 0), index, (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Retrieve a cursor for one of the overloaded declarations referenced by a CXCursor_OverloadedDeclRef cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getOverloadedDecl(cursor : Ptr[CXCursor], index : CUnsignedInt)(__return : Ptr[CXCursor]): Unit = 
  __sn_wrap_libclang_clang_getOverloadedDecl(cursor, index, __return)

/**
 * Determine the set of methods that are overridden by the given method.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getOverriddenCursors(cursor : Ptr[CXCursor], overridden : Ptr[Ptr[CXCursor]], num_overridden : Ptr[CUnsignedInt]): Unit = 
  __sn_wrap_libclang_clang_getOverriddenCursors(cursor, overridden, num_overridden)

/**
 * Determine the set of methods that are overridden by the given method.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getOverriddenCursors(cursor : CXCursor, overridden : Ptr[Ptr[CXCursor]], num_overridden : Ptr[CUnsignedInt])(using Zone): Unit = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = cursor
  __sn_wrap_libclang_clang_getOverriddenCursors((__ptr_0 + 0), overridden, num_overridden)

/**
 * For pointer types, returns the type of the pointee.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getPointeeType(T : CXType)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getPointeeType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * For pointer types, returns the type of the pointee.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getPointeeType(T : Ptr[CXType])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getPointeeType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * For pointer types, returns the type of the pointee.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getPointeeType(T : Ptr[CXType])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_getPointeeType(T, __return)

/**
 * Retrieve the file, line and column represented by the given source location, as specified in a # line directive.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getPresumedLocation(location : CXSourceLocation, filename : Ptr[CXString], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt])(using Zone): Unit = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = location
  __sn_wrap_libclang_clang_getPresumedLocation((__ptr_0 + 0), filename, line, column)

/**
 * Retrieve the file, line and column represented by the given source location, as specified in a # line directive.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getPresumedLocation(location : Ptr[CXSourceLocation], filename : Ptr[CXString], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt]): Unit = 
  __sn_wrap_libclang_clang_getPresumedLocation(location, filename, line, column)

/**
 * Retrieve a source range given the beginning and ending source locations.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getRange(begin : CXSourceLocation, end : CXSourceLocation)(using Zone): CXSourceRange = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](2)
  val __ptr_1: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  !(__ptr_0 + 0) = begin
  !(__ptr_0 + 1) = end
  __sn_wrap_libclang_clang_getRange((__ptr_0 + 0), (__ptr_0 + 1), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Retrieve a source range given the beginning and ending source locations.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getRange(begin : Ptr[CXSourceLocation], end : Ptr[CXSourceLocation])(__return : Ptr[CXSourceRange]): Unit = 
  __sn_wrap_libclang_clang_getRange(begin, end, __return)

/**
 * Retrieve a source range given the beginning and ending source locations.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getRange(begin : Ptr[CXSourceLocation], end : Ptr[CXSourceLocation])(using Zone): CXSourceRange = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_getRange(begin, end, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a source location representing the last character within a source range.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getRangeEnd(range : Ptr[CXSourceRange])(__return : Ptr[CXSourceLocation]): Unit = 
  __sn_wrap_libclang_clang_getRangeEnd(range, __return)

/**
 * Retrieve a source location representing the last character within a source range.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getRangeEnd(range : Ptr[CXSourceRange])(using Zone): CXSourceLocation = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getRangeEnd(range, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a source location representing the last character within a source range.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getRangeEnd(range : CXSourceRange)(using Zone): CXSourceLocation = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  val __ptr_1: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  !(__ptr_1 + 0) = range
  __sn_wrap_libclang_clang_getRangeEnd((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a source location representing the first character within a source range.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getRangeStart(range : Ptr[CXSourceRange])(__return : Ptr[CXSourceLocation]): Unit = 
  __sn_wrap_libclang_clang_getRangeStart(range, __return)

/**
 * Retrieve a source location representing the first character within a source range.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getRangeStart(range : Ptr[CXSourceRange])(using Zone): CXSourceLocation = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getRangeStart(range, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a source location representing the first character within a source range.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getRangeStart(range : CXSourceRange)(using Zone): CXSourceLocation = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  val __ptr_1: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  !(__ptr_1 + 0) = range
  __sn_wrap_libclang_clang_getRangeStart((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the return type associated with a function type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getResultType(T : Ptr[CXType])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getResultType(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the return type associated with a function type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getResultType(T : Ptr[CXType])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_getResultType(T, __return)

/**
 * Retrieve the return type associated with a function type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getResultType(T : CXType)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getResultType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Given a cursor that may represent a specialization or instantiation of a template, retrieve the cursor that represents the template that it specializes or from which it was instantiated.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getSpecializedCursorTemplate(C : Ptr[CXCursor])(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getSpecializedCursorTemplate(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Given a cursor that may represent a specialization or instantiation of a template, retrieve the cursor that represents the template that it specializes or from which it was instantiated.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getSpecializedCursorTemplate(C : CXCursor)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](2)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getSpecializedCursorTemplate((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Given a cursor that may represent a specialization or instantiation of a template, retrieve the cursor that represents the template that it specializes or from which it was instantiated.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getSpecializedCursorTemplate(C : Ptr[CXCursor])(__return : Ptr[CXCursor]): Unit = 
  __sn_wrap_libclang_clang_getSpecializedCursorTemplate(C, __return)

/**
 * Retrieve the file, line, column, and offset represented by the given source location.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getSpellingLocation(location : Ptr[CXSourceLocation], file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt]): Unit = 
  __sn_wrap_libclang_clang_getSpellingLocation(location, file, line, column, offset)

/**
 * Retrieve the file, line, column, and offset represented by the given source location.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
def clang_getSpellingLocation(location : CXSourceLocation, file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt])(using Zone): Unit = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = location
  __sn_wrap_libclang_clang_getSpellingLocation((__ptr_0 + 0), file, line, column, offset)

/**
 * Given a cursor that represents a template, determine the cursor kind of the specializations would be generated by instantiating the template.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTemplateCursorKind(C : CXCursor)(using Zone): CXCursorKind = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = C
  __sn_wrap_libclang_clang_getTemplateCursorKind((__ptr_0 + 0))

/**
 * Given a cursor that represents a template, determine the cursor kind of the specializations would be generated by instantiating the template.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTemplateCursorKind(C : Ptr[CXCursor]): CXCursorKind = 
  __sn_wrap_libclang_clang_getTemplateCursorKind(C)

/**
 * Get the raw lexical token starting with the given location.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getToken(TU : CXTranslationUnit, Location : CXSourceLocation)(using Zone): Ptr[CXToken] = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  !(__ptr_0 + 0) = Location
  __sn_wrap_libclang_clang_getToken(TU, (__ptr_0 + 0))

/**
 * Get the raw lexical token starting with the given location.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getToken(TU : CXTranslationUnit, Location : Ptr[CXSourceLocation]): Ptr[CXToken] = 
  __sn_wrap_libclang_clang_getToken(TU, Location)

/**
 * Retrieve a source range that covers the given token.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTokenExtent(_0 : CXTranslationUnit, _1 : Ptr[CXToken])(using Zone): CXSourceRange = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  __sn_wrap_libclang_clang_getTokenExtent(_0, _1, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a source range that covers the given token.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTokenExtent(_0 : CXTranslationUnit, _1 : CXToken)(using Zone): CXSourceRange = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  val __ptr_1: Ptr[CXToken] = alloc[CXToken](1)
  !(__ptr_1 + 0) = _1
  __sn_wrap_libclang_clang_getTokenExtent(_0, (__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve a source range that covers the given token.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTokenExtent(_0 : CXTranslationUnit, _1 : Ptr[CXToken])(__return : Ptr[CXSourceRange]): Unit = 
  __sn_wrap_libclang_clang_getTokenExtent(_0, _1, __return)

/**
 * Determine the kind of the given token.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTokenKind(_0 : CXToken)(using Zone): CXTokenKind = 
  val __ptr_0: Ptr[CXToken] = alloc[CXToken](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_getTokenKind((__ptr_0 + 0))

/**
 * Determine the kind of the given token.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTokenKind(_0 : Ptr[CXToken]): CXTokenKind = 
  __sn_wrap_libclang_clang_getTokenKind(_0)

/**
 * Retrieve the source location of the given token.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTokenLocation(_0 : CXTranslationUnit, _1 : Ptr[CXToken])(using Zone): CXSourceLocation = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_getTokenLocation(_0, _1, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the source location of the given token.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTokenLocation(_0 : CXTranslationUnit, _1 : CXToken)(using Zone): CXSourceLocation = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  val __ptr_1: Ptr[CXToken] = alloc[CXToken](1)
  !(__ptr_1 + 0) = _1
  __sn_wrap_libclang_clang_getTokenLocation(_0, (__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the source location of the given token.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTokenLocation(_0 : CXTranslationUnit, _1 : Ptr[CXToken])(__return : Ptr[CXSourceLocation]): Unit = 
  __sn_wrap_libclang_clang_getTokenLocation(_0, _1, __return)

/**
 * Determine the spelling of the given token.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTokenSpelling(_0 : CXTranslationUnit, _1 : Ptr[CXToken])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getTokenSpelling(_0, _1, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Determine the spelling of the given token.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTokenSpelling(_0 : CXTranslationUnit, _1 : CXToken)(using Zone): CXString = 
  val __ptr_0: Ptr[CXToken] = alloc[CXToken](1)
  val __ptr_1: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = _1
  __sn_wrap_libclang_clang_getTokenSpelling(_0, (__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Determine the spelling of the given token.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTokenSpelling(_0 : CXTranslationUnit, _1 : Ptr[CXToken])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getTokenSpelling(_0, _1, __return)

/**
 * Retrieve the cursor that represents the given translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTranslationUnitCursor(_0 : CXTranslationUnit)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getTranslationUnitCursor(_0, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the cursor that represents the given translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTranslationUnitCursor(_0 : CXTranslationUnit)(__return : Ptr[CXCursor]): Unit = 
  __sn_wrap_libclang_clang_getTranslationUnitCursor(_0, __return)

/**
 * Get the original translation unit source file name.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTranslationUnitSpelling(CTUnit : CXTranslationUnit)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getTranslationUnitSpelling(CTUnit, __return)

/**
 * Get the original translation unit source file name.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTranslationUnitSpelling(CTUnit : CXTranslationUnit)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getTranslationUnitSpelling(CTUnit, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Return the cursor for the declaration of the given type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTypeDeclaration(T : CXType)(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_getTypeDeclaration((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Return the cursor for the declaration of the given type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTypeDeclaration(T : Ptr[CXType])(__return : Ptr[CXCursor]): Unit = 
  __sn_wrap_libclang_clang_getTypeDeclaration(T, __return)

/**
 * Return the cursor for the declaration of the given type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTypeDeclaration(T : Ptr[CXType])(using Zone): CXCursor = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  __sn_wrap_libclang_clang_getTypeDeclaration(T, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the spelling of a given CXTypeKind.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTypeKindSpelling(K : CXTypeKind)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getTypeKindSpelling(K, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the spelling of a given CXTypeKind.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTypeKindSpelling(K : CXTypeKind)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getTypeKindSpelling(K, __return)

/**
 * Pretty-print the underlying type using the rules of the language of the translation unit from which it came.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTypeSpelling(CT : Ptr[CXType])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getTypeSpelling(CT, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Pretty-print the underlying type using the rules of the language of the translation unit from which it came.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTypeSpelling(CT : Ptr[CXType])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getTypeSpelling(CT, __return)

/**
 * Pretty-print the underlying type using the rules of the language of the translation unit from which it came.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTypeSpelling(CT : CXType)(using Zone): CXString = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  val __ptr_1: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = CT
  __sn_wrap_libclang_clang_getTypeSpelling((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Retrieve the underlying type of a typedef declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTypedefDeclUnderlyingType(C : CXCursor)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  val __ptr_1: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_1 + 0) = C
  __sn_wrap_libclang_clang_getTypedefDeclUnderlyingType((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the underlying type of a typedef declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTypedefDeclUnderlyingType(C : Ptr[CXCursor])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_getTypedefDeclUnderlyingType(C, __return)

/**
 * Retrieve the underlying type of a typedef declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTypedefDeclUnderlyingType(C : Ptr[CXCursor])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getTypedefDeclUnderlyingType(C, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Returns the typedef name of the given type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTypedefName(CT : Ptr[CXType])(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getTypedefName(CT, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Returns the typedef name of the given type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTypedefName(CT : CXType)(using Zone): CXString = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  val __ptr_1: Ptr[CXString] = alloc[CXString](1)
  !(__ptr_0 + 0) = CT
  __sn_wrap_libclang_clang_getTypedefName((__ptr_0 + 0), (__ptr_1 + 0))
  !(__ptr_1 + 0)

/**
 * Returns the typedef name of the given type.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getTypedefName(CT : Ptr[CXType])(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getTypedefName(CT, __return)

/**
 * Retrieve the spelling of a given CXUnaryOperatorKind.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getUnaryOperatorKindSpelling(kind : CXUnaryOperatorKind)(using Zone): CXString = 
  val __ptr_0: Ptr[CXString] = alloc[CXString](1)
  __sn_wrap_libclang_clang_getUnaryOperatorKindSpelling(kind, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the spelling of a given CXUnaryOperatorKind.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getUnaryOperatorKindSpelling(kind : CXUnaryOperatorKind)(__return : Ptr[CXString]): Unit = 
  __sn_wrap_libclang_clang_getUnaryOperatorKindSpelling(kind, __return)

/**
 * Retrieve the unqualified variant of the given type, removing as little sugar as possible.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getUnqualifiedType(CT : Ptr[CXType])(__return : Ptr[CXType]): Unit = 
  __sn_wrap_libclang_clang_getUnqualifiedType(CT, __return)

/**
 * Retrieve the unqualified variant of the given type, removing as little sugar as possible.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getUnqualifiedType(CT : Ptr[CXType])(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  __sn_wrap_libclang_clang_getUnqualifiedType(CT, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the unqualified variant of the given type, removing as little sugar as possible.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_getUnqualifiedType(CT : CXType)(using Zone): CXType = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](2)
  !(__ptr_0 + 0) = CT
  __sn_wrap_libclang_clang_getUnqualifiedType((__ptr_0 + 0), (__ptr_0 + 1))
  !(__ptr_0 + 1)

/**
 * Compute a hash value for the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_hashCursor(_0 : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_hashCursor(_0)

/**
 * Compute a hash value for the given cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_hashCursor(_0 : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_hashCursor((__ptr_0 + 0))

/**
 * Retrieve the CXSourceLocation represented by the given CXIdxLoc.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_indexLoc_getCXSourceLocation(loc : Ptr[CXIdxLoc])(using Zone): CXSourceLocation = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  __sn_wrap_libclang_clang_indexLoc_getCXSourceLocation(loc, (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the CXSourceLocation represented by the given CXIdxLoc.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_indexLoc_getCXSourceLocation(loc : CXIdxLoc)(using Zone): CXSourceLocation = 
  val __ptr_0: Ptr[CXSourceLocation] = alloc[CXSourceLocation](1)
  val __ptr_1: Ptr[CXIdxLoc] = alloc[CXIdxLoc](1)
  !(__ptr_1 + 0) = loc
  __sn_wrap_libclang_clang_indexLoc_getCXSourceLocation((__ptr_1 + 0), (__ptr_0 + 0))
  !(__ptr_0 + 0)

/**
 * Retrieve the CXSourceLocation represented by the given CXIdxLoc.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_indexLoc_getCXSourceLocation(loc : Ptr[CXIdxLoc])(__return : Ptr[CXSourceLocation]): Unit = 
  __sn_wrap_libclang_clang_indexLoc_getCXSourceLocation(loc, __return)

/**
 * Retrieve the CXIdxFile, file, line, column, and offset represented by the given CXIdxLoc.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_indexLoc_getFileLocation(loc : CXIdxLoc, indexFile : Ptr[CXIdxClientFile], file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt])(using Zone): Unit = 
  val __ptr_0: Ptr[CXIdxLoc] = alloc[CXIdxLoc](1)
  !(__ptr_0 + 0) = loc
  __sn_wrap_libclang_clang_indexLoc_getFileLocation((__ptr_0 + 0), indexFile, file, line, column, offset)

/**
 * Retrieve the CXIdxFile, file, line, column, and offset represented by the given CXIdxLoc.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_indexLoc_getFileLocation(loc : Ptr[CXIdxLoc], indexFile : Ptr[CXIdxClientFile], file : Ptr[CXFile], line : Ptr[CUnsignedInt], column : Ptr[CUnsignedInt], offset : Ptr[CUnsignedInt]): Unit = 
  __sn_wrap_libclang_clang_indexLoc_getFileLocation(loc, indexFile, file, line, column, offset)

/**
 * Determine whether a CXType has the "const" qualifier set, without looking through typedefs that may have added "const" at a different level.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isConstQualifiedType(T : CXType)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_isConstQualifiedType((__ptr_0 + 0))

/**
 * Determine whether a CXType has the "const" qualifier set, without looking through typedefs that may have added "const" at a different level.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isConstQualifiedType(T : Ptr[CXType]): CUnsignedInt = 
  __sn_wrap_libclang_clang_isConstQualifiedType(T)

/**
 * Determine whether the declaration pointed to by this cursor is also a definition of that entity.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isCursorDefinition(_0 : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_isCursorDefinition((__ptr_0 + 0))

/**
 * Determine whether the declaration pointed to by this cursor is also a definition of that entity.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isCursorDefinition(_0 : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_isCursorDefinition(_0)

/**
 * Return 1 if the CXType is a variadic function type, and 0 otherwise.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isFunctionTypeVariadic(T : Ptr[CXType]): CUnsignedInt = 
  __sn_wrap_libclang_clang_isFunctionTypeVariadic(T)

/**
 * Return 1 if the CXType is a variadic function type, and 0 otherwise.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isFunctionTypeVariadic(T : CXType)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_isFunctionTypeVariadic((__ptr_0 + 0))

/**
 * Determine whether the given declaration is invalid.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isInvalidDeclaration(_0 : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_isInvalidDeclaration(_0)

/**
 * Determine whether the given declaration is invalid.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isInvalidDeclaration(_0 : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_isInvalidDeclaration((__ptr_0 + 0))

/**
 * Return 1 if the CXType is a POD (plain old data) type, and 0 otherwise.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isPODType(T : CXType)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_isPODType((__ptr_0 + 0))

/**
 * Return 1 if the CXType is a POD (plain old data) type, and 0 otherwise.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isPODType(T : Ptr[CXType]): CUnsignedInt = 
  __sn_wrap_libclang_clang_isPODType(T)

/**
 * Determine whether a CXType has the "restrict" qualifier set, without looking through typedefs that may have added "restrict" at a different level.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isRestrictQualifiedType(T : Ptr[CXType]): CUnsignedInt = 
  __sn_wrap_libclang_clang_isRestrictQualifiedType(T)

/**
 * Determine whether a CXType has the "restrict" qualifier set, without looking through typedefs that may have added "restrict" at a different level.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isRestrictQualifiedType(T : CXType)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_isRestrictQualifiedType((__ptr_0 + 0))

/**
 * Returns 1 if the base class specified by the cursor with kind CX_CXXBaseSpecifier is virtual.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isVirtualBase(_0 : CXCursor)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = _0
  __sn_wrap_libclang_clang_isVirtualBase((__ptr_0 + 0))

/**
 * Returns 1 if the base class specified by the cursor with kind CX_CXXBaseSpecifier is virtual.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isVirtualBase(_0 : Ptr[CXCursor]): CUnsignedInt = 
  __sn_wrap_libclang_clang_isVirtualBase(_0)

/**
 * Determine whether a CXType has the "volatile" qualifier set, without looking through typedefs that may have added "volatile" at a different level.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isVolatileQualifiedType(T : CXType)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXType] = alloc[CXType](1)
  !(__ptr_0 + 0) = T
  __sn_wrap_libclang_clang_isVolatileQualifiedType((__ptr_0 + 0))

/**
 * Determine whether a CXType has the "volatile" qualifier set, without looking through typedefs that may have added "volatile" at a different level.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_isVolatileQualifiedType(T : Ptr[CXType]): CUnsignedInt = 
  __sn_wrap_libclang_clang_isVolatileQualifiedType(T)

/**
 * Tokenize the source code described by the given range into raw lexical tokens.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_tokenize(TU : CXTranslationUnit, Range : Ptr[CXSourceRange], Tokens : Ptr[Ptr[CXToken]], NumTokens : Ptr[CUnsignedInt]): Unit = 
  __sn_wrap_libclang_clang_tokenize(TU, Range, Tokens, NumTokens)

/**
 * Tokenize the source code described by the given range into raw lexical tokens.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_tokenize(TU : CXTranslationUnit, Range : CXSourceRange, Tokens : Ptr[Ptr[CXToken]], NumTokens : Ptr[CUnsignedInt])(using Zone): Unit = 
  val __ptr_0: Ptr[CXSourceRange] = alloc[CXSourceRange](1)
  !(__ptr_0 + 0) = Range
  __sn_wrap_libclang_clang_tokenize(TU, (__ptr_0 + 0), Tokens, NumTokens)

/**
 * Visit the children of a particular cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_visitChildren(parent : Ptr[CXCursor], visitor : CXCursorVisitor, client_data : CXClientData): CUnsignedInt = 
  __sn_wrap_libclang_clang_visitChildren(parent, visitor, client_data)

/**
 * Visit the children of a particular cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_visitChildren(parent : CXCursor, visitor : CXCursorVisitor, client_data : CXClientData)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = parent
  __sn_wrap_libclang_clang_visitChildren((__ptr_0 + 0), visitor, client_data)

/**
 * Visits the children of a cursor using the specified block. Behaves identically to clang_visitChildren() in all other respects.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_visitChildrenWithBlock(parent : CXCursor, block : CXCursorVisitorBlock)(using Zone): CUnsignedInt = 
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = parent
  __sn_wrap_libclang_clang_visitChildrenWithBlock((__ptr_0 + 0), block)

/**
 * Visits the children of a cursor using the specified block. Behaves identically to clang_visitChildren() in all other respects.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
def clang_visitChildrenWithBlock(parent : Ptr[CXCursor], block : CXCursorVisitorBlock): CUnsignedInt = 
  __sn_wrap_libclang_clang_visitChildrenWithBlock(parent, block)