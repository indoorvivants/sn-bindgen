#include "assert.h"
#include "export_basics.h"
#include <memory.h>
#include <stdio.h>
void my_tests() {
  assert(myscalalib_exports(25, 100) == 2500);

  myscalalib_struct str;
  str.a = 'h';
  str.b = 'o';
  char result[11];
  result[10] = '\0';
  myscalalib_complex(5, &str, result);

  printf("Result: '%s'", result);
  assert(strcmp(result, "hhhhhooooo") == 0);
}
