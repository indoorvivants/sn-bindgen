package bindgen.interface

import java.io.*
import java.lang.ProcessBuilder.Redirect
import java.nio.file.*
import scala.sys.process.ProcessLogger
import scala.util.control.NonFatal

sealed trait BindingLang extends Product with Serializable
object BindingLang {
  case object Scala extends BindingLang
  case object C extends BindingLang
}

sealed abstract class LogLevel(val str: String)
    extends Product
    with Serializable

object LogLevel {
  case object Trace extends LogLevel("trace")
  case object Info extends LogLevel("info")
  case object Warn extends LogLevel("warning")
  case object Error extends LogLevel("error")

  def apply(str: String): Option[LogLevel] =
    try {
      Option {
        str.toLowerCase match {
          case "trace"   => Trace
          case "info"    => Info
          case "warning" => Warn
          case "error"   => Error
        }
      }
    } catch { case _: MatchError => None }
}

import BindingLang.*
sealed trait Includes extends Product with Serializable
object Includes {
  case object ClangSearchPath extends Includes
  case object None extends Includes
}
