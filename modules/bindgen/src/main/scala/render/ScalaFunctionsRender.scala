package bindgen
package rendering

import opaque_newtypes.given

private val functionSorter = (f: GeneratedFunction.ScalaFunction) =>
  val body =
    f.body match
      case ScalaFunctionBody.Extern                    => 1
      case ScalaFunctionBody.Delegate(to, allocations) => 2
      case ScalaFunctionBody.Export(loc)               => 3

  f.name -> body

class ScalaFunctionsRenderer(
    out: LineBuilder,
    functions: Set[GeneratedFunction],
    renderMode: RenderMode,
    typeImports: TypeImports,
    exportMode: ExportMode
)(using Config, AliasResolver, Context)
    extends RenderingBase:
  def render() =
    val exported = List.newBuilder[Exported]

    val scalaExternFunctions = functions.collect {
      case f: GeneratedFunction.ScalaFunction
          if f.body == ScalaFunctionBody.Extern =>
        f
    }

    val scalaRegularFunctions = functions.collect {
      case f: GeneratedFunction.ScalaFunction
          if !scalaExternFunctions.contains(f) =>
        f
    }

    val safePackageName = packageName.split('.').last

    val hasExternFunctions = scalaExternFunctions.nonEmpty
    val hasRegularFunctions = scalaRegularFunctions.nonEmpty

    if functions.nonEmpty then
      if exportMode == ExportMode.No then

        if hasExternFunctions then
          val objectHeader = summon[Config].linkName
            .map { l =>
              s"""@link("$l")\n"""
            }
            .getOrElse("") +
            s"\n@extern\nprivate[$safePackageName] object extern_functions"
          maybeObjectBlock(out, renderMode)(objectHeader) {
            if renderMode == RenderMode.Objects then typeImports.render(out)

            exported ++= scalaExternFunctions.toList
              .sortBy(functionSorter)
              .map(f => ScalaFunctionRenderer(f, to(out), renderMode).render())
          }
        end if

        if hasRegularFunctions || hasExternFunctions then
          maybeObjectBlock(out, renderMode)(s"\nobject functions") {
            if renderMode == RenderMode.Objects then typeImports.render(out)

            if hasExternFunctions && renderMode == RenderMode.Objects then
              to(out)("import extern_functions.*")
              to(out)("export extern_functions.*")
              out.emptyLine

            exported ++= scalaRegularFunctions.toList
              .sortBy(functionSorter)
              .map(f => ScalaFunctionRenderer(f, to(out), renderMode).render())
          }
        end if
      else
        def modified(loc: ExportLocation) =
          scalaExternFunctions.toList
            .sortBy(functionSorter)
            .map { sf =>
              sf.copy(body = ScalaFunctionBody.Export(loc))
            }
            .filter { sf =>
              val isInit =
                sf.name.value == "ScalaNativeInit" && sf.returnType == CType.Int && sf.arguments.flatten.isEmpty

              if isInit then
                info(
                  "ScalaNativeInit function found in the bindings, not rendering it"
                )

              !isInit
            }

        val line = to(out)

        objectBlock(line)("trait ExportedFunctions") {
          if renderMode == RenderMode.Objects then typeImports.render(out)
          exported ++=
            modified(ExportLocation.Trait)
              .map(f => ScalaFunctionRenderer(f, to(out), renderMode).render())

        }

        maybeObjectBlock(out, renderMode)(
          s"\nobject functions extends ExportedFunctions"
        ) {
          if renderMode == RenderMode.Objects then typeImports.render(out)

          exported ++= modified(
            ExportLocation.Body(summon[Context].packageName.map(_ + ".impl"))
          ).map(f => ScalaFunctionRenderer(f, to(out), renderMode).render())
        }
      end if
    end if
    exported.result()
  end render
end ScalaFunctionsRenderer
