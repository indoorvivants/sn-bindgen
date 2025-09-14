package bindgen

import bindgen.rendering.{RenderedOutput, renderBinding}

import scala.scalanative.unsafe.Zone
import scala.util.Using
import java.io.FileWriter

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
      config.schemaOutputFile.foreach: path =>
        import io.circe.syntax.*
        val rendered = binding.all.asJson.noSpacesSortKeys
        Using(new FileWriter(path.value)): fw =>
          fw.write(rendered)
      renderBinding(binding, outputMode)
end InteractiveDriver

object InteractiveDriver:
  def init(using Config): Either[BindingError, InteractiveDriver] =
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
