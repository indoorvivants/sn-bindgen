#include <stdio.h>

int test1(double x, double y) {
  if (x > y)
    return 1;
  else if (x < y)
    return -1;
  else
    return 0;
}
