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

object BindgenPlugin extends AutoPlugin {
  object autoImport {
    val bindgenVersion = settingKey[String]("")
    val bindgenBinary = taskKey[File]("")
    val bindgenBindings = settingKey[Seq[Binding]]("")
    val bindgenGenerateScalaSources = taskKey[Seq[File]]("")
    val bindgenGenerateCSources = taskKey[Seq[File]]("")
    val bindgenClangInfo = taskKey[Platform.ClangInfo]("")
  }

  override def requires: Plugins = ScalaNativePlugin
  import ScalaNativePlugin.autoImport.nativeClang

  import autoImport.*

  override def projectSettings = Seq(
    bindgenVersion := Platform.BuildInfo.version,
    bindgenBindings := Seq.empty,
    bindgenClangInfo := Platform.detectClangInfo(nativeClang.value.toPath),
    bindgenBinary := {
      val res = dependencyResolution.value
      def getJars(mid: ModuleID) = {

        val depRes = (update / dependencyResolution).value
        val updc = (update / updateConfiguration).value
        val uwconfig = (update / unresolvedWarningConfiguration).value
        val modDescr = depRes.wrapDependencyInModule(mid)

        depRes
          .update(
            modDescr,
            updc,
            uwconfig,
            streams.value.log
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

    },
    Compile / bindgenGenerateScalaSources / fileInputs ++= {
      val defined = bindgenBindings.value
      defined.map(_.headerFile.toPath).map(_.toGlob)
    },
    Compile / bindgenGenerateScalaSources / fileOutputs ++= {
      outputs(
        bindgenBindings.value,
        (Compile / sourceManaged).value.toPath,
        BindingLang.Scala
      ).map(_.toGlob)
    },
    Compile / bindgenGenerateCSources / fileInputs ++= {
      val defined = bindgenBindings.value
      defined.map(_.headerFile.toPath).map(_.toGlob)
    },
    Compile / bindgenGenerateCSources / fileOutputs ++= {
      outputs(
        bindgenBindings.value,
        ((Compile / resourceManaged).value / "scala-native").toPath,
        BindingLang.C
      ).map(_.toGlob)
    },
    Compile / bindgenGenerateScalaSources := {
      incremental(
        bindgenBinary.value,
        bindgenBindings.value,
        (Compile / sourceManaged).value,
        BindingLang.Scala,
        bindgenClangInfo.value,
        bindgenGenerateScalaSources.inputFileChanges,
        streams.value.log
      )
    },
    Compile / bindgenGenerateCSources := {
      incremental(
        bindgenBinary.value,
        bindgenBindings.value,
        (Compile / resourceManaged).value / "scala-native",
        BindingLang.C,
        bindgenClangInfo.value,
        bindgenGenerateCSources.inputFileChanges,
        streams.value.log
      )
    },
    Compile / sourceGenerators += Compile / bindgenGenerateScalaSources,
    Compile / resourceGenerators += Compile / bindgenGenerateCSources
  )

  def incremental(
      binary: File,
      defined: Seq[Binding],
      destination: File,
      lang: BindingLang,
      ci: Platform.ClangInfo,
      report: FileChanges,
      logger: Logger
  ) = {
    val builder = new BindingBuilder(binary)
    val definitely = report.created ++ report.modified
    val out = outputs(defined, destination.toPath, lang)
    val in = inputs(defined)
    val mapping =
      defined
        .zip(in)
        .zip(out)

    val toRebuild = Seq.newBuilder[Binding]
    val unchangedOuts = Seq.newBuilder[File]

    mapping.foreach {
      case ((binding, in), out) if !out.toFile.exists() =>
        logger.debug(
          s"(BINDGEN $lang) regenerating $in because it was either created or modified"
        )
        toRebuild += binding
      case ((binding, in), _) if definitely.contains(in) =>
        logger.debug(
          s"(BINDGEN $lang) regenerating $in because output was removed"
        )
        toRebuild += binding
      case ((_, in), out) if !report.deleted.contains(in) =>
        logger.debug(
          s"(BINDGEN $lang) $in not changed, not regenerating"
        )
        unchangedOuts += out.toFile

      case ((_, in), out) =>
        logger.debug(
          s"(BINDGEN $lang) $in was deleted, so stop tracking it"
        )

    }

    builder.generate(toRebuild.result(), destination, lang, ci) ++
      unchangedOuts.result()
  }

  def inputs(bindings: Seq[Binding]) = bindings.map(_.headerFile.toPath)
  def outputs(
      bindings: Seq[Binding],
      destination: java.nio.file.Path,
      lang: bindgen.interface.BindingLang
  ) =
    bindings
      .map(bind =>
        destination.resolve(
          if (lang == BindingLang.C) bind.cFile else bind.scalaFile
        )
      )
}
