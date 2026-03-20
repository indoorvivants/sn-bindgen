package bindgen
package rendering

class MultiFileRender(rawBinding: Binding) extends RenderingBase:
  def render()(using Config, Context) =
    val info = BindingInfo(rawBinding)

    val multi =
      collection.mutable.Map.empty[StreamName, LineBuilder]

    def stream(name: String) =
      multi.getOrElseUpdate(StreamName(name), createScalaStream)

    given AliasResolver = info.aliasResolver

    renderEnums(name => stream(s"enums/$name"), info.resolvedEnums)
    renderStructs(name => stream(s"structs/$name"), info.resolvedStructs)
    renderUnions(name => stream(s"unions/$name"), info.resolvedUnions)
    if info.hasConstants then
      renderConstants(
        stream(s"constants"),
        info.binding.unnamedEnums.toList.sortBy(_.meta.file.map(_.value)),
        info.binding.macros
      )
    if info.hasAnyEnums then
      renderEnumPredef(name => stream(s"enums/$name"), info.enumBases)
    renderAliases(info.aliases, name => stream(s"aliases/$name"))

    if info.resolvedFunctions.nonEmpty then
      ScalaFunctionsRenderer(
        out = stream("functions"),
        functions = info.resolvedFunctions.toSet,
        renderMode = RenderMode.Files,
        typeImports = info.typeImports,
        exportMode = info.exportMode
      ).render()

    RenderedOutput.Multi(multi.toMap)
  end render

  private def renderEnums(
      stream: String => LineBuilder,
      enums: Iterable[ResolvedEnum]
  )(using Config, AliasResolver) =
    enums.foreach: resolvedEnum =>
      val out = stream(resolvedEnum.name.value)
      EnumRenderer(resolvedEnum, to(out)).render()

  private def renderStructs(
      stream: String => LineBuilder,
      structs: Iterable[ResolvedStruct]
  )(using Config, AliasResolver, Context) =
    structs.foreach: struct =>
      val out = stream(struct.name.value)
      StructRenderer(struct, to(out)).render()

  private def renderUnions(
      stream: String => LineBuilder,
      unions: Iterable[ResolvedUnion]
  )(using Config, AliasResolver, Context) =
    unions.foreach: union =>
      val out = stream(union.name.value)
      UnionRenderer(union, to(out)).render()

  private def renderConstants(
      out: LineBuilder,
      enums: List[Def.Enum],
      macros: List[MacroDefinition]
  )(using Config, AliasResolver) =
    constants(Constants(enums, macros), to(out))

  end renderConstants

  private def renderEnumPredef(
      out: String => LineBuilder,
      enumBases: Set[Option[CType.NumericIntegral]]
  )(using
      Config,
      AliasResolver,
      Context
  ) =
    enumBases.foreach: base =>
      val rend = EnumPredefRenderer(base)
      val stream = out(rend.traitName)

      rend.render(stream)

  private def renderAliases(
      aliases: List[Def.Alias],
      out: String => LineBuilder
  )(using Config, AliasResolver, Context) =
    aliases.foreach: alias =>
      AliasRender(alias, to(out(alias.name))).render()
  end renderAliases

end MultiFileRender
