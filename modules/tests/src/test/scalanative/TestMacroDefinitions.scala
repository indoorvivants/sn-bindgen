package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import lib_test_macro_definitions.all.*

class TestMacroDefinitions:
  @Test def test_HELLO_0(): Unit =
    assertEquals(macro_definitions_lookup(c"HELLO_0"), HELLO_0.toLong)
  @Test def test_HELLO_5(): Unit =
    assertEquals(macro_definitions_lookup(c"HELLO_5"), HELLO_5.toLong)
  @Test def test_HELLO_6(): Unit =
    assertEquals(macro_definitions_lookup(c"HELLO_6"), HELLO_6.toLong)
  @Test def test_HELLO_7(): Unit =
    assertEquals(macro_definitions_lookup(c"HELLO_7"), HELLO_7.toLong)
  @Test def test_HELLO_8(): Unit =
    assertEquals(macro_definitions_lookup(c"HELLO_8"), HELLO_8.toLong)
  @Test def test_HELLO_9(): Unit =
    assertEquals(macro_definitions_lookup(c"HELLO_9"), HELLO_9.toLong)
  @Test def test_HELLO_10(): Unit =
    assertEquals(macro_definitions_lookup(c"HELLO_10"), HELLO_10.toLong)
  @Test def test_HELLO_11(): Unit =
    assertEquals(macro_definitions_lookup(c"HELLO_11"), HELLO_11.toLong)
  @Test def test_HELLO_12(): Unit =
    assertEquals(macro_definitions_lookup(c"HELLO_12"), HELLO_12.toLong)
  @Test def test_INT_L1(): Unit =
    assertEquals(macro_definitions_lookup(c"INT_L1"), INT_L1.toLong)
  @Test def test_INT_L2(): Unit =
    assertEquals(macro_definitions_lookup(c"INT_L2"), INT_L2.toLong)
  @Test def test_INT_L3(): Unit =
    assertEquals(macro_definitions_lookup(c"INT_L3"), INT_L3.toLong)
  @Test def test_INT_L4(): Unit =
    assertEquals(macro_definitions_lookup(c"INT_L4"), INT_L4.toLong)
  @Test def test_INT_L5(): Unit =
    assertEquals(macro_definitions_lookup(c"INT_L5"), INT_L5.toLong)
  @Test def test_INT_L6(): Unit =
    assertEquals(macro_definitions_lookup(c"INT_L6"), INT_L6.toLong)
  @Test def test_INT_U1(): Unit =
    assertEquals(macro_definitions_lookup(c"INT_U1"), INT_U1.toLong)
  @Test def test_INT_U2(): Unit =
    assertEquals(macro_definitions_lookup(c"INT_U2"), INT_U2.toLong)
  @Test def test_INT_U3(): Unit =
    assertEquals(macro_definitions_lookup(c"INT_U3"), INT_U3.toLong)
  @Test def test_INT_U4(): Unit =
    assertEquals(macro_definitions_lookup(c"INT_U4"), INT_U4.toLong)
  @Test def test_INT_U5(): Unit =
    assertEquals(macro_definitions_lookup(c"INT_U5"), INT_U5.toLong)
  @Test def test_INT_U6(): Unit =
    assertEquals(macro_definitions_lookup(c"INT_U6"), INT_U6.toLong)
  @Test def test_INT_U7(): Unit =
    assertEquals(macro_definitions_lookup(c"INT_U7"), INT_U7.toLong)
  @Test def test_INT_U8(): Unit =
    assertEquals(macro_definitions_lookup(c"INT_U8"), INT_U8.toLong)
  @Test def test_BIN_UP1(): Unit =
    assertEquals(macro_definitions_lookup(c"BIN_UP1"), BIN_UP1.toLong)
  @Test def test_BIN_UP2(): Unit =
    assertEquals(macro_definitions_lookup(c"BIN_UP2"), BIN_UP2.toLong)
  @Test def test_OCT_1(): Unit =
    assertEquals(macro_definitions_lookup(c"OCT_1"), OCT_1.toLong)
  @Test def test_OCT_2(): Unit =
    assertEquals(macro_definitions_lookup(c"OCT_2"), OCT_2.toLong)
  @Test def test_OCT_3(): Unit =
    assertEquals(macro_definitions_lookup(c"OCT_3"), OCT_3.toLong)
  @Test def test_ZERO_DEC(): Unit =
    assertEquals(macro_definitions_lookup(c"ZERO_DEC"), ZERO_DEC.toLong)
  @Test def test_ZERO_HEX(): Unit =
    assertEquals(macro_definitions_lookup(c"ZERO_HEX"), ZERO_HEX.toLong)
  @Test def test_ZERO_OCT(): Unit =
    assertEquals(macro_definitions_lookup(c"ZERO_OCT"), ZERO_OCT.toLong)
  @Test def test_ZERO_BIN(): Unit =
    assertEquals(macro_definitions_lookup(c"ZERO_BIN"), ZERO_BIN.toLong)
  @Test def test_ZERO_NEG(): Unit =
    assertEquals(macro_definitions_lookup(c"ZERO_NEG"), ZERO_NEG.toLong)
  @Test def test_HEX_UINT(): Unit =
    assertEquals(macro_definitions_lookup(c"HEX_UINT"), HEX_UINT.toLong)
  @Test def test_WS_1(): Unit =
    assertEquals(macro_definitions_lookup(c"WS_1"), WS_1.toLong)
  @Test def test_WS_2(): Unit =
    assertEquals(macro_definitions_lookup(c"WS_2"), WS_2.toLong)
  @Test def test_WS_3(): Unit =
    assertEquals(macro_definitions_lookup(c"WS_3"), WS_3.toLong)
  @Test def test_WS_4(): Unit =
    assertEquals(macro_definitions_lookup(c"WS_4"), WS_4.toLong)
  @Test def test_NEG_HEX(): Unit =
    assertEquals(macro_definitions_lookup(c"NEG_HEX"), NEG_HEX.toLong)
  @Test def test_NEG_OCT(): Unit =
    assertEquals(macro_definitions_lookup(c"NEG_OCT"), NEG_OCT.toLong)
  @Test def test_NEG_BIN(): Unit =
    assertEquals(macro_definitions_lookup(c"NEG_BIN"), NEG_BIN.toLong)
  @Test def test_NEG_DEC(): Unit =
    assertEquals(macro_definitions_lookup(c"NEG_DEC"), NEG_DEC.toLong)
  @Test def test_MAX_INT(): Unit =
    assertEquals(macro_definitions_lookup(c"MAX_INT"), MAX_INT.toLong)
  @Test def test_MIN_INT(): Unit =
    assertEquals(macro_definitions_lookup(c"MIN_INT"), MIN_INT.toLong)
  @Test def test_MAX_UINT(): Unit =
    assertEquals(macro_definitions_lookup(c"MAX_UINT"), MAX_UINT.toLong)
  @Test def test_MAX_LL(): Unit =
    assertEquals(macro_definitions_lookup(c"MAX_LL"), MAX_LL.toLong)
  @Test def test_MAX_ULL(): Unit =
    assertEquals(macro_definitions_lookup(c"MAX_ULL"), MAX_ULL.toLong)
  @Test def test_AUDIO_U8(): Unit =
    assertEquals(macro_definitions_lookup(c"AUDIO_U8"), AUDIO_U8.toLong)
  @Test def test_AUDIO_S8(): Unit =
    assertEquals(macro_definitions_lookup(c"AUDIO_S8"), AUDIO_S8.toLong)
  @Test def test_AUDIO_U16LSB(): Unit =
    assertEquals(macro_definitions_lookup(c"AUDIO_U16LSB"), AUDIO_U16LSB.toLong)
  @Test def test_AUDIO_S16LSB(): Unit =
    assertEquals(macro_definitions_lookup(c"AUDIO_S16LSB"), AUDIO_S16LSB.toLong)
  @Test def test_AUDIO_U16MSB(): Unit =
    assertEquals(macro_definitions_lookup(c"AUDIO_U16MSB"), AUDIO_U16MSB.toLong)
  @Test def test_AUDIO_S16MSB(): Unit =
    assertEquals(macro_definitions_lookup(c"AUDIO_S16MSB"), AUDIO_S16MSB.toLong)

  @Test def test_AUDIO_U16(): Unit =
    assertNotEquals(
      "",
      compileErrors("AUDIO_U16")
    )
  // @Test def test_AUDIO_U16(): Unit =
  //   assertEquals(macro_definitions_lookup(c"AUDIO_U16"), AUDIO_U16.toLong)
  // @Test def test_AUDIO_S16(): Unit =
  //   assertEquals(macro_definitions_lookup(c"AUDIO_S16"), AUDIO_S16.toLong)
  @Test def test_SDL_BLENDMODE_INVALID(): Unit = assertEquals(
    macro_definitions_lookup(c"SDL_BLENDMODE_INVALID"),
    SDL_BLENDMODE_INVALID.toLong
  )
end TestMacroDefinitions
