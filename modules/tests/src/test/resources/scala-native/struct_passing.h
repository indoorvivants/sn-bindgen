typedef struct FunctionArg {
  int i;
  char *str;
} FunctionArg;

int function_taking_struct1(FunctionArg arg);

int function_taking_struct2(FunctionArg arg1, FunctionArg arg2);

FunctionArg function_returning_struct(int value);
