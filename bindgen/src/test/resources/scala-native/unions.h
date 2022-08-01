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

typedef union test_keywords {
  char object;
  long final;
  void* class;
  int* def;
} UnionKeywords;
