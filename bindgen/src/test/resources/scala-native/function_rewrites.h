typedef struct {
  int i;
  float b;
} FunctionRewriteStruct;

typedef struct {
  char *str;
  int i;
} AllocationTest;

FunctionRewriteStruct rewrite_bad_func(FunctionRewriteStruct a,
                                       FunctionRewriteStruct b);
int rewrite_better_func(FunctionRewriteStruct a, FunctionRewriteStruct b);
FunctionRewriteStruct *rewrite_good_func(FunctionRewriteStruct *a,
                                         FunctionRewriteStruct *b, int i);
FunctionRewriteStruct rewrite_without_allocations(FunctionRewriteStruct a,
                                                  FunctionRewriteStruct b,
                                                  AllocationTest c,
                                                  int i);
