// header.hpp

/* #include "clang-c/Index.h" */
/* #include <string.h> */
/* #include <stdio.h> */

/* void scalanative_clang_getNullCursor(CXCursor *curs) { */
/*   CXCursor c = clang_getNullCursor(); */
/*   memcpy(curs, &c, sizeof(CXCursor)); */
/* } */

/* void scalanative_clang_getTranslationUnitCursor(CXCursor *curs, CXTranslationUnit unit) { */
/*   CXCursor c = clang_getTranslationUnitCursor(unit); */
/*   printf("%d\n", CXChildVisit_Recurse); */
/*   memcpy(curs, &c, sizeof(CXCursor)); */
/* } */
 CINDEX_LINKAGE void clang_annotateTokens(CXTranslationUnit TU, CXToken *Tokens,
                                          unsigned NumTokens, CXCursor *Cursors);
  
 /**
  * Free the given set of tokens.
  */
 CINDEX_LINKAGE void clang_disposeTokens(CXTranslationUnit TU, CXToken *Tokens,
                                         unsigned NumTokens);
  
 /**
  * @}
  */
  
 /**
  * \defgroup CINDEX_DEBUG Debugging facilities
  *
  * These routines are used for testing and debugging, only, and should not
  * be relied upon.
  *
  * @{
  */
  
 /* for debug/testing */
 CINDEX_LINKAGE CXString clang_getCursorKindSpelling(enum CXCursorKind Kind);
 CINDEX_LINKAGE void clang_getDefinitionSpellingAndExtent(
     CXCursor, const char **startBuf, const char **endBuf, unsigned *startLine,
     unsigned *startColumn, unsigned *endLine, unsigned *endColumn);
 CINDEX_LINKAGE void clang_enableStackTraces(void);
 CINDEX_LINKAGE void clang_executeOnThread(void (*fn)(void *), void *user_data,
                                           unsigned stack_size);
  

int static_method();
