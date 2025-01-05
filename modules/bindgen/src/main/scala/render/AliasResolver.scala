package bindgen.rendering

import bindgen.*

opaque type AliasResolver = String => CType
object AliasResolver:
  extension (ar: AliasResolver) def apply(s: String) = ar(s)

  inline def apply(inline f: String => CType): AliasResolver = f

  def create(aliases: Seq[Def])(using Config): AliasResolver =
    val mapping = Map.newBuilder[String, CType]
    def go(definitions: Seq[Def]): Unit =
      definitions.foreach {
        case st @ Def.Struct(fields, name, _, staticSize, _) =>
          val typ = CType.Struct(fields.map(_._2).toList, Hints(staticSize))
          mapping += name.value -> typ
          mapping ++= traverse(st)
        case u @ Def.Union(fields, name, _, staticSize, _) =>
          val typ = CType.Struct(fields.map(_._2).toList, Hints(staticSize))
          mapping += name.value -> typ
          mapping ++= traverse(u)
        case Def.Alias(name, underlying, _) =>
          mapping += name -> underlying
        case Def.Enum(_, Some(name), Some(tp), _) =>
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

  private def traverse(st: Def.Union | Def.Struct)(using
      LoggingConfig
  ) =
    def go(
        s: Def.Union | Def.Struct | Def.Enum,
        bld: Tuple2[String, CType] => Unit,
        prepend: String = ""
    ): Unit =
      val anonymous = s match
        case u: Def.Union  => u.anonymous
        case u: Def.Struct => u.anonymous
        case e: Def.Enum   => Nil

      val thisName = prepend +
        (s match
          case u: Def.Union  => u.name.value
          case u: Def.Struct => u.name.value
          case e: Def.Enum   => e.name.get.value
        )

      s match
        case u: Def.Union =>
          bld(thisName -> Def.typeOf(u))
        case s: Def.Struct =>
          bld(thisName -> Def.typeOf(s))
        case s: Def.Enum =>
          bld(thisName -> Def.typeOf(s))

      anonymous.foreach { u =>
        go(u, bld, prepend = thisName + ".")
      }
    end go

    val bld = Map.newBuilder[String, CType]
    go(st, bld.addOne(_))
    bld.result
  end traverse
end AliasResolver
