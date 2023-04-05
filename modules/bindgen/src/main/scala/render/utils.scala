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

val scalaKeyWords =
  Set(
    "abstract",
    "case",
    "catch",
    "class",
    "def",
    "do",
    "else",
    "extends",
    "false",
    "final",
    "finally",
    "for",
    "forSome",
    "if",
    "implicit",
    "import",
    "lazy",
    "match",
    "new",
    "null",
    "object",
    "override",
    "package",
    "private",
    "protected",
    "return",
    "sealed",
    "super",
    "this",
    "throw",
    "trait",
    "try",
    "true",
    "type",
    "val",
    "var",
    "while",
    "with",
    "yield"
  )

def sanitise(name: String) =
  val reserved = Set("notify", "wait")
  if name == "_" then Sanitation.Renamed("$underscore")
  else if reserved(name) then Sanitation.Renamed(s"_$name")
  else if scalaKeyWords.contains(name) || name.endsWith("_") then
    Sanitation.Escaped
  else Sanitation.Good
end sanitise

def escape(name: String) =
  if name == "_" then "$underscore"
  else if scalaKeyWords.contains(name) || name.endsWith("_") then s"`$name`"
  else name
end escape

// I know, I know... the name is perfect.
def sanitiseBeforeColon(name: String) =
  if name.endsWith("_") then s"$name " else name

case class Error(msg: String) extends Exception(msg)

def raiseError(msg: String) = throw new Error(msg)

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
