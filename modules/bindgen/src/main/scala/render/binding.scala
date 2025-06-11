package bindgen
package rendering

import bindgen.*
import opaque_newtypes.given

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
        filename
          .flatMap(f => config.rendering.matchesPackage(_.externalPaths)(f))
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
    case e: Def.Enum  => true
    case d: Def.Union =>
      d.anonymous.exists(hasEnum)
    case d: Def.Struct =>
      d.anonymous.exists(hasEnum)

def renderBinding(
    rawBinding: Binding,
    outputMode: OutputMode
)(using
    Context,
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

  if summon[Context].lang == Lang.Scala then

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
          out = simpleStream("functions"),
          functions = resolvedFunctions.toSet,
          renderMode = renderMode,
          hasAnyTypes = hasAnyTypes,
          typeImports = typeImports,
          exportMode = exportMode
        )
      )
    end if
  end if

  val cFunctions = resolvedFunctions.collect {
    case f: GeneratedFunction.CFunction => f
  }

  if cFunctions.nonEmpty && summon[Context].lang == Lang.C then
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
    objectBlock(l)("object types") {
      val l = to(simpleStream("types"))
      if hasStructs then l(s"export _root_.${packageName}.structs.*")
      if hasAliases then l(s"export _root_.${packageName}.aliases.*")
      if hasUnions then l(s"export _root_.${packageName}.unions.*")
      if hasAnyEnums then l(s"export _root_.${packageName}.enumerations.*")
    }
  end if

  if !multiFileMode then
    renderExports(simpleStream(s"all"), exports.result(), renderMode)

  if multiFileMode then RenderedOutput.Multi(multi.toMap)
  else if summon[Context].lang == Lang.C then RenderedOutput.Single(cOutput)
  else RenderedOutput.Single(scalaOutput)
end renderBinding

private def commentException(element: Any, exc: Throwable) =
  val stackTrace =
    exc.getStackTrace.map("//    " + _.toString).mkString("\n")

  throw exc
end commentException

//wraps a block in the supplied object/class/trait if the render mode is such
private def maybeObjectBlock(out: LineBuilder, mode: RenderMode)(
    objectHeader: String
)(
    f: Config ?=> Unit
)(using Config) =
  lazy val openDelimiter: String =
    if summon[Config].useBraces.value then " {" else ":"
  lazy val closeDelimiter: Option[String] =
    if summon[Config].useBraces.value then Some("}") else None

  if mode == RenderMode.Objects then to(out)(s"$objectHeader$openDelimiter")
  nestIf(mode == RenderMode.Objects) {
    f
  }
  if mode == RenderMode.Objects then closeDelimiter.foreach(to(out))
end maybeObjectBlock

private def renderAliases(
    aliases: List[Def.Alias],
    out: LineBuilder,
    mode: RenderMode,
    typeImports: TypeImports
)(using Config, AliasResolver, Context) =
  val exported = List.newBuilder[Exported]
  maybeObjectBlock(out, mode)("object aliases") {
    if mode == RenderMode.Objects then typeImports.render(out)
    exported ++= renderAll(aliases, out, alias)
  }
  exported.result()
end renderAliases

private def renderExports(
    out: LineBuilder,
    exports: List[(String, String)],
    mode: RenderMode
)(using Config, Context) =
  mode match
    case RenderMode.Objects =>
      if exports.nonEmpty then
        out.emptyLine
        maybeObjectBlock(out, mode)("object all") {
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
)(using Config, AliasResolver, Context) =
  val exported = List.newBuilder[Exported]
  maybeObjectBlock(out, mode)("object unions") {
    if mode == RenderMode.Objects then typeImports.render(out)
    exported ++= renderAll(unions, out, union)
  }
  exported.result()
end renderUnions

private def renderStructs(
    structs: List[Def.Struct],
    out: LineBuilder,
    mode: RenderMode,
    typeImports: TypeImports
)(using Config, AliasResolver, Context) =
  val exported = List.newBuilder[Exported]
  maybeObjectBlock(out, mode)("object structs") {
    if mode == RenderMode.Objects then typeImports.render(out)
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
    maybeObjectBlock(out, mode)("object constants") {
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

private[bindgen] def enumBaseTraitName(
    intType: CType.NumericIntegral
)(using AliasResolver, Config) =
  val tpe = scalaNumericType(intType)
  s"_BindgenEnum$tpe"

private def enumPredef(
    safePackageName: String,
    base: Option[CType.NumericIntegral]
)(using AliasResolver, Config) =
  val intType: CType.NumericIntegral =
    base.getOrElse(CType.NumericIntegral(IntegralBase.Int, SignType.Signed))
  val renderedScalaType = scalaType(intType)
  val renderedTagName =
    val prefix = intType.sign match
      case SignType.Signed   => ""
      case SignType.Unsigned => "U"

    val bs = intType.base match
      case IntegralBase.Char     => "Byte"
      case IntegralBase.Short    => "Short"
      case IntegralBase.Int      => "Int"
      case IntegralBase.Long     => "Long"
      case IntegralBase.LongLong => "Long"

    prefix + bs
  end renderedTagName

  val lb = LineBuilder()

  val traitName = enumBaseTraitName(intType)

  objectBlock(to(lb))(
    s"private[${safePackageName}] trait $traitName[T](using eq: T =:= $renderedScalaType)"
  ) {
    to(lb)(s"given Tag[T] = Tag.$renderedTagName.asInstanceOf[Tag[T]]")
    defBlock(to(lb))("extension (inline t: T)") {
      to(lb)(s"inline def value: $renderedScalaType = eq.apply(t)")
      if intType.base == IntegralBase.Int then
        to(lb)(s"inline def int: CInt = eq.apply(t).toInt")
      if intType.sign == SignType.Unsigned then
        to(lb)(s"inline def uint: CUnsignedInt = eq.apply(t)")
    }
  }
  lb.result.linesIterator.toList
end enumPredef

private def renderEnumerations(
    out: LineBuilder,
    enums: List[Def.Enum],
    mode: RenderMode
)(using
    Config,
    AliasResolver,
    Context
) =
  val enumBases = enums.map(_.intType).distinct.sorted

  val exported = List.newBuilder[Exported]

  if enumBases.nonEmpty then
    maybeObjectBlock(out, mode)("object predef") {
      val safePackageName = packageName.split('.').last
      enumBases.foreach: base =>
        enumPredef(safePackageName, base).foreach(to(out))
    }
    if mode == RenderMode.Objects then out.emptyLine
    maybeObjectBlock(out, mode)("object enumerations") {
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

private val functionSorter = (f: GeneratedFunction.ScalaFunction) =>
  val body =
    f.body match
      case ScalaFunctionBody.Extern                    => 1
      case ScalaFunctionBody.Delegate(to, allocations) => 2
      case ScalaFunctionBody.Export(loc)               => 3

  f.name -> body

private def renderScalaFunctions(
    out: LineBuilder,
    functions: Set[GeneratedFunction],
    renderMode: RenderMode,
    hasAnyTypes: Boolean,
    typeImports: TypeImports,
    exportMode: ExportMode
)(using Config, AliasResolver, Context) =
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

  val safePackageName = packageName.split('.').last

  val hasExternFunctions = scalaExternFunctions.nonEmpty
  val hasRegularFunctions = scalaRegularFunctions.nonEmpty

  if functions.nonEmpty then
    if exportMode == ExportMode.No then

      if hasExternFunctions then
        val objectHeader = summon[Config].linkName
          .map { l =>
            s"""@link("$l")\n"""
          }
          .getOrElse("") +
          s"\n@extern\nprivate[$safePackageName] object extern_functions"
        maybeObjectBlock(out, renderMode)(objectHeader) {
          if renderMode == RenderMode.Objects then typeImports.render(out)
          exported ++= renderAll(
            scalaExternFunctions.toList.sortBy(functionSorter),
            out,
            renderFunction(_, _, renderMode)
          )
        }
      end if

      if hasRegularFunctions || hasExternFunctions then
        maybeObjectBlock(out, renderMode)(s"\nobject functions") {
          if renderMode == RenderMode.Objects then typeImports.render(out)

          if hasExternFunctions && renderMode == RenderMode.Objects then
            to(out)("import extern_functions.*")
            to(out)("export extern_functions.*")
            out.emptyLine

          exported ++= renderAll(
            scalaRegularFunctions.toList.sortBy(functionSorter),
            out,
            renderFunction(_, _, renderMode)
          )
        }
      end if
    else
      def modified(loc: ExportLocation) =
        scalaExternFunctions.toList
          .sortBy(functionSorter)
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

      val line = to(out)

      objectBlock(line)("trait ExportedFunctions") {
        if renderMode == RenderMode.Objects then typeImports.render(out)
        renderAll(
          modified(ExportLocation.Trait),
          out,
          renderFunction(_, _, renderMode)
        )
      }

      maybeObjectBlock(out, renderMode)(
        s"\nobject functions extends ExportedFunctions"
      ) {
        if renderMode == RenderMode.Objects then typeImports.render(out)
        renderAll(
          modified(
            ExportLocation.Body(summon[Context].packageName.map(_ + ".impl"))
          ),
          out,
          renderFunction(_, _, renderMode)
        )
      }
    end if
  end if
  exported.result()
end renderScalaFunctions
