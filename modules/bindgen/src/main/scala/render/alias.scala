package bindgen
package rendering

import bindgen.*
import scala.scalanative.unsafe.CFuncPtr
import util.chaining.*

import CType.*

def alias(model: Def.Alias, line: Appender)(using
    AliasResolver,
    Config
): Exported =
  val (underlyingType, enableConstructor) =
    model.underlying match
      case Pointer(Reference(Name.Unnamed)) =>
        Pointer(CType.Struct(Nil)) -> false
      case other => other -> true

  import CType.*
  val isOpaque = underlyingType match
    case _: Reference | _: Function | Void => false
    case _                                 => true

  val underlyingFunction = underlyingType match
    case Pointer(f: Function) => Some(f)
    case _                    => None

  val modifier = if isOpaque then "opaque " else ""
  renderComment(line, model.meta)
  line(s"${modifier}type ${model.name} = ${scalaType(underlyingType)}")
  line(s"object ${sanitiseBeforeColon(model.name)}: ")
  nest {
    model.underlying match
      case Reference(Name.BuiltIn(name)) =>
        line(s"val _tag: Tag[${model.name}] = summon[Tag[${name.full}]]")
      case _ =>
        line(s"given _tag: Tag[${model.name}] = ${scalaTag(underlyingType)}")

    if underlyingFunction.isDefined then
      line(
        s"inline def fromPtr(ptr: Ptr[Byte]): ${model.name} = CFuncPtr.fromPtr(ptr)"
      )
    end if

    val renderedUnderlyingType = scalaType(underlyingType)

    if enableConstructor then
      line(
        s"inline def apply(inline o: ${renderedUnderlyingType}): ${model.name} = o"
      )
      line(s"extension (v: ${model.name})")
      nest {
        line(s"inline def value: ${renderedUnderlyingType} = v")
        underlyingFunction.foreach: func =>
          line(s"inline def toPtr: Ptr[Byte] = CFuncPtr.toPtr(v)")
          val returnType = scalaType(func.returnType)
          val params = List.newBuilder[String]
          val arguments = List.newBuilder[String]
          var counter = 0
          def newName =
            s"_$counter".tap(_ => counter += 1)


          func.parameters.foreach:
            case Parameter(name, of) =>
              val formalName =
                name match
                  case None        => newName
                  case Some(value) => value.value

              params += s"$formalName: ${scalaType(of)}"
              arguments += formalName

          val parametersList = params.result().mkString(", ")
          val argumentsList = arguments.result().mkString(", ")

          line(s"inline def apply(${parametersList}): $returnType = ") 
          nest:
            line(s"v.apply($argumentsList)")

      }
    end if
  }

  Exported.Yes(model.name)

end alias
