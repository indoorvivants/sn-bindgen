typedef struct AnonymousNestedStruct
{
    union
    {
        int button;
        float axis;
        struct {
            int hat;
            int hat_mask;
        } headgear;
    } value;
    int test;
} AnonymousNestedStruct;

typedef union AnonymousNestedUnion {
    union
    {
        int button;
        float axis;
        struct {
            int hat;
            int hat_mask;
        } headgear;
    } value;
    int test;
} AnonymousNestedUnion;

// https://github.com/indoorvivants/sn-bindgen/issues/351#issuecomment-2854910220
typedef struct AVStreamGroupTileGrid {
    union {
        int vertical;
    } *offsets;

} AVStreamGroupTileGrid;


// https://github.com/scala/scala3/issues/25345
typedef void* h2o_linklist_t;
typedef int size_t;

struct st_h2o_context_t {
      enum { WHAT, THE, HELL } protocol;
      struct {
          h2o_linklist_t idle, active, shutdown;
          union {
              struct {
                  size_t idle, active, shutdown;
              };
              size_t counters[1];
          } num_conns;
      } _conns;
  };
