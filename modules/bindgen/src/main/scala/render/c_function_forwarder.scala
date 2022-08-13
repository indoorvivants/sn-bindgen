package bindgen
package rendering

import scala.collection.mutable.ListBuffer

def cFunctionForwarder(f: GeneratedFunction.CFunction, line: Appender)(using
    AliasResolver,
    Config
) =
  f.body match
    case CFunctionBody.Delegate(to, pointers, returnAsWell) =>
      val arglist = List.newBuilder[String]
      f.arguments.zipWithIndex
        .foreach { case (fp, i) =>
          arglist.addOne {
            if pointers.contains(i) then s"${fp.originalTyp.s} *${fp.name}"
            else s"${fp.originalTyp.s} ${fp.name}"
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
          case CType.Reference(Name.Model(name)) => name
          case _ =>
            throw Error(
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
