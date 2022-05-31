package bindgen
package rendering

import bindgen.*
import scala.collection.mutable.ListBuffer

def binding(
    binding: Binding,
    scalaOutput: LineBuilder,
    cOutput: LineBuilder
)(using
    Config
) =
  scalaOutput.appendLine(s"package $packageName")
  scalaOutput.emptyLine
  scalaOutput.append("""
    |import scala.scalanative.unsafe.*
    |import scala.scalanative.unsigned.*
    |import scalanative.libc.*
    """.stripMargin.trim)
  scalaOutput.emptyLines(2)
  val hasUnsignedEnums =
    binding.enums.exists(_.intType.exists(_.sign == SignType.Unsigned))

  val hasSignedEnums =
    binding.enums.exists(en =>
      en.intType.exists(_.sign == SignType.Signed) || en.intType.isEmpty
    )

  val hasAnyEnums = binding.enums.nonEmpty
  val hasAliases = binding.aliases.nonEmpty
  val hasUnions = binding.unions.nonEmpty
  val hasStructs = binding.structs.nonEmpty
  val hasAnyTypes = hasAnyEnums || hasAliases || hasUnions || hasStructs

  if (hasAnyEnums) then
    scalaOutput.appendLine("object predef:")
    nest {

      val predefSigned = s"""
      |trait CEnum[T](using eq: T =:= Int):
      |  given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
      |  extension (t: T) def int: CInt = eq.apply(t)
     """.stripMargin.linesIterator

      val predefUnsigned = s"""
      |trait CEnumU[T](using eq: T =:= UInt):
      |  given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
      |  extension (t: T)
      |   def int: CInt = eq.apply(t).toInt
      |   def uint: CUnsignedInt = eq.apply(t)
      """.stripMargin.linesIterator

      if (hasSignedEnums) then predefSigned.foreach(to(scalaOutput))
      if (hasUnsignedEnums) then predefUnsigned.foreach(to(scalaOutput))

    }
  end if

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
  end imports

  given AliasResolver =
    AliasResolver.create(binding.all)

  def commentException(element: Any, exc: Throwable) =
    val stackTrace =
      exc.getStackTrace.map("//    " + _.toString).mkString("\n")

    throw exc
  end commentException

  if hasAnyTypes then scalaOutput.appendLine("object types:")

  def renderAll[A <: (Def | GeneratedFunction)](
      defs: Seq[A],
      out: LineBuilder,
      how: (A, Appender) => Unit
  ) =
    defs.zipWithIndex.foreach { case (en, idx) =>
      en match
        case df: Def =>
          df.defName.foreach { name =>
            trace(s"Rendering $name")
          }
        case sf: GeneratedFunction.ScalaFunction =>
          trace(s"Rendering Scala function '${sf.name}'")
        case sf: GeneratedFunction.CFunction =>
          trace(s"Rendering C function '${sf.name}'")
      try how(
        en,
        to(out)
      )
      catch exc => to(out)(commentException(en, exc))
      if idx != defs.size - 1 then out.emptyLine
    }

  nest {
    if hasAnyEnums then
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

  val hasExternFunctions = scalaExternFunctions.nonEmpty
  val hasRegularFunctions = scalaRegularFunctions.nonEmpty

  if binding.functions.nonEmpty then
    if hasExternFunctions then
      summon[Config].linkName.foreach { l =>
        scalaOutput.append(s"""@link("$l")""")
      }
      scalaOutput.appendLine(
        s"\n@extern\nprivate[$packageName] object extern_functions:"
      )
      nest {
        if (hasAnyTypes) then to(scalaOutput)("import types.*")
        renderAll(
          scalaExternFunctions.toList.sortBy(_.name),
          scalaOutput,
          function
        )
      }
    end if

    if hasRegularFunctions || hasExternFunctions then
      scalaOutput.appendLine(s"\nobject functions:")
      nest {
        if hasAnyTypes then to(scalaOutput)("import types.*")

        if hasExternFunctions then
          to(scalaOutput)("import extern_functions.*")
          to(scalaOutput)("export extern_functions.*")

        renderAll(
          scalaRegularFunctions.toList.sortBy(_.name),
          scalaOutput,
          function
        )
      }
    end if

    val cFunctions = resolvedFunctions.collect {
      case f: GeneratedFunction.CFunction => f
    }

    if cFunctions.nonEmpty then
      to(cOutput)("#include <string.h>")
      summon[Config].cImports.foreach { s =>
        to(cOutput)(s"#include \"$s\"")
      }
      cOutput.emptyLine

      renderAll(cFunctions.toList.sortBy(_.name), cOutput, cFunctionForwarder)

  end if
end binding
