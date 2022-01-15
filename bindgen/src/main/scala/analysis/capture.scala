package bindgen

import scala.scalanative.unsafe.*

type Captured[D] = (D, Zone, Config)
object Captured:
  def allocate[D: Tag](value: D)(using z: Zone, c: Config): Ptr[Captured[D]] =
    val ptr = alloc[Captured[D]](1)
    !ptr = (value, z, c)

    ptr
