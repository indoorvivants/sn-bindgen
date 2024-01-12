#include "header.h"
#include "stdio.h"

bool hello(int i, float y) {
  printf("%f", i * y);
  return true;
}

bool hello2(int i, Test y) {
  printf("%d", i * ((int)y.x));
  return true;
}
