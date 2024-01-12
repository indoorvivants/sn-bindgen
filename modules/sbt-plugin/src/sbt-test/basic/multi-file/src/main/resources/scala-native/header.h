#include <stdbool.h>
bool hello(int i, float y);

typedef float position;

typedef struct {
  char x;
} Test;

union Bla {
  char x;
};

enum X { A, B };

bool hello2(int i, Test y);
