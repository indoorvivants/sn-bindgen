package bindgen

import scala.scalanative.libc.stdio.*
import scala.scalanative.posix.sys.socket.*
import scala.scalanative.posix.time.*
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

private def integral(base: IntegralBase, st: SignType) =
  CType.NumericIntegral(base, st)

private def _unsafe(typ: String) = s"scala.scalanative.unsafe.$typ"
private def _libc(typ: String) = s"scala.scalanative.libc.$typ"
private def _posix(typ: String) = s"scala.scalanative.posix.$typ"
private def size[T](using t: Tag[T]) = t.size
private def alignment[T](using t: Tag[T]) = t.alignment

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
