#include <stdbool.h>
bool hello(int i, float y);

typedef float position;

typedef struct {
  char x;
} Test;

union Bla {
  char x;
};

enum X { A=1u, B=2u };

bool hello2(int i, Test y);

enum {HELLO_1=100, HELLO_2=500};
