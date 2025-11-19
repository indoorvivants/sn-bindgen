package bindgen

import libclang.*

import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import fluent.*

// class StructCollector(
//     val struct: DefBuilder.Struct,
//     var numAnonymous: Int
// )

case class Nestor(level: Int)

def nestTrace(msg: String)(using Nestor, Config) =
  trace(" ➡ " * summon[Nestor].level + msg)

def nestTrace(msg: String, context: Seq[(String, Any)])(using Nestor, Config) =
  trace(" ➡ " * summon[Nestor].level + msg, context)

def goDeep[A](using n: Nestor)(f: Nestor ?=> A) =
  f(using n.copy(level = n.level + 1))

enum LastAction:
  case Anon, Field, NamedField

class StructCollector(
    val struct: DefBuilder.Struct,
    var numAnonymous: Int,
    var lastAction: Option[LastAction]
)

def visitStruct(cursor: CXCursor, name: Option[String])(using
    Config,
    Zone
)(using n: Nestor = Nestor(0)): Def.Struct =
  val (ptr, memory) = Captured.unsafe(
    StructCollector(
      struct = DefBuilder.Struct(
        fields = ListBuffer.empty,
        name = name.filter(_.nonEmpty).map(StructName(_)),
        anonymous = ListBuffer.empty,
        meta = extractMetadata(cursor),
        anonymousFieldStructMapping = ListBuffer.empty,
        staticSize = clang_Type_getSizeOf(clang_getCursorType(cursor))
      ),
      numAnonymous = 0,
      lastAction = None
    ) -> n
  )

  val visitor = CXCursorVisitorPtr {
    (cursorPtr: Ptr[CXCursor], parentPtr: Ptr[CXCursor], d: CXClientData) =>
      val ((collector, nestor), config) =
        !d.unwrap[Captured[(StructCollector, Nestor)]]
      given Config = config
      given Nestor = nestor
      val cursor = !cursorPtr

      Zone {

        val typ = clang_getCursorType(cursor)
        val decl = clang_getTypeDeclaration(typ)
        val isAnonymous = clang_Cursor_isAnonymous(decl) == 1.toUInt

        val builder = collector.struct

        nestTrace(
          s"Entering visitStruct visitor",
          Seq("kind" -> cursor.kind.spelling, "is_anonymous" -> isAnonymous) ++
            Option
              .when(!isAnonymous)("spelling" -> cursor.spelling)
              .toSeq
        )

        (cursor.kind, isAnonymous, typ.kind) match
          case (CXCursorKind.CXCursor_FieldDecl, true, _) =>
            handleAnonymousField(cursor, collector)
            CXChildVisitResult.CXChildVisit_Continue

          case (
                CXCursorKind.CXCursor_FieldDecl,
                false,
                CXTypeKind.CXType_ConstantArray
              ) =>
            handleAnonymousArrayField(cursor, collector)
            CXChildVisitResult.CXChildVisit_Continue

          case (CXCursorKind.CXCursor_FieldDecl, false, _) =>
            val fieldName =
              clang_getCursorSpelling(cursor).string
            builder.fields.addOne(
              FieldSpec.Known(
                fieldName,
                constructType(
                  clang_getCursorType(cursor)
                )
              )
            )

            collector.lastAction = Some(LastAction.NamedField)

            CXChildVisitResult.CXChildVisit_Continue
          case (
                CXCursorKind.CXCursor_UnionDecl,
                _,
                _
              ) =>
            handleAnonymousUnion(cursor, collector)
            CXChildVisitResult.CXChildVisit_Continue

          case (
                CXCursorKind.CXCursor_StructDecl,
                _,
                _
              ) =>
            handleAnonymousStruct(cursor, collector)
            CXChildVisitResult.CXChildVisit_Continue

          case (
                CXCursorKind.CXCursor_EnumDecl,
                _,
                _
              ) =>
            handleAnonymousEnum(cursor, collector)
            CXChildVisitResult.CXChildVisit_Continue

          case (ck, anon, tk) =>
            error(
              "Unexpected cursor state",
              Seq(
                "cursor_kind" -> cursor.kind.spelling,
                "is_anonymous" -> anon,
                "type_spelling" -> typ.spelling
              )
            )

            sys.exit(-1)

        end match
        // if cursor.kind == CXCursorKind.CXCursor_FieldDecl then
        // val fieldName =
        //   clang_getCursorSpelling(cursor).string
        // // val typ = clang_getCursorType(cursor)
        // // val decl = clang_getTypeDeclaration(typ)
        // // val isAnonymous = clang_Cursor_isAnonymous(decl) == 1.toUInt

        // nestTrace(
        //   s"Cursor is a field `$fieldName`",
        //   Seq(
        //     "type_spelling" -> typ.kindSpelling,
        //     "declaration" -> decl.spelling,
        //     "is_anonymous" -> isAnonymous
        //   )
        // )
        // if isAnonymous then
        //   // assert(
        //   //   collector.lastAction == Some(LastAction.Anon),
        //   //   s"This field is anonymous, expected last action to be collecting a union/struct/enum, got ${collector.lastAction}"
        //   // )
        //   val last = builder.anonymous.size
        //   val fieldSpec = FieldSpec.Anon(
        //     nameHint = Option(fieldName).filter(_.nonEmpty),
        //     last - 1
        //   )

        //   builder.fields.addOne(fieldSpec)

        //   // builder.anonymousFieldStructMapping.find(
        //   //   _._2.value == nestedName
        //   // ) match
        //   //   case None =>
        //   //     builder.fields.addOne(fieldSpec)
        //   //   case Some(idx) =>
        //   //     builder.fields.update(idx._1, fieldSpec)
        //   //     builder.anonymousFieldStructMapping.filterInPlace(_ != idx)
        // else if typ.kind == CXTypeKind.CXType_ConstantArray
        // then
        //   val speculateType = constructType(clang_getArrayElementType(typ))
        //   nestTrace(
        //     "Cursor is a constant array",
        //     Seq(
        //       "speculated_type" -> speculateType,
        //       "type_spelling" -> typ.spelling
        //     )
        //   )
        //   speculateType match
        //     case _: CType.Struct | _: CType.Union |
        //         CType.Reference(Name.Unnamed) =>
        //       val last =
        //         builder.anonymous.size // .apply(collector.numAnonymous)
        //       // val nestedName = last match
        //       //   case un: Def.Union  => un.name.value
        //       //   case st: Def.Struct => st.name.value
        //       val numElements = clang_getArraySize(typ)

        //       builder.fields.addOne(
        //         FieldSpec.AnonArray(
        //           nameHint = Option(fieldName).filter(_.nonEmpty),
        //           size = numElements,
        //           unsafeId = last - 1
        //         )
        //       )

        // val fieldSpec =
        //   fieldName -> constArrayType(
        //     CType.Reference(
        //       Name.Model(builder.name.value + "." + nestedName)
        //     ),
        //     numElements
        //   )

        // builder.anonymousFieldStructMapping.find(
        //   _._2.value == nestedName
        // ) match
        //   case None =>
        //     builder.fields.addOne(fieldSpec)
        //   case Some(idx) =>
        //     builder.fields.update(idx._1, fieldSpec)
        //     builder.anonymousFieldStructMapping.filterInPlace(_ != idx)

        // case _ =>
        //   builder.fields.addOne(
        //     FieldSpec.Known(
        //       fieldName,
        //       constructType(
        //         clang_getCursorType(cursor)
        //       )
        //     )
        //   )
        // end match
        // else
        //   builder.fields.addOne(
        //     FieldSpec.Known(
        //       fieldName,
        //       constructType(
        //         clang_getCursorType(cursor)
        //       )
        //     )
        //   )
        // end if

        // CXChildVisitResult.CXChildVisit_Continue
        // else if cursor.kind == CXCursorKind.CXCursor_UnionDecl then
        //   nestTrace(
        //     "Cursor is anonymous union"
        //   )

        //   val str = goDeep(visitStruct(cursor, None))

        //   val newValue = clang_Type_getSizeOf(clang_getCursorType(cursor))
        //   builder.anonymous.addOne(
        //     Def.Union(
        //       fields = str.fields,
        //       name = None,
        //       anonymous = str.anonymous,
        //       meta = extractMetadata(cursor),
        //       staticSize = newValue
        //     )
        //   )
        //   // builder.fields.addOne(
        //   //   FieldSpec.Anon(
        //   //     nameHint = None,
        //   //     unsafeId = builder.anonymous.size - 1
        //   //   )
        //   // )
        //   // builder.anonymousFieldStructMapping.addOne(
        //   //   builder.fields.size -> StructName(nestedName)
        //   // )
        //   // builder.fields.addOne(
        //   //   StructParameterName("") -> CType.Union(
        //   //     str.fields.map(_._2),
        //   //     Hints(newValue)
        //   //   )
        //   // )
        //   // builder.fields.addOne(
        //   //   FieldSpec.Anon(None, builder.anonymous.size - 1)
        //   // )
        //   //

        //   CXChildVisitResult.CXChildVisit_Continue
        // else if cursor.kind == CXCursorKind.CXCursor_StructDecl then
        //   nestTrace(
        //     "Cursor is anonymous struct",
        //     Seq(
        //       "sizeof" -> clang_Type_getSizeOf(clang_getCursorType(cursor))
        //     )
        //   )

        //   // val nestedName = "Struct" + builder.anonymous.size
        //   val str = goDeep(visitStruct(cursor, None))
        //   val newValue = clang_Type_getSizeOf(clang_getCursorType(cursor))

        //   builder.anonymous.addOne(
        //     removeFAM(
        //       Def.Struct(
        //         fields = str.fields,
        //         name = None,
        //         anonymous = str.anonymous,
        //         meta = extractMetadata(cursor),
        //         staticSize = newValue
        //       ),
        //       Some(cursor.spelling)
        //     )
        //   )
        //   // builder.anonymousFieldStructMapping.addOne(
        //   //   builder.fields.size -> StructName(nestedName)
        //   // )
        //   // builder.fields.addOne(
        //   //   StructParameterName("") -> CType.Struct(
        //   //     str.fields.map(_._2),
        //   //     Hints(newValue)
        //   //   )
        //   // )
        //   //
        //   // builder.fields.addOne(
        //   //   FieldSpec.Anon(None, builder.anonymous.size - 1)
        //   // )

        //   CXChildVisitResult.CXChildVisit_Continue
        // else if cursor.kind == CXCursorKind.CXCursor_EnumDecl then
        // CXChildVisitResult.CXChildVisit_Continue
        // else CXChildVisitResult.CXChildVisit_Continue
        // end if
      }
  }

  Zone {
    try
      libclang.fluent.clang_visitChildren(
        cursor,
        visitor,
        CXClientData.wrap(ptr)
      )

      val collected = (!ptr)._1._1

      collected.lastAction match
        case Some(LastAction.Anon) =>
          collected.struct.fields.addOne(
            FieldSpec.Anon(nameHint = None, collected.struct.anonymous.size - 1)
          )
        case _ =>

      removeFAM(collected.struct.build)
    finally memory.deallocate()
    end try
  }
end visitStruct

// def removeFAM(model: Def.St,ruct, name: Option[String] = None)(using
//     Config
// ): Def.Struct =

//   val hasFlexibleArrayMember = model.fields.lastOption.collectFirst {
//     case FieldSpec.Known(_, CType.IncompleteArray(_)) => true
//   }.isDefined

//   if hasFlexibleArrayMember then
//     warning(
//       s"Struct '${name.getOrElse(model.name)}' has a Flexible Array Member, so it was dropped from the definition. " +
//         "See https://github.com/indoorvivants/sn-bindgen/issues/62 for details"
//     )

//     model.copy(fields = model.fields.dropRight(1))
//   else model

// end removeFAM

def handleAnonymousEnum(
    cursor: CXCursor,
    collector: StructCollector
)(using Nestor, Config, Zone) =
  nestTrace(
    "Cursor is anonymous enum",
    Seq("last_action" -> collector.lastAction)
  )

  if collector.lastAction == Some(LastAction.Anon) then
    collector.struct.fields.addOne(
      FieldSpec.Anon(
        nameHint = None,
        unsafeId = collector.struct.anonymous.size - 1
      )
    )

  val str: Def.Enum =
    goDeep(visitEnum(cursor, isTypeDef = true))

  collector.struct.anonymous.addOne(
    str
  )
  collector.lastAction = Some(LastAction.Anon)
end handleAnonymousEnum

def handleAnonymousStruct(
    cursor: CXCursor,
    collector: StructCollector
)(using Nestor, Config, Zone) =
  nestTrace(
    "Cursor is anonymous struct",
    Seq(
      "sizeof" -> clang_Type_getSizeOf(clang_getCursorType(cursor)),
      "last_action" -> collector.lastAction
    )
  )

  if collector.lastAction == Some(LastAction.Anon) then
    collector.struct.fields.addOne(
      FieldSpec.Anon(
        nameHint = None,
        unsafeId = collector.struct.anonymous.size - 1
      )
    )

  val str = goDeep(visitStruct(cursor, None))
  val newValue = clang_Type_getSizeOf(clang_getCursorType(cursor))

  collector.struct.anonymous.addOne(
    removeFAM(
      Def.Struct(
        fields = str.fields,
        name = None,
        anonymous = str.anonymous,
        meta = extractMetadata(cursor),
        staticSize = newValue
      ),
      Some(cursor.spelling)
    )
  )

  collector.lastAction = Some(LastAction.Anon)
end handleAnonymousStruct

def handleAnonymousUnion(
    cursor: CXCursor,
    collector: StructCollector
)(using Nestor, Config, Zone) =
  nestTrace(
    "Cursor is anonymous union"
  )

  if collector.lastAction == Some(LastAction.Anon) then
    collector.struct.fields.addOne(
      FieldSpec.Anon(
        nameHint = None,
        unsafeId = collector.struct.anonymous.size - 1
      )
    )

  val str = goDeep(visitStruct(cursor, None))

  val newValue = clang_Type_getSizeOf(clang_getCursorType(cursor))
  collector.struct.anonymous.addOne(
    Def.Union(
      fields = str.fields,
      name = None,
      anonymous = str.anonymous,
      meta = extractMetadata(cursor),
      staticSize = newValue
    )
  )

  collector.lastAction = Some(LastAction.Anon)
end handleAnonymousUnion

def handleAnonymousField(
    cursor: CXCursor,
    collector: StructCollector
)(using Nestor, Config, Zone) =
  val fieldName =
    clang_getCursorSpelling(cursor).string
  val typ = clang_getCursorType(cursor)
  val decl = clang_getTypeDeclaration(typ)

  nestTrace(
    s"Cursor is anonymous field `$fieldName`",
    Seq(
      "type_spelling" -> typ.kindSpelling,
      "declaration" -> decl.spelling
    )
  )

  assert(
    collector.lastAction == Some(LastAction.Anon),
    s"This field is anonymous, expected last action to be collecting a union/struct/enum, got ${collector.lastAction}"
  )
  val last = collector.struct.anonymous.size
  val fieldSpec = FieldSpec.Anon(
    nameHint = Option(fieldName).filter(_.nonEmpty),
    last - 1
  )

  collector.struct.fields.addOne(fieldSpec)
  collector.lastAction = Some(LastAction.Field)
end handleAnonymousField

def handleAnonymousArrayField(
    cursor: CXCursor,
    collector: StructCollector
)(using Nestor, Config, Zone) =
  val fieldName =
    clang_getCursorSpelling(cursor).string
  val typ = clang_getCursorType(cursor)
  val decl = clang_getTypeDeclaration(typ)

  val speculateType = constructType(clang_getArrayElementType(typ))
  nestTrace(
    "Cursor is a constant array",
    Seq(
      "speculated_type" -> speculateType,
      "type_spelling" -> typ.spelling
    )
  )
  speculateType match
    case _: CType.Struct | _: CType.Union | CType.Reference(Name.Unnamed) =>
      val last =
        collector.struct.anonymous.size // .apply(collector.numAnonymous)
      // val nestedName = last match
      //   case un: Def.Union  => un.name.value
      //   case st: Def.Struct => st.name.value
      val numElements = clang_getArraySize(typ)

      collector.struct.fields.addOne(
        FieldSpec.AnonArray(
          nameHint = Option(fieldName).filter(_.nonEmpty),
          size = numElements,
          unsafeId = last - 1
        )
      )

    case _ =>
      collector.struct.fields.addOne(
        FieldSpec.Known(
          fieldName,
          constructType(
            clang_getCursorType(cursor)
          )
        )
      )
  end match

  collector.lastAction = Some(LastAction.Field)
end handleAnonymousArrayField
