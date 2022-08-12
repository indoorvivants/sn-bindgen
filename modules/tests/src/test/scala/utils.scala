package bindgen

import scalanative.unsafe.*

inline def zone[A](inline f: Zone ?=> A) = Zone.apply(z => f(using z))
