/* typedef struct { */
/*    const void *ptr_data[2]; */
/*    unsigned int_data; */
/*  } CXType; */

/* typedef enum CXIdxDeclInfoFlags { CXIdxDeclFlag_Skipped = 0x1 }
 * CXIdxDeclInfoFlags; */
/* enum CXTLSKind { CXTLS_None = 0, CXTLS_Dynamic, CXTLS_Static }; */

/* typedef struct CXUnsavedFile { */

/*   const char *Filename; */

/*   const char *Contents; */

/*   unsigned long Length; */

/*   signed char hello; */
/* } CXUnsavedFile; */

/* enum { */
/*    X = 1, */
/*    Y = 2 */
/* }; */

/* typedef enum CXTypeKind { */
/*    bla = 1 */
/* } CXTypeKind; */

/* typedef struct { */
/*   enum CXTypeKind kind; */
/*   void *data[2]; */
/*   unsigned test; */
/* } CXCursor; */

/* typedef int Hello; */

/* struct point { */
/*     int x; */
/*     int y; */
/* }; */

/* typedef struct point point; */

/* union myUn{ */
/*     int i; */
/*     long double t; */
/*     struct point p; */
/* } ; */

/* typedef struct bigStruct { */
/*     long one; */
/*     char two; */
/*     int three; */
/*     float four; */
/*     double five; */
/*     struct point six; */
/*     struct point *seven; */
/*     int eight; */
/*     int nine; */
/*     int ten; */
/*     int eleven; */
/*     int twelve; */
/*     int thirteen; */
/*     int fourteen; */
/*     int fifteen; */
/*     int sixteen; */
/*     int seventeen; */
/*     int eighteen; */
/*     int nineteen; */
/*     int twenty; */
/*     int twentyOne; */
/*     int twentyTwo; */
/*     int twentyThree; */
/*     union myUn twentyFive; */
/*     int twentySix; */
/* } bigStruct; */

/**
 * Retrieve the type of a CXCursor (if any).
 */
/* CXType clang_getCursorType(size_t hel, CXCursor C, CXType *types[3], long
 * double *idx); */
/* CXTypeKind clang_getCursorKing(size_t hel, CXCursor C, CXType *types[3], long
 * double *idx); */

/* CXTypeKind clang_getCursorKing(size_t hel, CXType *types[3], long double
 * *idx); */


typedef struct Hello2 Hello2;
typedef struct Hello1 Hello1;

typedef void(*hello_func)(struct Hello1*);

typedef struct Hello1 {
  struct Hello2 *hello2;
  char *str;
} Hello1;

typedef struct Hello {
  hello_func handler;
  int two;
} Hello;

typedef struct Hello2 {
  Hello *hello;
  double d;
} Hello2;


typedef struct Recursive {
  struct Recursive *hello;
  double d;
} Recursive;


typedef enum CURLMSG {
  OK=1, NOK=2
} CURLMSG;

typedef int CURLcode;

struct CURLMsg {
  CURLMSG msg;       /* what this message means */
  void *easy_handle; /* the handle it concerns */
  union {
    void *whatever;    /* message-specific data */
    CURLcode result;   /* return code for transfer */
  } union_data;

  struct {
    void *test;    /* message-specific data */
    CURLMSG msg_code;   /* return code for transfer */
  } struct_data;
};
typedef struct CURLMsg CURLMsg;
