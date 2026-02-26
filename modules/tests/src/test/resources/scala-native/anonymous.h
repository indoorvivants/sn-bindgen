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
typedef int size_bla;

struct st_h2o_context_t {
      enum { WHAT, THE, HELL } protocol;
      struct {
          h2o_linklist_t idle, active, shutdown;
          union {
              struct {
                  size_bla idle, active, shutdown;
              };
              size_bla counters[1];
          } num_conns;
      } _conns;
  };

struct AnonMultiField {
    enum {AYE, NAY};
    struct {
        int counter;
    } num_sent, num_received;
};


// This case is here because previously we had a bug where anonymous
// definitions under unions were not considered for computing closure
#include <sys/stat.h>
struct st_h2o_filecache_ref_t {
    union {
        struct {
            /* used if fd != -1 */
            struct stat MY_FIELD;
        };
    };
};
