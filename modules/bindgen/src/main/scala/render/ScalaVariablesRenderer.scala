package bindgen
package rendering

class ScalaVariablesRenderer(
    out: LineBuilder,
    variables: Set[Def.Variable],
    renderMode: RenderMode,
    typeImports: TypeImports
)(using Config, AliasResolver, Context)
    extends RenderingBase:
  def render(): Seq[Exported] =
    val exported = List.newBuilder[Exported]

    if variables.nonEmpty then
      val safePackageName = packageName.split('.').last

      val objectHeader = summon[Config].linkName
        .map(l => s"""@link("$l")\n""")
        .getOrElse("") +
        "\n@extern\nobject variables"

      maybeObjectBlock(out, renderMode)(objectHeader) {
        if renderMode == RenderMode.Objects then typeImports.render(out)

        exported ++= interspeseWithNewlines(
          out,
          variables.toList.sortBy(_.name)
        ): v =>
          val linkAnnotation = Option
            .when(renderMode == RenderMode.Files)(
              summon[Config].linkName
                .map(l => s"""@link("$l") """)
            )
            .flatten
            .getOrElse("")

          val externAnnotation =
            Option.when(renderMode == RenderMode.Files)("@extern ").getOrElse("")

          renderComment(to(out), v.meta)
          to(out)(
            s"$externAnnotation${linkAnnotation}var ${escape(v.name)}: ${scalaType(v.typ)} = extern"
          )
          Exported.Var(v.name)
      }
    end if

    exported.result()
  end render
end ScalaVariablesRenderer
