typedef struct {
  // int run;

  // union {
  //   char test;
  // };

  // union {
  //   char test;
  // } hal;

  union {
    int r0;
    long r1;
  } flan[2]; // 9

  // enum { A, B, C };

  // union {
  //   int a;
  //   union {
  //     char y;
  //     char *z;
  //   };
  //   struct {
  //     char x;
  //   } bla;
  // } help;

  // struct {
  //   int cozy[5];
  // } c;

  // union {
  //   char bla;
  //   int x;
  // };

} Yest;
// typedef struct {
//   union {
//   	int a;
//     float b;
//     struct {
//         float x;
//         union {
//             char* hello;
//         };
//     };

//     struct {
//         int bla;
//     } howdy;

//   };
//   char* yo;
//  } Help;

// void test(){
//     Help h;
//     h.hello;
//     // Help h = { .a = 1 };
//     // return h.x;
// }
