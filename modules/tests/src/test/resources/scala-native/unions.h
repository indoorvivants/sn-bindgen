typedef union UnionSimple {
 unsigned i;
 float b;
 char *s;
} UnionSimple;

typedef union UnionOverlapping {
  long p[35];
  char d[40];
} UnionOverlapping;

typedef union empty_union UnionEmpty;


typedef struct struct_with_union_array {
  int g_type;
  union {
    long test;
    char* help;
  } yo;
  union {
    long test;
    char* help;
  } data[2];
} StructWithUnionArray;
