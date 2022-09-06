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
