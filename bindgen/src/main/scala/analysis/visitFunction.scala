package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*
import libclang.enumerations.*
import scala.collection.mutable.ListBuffer

def visitFunction(functionCursor: CXCursor)(using Zone) =
  val mem = stackalloc[Def.Function](1)

  zone {
    val typ = clang_getCursorType(functionCursor)
    val functionName = clang_getCursorSpelling(functionCursor).string
    val returnType = clang_getResultType(typ)

    !mem = Def.Function(
      name = functionName,
      returnType = constructType(returnType),
      parameters = ListBuffer.empty,
      tpe = CFunctionType.Extern,
      originalCType = OriginalCType(
        constructType(returnType),
        clang_getTypeSpelling(returnType).string
      )
    )

    clang_visitChildren(
      functionCursor,
      CXCursorVisitor { (cursor: CXCursor, parent: CXCursor, d: CXClientData) =>
        zone {
          val builder = (!d.unwrap[Def.Function])
          // errln(builder.name)
          if cursor.kind == CXCursorKind.CXCursor_ParmDecl then
            val origParamName = Option(clang_getCursorSpelling(cursor).string)
              .filter(_.nonEmpty)

            val parameterName = origParamName
              .getOrElse(s"_${builder.parameters.size}")

            // errln(s"    $parameterName")

            val parameterType = constructType(clang_getCursorType(cursor))
            val parameterTypeRendered =
              clang_getTypeSpelling(clang_getCursorType(cursor)).string

            builder.parameters.addOne(
              FunctionParameter(
                name = parameterName,
                typ = parameterType,
                originalTyp =
                  OriginalCType(parameterType, parameterTypeRendered),
                generatedName = origParamName.isEmpty
              )
            )
            CXChildVisitResult.CXChildVisit_Continue
          else
            // errln(
            //   s"    Not a parmdecl, but ${clang_getCursorKindSpelling(
            //     cursor.kind
            //   ).string} === ${clang_getCursorSpelling(cursor).string}"
            // )
            CXChildVisitResult.CXChildVisit_Recurse
          end if
        }
      },
      CXClientData.wrap(mem)
    )
  }

  // errln(s"Registered function ${!mem}")
  !mem
end visitFunction
