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
