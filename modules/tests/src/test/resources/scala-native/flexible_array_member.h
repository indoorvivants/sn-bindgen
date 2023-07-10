typedef struct FAM {
  int len;
  char data[]; 
} FAM;

typedef union {
  struct 
  {
    int va_header;
    char va_data[]; 
  } va_compressed;
} FAM_union;


