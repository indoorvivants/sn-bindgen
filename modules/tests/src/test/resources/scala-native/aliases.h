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
} Test;
