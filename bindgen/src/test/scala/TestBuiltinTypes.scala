package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scala.scalanative.posix.time
import scala.scalanative.libc

class TestBuiltInTypes:
  import lib_test_built_in_types.types.*
  @Test def correct_tags(): Unit =
    assertEquals(summon[Tag[CSize]], Test_size_t._tag)
    assertEquals(summon[Tag[CSSize]], Test_ssize_t._tag)
    assertEquals(summon[Tag[time.time_t]], Test_time_t._tag)
    assertEquals(summon[Tag[libc.stdio.fpos_t]], Test_fpos_t._tag)

    // these should just compile
    summon[Test_size_t =:= CSize]
    summon[Test_ssize_t =:= CSSize]
    summon[Test_time_t =:= time.time_t]
    summon[Test_fpos_t =:= libc.stdio.fpos_t]
  end correct_tags
end TestBuiltInTypes
