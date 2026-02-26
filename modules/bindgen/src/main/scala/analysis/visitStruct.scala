package bindgen

import libclang.*

import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

import fluent.*

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
          Seq(
            "kind" -> cursor.kind.spelling,
            "is_anonymous" -> isAnonymous,
            "last_action" -> collector.lastAction
          ) ++
            Option
              .when(!isAnonymous)("spelling" -> cursor.spelling)
              .toSeq
        )

        import FieldVisitors.*
        (cursor.kind, isAnonymous, typ.kind) match
          case (CXCursorKind.CXCursor_FieldDecl, true, _) =>
            visitAnonymousField(cursor, collector)
            CXChildVisitResult.CXChildVisit_Continue

          case (
                CXCursorKind.CXCursor_FieldDecl,
                false,
                CXTypeKind.CXType_ConstantArray
              ) =>
            visitAnonymousArrayField(cursor, collector)
            CXChildVisitResult.CXChildVisit_Continue

          case (CXCursorKind.CXCursor_FieldDecl, false, _) =>
            val tpe = constructType(clang_getCursorType(cursor))

            def unnamedPointerDepth(t: CType): Option[Int] =
              t match
                case CType.Reference(Name.Unnamed) => Some(0)
                case CType.Pointer(to) => unnamedPointerDepth(to).map(_ + 1)
                case _                 => None

            val fieldName =
              clang_getCursorSpelling(cursor).string

            if collector.lastAction == Some(LastAction.Anon) then
              collector.struct.fields.addOne(
                FieldSpec.Anon(
                  nameHint =
                    if fieldName.nonEmpty then Some(fieldName) else None,
                  unsafeId = collector.struct.anonymous.size - 1,
                  pointerDepth = unnamedPointerDepth(tpe).getOrElse(0)
                )
              )
              collector.lastAction = Some(LastAction.Field)
            else
              builder.fields.addOne(
                FieldSpec.Known(
                  fieldName,
                  constructType(
                    clang_getCursorType(cursor)
                  )
                )
              )

              collector.lastAction = Some(LastAction.NamedField)
            end if

            CXChildVisitResult.CXChildVisit_Continue
          case (
                CXCursorKind.CXCursor_UnionDecl,
                true,
                _
              ) =>
            visitAnonymousUnion(cursor, collector)
            CXChildVisitResult.CXChildVisit_Continue

          case (
                CXCursorKind.CXCursor_StructDecl,
                true,
                _
              ) =>
            visitAnonymousStruct(cursor, collector)
            CXChildVisitResult.CXChildVisit_Continue

          case (
                CXCursorKind.CXCursor_EnumDecl,
                _,
                _
              ) =>
            visitAnonymousEnum(cursor, collector)
            CXChildVisitResult.CXChildVisit_Continue

          case (ck, anon, tk) =>
            trace(
              "Unexpected cursor state",
              Seq(
                "cursor_kind" -> cursor.kind.spelling,
                "is_anonymous" -> anon,
                "type_spelling" -> typ.spelling
              )
            )
            CXChildVisitResult.CXChildVisit_Continue

        end match
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

def removeFAM(model: Def.Struct, name: Option[String] = None)(using
    Config
): Def.Struct =

  val hasFlexibleArrayMember = model.fields.lastOption.collectFirst {
    case FieldSpec.Known(_, CType.IncompleteArray(_)) => true
  }.isDefined

  if hasFlexibleArrayMember then
    warning(
      s"Struct '${name.getOrElse(model.name)}' has a Flexible Array Member, so it was dropped from the definition. " +
        "See https://github.com/indoorvivants/sn-bindgen/issues/62 for details"
    )

    model.copy(fields = model.fields.dropRight(1))
  else model

end removeFAM

object FieldVisitors:
  def visitAnonymousEnum(
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
  end visitAnonymousEnum

  def visitAnonymousStruct(
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
  end visitAnonymousStruct

  def visitAnonymousUnion(
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
  end visitAnonymousUnion

  def visitAnonymousField(
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

    val last = collector.struct.anonymous.size
    val fieldSpec = FieldSpec.Anon(
      nameHint = Option(fieldName).filter(_.nonEmpty),
      last - 1
    )

    collector.struct.fields.addOne(fieldSpec)
    collector.lastAction = Some(LastAction.Field)
  end visitAnonymousField

  def visitAnonymousArrayField(
      cursor: CXCursor,
      collector: StructCollector
  )(using Nestor, Config, Zone) =
    val fieldName =
      clang_getCursorSpelling(cursor).string
    val typ = clang_getCursorType(cursor)
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
          collector.struct.anonymous.size
        val numElements = clang_getArraySize(typ)

        collector.struct.fields.addOne(
          FieldSpec.AnonArray(
            nameHint = Option(fieldName).filter(_.nonEmpty),
            size = numElements,
            unsafeId = last - 1
          )
        )

      case _ =>
        if collector.lastAction == Some(LastAction.Anon) then
          collector.struct.fields.addOne(
            FieldSpec.Anon(
              nameHint = None,
              unsafeId = collector.struct.anonymous.size - 1
            )
          )

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
  end visitAnonymousArrayField
end FieldVisitors
