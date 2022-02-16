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

  @Test def test_tags(): Unit =
    summon[Tag[Enum1]]
    summon[Tag[Enum2]]
    summon[Tag[EnumKeywords]]

end TestEnums
