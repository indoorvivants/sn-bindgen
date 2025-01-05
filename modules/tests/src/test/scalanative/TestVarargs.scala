package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

class TestVarargs:
  import lib_test_varags.all.*

  @Test def test_varargs() =
    Zone {
      assertEquals(15, test_my_sum(5, 1, 2, 3, 4, 5))
      assertEquals(0, test_my_sum(0, 1, 2, 3, 4, 5))
      val v = VaragsStruct(25, 'c')
      assertEquals(31, test_my_ptrs(v, 3, 1, 2, 3))

    }
end TestVarargs
