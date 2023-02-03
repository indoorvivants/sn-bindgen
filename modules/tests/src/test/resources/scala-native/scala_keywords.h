int test_keywords(int def, int class, int final, int object);
typedef union test_keywords {
  char object;
  long final;
  void* class;
  int* def;
  int val;
  int var;
  int new;
} UnionKeywords;

