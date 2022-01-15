package bindgen

import scala.scalanative.libc.stdio.FILE

def definitionClosure(b: Def)(using Config): Set[String] =
  def ref(ct: CType): Set[String] =
    import CType.*
    ct match
      case Reference(Name.Model(n)) => Set(n)
      case Struct(fields)           => fields.toSet.flatMap(ref)
      case Union(fields)            => fields.toSet.flatMap(ref)
      case Function(retType, params) =>
        ref(retType) ++ params.toSet.map(_.of).flatMap(ref)
      case Arr(of, _)  => ref(of)
      case Pointer(of) => ref(of)
      case _ =>
        Set.empty
    end match
  end ref

  b match
    case f: Def.Function =>
      Set(f.name) ++
        ref(f.returnType) ++
        f.parameters.toSet.flatMap { p =>
          ref(p.typ) ++ ref(p.originalTyp.typ)
        }
    case f: Def.Struct =>
      Set(f.name) ++
        f.fields
          .map(_._2)
          .toSet
          .flatMap(ref) ++
        f.anonymous.toSet.flatMap(definitionClosure)
    case f: Def.Union => Set(f.name) ++ f.fields.map(_._2).toSet.flatMap(ref)
    case f: Def.Enum  => f.name.toSet
    case a: Def.Alias => Set(a.name) ++ ref(a.underlying)
  end match
end definitionClosure

def computeClosure(named: Map[String, BindingDefinition])(using
    Config
): Set[String] =
  import scala.collection.mutable

  def expand(visited: Set[String], result: Set[String]): Set[String] =
    val notVisited = result -- visited
    trace(s"Closure computer: visited = $visited, result = $result")
    if notVisited.isEmpty then result
    else
      val grown = notVisited.flatMap(k =>
        named.get(k).map(n => definitionClosure(n.item)).getOrElse(Set.empty)
      )
      trace(s"Closure computer: grown = $grown")
      if (grown -- result).nonEmpty then
        expand(visited ++ notVisited, result ++ grown)
      else result
    end if
  end expand

  expand(Set.empty, named.filter(_._2.isFromMainFile).keySet)
end computeClosure
