#include "aliases.h"

int higher_order_function(int n, TestFunctionPointer handler,
                          struct TestStruct *container) {
  int sum = 0;

  for (int i = 0; i < n; i++) {
    sum += handler(container);
  }

  return sum;
}
