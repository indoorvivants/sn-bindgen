package bindgen
package rendering

import scala.collection.mutable.ListBuffer

def cFunctionForwarder(model: Def.Function, line: Appender)(using
    AliasResolver,
    Config
) =
  model match
    case Def.Function(
          name,
          returnType,
          parameters,
          CFunctionType.ExternRename(_, _, original),
          originalCType
        ) =>
      val arglist = parameters
        .map { case a @ (n, typ, oct) =>
          if isDirectStructAccess(oct.typ) then s"${oct.s} *$n"
          else s"${oct.s} $n"
        }
        .mkString(", ")

      val returnIsOkay = originalCType.typ == returnType

      val delegateCallList = ListBuffer.empty[String]
      parameters
        .map { case a @ (n, typ, oct) =>
          delegateCallList.addOne(
            if isDirectStructAccess(oct.typ) then s"*$n"
            else s"$n"
          )
        }

      if returnIsOkay then
        val returnKeyword = if returnType != CType.Void then "return " else ""
        line(
          s"${originalCType.s} $name($arglist) {\n $returnKeyword$original(${delegateCallList.mkString(", ")});\n};\n"
        )
      else
        val returnStructName = originalCType.typ match
          case CType.RecordRef(name) => name
          case CType.Typedef(name)   => name
          case _ =>
            throw error(
              s"${originalCType.typ} should be a RecordRef or a TypeDef"
            )
        line(s"${originalCType.s} $name($arglist) {")
        line(
          s"  $returnStructName ____ret = $original(${delegateCallList.dropRight(1).mkString(", ")});"
        )
        line(s"  memcpy(__return, &____ret, sizeof($returnStructName));")
        line("}\n")
      end if
