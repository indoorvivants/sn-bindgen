#include "function_rewrites.h"
#include "stdlib.h"
#include "string.h"

FunctionRewriteStruct rewrite_bad_func(FunctionRewriteStruct x,
                                       FunctionRewriteStruct y) {
  FunctionRewriteStruct result;

  result.b = x.b * y.b;
  result.i = x.i - y.i;

  return result;
}
int rewrite_better_func(FunctionRewriteStruct a, FunctionRewriteStruct b) {
  return a.i - b.i;
}
FunctionRewriteStruct *rewrite_good_func(FunctionRewriteStruct *a,
                                         FunctionRewriteStruct *b, int i) {
  FunctionRewriteStruct *res = malloc(sizeof(FunctionRewriteStruct));

  res->b = a->b * i + b->b * i;
  res->i = a->i * i - b->i * i;

  return res;
}

FunctionRewriteStruct rewrite_without_allocations(FunctionRewriteStruct a,
                                                  FunctionRewriteStruct b,
                                                  AllocationTest c, int i) {

  FunctionRewriteStruct result;

  result.i = a.i + b.i + c.i;

  return result;
}
