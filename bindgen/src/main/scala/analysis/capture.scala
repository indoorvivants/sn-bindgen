package bindgen

import scala.scalanative.unsafe.*

opaque type Memory = (String, () => Unit)
object Memory:
  extension (f: Memory)
    def deallocate() =
      System.err.println(s"Deallocating ${f._1}")
      f._2()

type Captured[D] = (D, Config)
object Captured:
  def unsafe[D: Tag](value: D)(using c: Config): (Ptr[Captured[D]], Memory) =
    import scalanative.runtime.*

    System.err.println(s"Allocating ${value.toString}")
    val rawptr = libc.malloc(sizeof[Captured[D]])
    val mem = fromRawPtr[Captured[D]](rawptr)
    val deallocate: Memory =
      (value.toString(), () => libc.free(toRawPtr[Captured[D]](mem)))

    val tuple = (value, c)

    val originalAddress = Intrinsics.castObjectToRawPtr(tuple)

    Intrinsics.storeObject(rawptr, tuple)

    // System.err.println(s"Original address: $originalAddress, ptr: $rawptr")

    (mem, deallocate)
  end unsafe
end Captured
