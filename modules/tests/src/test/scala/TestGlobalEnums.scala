package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scala.scalanative.meta.LinktimeInfo.isWindows

class TestGlobalEnums:
  import lib_test_global_enums.constants.*
  @Test def test_basic_enums(): Unit =
    // On windows default type for enums seems to be int
    if isWindows then
      assertEquals(25, HELLO)
      assertEquals(11, BYEBYE)
    else
      assertEquals(25.toUInt, HELLO)
      assertEquals(11.toUInt, BYEBYE)

    assertEquals(-1, HOW)
    assertEquals(-2, DOESTHIS)
    assertEquals(0, WORK)
  end test_basic_enums

end TestGlobalEnums
