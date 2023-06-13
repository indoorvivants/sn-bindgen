#include "assert.h"
#include "export_basics.h"
#include <memory.h>
#include <stdio.h>

int main() {
  printf("Yep, that worked");
  assert(ScalaNativeInit() == 0);

  assert(myscalalib_exports(25, 100) == 2500);

  printf("Yep, that worked");

  myscalalib_struct str;
  str.a = 'h';
  str.b = 'o';
  char result[11];
  result[10] = '\0';
  myscalalib_complex(5, &str, result);

  printf("Result: '%s'", result);
  assert(strcmp(result, "hhhhhooooo") == 0);

  return 0;
}
