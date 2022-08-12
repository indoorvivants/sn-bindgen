
typedef enum DUCKDB_TYPEs {
  DUCKDB_TYPE_INVALID = 0,
  DUCKDB_TYPE_JSON,
} duckdb_type;

typedef struct DUCKDB_COLUMNs{
  duckdb_type type;
  char *name;
  void *internal_data;
} duckdb_column;

struct Hello {
  duckdb_column* h;
};
