//!bindgen: --use-braces

union Test {
  int x;
  char y;
  struct {
      int a;
  } hello;
};

enum Bla { A, B };
typedef float Howdy;
typedef struct Hello {
  int bla;
  Howdy yes;
} Hello;

typedef Hello HelloAlias;

unsigned run(int i, float h, HelloAlias test, union Test verify);
void naughty(Hello st);
void nice(char st);
enum { Constant1, Constant2 };

int test_varargs(int i, ...);
