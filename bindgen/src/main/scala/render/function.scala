package bindgen
package rendering

import bindgen.*
import scala.collection.mutable.ListBuffer

def function(f: GeneratedFunction.ScalaFunction, line: Appender)(using
    Config,
    AliasResolver
) =
  val arglist = f.arguments
    .map(fp => s"${escape(fp.name)}: ${scalaType(fp.typ)}")
    .mkString(", ")

  val access =
    if f.public then "" else s"private[${summon[Config].packageName.value}] "

  f.body match
    case ScalaFunctionBody.Extern =>
      line(
        s"${access}def ${f.name}($arglist): ${scalaType(f.returnType)} = extern"
      )
    case ScalaFunctionBody.Delegate(to, Allocations(indices, returnAsWell)) =>
      line(
        s"def ${f.name}($arglist)(using Zone): ${scalaType(f.returnType)} = "
      )
      def ptr_name(n: String) = s"_ptr_$n"
      nest {
        indices.toList.sorted.foreach { idx =>
          val fp = f.arguments(idx)
          line(
            s"val ${ptr_name(idx.toString)} = alloc[${scalaType(fp.typ)}](1)"
          )
          line(s"!${ptr_name(idx.toString)} = ${escape(fp.name)}")
        }
        if returnAsWell then
          line(
            s"val ${ptr_name("return")} = alloc[${scalaType(f.returnType)}](1)"
          )

        val delegateCallArgList =
          ListBuffer.empty[String]

        (0 until f.arguments.size).foreach { i =>
          if !indices.contains(i) then
            delegateCallArgList.addOne(f.arguments(i).name)
          else delegateCallArgList.addOne(ptr_name(i.toString))
        }

        if returnAsWell then delegateCallArgList.addOne(ptr_name("return"))
        line(s"$to(${delegateCallArgList.map(escape).mkString(", ")})")
        if returnAsWell then line(s"!${ptr_name("return")}")
      }
  end match
end function
