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
