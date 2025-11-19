package bindgen
package rendering

object NameResolver:
  private def goStruct(
      str: Def.Struct,
      prepend: String,
      namer: Namer
  ): ResolvedStruct =
    val newAnon = List.newBuilder[ResolvedStruct | ResolvedUnion | Def.Enum]

    val newFields = str.fields.flatMap:
      case FieldSpec.Known(name, tpe) =>
        Some(StructParameterName(name) -> tpe)
      case FieldSpec.Anon(nameHint, unsafeId) =>
        str.anonymous(unsafeId) match
          case e: Def.Enum =>
            val resolved = e.copy(name = Some(namer.genEnumName(nameHint)))
            newAnon += resolved
            None
          case s: Def.Struct =>
            val name = namer.genStructName(nameHint)
            val resolved =
              goStruct(
                s.copy(name = Some(name)),
                prepend + name.value + ".",
                createNamer
              )
            newAnon += resolved
            nameHint.map(n =>
              StructParameterName(n) -> CType.Reference(
                Name.Model(prepend + name.value)
              )
            )

          case u: Def.Union =>
            val name = namer.genUnionName(nameHint)
            val resolved =
              goUnion(
                u.copy(name = Some(name)),
                prepend + name.value + ".",
                createNamer
              )
            newAnon += resolved
            nameHint.map(n =>
              StructParameterName(n) -> CType.Reference(
                Name.Model(prepend + name.value)
              )
            )

    ResolvedStruct(
      name = namer.genStructName(str.name.map(_.value)),
      fields = newFields,
      anonymous = newAnon.result.toVector,
      staticSize = str.staticSize,
      deepFields =
        List.empty, // str.deepFields.map(go(_, prepend + ".", namer)),
      meta = str.meta
    )
  end goStruct

  private def goUnion(
      str: Def.Union,
      prepend: String,
      namer: Namer
  ): ResolvedUnion =
    val newAnon = List.newBuilder[ResolvedStruct | ResolvedUnion | Def.Enum]

    val newFields = str.fields.flatMap:
      case FieldSpec.Known(name, tpe) =>
        Some(UnionParameterName(name) -> tpe)
      case FieldSpec.Anon(nameHint, unsafeId) =>
        str.anonymous(unsafeId) match
          case e: Def.Enum =>
            val resolved = e.copy(name = Some(namer.genEnumName(nameHint)))
            newAnon += resolved
            None
          case s: Def.Struct =>
            val name = namer.genStructName(nameHint)
            val resolved =
              goStruct(
                s.copy(name = Some(name)),
                prepend + name.value + ".",
                createNamer
              )
            newAnon += resolved
            nameHint.map(n =>
              UnionParameterName(n) -> CType.Reference(
                Name.Model(prepend + name.value)
              )
            )

          case u: Def.Union =>
            val name = namer.genUnionName(nameHint)
            val resolved =
              goUnion(
                u.copy(name = Some(name)),
                prepend + name.value + ".",
                createNamer
              )
            newAnon += resolved
            nameHint.map(n =>
              UnionParameterName(n) -> CType.Reference(
                Name.Model(prepend + name.value)
              )
            )

    ResolvedUnion(
      name = namer.genUnionName(str.name.map(_.value)),
      fields = newFields,
      anonymous = newAnon.result.toVector,
      staticSize = str.staticSize,
      // deepFields =
      //   List.empty, // str.deepFields.map(go(_, prepend + ".", namer)),
      meta = str.meta
    )
  end goUnion

  def resolveStruct(s: Def.Struct): ResolvedStruct =
    goStruct(s, "", createNamer)

  def resolveUnion(s: Def.Union): ResolvedUnion =
    goUnion(s, "", createNamer)

  type Namer =
    (
        genStructName: Option[String] => StructName,
        genUnionName: Option[String] => UnionName,
        genEnumName: Option[String] => EnumName
    )

  def createNamer: Namer =
    var unions = 0
    var structs = 0
    var enums = 0
    (
      genStructName = (hint: Option[String]) =>
        StructName(
          hint
            .map(_.capitalize)
            .getOrElse({
              val res = s"Struct$structs"
              structs += 1
              res
            })
        ),
      genUnionName = (hint: Option[String]) =>
        UnionName(
          hint
            .map(_.capitalize)
            .getOrElse({
              val res = s"Union$unions"
              unions += 1
              res
            })
        ),
      genEnumName = (hint: Option[String]) =>
        EnumName(
          hint
            .map(_.capitalize)
            .getOrElse({
              val res = s"Enum$enums"
              enums += 1
              res
            })
        )
    )
  end createNamer
end NameResolver
