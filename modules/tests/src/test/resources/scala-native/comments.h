/**
 * hello this is a comment
 * It's rendered correctly
 * @a is an integer
 */
typedef struct {
    int a;
    char *b;
} HasComment;


/// hello
/// this is a doxygen support comment
typedef struct {

} HasTripleSlashComment;

//! hello
//! this is a doxygen support comment
typedef struct {

} HasWeirdComment;

// hello
typedef struct {

} NoComment;
