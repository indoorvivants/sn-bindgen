package bindgen.rendering

import bindgen.*

import bindgen.Binding
import scala.scalanative.unsafe.Tag
import scala.scalanative.annotation.alwaysinline
import scala.collection.mutable.ListBuffer

def escape(name: String) =
  val keywords =
    Set(
      "type",
      "val",
      "var",
      "class",
      "object",
      "null",
      "match",
      "true",
      "false",
      "final"
    )
  if keywords.contains(name) then s"`$name`" else name
end escape

case class Error(msg: String) extends Exception(msg)

import scala.scalanative.unsafe.*
import scalanative.unsigned.*

def indent(using c: Config): String =
  (" " * (c.indentSize.value * c.indents.value))

def nest(f: Config ?=> Unit)(using config: Config) =
  f(using config.copy(indents = config.indents.map(_ + 1)))

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
  def create(aliases: Seq[Def]): AliasResolver = s =>
    aliases
      .collectFirst {
        case Def.Struct(fields, name, _) if name.value == s =>
          CType.Struct(fields.map(_._2).toList)
        case Def.Union(fields, name, _) if name.value == s =>
          CType.Struct(fields.map(_._2).toList)
        case Def.Alias(name, underlying) if name == s =>
          underlying
        case Def.Enum(_, Some(name), Some(tp)) if name.value == s =>
          tp
      }
      .getOrElse(throw Error(s"Failed to resolve aliased definition $s"))

  extension (ar: AliasResolver)
    def nest(st: Def.Union | Def.Struct)(using LoggingConfig): AliasResolver =

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
      val result = bld.result

      trace("Build alias resolving", result.toSeq*)

      AliasResolver(s => result.getOrElse(s, ar(s)))

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
