#include "function_rewrites.h"
#include "string.h"
#include "stdlib.h"

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
FunctionRewriteStruct* rewrite_good_func(FunctionRewriteStruct *a,
                                 FunctionRewriteStruct *b, int i) {
  FunctionRewriteStruct *res = malloc(sizeof(FunctionRewriteStruct));

  res->b = a->b * i + b->b * i; 
  res->i = a->i * i - b->i * i; 

  return res;
}
