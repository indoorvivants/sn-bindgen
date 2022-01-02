package bindgen

import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.*

extension (seq: Seq[String])
  def toCArray(using Zone): Ptr[CString] =
    val mem = alloc[CString](seq.size)
    (0 until seq.size).foreach { i =>
      mem(i) = toCString(seq(i))
    }

    mem
