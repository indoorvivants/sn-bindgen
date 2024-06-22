//!bindgen: --render.opaque-structs StructComplexOpaque

typedef enum my_bool { m_false, m_true } my_bool;

typedef struct StructSimple {
  int x, y;
  char *s1, *s2;
} StructSimple;

typedef struct StructComplex {
  StructSimple p1, p2;
  int x;

  struct {
    char yo;
  } kiss;

  my_bool flag;

  struct {
    int HELLO;
  } yass;

  char* bla;

  int test[25];

} StructComplex;

typedef struct StructComplexOpaque {
  StructSimple p1, p2;
  int x;

  struct {
    char yo;
  } kiss;

  my_bool flag;

  struct {
    int HELLO;
  } yass;

  char* bla;

  union {
    int u0;
    long u1;
  };

  int test[25];

  union {
    int r0;
    long r1;
  } flan[2];

  double y;

  union {
    int u0;
    long u1;
  } top;


} StructComplexOpaque;


typedef struct StructAnonymous {
  int x;
  union {
    char *str;
    int num;
  } context;
  struct {
    char *key;
    char *value;
  } header;
} StructAnonymous;
