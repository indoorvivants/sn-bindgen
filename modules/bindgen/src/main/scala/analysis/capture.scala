package bindgen

import scala.scalanative.unsafe.*

opaque type Memory = (String, () => Unit)
object Memory:
  extension (f: Memory)
    def deallocate() =
      f._2()

type Captured[D] = (D, Config)
object Captured:
  def unsafe[D: Tag](value: D)(using c: Config): (Ptr[Captured[D]], Memory) =
    import scalanative.runtime.*

    val rawptr = libc.malloc(sizeof[Captured[D]])
    val mem = fromRawPtr[Captured[D]](rawptr)
    val deallocate: Memory =
      (
        value.toString(),
        () =>
          GCRoots.removeRoot(value.asInstanceOf[Object])
          libc.free(toRawPtr[Captured[D]](mem))
      )

    val tuple = (value, c)

    val originalAddress = Intrinsics.castObjectToRawPtr(tuple)

    Intrinsics.storeObject(rawptr, tuple)

    GCRoots.addRoot(tuple)

    (mem, deallocate)
  end unsafe

end Captured

object GCRoots:
  private val references = new java.util.IdentityHashMap[Object, Unit]
  def addRoot(o: Object): Unit = references.put(o, ())
  def removeRoot(o: Object): Unit = references.remove(o)
