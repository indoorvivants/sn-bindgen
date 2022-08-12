package bindgen

import libclang.defs.*
import libclang.enumerations.*
import libclang.types.*

import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import libclang.fluent.*

import scalanative.libc.*

def visitFunction(functionCursor: CXCursor)(using Zone, Config): Def.Function =
  val typ = clang_getCursorType(functionCursor)
  val functionName = clang_getCursorSpelling(functionCursor).string
  val returnType = clang_getResultType(typ)

  val (ptr, memory) = Captured.unsafe[DefBuilder.Function](
    DefBuilder.Function(
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

  val visitor = CXCursorVisitor {
    (cursor: CXCursor, parent: CXCursor, d: CXClientData) =>
      val (builder, config) = (!d.unwrap[Captured[DefBuilder.Function]])

      given Config = config

      zone {
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
      }
  }

  try
    clang_visitChildren(
      functionCursor,
      visitor,
      CXClientData.wrap(ptr)
    )
    (!ptr)._1.build
  finally memory.deallocate()

end visitFunction
