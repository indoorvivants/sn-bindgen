package bindgen
package rendering

import bindgen.*
import scala.collection.mutable.ListBuffer

def binding(
    binding: Binding,
    scalaOutput: StringBuilder,
    cOutput: StringBuilder
)(using
    Config
) =
  scalaOutput.append(s"package $packageName\n\n")
  scalaOutput.append("""
    |import scala.scalanative.unsafe.*
    |import scala.scalanative.unsigned.*
    |import scalanative.libc.*
    """.stripMargin.trim)
  scalaOutput.append("\n\n")
  scalaOutput.append("object predef:")
  nest {
    val predef = """
    |abstract class CEnum[T](using eq: T =:= Int):
    |  given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
    |  extension (t: T) def int: CInt = eq.apply(t)
    |
    |abstract class CEnumU[T](using eq: T =:= UInt):
    |  given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
    |  extension (t: T)
    |   def int: CInt = eq.apply(t).toInt
    |   def uint: CUnsignedInt = eq.apply(t)
    """.stripMargin.linesIterator
    predef.foreach(to(scalaOutput))
  }

  type Scope = "predef" | "aliases" | "enumerations" | "structs" | "functions"
  def define(s: Scope) = s"object $s"
  def imports(scopes: Scope*) =
    val filtered = scopes.filter {
      case "aliases"      => binding.aliases.nonEmpty
      case "enumerations" => binding.enums.nonEmpty
      case "structs"      => binding.structs.nonEmpty
      case "functions"    => binding.functions.nonEmpty
      case _              => true
    }
    s"import ${filtered.map { sc => sc + ".*" }.mkString(", ")}"

  given AliasResolver =
    AliasResolver.create(binding.named.values.toSeq.map(_.item))

  def commentException(element: Any, exc: Throwable) =
    val stackTrace =
      exc.getStackTrace.map("//    " + _.toString).mkString("\n")

    throw exc
  end commentException

  scalaOutput.append("object types:\n")
  def renderAll[A <: (Def | GeneratedFunction)](
      defs: Seq[A],
      out: StringBuilder,
      how: (A, Appender) => Unit
  ) =
    defs.zipWithIndex.foreach { case (en, idx) =>
      try how(
        en,
        to(out)
      )
      catch exc => to(out)(commentException(en, exc))
      if idx != defs.size - 1 then out.append("\n")
    }

  nest {
    to(scalaOutput)("import predef.*")
    renderAll(
      binding.enums.toList
        .sortBy(_.name)
        .filter(_.name.isDefined),
      scalaOutput,
      enumeration
    )
    renderAll(binding.aliases.toList.sortBy(_.name), scalaOutput, alias)
    renderAll(binding.structs.toList.sortBy(_.name), scalaOutput, struct)
    renderAll(binding.unions.toList.sortBy(_.name), scalaOutput, union)
  }

  val resolvedFunctions =
    deduplicateFunctions(binding.functions).flatMap(functionRewriter(_))

  val scalaExternFunctions = resolvedFunctions.collect {
    case f: GeneratedFunction.ScalaFunction
        if f.body == ScalaFunctionBody.Extern =>
      f
  }

  val scalaRegularFunctions = resolvedFunctions.collect {
    case f: GeneratedFunction.ScalaFunction
        if !scalaExternFunctions.contains(f) =>
      f
  }

  if binding.functions.nonEmpty then
    summon[Config].linkName.foreach { l =>
      scalaOutput.append(s"""@link("$l")""")
    }
    scalaOutput.append(
      s"\n@extern\nprivate[$packageName] object extern_functions: \n"
    )
    nest {
      to(scalaOutput)("import types.*\n")
      renderAll(
        scalaExternFunctions.toList.sortBy(_.name),
        scalaOutput,
        function
      )
    }
    scalaOutput.append(s"\nobject functions: \n")
    nest {
      to(scalaOutput)("import types.*, extern_functions.*\n")
      to(scalaOutput)("export extern_functions.*\n")
      renderAll(
        scalaRegularFunctions.toList.sortBy(_.name),
        scalaOutput,
        function
      )
    }

    val cFunctions = resolvedFunctions.collect {
      case f: GeneratedFunction.CFunction => f
    }

    if cFunctions.nonEmpty then
      to(cOutput)("#include <string.h>")
      summon[Config].cImports.foreach { s =>
        to(cOutput)(s"#include \"$s\"")
      }
      to(cOutput)("\n")

      renderAll(cFunctions.toList.sortBy(_.name), cOutput, cFunctionForwarder)

  end if
end binding
