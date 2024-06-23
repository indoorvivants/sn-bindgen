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

  char *bla;

  int test[25];

} StructComplex;

typedef struct StructComplexOpaque {
  StructSimple p1, // 0
               p2; // 1
  int x; //2

  struct {
    char yo; 
  } kiss; //3

  my_bool flag; // 4

  struct {
    int HELLO;
  } yass; //5

  char *bla; //6 

  union {
    int u0;
    long u1;
  }; //7

  int test[25]; // 8

  union {
    int r0;
    long r1;
  } flan[2]; // 9

  double y; // 10

  union {
    int u0;
    long u1;
  } top; // 11

} StructComplexOpaque;

void write_offsets(int *offsets);

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
