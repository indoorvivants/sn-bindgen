#include <string.h>
#include "../function_rewrites.h"

void __sn_wrap_lib_test_function_rewrites_rewrite_bad_func(FunctionRewriteStruct *a, FunctionRewriteStruct *b, FunctionRewriteStruct *____return) {
  FunctionRewriteStruct ____ret = rewrite_bad_func(*a, *b);
  memcpy(____return, &____ret, sizeof(FunctionRewriteStruct));
}


int __sn_wrap_lib_test_function_rewrites_rewrite_better_func(FunctionRewriteStruct *a, FunctionRewriteStruct *b) {
 return rewrite_better_func(*a, *b);
};


void __sn_wrap_lib_test_function_rewrites_rewrite_without_allocations(FunctionRewriteStruct *a, FunctionRewriteStruct *b, AllocationTest *c, int i, FunctionRewriteStruct *____return) {
  FunctionRewriteStruct ____ret = rewrite_without_allocations(*a, *b, *c, i);
  memcpy(____return, &____ret, sizeof(FunctionRewriteStruct));
}