package bindgen

import scala.scalanative.libc.stdio.*
import scala.scalanative.posix.sys.socket.*
import scala.scalanative.posix.netdb.*
import scala.scalanative.posix.netinet.in.*
import scala.scalanative.posix.time.*
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

private def integral(base: IntegralBase, st: SignType) =
  CType.NumericIntegral(base, st)

private def _unsafe(typ: String) = s"scala.scalanative.unsafe.$typ"
private def _scala(typ: String) = s"scala.$typ"
private def _unsigned(typ: String) = s"scala.scalanative.unsigned.$typ"
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
    apply[UByte]("uint8_t", _unsigned("UByte")),
    apply[UShort]("uint16_t", _unsigned("UShort")),
    apply[UInt]("uint32_t", _unsigned("UInt")),
    apply[ULong]("uint64_t", _unsigned("ULong")),
    apply[CChar]("int8_t", _unsafe("CChar")),
    apply[Short]("int16_t", _scala("Short")),
    apply[CInt]("int32_t", _unsafe("CInt")),
    apply[Long]("int64_t", _scala("Long"))
  )
end BuiltinType
