package bindgen

import scala.scalanative.unsafe.*

opaque type Memory = () => Unit
object Memory:
  extension (f: Memory) def deallocate() = f()

type Captured[D] = (D, Config)
object Captured:
  def unsafe[D: Tag](value: D)(using c: Config): (Ptr[Captured[D]], Memory) =
    import scalanative.runtime.*
    val mem = fromRawPtr[Captured[D]](libc.malloc(sizeof[Captured[D]]))
    val deallocate: Memory = () => libc.free(toRawPtr[Captured[D]](mem))

    !mem = (value, c)

    (mem, deallocate)
end Captured
