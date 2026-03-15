#include <string.h>
#include "macro_definitions.h"

const char* macro_definition_string(const char* name) {
    if (strcmp(name, "STR_VALID") == 0) return STR_VALID;
    if (strcmp(name, "STR_VALID_EMPTY") == 0) return STR_VALID_EMPTY;
    if (strcmp(name, "STR_ESCAPED") == 0) return STR_ESCAPED;
    return NULL;
}

long long macro_definitions_lookup(const char *name) {
    if (strcmp(name, "HELLO_0") == 0) return (long long)HELLO_0;
    if (strcmp(name, "HELLO_5") == 0) return (long long)HELLO_5;
    if (strcmp(name, "HELLO_6") == 0) return (long long)HELLO_6;
    if (strcmp(name, "HELLO_7") == 0) return (long long)HELLO_7;
    if (strcmp(name, "HELLO_8") == 0) return (long long)HELLO_8;
    if (strcmp(name, "HELLO_9") == 0) return (long long)HELLO_9;
    if (strcmp(name, "HELLO_10") == 0) return (long long)HELLO_10;
    if (strcmp(name, "HELLO_11") == 0) return (long long)HELLO_11;
    if (strcmp(name, "HELLO_12") == 0) return (long long)HELLO_12;
    if (strcmp(name, "INT_L1") == 0) return (long long)INT_L1;
    if (strcmp(name, "INT_L2") == 0) return (long long)INT_L2;
    if (strcmp(name, "INT_L3") == 0) return (long long)INT_L3;
    if (strcmp(name, "INT_L4") == 0) return (long long)INT_L4;
    if (strcmp(name, "INT_L5") == 0) return (long long)INT_L5;
    if (strcmp(name, "INT_L6") == 0) return (long long)INT_L6;
    if (strcmp(name, "INT_U1") == 0) return (long long)INT_U1;
    if (strcmp(name, "INT_U2") == 0) return (long long)INT_U2;
    if (strcmp(name, "INT_U3") == 0) return (long long)INT_U3;
    if (strcmp(name, "INT_U4") == 0) return (long long)INT_U4;
    if (strcmp(name, "INT_U5") == 0) return (long long)INT_U5;
    if (strcmp(name, "INT_U6") == 0) return (long long)INT_U6;
    if (strcmp(name, "INT_U7") == 0) return (long long)INT_U7;
    if (strcmp(name, "INT_U8") == 0) return (long long)INT_U8;
    if (strcmp(name, "BIN_UP1") == 0) return (long long)BIN_UP1;
    if (strcmp(name, "BIN_UP2") == 0) return (long long)BIN_UP2;
    // if (strcmp(name, "BIN_UP3") == 0) return (long long)(BIN_UP3 ;
    if (strcmp(name, "OCT_1") == 0) return (long long)OCT_1;
    if (strcmp(name, "OCT_2") == 0) return (long long)OCT_2;
    if (strcmp(name, "OCT_3") == 0) return (long long)OCT_3;
    // if (strcmp(name, "OCT_4") == 0) return (long long)OCT_4;
    if (strcmp(name, "ZERO_DEC") == 0) return (long long)ZERO_DEC;
    if (strcmp(name, "ZERO_HEX") == 0) return (long long)ZERO_HEX;
    if (strcmp(name, "ZERO_OCT") == 0) return (long long)ZERO_OCT;
    if (strcmp(name, "ZERO_BIN") == 0) return (long long)ZERO_BIN;
    if (strcmp(name, "ZERO_NEG") == 0) return (long long)ZERO_NEG;
    if (strcmp(name, "HEX_UINT") == 0) return (long long)HEX_UINT;
    // if (strcmp(name, "HEX_SEP1") == 0) return (long long)HEX_SEP1;
    // if (strcmp(name, "HEX_SEP2") == 0) return (long long)HEX_SEP2;
    // if (strcmp(name, "HEX_SEP3") == 0) return (long long)HEX_SEP3;
    if (strcmp(name, "WS_1") == 0) return (long long)WS_1;
    if (strcmp(name, "WS_2") == 0) return (long long)WS_2;
    if (strcmp(name, "WS_3") == 0) return (long long)WS_3;
    if (strcmp(name, "WS_4") == 0) return (long long)WS_4;
    if (strcmp(name, "NEG_HEX") == 0) return (long long)NEG_HEX;
    if (strcmp(name, "NEG_OCT") == 0) return (long long)NEG_OCT;
    if (strcmp(name, "NEG_BIN") == 0) return (long long)NEG_BIN;
    if (strcmp(name, "NEG_DEC") == 0) return (long long)NEG_DEC;
    if (strcmp(name, "MAX_INT") == 0) return (long long)MAX_INT;
    if (strcmp(name, "MIN_INT") == 0) return (long long)MIN_INT;
    if (strcmp(name, "MAX_UINT") == 0) return (long long)MAX_UINT;
    if (strcmp(name, "MAX_LL") == 0) return (long long)MAX_LL;
    if (strcmp(name, "MAX_ULL") == 0) return (long long)MAX_ULL;
    if (strcmp(name, "AUDIO_U8") == 0) return (long long)AUDIO_U8;
    if (strcmp(name, "AUDIO_S8") == 0) return (long long)AUDIO_S8;
    if (strcmp(name, "AUDIO_U16LSB") == 0) return (long long)AUDIO_U16LSB;
    if (strcmp(name, "AUDIO_S16LSB") == 0) return (long long)AUDIO_S16LSB;
    if (strcmp(name, "AUDIO_U16MSB") == 0) return (long long)AUDIO_U16MSB;
    if (strcmp(name, "AUDIO_S16MSB") == 0) return (long long)AUDIO_S16MSB;
    if (strcmp(name, "AUDIO_U16") == 0) return (long long)AUDIO_U16;
    if (strcmp(name, "AUDIO_S16") == 0) return (long long)AUDIO_S16;
    if (strcmp(name, "DEDUP_0") == 0) return (long long)DEDUP_0;
    if (strcmp(name, "SDL_BLENDMODE_INVALID") == 0) return (long long)SDL_BLENDMODE_INVALID;
    return -1L;
}
