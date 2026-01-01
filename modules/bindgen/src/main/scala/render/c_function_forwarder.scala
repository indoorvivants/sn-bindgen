package bindgen
package rendering

import scala.collection.mutable.ListBuffer

// Pattern to match C array types like "int64_t[4]" or "int[10][20]"
private val arrayTypePattern = """^(.+?)(\[.+\])$""".r

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
            else
              // Handle array types: "int64_t[4]" should become "int64_t name[4]"
              fp.originalTyp.s match
                case arrayTypePattern(baseType, arraySuffix) =>
                  s"$baseType ${fp.name}$arraySuffix"
                case _ =>
                  s"${fp.originalTyp.s} ${fp.name}"
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
