typedef struct MetaObj {
  int add;
} MetaObj;

int test_function_np_proto(void* self, const MetaObj* (*callback)());
