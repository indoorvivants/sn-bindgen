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
  int macro;
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
  int macro;
} StructKeywords;

void test_alloc_collision(int alloc, StructKeywords the_struct);
