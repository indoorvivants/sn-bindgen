package bindgen.rendering

import bindgen.*
import scala.collection.mutable.ListBuffer

def function(model: Def.Function, line: Appender)(using
    AliasResolver,
    Config
): Unit =
  import model.*

  val arglist = parameters
    .map((name, ctype, _) => s"${escape(name)}: ${scalaType(ctype)}")
    .mkString(", ")

  val privatise = model.tpe match
    case f: CFunctionType.ExternRename => s"private[$packageName] "
    case _                             => ""

  val isFunctionRewrite =
    model.tpe match
      case CFunctionType.Extern => false
      case _                    => true
    end match

  // if !isFunctionRewrite && isIllegalFunction(
  //     model.returnType,
  //     model.parameters.toList.map(_._2)
  //   )
  // then
  //   val rewrites = functionRewriter(model)

  //   line(s"object $name:")
  //   nest {
  //     rewrites.foreach { m =>
  //       function(m, line)
  //       line("")
  //     }
  //   }
  // else
  model.tpe match
    case CFunctionType.Extern =>
      line(
        s"${privatise}def $name($arglist): ${scalaType(returnType)} = extern"
      )
    case CFunctionType.ExternRename(name, _, _) =>
      line(s"""@name("$name")""")
      line(
        s"${privatise}def $name($arglist): ${scalaType(returnType)} = extern"
      )
    case CFunctionType.Delegate(rewrites, returnAsWell, delegateTo) =>
      line(s"def $name($arglist)(using Zone): ${scalaType(returnType)} = ")
      def ptr_name(n: String) = s"_ptr_$n"
      nest {
        rewrites.toList.sorted.foreach { idx =>
          val (name, typ, _) = model.parameters(idx)
          line(
            s"val ${ptr_name(idx.toString)} = alloc[${scalaType(typ)}](1)"
          )
          line(s"!${ptr_name(idx.toString)} = ${escape(name)}")
        }

        if returnAsWell then
          line(
            s"val ${ptr_name("return")} = alloc[${scalaType(model.returnType)}](1)"
          )

        val delegateCallArgList =
          ListBuffer.empty[String]

        (0 until model.parameters.size).foreach { i =>
          if !rewrites.contains(i) then
            delegateCallArgList.addOne(model.parameters(i)._1)
          else delegateCallArgList.addOne(ptr_name(i.toString))
        }

        if returnAsWell then delegateCallArgList.addOne(ptr_name("return"))

        line(s"$delegateTo(${delegateCallArgList.mkString(", ")})")

        if returnAsWell then line(s"!${ptr_name("return")}")
      }
  end match

// end if

end function
