package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import lib_test_typedefs.types.*

class TestTypeDefs:

  @Test def test_basics() =
    val enum1 = DUCKDB_TYPEs.DUCKDB_TYPE_INVALID

    Zone {
      val st = Hello()
    }

end TestTypeDefs
