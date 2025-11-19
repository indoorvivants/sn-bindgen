package bindgen

import bindgen.RenderingConfig.FilterSpec
import opaque_newtypes.*

import scala.util.matching.Regex

object RenderingConfig:
  def withDefaults: RenderingConfig =
    RenderingConfig(
      noConstructor = Set.empty,
      opaqueStruct = Set.empty,
      comments = RenderComments.Yes,
      location = RenderLocation.No,
      externalNames = Map.empty,
      externalPaths = Map.empty
    )

  opaque type FilterSpec = String
  object FilterSpec extends OpaqueString[FilterSpec]

  enum NameFilter(value: FilterSpec):
    case Single(value: FilterSpec) extends NameFilter(value)
    case Wildcard(value: FilterSpec) extends NameFilter(value)

    val compiled: Regex = this match
      case Single(value) => Regex.quote(value).r
      case Wildcard(value) =>
        val parts = value.split(Regex.quote("*"), -1).toList
        parts.mkString(".*").r.anchored

    def matches(s: String): Option[FilterSpec] =
      Option.when(compiled.matches(s))(value)

    override def toString(): String = value
  end NameFilter

  object NameFilter:
    def apply(value: String) =
      if value.contains("*") then NameFilter.Wildcard(value)
      else NameFilter.Single(value)
end RenderingConfig

import RenderingConfig.NameFilter

case class RenderingConfig(
    noConstructor: Set[NameFilter],
    opaqueStruct: Set[NameFilter],
    comments: RenderComments,
    location: RenderLocation,
    externalPaths: Map[NameFilter, PackageName],
    externalNames: Map[NameFilter, PackageName]
):
  def matches(
      f: this.type => Set[NameFilter]
  )(name: String): Option[FilterSpec] = f(this).iterator
    .map(_.matches(name))
    .collectFirst { case a if a.isDefined => a }
    .flatten

  def matchesPackage(f: this.type => Map[NameFilter, PackageName])(
      name: String
  ): Option[(FilterSpec, PackageName)] =
    val filters = f(this)
    filters.iterator
      .map((filterName, pkgName) => filterName.matches(name).map(_ -> pkgName))
      .collectFirst { case a if a.isDefined => a }
      .flatten

end RenderingConfig
