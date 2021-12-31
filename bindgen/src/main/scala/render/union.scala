package bindgen.rendering

import bindgen.*

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
