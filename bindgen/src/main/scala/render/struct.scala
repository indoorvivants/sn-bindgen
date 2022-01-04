package bindgen
package rendering

def struct(struct: Def.Struct, line: Appender)(using Config, AliasResolver) =
  // val (struct, rewriteFields) =
  //   if (model.fields.size > 22) then (model, Set.empty[String])
  //   else hack_recursive_structs(model)
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
  // val tpe = scalaType(structType)
  if rewriteRules.nonEmpty then
    info(s"Rewrite rules for struct ${struct.name}: $rewriteRules")
  line(s"opaque type $structName = ${scalaType(rewrittenStructType)}")
  line(s"object $structName:")
  nest {
    if struct.fields.nonEmpty then
      val fieldTypes =
        struct.fields.map(_._2).zipWithIndex.map { case (typ, idx) =>
          rewriteRules.get(idx).map(_.newRawType).getOrElse(typ)
        }
      // val paramTypes = fieldTypes.map(scalaType).mkString(", ")
      val tag =
        s"given _tag: Tag[$structName] = ${scalaTag(rewrittenStructType)}"
      line(tag)

      line(
        s"def apply()(using Zone): Ptr[$structName] = scala.scalanative.unsafe.alloc[$structName](1)"
      )

      val applyArgList = List.newBuilder[String]
      struct.fields.zipWithIndex.map { case ((name, typ), idx) =>
        // if !rewriteRules.contains(idx) then
        //   applyArgList.addOne(s"${escape(name)}: ${scalaType(ct)}")
        // else
        val inputType = rewriteRules.get(idx).map(_.newRichType).getOrElse(typ)
        applyArgList.addOne(s"${escape(name)}: ${scalaType(inputType)}")
      }

      line(
        s"def apply(${applyArgList.result.mkString(", ")})(using Zone): Ptr[$structName] = "
      )
      nest {
        line(s"val ____ptr = apply()")
        struct.fields.foreach { case (n, _) =>
          line(s"(!____ptr).${escape(n)} = ${escape(n)}")
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
                    s"def ${escape(fieldName)}: ${scalaType(rewrite.newRichType)} = struct._${idx + 1}.asInstanceOf[${scalaType(rewrite.newRichType)}]"
                  )
                  line(
                    s"def ${escape(fieldName + "_=")}(value: ${scalaType(rewrite.newRichType)}): Unit = !struct.at${idx + 1} = value.asInstanceOf[${scalaType(rewrite.newRawType)}]"
                  )

                case None =>
                  line(
                    s"def ${escape(fieldName)}: ${scalaType(fieldType)} = struct._${idx + 1}"
                  )
                  line(
                    s"def ${escape(fieldName + "_=")}(value: ${scalaType(fieldType)}): Unit = !struct.at${idx + 1} = value"
                  )
            // if !rewriteFields.contains(fieldName) then
            //   val typ = scalaType(fieldType)
            //   line(
            //     s"def ${escape(fieldName)}: $typ = struct._${idx + 1}"
            //   )
            //   line(
            //     s"def ${escape(fieldName + "_=")}(value: $typ): Unit = !struct.at${idx + 1} = value"
            //   )
            // else
            //   val newType =
            //     scalaType(CType.Pointer(CType.RecordRef(structName)))
            //   line(
            //     s"def ${escape(fieldName)}: $newType = struct._${idx + 1}.asInstanceOf[$newType]"
            //   )
            //   line(
            //     s"def ${escape(fieldName + "_=")}(value: $newType): Unit = !struct.at${idx + 1} = value.asInstanceOf[${scalaType(fieldType)}]"
            //   )
            // end if
          }
        else
          struct.fields.zip(fieldOffsets).foreach {
            case ((fieldName, fieldType), fieldOffset) =>
              val typ = scalaType(fieldType)
              line(
                s"def ${escape(fieldName)}: $typ = !struct.at($fieldOffset).asInstanceOf[Ptr[$typ]]"
              )
              line(
                s"def ${escape(fieldName + "_=")}(value: $typ): Unit = !struct.at($fieldOffset).asInstanceOf[Ptr[$typ]] = value"
              )
          }
        end if
      }
    else line(s"given _tag: Tag[$structName] = Tag.materializeCStruct0Tag")
    end if
  }
end struct
