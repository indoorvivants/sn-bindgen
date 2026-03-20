package bindgen

import bindgen.rendering.{RenderedOutput, MultiFileRender}

import scala.scalanative.unsafe.Zone
import bindgen.rendering.SingleFileRender

case class ConfiguredEnvironment(
    clang: ClangInfo,
    systemHeaderDetector: SystemHeaderDetector
)

class InteractiveDriver(config: Config, environment: ConfiguredEnvironment):
  private given Config = config

  def analyse(context: Context)(using Zone): Either[BindingError, Binding] =
    BindingGenerator.run(context, environment)

  def createBinding(context: Context, outputMode: OutputMode)(using
      Zone
  ): Either[BindingError, RenderedOutput] =
    analyse(context).map: binding =>
      given Context = context
      outputMode match
        case _: OutputMode.MultiFile => MultiFileRender(binding).render()
        case _                       => SingleFileRender(binding).render()

end InteractiveDriver

object InteractiveDriver:
  def init(using Config, Zone): Either[BindingError, InteractiveDriver] =
    val config = summon[Config]
    for clang <- clangInfo(config.systemPathDetection)
    yield InteractiveDriver(
      config,
      ConfiguredEnvironment(
        clang,
        SystemHeaderDetector(clang, config.excludeSystemPaths)
      )
    )
  end init
end InteractiveDriver
