package bindgen.rendering

import bindgen.*
import scala.collection.mutable.ListBuffer

def binding(
    binding: Def.Binding,
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

  given aliasResolver: AliasResolver =
    s =>
      val alias = binding.aliases.find(_.name == s).map(_.underlying)
      val struct = binding.structs
        .find(_.name == s)
        .map(_.fields.map(_._2).toList)
        .map(CType.Struct.apply)
      val union = binding.unions
        .find(_.name == s)
        .map(_.fields.map(_._2).toList)
        .map(CType.Union.apply)
      val _enum = binding.enums.find(_.name.contains(s)).flatMap(_._3)

      alias.orElse(struct).orElse(_enum).orElse(union) match
        case Some(resolved) => resolved
        case None => throw error(s"Failed to resolve aliased definition $s")

  def commentException(element: Any, exc: Throwable) =
    val stackTrace =
      exc.getStackTrace.map("//    " + _.toString).mkString("\n")
    s"""
    |// Failed to render:
    |//  $element
    |// Error:
    |//  $exc
    |$stackTrace\n
    """.stripMargin
  end commentException

  scalaOutput.append("object types:\n")
  nest {
    to(scalaOutput)("import predef.*")
    binding.enums.toList
      .sortBy(_.name)
      .filter(_.name.isDefined)
      .zipWithIndex
      .foreach { case (en, idx) =>
        try enumeration(
          en,
          to(scalaOutput)
        )
        catch exc => to(scalaOutput)(commentException(en, exc))
        if idx != binding.enums.size - 1 then scalaOutput.append("\n")
      }
    binding.aliases.toList.sortBy(_.name).zipWithIndex.foreach {
      case (en, idx) =>
        try alias(
          en,
          to(scalaOutput)
        )
        catch exc => to(scalaOutput)(commentException(en, exc))
        if idx != binding.aliases.size - 1 then scalaOutput.append("\n")
    }
    binding.structs.toList.sortBy(_.name).zipWithIndex.foreach {
      case (en, idx) =>
        try struct(
          en,
          to(scalaOutput)
        )
        catch exc => to(scalaOutput)(commentException(en, exc))
        if idx != binding.structs.size - 1 then scalaOutput.append("\n")
    }
    binding.unions.toList.sortBy(_.name).zipWithIndex.foreach {
      case (en, idx) =>
        try union(
          en,
          to(scalaOutput)
        )
        catch exc => to(scalaOutput)(commentException(en, exc))
        if idx != binding.unions.size - 1 then scalaOutput.append("\n")
    }
  }

  val resolvedFunctions = binding.functions.flatMap(functionRewriter)

  val externFunctions = resolvedFunctions.collect {
    case f @ Def.Function(_, _, _, CFunctionType.Extern, _)          => f
    case f @ Def.Function(_, _, _, _: CFunctionType.ExternRename, _) => f
  }

  val regularFunctions = resolvedFunctions.filterNot(externFunctions.contains)

  if binding.functions.nonEmpty then
    summon[Config].linkName.foreach { l =>
      scalaOutput.append(s"""@link("$l")""")
    }
    scalaOutput.append(
      s"\n@extern\nprivate[$packageName] object extern_functions: \n"
    )
    nest {
      to(scalaOutput)("import types.*\n")
      externFunctions.toList.sortBy(_.name).zipWithIndex.foreach {
        case (func, idx) =>
          try function(
            func,
            to(scalaOutput)
          )
          catch exc => to(scalaOutput)(commentException(func, exc))
          if idx != externFunctions.size - 1 then scalaOutput.append("\n")
      }
    }
    scalaOutput.append(s"\nobject functions: \n")
    nest {
      to(scalaOutput)("import types.*, extern_functions.*\n")
      to(scalaOutput)("export extern_functions.*\n")
      regularFunctions.toList.sortBy(_.name).zipWithIndex.foreach {
        case (func, idx) =>
          try function(
            func,
            to(scalaOutput)
          )
          catch exc => to(scalaOutput)(commentException(func, exc))
          if idx != regularFunctions.size - 1 then scalaOutput.append("\n")
      }
    }

    val cFunctions =
      externFunctions
        .filter(_.tpe.isInstanceOf[CFunctionType.ExternRename])

    if cFunctions.nonEmpty then
      to(cOutput)("#include <string.h>")
      summon[Config].cImports.foreach { s =>
        to(cOutput)(s"#include <$s>")
      }
      to(cOutput)("\n")

    cFunctions.toList.sortBy(_.name).zipWithIndex.foreach { case (func, idx) =>
      try cFunctionForwarder(
        func,
        to(cOutput)
      )
      catch exc => to(cOutput)(commentException(func, exc))
      if idx != cFunctions.size - 1 then scalaOutput.append("\n")
    }

  end if
end binding
