typedef union UnionSimple {
 unsigned i;
 float b;
 char *s;
} UnionSimple;

typedef union UnionOverlapping {
  long p[35];
  char d[40];
} UnionOverlapping;
