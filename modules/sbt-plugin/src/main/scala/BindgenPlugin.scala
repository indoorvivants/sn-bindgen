package bindgen.plugin
import java.util.Properties

import sbt.Keys.*
import sbt.nio.Keys.*
import sbt.*
import bindgen.interface.Platform
import bindgen.interface.BindingBuilder
import bindgen.interface.BindingLang
import scala.util.Try
import bindgen.interface.Binding
import scala.scalanative.sbtplugin.ScalaNativePlugin
import sbt.internal.util.ManagedLogger
import sjsonnew.JsonFormat
import bindgen.interface.LogLevel
import bindgen.interface.Includes

object BindgenPlugin extends AutoPlugin {
  object autoImport {
    val bindgenVersion = settingKey[String]("")
    val bindgenBinary = taskKey[File]("")
    val bindgenBindings = taskKey[Seq[Binding]]("")
    val bindgenGenerateScalaSources = taskKey[Seq[File]]("")
    val bindgenGenerateCSources = taskKey[Seq[File]]("")
    val bindgenClangInfo = taskKey[Platform.ClangInfo]("")
  }

  override def requires: Plugins = ScalaNativePlugin
  import ScalaNativePlugin.autoImport.nativeClang

  import autoImport.*

  private case class Config(version: String, binary: File)

  private val resolveBinaryTask =
    Def.task {
      val res = (dependencyResolution).value

      def getJars(mid: ModuleID) = {

        val depRes = (update / dependencyResolution).value
        val updc = (update / updateConfiguration).value
        val uwconfig = (update / unresolvedWarningConfiguration).value
        val modDescr = depRes.wrapDependencyInModule(mid)
        val log = (streams).value.log

        depRes
          .update(
            modDescr,
            updc,
            uwconfig,
            log
          )
          .map(_.allFiles)
          .fold(uw => throw uw.resolveException, identity)
      }

      def find(platform: Platform.Target) = {
        getJars(
          ModuleID(
            "com.indoorvivants",
            "bindgen_native0.4_3",
            bindgenVersion.value
          ).intransitive().classifier(platform.string)
        ).headOption
      }

      val file = {
        find(Platform.target) orElse
          Platform.target.fallback.flatMap(target => find(target))
      }.getOrElse(
        throw new Exception("Could not download the binary for bindgen")
      )

      file.setExecutable(true)

      file
    }

  override def projectSettings =
    Seq(Compile, Test).flatMap(conf => inConfig(conf)(definedSettings(conf)))

  val compileFilter =
    ScopeFilter(
      inProjects(ThisProject.project),
      inConfigurations(Compile) || inZeroConfiguration
    )

  val testFilter =
    ScopeFilter(inProjects(ThisProject.project), inConfigurations(Test))

  private def definedSettings(addConf: Configuration) = Seq(
    bindgenVersion := Platform.BuildInfo.version,
    bindgenBindings := Seq.empty,
    bindgenClangInfo := Platform.detectClangInfo(
      nativeClang.value.toPath
    ),
    bindgenBindings := Seq.empty,
    bindgenBinary := resolveBinaryTask.value,
    bindgenGenerateScalaSources := {
      val compile = bindgenBindings.all(compileFilter).value
      val test = bindgenBindings.all(testFilter).value

      val default = bindgenBindings.value

      val selected = if (addConf == Test) test.flatten else compile.flatten

      incremental(
        Config(bindgenVersion.value, bindgenBinary.value),
        (selected ++ default).distinct,
        (sourceManaged).value,
        BindingLang.Scala,
        bindgenClangInfo.value,
        streams.value
      )
    },
    bindgenGenerateCSources := {
      val compile = bindgenBindings.all(compileFilter).value
      val test = bindgenBindings.all(testFilter).value

      val default = bindgenBindings.value

      val selected = if (addConf == Test) test.flatten else compile.flatten

      incremental(
        Config(bindgenVersion.value, bindgenBinary.value),
        (selected ++ default).distinct,
        (resourceManaged).value / "scala-native",
        BindingLang.C,
        bindgenClangInfo.value,
        streams.value
      )
    },
    sourceGenerators += bindgenGenerateScalaSources,
    resourceGenerators += bindgenGenerateCSources
  )

  implicit object LogLevelFormat extends JsonFormat[LogLevel] {
    override def write[J](x: LogLevel, builder: sjsonnew.Builder[J]): Unit =
      builder.writeString(x.str)
    override def read[J](
        jsOpt: Option[J],
        unbuilder: sjsonnew.Unbuilder[J]
    ): LogLevel =
      jsOpt match {
        case Some(js) =>
          LogLevel(unbuilder.readString(js)).getOrElse(LogLevel.Info)
        case None => LogLevel.Info
      }
  }

  private case class InternalBinding(
      headerFile: File,
      packageName: String,
      scalaFile: String,
      cFile: String,
      linkName: Option[String],
      cImports: List[String],
      clangFlags: List[String],
      logLevel: String
  )

  private object InternalBinding {
    def convert(b: Binding): InternalBinding =
      InternalBinding(
        headerFile = b.headerFile,
        packageName = b.packageName,
        scalaFile = b.scalaFile,
        cFile = b.cFile,
        linkName = b.linkName,
        cImports = b.cImports,
        clangFlags = b.clangFlags,
        logLevel = b.logLevel.str
      )
  }

  private def incremental(
      config: Config,
      defined: Seq[Binding],
      destination: File,
      lang: BindingLang,
      ci: Platform.ClangInfo,
      streams: TaskStreams
  ): Seq[File] = {

    import config.*
    val logger = streams.log
    val builder = new BindingBuilder(binary)
    val cacheFile =
      streams.cacheDirectory / s"sn-bindgen"

    import sjsonnew.*
    import LList.:*:
    import BasicJsonProtocol.*

    implicit val configFormat: JsonFormat[Config] =
      caseClassArray(Config.apply _, Config.unapply _)

    case class Input(
        config: Config,
        hash: FilesInfo[HashFileInfo],
        configs: List[InternalBinding]
    )

    implicit val ibFormat: JsonFormat[InternalBinding] =
      caseClassArray(InternalBinding.apply _, InternalBinding.unapply _)

    implicit val inputFormat: JsonFormat[Input] =
      caseClassArray(Input.apply _, Input.unapply _)

    val tracker = Tracked.inputChanged[Input, Set[File]](cacheFile / "input") {
      (changed: Boolean, in: Input) =>
        Tracked.diffOutputs(cacheFile / "output", FileInfo.exists) {
          (outDiff: ChangeReport[File]) =>
            if (changed || outDiff.modified.nonEmpty) {
              builder.generate(defined, destination, lang, ci).toSet
            } else outDiff.checked
        }
    }

    val s: FilesInfo[HashFileInfo] =
      FileInfo.hash(defined.map(_.headerFile).toSet)

    tracker(Input(config, s, defined.map(InternalBinding.convert).toList)).toSeq
  }

  def inputs(bindings: Seq[Binding]): Seq[java.nio.file.Path] =
    bindings.map(_.headerFile.toPath)

  def outputs(
      bindings: Seq[Binding],
      destination: java.nio.file.Path,
      lang: bindgen.interface.BindingLang
  ): Seq[java.nio.file.Path] =
    bindings
      .map(bind =>
        destination.resolve(
          if (lang == BindingLang.C) bind.cFile else bind.scalaFile
        )
      )
}
