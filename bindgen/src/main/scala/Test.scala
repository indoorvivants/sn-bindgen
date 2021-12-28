package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*
import libclang.enumerations.*
import scala.collection.mutable

inline def zone[A](inline f: Zone ?=> A) = Zone.apply(z => f(using z))

@main def hello(file: String) =
  zone {
    val filename = toCString(file)
    val index = clang_createIndex(0, 0)
    val l = List.newBuilder[String]
    val unit = clang_parseTranslationUnit(
      index,
      filename,
      null,
      0.toUInt,
      null,
      0.toUInt,
      CXTranslationUnit_Flags.CXTranslationUnit_None
    )
    val bindingMem = stackalloc[Def.Binding](1)
    !bindingMem = Def.Binding(
      enums = mutable.Set.empty,
      structs = mutable.Set.empty,
      functions = mutable.Set.empty
    )

    clang_visitChildren(
      clang_getTranslationUnitCursor(unit),
      CXCursorVisitor {
        (cursor: CXCursor, parent: CXCursor, data: CXClientData) =>
          val binding = !(data.unwrap[Def.Binding])
          zone {
            if cursor.kind == CXCursorKind.CXCursor_FunctionDecl then
              val function = visitFunction(cursor)
              binding.functions.add(function)
              println("Defined func: " + function)

            if cursor.kind == CXCursorKind.CXCursor_TypedefDecl then
              val typ = clang_getTypedefDeclUnderlyingType(cursor)
              val name = clang_getCursorSpelling(cursor).string
              val recordType = clang_Type_getNamedType(typ)
              val struct =
                visitStruct(clang_getTypeDeclaration(recordType), name)
              println("Defined struct: " + struct)
              binding.structs.add(struct)
            end if

            if cursor.kind == CXCursorKind.CXCursor_EnumDecl then
              binding.enums.add(
                visitEnum(
                  cursor,
                  clang_getCursorType(parent).kind == CXTypeKind.CXType_Typedef
                )
              )
          }
          if cursor.kind == CXCursorKind.CXCursor_TypedefDecl then
            CXChildVisitResult.CXChildVisit_Continue
          else CXChildVisitResult.CXChildVisit_Recurse
      },
      CXClientData.wrap(bindingMem)
    )

    val sb = new java.lang.StringBuilder

    given default: Config = Config(indentSize = 2)

    sb.append("object predef:")
    render.nest {
      val predef = """
      |abstract class CEnum[T](using eq: T =:= Int):
      |  given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
      |  extension (t: T) def int: CInt = eq.apply(t)
      |
      |abstract class CEnumU[T](using eq: T =:= UInt):
      |  given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
      """.stripMargin.linesIterator
      predef.foreach(render.to(sb))
    }

    sb.append("object enumerations:\n")
    render.nest {
      render.to(sb)("import predef.*")
      (!bindingMem).enums.zipWithIndex.foreach { case (en, idx) =>
        render.enumeration(
          en,
          render.to(sb)
        )
        if idx != (!bindingMem).enums.size - 1 then sb.append("\n")
      }
    }

    sb.append("object structs:\n")
    render.nest {
      render.to(sb)("import predef.*, enumerations.*")

      (!bindingMem).structs.zipWithIndex.foreach { case (en, idx) =>
        render.struct(
          en,
          render.to(sb)
        )
        if idx != (!bindingMem).structs.size - 1 then sb.append("\n")
      }
    }
    println(sb.toString)

    clang_disposeTranslationUnit(unit)
    clang_disposeIndex(index)
  }
end hello
