package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

class TestExternGlobals:
  import lib_test_extern_globals.all.*

  @Test def test_simple_int_const(): Unit =
    assertEquals(42, simple_int_const)

  @Test def test_writable_int_initial(): Unit =
    assertEquals(7, writable_int)

  @Test def test_writable_int_mutates(): Unit =
    val previous = writable_int
    try
      writable_int = 123
      assertEquals(123, writable_int)
    finally writable_int = previous

  @Test def test_some_string(): Unit =
    Zone:
      assertEquals("hello extern", fromCString(some_string))

  @Test def test_some_opaque_not_null(): Unit =
    assertNotEquals(null, some_opaque)
