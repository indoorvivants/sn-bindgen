package bindgen
import scala.collection.mutable

private def functionsAreSame(a: Def.Function, b: Def.Function): Boolean =
  if a.name == b.name then
    val aParams = a.parameters.map(_.typ)
    val bParams = b.parameters.map(_.typ)

    aParams == bParams
  else false

private def readabilityScore(func: Def.Function): Int =
  func.parameters.count(!_.generatedName)

def deduplicateFunctions(res: mutable.Set[Def.Function])(using
    Config
): mutable.Set[Def.Function] =
  val toRemove = mutable.Set.empty[Def.Function]
  val vec = res.toVector

  info(s"Deduplication ${vec.size} functions")

  vec.foreach { funcA =>
    vec.foreach { funcB =>
      if funcA != funcB && functionsAreSame(funcA, funcB) then
        if readabilityScore(funcA) < readabilityScore(funcB) then
          toRemove.add(funcA)
        else toRemove.add(funcB)
    }
  }

  mutable.Set.from(res) -- toRemove
end deduplicateFunctions
