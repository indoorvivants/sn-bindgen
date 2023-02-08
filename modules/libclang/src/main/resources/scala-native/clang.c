#include "clang-c/Index.h"
#include <stdio.h>
typedef enum CXChildVisitResult (*CXCursorVisitorPtr)(CXCursor *cursor,
                                                   CXCursor *parent,
                                                   CXClientData client_data);

typedef struct CDataWrapper {
  CXCursorVisitorPtr original_visitor;
  CXClientData original_cdata;
} CDataWrapper;

// TODO: somehow this name sounds creepy
enum CXChildVisitResult special_visitor(CXCursor c, CXCursor parent, CXClientData cd) {
  struct CDataWrapper *unpacked = (CDataWrapper*) cd;
  /* fprintf(stderr, "In special visitor: %12X, parent: %12X, data: %12X\n", &c, &parent, cd); */
  return (*unpacked).original_visitor(&c, &parent, (*unpacked).original_cdata);
}

unsigned __sn_wrap_clang_visitChildren(CXCursor *curs, CXCursorVisitorPtr scala_visitor,
                            CXClientData cdata) {

  struct CDataWrapper wrapper;

  wrapper.original_visitor = scala_visitor;
  wrapper.original_cdata = cdata;
  return clang_visitChildren(*curs, &special_visitor, &wrapper);
}
