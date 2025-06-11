package bindgen

import scala.annotation.tailrec

def referencedNames(typ: CType): Set[String] =
  import CType.*

  @tailrec
  def go(types: List[CType], acc: Set[String]): Set[String] =
    types match
      case ct :: rest =>
        val (next, names) =
          ct match
            case Reference(Name.Model(n, _)) => Nil -> Set(n)
            case Struct(fields, _)           => fields -> Set.empty
            case Union(fields, _)            => fields -> Set.empty
            case Function(retType, params)   =>
              (retType :: params.map(_.of)) -> Set.empty
            case Arr(of, _)  => List(of) -> Set.empty
            case Pointer(of) => List(of) -> Set.empty
            case _           =>
              Nil -> Set.empty
          end match
        end val

        go(next ++ rest, acc ++ names)
      case Nil => acc
  end go

  go(List(typ), Set.empty)
end referencedNames

def definitionClosure(_d: Def)(using Config): Set[String] =
  @tailrec
  def go(types: List[Def], acc: Set[String]): Set[String] =
    types match
      case b :: rest =>
        val (next, names) =
          b match
            case f: Def.Function =>
              Nil -> {
                Set(f.name.value) ++
                  referencedNames(f.returnType) ++
                  f.parameters.toSet.flatMap { p =>
                    referencedNames(p.typ) ++ referencedNames(p.originalTyp.typ)
                  }
              }

            case f: Def.Struct =>
              f.anonymous -> {
                Set(f.name.value) ++
                  f.fields
                    .map(_._2)
                    .toSet
                    .flatMap(referencedNames)
              }
            case f: Def.Union =>
              Nil -> {
                Set(f.name.value) ++ f.fields
                  .map(_._2)
                  .toSet
                  .flatMap(referencedNames)
              }
            case f: Def.Enum  => Nil -> f.name.toSet.map(_.value)
            case a: Def.Alias =>
              Nil -> (Set(a.name) ++ referencedNames(a.underlying))
          end match
        end val

        go(rest ++ next, names ++ acc)
      case _ => acc

  go(List(_d), Set.empty)
end definitionClosure

def computeClosure(named: Map[DefName, BindingDefinition])(using
    Config
): Set[String] =

  @tailrec
  def expand(visited: Set[String], result: Set[String]): Set[String] =
    val notVisited = result -- visited
    if notVisited.isEmpty then result
    else
      val grown = notVisited.flatMap { k =>
        DefTag.all.flatMap { tg =>
          named
            .get(DefName(k, tg))
            .map(n => definitionClosure(n.item))
            .getOrElse(Set.empty)
        }
      }
      expand(visited ++ notVisited, result ++ grown)
    end if
  end expand

  expand(
    Set.empty,
    named.filter(_._2.location.shouldBeIncluded).keySet.map(_.n)
  )
end computeClosure
