package bindgen
package rendering

def struct(struct: Def.Struct, line: Appender)(using
    c: Config,
    ar: AliasResolver
): Exported =
  val rewriteRules = hack_recursive_structs(struct)
  val structName = struct.name
  val structType: CType.Struct = CType.Struct(struct.fields.map(_._2).toList)
  val rewrittenStructType: CType.Struct = CType.Struct(
    struct.fields
      .map(_._2)
      .zipWithIndex
      .map { case (typ, idx) =>
        rewriteRules.get(idx).map(_.newRawType).getOrElse(typ)
      }
      .toList
  )

  val madeOpaque = c.rendering.matches(_.opaqueStruct)(structName.value)

  val structIsOpaque =
    if struct.fields.size > 22 then true
    else if struct.fields.size == 0 then false
    else
      madeOpaque match
        case None => false
        case Some(value) =>
          warning(
            s"${structName.value} will be rendered as a static array, as requested by '$value' filter"
          )
          true

  info(s"Size: ${struct.meta.staticSize}")
  val finalStructType =
    if structIsOpaque then
      struct.meta.staticSize
        .map(sz => CType.Arr(CType.Byte, Some(sz)))
        .getOrElse(structArrayType(rewrittenStructType))
    else rewrittenStructType

  def setter(name: String): String =
    import Sanitation.*
    sanitise(name) match
      case Good | Escaped if structIsOpaque && name == "length" =>
        "_length_="
      case Good | Escaped => name + "_="
      case Renamed(value) => value + "_="

  def getter(name: String): String =
    import Sanitation.*
    sanitise(name) match
      case Good | Escaped if structIsOpaque && name == "length" =>
        warning(
          s"Struct ${structName.value} has its `length` parameter renamed as `_length` because it's rewritten as CArray"
        )
        "_length"

      case Good           => name
      case Renamed(value) => value
      case Escaped        => s"`$name`"
    end match
  end getter

  if rewriteRules.nonEmpty then
    trace(
      s"Rewrite rules for struct ${struct.name}",
      rewriteRules.toSeq
        .sortBy(_._1)
        .map(_._2)
        .map(p => p.name.value -> p.newRawType)
    )

  renderComment(line, struct.meta)
  line(s"opaque type $structName = ${scalaType(finalStructType)}")
  line(s"object ${sanitiseBeforeColon(structName.value)}:")
  nest {
    struct.anonymous.foreach {
      case s: Def.Struct =>
        rendering.struct(s, line)
      case u: Def.Union =>
        rendering.union(u, line)
      case e: Def.Enum =>
        rendering.enumeration(e, line)
    }
    if struct.fields.nonEmpty then
      val fieldTypes =
        struct.fields.map(_._2).zipWithIndex.map { case (typ, idx) =>
          rewriteRules.get(idx).map(_.newRawType).getOrElse(typ)
        }
      val tag =
        s"given _tag: Tag[$structName] = ${scalaTag(finalStructType)}"
      line(tag)

      line(
        s"def apply()(using Zone): Ptr[$structName] = scala.scalanative.unsafe.alloc[$structName](1)"
      )

      val namedFieldsWithIndex =
        struct.fields.zipWithIndex.toVector
      val namedFields = namedFieldsWithIndex.map(_._1)

      val applyArgList = List.newBuilder[String]

      namedFieldsWithIndex.map { case ((name, typ), idx) =>
        if name.value.nonEmpty then
          val inputType =
            rewriteRules.get(idx).map(_.newRichType).getOrElse(typ)
          applyArgList.addOne(
            s"${getter(name.value)} : ${scalaType(inputType)}"
          )
      }

      val ignored = c.rendering.matches(_.noConstructor)(structName.value)

      ignored match
        case None =>
          line(
            s"def apply(${applyArgList.result.mkString(", ")})(using Zone): Ptr[$structName] = "
          )
          nest {
            line(s"val ____ptr = apply()")
            namedFields.filter(_._1.value.nonEmpty).foreach {
              case (fieldName, _) =>
                line(
                  s"(!____ptr).${getter(fieldName.value)} = ${getter(fieldName.value)}"
                )
            }
            line(s"____ptr")
          }
        case Some(v) =>
          warning(
            s"Not rendering the constructor for ${structName.value}, as requested by '$v' filter"
          )
      end match

      line(s"extension (struct: $structName)")
      nest {
        if !structIsOpaque then
          namedFieldsWithIndex.filter(_._1._1.value.nonEmpty).foreach {
            case ((fieldName, fieldType), idx) =>
              val setterName = setter(fieldName.value)
              val getterName = getter(fieldName.value)

              rewriteRules.get(idx) match
                case Some(rewrite) =>
                  val typ = scalaType(rewrite.newRichType)
                  line(
                    s"def $getterName : $typ = struct._${idx + 1}.asInstanceOf[$typ]"
                  )
                  line(
                    s"def $setterName(value: $typ): Unit = !struct.at${idx + 1} = value.asInstanceOf[${scalaType(rewrite.newRawType)}]"
                  )

                case None =>
                  val typ = scalaType(fieldType)
                  line(
                    s"def $getterName : $typ = struct._${idx + 1}"
                  )
                  line(
                    s"def $setterName(value: $typ): Unit = !struct.at${idx + 1} = value"
                  )
              end match
          }
        else
          namedFieldsWithIndex.filter(_._1._1.value.nonEmpty).foreach {
            case ((fieldName, fieldType), fieldOffset) =>
              val typ = scalaType(fieldType)
              val setterName = setter(fieldName.value)
              val getterName = getter(fieldName.value)

              line(
                s"def $getterName: $typ = !struct.at($fieldOffset).asInstanceOf[Ptr[$typ]]"
              )
              line(
                s"def $setterName(value: $typ): Unit = !struct.at($fieldOffset).asInstanceOf[Ptr[$typ]] = value"
              )
          }
        end if

      }
      if structIsOpaque then
        line("val offsets: Array[Int] = ")
        nest {
          line(s"val res = Array.ofDim[Int](${namedFieldsWithIndex.length})")

          alignMethod.foreach(line(_))
          line("")
          namedFieldsWithIndex.foreach { case ((_, fieldType), idx) =>
            val tpe = scalaType(fieldType)
            if idx == 0 then line(s"res(0) = align(0, alignmentof[$tpe].toInt)")
            else
              val prevTpe = scalaType(namedFieldsWithIndex(idx - 1)._1._2)
              line(
                s"res($idx) = align(res(${idx - 1}) + sizeof[$prevTpe].toInt, alignmentof[$tpe].toInt)"
              )

          }
          line("res")
        }

        line("end offsets")
      end if
    else line(s"given _tag: Tag[$structName] = Tag.materializeCStruct0Tag")
    end if

  }

  Exported.Yes(structName.value)
end struct

private val alignMethod =
  """
def align(offset: Int, alignment: Int) = {
  val alignmentMask = alignment - 1
  val padding =
    if ((offset & alignmentMask) == 0) 0
    else alignment - (offset & alignmentMask)
  offset + padding
}
""".trim().linesIterator
