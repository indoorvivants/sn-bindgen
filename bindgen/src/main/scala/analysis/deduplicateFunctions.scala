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
  info(s"Deduplicating ${res.size} functions")
  val toRemove = mutable.Set.empty[Def.Function]
  val vec = res.toArray.sortBy(_.name)

  vec.zipWithIndex.foreach { case (func, i) =>
    if (i != vec.length - 1) then
      val next = vec(i + 1)
      if next.name == func.name then
        if readabilityScore(func) < readabilityScore(next) then
          toRemove.add(func)
        else toRemove.add(next)
    end if
  }
  info(s"After deduplication ${toRemove.size} functions will be removed")

  mutable.Set.from(res) -- toRemove
end deduplicateFunctions
