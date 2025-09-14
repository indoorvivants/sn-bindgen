package bindgen.rendering

import bindgen.*

opaque type AliasResolver = String => CType
object AliasResolver:
  extension (ar: AliasResolver) def apply(s: String) = ar(s)

  inline def apply(inline f: String => CType): AliasResolver = f

  def create(aliases: Seq[CDefinition])(using Config): AliasResolver =
    val mapping = Map.newBuilder[String, CType]
    def go(definitions: Seq[CDefinition]): Unit =
      definitions.foreach {
        case st @ CDefinition.Struct(fields, name, _, staticSize, _) =>
          val typ = CType.Struct(fields.map(_._2).toList, Hints(staticSize))
          mapping += name.value -> typ
          mapping ++= traverse(st)
        case u @ CDefinition.Union(fields, name, _, staticSize, _) =>
          val typ = CType.Struct(fields.map(_._2).toList, Hints(staticSize))
          mapping += name.value -> typ
          mapping ++= traverse(u)
        case CDefinition.Alias(name, underlying, _) =>
          mapping += name -> underlying
        case CDefinition.Enum(_, Some(name), Some(tp), _) =>
          mapping += name.value -> tp
        case _ =>
      }

    go(aliases)

    trace("Aliases:", mapping.result().toSeq)

    val result = mapping.result()

    apply(s =>
      result
        .getOrElse(s, throw Error(s"Failed to resolve aliased definition $s"))
    )

  end create

  private def traverse(st: CDefinition.Union | CDefinition.Struct)(using
      LoggingConfig
  ) =
    def go(
        s: CDefinition.Union | CDefinition.Struct | CDefinition.Enum,
        bld: Tuple2[String, CType] => Unit,
        prepend: String = ""
    ): Unit =
      val anonymous = s match
        case u: CDefinition.Union  => u.anonymous
        case u: CDefinition.Struct => u.anonymous
        case e: CDefinition.Enum   => Nil

      val thisName = prepend +
        (s match
          case u: CDefinition.Union  => u.name.value
          case u: CDefinition.Struct => u.name.value
          case e: CDefinition.Enum   => e.name.get.value
        )

      s match
        case u: CDefinition.Union =>
          bld(thisName -> CDefinition.typeOf(u))
        case s: CDefinition.Struct =>
          bld(thisName -> CDefinition.typeOf(s))
        case s: CDefinition.Enum =>
          bld(thisName -> CDefinition.typeOf(s))

      anonymous.foreach { u =>
        go(u, bld, prepend = thisName + ".")
      }
    end go

    val bld = Map.newBuilder[String, CType]
    go(st, bld.addOne(_))
    bld.result
  end traverse
end AliasResolver
