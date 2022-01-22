typedef struct {
  int i;
  float b;
} FunctionRewriteStruct;

FunctionRewriteStruct rewrite_bad_func(FunctionRewriteStruct a, FunctionRewriteStruct b);
int rewrite_better_func(FunctionRewriteStruct a, FunctionRewriteStruct b);
FunctionRewriteStruct* rewrite_good_func(FunctionRewriteStruct *a, FunctionRewriteStruct *b, int i);
