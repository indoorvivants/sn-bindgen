package bindgen
package rendering

class SingleFileRender(rawBinding: Binding) extends RenderingBase:
  def render()(using Config, Context) =
    val info = BindingInfo(rawBinding)

    given AliasResolver = info.aliasResolver

    val exports = List.newBuilder[(String, String)]

    def updateExports(location: String, names: Seq[Exported]) =
      exports ++= names.collect { case Exported.Yes(v) => v }.map(location -> _)

    if summon[Context].lang == Lang.Scala then
      val out = createScalaStream
      if info.hasAnyEnums then
        renderEnumPredef(out, info.enumBases)
        out.emptyLine

        updateExports(
          "enumerations",
          renderEnums(out, info.resolvedEnums.sortBy(_.name.value))
        )
        out.emptyLine

      if info.hasStructs then
        updateExports(
          "structs",
          renderStructs(
            out,
            info.resolvedStructs.sortBy(_.name.value),
            info.typeImports
          )
        )
        out.emptyLine
      end if

      if info.hasUnions then
        updateExports(
          "unions",
          renderUnions(
            out,
            info.resolvedUnions.sortBy(_.name.value),
            info.typeImports
          )
        )
        out.emptyLine
      end if

      if info.hasConstants then
        updateExports(
          "constants",
          renderConstants(
            out,
            info.binding.unnamedEnums.toList.sortBy(_.meta.file.map(_.value)),
            info.binding.macros
          )
        )
        out.emptyLine
      end if

      if info.hasAliases then
        updateExports(
          "aliases",
          renderAliases(
            out,
            info.aliases,
            info.typeImports
          )
        )
        out.emptyLine
      end if

      if info.resolvedFunctions.exists(
          _.isInstanceOf[GeneratedFunction.ScalaFunction]
        )
      then
        updateExports(
          "functions",
          ScalaFunctionsRenderer(
            out = out,
            functions = info.resolvedFunctions.toSet,
            renderMode = RenderMode.Objects,
            typeImports = info.typeImports,
            exportMode = info.exportMode
          ).render()
        )

        out.emptyLine
      end if

      if info.hasAnyTypes then
        val l = to(out)
        objectBlock(l)("object types") {
          nest {
            val l = to(out)
            if info.hasStructs then l(s"export _root_.${packageName}.structs.*")
            if info.hasAliases then l(s"export _root_.${packageName}.aliases.*")
            if info.hasUnions then l(s"export _root_.${packageName}.unions.*")
            if info.hasAnyTopLevelEnums then
              l(s"export _root_.${packageName}.enumerations.*")
          }
        }
        out.emptyLine
      end if

      val allExports = exports.result()
      if allExports.nonEmpty then renderExports(out, allExports)
      RenderedOutput.Single(out)
    else
      if info.cFunctions.nonEmpty then
        val out = createCStream
        renderCFunctionForwards(
          out,
          cFunctions = info.cFunctions.toList.sortBy(_.name.value)
        )
        RenderedOutput.Single(out)
      else RenderedOutput.Single(LineBuilder())
      end if

    end if

  end render

  private def renderCFunctionForwards(
      out: LineBuilder,
      cFunctions: Seq[GeneratedFunction.CFunction]
  )(using Config, AliasResolver) =
    to(out)("#include <string.h>")
    summon[Config].cImports.foreach { s =>
      to(out)(s"#include \"$s\"")
    }
    out.emptyLine

    interspeseWithNewlines(
      out,
      cFunctions.toList
        .sortBy(_.name.value)
    ): cf =>
      cFunctionForwarder(cf, to(out))
  end renderCFunctionForwards

  private def renderEnums(
      out: LineBuilder,
      enums: Seq[ResolvedEnum]
  )(using Config, AliasResolver) =
    val enumBases = enums.map(_.intType).distinct.sorted

    val exported = List.newBuilder[Exported]

    if enumBases.nonEmpty then
      maybeObjectBlock(out, RenderMode.Objects)("object enumerations"):
        to(out)("import predef.*")

        exported ++= interspeseWithNewlines(out, enums): resolvedEnum =>
          EnumRenderer(resolvedEnum, to(out)).render()
    end if
    exported.result()
  end renderEnums

  private def renderStructs(
      out: LineBuilder,
      structs: Seq[ResolvedStruct],
      typeImports: TypeImports
  )(using Config, AliasResolver, Context) =
    val exported = List.newBuilder[Exported]
    maybeObjectBlock(out, RenderMode.Objects)("object structs") {
      typeImports.render(out)
      out.emptyLine
      interspeseWithNewlines(
        out,
        structs
          .sortBy(_.name.value)
      ): struct =>
        exported += StructRenderer(struct, to(out)).render()
    }
    exported.result()
  end renderStructs

  private def renderUnions(
      out: LineBuilder,
      unions: Seq[ResolvedUnion],
      typeImports: TypeImports
  )(using Config, AliasResolver, Context) =
    val exported = List.newBuilder[Exported]
    maybeObjectBlock(out, RenderMode.Objects)("object unions") {
      typeImports.render(out)
      out.emptyLine
      exported ++= interspeseWithNewlines(
        out,
        unions
          .sortBy(_.name.value)
      ): union =>
        UnionRenderer(union, to(out)).render()
    }
    exported.result()
  end renderUnions

  private def renderConstants(
      out: LineBuilder,
      enums: List[Def.Enum],
      macros: List[MacroDefinition]
  )(using Config, AliasResolver) =
    val exported = List.newBuilder[Exported]
    if enums.nonEmpty || macros.nonEmpty then
      maybeObjectBlock(out, RenderMode.Objects)("object constants") {
        exported ++= constants(Constants(enums, macros), to(out))
      }

    exported.result()
  end renderConstants

  private def renderEnumPredef(
      out: LineBuilder,
      enumBases: Set[Option[CType.NumericIntegral]]
  )(using
      Config,
      AliasResolver,
      Context
  ) =
    maybeObjectBlock(out, RenderMode.Objects)("object predef"):
      interspeseWithNewlines(out, enumBases.toList.sorted): base =>
        val rend = EnumPredefRenderer(base)
        rend.render(out)

  private def renderAliases(
      out: LineBuilder,
      aliases: List[Def.Alias],
      typeImports: TypeImports
  )(using Config, AliasResolver, Context) =
    val exported = List.newBuilder[Exported]
    maybeObjectBlock(out, RenderMode.Objects)("object aliases"):
      typeImports.render(out)

      exported ++= interspeseWithNewlines(out, aliases): alias =>
        AliasRender(alias, to(out)).render()

    exported.result()
  end renderAliases

  private def renderExports(
      out: LineBuilder,
      exports: List[(String, String)]
  )(using Config, Context) =
    if exports.nonEmpty then
      maybeObjectBlock(out, RenderMode.Objects)("object all") {
        exports.distinct.foreach { (scope, name) =>
          to(out)(s"export _root_.$packageName.$scope.$name")
        }
      }

  end renderExports

end SingleFileRender
