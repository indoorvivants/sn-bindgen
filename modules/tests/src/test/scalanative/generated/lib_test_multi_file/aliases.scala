package lib_test_multi_file

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

type HelloAlias = Hello
object HelloAlias:
  given _tag: Tag[HelloAlias] = Hello._tag
  inline def apply(inline o: Hello): HelloAlias = o
  extension (v: HelloAlias) inline def value: Hello = v

opaque type Howdy = Float
object Howdy:
  given _tag: Tag[Howdy] = Tag.Float
  inline def apply(inline o: Float): Howdy = o
  extension (v: Howdy) inline def value: Float = v
