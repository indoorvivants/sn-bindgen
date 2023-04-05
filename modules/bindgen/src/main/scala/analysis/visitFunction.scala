package bindgen

import _root_.libclang.structs.*
import _root_.libclang.enumerations.*
import _root_.libclang.aliases.*
import _root_.libclang.functions.*

import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import libclang.fluent.*

import scalanative.libc.*

def visitFunction(functionCursor: CXCursor)(using Zone, Config): Def.Function =
  val typ = clang_getCursorType(functionCursor)
  val isVariadic = clang_Cursor_isVariadic(functionCursor).toInt == 1
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
      numArguments = clang_getNumArgTypes(typ),
      variadic = isVariadic,
      meta = extractMetadata(functionCursor)
    )
  )

  val visitor = CXCursorVisitorPtr {
    (cursorPtr: Ptr[CXCursor], parentPtr: Ptr[CXCursor], d: CXClientData) =>
      val (builder, config) = (!d.unwrap[Captured[DefBuilder.Function]])

      val cursor = !cursorPtr

      given Config = config

      zone {
        if cursor.kind == CXCursorKind.CXCursor_ParmDecl && builder.parameters.size < builder.numArguments
        then
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
    libclang.fluent.clang_visitChildren(
      functionCursor,
      visitor,
      CXClientData.wrap(ptr)
    )
    (!ptr)._1.build
  finally memory.deallocate()

end visitFunction
