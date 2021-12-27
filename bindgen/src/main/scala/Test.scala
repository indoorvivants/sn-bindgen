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
    !bindingMem = Def.Binding(enums = mutable.Set.empty)

    clang_visitChildren(
      clang_getTranslationUnitCursor(unit),
      CXCursorVisitor {
        (cursor: CXCursor, parent: CXCursor, data: CXClientData) =>
          val binding = !(data.unwrap[Def.Binding])
          zone {
            // if cursor.kind == CXCursorKind.CXCursor_StructDecl then
            //   visitStruct(cursor)
            //   CXChildVisitResult.CXChildVisit_Continue
            // else CXChildVisitResult.CXChildVisit_Recurse

            if cursor.kind == CXCursorKind.CXCursor_EnumDecl then
              binding.enums.add(
                visitEnum(
                  cursor,
                  clang_getCursorType(parent).kind == CXTypeKind.CXType_Typedef
                )
              )
          }

          CXChildVisitResult.CXChildVisit_Recurse
      },
      CXClientData.wrap(bindingMem)
    )

    val sb = new java.lang.StringBuilder

    given Config = Config(indent = 2)
    
    sb.append("object enumerations:\n")
    (!bindingMem).enums.zipWithIndex.foreach { case (en, idx) =>
      render.enumeration(en, (s: String) => sb.append(render.indent + s + "\n"))
      if idx != (!bindingMem).enums.size - 1 then sb.append("\n")
    }
    println(sb.toString)

    clang_disposeTranslationUnit(unit)
    clang_disposeIndex(index)
  }
end hello

def visitEnum(cursor: CXCursor, isTypeDef: Boolean)(using Zone) =
  val mem = stackalloc[Def.Enum](1)
  !mem = Def.Enum(mutable.ListBuffer.empty, name = "", intType = "")
  zone {
    (!mem).intType =
      clang_getTypeSpelling(clang_getEnumDeclIntegerType(cursor)).string
    val typ = clang_getCursorType(cursor)
    val name = clang_getTypeSpelling(typ).string
    (!mem).name = if name.startsWith("enum ") then name.drop(5) else name
  }

  clang_visitChildren(
    cursor,
    CXCursorVisitor { (cursor: CXCursor, parent: CXCursor, d: CXClientData) =>
      zone {
        if cursor.kind == CXCursorKind.CXCursor_EnumConstantDecl then
          val s = clang_getCursorSpelling(cursor).string
          val ref = !d.unwrap[Def.Enum]
          ref.values.addOne(
            s -> clang_getEnumConstantDeclValue(cursor)
          )
          CXChildVisitResult.CXChildVisit_Continue
        else CXChildVisitResult.CXChildVisit_Recurse
      }
    },
    CXClientData.wrap(mem)
  )
  !mem
end visitEnum

def visitStruct(cursor: CXCursor)(using Zone) =
  val mem = stackalloc[mutable.ListBuffer[String]](1)
  !mem = mutable.ListBuffer.empty[String]
  clang_visitChildren(
    cursor,
    CXCursorVisitor { (cursor: CXCursor, parent: CXCursor, d: CXClientData) =>
      zone {
        if cursor.kind == CXCursorKind.CXCursor_FieldDecl then
          val s = clang_getCursorSpelling(cursor).string
          (!d.unwrap[mutable.ListBuffer[String]]).addOne(s)
          CXChildVisitResult.CXChildVisit_Continue
        else CXChildVisitResult.CXChildVisit_Recurse
      }
    },
    CXClientData.wrap(mem)
  )

  (!mem).result
end visitStruct
