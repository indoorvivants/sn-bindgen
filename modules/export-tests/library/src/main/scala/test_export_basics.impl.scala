package lib_test_export_basics
package impl

import scalanative.unsafe.*
import all.*

object Implementations extends ExportedFunctions:
  override def myscalalib_exports(i: Int, r: Int) =
    i * r
  override def myscalalib_complex(
      times: Int,
      clamp: Ptr[myscalalib_struct],
      result: CString
  ) =
    val midpoint = times - 1
    (0 until (times * 2)).foreach { i =>
      result(i) = if i > midpoint then (!clamp).b else (!clamp).a
    }
end Implementations
