//!bindgen: --macros HELLO_*,INT_*,WS_*,BIN_*,OCT_*,ZERO_*,HEX_*,NEG_*,AUDIO_*,SDL_*,MAX_*,MIN_*,STR_*,DEDUP_*,FLT_BASIC*,FLT_DOT*,FLT_NEG*,SCI_*

#define HELLO_0 0x25
#define HELLO_5 42
#define HELLO_6 052
#define HELLO_7 0x2a
#define HELLO_8 0X2A
#define HELLO_9 0b101010
#define HELLO_10 /* comment stuff */ -0b101010
#define HELLO_11 -0X2A
#define HELLO_12 4147483647u
#define HELLO_1  18446744073709550592ull // C99
#define HELLO_2  18'446'744'073'709'550'592llu // C23
#define HELLO_3  1844'6744'0737'0955'0592uLL // C23
#define HELLO_4  184467'440737'0'95505'92LLU // C23


/* ── Integer suffix variants (signed long / long long) ── */
#define INT_L1   42l
#define INT_L2   42L
#define INT_L3   42ll
#define INT_L4   42LL
#define INT_L5   -42l
#define INT_L6   -42LL

/* ── Unsigned variants not yet covered ── */
#define INT_U1   42u
#define INT_U2   42U
#define INT_U3   42UL
#define INT_U4   42Ul
#define INT_U5   42uL
#define INT_U6   42ULL
#define INT_U7   42Ull
#define INT_U8   42ull

/* ── Uppercase 0B binary prefix (C23) ── */
#define BIN_UP1  0B101010
#define BIN_UP2  -0B101010
#define BIN_UP3  0B1111'1111u

/* ── Octal ── */
#define OCT_1     00
#define OCT_2     0777
#define OCT_3     -0755
#define OCT_4     0'177'777

/* ── Zero edge cases ── */
#define ZERO_DEC  0
#define ZERO_HEX  0x0
#define ZERO_OCT  00
#define ZERO_BIN  0b0
#define ZERO_NEG  -0

#define HEX_UINT 0x7FFFFFFFu

/* ── Hex with digit separators (C23) ── */
#define HEX_SEP1  0xDEAD'BEEF
#define HEX_SEP2  0xFF'FF'FF'FFu
#define HEX_SEP3  0x0000'0001ULL

/* ── Whitespace / comment variants ── */
#define WS_1  /* leading block comment */    42
#define WS_2  42  /* trailing comment */
#define WS_3	42
#define WS_4  /* c1 */ /* c2 */ 42
#define WS_5  // no value token

/* ── Negative of every base ── */
#define NEG_HEX   -0xDEAD
#define NEG_OCT   -0777
#define NEG_BIN   -0b1111
#define NEG_DEC   -1

/* ── Extreme / boundary values ── */
#define MAX_INT    2147483647
#define MIN_INT   -2147483648
#define MAX_UINT   4294967295u
#define MAX_LL     9223372036854775807LL
#define MAX_ULL    18446744073709551615ULL


#define AUDIO_U8        0x0008  /**< Unsigned 8-bit samples */
#define AUDIO_S8        0x8008  /**< Signed 8-bit samples */
#define AUDIO_U16LSB    0x0010  /**< Unsigned 16-bit samples */
#define AUDIO_S16LSB    0x8010  /**< Signed 16-bit samples */
#define AUDIO_U16MSB    0x1010  /**< As above, but big-endian byte order */
#define AUDIO_S16MSB    0x9010  /**< As above, but big-endian byte order */
#define AUDIO_U16       AUDIO_U16LSB
#define AUDIO_S16       AUDIO_S16LSB

#define SDL_BLENDMODE_INVALID               0x7FFFFFFFu
#define SDL_TEST2 0.0f

#define STR_VALID "string"
#define STR_VALID_EMPTY ""
#define STR_INVALID "blasd
#define STR_ESCAPED "Hello \" world"
#define STR_BAD_ESCAPE "Hello " world"

#define DEDUP_0 25
#define DEDUP_0 26

/* ── Basic decimal floats ── */
#define FLT_BASIC1   3.14f
#define FLT_BASIC2   3.14F
#define FLT_BASIC3   3.14
#define FLT_BASIC4   3.14l
#define FLT_BASIC5   3.14L

/* ── Leading/trailing dot forms ── */
#define FLT_DOT1   .5f
#define FLT_DOT2   .5
#define FLT_DOT3   .5L
#define FLT_DOT4   5.f
#define FLT_DOT5   5.
#define FLT_DOT6   5.L
#define FLT_DOT7   0.f
#define FLT_DOT8   0.

/* ── Negative ── */
#define FLT_NEG1   -3.14f
#define FLT_NEG2   -3.14
#define FLT_NEG3   -3.14L
#define FLT_NEG4   -.5f
#define FLT_NEG5   -5.

/* ── Scientific notation: basic ── */
#define SCI_1   1e10
#define SCI_2   1E10
#define SCI_3   1e+10
#define SCI_4   1e-10
#define SCI_5   1.5e3f
#define SCI_6   1.5E-3F
#define SCI_7   .5e2L
#define SCI_8   5.e2
#define SCI_9   -1.5e10L
#define SCI_10  -1e-3f

/* ── Scientific notation: boundary exponents ── */
#define SCI_EXP1   1e0
#define SCI_EXP2   1e+0
#define SCI_EXP3   1e-0
#define SCI_EXP4   1e38f       /* near FLT_MAX magnitude */
#define SCI_EXP5   1e308       /* near DBL_MAX magnitude */
#define SCI_EXP6   1e-38f      /* near FLT_MIN magnitude */

/* ── C23 digit separators: decimal ── */
// #define FLT_SEP1   1'000.0f
// #define FLT_SEP2   1'000'000.5
// #define FLT_SEP3   3.141'592'653
// #define FLT_SEP4   .000'001f
// #define FLT_SEP5   1'000.

// /* ── C23 digit separators: scientific ── */
// #define FLT_SEP_SCI1   1'000.5e1'0
// #define FLT_SEP_SCI2   1.234'567e+3f
// #define FLT_SEP_SCI3   -1'500.0e-1'0L

// /* ── C23 digit separators: hex floats ── */
// #define FLT_SEP_HEX1   0x1.FFF'FFFp+1'2f
// #define FLT_SEP_HEX2   0xDE'AD.0p+0
// #define FLT_SEP_HEX3   0x1'0000p-1'6L

/* ── Zero edge cases ── */
#define FLT_ZERO1   0.0f
#define FLT_ZERO2   0.0
#define FLT_ZERO3   0.0L
#define FLT_ZERO4   0.f
#define FLT_ZERO5   .0f
#define FLT_ZERO6   -0.0f      /* negative zero */
#define FLT_ZERO7   0e0
#define FLT_ZERO8   0x0p0      /* hex float zero */
#define FLT_ZERO9   0x0.0p0f

/* ── Whitespace / comment variants ── */
#define FLT_WS1   /* comment */ 3.14f
#define FLT_WS2   3.14f  /* trailing */
#define FLT_WS3   /* c1 */ /* c2 */ 3.14

/* ── Real-world named constants ── */
#define FLT_PI       3.14159265358979323846
#define FLT_E        2.71828182845904523536
#define FLT_AVOGADRO 6.022e23
#define FLT_PLANCK   6.626e-34
#define FLT_MAX_F    3.402823466e+38f
#define FLT_MIN_F    1.175494351e-38f
#define FLT_MAX_D    1.7976931348623158e+308
#define FLT_MIN_D    2.2250738585072014e-308


long long macro_definitions_lookup(const char *name);
const char* macro_definition_string(const char*name);
