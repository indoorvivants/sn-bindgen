package lib_test_multi_file

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

/**
 * bindgen: --multi-file
*/
opaque type Test = CArray[Byte, Nat._4]
object Test:
  given _tag: Tag[Test] = Tag.CArray[CChar, Nat._4](Tag.Byte, Tag.Nat4)
  def apply()(using Zone): Ptr[Test] =
    val ___ptr = _root_.scala.scalanative.unsafe.alloc[Test](1)
    ___ptr
  @scala.annotation.targetName("apply_x")
  def apply(x: CInt)(using Zone): Ptr[Test] =
    val ___ptr = _root_.scala.scalanative.unsafe.alloc[Test](1)
    val un = !___ptr
    un.at(0).asInstanceOf[Ptr[CInt]].update(0, x)
    ___ptr
  @scala.annotation.targetName("apply_y")
  def apply(y: CChar)(using Zone): Ptr[Test] =
    val ___ptr = _root_.scala.scalanative.unsafe.alloc[Test](1)
    val un = !___ptr
    un.at(0).asInstanceOf[Ptr[CChar]].update(0, y)
    ___ptr
  extension (struct: Test)
    def x : CInt = !struct.at(0).asInstanceOf[Ptr[CInt]]
    def x_=(value: CInt): Unit = !struct.at(0).asInstanceOf[Ptr[CInt]] = value
    def y : CChar = !struct.at(0).asInstanceOf[Ptr[CChar]]
    def y_=(value: CChar): Unit = !struct.at(0).asInstanceOf[Ptr[CChar]] = value