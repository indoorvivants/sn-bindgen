package bindgen

import scala.collection.mutable.ListBuffer
import bindgen.CType.Parameter
import scala.collection.mutable
import Def.*
import scala.scalanative.unsigned.ULong
import scala.scalanative.unsafe.Tag
import CType.*
import scala.scalanative.unsafe.*
import scala.scalanative.posix.time.*
import scala.scalanative.libc.stdio.*
import scala.scalanative.posix.sys.socket.*

case class BuiltinType(
    short: String,
    full: String,
    size: ULong,
    alignment: ULong
)

object BuiltinType:
  def apply[T: Tag](short: String, full: String) =
    new BuiltinType(short, full, size[T], alignment[T])

  val all = List(
    apply[FILE](
      "FILE",
      "scala.scalanative.libc.stdio.FILE"
    ),
    apply[fpos_t](
      "fpos_t",
      "scala.scalanative.libc.stdio.fpos_t"
    ),
    apply[CVarArgList](
      "va_list",
      _unsafe("CVarArgList")
    ),
    apply[CSize](
      "size_t",
      _unsafe("CSize")
    ),
    apply[CSSize](
      "ssize_t",
      _unsafe("CSSize")
    ),
    apply[time_t](
      "time_t",
      "scala.scalanative.posix.time.time_t"
    ),
    apply[sockaddr](
      "sockaddr",
      "scala.scalanative.posix.sys.socket.sockaddr"
    )
  )
end BuiltinType
