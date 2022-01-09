typedef struct FunctionArg {
  int i;
  char *str;
} FunctionArg;

int function_taking_struct1(FunctionArg arg) { return arg.i * arg.i; }

int function_taking_struct2(FunctionArg arg1, FunctionArg arg2) {
  return (arg1.i * arg2.i) / 2;
}

FunctionArg function_returning_struct(int value) {
  // this leaks memory but for tests it should be okay
  FunctionArg mem = {value * value - 1, "hello"};

  return mem;
}
