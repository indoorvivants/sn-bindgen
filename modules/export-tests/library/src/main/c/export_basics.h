//!bindgen: --export

extern int myscalalib_exports(int i, int r);

typedef struct {
  char a;
  char b;
} myscalalib_struct;

extern void myscalalib_complex(int times, myscalalib_struct* clamp, char* result);

extern int ScalaNativeInit(void);
