#include <stdio.h>
#include <time.h>
#include <stdint.h>

#ifdef _WIN32
typedef unsigned long ssize_t;
#endif

typedef size_t Test_size_t;
typedef ssize_t Test_ssize_t;
typedef time_t Test_time_t;
typedef fpos_t Test_fpos_t;
typedef va_list Test_va_list;

struct SpecialIntTypes {
  int8_t i8;
  int16_t i16;
  int32_t i32;

  uint8_t u8;
  uint16_t u16;
  uint32_t u32;
};

#include <inttypes.h>


#ifndef _WIN32

#include <sys/socket.h>

// We are testing that this doesn't get replaced by group from posix
typedef struct group {
  int i;
} group;

typedef struct {
  imaxdiv_t i1;
  struct sockaddr s2;
  group g1;
} UsingPosixTypes;

#endif
