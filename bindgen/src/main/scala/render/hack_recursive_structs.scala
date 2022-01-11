package bindgen.rendering

import bindgen.*

def isCyclical(typ: CType, name: String)(using AliasResolver, Config): Boolean =
  def go(t: CType, visited: Set[String], level: Int): Boolean =
    import CType.*
    trace((" " * level) + s"visiting $t with $visited")
    val result =
      t match
        case Typedef(name) =>
          visited.contains(name) || go(
            aliasResolver(name),
            visited ++ Set(name),
            level + 1
          )
        case Pointer(Typedef(name)) =>
          visited.contains(name) || go(
            aliasResolver(name),
            visited ++ Set(name),
            level + 1
          )

        case Pointer(RecordRef(name)) =>
          visited.contains(name) || go(
            aliasResolver(name),
            visited ++ Set(name),
            level + 1
          )

        case Struct(fields) =>
          if fields.size > 22 then
            false // implemented as CArray[Byte, ...] so cannot be self-referential
          else
            fields.foldLeft(false) { case (acc, field) =>
              acc || go(field, visited, level + 1)
            }

        case Pointer(Function(retType, params)) =>
          (retType +: params.map(_.of)).foldLeft(false) { case (acc, field) =>
            acc || go(field, visited, level + 1)
          }
        case _ => false
      end match
    end result

    trace((" " * level) + s"result of $t is '$result', visited: $visited")
    result
  end go
  go(typ, Set(name), 0)
end isCyclical

case class ParameterRewrite(
    name: String,
    originalType: CType,
    newRawType: CType,
    newRichType: CType
)

def hack_recursive_structs(
    struct: Def.Struct
)(using Config, AliasResolver): Map[Int, ParameterRewrite] =
  val structType: CType.Struct = CType.Struct(struct.fields.map(_._2).toList)
  val structName = struct.name

  val cyclicalParameters =
    struct.fields.map((_, typ) => isCyclical(typ, structName))

  val isPointerRecursive: Boolean = cyclicalParameters.exists(_ == true)

  def rewrite(name: String, originalType: CType): Option[ParameterRewrite] =
    if !isCyclical(originalType, structName) then None
    else
      import CType.*
      def result(newType: CType) = Some(
        ParameterRewrite(
          name = name,
          originalType = originalType,
          newRawType = Pointer(Void),
          newRichType = newType
        )
      )

      originalType match
        case Pointer(Typedef(name))   => result(Pointer(Typedef(name)))
        case Pointer(RecordRef(name)) => result(Pointer(RecordRef(name)))
        case Typedef(name) =>
          aliasResolver(name) match
            case Pointer(_: Function) => result(Typedef(name))
            case other =>
              throw Error(
                s"Expected '$name' to point to a function pointer, got $other instead"
              )
      end match

    end if
  end rewrite

  if !isPointerRecursive then Map.empty
  else
    info(s"Struct '$structName' was detected as having cycles")

    struct.fields.zipWithIndex.flatMap { case ((name, typ), idx) =>
      rewrite(name, typ).map { rule =>
        idx -> rule
      }
    }.toMap
  end if
end hack_recursive_structs
