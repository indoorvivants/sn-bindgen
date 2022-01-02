package bindgen
package rendering

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

      line(
        s"def apply()(using Zone): Ptr[$structName] = scala.scalanative.unsafe.alloc[$structName](1)"
      )

      val applyArgList = List.newBuilder[String]
      struct.fields.map { case (n, ct) =>
        if !rewriteFields.contains(n) then
          applyArgList.addOne(s"${escape(n)}: ${scalaType(ct)}")
        else applyArgList.addOne(s"${escape(n)}: Ptr[$structName]")
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
              if !rewriteFields.contains(fieldName) then
                val typ = scalaType(fieldType)
                line(
                  s"def ${escape(fieldName)}: $typ = struct._${idx + 1}"
                )
                line(
                  s"def ${escape(fieldName + "_=")}(value: $typ): Unit = !struct.at${idx + 1} = value"
                )
              else
                val newType =
                  scalaType(CType.Pointer(CType.RecordRef(structName)))
                line(
                  s"def ${escape(fieldName)}: $newType = struct._${idx + 1}.asInstanceOf[$newType]"
                )
                line(
                  s"def ${escape(fieldName + "_=")}(value: $newType): Unit = !struct.at${idx + 1} = value.asInstanceOf[${scalaType(fieldType)}]"
                )
              end if
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
