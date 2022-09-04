package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scala.scalanative.*

import scala.util.NotGiven

class TestBuiltInTypes:
  import lib_test_built_in_types.types.*
  @Test def correct_tags(): Unit =
    assertEquals(summon[Tag[CSize]], Test_size_t._tag)
    assertEquals(summon[Tag[CSSize]], Test_ssize_t._tag)
    assertEquals(summon[Tag[posix.time.time_t]], Test_time_t._tag)
    assertEquals(summon[Tag[libc.stdio.fpos_t]], Test_fpos_t._tag)

    // these should just compile
    summon[Test_size_t =:= CSize]
    summon[Test_ssize_t =:= CSSize]
    summon[Test_time_t =:= posix.time.time_t]
    summon[Test_fpos_t =:= libc.stdio.fpos_t]
    summon[va_list =:= CVarArgList]
    summon[sockaddr =:= posix.sys.socket.sockaddr]
    summon[NotGiven[group =:= posix.grp.group]]
  end correct_tags

  @Test def consistent_uint_types(): Unit =
    // this should compile
    zone {
      val st = !SpecialIntTypes(
        i8 = -8.toByte,
        i16 = -16.toShort,
        i32 = -32,
        u8 = 8.toUByte,
        u16 = 16.toUShort,
        u32 = 32.toUInt
      )

      assertEquals(-8, st.i8.toInt)
      assertEquals(-16, st.i16.toInt)
      assertEquals(-32, st.i32.toInt)
      assertEquals(8, st.u8.toInt)
      assertEquals(16, st.u16.toInt)
      assertEquals(32, st.u32.toInt)
    }
end TestBuiltInTypes
