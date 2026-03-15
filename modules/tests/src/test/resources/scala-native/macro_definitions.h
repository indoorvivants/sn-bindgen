//!bindgen: --macros HELLO_*,INT_*,WS_*,BIN_*,OCT_*,ZERO_*,HEX_*,NEG_*,AUDIO_*,SDL_*,MAX_*,MIN_*

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
#define SDL_TEST "string"
#define SDL_TEST2 0.0f

long long macro_definitions_lookup(const char *name);
