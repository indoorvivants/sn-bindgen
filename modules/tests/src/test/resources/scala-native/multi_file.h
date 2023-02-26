//!bindgen --multi-file

union Test {
  int x;
  char y;
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
