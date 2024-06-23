#include "structs.h"
#include <stddef.h>

void write_offsets(int *offsets) {
  offsets[0] = offsetof(StructComplexOpaque, p1);
  offsets[1] = offsetof(StructComplexOpaque, p2);
  offsets[2] = offsetof(StructComplexOpaque, x);
  offsets[3] = offsetof(StructComplexOpaque, kiss);
  offsets[4] = offsetof(StructComplexOpaque, flag);
  offsets[5] = offsetof(StructComplexOpaque, yass);
  offsets[6] = offsetof(StructComplexOpaque, bla);
  offsets[7] = offsetof(StructComplexOpaque, u1); // sic!
  offsets[8] = offsetof(StructComplexOpaque, test);
  offsets[9] = offsetof(StructComplexOpaque, flan);
  offsets[10] = offsetof(StructComplexOpaque, y);
  offsets[11] = offsetof(StructComplexOpaque, top);
}
