#include <stdarg.h>

typedef struct {
  int a;
  char c;
} VaragsStruct;

int test_my_sum(int count, ...);
int test_my_ptrs(VaragsStruct * vs, int count, ...);
int test_my_ptrs_bad(VaragsStruct vs, int count, ...);
