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

void wrap_getCursorType(CXCursor *curs, CXType *cxtype) {
  CXType cs = clang_getCursorType(*curs);
  memcpy(cxtype, &cs, sizeof(CXType));
}

void wrap_getResultType(CXType *cxtype) {
  CXType cs = clang_getResultType(*cxtype);
  memcpy(cxtype, &cs, sizeof(CXType));
}

void wrap_getTypeSpelling(CXType *cxtype, CXString *cxs) {
  CXString cs = clang_getTypeSpelling(*cxtype);
  memcpy(cxs, &cs, sizeof(CXString));
}
