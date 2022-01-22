package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*
import libclang.enumerations.*
import scala.collection.mutable.ListBuffer

def visitFunction(functionCursor: CXCursor)(using Zone, Config) =
  val typ = clang_getCursorType(functionCursor)
  val functionName = clang_getCursorSpelling(functionCursor).string
  val returnType = clang_getResultType(typ)

  val mem = Captured.allocate[Def.Function](
    Def.Function(
      name = functionName,
      returnType = constructType(returnType),
      parameters = ListBuffer.empty,
      originalCType = OriginalCType(
        constructType(returnType),
        clang_getTypeSpelling(returnType).string
      )
    )
  )

  clang_visitChildren(
    functionCursor,
    CXCursorVisitor { (cursor: CXCursor, parent: CXCursor, d: CXClientData) =>
      val (builder, zone, config) = (!d.unwrap[Captured[Def.Function]])
      given Zone = zone
      given Config = config
      if cursor.kind == CXCursorKind.CXCursor_ParmDecl then
        val origParamName = Option(clang_getCursorSpelling(cursor).string)
          .filter(_.nonEmpty)

        val parameterName = origParamName
          .getOrElse(s"_${builder.parameters.size}")

        val parameterType = constructType(clang_getCursorType(cursor))
        val parameterTypeRendered =
          clang_getTypeSpelling(clang_getCursorType(cursor)).string

        builder.parameters.addOne(
          FunctionParameter(
            name = parameterName,
            typ = parameterType,
            originalTyp = OriginalCType(parameterType, parameterTypeRendered),
            generatedName = origParamName.isEmpty
          )
        )
        CXChildVisitResult.CXChildVisit_Continue
      else CXChildVisitResult.CXChildVisit_Recurse
      end if
    },
    CXClientData.wrap(mem)
  )
  (!mem)._1
end visitFunction
