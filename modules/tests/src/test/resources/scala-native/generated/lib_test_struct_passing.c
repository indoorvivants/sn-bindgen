#include <string.h>
#include "../struct_passing.h"

void __sn_wrap_lib_test_struct_passing_function_returning_struct(int value, FunctionArg *____return) {
  FunctionArg ____ret = function_returning_struct(value);
  memcpy(____return, &____ret, sizeof(FunctionArg));
}


int __sn_wrap_lib_test_struct_passing_function_taking_struct1(FunctionArg *arg) {
 return function_taking_struct1(*arg);
};


int __sn_wrap_lib_test_struct_passing_function_taking_struct2(FunctionArg *arg1, FunctionArg *arg2) {
 return function_taking_struct2(*arg1, *arg2);
};