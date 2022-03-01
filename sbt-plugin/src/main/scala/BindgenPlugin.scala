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
      val defined = bindgenBindings.value
      val destination = (Compile / sourceManaged).value
      defined
        .map(bind => destination.toPath.resolve(bind.scalaFile))
        .map(_.toGlob)
    },
    Compile / bindgenGenerateCSources / fileInputs ++= {
      val defined = bindgenBindings.value
      defined.map(_.headerFile.toPath).map(_.toGlob)
    },
    Compile / bindgenGenerateCSources / fileOutputs ++= {
      val defined = bindgenBindings.value
      val destination = (Compile / resourceManaged).value / "scala-native"
      defined
        .map(bind => destination.toPath.resolve(bind.cFile))
        .map(_.toGlob)
    },
    Compile / bindgenGenerateScalaSources := {
      val builder = new BindingBuilder(bindgenBinary.value)
      val defined = bindgenBindings.value
      val destination = (Compile / sourceManaged).value
      val report = bindgenGenerateScalaSources.inputFileChanges

      val definitely = report.created ++ report.modified

      println(report)

      builder.generate(
        defined,
        destination,
        BindingLang.Scala,
        bindgenClangInfo.value
      )
    },
    Compile / bindgenGenerateCSources := {
      val builder = new BindingBuilder(bindgenBinary.value)
      val defined = bindgenBindings.value
      val destination = (Compile / resourceManaged).value / "scala-native"

      builder
        .generate(defined, destination, BindingLang.C, bindgenClangInfo.value)
    },
    Compile / sourceGenerators += Compile / bindgenGenerateScalaSources,
    Compile / resourceGenerators += Compile / bindgenGenerateCSources
  )
}
