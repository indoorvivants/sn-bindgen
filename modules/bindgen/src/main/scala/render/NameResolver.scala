package bindgen
package rendering

def wrapPointer(depth: Int, tpe: CType): CType =
  if depth <= 0 then tpe
  else wrapPointer(depth - 1, CType.Pointer(tpe))

// TODO: This class is not implemented well – structs and unions are just similar enough to be handled generically,
// but different enough that it doesn't quite work.
// The proper solution (I think) is to create a `FieldBag` class that has a `layout: Struct | Union` field – and
// everything else should just depend on the layout.
object NameResolver:
  private def renderName(prepend: Vector[String], name: String) =
    (prepend :+ name).mkString("_")

  private def goStruct(
      str: Def.Struct,
      prepend: Vector[String],
      namer: AnonymousNameGenerator
  )(using Config): ResolvedStruct =
    val newAnon = List.newBuilder[ResolvedStruct | ResolvedUnion | ResolvedEnum]

    def handleAnon(
        nameHint: Option[String],
        unsafeId: Int,
        idx: Int,
        pointerDepth: Int
    ) =
      str.anonymous(unsafeId) match
        case e: Def.Enum =>
          val anonEnumName = namer.genEnumName(nameHint)
          val name = renderName(prepend, anonEnumName.value)
          val resolved = ResolvedEnum(
            e.values,
            name = EnumName(name),
            fqn = EnumName(name),
            intType = e.intType,
            meta = e.meta
          )
          newAnon += resolved
          val fieldName = nameHint.getOrElse("_" + idx.toString())
          Some(
            StructParameterName(fieldName) -> CType.Reference(
              Name.Model(resolved.fqn.value)
            )
          )
        case s: Def.Struct =>
          val anonStructName = namer.genStructName(nameHint)
          val name = renderName(prepend, anonStructName.value)
          val resolved =
            goStruct(
              s.copy(name = Some(StructName(name))),
              prepend :+ anonStructName.value,
              AnonymousNameGenerator()
            )
          newAnon += resolved
          val fieldName = nameHint.getOrElse("_" + idx.toString())
          Some(
            StructParameterName(fieldName) -> wrapPointer(
              pointerDepth,
              CType.Reference(
                Name.Model(name)
              )
            )
          )

        case u: Def.Union =>
          val anonUnionName = namer.genUnionName(nameHint)
          val name = renderName(prepend, anonUnionName.value)
          // val name = namer.genUnionName(nameHint)
          val resolved =
            goUnion(
              u.copy(name = Some(UnionName(name))),
              prepend :+ anonUnionName.value,
              AnonymousNameGenerator()
            )
          newAnon += resolved
          val fieldName = nameHint.getOrElse("_" + idx)
          Some(
            StructParameterName(fieldName) -> wrapPointer(
              pointerDepth,
              CType.Reference(
                Name.Model(name)
              )
            )
          )
    end handleAnon

    val newFields = str.fields.zipWithIndex
      .map((f, i) => (f, i + 1))
      .flatMap:
        case (FieldSpec.Known(name, tpe), _) =>
          Some(StructParameterName(name) -> tpe)

        case (FieldSpec.Anon(nameHint, unsafeId, pointerDepth), idx) =>
          handleAnon(nameHint, unsafeId, idx, pointerDepth)

        case (FieldSpec.AnonArray(nameHint, size, unsafeId), idx) =>
          val anon = handleAnon(nameHint, unsafeId, idx, pointerDepth = 0)
          anon.map: (fs, ct) =>
            fs -> CType.Arr(ct, Some(size))

    val structName = str.name.getOrElse(namer.genStructName(None)).value
    ResolvedStruct(
      name = StructName(structName),
      fqn = StructName(
        if prepend.isEmpty then structName else prepend.mkString("_")
      ),
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
      prepend: Vector[String],
      namer: AnonymousNameGenerator
  )(using Config): ResolvedUnion =
    val newAnon = List.newBuilder[ResolvedStruct | ResolvedUnion | ResolvedEnum]

    def handleAnon(nameHint: Option[String], unsafeId: Int, idx: Int) =
      str.anonymous(unsafeId) match
        case e: Def.Enum =>
          val anonEnumName = namer.genEnumName(nameHint)
          val name = renderName(prepend, anonEnumName.value)
          val resolved = ResolvedEnum(
            e.values,
            name = EnumName(name),
            fqn = EnumName(name),
            intType = e.intType,
            meta = e.meta
          )
          newAnon += resolved
          val fieldName = nameHint.getOrElse("_" + idx.toString())
          Some(
            UnionParameterName(fieldName) -> CType.Reference(
              Name.Model(resolved.fqn.value)
            )
          )
        case s: Def.Struct =>
          val anonStructName = namer.genStructName(nameHint)
          val name = renderName(prepend, anonStructName.value)

          val resolved =
            goStruct(
              s.copy(name = Some(StructName(name))),
              prepend :+ anonStructName.value,
              AnonymousNameGenerator()
            )
          newAnon += resolved
          val fieldName = nameHint.getOrElse("_" + idx.toString())
          Some(
            UnionParameterName(fieldName) -> CType.Reference(
              Name.Model(name)
            )
          )

        case u: Def.Union =>
          val anonUnionName = namer.genUnionName(nameHint)
          val name = renderName(prepend, anonUnionName.value)
          // val name = namer.genUnionName(nameHint)
          val resolved =
            goUnion(
              u.copy(name = Some(UnionName(name))),
              prepend :+ anonUnionName.value,
              AnonymousNameGenerator()
            )
          newAnon += resolved
          val fieldName = nameHint
            .getOrElse("_" + idx)
          Some(
            UnionParameterName(fieldName) -> CType.Reference(
              Name.Model(name)
            )
          )
    end handleAnon

    val newFields = str.fields.zipWithIndex
      .map((f, i) => (f, i + 1))
      .flatMap:
        case (FieldSpec.Known(name, tpe), _) =>
          Some(UnionParameterName(name) -> tpe)

        case (FieldSpec.Anon(nameHint, unsafeId, pointerDepth), idx) =>
          handleAnon(nameHint, unsafeId, idx)

        case (FieldSpec.AnonArray(nameHint, size, unsafeId), idx) =>
          val anon = handleAnon(nameHint, unsafeId, idx)
          anon.map: (fs, ct) =>
            fs -> CType.Arr(ct, Some(size))

    val nm =
      str.name.getOrElse(namer.genUnionName(None))

    ResolvedUnion(
      name = nm,
      fields = newFields,
      fqn =
        if prepend.isEmpty then nm
        else UnionName(prepend.mkString("_")),
      anonymous = newAnon.result.toVector,
      staticSize = str.staticSize,
      // deepFields =
      //   List.empty, // str.deepFields.map(go(_, prepend + ".", namer)),
      meta = str.meta
    )
  end goUnion

  def resolveStruct(s: Def.Struct)(using Config): ResolvedStruct =
    val resolved =
      goStruct(s, s.name.toVector.map(_.value), AnonymousNameGenerator())
    trace(
      "Resolved struct",
      Seq(
        "raw" -> pprint(s),
        "resolved" -> pprint(resolved)
      )
    )

    resolved
  end resolveStruct

  def resolveUnion(s: Def.Union)(using Config): ResolvedUnion =
    goUnion(s, s.name.toVector.map(_.value), AnonymousNameGenerator())

  def resolveEnum(s: Def.Enum): ResolvedEnum =
    // goUnion(s, s.name.toVector.map(_.value), createNamer)
    ResolvedEnum(
      values = s.values,
      name = s.name.getOrElse(
        sys.error("Consistency error - unnamed unions should not be resolved")
      ),
      fqn = s.name.get,
      intType = s.intType,
      meta = s.meta
    )

end NameResolver
