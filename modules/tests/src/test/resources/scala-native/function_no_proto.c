#include "function_no_proto.h"
#include <string.h>

int test_function_np_proto(void *self, const MetaObj *(*callback)()) {
  char *str = (char *)self;
  const MetaObj *meta = callback();

  return strlen(str) + meta->add;
}
