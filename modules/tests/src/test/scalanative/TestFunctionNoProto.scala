package bindgen

import lib_test_function_no_proto.all.*

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import bindgen.TestFunctionRewrites

object LongLived:
  var meta: Ptr[MetaObj] = null

class TestFunctionNoProto:
  @Test def test_basic(): Unit =
    Zone:
      LongLived.meta = MetaObj(17)
      val callback = CFuncPtr0.fromScalaFunction(() => LongLived.meta)

      val result = test_function_np_proto(c"hello", callback)

      assertEquals(5 + 17, result)
