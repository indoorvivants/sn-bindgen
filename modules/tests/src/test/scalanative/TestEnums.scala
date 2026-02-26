package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scala.scalanative.meta.LinktimeInfo.isWindows

class TestEnums:
  import lib_test_enums.types.*
  @Test def test_basic_enums(): Unit =
    // On windows default type for enums seems to be int
    if isWindows then
      assertEquals(1, Enum1.ONE)
      assertEquals(2, Enum1.TWO)
      assertEquals(3, Enum1.THREE)
    else
      assertEquals(1.toUInt, Enum1.ONE)
      assertEquals(2.toUInt, Enum1.TWO)
      assertEquals(3.toUInt, Enum1.THREE)

  @Test def test_enum_extensions(): Unit =
    assertEquals(1, Enum1.ONE.int)
    assertEquals(2, Enum1.TWO.int)
    assertEquals(3, Enum1.THREE.int)

  @Test def test_signed_enums(): Unit =
    assertEquals(-1, Enum2.MINUS_ONE)
    assertEquals(-2, Enum2.MINUS_TWO)
    assertEquals(4, Enum2.FOUR)

  @Test def test_bitwise_operation(): Unit =
    import EnumBitwiseOperations.*
    assertTrue((BITWISE_ONE & BITWISE_THREE) == BITWISE_ONE)
    assertTrue((BITWISE_ONE | BITWISE_TWO) == BITWISE_THREE)
    assertTrue(BITWISE_THREE.is(BITWISE_ONE) && BITWISE_THREE.is(BITWISE_TWO))

  @Test def test_reserved_keywords(): Unit =
    assertEquals(1, EnumKeywords.`match`.int)
    assertEquals(2, EnumKeywords.`true`.int)
    assertEquals(3, EnumKeywords.`false`.int)
    assertEquals(4, EnumKeywords.`class`.int)
    assertEquals(5, EnumKeywords.`object`.int)
    assertEquals(6, EnumKeywords.`null`.int)
    assertEquals(7, EnumKeywords.`type`.int)
    assertEquals(8, EnumKeywords.`val`.int)
    assertEquals(9, EnumKeywords.`var`.int)
  end test_reserved_keywords

  @Test def test_getname(): Unit =
    assertEquals(Some("ONE"), Enum1.getName(Enum1.ONE))
    assertEquals(Some("TWO"), Enum1.getName(Enum1.TWO))
    assertEquals(Some("THREE"), Enum1.getName(Enum1.THREE))
    assertEquals(None, Enum1.getName(Enum1.define(4)))
  end test_getname

  @Test def test_anon_enum(): Unit =
    Zone:
      val test = EnumAnon()
      (!test).protocol = EnumAnon_Protocol.WHAT
      (!test).howdy = 25

      assert((!test).protocol == EnumAnon_Protocol.WHAT)
      assert((!test).howdy == 25)
  end test_anon_enum

  @Test def test_small_enums(): Unit =
    Zone:
      if !isWindows then
        assertEquals(
          (PackedEnum8.TOP | PackedEnum8.CENTER).value,
          (0x01.toByte | 0x02.toByte).toUByte
        )

  @Test def test_tags(): Unit =
    summon[Tag[Enum1]]
    summon[Tag[Enum2]]
    summon[Tag[EnumKeywords]]
    summon[Tag[EnumAnon_Protocol]]

end TestEnums
