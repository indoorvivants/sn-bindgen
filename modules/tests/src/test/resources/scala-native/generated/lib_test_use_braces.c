#include <string.h>
#include "../use_braces.h"

void __sn_wrap_lib_test_use_braces_naughty(Hello *st) {
 naughty(*st);
};


unsigned int __sn_wrap_lib_test_use_braces_run(int i, float h, HelloAlias *test, union Test verify) {
 return run(i, h, *test, verify);
};