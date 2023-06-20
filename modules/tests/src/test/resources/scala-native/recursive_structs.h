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

typedef struct Recursive_Func {
  double d;
  void (*free)(struct Recursive_Func *entry);
  int freed;
} Recursive_Func;

typedef struct Ptr_Recursive {
  double d;
  struct Ptr_Recursive **elements;
} Ptr_Recursive;

typedef struct Ptr_Recursive2 {
  double d;
  struct Ptr_Recursive2 ***elements;
} Ptr_Recursive2;

struct Ptr_Recursive_Array {
  struct Ptr_Recursive_Array *opt[3];
  int ne;
};
