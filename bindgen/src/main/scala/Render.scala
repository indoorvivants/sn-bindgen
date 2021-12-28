package bindgen

import bindgen.Def.Binding

object render:
  def enumeration(model: Def.Enum, line: Appender)(using
      Config
  ) =
    val values = List.newBuilder[(String, String)]
    val opaqueType = model.name
    val finalizer = if model.values.nonEmpty then ":" else ""
    val numericType = model.intType.getOrElse(CType.Int)
    val enumSuffix = if numericType.sign == SignType.Unsigned then "U" else ""
    val underlyingTypeRender = scalaType(numericType)
    line(s"opaque type $opaqueType = $underlyingTypeRender")
    line(s"object $opaqueType extends CEnum$enumSuffix[$opaqueType]$finalizer")

    nest {
      if numericType.sign == SignType.Signed then
        line(s"inline def define(inline a: $underlyingTypeRender): $opaqueType = a")
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

  def struct(model: Def.Struct, line: Appender)(using Config) =
    val structName = model.name
    val tpe = scalaType(CType.Struct(model.fields.map(_._2).toList))
    line(s"opaque type $structName = $tpe")
    line(s"object $structName:")
    nest {
      line(s"extension (struct: $structName)")
      nest {
        model.fields.zipWithIndex.foreach {
          case ((fieldName, fieldType), idx) =>
            line(
              s"def $fieldName: ${scalaType(fieldType)} = struct._${idx + 1}"
            )
        }
      }
    }
  end struct

  def scalaType(typ: CType)(using Config): String =
    import CType.*
    typ match
      case Typedef(name) => name
      case Pointer(to) =>
        to match
          case Void  => "Ptr[Byte]" // there's no void type on SN
          case other => s"Ptr[${scalaType(other)}]"
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

      case Struct(fields) =>
        s"CStruct${fields.size}[${fields.map(scalaType).mkString(", ")}]"

      case Arr(of, size) =>
        size match
          case Some(cnt) => s"CArray[${scalaType(of)}, ${natDigits(cnt)}]"
          case None      => s"Ptr[${scalaType(of)}]"

      case Void =>
        "void"

    end match
  end scalaType

  def binding(packageName: String, binding: Def.Binding, sb: StringBuilder)(
      using Config
  ) =
    sb.append(s"package $packageName\n")
    sb.append("""
      |import scala.scalanative.unsafe.*
      |import scala.scalanative.unsigned.*
      |import scalanative.libc.*
      """.stripMargin.trim)
    sb.append("\n")
    sb.append("object predef:")
    render.nest {
      val predef = """
      |
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
      binding.enums.zipWithIndex.foreach { case (en, idx) =>
        try render.enumeration(
          en,
          render.to(sb)
        )
        catch exc => System.err.println(s"Failed to render $en: $exc")
        if idx != binding.enums.size - 1 then sb.append("\n")
      }
    }

    sb.append("object structs:\n")
    render.nest {
      render.to(sb)("import predef.*, enumerations.*")

      binding.structs.zipWithIndex.foreach { case (en, idx) =>
        try render.struct(
          en,
          render.to(sb)
        )
        catch exc => System.err.println(s"Failed to render $en: $exc")
        if idx != binding.structs.size - 1 then sb.append("\n")
      }
    }
  end binding

  private def natDigits(i: Int): String =
    if i <= 9 then s"Nat._$i"
    else
      val digits = i.toString.iterator.toList.map("_" + _).mkString(", ")
      s"Nat.Digit${digits.size}[$digits]"

  private def indent(using c: Config): String =
    (" " * (c.indentSize * c.indents))

  private def nest(f: Config ?=> Unit)(using config: Config) = f(using
    Config(config.indentSize, indents = config.indents + 1)
  )

  private def to(sb: StringBuilder)(using config: Config): Appender =
    line => sb.append(indent(using config) + line + "\n")

  type Appender = Config ?=> String => Unit
end render

case class Config(indentSize: Int = 2, indents: Int = 0)
