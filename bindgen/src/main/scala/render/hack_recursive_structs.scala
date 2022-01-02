package bindgen.rendering

import bindgen.*

def deRecurse(struct: Def.Struct): (Def.Struct, Set[String]) =
  val structType = CType.Struct(struct.fields.map(_._2).toList)
  val structName = struct.name

  def referencesThis(typ: CType): Boolean =
    import CType.*
    typ match
      case Pointer(Typedef(`structName`))   => true
      case Pointer(RecordRef(`structName`)) => true
      case _                                => false

  def selfReferential(typ: CType): Boolean =
    import CType.*
    typ match
      case Typedef(`structName`)   => true
      case RecordRef(`structName`) => true
      case _                       => false

  val isPointerRecursive: Boolean =
    struct.fields.map(_._2).exists(referencesThis)

  val isRecursive = struct.fields.map(_._2).exists(selfReferential)

  if isRecursive then
    throw Error(
      s"struct '${struct.name}' is self-referential, and I don't know how to de-recurse it"
    )

  if !isPointerRecursive then (struct, Set.empty)
  else
    val rewrite = struct.fields.collect {
      case (name, typ) if referencesThis(typ) => name
    }

    val newfields = struct.fields.map {
      case (name, typ) if referencesThis(typ) =>
        name -> CType.Pointer(CType.Void)
      case other => other
    }

    struct.copy(newfields) -> rewrite.toSet

  end if
end deRecurse

