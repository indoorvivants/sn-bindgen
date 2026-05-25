#include "extern_globals.h"

const int simple_int_const = 42;
int writable_int = 7;
const char *some_string = "hello extern";

static int opaque_sentinel = 99;
void *some_opaque = &opaque_sentinel;
