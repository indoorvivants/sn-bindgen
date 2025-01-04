#include <string.h>
#include "clang-c/Index.h"

unsigned int __sn_wrap_libclang_clang_CXCursorSet_contains(CXCursorSet cset, CXCursor *cursor) {
 return clang_CXCursorSet_contains(cset, *cursor);
};


unsigned int __sn_wrap_libclang_clang_CXCursorSet_insert(CXCursorSet cset, CXCursor *cursor) {
 return clang_CXCursorSet_insert(cset, *cursor);
};


unsigned int __sn_wrap_libclang_clang_CXXConstructor_isConvertingConstructor(CXCursor *C) {
 return clang_CXXConstructor_isConvertingConstructor(*C);
};


unsigned int __sn_wrap_libclang_clang_CXXConstructor_isCopyConstructor(CXCursor *C) {
 return clang_CXXConstructor_isCopyConstructor(*C);
};


unsigned int __sn_wrap_libclang_clang_CXXConstructor_isDefaultConstructor(CXCursor *C) {
 return clang_CXXConstructor_isDefaultConstructor(*C);
};


unsigned int __sn_wrap_libclang_clang_CXXConstructor_isMoveConstructor(CXCursor *C) {
 return clang_CXXConstructor_isMoveConstructor(*C);
};


unsigned int __sn_wrap_libclang_clang_CXXField_isMutable(CXCursor *C) {
 return clang_CXXField_isMutable(*C);
};


unsigned int __sn_wrap_libclang_clang_CXXMethod_isConst(CXCursor *C) {
 return clang_CXXMethod_isConst(*C);
};


unsigned int __sn_wrap_libclang_clang_CXXMethod_isCopyAssignmentOperator(CXCursor *C) {
 return clang_CXXMethod_isCopyAssignmentOperator(*C);
};


unsigned int __sn_wrap_libclang_clang_CXXMethod_isDefaulted(CXCursor *C) {
 return clang_CXXMethod_isDefaulted(*C);
};


unsigned int __sn_wrap_libclang_clang_CXXMethod_isDeleted(CXCursor *C) {
 return clang_CXXMethod_isDeleted(*C);
};


unsigned int __sn_wrap_libclang_clang_CXXMethod_isExplicit(CXCursor *C) {
 return clang_CXXMethod_isExplicit(*C);
};


unsigned int __sn_wrap_libclang_clang_CXXMethod_isMoveAssignmentOperator(CXCursor *C) {
 return clang_CXXMethod_isMoveAssignmentOperator(*C);
};


unsigned int __sn_wrap_libclang_clang_CXXMethod_isPureVirtual(CXCursor *C) {
 return clang_CXXMethod_isPureVirtual(*C);
};


unsigned int __sn_wrap_libclang_clang_CXXMethod_isStatic(CXCursor *C) {
 return clang_CXXMethod_isStatic(*C);
};


unsigned int __sn_wrap_libclang_clang_CXXMethod_isVirtual(CXCursor *C) {
 return clang_CXXMethod_isVirtual(*C);
};


unsigned int __sn_wrap_libclang_clang_CXXRecord_isAbstract(CXCursor *C) {
 return clang_CXXRecord_isAbstract(*C);
};


CXEvalResult __sn_wrap_libclang_clang_Cursor_Evaluate(CXCursor *C) {
 return clang_Cursor_Evaluate(*C);
};


void __sn_wrap_libclang_clang_Cursor_getArgument(CXCursor *C, unsigned int i, CXCursor *____return) {
  CXCursor ____ret = clang_Cursor_getArgument(*C, i);
  memcpy(____return, &____ret, sizeof(CXCursor));
}


enum CX_BinaryOperatorKind __sn_wrap_libclang_clang_Cursor_getBinaryOpcode(CXCursor *C) {
 return clang_Cursor_getBinaryOpcode(*C);
};


void __sn_wrap_libclang_clang_Cursor_getBinaryOpcodeStr(enum CX_BinaryOperatorKind Op, CXString *____return) {
  CXString ____ret = clang_Cursor_getBinaryOpcodeStr(Op);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_Cursor_getBriefCommentText(CXCursor *C, CXString *____return) {
  CXString ____ret = clang_Cursor_getBriefCommentText(*C);
  memcpy(____return, &____ret, sizeof(CXString));
}


CXStringSet * __sn_wrap_libclang_clang_Cursor_getCXXManglings(CXCursor *_0) {
 return clang_Cursor_getCXXManglings(*_0);
};


void __sn_wrap_libclang_clang_Cursor_getCommentRange(CXCursor *C, CXSourceRange *____return) {
  CXSourceRange ____ret = clang_Cursor_getCommentRange(*C);
  memcpy(____return, &____ret, sizeof(CXSourceRange));
}


void __sn_wrap_libclang_clang_Cursor_getMangling(CXCursor *_0, CXString *____return) {
  CXString ____ret = clang_Cursor_getMangling(*_0);
  memcpy(____return, &____ret, sizeof(CXString));
}


CXModule __sn_wrap_libclang_clang_Cursor_getModule(CXCursor *C) {
 return clang_Cursor_getModule(*C);
};


int __sn_wrap_libclang_clang_Cursor_getNumArguments(CXCursor *C) {
 return clang_Cursor_getNumArguments(*C);
};


int __sn_wrap_libclang_clang_Cursor_getNumTemplateArguments(CXCursor *C) {
 return clang_Cursor_getNumTemplateArguments(*C);
};


unsigned int __sn_wrap_libclang_clang_Cursor_getObjCDeclQualifiers(CXCursor *C) {
 return clang_Cursor_getObjCDeclQualifiers(*C);
};


CXStringSet * __sn_wrap_libclang_clang_Cursor_getObjCManglings(CXCursor *_0) {
 return clang_Cursor_getObjCManglings(*_0);
};


unsigned int __sn_wrap_libclang_clang_Cursor_getObjCPropertyAttributes(CXCursor *C, unsigned int reserved) {
 return clang_Cursor_getObjCPropertyAttributes(*C, reserved);
};


void __sn_wrap_libclang_clang_Cursor_getObjCPropertyGetterName(CXCursor *C, CXString *____return) {
  CXString ____ret = clang_Cursor_getObjCPropertyGetterName(*C);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_Cursor_getObjCPropertySetterName(CXCursor *C, CXString *____return) {
  CXString ____ret = clang_Cursor_getObjCPropertySetterName(*C);
  memcpy(____return, &____ret, sizeof(CXString));
}


int __sn_wrap_libclang_clang_Cursor_getObjCSelectorIndex(CXCursor *_0) {
 return clang_Cursor_getObjCSelectorIndex(*_0);
};


long long __sn_wrap_libclang_clang_Cursor_getOffsetOfField(CXCursor *C) {
 return clang_Cursor_getOffsetOfField(*C);
};


void __sn_wrap_libclang_clang_Cursor_getRawCommentText(CXCursor *C, CXString *____return) {
  CXString ____ret = clang_Cursor_getRawCommentText(*C);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_Cursor_getReceiverType(CXCursor *C, CXType *____return) {
  CXType ____ret = clang_Cursor_getReceiverType(*C);
  memcpy(____return, &____ret, sizeof(CXType));
}


void __sn_wrap_libclang_clang_Cursor_getSpellingNameRange(CXCursor *_0, unsigned int pieceIndex, unsigned int options, CXSourceRange *____return) {
  CXSourceRange ____ret = clang_Cursor_getSpellingNameRange(*_0, pieceIndex, options);
  memcpy(____return, &____ret, sizeof(CXSourceRange));
}


enum CX_StorageClass __sn_wrap_libclang_clang_Cursor_getStorageClass(CXCursor *_0) {
 return clang_Cursor_getStorageClass(*_0);
};


enum CXTemplateArgumentKind __sn_wrap_libclang_clang_Cursor_getTemplateArgumentKind(CXCursor *C, unsigned int I) {
 return clang_Cursor_getTemplateArgumentKind(*C, I);
};


void __sn_wrap_libclang_clang_Cursor_getTemplateArgumentType(CXCursor *C, unsigned int I, CXType *____return) {
  CXType ____ret = clang_Cursor_getTemplateArgumentType(*C, I);
  memcpy(____return, &____ret, sizeof(CXType));
}


unsigned long long __sn_wrap_libclang_clang_Cursor_getTemplateArgumentUnsignedValue(CXCursor *C, unsigned int I) {
 return clang_Cursor_getTemplateArgumentUnsignedValue(*C, I);
};


long long __sn_wrap_libclang_clang_Cursor_getTemplateArgumentValue(CXCursor *C, unsigned int I) {
 return clang_Cursor_getTemplateArgumentValue(*C, I);
};


CXTranslationUnit __sn_wrap_libclang_clang_Cursor_getTranslationUnit(CXCursor *_0) {
 return clang_Cursor_getTranslationUnit(*_0);
};


void __sn_wrap_libclang_clang_Cursor_getVarDeclInitializer(CXCursor *cursor, CXCursor *____return) {
  CXCursor ____ret = clang_Cursor_getVarDeclInitializer(*cursor);
  memcpy(____return, &____ret, sizeof(CXCursor));
}


unsigned int __sn_wrap_libclang_clang_Cursor_hasAttrs(CXCursor *C) {
 return clang_Cursor_hasAttrs(*C);
};


int __sn_wrap_libclang_clang_Cursor_hasVarDeclExternalStorage(CXCursor *cursor) {
 return clang_Cursor_hasVarDeclExternalStorage(*cursor);
};


int __sn_wrap_libclang_clang_Cursor_hasVarDeclGlobalStorage(CXCursor *cursor) {
 return clang_Cursor_hasVarDeclGlobalStorage(*cursor);
};


unsigned int __sn_wrap_libclang_clang_Cursor_isAnonymous(CXCursor *C) {
 return clang_Cursor_isAnonymous(*C);
};


unsigned int __sn_wrap_libclang_clang_Cursor_isAnonymousRecordDecl(CXCursor *C) {
 return clang_Cursor_isAnonymousRecordDecl(*C);
};


unsigned int __sn_wrap_libclang_clang_Cursor_isBitField(CXCursor *C) {
 return clang_Cursor_isBitField(*C);
};


int __sn_wrap_libclang_clang_Cursor_isDynamicCall(CXCursor *C) {
 return clang_Cursor_isDynamicCall(*C);
};


unsigned int __sn_wrap_libclang_clang_Cursor_isExternalSymbol(CXCursor *C, CXString * language, CXString * definedIn, unsigned int * isGenerated) {
 return clang_Cursor_isExternalSymbol(*C, language, definedIn, isGenerated);
};


unsigned int __sn_wrap_libclang_clang_Cursor_isFunctionInlined(CXCursor *C) {
 return clang_Cursor_isFunctionInlined(*C);
};


unsigned int __sn_wrap_libclang_clang_Cursor_isInlineNamespace(CXCursor *C) {
 return clang_Cursor_isInlineNamespace(*C);
};


unsigned int __sn_wrap_libclang_clang_Cursor_isMacroBuiltin(CXCursor *C) {
 return clang_Cursor_isMacroBuiltin(*C);
};


unsigned int __sn_wrap_libclang_clang_Cursor_isMacroFunctionLike(CXCursor *C) {
 return clang_Cursor_isMacroFunctionLike(*C);
};


int __sn_wrap_libclang_clang_Cursor_isNull(CXCursor *cursor) {
 return clang_Cursor_isNull(*cursor);
};


unsigned int __sn_wrap_libclang_clang_Cursor_isObjCOptional(CXCursor *C) {
 return clang_Cursor_isObjCOptional(*C);
};


unsigned int __sn_wrap_libclang_clang_Cursor_isVariadic(CXCursor *C) {
 return clang_Cursor_isVariadic(*C);
};


unsigned int __sn_wrap_libclang_clang_EnumDecl_isScoped(CXCursor *C) {
 return clang_EnumDecl_isScoped(*C);
};


void __sn_wrap_libclang_clang_File_tryGetRealPathName(CXFile file, CXString *____return) {
  CXString ____ret = clang_File_tryGetRealPathName(file);
  memcpy(____return, &____ret, sizeof(CXString));
}


int __sn_wrap_libclang_clang_Location_isFromMainFile(CXSourceLocation *location) {
 return clang_Location_isFromMainFile(*location);
};


int __sn_wrap_libclang_clang_Location_isInSystemHeader(CXSourceLocation *location) {
 return clang_Location_isInSystemHeader(*location);
};


void __sn_wrap_libclang_clang_Module_getFullName(CXModule Module, CXString *____return) {
  CXString ____ret = clang_Module_getFullName(Module);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_Module_getName(CXModule Module, CXString *____return) {
  CXString ____ret = clang_Module_getName(Module);
  memcpy(____return, &____ret, sizeof(CXString));
}


int __sn_wrap_libclang_clang_Range_isNull(CXSourceRange *range) {
 return clang_Range_isNull(*range);
};


void __sn_wrap_libclang_clang_TargetInfo_getTriple(CXTargetInfo Info, CXString *____return) {
  CXString ____ret = clang_TargetInfo_getTriple(Info);
  memcpy(____return, &____ret, sizeof(CXString));
}


long long __sn_wrap_libclang_clang_Type_getAlignOf(CXType *T) {
 return clang_Type_getAlignOf(*T);
};


enum CXRefQualifierKind __sn_wrap_libclang_clang_Type_getCXXRefQualifier(CXType *T) {
 return clang_Type_getCXXRefQualifier(*T);
};


void __sn_wrap_libclang_clang_Type_getClassType(CXType *T, CXType *____return) {
  CXType ____ret = clang_Type_getClassType(*T);
  memcpy(____return, &____ret, sizeof(CXType));
}


void __sn_wrap_libclang_clang_Type_getModifiedType(CXType *T, CXType *____return) {
  CXType ____ret = clang_Type_getModifiedType(*T);
  memcpy(____return, &____ret, sizeof(CXType));
}


void __sn_wrap_libclang_clang_Type_getNamedType(CXType *T, CXType *____return) {
  CXType ____ret = clang_Type_getNamedType(*T);
  memcpy(____return, &____ret, sizeof(CXType));
}


enum CXTypeNullabilityKind __sn_wrap_libclang_clang_Type_getNullability(CXType *T) {
 return clang_Type_getNullability(*T);
};


unsigned int __sn_wrap_libclang_clang_Type_getNumObjCProtocolRefs(CXType *T) {
 return clang_Type_getNumObjCProtocolRefs(*T);
};


unsigned int __sn_wrap_libclang_clang_Type_getNumObjCTypeArgs(CXType *T) {
 return clang_Type_getNumObjCTypeArgs(*T);
};


int __sn_wrap_libclang_clang_Type_getNumTemplateArguments(CXType *T) {
 return clang_Type_getNumTemplateArguments(*T);
};


void __sn_wrap_libclang_clang_Type_getObjCEncoding(CXType *type, CXString *____return) {
  CXString ____ret = clang_Type_getObjCEncoding(*type);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_Type_getObjCObjectBaseType(CXType *T, CXType *____return) {
  CXType ____ret = clang_Type_getObjCObjectBaseType(*T);
  memcpy(____return, &____ret, sizeof(CXType));
}


void __sn_wrap_libclang_clang_Type_getObjCProtocolDecl(CXType *T, unsigned int i, CXCursor *____return) {
  CXCursor ____ret = clang_Type_getObjCProtocolDecl(*T, i);
  memcpy(____return, &____ret, sizeof(CXCursor));
}


void __sn_wrap_libclang_clang_Type_getObjCTypeArg(CXType *T, unsigned int i, CXType *____return) {
  CXType ____ret = clang_Type_getObjCTypeArg(*T, i);
  memcpy(____return, &____ret, sizeof(CXType));
}


long long __sn_wrap_libclang_clang_Type_getOffsetOf(CXType *T, const char * S) {
 return clang_Type_getOffsetOf(*T, S);
};


long long __sn_wrap_libclang_clang_Type_getSizeOf(CXType *T) {
 return clang_Type_getSizeOf(*T);
};


void __sn_wrap_libclang_clang_Type_getTemplateArgumentAsType(CXType *T, unsigned int i, CXType *____return) {
  CXType ____ret = clang_Type_getTemplateArgumentAsType(*T, i);
  memcpy(____return, &____ret, sizeof(CXType));
}


void __sn_wrap_libclang_clang_Type_getValueType(CXType *CT, CXType *____return) {
  CXType ____ret = clang_Type_getValueType(*CT);
  memcpy(____return, &____ret, sizeof(CXType));
}


unsigned int __sn_wrap_libclang_clang_Type_isTransparentTagTypedef(CXType *T) {
 return clang_Type_isTransparentTagTypedef(*T);
};


unsigned int __sn_wrap_libclang_clang_Type_visitFields(CXType *T, CXFieldVisitor visitor, CXClientData client_data) {
 return clang_Type_visitFields(*T, visitor, client_data);
};


void __sn_wrap_libclang_clang_codeCompleteGetContainerUSR(CXCodeCompleteResults * Results, CXString *____return) {
  CXString ____ret = clang_codeCompleteGetContainerUSR(Results);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_codeCompleteGetObjCSelector(CXCodeCompleteResults * Results, CXString *____return) {
  CXString ____ret = clang_codeCompleteGetObjCSelector(Results);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_constructUSR_ObjCCategory(const char * class_name, const char * category_name, CXString *____return) {
  CXString ____ret = clang_constructUSR_ObjCCategory(class_name, category_name);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_constructUSR_ObjCClass(const char * class_name, CXString *____return) {
  CXString ____ret = clang_constructUSR_ObjCClass(class_name);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_constructUSR_ObjCIvar(const char * name, CXString *classUSR, CXString *____return) {
  CXString ____ret = clang_constructUSR_ObjCIvar(name, *classUSR);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_constructUSR_ObjCMethod(const char * name, unsigned int isInstanceMethod, CXString *classUSR, CXString *____return) {
  CXString ____ret = clang_constructUSR_ObjCMethod(name, isInstanceMethod, *classUSR);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_constructUSR_ObjCProperty(const char * property, CXString *classUSR, CXString *____return) {
  CXString ____ret = clang_constructUSR_ObjCProperty(property, *classUSR);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_constructUSR_ObjCProtocol(const char * protocol_name, CXString *____return) {
  CXString ____ret = clang_constructUSR_ObjCProtocol(protocol_name);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_disposeCXTUResourceUsage(CXTUResourceUsage *usage) {
 clang_disposeCXTUResourceUsage(*usage);
};


void __sn_wrap_libclang_clang_disposeString(CXString *string) {
 clang_disposeString(*string);
};


unsigned int __sn_wrap_libclang_clang_equalCursors(CXCursor *_0, CXCursor *_1) {
 return clang_equalCursors(*_0, *_1);
};


unsigned int __sn_wrap_libclang_clang_equalLocations(CXSourceLocation *loc1, CXSourceLocation *loc2) {
 return clang_equalLocations(*loc1, *loc2);
};


unsigned int __sn_wrap_libclang_clang_equalRanges(CXSourceRange *range1, CXSourceRange *range2) {
 return clang_equalRanges(*range1, *range2);
};


unsigned int __sn_wrap_libclang_clang_equalTypes(CXType *A, CXType *B) {
 return clang_equalTypes(*A, *B);
};


CXResult __sn_wrap_libclang_clang_findIncludesInFile(CXTranslationUnit TU, CXFile file, CXCursorAndRangeVisitor *visitor) {
 return clang_findIncludesInFile(TU, file, *visitor);
};


CXResult __sn_wrap_libclang_clang_findReferencesInFile(CXCursor *cursor, CXFile file, CXCursorAndRangeVisitor *visitor) {
 return clang_findReferencesInFile(*cursor, file, *visitor);
};


CXResult __sn_wrap_libclang_clang_findReferencesInFileWithBlock(CXCursor *_0, CXFile _1, CXCursorAndRangeVisitorBlock _2) {
 return clang_findReferencesInFileWithBlock(*_0, _1, _2);
};


void __sn_wrap_libclang_clang_formatDiagnostic(CXDiagnostic Diagnostic, unsigned int Options, CXString *____return) {
  CXString ____ret = clang_formatDiagnostic(Diagnostic, Options);
  memcpy(____return, &____ret, sizeof(CXString));
}


unsigned int __sn_wrap_libclang_clang_getAddressSpace(CXType *T) {
 return clang_getAddressSpace(*T);
};


void __sn_wrap_libclang_clang_getArgType(CXType *T, unsigned int i, CXType *____return) {
  CXType ____ret = clang_getArgType(*T, i);
  memcpy(____return, &____ret, sizeof(CXType));
}


void __sn_wrap_libclang_clang_getArrayElementType(CXType *T, CXType *____return) {
  CXType ____ret = clang_getArrayElementType(*T);
  memcpy(____return, &____ret, sizeof(CXType));
}


long long __sn_wrap_libclang_clang_getArraySize(CXType *T) {
 return clang_getArraySize(*T);
};


void __sn_wrap_libclang_clang_getBinaryOperatorKindSpelling(enum CXBinaryOperatorKind kind, CXString *____return) {
  CXString ____ret = clang_getBinaryOperatorKindSpelling(kind);
  memcpy(____return, &____ret, sizeof(CXString));
}


const char * __sn_wrap_libclang_clang_getCString(CXString *string) {
 return clang_getCString(*string);
};


void __sn_wrap_libclang_clang_getCXTUResourceUsage(CXTranslationUnit TU, CXTUResourceUsage *____return) {
  CXTUResourceUsage ____ret = clang_getCXTUResourceUsage(TU);
  memcpy(____return, &____ret, sizeof(CXTUResourceUsage));
}


enum CX_CXXAccessSpecifier __sn_wrap_libclang_clang_getCXXAccessSpecifier(CXCursor *_0) {
 return clang_getCXXAccessSpecifier(*_0);
};


void __sn_wrap_libclang_clang_getCanonicalCursor(CXCursor *_0, CXCursor *____return) {
  CXCursor ____ret = clang_getCanonicalCursor(*_0);
  memcpy(____return, &____ret, sizeof(CXCursor));
}


void __sn_wrap_libclang_clang_getCanonicalType(CXType *T, CXType *____return) {
  CXType ____ret = clang_getCanonicalType(*T);
  memcpy(____return, &____ret, sizeof(CXType));
}


void __sn_wrap_libclang_clang_getClangVersion(CXString *____return) {
  CXString ____ret = clang_getClangVersion();
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getCompletionAnnotation(CXCompletionString completion_string, unsigned int annotation_number, CXString *____return) {
  CXString ____ret = clang_getCompletionAnnotation(completion_string, annotation_number);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getCompletionBriefComment(CXCompletionString completion_string, CXString *____return) {
  CXString ____ret = clang_getCompletionBriefComment(completion_string);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getCompletionChunkText(CXCompletionString completion_string, unsigned int chunk_number, CXString *____return) {
  CXString ____ret = clang_getCompletionChunkText(completion_string, chunk_number);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getCompletionFixIt(CXCodeCompleteResults * results, unsigned int completion_index, unsigned int fixit_index, CXSourceRange * replacement_range, CXString *____return) {
  CXString ____ret = clang_getCompletionFixIt(results, completion_index, fixit_index, replacement_range);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getCompletionParent(CXCompletionString completion_string, enum CXCursorKind * kind, CXString *____return) {
  CXString ____ret = clang_getCompletionParent(completion_string, kind);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getCursor(CXTranslationUnit _0, CXSourceLocation *_1, CXCursor *____return) {
  CXCursor ____ret = clang_getCursor(_0, *_1);
  memcpy(____return, &____ret, sizeof(CXCursor));
}


enum CXAvailabilityKind __sn_wrap_libclang_clang_getCursorAvailability(CXCursor *cursor) {
 return clang_getCursorAvailability(*cursor);
};


enum CXBinaryOperatorKind __sn_wrap_libclang_clang_getCursorBinaryOperatorKind(CXCursor *cursor) {
 return clang_getCursorBinaryOperatorKind(*cursor);
};


CXCompletionString __sn_wrap_libclang_clang_getCursorCompletionString(CXCursor *cursor) {
 return clang_getCursorCompletionString(*cursor);
};


void __sn_wrap_libclang_clang_getCursorDefinition(CXCursor *_0, CXCursor *____return) {
  CXCursor ____ret = clang_getCursorDefinition(*_0);
  memcpy(____return, &____ret, sizeof(CXCursor));
}


void __sn_wrap_libclang_clang_getCursorDisplayName(CXCursor *_0, CXString *____return) {
  CXString ____ret = clang_getCursorDisplayName(*_0);
  memcpy(____return, &____ret, sizeof(CXString));
}


int __sn_wrap_libclang_clang_getCursorExceptionSpecificationType(CXCursor *C) {
 return clang_getCursorExceptionSpecificationType(*C);
};


void __sn_wrap_libclang_clang_getCursorExtent(CXCursor *_0, CXSourceRange *____return) {
  CXSourceRange ____ret = clang_getCursorExtent(*_0);
  memcpy(____return, &____ret, sizeof(CXSourceRange));
}


enum CXCursorKind __sn_wrap_libclang_clang_getCursorKind(CXCursor *_0) {
 return clang_getCursorKind(*_0);
};


void __sn_wrap_libclang_clang_getCursorKindSpelling(enum CXCursorKind Kind, CXString *____return) {
  CXString ____ret = clang_getCursorKindSpelling(Kind);
  memcpy(____return, &____ret, sizeof(CXString));
}


enum CXLanguageKind __sn_wrap_libclang_clang_getCursorLanguage(CXCursor *cursor) {
 return clang_getCursorLanguage(*cursor);
};


void __sn_wrap_libclang_clang_getCursorLexicalParent(CXCursor *cursor, CXCursor *____return) {
  CXCursor ____ret = clang_getCursorLexicalParent(*cursor);
  memcpy(____return, &____ret, sizeof(CXCursor));
}


enum CXLinkageKind __sn_wrap_libclang_clang_getCursorLinkage(CXCursor *cursor) {
 return clang_getCursorLinkage(*cursor);
};


void __sn_wrap_libclang_clang_getCursorLocation(CXCursor *_0, CXSourceLocation *____return) {
  CXSourceLocation ____ret = clang_getCursorLocation(*_0);
  memcpy(____return, &____ret, sizeof(CXSourceLocation));
}


int __sn_wrap_libclang_clang_getCursorPlatformAvailability(CXCursor *cursor, int * always_deprecated, CXString * deprecated_message, int * always_unavailable, CXString * unavailable_message, CXPlatformAvailability * availability, int availability_size) {
 return clang_getCursorPlatformAvailability(*cursor, always_deprecated, deprecated_message, always_unavailable, unavailable_message, availability, availability_size);
};


void __sn_wrap_libclang_clang_getCursorPrettyPrinted(CXCursor *Cursor, CXPrintingPolicy Policy, CXString *____return) {
  CXString ____ret = clang_getCursorPrettyPrinted(*Cursor, Policy);
  memcpy(____return, &____ret, sizeof(CXString));
}


CXPrintingPolicy __sn_wrap_libclang_clang_getCursorPrintingPolicy(CXCursor *_0) {
 return clang_getCursorPrintingPolicy(*_0);
};


void __sn_wrap_libclang_clang_getCursorReferenceNameRange(CXCursor *C, unsigned int NameFlags, unsigned int PieceIndex, CXSourceRange *____return) {
  CXSourceRange ____ret = clang_getCursorReferenceNameRange(*C, NameFlags, PieceIndex);
  memcpy(____return, &____ret, sizeof(CXSourceRange));
}


void __sn_wrap_libclang_clang_getCursorReferenced(CXCursor *_0, CXCursor *____return) {
  CXCursor ____ret = clang_getCursorReferenced(*_0);
  memcpy(____return, &____ret, sizeof(CXCursor));
}


void __sn_wrap_libclang_clang_getCursorResultType(CXCursor *C, CXType *____return) {
  CXType ____ret = clang_getCursorResultType(*C);
  memcpy(____return, &____ret, sizeof(CXType));
}


void __sn_wrap_libclang_clang_getCursorSemanticParent(CXCursor *cursor, CXCursor *____return) {
  CXCursor ____ret = clang_getCursorSemanticParent(*cursor);
  memcpy(____return, &____ret, sizeof(CXCursor));
}


void __sn_wrap_libclang_clang_getCursorSpelling(CXCursor *_0, CXString *____return) {
  CXString ____ret = clang_getCursorSpelling(*_0);
  memcpy(____return, &____ret, sizeof(CXString));
}


enum CXTLSKind __sn_wrap_libclang_clang_getCursorTLSKind(CXCursor *cursor) {
 return clang_getCursorTLSKind(*cursor);
};


void __sn_wrap_libclang_clang_getCursorType(CXCursor *C, CXType *____return) {
  CXType ____ret = clang_getCursorType(*C);
  memcpy(____return, &____ret, sizeof(CXType));
}


void __sn_wrap_libclang_clang_getCursorUSR(CXCursor *_0, CXString *____return) {
  CXString ____ret = clang_getCursorUSR(*_0);
  memcpy(____return, &____ret, sizeof(CXString));
}


enum CXUnaryOperatorKind __sn_wrap_libclang_clang_getCursorUnaryOperatorKind(CXCursor *cursor) {
 return clang_getCursorUnaryOperatorKind(*cursor);
};


enum CXVisibilityKind __sn_wrap_libclang_clang_getCursorVisibility(CXCursor *cursor) {
 return clang_getCursorVisibility(*cursor);
};


void __sn_wrap_libclang_clang_getDeclObjCTypeEncoding(CXCursor *C, CXString *____return) {
  CXString ____ret = clang_getDeclObjCTypeEncoding(*C);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getDefinitionSpellingAndExtent(CXCursor *_0, const char ** startBuf, const char ** endBuf, unsigned int * startLine, unsigned int * startColumn, unsigned int * endLine, unsigned int * endColumn) {
 clang_getDefinitionSpellingAndExtent(*_0, startBuf, endBuf, startLine, startColumn, endLine, endColumn);
};


void __sn_wrap_libclang_clang_getDiagnosticCategoryName(unsigned int Category, CXString *____return) {
  CXString ____ret = clang_getDiagnosticCategoryName(Category);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getDiagnosticCategoryText(CXDiagnostic _0, CXString *____return) {
  CXString ____ret = clang_getDiagnosticCategoryText(_0);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getDiagnosticFixIt(CXDiagnostic Diagnostic, unsigned int FixIt, CXSourceRange * ReplacementRange, CXString *____return) {
  CXString ____ret = clang_getDiagnosticFixIt(Diagnostic, FixIt, ReplacementRange);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getDiagnosticLocation(CXDiagnostic _0, CXSourceLocation *____return) {
  CXSourceLocation ____ret = clang_getDiagnosticLocation(_0);
  memcpy(____return, &____ret, sizeof(CXSourceLocation));
}


void __sn_wrap_libclang_clang_getDiagnosticOption(CXDiagnostic Diag, CXString * Disable, CXString *____return) {
  CXString ____ret = clang_getDiagnosticOption(Diag, Disable);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getDiagnosticRange(CXDiagnostic Diagnostic, unsigned int Range, CXSourceRange *____return) {
  CXSourceRange ____ret = clang_getDiagnosticRange(Diagnostic, Range);
  memcpy(____return, &____ret, sizeof(CXSourceRange));
}


void __sn_wrap_libclang_clang_getDiagnosticSpelling(CXDiagnostic _0, CXString *____return) {
  CXString ____ret = clang_getDiagnosticSpelling(_0);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getElementType(CXType *T, CXType *____return) {
  CXType ____ret = clang_getElementType(*T);
  memcpy(____return, &____ret, sizeof(CXType));
}


unsigned long long __sn_wrap_libclang_clang_getEnumConstantDeclUnsignedValue(CXCursor *C) {
 return clang_getEnumConstantDeclUnsignedValue(*C);
};


long long __sn_wrap_libclang_clang_getEnumConstantDeclValue(CXCursor *C) {
 return clang_getEnumConstantDeclValue(*C);
};


void __sn_wrap_libclang_clang_getEnumDeclIntegerType(CXCursor *C, CXType *____return) {
  CXType ____ret = clang_getEnumDeclIntegerType(*C);
  memcpy(____return, &____ret, sizeof(CXType));
}


int __sn_wrap_libclang_clang_getExceptionSpecificationType(CXType *T) {
 return clang_getExceptionSpecificationType(*T);
};


void __sn_wrap_libclang_clang_getExpansionLocation(CXSourceLocation *location, CXFile * file, unsigned int * line, unsigned int * column, unsigned int * offset) {
 clang_getExpansionLocation(*location, file, line, column, offset);
};


int __sn_wrap_libclang_clang_getFieldDeclBitWidth(CXCursor *C) {
 return clang_getFieldDeclBitWidth(*C);
};


void __sn_wrap_libclang_clang_getFileLocation(CXSourceLocation *location, CXFile * file, unsigned int * line, unsigned int * column, unsigned int * offset) {
 clang_getFileLocation(*location, file, line, column, offset);
};


void __sn_wrap_libclang_clang_getFileName(CXFile SFile, CXString *____return) {
  CXString ____ret = clang_getFileName(SFile);
  memcpy(____return, &____ret, sizeof(CXString));
}


enum CXCallingConv __sn_wrap_libclang_clang_getFunctionTypeCallingConv(CXType *T) {
 return clang_getFunctionTypeCallingConv(*T);
};


void __sn_wrap_libclang_clang_getIBOutletCollectionType(CXCursor *_0, CXType *____return) {
  CXType ____ret = clang_getIBOutletCollectionType(*_0);
  memcpy(____return, &____ret, sizeof(CXType));
}


CXFile __sn_wrap_libclang_clang_getIncludedFile(CXCursor *cursor) {
 return clang_getIncludedFile(*cursor);
};


void __sn_wrap_libclang_clang_getInstantiationLocation(CXSourceLocation *location, CXFile * file, unsigned int * line, unsigned int * column, unsigned int * offset) {
 clang_getInstantiationLocation(*location, file, line, column, offset);
};


void __sn_wrap_libclang_clang_getLocation(CXTranslationUnit tu, CXFile file, unsigned int line, unsigned int column, CXSourceLocation *____return) {
  CXSourceLocation ____ret = clang_getLocation(tu, file, line, column);
  memcpy(____return, &____ret, sizeof(CXSourceLocation));
}


void __sn_wrap_libclang_clang_getLocationForOffset(CXTranslationUnit tu, CXFile file, unsigned int offset, CXSourceLocation *____return) {
  CXSourceLocation ____ret = clang_getLocationForOffset(tu, file, offset);
  memcpy(____return, &____ret, sizeof(CXSourceLocation));
}


void __sn_wrap_libclang_clang_getNonReferenceType(CXType *CT, CXType *____return) {
  CXType ____ret = clang_getNonReferenceType(*CT);
  memcpy(____return, &____ret, sizeof(CXType));
}


void __sn_wrap_libclang_clang_getNullCursor(CXCursor *____return) {
  CXCursor ____ret = clang_getNullCursor();
  memcpy(____return, &____ret, sizeof(CXCursor));
}


void __sn_wrap_libclang_clang_getNullLocation(CXSourceLocation *____return) {
  CXSourceLocation ____ret = clang_getNullLocation();
  memcpy(____return, &____ret, sizeof(CXSourceLocation));
}


void __sn_wrap_libclang_clang_getNullRange(CXSourceRange *____return) {
  CXSourceRange ____ret = clang_getNullRange();
  memcpy(____return, &____ret, sizeof(CXSourceRange));
}


int __sn_wrap_libclang_clang_getNumArgTypes(CXType *T) {
 return clang_getNumArgTypes(*T);
};


long long __sn_wrap_libclang_clang_getNumElements(CXType *T) {
 return clang_getNumElements(*T);
};


unsigned int __sn_wrap_libclang_clang_getNumOverloadedDecls(CXCursor *cursor) {
 return clang_getNumOverloadedDecls(*cursor);
};


void __sn_wrap_libclang_clang_getOverloadedDecl(CXCursor *cursor, unsigned int index, CXCursor *____return) {
  CXCursor ____ret = clang_getOverloadedDecl(*cursor, index);
  memcpy(____return, &____ret, sizeof(CXCursor));
}


void __sn_wrap_libclang_clang_getOverriddenCursors(CXCursor *cursor, CXCursor ** overridden, unsigned int * num_overridden) {
 clang_getOverriddenCursors(*cursor, overridden, num_overridden);
};


void __sn_wrap_libclang_clang_getPointeeType(CXType *T, CXType *____return) {
  CXType ____ret = clang_getPointeeType(*T);
  memcpy(____return, &____ret, sizeof(CXType));
}


void __sn_wrap_libclang_clang_getPresumedLocation(CXSourceLocation *location, CXString * filename, unsigned int * line, unsigned int * column) {
 clang_getPresumedLocation(*location, filename, line, column);
};


void __sn_wrap_libclang_clang_getRange(CXSourceLocation *begin, CXSourceLocation *end, CXSourceRange *____return) {
  CXSourceRange ____ret = clang_getRange(*begin, *end);
  memcpy(____return, &____ret, sizeof(CXSourceRange));
}


void __sn_wrap_libclang_clang_getRangeEnd(CXSourceRange *range, CXSourceLocation *____return) {
  CXSourceLocation ____ret = clang_getRangeEnd(*range);
  memcpy(____return, &____ret, sizeof(CXSourceLocation));
}


void __sn_wrap_libclang_clang_getRangeStart(CXSourceRange *range, CXSourceLocation *____return) {
  CXSourceLocation ____ret = clang_getRangeStart(*range);
  memcpy(____return, &____ret, sizeof(CXSourceLocation));
}


void __sn_wrap_libclang_clang_getResultType(CXType *T, CXType *____return) {
  CXType ____ret = clang_getResultType(*T);
  memcpy(____return, &____ret, sizeof(CXType));
}


void __sn_wrap_libclang_clang_getSpecializedCursorTemplate(CXCursor *C, CXCursor *____return) {
  CXCursor ____ret = clang_getSpecializedCursorTemplate(*C);
  memcpy(____return, &____ret, sizeof(CXCursor));
}


void __sn_wrap_libclang_clang_getSpellingLocation(CXSourceLocation *location, CXFile * file, unsigned int * line, unsigned int * column, unsigned int * offset) {
 clang_getSpellingLocation(*location, file, line, column, offset);
};


enum CXCursorKind __sn_wrap_libclang_clang_getTemplateCursorKind(CXCursor *C) {
 return clang_getTemplateCursorKind(*C);
};


CXToken * __sn_wrap_libclang_clang_getToken(CXTranslationUnit TU, CXSourceLocation *Location) {
 return clang_getToken(TU, *Location);
};


void __sn_wrap_libclang_clang_getTokenExtent(CXTranslationUnit _0, CXToken *_1, CXSourceRange *____return) {
  CXSourceRange ____ret = clang_getTokenExtent(_0, *_1);
  memcpy(____return, &____ret, sizeof(CXSourceRange));
}


CXTokenKind __sn_wrap_libclang_clang_getTokenKind(CXToken *_0) {
 return clang_getTokenKind(*_0);
};


void __sn_wrap_libclang_clang_getTokenLocation(CXTranslationUnit _0, CXToken *_1, CXSourceLocation *____return) {
  CXSourceLocation ____ret = clang_getTokenLocation(_0, *_1);
  memcpy(____return, &____ret, sizeof(CXSourceLocation));
}


void __sn_wrap_libclang_clang_getTokenSpelling(CXTranslationUnit _0, CXToken *_1, CXString *____return) {
  CXString ____ret = clang_getTokenSpelling(_0, *_1);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getTranslationUnitCursor(CXTranslationUnit _0, CXCursor *____return) {
  CXCursor ____ret = clang_getTranslationUnitCursor(_0);
  memcpy(____return, &____ret, sizeof(CXCursor));
}


void __sn_wrap_libclang_clang_getTranslationUnitSpelling(CXTranslationUnit CTUnit, CXString *____return) {
  CXString ____ret = clang_getTranslationUnitSpelling(CTUnit);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getTypeDeclaration(CXType *T, CXCursor *____return) {
  CXCursor ____ret = clang_getTypeDeclaration(*T);
  memcpy(____return, &____ret, sizeof(CXCursor));
}


void __sn_wrap_libclang_clang_getTypeKindSpelling(enum CXTypeKind K, CXString *____return) {
  CXString ____ret = clang_getTypeKindSpelling(K);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getTypeSpelling(CXType *CT, CXString *____return) {
  CXString ____ret = clang_getTypeSpelling(*CT);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getTypedefDeclUnderlyingType(CXCursor *C, CXType *____return) {
  CXType ____ret = clang_getTypedefDeclUnderlyingType(*C);
  memcpy(____return, &____ret, sizeof(CXType));
}


void __sn_wrap_libclang_clang_getTypedefName(CXType *CT, CXString *____return) {
  CXString ____ret = clang_getTypedefName(*CT);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getUnaryOperatorKindSpelling(enum CXUnaryOperatorKind kind, CXString *____return) {
  CXString ____ret = clang_getUnaryOperatorKindSpelling(kind);
  memcpy(____return, &____ret, sizeof(CXString));
}


void __sn_wrap_libclang_clang_getUnqualifiedType(CXType *CT, CXType *____return) {
  CXType ____ret = clang_getUnqualifiedType(*CT);
  memcpy(____return, &____ret, sizeof(CXType));
}


unsigned int __sn_wrap_libclang_clang_hashCursor(CXCursor *_0) {
 return clang_hashCursor(*_0);
};


void __sn_wrap_libclang_clang_indexLoc_getCXSourceLocation(CXIdxLoc *loc, CXSourceLocation *____return) {
  CXSourceLocation ____ret = clang_indexLoc_getCXSourceLocation(*loc);
  memcpy(____return, &____ret, sizeof(CXSourceLocation));
}


void __sn_wrap_libclang_clang_indexLoc_getFileLocation(CXIdxLoc *loc, CXIdxClientFile * indexFile, CXFile * file, unsigned int * line, unsigned int * column, unsigned int * offset) {
 clang_indexLoc_getFileLocation(*loc, indexFile, file, line, column, offset);
};


unsigned int __sn_wrap_libclang_clang_isConstQualifiedType(CXType *T) {
 return clang_isConstQualifiedType(*T);
};


unsigned int __sn_wrap_libclang_clang_isCursorDefinition(CXCursor *_0) {
 return clang_isCursorDefinition(*_0);
};


unsigned int __sn_wrap_libclang_clang_isFunctionTypeVariadic(CXType *T) {
 return clang_isFunctionTypeVariadic(*T);
};


unsigned int __sn_wrap_libclang_clang_isInvalidDeclaration(CXCursor *_0) {
 return clang_isInvalidDeclaration(*_0);
};


unsigned int __sn_wrap_libclang_clang_isPODType(CXType *T) {
 return clang_isPODType(*T);
};


unsigned int __sn_wrap_libclang_clang_isRestrictQualifiedType(CXType *T) {
 return clang_isRestrictQualifiedType(*T);
};


unsigned int __sn_wrap_libclang_clang_isVirtualBase(CXCursor *_0) {
 return clang_isVirtualBase(*_0);
};


unsigned int __sn_wrap_libclang_clang_isVolatileQualifiedType(CXType *T) {
 return clang_isVolatileQualifiedType(*T);
};


void __sn_wrap_libclang_clang_tokenize(CXTranslationUnit TU, CXSourceRange *Range, CXToken ** Tokens, unsigned int * NumTokens) {
 clang_tokenize(TU, *Range, Tokens, NumTokens);
};


unsigned int __sn_wrap_libclang_clang_visitChildren(CXCursor *parent, CXCursorVisitor visitor, CXClientData client_data) {
 return clang_visitChildren(*parent, visitor, client_data);
};


unsigned int __sn_wrap_libclang_clang_visitChildrenWithBlock(CXCursor *parent, CXCursorVisitorBlock block) {
 return clang_visitChildrenWithBlock(*parent, block);
};