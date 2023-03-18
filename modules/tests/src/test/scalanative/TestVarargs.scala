package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

class TestVarargs:
  import lib_test_varags.all.*

  @Test def test_varargs() =
    zone {
      assertEquals(15, test_my_sum(5, 1, 2, 3, 4, 5))

    }
end TestVarargs
