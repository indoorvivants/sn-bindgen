#include "clang-c/Index.h"
#include <string.h>
#include <stdio.h>

void scalanative_clang_getNullCursor(CXCursor *curs) {
  CXCursor c = clang_getNullCursor();
  memcpy(curs, &c, sizeof(CXCursor));
}

void scalanative_clang_getTranslationUnitCursor(CXCursor *curs, CXTranslationUnit unit) {
  CXCursor c = clang_getTranslationUnitCursor(unit);
  printf("%d\n", CXChildVisit_Recurse);
  memcpy(curs, &c, sizeof(CXCursor));
}
