package bindgen.rendering

import bindgen.*

import bindgen.Binding
import scala.scalanative.unsafe.Tag
import scala.scalanative.annotation.alwaysinline
import scala.collection.mutable.ListBuffer

enum Sanitation:
  case Renamed(value: String)
  case Escaped
  case Good

def sanitise(name: String) =
  val keywords =
    Set(
      "type",
      "val",
      "var",
      "class",
      "def",
      "object",
      "null",
      "match",
      "true",
      "false",
      "final",
      "new"
    )
  val reserved = Set("notify", "wait")
  if name == "_" then Sanitation.Renamed("$underscore")
  else if reserved(name) then Sanitation.Renamed(s"_$name")
  else if keywords.contains(name) || name.endsWith("_") then Sanitation.Escaped
  else Sanitation.Good
end sanitise

def escape(name: String) =
  val keywords =
    Set(
      "type",
      "val",
      "var",
      "class",
      "def",
      "object",
      "null",
      "match",
      "true",
      "false",
      "final",
      "new"
    )
  if name == "_" then "$underscore"
  else if keywords.contains(name) || name.endsWith("_") then s"`$name`"
  else name
end escape

// I know, I know... the name is perfect.
def sanitiseBeforeColon(name: String) =
  if name.endsWith("_") then s"$name " else name

case class Error(msg: String) extends Exception(msg)

import scala.scalanative.unsafe.*
import scalanative.unsigned.*

def indent(using c: Config): String =
  (" " * (c.indentSize.value * c.indents.value))

def nest(f: Config ?=> Unit)(using config: Config) =
  f(using config.copy(indents = config.indents.map(_ + 1)))

def nestIf(cond: Boolean)(f: Config ?=> Unit)(using config: Config) =
  val next = if cond then 1 else 0 
  f(using config.copy(indents = config.indents.map(_ + next)))

def to(sb: LineBuilder)(using config: Config): Appender =
  import LineBuilder.*
  line => sb.appendLine(indent(using config) + line)

def aliasResolver(name: String)(using ar: AliasResolver): CType =
  ar(name)

def packageName(using conf: Config): String = conf.packageName.value

type Appender = Config ?=> String => Unit

opaque type AliasResolver = String => CType

object AliasResolver:
  extension (ar: AliasResolver) def apply(s: String) = ar(s)

  inline def apply(inline f: String => CType): AliasResolver = f

  def create(aliases: Seq[Def])(using LoggingConfig): AliasResolver =
    val mapping = Map.newBuilder[String, CType]
    def go(definitions: Seq[Def]): Unit =
      definitions.foreach {
        case st @ Def.Struct(fields, name, _) =>
          val typ = CType.Struct(fields.map(_._2).toList)
          mapping += name.value -> typ
          mapping ++= traverse(st)
        case u @ Def.Union(fields, name, _) =>
          val typ = CType.Struct(fields.map(_._2).toList)
          mapping += name.value -> typ
          mapping ++= traverse(u)
        case Def.Alias(name, underlying) =>
          mapping += name -> underlying
        case Def.Enum(_, Some(name), Some(tp)) =>
          mapping += name.value -> tp
        case _ =>
      }

    go(aliases)

    trace("Aliases:", mapping.result().toSeq)

    val result = mapping.result()

    apply(s =>
      result
        .getOrElse(s, throw Error(s"Failed to resolve aliased definition $s"))
    )

  end create

  private def traverse(st: Def.Union | Def.Struct)(using
      LoggingConfig
  ) =
    def go(
        s: Def.Union | Def.Struct,
        bld: Tuple2[String, CType] => Unit,
        prepend: String = ""
    ): Unit =
      val anonymous = s match
        case u: Def.Union  => u.anonymous
        case u: Def.Struct => u.anonymous

      val thisName = prepend +
        (s match
          case u: Def.Union  => u.name.value
          case u: Def.Struct => u.name.value
        )

      s match
        case u: Def.Union =>
          bld(thisName -> Def.typeOf(u))
        case s: Def.Struct =>
          bld(thisName -> Def.typeOf(s))

      anonymous.foreach { u =>
        go(u, bld, prepend = thisName + ".")
      }
    end go

    val bld = Map.newBuilder[String, CType]
    go(st, bld.addOne(_))
    bld.result
  end traverse

end AliasResolver

opaque type LineBuilder = StringBuilder
object LineBuilder:
  private val SEP = System.lineSeparator()
  def apply(): LineBuilder = new StringBuilder
  extension (lb: LineBuilder)
    def result: String = lb.result
    def appendLine(s: String): LineBuilder = lb.append(s + SEP)
    def emptyLine: LineBuilder = lb.append(SEP)
    def emptyLines(n: Int): LineBuilder = lb.append(SEP * n)
    def append(s: String): LineBuilder = lb.append(s)
