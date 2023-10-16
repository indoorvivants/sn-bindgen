typedef struct {
  union {
    char *bla;
    int foo;
  } help;
} AliasesRef;

typedef struct {
  union {
    long help;
    char *key;
  } field1;
  AliasesRef *field2;
} TestAliases;

typedef int hello_alias;
typedef hello_alias alias_of_an_alias;

struct TestStruct {
  int ne;
};

typedef int (*TestFunctionPointer)(struct TestStruct *container);

int higher_order_function(int n, TestFunctionPointer handler,
                          struct TestStruct *container);
