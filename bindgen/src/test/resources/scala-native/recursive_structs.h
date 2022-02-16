typedef struct Recursive_Struct2 Recursive_Struct2;

typedef void (*hello_func)(struct Recursive_Struct2 *);

typedef struct Recursive_Struct2 {
  struct Recrusive_Struct1 *hello2;
  char *str;
} Recursive_Struct2;

typedef struct Recursive_Struct3 {
  hello_func handler;
  int two;
} Recursive_Struct3;

typedef struct Recrusive_Struct1 {
  Recursive_Struct3 *hello;
  double d;
} Recrusive_Struct1;

typedef struct Recrusive_Simple {
  struct Recrusive_Simple *hello;
  double d;
} Recrusive_Simple;

struct Recursive_Func;

typedef struct {
  double d;
  void (*free)(struct Recursive_Func *entry);
  int freed;
} Recursive_Func;
