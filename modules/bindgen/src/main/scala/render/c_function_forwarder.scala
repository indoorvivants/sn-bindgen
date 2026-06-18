package bindgen
package rendering

import scala.collection.mutable.ListBuffer

// Pattern to match function pointer types like "void (*)(void *)"
// Captures: group 1 = return type and opening, group 2 = params
private val funcPtrPattern = """^(.+\(\*)(\)\(.*)$""".r

// Render a C parameter with correct syntax for function pointers
private def renderCParam(typeStr: String, name: String): String =
  typeStr match
    case funcPtrPattern(prefix, suffix) =>
      // "void (*)(void *)" -> "void (*name)(void *)"
      s"$prefix$name$suffix"
    case _ =>
      s"$typeStr $name"

def cFunctionForwarder(f: GeneratedFunction.CFunction, line: Appender)(using
    AliasResolver,
    Config
): Unit =
  f.body match
    case CFunctionBody.Delegate(to, pointers, returnAsWell) =>
      val arglist = List.newBuilder[String]
      f.arguments.zipWithIndex
        .foreach { case (fp, i) =>
          arglist.addOne {
            if pointers.contains(i) then s"${fp.originalTyp.s} *${fp.name}"
            else renderCParam(fp.originalTyp.s, fp.name)
          }
        }

      val delegateCallList = ListBuffer.empty[String]
      f.arguments
        .map { case FunctionParameter(n, typ, oct, _) =>
          delegateCallList.addOne(
            if isDirectStructAccess(oct.typ) then s"*$n"
            else s"$n"
          )
        }

      if !returnAsWell then
        val returnKeyword = if f.returnType != CType.Void then "return " else ""
        line(
          s"${f.originalCType.s} ${f.name}(${arglist.result
              .mkString(", ")}) {\n $returnKeyword$to(${delegateCallList.mkString(", ")});\n};\n"
        )
      else
        val returnParamName = "____return"
        val returnStructName = f.originalCType.typ match
          case CType.Reference(Name.Model(name, _)) => name
          case _ =>
            raiseError(
              s"${f.originalCType.typ} should be a Reference"
            )
        arglist.addOne(
          s"$returnStructName *$returnParamName"
        )
        line(s"void ${f.name}(${arglist.result.mkString(", ")}) {")
        line(
          s"  $returnStructName ____ret = $to(${delegateCallList.mkString(", ")});"
        )
        line(
          s"  memcpy($returnParamName, &____ret, sizeof($returnStructName));"
        )
        line("}\n")
      end if
  end match
end cFunctionForwarder
