package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import bindgen.TestFunctionRewrites

class TestFunctionRewrites:
  import lib_test_function_rewrites.functions.*
  import lib_test_function_rewrites.types.*
  @Test def test_with_pointers(): Unit =
    zone {
      val t1 = FunctionRewriteStruct(25, 35.0)
      val t2 = FunctionRewriteStruct(15, 40.0)
      val i = 100

      val result = !rewrite_good_func(t1, t2, i)

      assertEquals(25 * 100 - 15 * 100, result.i)
      assertEquals(35.0 * 100 + 40.0 * 100, result.b, 0.01f)

    }
  @Test def test_with_allocators(): Unit =
    zone {
      val t1 = FunctionRewriteStruct(25, 35.0)
      val t2 = FunctionRewriteStruct(15, 40.0)

      val result = rewrite_bad_func(!t1, !t2)

      assertEquals(35.0 * 40.0, result.b, 0.01f)
      assertEquals(25 - 15, result.i)

    }
  @Test def test_with_no_return_value(): Unit =
    zone {
      val t1 = FunctionRewriteStruct(25, 35.0)
      val t2 = FunctionRewriteStruct(15, 40.0)
      val i = 100

      assertEquals(25 - 15, rewrite_better_func(!t1, !t2))
      assertEquals(15 - 25, rewrite_better_func(!t2, !t1))
    }

  @Test def test_pointer_versions(): Unit =
    zone {
      val t1 = FunctionRewriteStruct(25, 35.0)
      val t2 = FunctionRewriteStruct(15, 40.0)
      val resultPtr = FunctionRewriteStruct()
      {
        // this method shouldn't require a Zone!
        given Zone = ???
        rewrite_bad_func(t1, t2)(resultPtr)

        assertEquals(35.0 * 40.0, (!resultPtr).b, 0.01f)
      }

      val result = rewrite_bad_func(t1, t2)

      assertEquals(35.0 * 40.0, result.b, 0.01f)
    }
end TestFunctionRewrites
