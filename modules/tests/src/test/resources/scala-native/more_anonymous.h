
struct Hello {
  char *yes;
};
typedef struct Recursive_Struct2 {
  struct Hello *hello2;
  struct {
    char bla;
  } *hello3;
  char *str;
} Recursive_Struct2;

// typedef struct Recursive_Struct3 {
//   hello_func handler;
//   int two;
// } Recursive_Struct3;

// typedef struct Recrusive_Struct1 {
//   Recursive_Struct3 *hello;
//   double d;
// } Recrusive_Struct1;

// typedef struct {
//   int x, y;
// } StructSimple;

// typedef int my_bool;

// typedef struct StructComplexOpaque {
//   StructSimple p1, // 0
//                p2; // 1
//   int x; //2

//   struct {
//     char yo;
//   } kiss; //3

//   my_bool flag; // 4

//   struct {
//     int HELLO;
//   } yass; //5

//   char *bla; //6

//   union {
//     int u0;
//     long u1;
//   }; //7

//   int test[25]; // 8

//   union {
//     int r0;
//     long r1;
//   } flan[2]; // 9

//   double y; // 10

//   union {
//     int u0;
//     long u1;
//   } top; // 11

// } StructComplexOpaque;
// // typedef struct {
//   // int run;

//   // union {
//   //   char test;
//   // };

//   // union {
//   //   char test;
//   // } hal;

//   // union {
//   //   int r0;
//   //   long r1;
//   // } flan[2]; // 9

//   // enum { A, B, C };
//   // enum { A, B, C } protocol;

//   // union {
//   //   int a;
//   //   union {
//   //     char y;
//   //     char *z;
//   //   };
//   //   struct {
//   //     char x;
//   //   } bla;
//   // } help;

//   // struct {
//   //   int cozy[5];
//   // } c;

//   // union {
//   //   char bla;
//   //   int x;
//   // };

// // } Yest;
// // typedef struct {
// //   union {
// //   	int a;
// //     float b;
// //     struct {
// //         float x;
// //         union {
// //             char* hello;
// //         };
// //     };

// //     struct {
// //         int bla;
// //     } howdy;

// //   };
// //   char* yo;
// //  } Help;

// // void test(){
// //     Help h;
// //     h.hello;
// //     // Help h = { .a = 1 };
// //     // return h.x;
// // }
