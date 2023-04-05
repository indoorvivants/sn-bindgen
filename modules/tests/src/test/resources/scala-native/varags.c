#include "varags.h"

int test_my_sum(int count, ...) {
  va_list args;
  va_start(args, count);
  int sum = 0;
  for (int i = 0; i < count; i++) {
    int arg = va_arg(args, int);
    sum += arg;
  }
  va_end(args);
  return sum;
}

int test_my_ptrs(VaragsStruct *vs, int count, ...) {
  va_list args;
  va_start(args, count);
  int sum = 0;
  for (int i = 0; i < count; i++) {
    int arg = va_arg(args, int);
    sum += arg;
  }
  va_end(args);
  return vs->a + sum;
}

int test_my_ptrs_bad(VaragsStruct vs, int count, ...) {
  va_list args;
  va_start(args, count);
  int sum = 0;
  for (int i = 0; i < count; i++) {
    int arg = va_arg(args, int);
    sum += arg;
  }
  va_end(args);
  return vs.a + sum;
}
