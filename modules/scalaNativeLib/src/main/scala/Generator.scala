import java.nio.file.Path
import scala.meta.*
import java.nio.file.Files

import scala.jdk.CollectionConverters.*
import scala.util.Using
import java.io.FileWriter
import java.io.File

object Generator {
  def main(args: Array[String]): Unit = {
    val path = args.head
    val target = args.tail.head
    val relative =
      Path.of(path, "posixlib/src/main/scala/scala/scalanative/posix/")
    val relativeLibc =
      Path.of(path, "clib/src/main/scala/scala/scalanative/libc")

    val lines = scala.io.Source.fromFile(target).getLines().toVector
    val startFrom = lines.indexWhere(_.contains("GENERATEDCODE: START"))
    val endAt = lines.indexWhere(_.contains("GENERATEDCODE: END"))

    assert(
      startFrom != -1,
      s"Could not find `// GENERATEDCODE: START` marker in $target"
    )
    assert(
      endAt != -1,
      s"Could not find `// GENERATEDCODE: END` marker in $target"
    )

    val results = List.newBuilder[String]

    (Files
      .walk(relative)
      .iterator()
      .asScala ++ Files.walk(relativeLibc).iterator().asScala)
      .filter(_.getFileName().toString.endsWith(".scala"))
      .map(_.parse[Source].get)
      .flatMap { m =>
        val packageName = List.newBuilder[String]

        val packages = m.traverse { case Pkg(ref, stats) =>
          packageName ++= extractPackageName(ref)
        }

        if (
          packageName
            .result()
            .startsWith(List("scala", "scalanative", "posix")) ||
          packageName.result().startsWith(List("scala", "scalanative", "libc"))
        )
          Option(
            (packageName.result().drop(3), packageName.result().apply(2), m)
          )
        else None

      }
      .map { case (pkg, top, m) =>
        m
          .collect { case o: Defn.Object /*if isTopLevelObj(o)*/ =>
            o
          }
          .foreach { o =>
            val scopeName = o.name.value
            o.collect {
              case t: Defn.Type if allowed(t) =>
                val segments =
                  (top +: pkg :+ scopeName :+ t.name).map(_.toString)
                val fqn = segments
                  .mkString(".")
                val fqnEscaped = segments
                  .map(s => if (scalaKeywords(s)) s"`$s`" else s)
                  .mkString(".")
                val header = (pkg :+ scopeName).mkString("/") + ".h"
                Option.when(!ignore(fqn)) {
                  s"""
                apply[$fqnEscaped](short = "${t.name}", full = "$fqnEscaped", header = "$header")
                """.strip()
                }
            }.flatten
              .foreach(results.addOne)
          }
      }
      .toList

    val linesBefore = lines.take(startFrom + 1)
    val linesAfter = lines.drop(endAt)

    val fw = new FileWriter(new File(target))

    Using.resource(fw) { fw =>
      fw.write(linesBefore.mkString(System.lineSeparator()))
      fw.write(System.lineSeparator())
      results
        .result()
        .map("    " + _ + "," + System.lineSeparator())
        .foreach(fw.write(_))
      fw.write((linesAfter :+ "").mkString(System.lineSeparator()))
    }
  }

  def extractPackageName(t: Term): List[String] = {
    t match {
      case Term.Select(qual, nm) => extractPackageName(qual) :+ nm.value
      case Term.Name(value)      => List(value)
    }
  }

  def isTopLevelObj(o: Defn.Object) = {
    o.mods
      .collectFirst { case Mod.Annot(Init(Type.Name(value), _, _)) =>
        value == "extern"
      }
      .contains(true)
  }

  def isExtern(init: Init) = {
    init.tpe == Type.Name("extern")
  }

  val ignore = Set(
    "posix.pthread.routine",
    "posix.sys.socketOps.WindowsLinger",
    "posix.sys.stat.off_t"
  )

  def allowed(t: Defn.Type) = {
    val names = Set(
      "CInt",
      "CLong",
      "CLongLong",
      "CSize",
      "CSSize",
      "CChar",
      "CShort",
      "UByte",
      "UInt",
      "UShort",
      "CStruct0",
      "CUnsignedInt",
      "CUnsignedLong",
      "CUnsignedLongInt",
      "CUnsignedLongLong",
      "CUnsignedShort",
      "ULong",
      "size_t",
      "size_t",
      "ssize_t"
    )
    t.body match {
      case Type.Name(v) if names(v)                              => true
      case Type.Apply(Type.Name("Ptr"), List(Type.Name("Byte"))) => true
      case Type.Apply(Type.Name(value), _) if value.startsWith("CStruct") =>
        true
      case Type.Apply(Type.Name(value), _) if value.startsWith("CFuncPtr") =>
        true
      case other =>
        println(s"[${t.name}] Ignoring ${t.body.structure}")
        false
    }
  }

  val scalaKeywords =
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

}
