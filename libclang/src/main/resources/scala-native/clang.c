#include "clang-c/Index.h"
#include <string.h>
#include <stdio.h>

void wrap_getNullCursor(CXCursor *curs) {
  CXCursor c = clang_getNullCursor();
  memcpy(curs, &c, sizeof(CXCursor));
}

void wrap_getTranslationUnitCursor(CXCursor *curs, CXTranslationUnit unit) {
  CXCursor c = clang_getTranslationUnitCursor(unit);
  memcpy(curs, &c, sizeof(CXCursor));
}

unsigned wrap_hashCursor(CXCursor *curs) {
  return clang_hashCursor(*curs);
}

const char* wrap_getCString(CXString *cxs) {
  return clang_getCString(*cxs);
}

void wrap_disposeString(CXString *cxs) {
  return clang_disposeString(*cxs);
}


unsigned wrap_visitChildren(CXCursor *curs, CXCursorVisitor vis, CXClientData cdata) {
  return clang_visitChildren(*curs, vis, cdata);
}

void wrap_getCursorSpelling(CXCursor *curs, CXString *cxstr) {
  CXString cs = clang_getCursorSpelling(*curs);
  memcpy(cxstr, &cs, sizeof(CXString));
}

void wrap_getCursorKindSpelling(enum CXCursorKind kind, CXString *cxstr) {
  CXString cs = clang_getCursorKindSpelling(kind);
  memcpy(cxstr, &cs, sizeof(CXString));
}

void wrap_getTypeKindSpelling(enum CXTypeKind kind, CXString *cxstr) {
  CXString cs = clang_getTypeKindSpelling(kind);
  memcpy(cxstr, &cs, sizeof(CXString));
}

void wrap_getCursorType(CXCursor *curs, CXType *cxtype) {
  CXType cs = clang_getCursorType(*curs);
  memcpy(cxtype, &cs, sizeof(CXType));
}

void wrap_getEnumDeclIntegerType(CXCursor *curs, CXType *cxtype) {
  CXType cs = clang_getEnumDeclIntegerType(*curs);
  memcpy(cxtype, &cs, sizeof(CXType));
}

void wrap_getTypedefDeclUnderlyingType(CXCursor *curs, CXType *cxtype) {
  CXType cs = clang_getTypedefDeclUnderlyingType(*curs);
  memcpy(cxtype, &cs, sizeof(CXType));
}

long long wrap_getEnumConstantDeclValue(CXCursor *curs) {
  return clang_getEnumConstantDeclValue(*curs);
}

int wrap_getNumArgTypes(CXType *curs) {
  return clang_getNumArgTypes(*curs);
}

int wrap_getArraySize(CXType *curs) {
  return clang_getArraySize(*curs);
}

void wrap_getResultType(CXType *functionType, CXType *resultType) {
  CXType cs = clang_getResultType(*functionType);
  memcpy(resultType, &cs, sizeof(CXType));
}

void wrap_getArrayElementType(CXType *arrayType, CXType *elementType) {
  CXType cs = clang_getArrayElementType(*arrayType);
  memcpy(elementType, &cs, sizeof(CXType));
}

void wrap_getPointeeType(CXType *pointerType, CXType *pointeeType) {
  CXType cs = clang_getPointeeType(*pointerType);
  memcpy(pointeeType, &cs, sizeof(CXType));
}

void wrap_getArgType(CXType *functionType, CXType *argType, int idx) {
  CXType cs = clang_getArgType(*functionType, idx);
  memcpy(argType, &cs, sizeof(CXType));
}


void wrap_getTypeSpelling(CXType *cxtype, CXString *cxs) {
  CXString cs = clang_getTypeSpelling(*cxtype);
  memcpy(cxs, &cs, sizeof(CXString));
}

void wrap_getTypedefName(CXType *cxtype, CXString *cxs) {
  CXString cs = clang_getTypedefName(*cxtype);
  memcpy(cxs, &cs, sizeof(CXString));
}

unsigned wrap_Cursor_isAnonymousRecordDecl(CXCursor *curs) {
  return clang_Cursor_isAnonymousRecordDecl(*curs);
}

unsigned wrap_Cursor_isAnonymous(CXCursor *curs) {
  return clang_Cursor_isAnonymous(*curs);
}

void wrap_Type_getNamedType(CXType *elaborated, CXType *underlying) {
  CXType cs = clang_Type_getNamedType(*elaborated);
  memcpy(underlying, &cs, sizeof(CXType));
}

void wrap_getTypeDeclaration(CXType *tpe, CXCursor *declaration) {
  CXCursor cs = clang_getTypeDeclaration(*tpe);
  memcpy(declaration, &cs, sizeof(CXCursor));
}

