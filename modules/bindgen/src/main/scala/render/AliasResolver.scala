package bindgen.rendering

import bindgen.*

opaque type AliasResolver = String => CType
object AliasResolver:
  extension (ar: AliasResolver) def apply(s: String) = ar(s)

  inline def apply(inline f: String => CType): AliasResolver = f

  def create(
      aliases: Seq[
        ResolvedStruct | ResolvedUnion | ResolvedEnum | Def.Alias | Def.Function
      ]
  )(using Config): AliasResolver =
    val mapping = Map.newBuilder[String, CType]
    def go(
        definitions: Seq[
          ResolvedStruct | ResolvedUnion | ResolvedEnum | Def.Alias |
            Def.Function
        ]
    ): Unit =
      definitions.foreach {
        case s: ResolvedStruct =>
          mapping += s.fqn.value -> s.typ
          go(s.anonymous)
        case s: ResolvedUnion =>
          mapping += s.fqn.value -> s.typ
          go(s.anonymous)
        case Def.Alias(name, underlying, _) =>
          mapping += name -> underlying
        case s: ResolvedEnum =>
          mapping += s.fqn.value -> s.typ
        case _ =>
      }

    go(aliases)

    trace("Aliases:", mapping.result().toSeq)

    val result = mapping.result()

    apply(s =>
      result
        .getOrElse(s, throw Error(s"Failed to resolve aliased definition $s"))
    )

  end create
end AliasResolver
