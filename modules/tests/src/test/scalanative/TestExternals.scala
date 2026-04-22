package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

class TestExternals:
  import lib_test_external_paths_inc.all.*
  import lib_test_external_paths.all.*

  @Test def test_basics() =
    Zone:
      val str = my_struct(25)
      val result = my_func(str)

      assertEquals(result, 25 * 11)
end TestExternals
