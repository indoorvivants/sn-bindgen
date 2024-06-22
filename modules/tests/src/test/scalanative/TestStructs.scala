package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

class TestStructs:
  import lib_test_structs.types.*

  @Test def test_simple() =
    zone {
      val st = !StructSimple(25, 150, c"howdy", c"yo")

      assertEquals(25, st.x)
      assertEquals(150, st.y)
      assertEquals("howdy", fromCString(st.s1))
      assertEquals("yo", fromCString(st.s2))
    }
  @Test def test_complex() =
    zone {
      val st1 = !StructSimple(42, 420, c"s1", c"part 1")
      val st2 = !StructSimple(13, 130, c"s2", c"part 2")

      val arr = stackalloc[CArray[Int, Nat.Digit2[Nat._2, Nat._5]]]()
      (!arr).update(7, -1293939)
      val cs0 = StructComplex.Struct0('h')
      val cs1 = StructComplex.Struct1(25)
      val cx =
        !StructComplex(st1, st2, 111, !cs0, my_bool.m_false, !cs1, c"yes", !arr)

      assertEquals(cx.p1.x, 42)
      assertEquals(cx.p1.y, 420)
      assertEquals(cx.p2.x, 13)
      assertEquals(cx.p2.y, 130)

      assertEquals(my_bool.m_false, cx.flag)
      assertEquals(111, cx.x)

      assertEquals(cx.test(7), -1293939)
    }
  @Test def test_anonymous() =
    zone {
      val context = !StructAnonymous.Union0(25)
      val header = !StructAnonymous.Struct1(c"k1", c"v1")
      val struct = !StructAnonymous(25, context, header)

      assertEquals(25, context.num)
      assertEquals(25, struct.context.num)

      assertEquals("k1", fromCString(header.key))
      assertEquals("v1", fromCString(header.value))
      assertEquals("k1", fromCString(struct.header.key))
      assertEquals("v1", fromCString(struct.header.value))

      struct.context.str = c"what"
      assertEquals("what", fromCString(struct.context.str))
    }

end TestStructs
