package bindgen
package rendering

class BindingInfo(rawBinding: Binding)(using Config, Context):
  private def shouldRender(definition: Def)(using config: Config) =
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

  val binding = rawBinding.filterAll(shouldRender)

  // In order
  def anonymousEnumBases(struct: Def.Struct | Def.Union | Def.Enum) =
    @annotation.tailrec
    def go(
        ls: List[Def.Struct | Def.Union | Def.Enum],
        acc: Set[Option[CType.NumericIntegral]]
    ): Set[Option[CType.NumericIntegral]] =
      ls match
        case Nil                   => acc
        case (e: Def.Enum) :: rest => go(rest, acc + e.intType)
        case (u: Def.Union) :: rest =>
          go(u.anonymous ++ rest, acc)
        case (u: Def.Struct) :: rest =>
          go(u.anonymous ++ rest, acc)

    go(List(struct), Set.empty)
  end anonymousEnumBases

  val enumBases =
    binding.structs.flatMap(anonymousEnumBases) ++
      binding.unions.flatMap(anonymousEnumBases) ++
      binding.enums.flatMap(anonymousEnumBases)

  val hasAnyEnums = enumBases.nonEmpty
  val hasAnyTopLevelEnums = binding.enums.nonEmpty
  val hasAliases = binding.aliases.nonEmpty
  val hasUnions = binding.unions.nonEmpty
  val hasStructs = binding.structs.nonEmpty
  val hasConstants = binding.unnamedEnums.nonEmpty || binding.macros.nonEmpty
  val hasAnyTypes = hasAnyEnums || hasAliases || hasUnions || hasStructs
  val typeImports = TypeImports(
    // We only need type imports for top level enums
    anonEnums = hasAnyEnums && !hasAnyTopLevelEnums,
    enums = hasAnyTopLevelEnums,
    aliases = hasAliases,
    structs = hasStructs,
    unions = hasUnions
  )

  val exportMode = summon[Config].exportMode

  val all = rawBinding.resolve

  val aliasResolver =
    AliasResolver.create(all)

  val resolvedFunctions: scala.collection.mutable.Set[GeneratedFunction] =
    deduplicateFunctions(binding.functions).flatMap(
      functionRewriter(_)(using aliasResolver)
    )

  val cFunctions = resolvedFunctions.collect {
    case f: GeneratedFunction.CFunction => f
  }

  val resolvedStructs = all.collect { case rs: ResolvedStruct => rs }
  val resolvedUnions = all.collect { case rs: ResolvedUnion => rs }
  val resolvedEnums = all.collect { case rs: ResolvedEnum => rs }
  val aliases = binding.aliases.toList.sortBy(_.name)

end BindingInfo
