package bindgen
package rendering

def wrapPointer(depth: Int, tpe: CType): CType =
  if depth <= 0 then tpe
  else wrapPointer(depth - 1, CType.Pointer(tpe))

object NameResolver:
  private def goStruct(
      str: Def.Struct,
      prepend: Vector[String],
      namer: Namer
  ): ResolvedStruct =
    val newAnon = List.newBuilder[ResolvedStruct | ResolvedUnion | ResolvedEnum]

    def handleAnon(
        nameHint: Option[String],
        unsafeId: Int,
        idx: Int,
        pointerDepth: Int
    ) =
      str.anonymous(unsafeId) match
        case e: Def.Enum =>
          val name = namer.genEnumName(nameHint)
          val resolved = ResolvedEnum(
            e.values,
            name = name,
            fqn = EnumName((prepend :+ name.value).mkString(".")),
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
          val name = namer.genStructName(nameHint)
          val resolved =
            goStruct(
              s.copy(name = Some(name)),
              prepend :+ name.value,
              createNamer
            )
          newAnon += resolved
          val fieldName = nameHint.getOrElse("_" + idx.toString())
          Some(
            StructParameterName(fieldName) -> wrapPointer(
              pointerDepth,
              CType.Reference(
                Name.Model((prepend :+ name.value).mkString("."))
              )
            )
          )

        case u: Def.Union =>
          val name = namer.genUnionName(nameHint)
          val resolved =
            goUnion(
              u.copy(name = Some(name)),
              prepend :+ name.value,
              createNamer
            )
          newAnon += resolved
          val fieldName = nameHint
            .getOrElse("_" + idx)
          Some(
            StructParameterName(fieldName) -> wrapPointer(
              pointerDepth,
              CType.Reference(
                Name.Model((prepend :+ name.value).mkString("."))
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

    val nm =
      str.name.getOrElse(namer.genStructName(None))
    ResolvedStruct(
      name = nm,
      fqn = if prepend.isEmpty then nm else StructName(prepend.mkString(".")),
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
      namer: Namer
  ): ResolvedUnion =
    val newAnon = List.newBuilder[ResolvedStruct | ResolvedUnion | ResolvedEnum]

    def handleAnon(nameHint: Option[String], unsafeId: Int, idx: Int) =
      str.anonymous(unsafeId) match
        case e: Def.Enum =>
          val name = namer.genEnumName(nameHint)
          val resolved = ResolvedEnum(
            e.values,
            name = name,
            fqn = EnumName((prepend :+ name.value).mkString(".")),
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
          val name = namer.genStructName(nameHint)
          val resolved =
            goStruct(
              s.copy(name = Some(name)),
              prepend :+ name.value,
              createNamer
            )
          newAnon += resolved
          val fieldName = nameHint.getOrElse("_" + idx.toString())
          Some(
            UnionParameterName(fieldName) -> CType.Reference(
              Name.Model((prepend :+ name.value).mkString("."))
            )
          )

        case u: Def.Union =>
          val name = namer.genUnionName(nameHint)
          val resolved =
            goUnion(
              u.copy(name = Some(name)),
              prepend :+ name.value,
              createNamer
            )
          newAnon += resolved
          val fieldName = nameHint
            .getOrElse("_" + idx)
          Some(
            UnionParameterName(fieldName) -> CType.Reference(
              Name.Model((prepend :+ name.value).mkString("."))
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
        else UnionName(prepend.mkString(".")),
      anonymous = newAnon.result.toVector,
      staticSize = str.staticSize,
      // deepFields =
      //   List.empty, // str.deepFields.map(go(_, prepend + ".", namer)),
      meta = str.meta
    )
  end goUnion

  def resolveStruct(s: Def.Struct): ResolvedStruct =
    goStruct(s, s.name.toVector.map(_.value), createNamer)

  def resolveUnion(s: Def.Union): ResolvedUnion =
    goUnion(s, s.name.toVector.map(_.value), createNamer)

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
