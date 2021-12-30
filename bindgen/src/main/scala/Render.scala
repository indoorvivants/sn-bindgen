package bindgen

import bindgen.Def.Binding
import scala.scalanative.unsafe.Tag
import scala.runtime.AbstractFunction4
import scala.scalanative.annotation.alwaysinline

object render:
  private def escape(name: String) =
    name match
      case "type"   => "`type`"
      case "val"    => "`val`"
      case "class"  => "`class`"
      case "object" => "`object`"
      case other    => other

  def enumeration(model: Def.Enum, line: Appender)(using
      Config,
      AliasResolver
  ) =
    val values = List.newBuilder[(String, String)]
    val opaqueType = model.name.get
    val numericType = model.intType.getOrElse(CType.Int)
    val enumSuffix = if numericType.sign == SignType.Unsigned then "U" else ""
    val underlyingTypeRender = scalaType(numericType)
    line(s"opaque type $opaqueType = $underlyingTypeRender")
    line(s"object $opaqueType extends CEnum$enumSuffix[$opaqueType]:")

    nest {
      if numericType.sign == SignType.Signed then
        line(
          s"inline def define(inline a: $underlyingTypeRender): $opaqueType = a"
        )
      else
        val extension = numericType.base match
          case IntegralBase.Int   => "Int"
          case IntegralBase.Long  => "Long"
          case IntegralBase.Short => "Short"
          case IntegralBase.Char  => "Byte"
        line(
          s"inline def define(inline a: Long): $opaqueType = a.toU$extension"
        )
      end if
      model.values.foreach { case (constName, value) =>
        val lhs = s"val $constName"
        val rhs = "define(" + value.toString + ")"

        line(lhs + " = " + rhs)
      }
    }
  end enumeration

  def union(model: Def.Union, line: Appender)(using Config, AliasResolver) =
    val structName = model.name
    val unionType: CType.Union = CType.Union(model.fields.map(_._2).toList)
    val tpe = scalaType(unionType)
    line(s"opaque type $structName = $tpe")
    line(s"object $structName:")
    nest {
      val tag =
        s"given _tag: Tag[$structName] = ${scalaTag(unionType)}"
      line(tag)
      if model.fields.nonEmpty then
        line(s"extension (struct: $structName)")
        nest {
          model.fields.foreach { case (fieldName, fieldType) =>
            val typ = scalaType(fieldType)
            line(
              s"def ${escape(fieldName)}: $typ = !struct.at(0).asInstanceOf[Ptr[$typ]]"
            )
          }
        }
      end if
    }
  end union

  def struct(model: Def.Struct, line: Appender)(using Config, AliasResolver) =
    val (struct, rewriteFields) =
      if (model.fields.size > 22) then (model, Set.empty[String])
      else deRecurse(model)
    val structName = struct.name
    val structType: CType.Struct = CType.Struct(struct.fields.map(_._2).toList)
    val fieldOffsets = offsets(structType)
    val tpe = scalaType(structType)
    line(s"opaque type $structName = $tpe")
    line(s"object $structName:")
    nest {
      if model.fields.nonEmpty then
        val paramTypes = struct.fields.map(_._2).map(scalaType).mkString(", ")
        val tag =
          s"given _tag: Tag[$structName] = ${scalaTag(structType)}"
        line(tag)
        line(s"extension (struct: $structName)")
        nest {
          if struct.fields.size <= 22 then
            struct.fields.zipWithIndex.foreach {
              case ((fieldName, fieldType), idx) =>
                if !rewriteFields.contains(fieldName) then
                  line(
                    s"def ${escape(fieldName)}: ${scalaType(fieldType)} = struct._${idx + 1}"
                  )
                else
                  val newType =
                    scalaType(CType.Pointer(CType.RecordRef(structName)))
                  line(
                    s"def ${escape(fieldName)}: $newType = struct._${idx + 1}.asInstanceOf[$newType]"
                  )
                end if
            }
          else
            struct.fields.zip(fieldOffsets).foreach {
              case ((fieldName, fieldType), fieldOffset) =>
                line(
                  s"def ${escape(fieldName)}: ${scalaType(fieldType)} = !struct.at($fieldOffset).asInstanceOf[Ptr[${scalaType(fieldType)}]]"
                )
            }
          end if
        }
      else line(s"given _tag: Tag[$structName] = Tag.materializeCStruct0Tag")
      end if
    }
  end struct

  case class error(msg: String) extends Exception(msg)

  def deRecurse(struct: Def.Struct): (Def.Struct, Set[String]) =
    val structType = CType.Struct(struct.fields.map(_._2).toList)
    val structName = struct.name

    def referencesThis(typ: CType): Boolean =
      import CType.*
      typ match
        case Pointer(Typedef(`structName`))   => true
        case Pointer(RecordRef(`structName`)) => true
        case _                                => false

    def selfReferential(typ: CType): Boolean =
      import CType.*
      typ match
        case Typedef(`structName`)   => true
        case RecordRef(`structName`) => true
        case _                       => false

    val isPointerRecursive: Boolean =
      struct.fields.map(_._2).exists(referencesThis)

    val isRecursive = struct.fields.map(_._2).exists(selfReferential)

    if isRecursive then
      throw error(
        s"struct '${struct.name}' is self-referential, and I don't know how to de-recurse it"
      )

    if !isPointerRecursive then (struct, Set.empty)
    else
      val rewrite = struct.fields.collect {
        case (name, typ) if referencesThis(typ) => name
      }

      val newfields = struct.fields.map {
        case (name, typ) if referencesThis(typ) =>
          name -> CType.Pointer(CType.Void)
        case other => other
      }

      struct.copy(newfields) -> rewrite.toSet

    end if
  end deRecurse

  def function(model: Def.Function, line: Appender)(using
      AliasResolver,
      Config
  ) =
    import model.*

    val arglist = parameters
      .map((name, ctype) => s"${escape(name)}: ${scalaType(ctype)}")
      .mkString(", ")
    if isIllegalFunction(
        model.returnType,
        model.parameters.toList.map(_._2)
      )
    then
      line(
        "// this function will not work on Scala Native as it has direct Struct parameter or returns a struct"
      )
    line(s"def $name($arglist): ${scalaType(returnType)} = extern")

  end function

  private def scalaTag(typ: CType)(using AliasResolver): String =
    import CType.*
    typ match
      case model @ Struct(fields) if fields.size <= 22 =>
        val paramTypes = model.fields.map(scalaType).mkString(", ")
        s"Tag.materializeCStruct${model.fields.size}Tag[$paramTypes]"

      case struct @ Struct(fields) =>
        scalaTag(Arr(CType.Byte, Some(staticSize(struct).toInt)))

      case union @ Union(fields) =>
        scalaTag(Arr(CType.Byte, Some(staticSize(union).toInt)))

      case n: NumericIntegral =>
        import IntegralBase.*
        import SignType.*
        val base = n.base match
          case Char            => "Byte"
          case Int             => "Int"
          case Long | LongLong => "Long"
          case Short           => "Short"

        val sign = n.sign match
          case Unsigned => "U"
          case _        => ""

        s"Tag.$sign$base"
      case Typedef(n) => s"$n._tag"

      case RecordRef(n) => s"$n._tag"
      case Function(ret, params) =>
        val paramTypes =
          (params.map(_.of) ++ List(ret))
        val paramTypesRendered = paramTypes.map(scalaType).mkString(", ")
        s"Tag.materializeCFuncPtr${paramTypes.size - 1}[$paramTypesRendered]"

      case n: NumericReal =>
        n.base match
          case FloatingBase.Float => "Tag.Float"
          case _                  => "Tag.Double"

      case Pointer(Void) => s"Tag.Ptr(Tag.Byte)"

      case Pointer(of) =>
        s"Tag.Ptr[${scalaType(of)}](${scalaTag(of)})"

      case Arr(tpe, Some(n)) =>
        s"Tag.CArray[${scalaType(tpe)}, ${natDigits(n)}](${scalaTag(tpe)}, ${natDigitsTag(n)})"
      case Void => s"Tag.Unit"
    end match
  end scalaTag

  private def scalaType(typ: CType)(using AliasResolver): String =
    import CType.*
    typ match
      case Typedef(name)   => name
      case RecordRef(name) => name
      case Pointer(to) =>
        to match
          case Void       => "Ptr[Byte]" // there's no void type on SN
          case CType.Byte => "CString"
          case other      => s"Ptr[${scalaType(other)}]"
      case NumericReal(base) =>
        base match
          case FloatingBase.Float      => "Float"
          case FloatingBase.Double     => "Double"
          case FloatingBase.LongDouble => "Double"
      case NumericIntegral(base, signType) =>
        import IntegralBase.*
        import SignType.*
        val bs =
          base match
            case Char     => "Char"
            case Short    => "Short"
            case Int      => "Int"
            case Long     => "LongInt"
            case LongLong => "LongLong"

        val prefix = signType match
          case Signed   => "C"
          case Unsigned => "CUnsigned"

        prefix + bs
      case Function(ret, params) =>
        val args = params.size
        val types =
          (params.map(_.of) ++ List(ret))
            .map(scalaType)
            .mkString("[", ", ", "]")
        s"CFuncPtr$args$types"

      case at @ Struct(fields) =>
        if fields.size > 22 then
          s"CArray[Byte, ${natDigits(staticSize(at).toInt)}]"
        else if fields.nonEmpty then
          val parameters = fields.map(scalaType).mkString("[", ", ", "]")
          s"CStruct${fields.size}$parameters"
        else "CStruct0"

      case at @ Union(fields) =>
        s"CArray[Byte, ${natDigits(staticSize(at).toInt)}]"

      case Arr(of, size) =>
        size match
          case Some(cnt) => s"CArray[${scalaType(of)}, ${natDigits(cnt)}]"
          case None      => s"Ptr[${scalaType(of)}]"

      case Void =>
        "Unit"

    end match
  end scalaType

  import scala.scalanative.unsafe.*
  import scalanative.unsigned.*

  @alwaysinline def align(
      offset: CSize,
      alignment: CSize
  ) =
    val alignmentMask = alignment - 1.toULong
    val zeroUL = 0.toULong
    val padding =
      if (offset & alignmentMask) == zeroUL then zeroUL
      else alignment - (offset & alignmentMask)
    offset + padding
  end align

  def offsets(typ: CType.Struct)(using AliasResolver): List[ULong] =
    def accumulate(fields: List[CType]) =
      var res = 0.toULong
      fields.dropRight(1).foreach { typ =>
        res = align(res, alignment(typ)) + staticSize(typ)
      }
      align(res, alignment(fields.last))

    typ.fields.zipWithIndex.map { case (fieldTyp, idx) =>
      if idx == 0 then align(0.toULong, alignment(fieldTyp))
      else accumulate(typ.fields.take(idx + 1))
    }
  end offsets

  def alignment(typ: CType)(using AliasResolver): CSize =
    import CType.*
    typ match
      case integral: NumericIntegral => staticSize(integral)
      case real: NumericReal         => staticSize(real)
      case Arr(of, Some(_))          => alignment(of)
      case Pointer(_)                => staticSize(typ)
      case Struct(fields) =>
        fields.map(alignment).maxOption.getOrElse(1.toULong)
      case Bool            => 1.toULong
      case Typedef(name)   => alignment(aliasResolver(name))
      case RecordRef(name) => alignment(aliasResolver(name))
      case Union(fields) =>
        1.toULong // TODO: are unions aligned at all?
    end match
  end alignment

  def staticSize(typ: CType)(using AliasResolver): CSize =
    import CType.*
    typ match
      case NumericIntegral(base, _) =>
        base match
          case IntegralBase.Char     => 1.toULong
          case IntegralBase.Short    => 2.toULong
          case IntegralBase.Int      => 4.toULong
          case IntegralBase.Long     => 8.toULong
          case IntegralBase.LongLong => 8.toULong
      case NumericReal(base) =>
        base match
          case FloatingBase.Float      => 4.toULong
          case FloatingBase.Double     => 8.toULong
          case FloatingBase.LongDouble => 8.toULong
      case Arr(of, Some(sz)) =>
        sz.toULong * staticSize(of)
      case Pointer(_)       => 8.toULong
      case Enum(underlying) => staticSize(underlying)
      case Struct(fields) =>
        var res = 0.toULong
        fields.foreach { typ =>
          res = align(res, alignment(typ)) + staticSize(typ)
        }

        align(res, alignment(typ))
      case Union(fields) =>
        // TODO: are unions aligned on any boundary?
        fields.map(staticSize).max
      case Typedef(name)   => staticSize(aliasResolver(name))
      case RecordRef(name) => staticSize(aliasResolver(name))

    end match
  end staticSize

  def alias(model: Def.Alias, line: Appender)(using AliasResolver, Config) =
    val underlyingType = scalaType(model.underlying)
    import CType.*
    val isOpaque = model.underlying match
      case _: Typedef | _: RecordRef | _: Function | Void => false
      case _                                              => true

    val modifier = if isOpaque then "opaque " else ""
    line(s"${modifier}type ${model.name} = $underlyingType")
    line(s"object ${model.name}: ")
    nest {
      line(s"given _tag: Tag[${model.name}] = ${scalaTag(model.underlying)}")
      if isOpaque then
        line(s"inline def apply(inline o: $underlyingType): ${model.name} = o")
    }

  end alias

  def binding(binding: Def.Binding, sb: StringBuilder)(using
      Config
  ) =
    sb.append(s"package $packageName\n\n")
    sb.append("""
      |import scala.scalanative.unsafe.*
      |import scala.scalanative.unsigned.*
      |import scalanative.libc.*
      """.stripMargin.trim)
    sb.append("\n\n")
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

    type Scope = "predef" | "aliases" | "enumerations" | "structs" | "functions"
    def define(s: Scope) = s"object $s"
    def imports(scopes: Scope*) =
      val filtered = scopes.filter {
        case "aliases"      => binding.aliases.nonEmpty
        case "enumerations" => binding.enums.nonEmpty
        case "structs"      => binding.structs.nonEmpty
        case "functions"    => binding.functions.nonEmpty
        case _              => true
      }
      s"import ${filtered.map { sc => sc + ".*" }.mkString(", ")}"

    given aliasResolver: render.AliasResolver =
      s =>
        val alias = binding.aliases.find(_.name == s).map(_.underlying)
        val struct = binding.structs
          .find(_.name == s)
          .map(_.fields.map(_._2).toList)
          .map(CType.Struct.apply)
        val union = binding.unions
          .find(_.name == s)
          .map(_.fields.map(_._2).toList)
          .map(CType.Union.apply)
        val _enum = binding.enums.find(_.name.contains(s)).flatMap(_._3)

        alias.orElse(struct).orElse(_enum).orElse(union) match
          case Some(resolved) => resolved
          case None => throw error(s"Failed to resolve aliased definition $s")

    def commentException(element: Any, exc: Throwable) =
      val stackTrace =
        exc.getStackTrace.map("//    " + _.toString).mkString("\n")
      s"""
      |// Failed to render:
      |//  $element
      |// Error:
      |//  $exc
      |$stackTrace\n
      """.stripMargin
    end commentException

    sb.append("object types:\n")
    render.nest {
      render.to(sb)("import predef.*")
      binding.enums.toList.sortBy(_.name).filter(_.name.isDefined).zipWithIndex.foreach {
        case (en, idx) =>
          try render.enumeration(
            en,
            render.to(sb)
          )
          catch exc => render.to(sb)(commentException(en, exc))
          if idx != binding.enums.size - 1 then sb.append("\n")
      }
      binding.aliases.toList.sortBy(_.name).zipWithIndex.foreach { case (en, idx) =>
        try render.alias(
          en,
          render.to(sb)
        )
        catch exc => render.to(sb)(commentException(en, exc))
        if idx != binding.aliases.size - 1 then sb.append("\n")
      }
      binding.structs.toList.sortBy(_.name).zipWithIndex.foreach { case (en, idx) =>
        try render.struct(
          en,
          render.to(sb)
        )
        catch exc => render.to(sb)(commentException(en, exc))
        if idx != binding.structs.size - 1 then sb.append("\n")
      }
      binding.unions.toList.sortBy(_.name).zipWithIndex.foreach { case (en, idx) =>
        try render.union(
          en,
          render.to(sb)
        )
        catch exc => render.to(sb)(commentException(en, exc))
        if idx != binding.unions.size - 1 then sb.append("\n")
      }
    }

    if binding.functions.nonEmpty then
      summon[Config].linkName.foreach { l =>
        sb.append(s"""@link("$l")""")
      }
      sb.append("\n@extern\nobject functions: \n")
      render.nest {
        render.to(sb)("import types.*\n")
        binding.functions.zipWithIndex.foreach { case (func, idx) =>
          try render.function(
            func,
            render.to(sb)
          )
          catch exc => System.err.println(s"Failed to render $func: $exc")
          if idx != binding.functions.size - 1 then sb.append("\n")
        }
      }
    end if
  end binding

  private def isIllegalFunction(returnType: CType, parameters: List[CType])(
      using AliasResolver
  ) =
    def isDirectStructAccess(typ: CType): Boolean =
      import CType.*
      typ match
        case _: Struct       => true
        case _: Pointer      => false
        case Typedef(name)   => isDirectStructAccess(aliasResolver(name))
        case RecordRef(name) => isDirectStructAccess(aliasResolver(name))
        case _               => false

    isDirectStructAccess(returnType) || parameters.exists(isDirectStructAccess)
  end isIllegalFunction

  private def natDigits(i: Int): String =
    if i <= 9 then s"Nat._$i"
    else
      val digits = i.toString.toIterator.toList
      val rendered = digits.map("Nat._" + _).mkString(", ")
      s"Nat.Digit${digits.size}[$rendered]"

  private def natDigitsTag(i: Int): String =
    if i <= 9 then s"Tag.Nat$i"
    else
      val digits = i.toString.toIterator.toList
      val renderedTypes = digits.map("Nat._" + _).mkString(", ")
      val renderedTags = digits.map("Tag.Nat" + _).mkString(", ")
      s"Tag.Digit${digits.size}[$renderedTypes]($renderedTags)"

  private def indent(using c: Config): String =
    (" " * (c.indentSize * c.indents))

  private def nest(f: Config ?=> Unit)(using config: Config) =
    f(using config.copy(indents = config.indents + 1))

  private def to(sb: StringBuilder)(using config: Config): Appender =
    line => sb.append(indent(using config) + line + "\n")

  private def aliasResolver(name: String)(using ar: AliasResolver): CType =
    ar(name)

  private def packageName(using conf: Config): String = conf.packageName

  type Appender = Config ?=> String => Unit
  type AliasResolver = String => CType
end render

case class Config(
    packageName: String,
    linkName: Option[String],
    indentSize: Int,
    indents: Int = 0
)
