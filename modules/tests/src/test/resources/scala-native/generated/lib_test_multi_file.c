#include <string.h>
#include "../multi_file.h"

void __sn_wrap_lib_test_multi_file_naughty(Hello *st) {
 naughty(*st);
};


unsigned int __sn_wrap_lib_test_multi_file_run(int i, float h, HelloAlias *test, union Test verify) {
 return run(i, h, *test, verify);
};