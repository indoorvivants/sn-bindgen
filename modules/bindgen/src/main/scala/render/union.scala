package bindgen
package rendering

import bindgen.*

def union(model: Def.Union, line: Appender)(using Config)(using
    ar: AliasResolver
): Exported =
  val unionName = model.name
  val unionType: CType.Union =
    CType.Union(model.fields.map(_._2).toList, Hints(model.staticSize))
  val tpe = scalaType(unionType)

  def setter(name: String): String =
    import Sanitation.*
    sanitise(name) match
      case Good | Escaped => name + "_="
      case Renamed(value) => value + "_="

  def getter(name: String): String =
    import Sanitation.*
    sanitise(name) match
      case Good           => name
      case Renamed(value) => value
      case Escaped        => s"`$name`"

  renderComment(line, model.meta)
  line(s"opaque type $unionName = $tpe")
  objectBlock(line)(s"object ${sanitiseBeforeColon(unionName.value)}") {
    model.anonymous.foreach {
      case s: Def.Struct =>
        rendering.struct(s, line)
      case u: Def.Union =>
        rendering.union(u, line)
    }

    val tag =
      s"given _tag: Tag[$unionName] = ${scalaTag(unionType)}"
    line(tag)

    if model.fields.nonEmpty then
      defBlock(line)(s"def apply()(using Zone): Ptr[$unionName] =") {
        line(
          s"val ___ptr = _root_.scala.scalanative.unsafe.alloc[$unionName](1)"
        )
        line("___ptr")
      }
      model.fields.foreach { case (fieldName, fieldType) =>
        val typ = scalaType(fieldType)
        val getterName = getter(fieldName.value)
        val setterName = setter(fieldName.value)
        // It's important we don't use the escape(...) function here
        line(s"@scala.annotation.targetName(\"apply_${fieldName.value}\")")
        defBlock(line)(
          s"def apply($getterName: $typ)(using Zone): Ptr[$unionName] ="
        ) {
          line(
            s"val ___ptr = _root_.scala.scalanative.unsafe.alloc[$unionName](1)"
          )
          line(s"val un = !___ptr")
          line(
            s"un.at(0).asInstanceOf[Ptr[$typ]].update(0, $getterName)"
          )
          line("___ptr")
        }
      }
      defBlock(line)(s"extension (struct: $unionName)") {
        model.fields.foreach { case (fieldName, fieldType) =>
          val getterName = getter(fieldName.value)
          val setterName = setter(fieldName.value)
          val typ = scalaType(fieldType)

          line(
            s"def $getterName : $typ = !struct.at(0).asInstanceOf[Ptr[$typ]]"
          )
          line(
            s"def $setterName(value: $typ): Unit = !struct.at(0).asInstanceOf[Ptr[$typ]] = value"
          )
        }
      }
    end if
  }
  Exported.Yes(unionName.value)
end union
