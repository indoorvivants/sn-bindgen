package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scala.scalanative.*

import scala.util.NotGiven

class TestBuiltInTypes_NoWindows:
  import lib_test_built_in_types.types.*
  @Test def correct_tags(): Unit =
    summon[sockaddr =:= posix.sys.socket.sockaddr]
    summon[NotGiven[group =:= posix.grp.group]]
  end correct_tags
