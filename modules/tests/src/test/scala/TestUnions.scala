package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

class TestUnions:
  import lib_test_unions.types.*

  @Test def test_basics() =
    zone {
      val empty = UnionSimple()
      val int_like = UnionSimple(31.toUInt)
      val float_like = UnionSimple(25.0f)
      val string_like = UnionSimple(c"hello")

      assertEquals(31.toUInt, (!int_like).i)
      assertEquals(25.0f, (!float_like).b, 0.0001f)
      assertEquals("hello", fromCString((!string_like).s))
    }

  @Test def test_setters() =
    zone {
      val un = !UnionSimple(31.toUInt)

      un.i = 150.toUInt
      assertEquals(150.toUInt, un.i)

      un.b = 1735.0f
      assertEquals(1735.0f, un.b, 0.0001f)

      un.s = c"hello world!"
      assertEquals("hello world!", fromCString(un.s))
    }

end TestUnions
