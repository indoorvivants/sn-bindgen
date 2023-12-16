package bindgen

import scala.util.boundary, boundary.break, boundary.Label
import scala.scalanative.unsafe.Zone
import bindgen.rendering.RenderedOutput
import bindgen.rendering.renderBinding

case class ConfiguredEnvironment(
    clang: ClangInfo,
    systemHeaderDetector: SystemHeaderDetector
)

class InteractiveDriver(config: Config, environment: ConfiguredEnvironment):
  private given Config = config

  def analyse(file: String)(using Zone): Either[BindingError, Binding] =
    BindingGenerator.run(file, environment)

  def createBinding(file: String, lang: Lang, outputMode: OutputMode)(using
      Zone
  ): Either[BindingError, RenderedOutput] =
    boundary:
      val binding = analyse(file).?
      Right(renderBinding(binding, lang, outputMode))
end InteractiveDriver

object InteractiveDriver:
  def init(using Config, Zone): Either[BindingError, InteractiveDriver] =
    boundary:
      val config = summon[Config]
      val clang = clangInfo(config.systemPathDetection).?

      Right(
        InteractiveDriver(
          config,
          ConfiguredEnvironment(clang, SystemHeaderDetector(clang))
        )
      )
end InteractiveDriver
