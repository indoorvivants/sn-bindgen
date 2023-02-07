package bindgen

import opaque_newtypes.*
import java.io.File
import scala.util.matching.Regex
import scala.util.chaining.*

object RenderingConfig:
  enum NameFilter(value: String):
    case Single(value: String) extends NameFilter(value)
    case Wildcard(value: String) extends NameFilter(value)

    val compiled: Regex = this match
      case Single(value) => Regex.quote(value).r
      case Wildcard(value) =>
        val parts = value.split(Regex.quote("*"), -1).toList
        parts.mkString(".*").r.anchored

    def matches(s: String): Option[String] =
      Option.when(compiled.matches(s))(value)
  end NameFilter

  object NameFilter:
    def apply(value: String) =
      if value.contains("*") then NameFilter.Wildcard(value)
      else NameFilter.Single(value)
end RenderingConfig

import RenderingConfig.NameFilter

case class RenderingConfig(
    noConstructor: Set[NameFilter],
    opaqueStruct: Set[NameFilter]
):
  def matches(f: this.type => Set[NameFilter])(name: String) = f(this).iterator
    .map(_.matches(name))
    .collectFirst { case a if a.isDefined => a }
    .flatten
