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

enum Exported:
  case No
  case Yes(as: String)

enum RenderMode:
  case Objects, Files

def shouldRender(definition: Def)(using config: Config) =
  definition.defName
    .map(_.n)
    .flatMap { n =>
      val filename = definition.metadata.file.map(_.value)

      val fileMatches =
        filename.flatMap(f =>
          config.rendering.matchesPackage(_.externalPaths)(f)
        )
      val nameMatches =
        config.rendering.matchesPackage(_.externalNames)(n)

      fileMatches.map((filterSpec, pkg) =>
        trace(
          s"Definition `$n` was not rendered because it matched path " +
            s"filter `$filterSpec`, and will be referenced instead from `$pkg` package"
        )
      ) orElse
        nameMatches.map((filterSpec, pkg) =>
          trace(
            s"Definition `$n` was not rendered because its name matched" +
              s"filter `$filterSpec`, and will be referenced instead from `$pkg` package"
          )
        )
    }
    .isEmpty

def hasEnum(st: Def.Union | Def.Struct | Def.Enum): Boolean =
  st match
    case e: Def.Enum => true
    case d: Def.Union =>
      d.anonymous.exists(hasEnum)
    case d: Def.Struct =>
      d.anonymous.exists(hasEnum)

def renderBinding(
    rawBinding: Binding,
    lang: Lang,
    outputMode: OutputMode
)(using
    Config
): RenderedOutput =
  val binding = rawBinding.filterAll(shouldRender)

  val hasAnyEnums = binding.enums.nonEmpty || binding.unions.exists(
    hasEnum
  ) || binding.structs.exists(hasEnum)
  val hasAliases = binding.aliases.nonEmpty
  val hasUnions = binding.unions.nonEmpty
  val hasStructs = binding.structs.nonEmpty
  val hasConstants = binding.unnamedEnums.nonEmpty
  val hasAnyTypes = hasAnyEnums || hasAliases || hasUnions || hasStructs
  val typeImports = TypeImports(
    enums = hasAnyEnums,
    aliases = hasAliases,
    structs = hasStructs,
    unions = hasUnions
  )

  val multiFileMode = outputMode match
    case _: OutputMode.MultiFile => true
    case _                       => false

  val exportMode = summon[Config].exportMode

  given AliasResolver =
    AliasResolver.create(rawBinding.all)

  val resolvedFunctions: scala.collection.mutable.Set[GeneratedFunction] =
    deduplicateFunctions(binding.functions).flatMap(functionRewriter(_))

  def create(name: String)(subPackage: String = name) =
    val lb = LineBuilder()
    lb.appendLine(s"package $packageName")
    if multiFileMode then lb.appendLine(s"package $subPackage")
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

  val scalaOutput = create("")()
  val cOutput = LineBuilder()

  val exports = List.newBuilder[(String, String)]

  val multi =
    collection.mutable.Map.empty[StreamName, LineBuilder]

  val (stream, renderMode): ((String, String) => LineBuilder, RenderMode) =
    if multiFileMode then
      (
        (str: String, packageName: String) =>
          multi.getOrElseUpdate(StreamName(str), create(str)(packageName)),
        RenderMode.Files
      )
    else ((_: String, _: String) => scalaOutput, RenderMode.Objects)

  val simpleStream = (name: String) => stream(name, name)

  def updateExports(location: String, names: Seq[Exported]) =
    exports ++= names.collect { case Exported.Yes(v) => v }.map(location -> _)

  if lang == Lang.Scala then

    if hasAnyEnums then
      updateExports(
        "enumerations",
        renderEnumerations(
          simpleStream("enumerations"),
          binding.enums.toList
            .sortBy(_.name)
            .filter(_.name.isDefined),
          mode = renderMode
        )
      )
    end if

    if hasAliases then
      updateExports(
        "aliases",
        renderAliases(
          binding.aliases.toList.sortBy(_.name),
          simpleStream("aliases"),
          mode = renderMode,
          typeImports
        )
      )
    end if

    if hasStructs then
      updateExports(
        "structs",
        renderStructs(
          binding.structs.toList.sortBy(_.name),
          simpleStream("structs"),
          mode = renderMode,
          typeImports
        )
      )
    end if

    if hasUnions then
      updateExports(
        "unions",
        renderUnions(
          binding.unions.toList.sortBy(_.name),
          simpleStream("unions"),
          mode = renderMode,
          typeImports
        )
      )
    end if

    if resolvedFunctions.exists(_.isInstanceOf[GeneratedFunction.ScalaFunction])
    then
      updateExports(
        "functions",
        renderScalaFunctions(
          simpleStream("functions"),
          resolvedFunctions.toSet,
          renderMode = renderMode,
          hasAnyTypes = hasAnyTypes,
          typeImports,
          exportMode = exportMode
        )
      )
    end if
  end if

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

  if hasConstants then
    renderConstants(
      simpleStream("constants"),
      binding.unnamedEnums.toList,
      mode = renderMode
    )

  if !multiFileMode && hasAnyTypes then
    val l = to(simpleStream("types"))
    l("object types:")
    nest {
      val l = to(simpleStream("types"))
      if hasStructs then l(s"export _root_.${packageName}.structs.*")
      if hasAliases then l(s"export _root_.${packageName}.aliases.*")
      if hasUnions then l(s"export _root_.${packageName}.unions.*")
      if hasAnyEnums then l(s"export _root_.${packageName}.enumerations.*")
    }
  end if

  if multiFileMode then
    val byType: Map[String, List[(String, String)]] =
      exports.result().groupBy(_._1)

    byType.toList.sortBy(_._1).foreach { (exportType, results) =>
      renderExports(stream(s"all.$exportType", "all"), results, renderMode)
    }
  else renderExports(simpleStream(s"all"), exports.result(), renderMode)

  if multiFileMode then RenderedOutput.Multi(multi.toMap)
  else if lang == Lang.C then RenderedOutput.Single(cOutput)
  else RenderedOutput.Single(scalaOutput)
end renderBinding

private def commentException(element: Any, exc: Throwable) =
  val stackTrace =
    exc.getStackTrace.map("//    " + _.toString).mkString("\n")

  throw exc
end commentException

private def renderAliases(
    aliases: List[Def.Alias],
    out: LineBuilder,
    mode: RenderMode,
    typeImports: TypeImports
)(using Config, AliasResolver) =
  val exported = List.newBuilder[Exported]
  if mode == RenderMode.Files then typeImports.render(out, multiFile = true)
  if mode == RenderMode.Objects then out.appendLine("object aliases:")

  nestIf(mode == RenderMode.Objects) {
    if mode == RenderMode.Objects then
      typeImports.render(out, multiFile = false)
    exported ++= renderAll(aliases, out, alias)
  }
  exported.result()
end renderAliases

private def renderExports(
    out: LineBuilder,
    exports: List[(String, String)],
    mode: RenderMode
)(using Config) =
  mode match
    case RenderMode.Objects =>
      if exports.nonEmpty then
        out.emptyLine
        to(out)("object all:")
        nest {
          exports.distinct.foreach { (scope, name) =>
            to(out)(s"export _root_.$packageName.$scope.$name")
          }
        }
    case RenderMode.Files =>
      exports.distinct.foreach { (scope, name) =>
        to(out)(s"export _root_.$packageName.$scope.$name")
      }

end renderExports

private def renderUnions(
    unions: List[Def.Union],
    out: LineBuilder,
    mode: RenderMode,
    typeImports: TypeImports
)(using Config, AliasResolver) =
  val exported = List.newBuilder[Exported]
  if mode == RenderMode.Files then typeImports.render(out, multiFile = true)
  if mode == RenderMode.Objects then out.appendLine("object unions:")
  nestIf(mode == RenderMode.Objects) {
    if mode == RenderMode.Objects then
      typeImports.render(out, multiFile = false)
    exported ++= renderAll(unions, out, union)
  }
  exported.result()
end renderUnions

private def renderStructs(
    structs: List[Def.Struct],
    out: LineBuilder,
    mode: RenderMode,
    typeImports: TypeImports
)(using Config, AliasResolver) =
  val exported = List.newBuilder[Exported]
  if mode == RenderMode.Files then typeImports.render(out, multiFile = true)
  if mode == RenderMode.Objects then out.appendLine("object structs:")

  nestIf(mode == RenderMode.Objects) {
    if mode == RenderMode.Objects then
      typeImports.render(out, multiFile = false)
    exported ++= renderAll(structs, out, struct)
  }
  exported.result()
end renderStructs

private def renderConstants(
    out: LineBuilder,
    enums: List[Def.Enum],
    mode: RenderMode
)(using Config, AliasResolver) =
  if enums.nonEmpty then
    if mode == RenderMode.Objects then to(out)("object constants:")
    nestIf(mode == RenderMode.Objects) {
      constants(Constants(enums), to(out))
    }

private def renderAll[A <: (Def | GeneratedFunction)](
    defs: Seq[A],
    out: LineBuilder,
    how: (A, Appender) => Exported | Unit
)(using Config): Seq[Exported] =
  val exported = List.newBuilder[Exported]
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
      ) match
        case ()              =>
        case other: Exported => exported.addOne(other)

      out.emptyLine

    catch exc => to(out)(commentException(en, exc))
    end try

  }
  exported.result
end renderAll

private def renderEnumerations(
    out: LineBuilder,
    enums: List[Def.Enum],
    mode: RenderMode
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

  val exported = List.newBuilder[Exported]

  if hasAnyEnums then
    if mode == RenderMode.Objects then out.appendLine("object predef:")
    nestIf(mode == RenderMode.Objects) {

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

      if hasSignedEnums then predefSigned.foreach(to(out))
      if hasUnsignedEnums then predefUnsigned.foreach(to(out))
    }
    if mode == RenderMode.Objects then
      out.appendLine("\n\nobject enumerations:")
    nestIf(mode == RenderMode.Objects) {
      if mode == RenderMode.Objects then to(out)("import predef.*")
      exported ++= renderAll(
        enums,
        out,
        enumeration
      )
    }
  end if
  exported.result()
end renderEnumerations

private def renderScalaFunctions(
    out: LineBuilder,
    functions: Set[GeneratedFunction],
    renderMode: RenderMode,
    hasAnyTypes: Boolean,
    typeImports: TypeImports,
    exportMode: ExportMode
)(using Config, AliasResolver) =
  val exported = List.newBuilder[Exported]
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
    if exportMode == ExportMode.No then
      if renderMode == RenderMode.Files then
        typeImports.render(out, multiFile = true)

      if hasExternFunctions then
        summon[Config].linkName.foreach { l =>
          out.append(s"""@link("$l")""")
        }
        out.appendLine(
          s"\n@extern\nprivate[$packageName] object extern_functions:"
        )
        nest {
          if renderMode == RenderMode.Objects then
            typeImports.render(out, multiFile = false)
          exported ++= renderAll(
            scalaExternFunctions.toList.sortBy(_.name),
            out,
            renderFunction
          )
        }
      end if

      if hasRegularFunctions || hasExternFunctions then
        if renderMode == RenderMode.Objects then
          out.appendLine(s"\nobject functions:")
        nestIf(renderMode == RenderMode.Objects) {
          if renderMode == RenderMode.Objects then
            typeImports.render(out, multiFile = false)

          if hasExternFunctions then
            to(out)("import extern_functions.*")
            to(out)("export extern_functions.*")
            out.emptyLine

          exported ++= renderAll(
            scalaRegularFunctions.toList.sortBy(_.name),
            out,
            renderFunction
          )
        }
      end if
    else
      def modified(loc: ExportLocation) =
        scalaExternFunctions.toList
          .sortBy(_.name)
          .map { sf =>
            sf.copy(body = ScalaFunctionBody.Export(loc))
          }
          .filter { sf =>
            val isInit =
              sf.name.value == "ScalaNativeInit" && sf.returnType == CType.Int && sf.arguments.flatten.isEmpty

            if isInit then
              info(
                "ScalaNativeInit function found in the bindings, not rendering it"
              )

            !isInit
          }

      out.appendLine("trait ExportedFunctions:")
      nest {
        if renderMode == RenderMode.Objects then
          typeImports.render(out, multiFile = false)
        renderAll(modified(ExportLocation.Trait), out, renderFunction)
      }

      if renderMode == RenderMode.Objects then
        out.appendLine(s"\nobject functions extends ExportedFunctions:")
      nestIf(renderMode == RenderMode.Objects) {
        if renderMode == RenderMode.Objects then
          typeImports.render(out, multiFile = false)
        renderAll(
          modified(
            ExportLocation.Body(summon[Config].packageName.map(_ + ".impl"))
          ),
          out,
          renderFunction
        )
      }

    end if
  end if
  exported.result()
end renderScalaFunctions
