package bindgen
package rendering

import bindgen.*
import scala.collection.mutable.ListBuffer
import opaque_newtypes.given
import scala.collection.mutable

case class Constants(enums: Seq[Def.Enum])

opaque type StreamName = String
object StreamName extends opaque_newtypes.OpaqueString[StreamName]

enum RenderedOutput:
  case Single(lb: LineBuilder)
  case Multi(mp: Map[StreamName, LineBuilder])

def binding(
    binding: Binding,
    lang: Lang,
    mode: OutputMode
)(using
    Config
): RenderedOutput =
  val hasAnyEnums = binding.enums.nonEmpty
  val hasAliases = binding.aliases.nonEmpty
  val hasUnions = binding.unions.nonEmpty
  val hasStructs = binding.structs.nonEmpty
  val hasAnyTypes = hasAnyEnums || hasAliases || hasUnions || hasStructs

  def create(name: String) =
    val lb = LineBuilder()
    lb.appendLine(s"package $packageName")
    if mode.isInstanceOf[OutputMode.MultiFile] then
      lb.appendLine(s"package $name")
    lb.emptyLine
    lb.append("""
      |import _root_.scala.scalanative.unsafe.*
      |import _root_.scala.scalanative.unsigned.*
      |import _root_.scala.scalanative.libc.*
      |import _root_.scala.scalanative.*
      """.stripMargin.trim)
    lb.emptyLines(2)

    lb
  end create

  val scalaOutput = create("")
  val cOutput = LineBuilder()

  val multi =
    collection.mutable.Map.empty[StreamName, LineBuilder]

  val (stream, asObject): (String => LineBuilder, Boolean) = mode match
    case OutputMode.MultiFile(_) =>
      (
        (str: String) => multi.getOrElseUpdate(StreamName(str), create(str)),
        false
      )
    case _ =>
      ((_: String) => scalaOutput, true)

  given AliasResolver =
    AliasResolver.create(binding.all)

  renderEnumerations(
    stream("enumerations"),
    binding.enums.toList
      .sortBy(_.name)
      .filter(_.name.isDefined),
    asObject = asObject
  )

  renderAliases(
    binding.aliases.toList.sortBy(_.name),
    stream("aliases"),
    asObject = asObject
  )

  renderStructs(
    binding.structs.toList.sortBy(_.name),
    stream("structs"),
    asObject = asObject
  )

  renderUnions(
    binding.unions.toList.sortBy(_.name),
    stream("unions"),
    asObject = asObject
  )

  val resolvedFunctions: scala.collection.mutable.Set[GeneratedFunction] =
    deduplicateFunctions(binding.functions).flatMap(functionRewriter(_))

  renderScalaFunctions(
    stream("functions"),
    resolvedFunctions.toSet,
    asObject = asObject,
    hasAnyTypes = hasAnyTypes
  )

  val cFunctions = resolvedFunctions.collect {
    case f: GeneratedFunction.CFunction => f
  }

  if cFunctions.nonEmpty && lang == Lang.C then
    to(cOutput)("#include <string.h>")
    summon[Config].cImports.foreach { s =>
      to(cOutput)(s"#include \"$s\"")
    }
    cOutput.emptyLine

    renderAll(cFunctions.toList.sortBy(_.name), cOutput, cFunctionForwarder)

  end if

  renderConstants(
    stream("constants"),
    binding.unnamedEnums.toList,
    asObject = asObject
  )

  mode match
    case OutputMode.MultiFile(_) => RenderedOutput.Multi(multi.toMap)
    case _ =>
      if lang == Lang.C then RenderedOutput.Single(cOutput)
      else RenderedOutput.Single(scalaOutput)

end binding

private def commentException(element: Any, exc: Throwable) =
  val stackTrace =
    exc.getStackTrace.map("//    " + _.toString).mkString("\n")

  throw exc
end commentException

private def renderAliases(
    aliases: List[Def.Alias],
    out: LineBuilder,
    asObject: Boolean
)(using Config, AliasResolver) =
  if asObject && aliases.nonEmpty then out.appendLine("object aliases:")
  nestIf(asObject) {
    renderAll(aliases, out, alias)
  }
end renderAliases

private def renderUnions(
    unions: List[Def.Union],
    out: LineBuilder,
    asObject: Boolean
)(using Config, AliasResolver) =
  if asObject && unions.nonEmpty then out.appendLine("object unions:")
  nestIf(asObject) {
    renderAll(unions, out, union)
  }
end renderUnions

private def renderStructs(
    structs: List[Def.Struct],
    out: LineBuilder,
    asObject: Boolean
)(using Config, AliasResolver) =
  if asObject && structs.nonEmpty then out.appendLine("object structs:")
  nestIf(asObject) {
    renderAll(structs, out, struct)
  }
end renderStructs

private def renderConstants(
    out: LineBuilder,
    enums: List[Def.Enum],
    asObject: Boolean
)(using Config, AliasResolver) =
  if enums.nonEmpty then
    if asObject then to(out)("object constants:")
    nestIf(asObject) {
      constants(Constants(enums), to(out))
    }

private def renderAll[A <: (Def | GeneratedFunction)](
    defs: Seq[A],
    out: LineBuilder,
    how: (A, Appender) => Unit
)(using Config) =
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
    try
      how(
        en,
        to(out)
      )
      out.emptyLine
    catch exc => to(out)(commentException(en, exc))

  }

private def renderEnumerations(
    out: LineBuilder,
    enums: List[Def.Enum],
    asObject: Boolean
)(using
    Config,
    AliasResolver
) =
  val hasAnyEnums = enums.nonEmpty
  val hasUnsignedEnums =
    enums.exists(_.intType.exists(_.sign == SignType.Unsigned))
  val hasSignedEnums =
    enums.exists(en =>
      en.intType.exists(_.sign == SignType.Signed) || en.intType.isEmpty
    )
  if hasAnyEnums then
    if asObject then out.appendLine("object predef:")
    nestIf(asObject) {

      val predefSigned = s"""
        |private[$packageName] trait CEnum[T](using eq: T =:= Int):
        |  given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
        |  extension (inline t: T) 
        |    inline def int: CInt = eq.apply(t)
        |    inline def value: CInt = eq.apply(t)
       """.stripMargin.trim.linesIterator

      val predefUnsigned = s"""
        |private[$packageName] trait CEnumU[T](using eq: T =:= UInt):
        |  given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
        |  extension (inline t: T)
        |   inline def int: CInt = eq.apply(t).toInt
        |   inline def uint: CUnsignedInt = eq.apply(t)
        |   inline def value: CUnsignedInt = eq.apply(t)
        """.stripMargin.trim.linesIterator

      if (hasSignedEnums) then predefSigned.foreach(to(out))
      if (hasUnsignedEnums) then predefUnsigned.foreach(to(out))
    }
    if asObject then out.appendLine("\n\nobject enumerations:")
    nestIf(asObject) {
      if asObject then to(out)("import predef.*")
      renderAll(
        enums,
        out,
        enumeration
      )
    }
  end if
end renderEnumerations

private def renderScalaFunctions(
    out: LineBuilder,
    functions: Set[GeneratedFunction],
    asObject: Boolean,
    hasAnyTypes: Boolean
)(using Config, AliasResolver) =
  val scalaExternFunctions = functions.collect {
    case f: GeneratedFunction.ScalaFunction
        if f.body == ScalaFunctionBody.Extern =>
      f
  }

  val scalaRegularFunctions = functions.collect {
    case f: GeneratedFunction.ScalaFunction
        if !scalaExternFunctions.contains(f) =>
      f
  }

  val hasExternFunctions = scalaExternFunctions.nonEmpty
  val hasRegularFunctions = scalaRegularFunctions.nonEmpty

  if functions.nonEmpty then
    if hasExternFunctions then
      summon[Config].linkName.foreach { l =>
        out.append(s"""@link("$l")""")
      }
      out.appendLine(
        s"\n@extern\nprivate[$packageName] object extern_functions:"
      )
      nest {
        if hasAnyTypes && asObject then to(out)("import types.*")
        renderAll(
          scalaExternFunctions.toList.sortBy(_.name),
          out,
          renderFunction
        )
      }
    end if

    if hasRegularFunctions || hasExternFunctions then
      if asObject then out.appendLine(s"\nobject functions:")
      nestIf(asObject) {
        if hasAnyTypes && asObject then to(out)("import types.*")

        if hasExternFunctions then
          to(out)("import extern_functions.*")
          to(out)("export extern_functions.*")
          out.emptyLine

        renderAll(
          scalaRegularFunctions.toList.sortBy(_.name),
          out,
          renderFunction
        )
      }
    end if
  end if
end renderScalaFunctions
