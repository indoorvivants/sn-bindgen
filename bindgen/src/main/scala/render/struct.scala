package bindgen
package rendering

def struct(model: Def.Struct, line: Appender)(using
    c: Config,
    ar: AliasResolver
): Unit =
  val hasFlexibleArrayMember = model.fields.lastOption.collectFirst {
    case (_, CType.IncompleteArray(_)) => true
  }.isDefined

  val struct: Def.Struct =
    if hasFlexibleArrayMember then
      model.copy(fields = model.fields.dropRight(1))
    else model

  if hasFlexibleArrayMember then
    warning(
      s"Struct '${model.name}' has a Flexible Array Member, so it was dropped from the definition. " +
        "See https://github.com/indoorvivants/sn-bindgen/issues/62 for details"
    )

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
  val fieldOffsets = offsets(structType)

  if rewriteRules.nonEmpty then
    trace(
      s"Rewrite rules for struct ${struct.name}",
      rewriteRules.toSeq
        .sortBy(_._1)
        .map(_._2)
        .map(p => p.name.value -> p.newRawType)*
    )
  line(s"opaque type $structName = ${scalaType(rewrittenStructType)}")
  line(s"object $structName:")
  nest {
    struct.anonymous.foreach {
      case s: Def.Struct =>
        rendering.struct(s, line)
      case u: Def.Union =>
        rendering.union(u, line)
    }
    if struct.fields.nonEmpty then
      val fieldTypes =
        struct.fields.map(_._2).zipWithIndex.map { case (typ, idx) =>
          rewriteRules.get(idx).map(_.newRawType).getOrElse(typ)
        }
      val tag =
        s"given _tag: Tag[$structName] = ${scalaTag(rewrittenStructType)}"
      line(tag)

      line(
        s"def apply()(using Zone): Ptr[$structName] = scala.scalanative.unsafe.alloc[$structName](1)"
      )

      val applyArgList = List.newBuilder[String]
      struct.fields.zipWithIndex.map { case ((name, typ), idx) =>
        val inputType = rewriteRules.get(idx).map(_.newRichType).getOrElse(typ)
        applyArgList.addOne(s"${escape(name.value)}: ${scalaType(inputType)}")
      }

      line(
        s"def apply(${applyArgList.result.mkString(", ")})(using Zone): Ptr[$structName] = "
      )
      nest {
        line(s"val ____ptr = apply()")
        struct.fields.foreach { case (fieldName, _) =>
          line(
            s"(!____ptr).${escape(fieldName.value)} = ${escape(fieldName.value)}"
          )
        }
        line(s"____ptr")
      }

      line(s"extension (struct: $structName)")
      nest {
        if struct.fields.size <= 22 then
          struct.fields.zipWithIndex.foreach {
            case ((fieldName, fieldType), idx) =>
              rewriteRules.get(idx) match
                case Some(rewrite) =>
                  line(
                    s"def ${escape(fieldName.value)}: ${scalaType(
                      rewrite.newRichType
                    )} = struct._${idx + 1}.asInstanceOf[${scalaType(rewrite.newRichType)}]"
                  )
                  line(
                    s"def ${escape(fieldName.value + "_=")}(value: ${scalaType(rewrite.newRichType)}): Unit = !struct.at${idx + 1} = value.asInstanceOf[${scalaType(rewrite.newRawType)}]"
                  )

                case None =>
                  line(
                    s"def ${escape(fieldName.value)}: ${scalaType(fieldType)} = struct._${idx + 1}"
                  )
                  line(
                    s"def ${escape(fieldName.value + "_=")}(value: ${scalaType(fieldType)}): Unit = !struct.at${idx + 1} = value"
                  )
          }
        else
          struct.fields.zip(fieldOffsets).foreach {
            case ((fieldName, fieldType), fieldOffset) =>
              val typ = scalaType(fieldType)
              line(
                s"def ${escape(fieldName.value)}: $typ = !struct.at($fieldOffset).asInstanceOf[Ptr[$typ]]"
              )
              line(
                s"def ${escape(fieldName.value + "_=")}(value: $typ): Unit = !struct.at($fieldOffset).asInstanceOf[Ptr[$typ]] = value"
              )
          }
        end if
      }
    else line(s"given _tag: Tag[$structName] = Tag.materializeCStruct0Tag")
    end if
  }
end struct
