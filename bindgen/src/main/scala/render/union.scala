package bindgen
package rendering

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
      line(s"def apply()(using Zone): Ptr[$structName] = ")
      nest {
        line(s"val ___ptr = alloc[$structName](1)")
        line("___ptr")
      }
      model.fields.foreach { case (fieldName, fieldType) =>
        val typ = scalaType(fieldType)
        line(
          s"def apply(${escape(fieldName)}: $typ)(using Zone): Ptr[$structName] ="
        )
        nest {
          line(s"val ___ptr = alloc[$structName](1)")
          line(s"val un = !___ptr")
          line(
            s"un.at(0).asInstanceOf[Ptr[$typ]].update(0, ${escape(fieldName)})"
          )
          line("___ptr")
        }
      }
      line(s"extension (struct: $structName)")
      nest {
        model.fields.foreach { case (fieldName, fieldType) =>
          val typ = scalaType(fieldType)
          line(
            s"def ${escape(fieldName)}: $typ = !struct.at(0).asInstanceOf[Ptr[$typ]]"
          )
          line(
            s"def ${escape(fieldName)}_=(value: $typ): Unit = !struct.at(0).asInstanceOf[Ptr[$typ]] = value"
          )
        }
      }
    end if
  }
end union
