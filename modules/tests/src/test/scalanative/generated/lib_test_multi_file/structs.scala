package lib_test_multi_file

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

opaque type Hello = CStruct2[CInt, Howdy]
object Hello:
  given _tag: Tag[Hello] = Tag.materializeCStruct2Tag[CInt, Howdy]
  def apply()(using Zone): Ptr[Hello] = scala.scalanative.unsafe.alloc[Hello](1)
  def apply(bla : CInt, yes : Howdy)(using Zone): Ptr[Hello] = 
    val ____ptr = apply()
    (!____ptr).bla = bla
    (!____ptr).yes = yes
    ____ptr
  extension (struct: Hello)
    def bla : CInt = struct._1
    def bla_=(value: CInt): Unit = !struct.at1 = value
    def yes : Howdy = struct._2
    def yes_=(value: Howdy): Unit = !struct.at2 = value