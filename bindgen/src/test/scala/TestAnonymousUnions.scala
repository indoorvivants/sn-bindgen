package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

class TestAnonymousNested:
  import lib_test_anonymous.types.*

  @Test def test_struct() =
    zone {

      val struct =
        AnonymousNestedStruct.Union0.Struct0(hat = 25, hat_mask = -50)
      val union1 = AnonymousNestedStruct.Union0(!struct)
      val union2 = AnonymousNestedStruct.Union0(button = 182)
      val union3 = AnonymousNestedStruct.Union0(axis = 39.0f)

      val largeStruct1 = !AnonymousNestedStruct(!union1, 25011)

      assertEquals(25011, largeStruct1.test)
      assertEquals(25, largeStruct1.value.headgear.hat)

      val largeStruct2 = !AnonymousNestedStruct(!union2, 25011)

      assertEquals(25011, largeStruct2.test)
      assertEquals(182, largeStruct2.value.button)

      val largeStruct3 = !AnonymousNestedStruct(!union3, 25011)

      assertEquals(25011, largeStruct3.test)
      assertEquals(39.0f, largeStruct3.value.axis, 0.0001f)

    }

  @Test def test_union() =
    zone {

      val struct = AnonymousNestedUnion.Union0.Struct0(hat = 25, hat_mask = -50)
      val union1 = AnonymousNestedUnion.Union0(!struct)
      val union2 = AnonymousNestedUnion.Union0(button = 182)
      val union3 = AnonymousNestedUnion.Union0(axis = 39.0f)

      val largeUnion1 = !AnonymousNestedUnion(value = !union1)
      val largeUnion2 = !AnonymousNestedUnion(value = !union2)
      val largeUnion3 = !AnonymousNestedUnion(value = !union3)
      val largeUnion4 = !AnonymousNestedUnion(test = 25011)

      assertEquals(25, largeUnion1.value.headgear.hat)
      assertEquals(-50, largeUnion1.value.headgear.hat_mask)

      assertEquals(182, largeUnion2.value.button)
      assertEquals(39.0f, largeUnion3.value.axis, 0.0001f)
      assertEquals(25011, largeUnion4.test)

    }

end TestAnonymousNested
