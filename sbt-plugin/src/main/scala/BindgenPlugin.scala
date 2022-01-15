package bindgen.plugin
import java.util.Properties

import sbt.Keys.*
import sbt.*
import bindgen.interface.Platform
import bindgen.interface.BindingBuilder
import bindgen.interface.BindingLang
import scala.util.Try

object BindgenPlugin extends AutoPlugin {
  object autoImport {
    object Bindgen {
      val generatorVersion = settingKey[String]("")
      val binary = taskKey[File]("")
      val bindings = taskKey[BindingBuilder => BindingBuilder]("")
    }
  }

  import autoImport.*

  override def projectSettings = Seq(
    Bindgen.generatorVersion := Platform.BuildInfo.version,
    Bindgen.bindings := identity,
    Bindgen.binary := {
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
            Bindgen.generatorVersion.value
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
    Compile / sourceGenerators += Def.task {
      val builder = new BindingBuilder(Bindgen.binary.value)
      val defined = Bindgen.bindings.value.apply(builder)
      val destination = (Compile / sourceManaged).value

      defined.generate(destination, BindingLang.Scala)
    },
    Compile / resourceGenerators += Def.task {
      val builder = new BindingBuilder(Bindgen.binary.value)
      val defined = Bindgen.bindings.value.apply(builder)
      val destination = (Compile / resourceManaged).value / "scala-native"

      defined.generate(destination, BindingLang.C)
    }
  )
}
