int test_keywords(int def, int class, int final, int object);
typedef union test_keywords {
  char object;
  long final;
  void *class;
  int *def;
  int val;
  int var;
  int new;
  int notify;
  int wait;
} UnionKeywords;

typedef struct test_keywords_struct {
  char object;
  long final;
  void *class;
  int *def;
  int val;
  int var;
  int new;
  int notify;
  int wait;
} StructKeywords;
