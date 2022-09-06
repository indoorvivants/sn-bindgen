package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

class TestFunctions:
  import lib_test_functions.functions
  @Test def test1(): Unit =
    assertEquals(functions.test1(25.0, 32.0), -1)
    assertEquals(functions.test1(32.0, 25.0), 1)
    assertEquals(functions.test1(25.0, 25.0), 0)
