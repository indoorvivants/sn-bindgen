package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

class TestRecursiveStructs:
  import lib_test_recursive_structs.types.*
  @Test def test_simple_recursive(): Unit =
    zone {
      val nested3 = Recrusive_Simple(null, 333.33)
      val nested2 = Recrusive_Simple(nested3, 222.22)
      val nested1 = Recrusive_Simple(nested2, 111.11)
      val nested0 = Recrusive_Simple(nested1, 0.0)

      assertEquals(111.11, (!(!nested0).hello).d, 0.01d)
      assertEquals(222.22, (!(!nested1).hello).d, 0.01d)
      assertEquals(333.33, (!(!nested2).hello).d, 0.01d)
      assertEquals(null, (!nested3).hello)

      (!(!nested0).hello).hello = nested3
      assertEquals(
        nested3.unary_!.d,
        nested0.unary_!.hello.unary_!.hello.unary_!.d,
        0.01d
      )
    }

  @Test def test_mutually_recursive(): Unit =
    zone {
      val struct1 = Recrusive_Struct1(null, 1.0)
      val struct2 = Recursive_Struct2(struct1, c"hello")
      val struct3 = Recursive_Struct3(hello_func(null), 25)
      (!struct1).hello = struct3

      assertEquals(1.0, struct1.unary_!.d, 0.01d)
      assertEquals('h', struct2.unary_!.str(0))

    }
end TestRecursiveStructs