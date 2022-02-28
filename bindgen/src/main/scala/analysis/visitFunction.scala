package bindgen

import libclang.defs.*
import libclang.enumerations.*
import libclang.types.*

import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import scalanative.libc.*

def visitFunction(functionCursor: CXCursor)(using Zone, Config) =
  val typ = clang_getCursorType(functionCursor)
  val functionName = clang_getCursorSpelling(functionCursor).string
  val returnType = clang_getResultType(typ)

  val mem = Captured.allocate[Def.Function](
    Def.Function(
      name = FunctionName(functionName),
      returnType = constructType(returnType),
      parameters = ListBuffer.empty,
      originalCType = OriginalCType(
        constructType(returnType),
        clang_getTypeSpelling(returnType).string
      ),
      numArguments = clang_getNumArgTypes(typ)
    )
  )

  import libclang.fluent.*

  clang_visitChildren(
    functionCursor,
    CXCursorVisitor { (cursor: CXCursor, parent: CXCursor, d: CXClientData) =>
      val (builder, zone, config) = (!d.unwrap[Captured[Def.Function]])
      given Zone = zone
      given Config = config
      if cursor.kind == CXCursorKind.CXCursor_ParmDecl && builder.parameters.size < builder.numArguments then
        val origParamName = Option(cursor.spelling)
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
      else CXChildVisitResult.CXChildVisit_Continue
      end if
    },
    CXClientData.wrap(mem)
  )

  (!mem)._1
end visitFunction
