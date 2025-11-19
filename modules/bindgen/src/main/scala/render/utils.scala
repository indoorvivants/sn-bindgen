package bindgen.rendering

import bindgen.*

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
    "macro",
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
    "true",
    "try",
    "type",
    "val",
    "var",
    "while",
    "with",
    "yield"
  )

def sanitise(name: String) =
  val reserved = Set("notify", "wait", "eq", "ne")
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

def escapeInCase(name: String) =
  if name == "_" then "`$underscore`"
  else "`" + name + "`"

// I know, I know... the name is perfect.
def sanitiseBeforeColon(name: String) =
  if name.endsWith("_") then s"$name " else name

case class Error(msg: String) extends Exception(msg)

def raiseError(msg: String) = throw new Error(msg)

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

//objects, traits, classes
def objectBlock(line: Appender)(start: String)(
    f: Config ?=> Unit
)(using config: Config): Unit =
  val startDelimiter = if config.useBraces.value then " {" else ":"
  line(start + startDelimiter)
  nest {
    f
  }
  if config.useBraces.value then line("}")

//defs, vals, extensions
def defBlock(
    line: Appender
)(start: String, defNameForEnd: Option[String] = None)(
    f: Config ?=> Unit
)(using config: Config): Unit =
  val startDelimiter = if config.useBraces.value then " {" else ""
  line(start + startDelimiter)
  nest {
    f
  }
  if config.useBraces.value then line("}")
  else defNameForEnd.foreach(n => line(s"end $n"))
end defBlock

def packageName(using conf: Context): String = conf.packageName.value

type Appender = Config ?=> String => Unit

opaque type LineBuilder = StringBuilder
object LineBuilder:
  private val SEP = System.lineSeparator()
  def apply(): LineBuilder = new StringBuilder
  extension (lb: LineBuilder)
    def result: String = lb.result
    def appendLine(s: String): LineBuilder = lb.append(s + SEP)
    def appendLineWhen(cond: Boolean)(s: String): LineBuilder =
      if cond then appendLine(s) else lb
    def emptyLine: LineBuilder = lb.append(SEP)
    def emptyLines(n: Int): LineBuilder = lb.append(SEP * n)
    def append(s: String): LineBuilder = lb.append(s)
end LineBuilder
