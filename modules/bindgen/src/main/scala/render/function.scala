package bindgen
package rendering

import bindgen.*
import scala.collection.mutable.ListBuffer

def renderFunction(f: GeneratedFunction.ScalaFunction, line: Appender)(using
    Config,
    AliasResolver
) =
  val arglist = f.arguments
    .map { args =>
      args
        .map(fp => s"${escape(fp.name)} : ${scalaType(fp.typ)}")
        .mkString(", ")
    }
    .mkString("(", ")(", ")")

  val flatArguments = f.arguments.flatten

  val access =
    if f.public then "" else s"private[${summon[Config].packageName.value}] "

  f.body match
    case ScalaFunctionBody.Extern =>
      line(
        s"${access}def ${f.name}$arglist: ${scalaType(f.returnType)} = extern"
      )
    case ScalaFunctionBody.Delegate(
          to,
          a @ Allocations(indices, returnAsWell)
        ) =>
      val hasZone = if a.hasAny then "(using Zone)" else ""
      line(
        s"def ${f.name}$arglist$hasZone: ${scalaType(f.returnType)} = "
      )
      nest {
        import scala.collection.mutable.Map as MutableMap

        val allocationSizes: CType MutableMap Int =
          MutableMap.from(
            indices
              .map(flatArguments.apply)
              .groupBy(_.typ)
              .map((tpe, params) => tpe -> params.size)
          )

        if returnAsWell then
          allocationSizes.update(
            f.returnType,
            allocationSizes.getOrElse(f.returnType, 0) + 1
          )

        val typeIndices = allocationSizes.keys.toList.zipWithIndex.toMap

        val locations: Map[Int, String] =
          val usedAllocations: MutableMap[CType, Int] =
            allocationSizes.map((ct, _) => ct -> 0)

          val params = indices.toList.sorted.map { i =>
            val argType = flatArguments(i).typ
            val block = s"__ptr_${typeIndices(argType)}"
            val locationInBlock = usedAllocations(argType)
            usedAllocations.update(argType, locationInBlock + 1)

            i -> s"($block + $locationInBlock)"
          }.toMap

          if returnAsWell then
            val block = s"__ptr_${typeIndices(f.returnType)}"
            val locationInBlock = usedAllocations(f.returnType)
            params ++ Map(-1 -> s"($block + $locationInBlock)")
          else params
        end locations

        typeIndices.foreach { (ct, i) =>
          val typ = scalaType(ct)
          line(
            s"val __ptr_$i: Ptr[$typ] = alloc[$typ](${allocationSizes(ct)})"
          )
        }
        indices.toList.sorted.foreach { idx =>
          val fp = flatArguments(idx)
          line(s"!${locations(idx)} = ${escape(fp.name)}")
        }
        val delegateCallArgList =
          ListBuffer.empty[String]

        flatArguments.zipWithIndex.foreach { (arg, i) =>
          if !indices.contains(i) then delegateCallArgList.addOne(arg.name)
          else delegateCallArgList.addOne(locations(i))
        }

        lazy val return_ptr = locations(-1)

        if returnAsWell then delegateCallArgList.addOne(return_ptr)
        line(s"$to(${delegateCallArgList.map(escape).mkString(", ")})")
        if returnAsWell then line(s"!${return_ptr}")
      }
  end match
end renderFunction
