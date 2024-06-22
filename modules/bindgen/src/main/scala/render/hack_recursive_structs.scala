package bindgen.rendering

import bindgen.*
import scala.annotation.tailrec

def isCyclical(typ: CType, structName: StructName)(using
    AliasResolver,
    Config
): Option[List[String]] =
  def go(t: CType, visited: List[String], level: Int): Option[List[String]] =
    import CType.*
    t match
      case Reference(Name.Model(name, _)) =>
        Option.when(visited.contains(name))(visited ++ List(name)) orElse
          go(
            aliasResolver(name),
            visited ++ List(name),
            level + 1
          )

      case Struct(fields, _) =>
        if fields.size > 22 then
          Option.empty // implemented as CArray[Byte, ...] so cannot be self-referential
        else
          fields.foldLeft(Option.empty) { case (acc, field) =>
            acc orElse go(field, visited, level + 1)
          }

      case Pointer(Function(retType, params)) =>
        (retType +: params.map(_.of)).foldLeft(Option.empty) {
          case (acc, field) =>
            acc orElse go(field, visited, level + 1)
        }
      case Pointer(to) =>
        go(to, visited, level + 1)

      case Arr(of, _) =>
        go(of, visited, level + 1)

      case _ => Option.empty
    end match
  // trace((" " * level) + s"result of $t is '$result', visited: $visited")
  end go
  go(typ, List(structName.value), 0)
end isCyclical

case class ParameterRewrite(
    name: StructParameterName,
    originalType: CType,
    newRawType: CType,
    newRichType: CType
)

def hack_recursive_structs(
    struct: Def.Struct
)(using Config, AliasResolver): Map[Int, ParameterRewrite] =
  val structType: CType.Struct =
    CType.Struct(struct.fields.map(_._2).toList, Hints(struct.staticSize))
  val structName = struct.name

  val cyclicalParameters =
    struct.fields.map((_, typ) => isCyclical(typ, structName))

  val isPointerRecursive: Boolean = cyclicalParameters.exists(_.nonEmpty)

  def rewrite(
      parameterName: StructParameterName,
      originalType: CType
  ): Option[ParameterRewrite] =
    if isCyclical(originalType, structName).isEmpty then None
    else
      import CType.*
      def result(newType: CType) = Some(
        ParameterRewrite(
          name = parameterName,
          originalType = originalType,
          newRawType = Pointer(Void),
          newRichType = newType
        )
      )

      originalType match
        case a @ Pointer(func @ Function(retType, params)) =>
          def rewriteFunctionType(func: Function): Function =
            func.copy(
              returnType = func.returnType match
                case Pointer(of) if isCyclical(of, structName).nonEmpty =>
                  Pointer(Void)
                case funcP @ Pointer(f: Function)
                    if isCyclical(funcP, structName).nonEmpty =>
                  Pointer(rewriteFunctionType(f))
                case other => other
              ,
              parameters = func.parameters.map { p =>
                val newPType = p.of match
                  case Pointer(of) if isCyclical(of, structName).nonEmpty =>
                    Pointer(Void)
                  case funcP @ Pointer(f: Function)
                      if isCyclical(funcP, structName).nonEmpty =>
                    Pointer(rewriteFunctionType(f))
                  // case other if isCyclical(other, structName).nonEmpty =>
                  //   val cycle = isCyclical(other, structName)
                  //   throw Error(
                  //     s"Parameter: ${parameterName}, Type of function pointer is '$other' which we cannot rewrite to avoid cycles ($cycle)"
                  //   )
                  case other => other

                p.copy(of = newPType)
              }
            )

          Some(
            ParameterRewrite(
              name = parameterName,
              originalType = a,
              newRawType = rewriteFunctionType(func),
              newRichType = a
            )
          )

        case Pointer(to) =>
          Some(
            ParameterRewrite(
              name = parameterName,
              originalType = originalType,
              newRawType = Pointer(Void),
              newRichType = Pointer(to)
            )
          )
        case arr @ Arr(to, sz) =>
          Some(
            ParameterRewrite(
              name = parameterName,
              originalType = originalType,
              newRawType = Arr(Pointer(Void), sz),
              newRichType = arr
            )
          )

        case ref @ Reference(Name.Model(name, _)) =>
          aliasResolver(name) match
            case Pointer(_: Function) => result(ref)

            case other => None
      // throw Error(
      //   s"Expected '$name' to point to a function pointer, got $other instead"
      // )
      end match

    end if
  end rewrite

  if !isPointerRecursive then Map.empty
  else
    trace(s"Struct '$structName' was detected as having cycles")

    struct.fields.zipWithIndex.flatMap { case ((name, typ), idx) =>
      rewrite(name, typ).map { rule =>
        idx -> rule
      }
    }.toMap
  end if
end hack_recursive_structs
