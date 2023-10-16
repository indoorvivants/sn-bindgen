package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

class TestAliases:
  import lib_test_aliases.types.*
  import lib_test_aliases.functions.*

  @Test def test_basics() =
    zone:
      assertEquals(42069, hello_alias(42069).value)

      val x: Int = hello_alias(42069).value

      assertTrue(hello_alias._tag == alias_of_an_alias._tag)
      assertEquals(hello_alias(25), alias_of_an_alias(hello_alias(25)))

      summon[Tag[hello_alias]]

      // testing that alias_of_an_alias is not opaque
      val t: alias_of_an_alias = hello_alias(25)

      assertEquals(t.value, hello_alias(25).value)
      assertEquals(t.value, 25)

  @Test def test_function_pointers() =
    zone:
      val test = TestStruct(10)

      val square = TestFunctionPointer: (struct: Ptr[TestStruct]) =>
        (!struct)._ne * (!struct)._ne

      // sanity check first
      assertEquals(500, higher_order_function(5, square, test))

      val ptr: Ptr[Byte] = CFuncPtr.toPtr(square.value)
      val squareReconstructed =
        TestFunctionPointer.fromPtr(ptr)

      // now check reconstructed function is still valid
      assertEquals(500, higher_order_function(5, squareReconstructed, test))

      // test toPtr/fromPtr pair
      val roundTrip =
        TestFunctionPointer.fromPtr(square.toPtr)

      // now check reconstructed function is still valid
      assertEquals(500, higher_order_function(5, roundTrip, test))

end TestAliases
