package bindgen.rendering
import bindgen.*

import bindgen.Binding
import scala.scalanative.unsafe.Tag
import scala.scalanative.annotation.alwaysinline
import scala.collection.mutable.ListBuffer

def escape(name: String) =
  val keywords = Set("type", "val", "class", "object", "null", "match")
  if keywords.contains(name) then s"`$name`" else name

case class Error(msg: String) extends Exception(msg)

import scala.scalanative.unsafe.*
import scalanative.unsigned.*

def indent(using c: Config): String =
  (" " * (c.indentSize.value * c.indents.value))

def nest(f: Config ?=> Unit)(using config: Config) =
  f(using config.copy(indents = config.indents.map(_ + 1)))

def to(sb: StringBuilder)(using config: Config): Appender =
  line => sb.append(indent(using config) + line + "\n")

def aliasResolver(name: String)(using ar: AliasResolver): CType =
  ar(name)

def packageName(using conf: Config): String = conf.packageName.value

type Appender = Config ?=> String => Unit

type AliasResolver = String => CType

object AliasResolver:
  def create(aliases: Seq[Def]): AliasResolver = s =>
    aliases
      .collectFirst {
        case Def.Struct(fields, name, _) if name == s =>
          CType.Struct(fields.map(_._2).toList)
        case Def.Union(fields, name) if name == s =>
          CType.Struct(fields.map(_._2).toList)
        case Def.Alias(name, underlying) if name == s =>
          underlying
        case Def.Enum(_, Some(name), Some(tp)) if name == s =>
          tp
      }
      .getOrElse(throw Error(s"Failed to resolve aliased definition $s"))
end AliasResolver
