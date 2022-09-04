import scala.scalanative.build.GC
import _root_.bindgen.interface.Platform.OS.*
import _root_.bindgen.interface.Platform.ClangInfo
import _root_.bindgen.interface.Binding
import coursierapi.ResolutionParams
import coursierapi.Repository
import sbt.io.Using
import java.util.stream.Collectors
import java.nio.file.Files
import scala.scalanative.build.Mode
import scala.scalanative.build.NativeConfig
import scala.scalanative.build.LTO
import commandmatrix.extra.*

import _root_.bindgen.interface.{
  BindingBuilder,
  BindingLang,
  LogLevel,
  Platform
}
import java.nio.file.Paths

lazy val Versions = new {
  val decline = "2.3.0"
  val scalaNative = nativeVersion
  val junit = "0.13.3"
  val scalameta = "4.5.13"
  val b2s = "0.3.16"
  val pluginTargetSN = "0.4.6"
  val pluginTargetSBT = "1.6.1"

  val Scala3 = "3.1.3"
  val Scala212 = "2.12.16"
  val Scala213 = "2.13.8"
  val Scala2 = List(Scala212, Scala213)

}

inThisBuild(
  Seq(
    organization := "com.indoorvivants",
    organizationName := "Anton Sviridov",
    homepage := Some(url("https://github.com/indoorvivants/sn-bindgen")),
    startYear := Some(2022),
    licenses := List(
      "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")
    ),
    developers := List(
      Developer(
        "keynmol",
        "Anton Sviridov",
        "velvetbaldmime@protonmail.com",
        url("https://blog.indoorvivants.com")
      )
    )
  )
)

// --------------MODULES-------------------------
lazy val root = project
  .in(file("."))
  .aggregate(bindgen, libclang)
  .aggregate(iface.projectRefs*)
  .aggregate(plugin.projectRefs*)
  .aggregate(tests)
  .settings(
    publish / skip := true,
    publishLocal / skip := true
  )

lazy val iface = projectMatrix
  .in(file("modules/interface"))
  .someVariations(
    Versions.Scala2 :+ Versions.Scala3,
    List(VirtualAxis.jvm) // todo may be publish native interfaces as well
  )(MatrixAction.ForScala(_.isScala2).Settings(scalacOptions += "-Xsource:3"))
  .settings(
    moduleName := "bindgen-interface",
    libraryDependencies += "com.github.sbt" % "junit-interface" % Versions.junit % Test,
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-s", "-v"),
    Test / fork := true,
    Test / envVars += "BINARY" -> (bindgen / Compile / nativeLink).value.toString,
    Test / envVars += "BINDGEN_CLANG_PATH" -> (bindgen / Compile / nativeClang).value.toString,
    Compile / resourceGenerators += Def.task {
      val out =
        (Compile / managedResourceDirectories).value.head / "sn-bindgen.properties"

      val props = new java.util.Properties()

      props.setProperty("sn-bindgen.version", version.value)

      IO.write(props, "SN bindgen properites file", out)

      List(out)
    }
  )

lazy val bindgen = project
  .in(file("modules/bindgen"))
  .dependsOn(libclang)
  .enablePlugins(ScalaNativePlugin, ScalaNativeJUnitPlugin)
  .settings(nativeCommon)
  .settings(Compile / nativeConfig ~= environmentConfiguration)
  .settings(nativeConfig ~= usesLibClang)
  .settings(Test / nativeConfig ~= usesLibClang)
  .settings(clangDetection)
  .settings(
    moduleName := "bindgen",
    libraryDependencies += ("com.monovore" %%% "decline" % Versions.decline cross CrossVersion.for3Use2_13)
      .excludeAll(ExclusionRule("org.scala-native")),
    libraryDependencies += compilerPlugin(
      "org.polyvariant" % "better-tostring" % Versions.b2s cross CrossVersion.full
    ),
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-s", "-v")
  )
  .settings {
    val detected = detectBinaryArtifacts
    detected
      .map { case (_, (artifact, file)) =>
        addArtifact(Def.setting(artifact), Def.task(file))
      }
      .toSeq
      .flatten
  }

lazy val binaryArtifacts = project
  .in(file("build/binary-artifacts"))
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)
  .settings(
    packageBin / publishArtifact := false,
    packageDoc / publishArtifact := false,
    packageSrc / publishArtifact := false,
    moduleName := "bindgen"
  )
  .settings {
    val detected = detectBinaryArtifacts
    detected
      .map { case (_, (artifact, file)) =>
        addArtifact(Def.setting(artifact), Def.task(file))
      }
      .toSeq
      .flatten
  }

lazy val localBindgenArtifact = project
  .in(file("local-bindgen"))
  .enablePlugins(ScalaNativePlugin)
  .dependsOn(bindgen, libclang)
  .settings(nativeCommon)
  .settings(
    packageBin / publishArtifact := false,
    packageDoc / publishArtifact := false,
    packageSrc / publishArtifact := false,
    moduleName := "bindgen"
  )
  .settings {

    def build(classifier: String) =
      Artifact("bindgen", classifier)
        .withExtension("jar")
        .withType("jar")
        .withConfigurations(Vector(Compile))
    addArtifact(
      Def.setting(build(Platform.target.string)),
      Def.task { (bindgen / Compile / nativeLink).value }
    )
  }

lazy val plugin = projectMatrix
  .in(file("modules/sbt-plugin"))
  .defaultAxes(VirtualAxis.scalaABIVersion(Versions.Scala212), VirtualAxis.jvm)
  .allVariations(List(Versions.Scala212), List(VirtualAxis.jvm))
  .dependsOn(iface)
  .settings(
    sbtPlugin := true,
    addSbtPlugin(
      "org.scala-native" % "sbt-scala-native" % Versions.pluginTargetSN
    ),
    pluginCrossBuild / sbtVersion := Versions.pluginTargetSBT,
    moduleName := "bindgen-sbt-plugin",
    scriptedLaunchOpts := {
      scriptedLaunchOpts.value ++
        Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
    },
    scriptedBufferLog := false,
    publishLocal := publishLocal
      .dependsOn(
        localBindgenArtifact / publishLocal
      )
      .value
  )
  .enablePlugins(ScriptedPlugin, SbtPlugin)

lazy val libclang = project
  .in(file("modules/libclang"))
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)
  .settings(clangDetection)
  .settings(nativeConfig ~= usesLibClang)
  .settings(
    moduleName := "bindgen-libclang",
    Compile / doc / scalacOptions ~= { opts =>
      opts.filterNot(_.contains("-Xplugin"))
    }
  )

lazy val tests = project
  .in(file("modules/tests"))
  .enablePlugins(ScalaNativePlugin, ScalaNativeJUnitPlugin, BindgenPlugin)
  .settings(nativeCommon)
  .settings(Compile / nativeConfig ~= environmentConfiguration)
  .settings(nativeConfig ~= usesLibClang)
  .settings(clangDetection)
  .settings(
    publish / skip := true,
    publishLocal / skip := true,
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-s", "-v"),
    bindgenBinary := (bindgen / Compile / nativeLink).value,
    Compile / bindgenBinary := (bindgen / Compile / nativeLink).value,
    Test / bindgenBinary := (bindgen / Compile / nativeLink).value,
    bindgenBindings := Seq.empty,
    Test / sources := {
      val defaults = (Test / sources).value
      if (Platform.os == Platform.OS.Windows)
        defaults.filterNot(_.toString.toLowerCase.contains("no-windows"))
      else defaults
    },
    Test / bindgenBindings := {
      val headersPath =
        baseDirectory.value / "src" / "test" / "resources" / "scala-native"

      val files = headersPath.toGlob / "**" / "*.h"
      import scala.collection.JavaConverters.*
      val headerSpec = Files
        .walk(headersPath.toPath, 1)
        .collect(Collectors.toList())
        .asScala
        .filter(_.toFile().isFile())
        .filter(_.toFile.ext == "h")
        .map(h =>
          h.toFile -> headersPath.toPath.relativize(h).toString.dropRight(2)
        )
        .toMap

      headerSpec.toSeq.map { case (header, name) =>
        Binding(
          header,
          s"lib_test_$name",
          cImports = List(s"$name.h"),
          logLevel = LogLevel.Trace
        )
      }
    }
  )

lazy val scalaNativeLibParser = project
  .in(file("modules/scalaNativeLib"))
  .settings(scalaVersion := Versions.Scala213)
  .settings(
    libraryDependencies += "org.scalameta" %% "scalameta" % Versions.scalameta,
    scalacOptions += "-Xsource:3"
  )

lazy val docs =
  project
    .in(file("docs"))
    .enablePlugins(SubatomicPlugin)
    .settings(
      scalaVersion := Versions.Scala3,
      fork := true,
      publish / skip := true,
      Compile / run / envVars := Map(
        "BINDGEN_BINARY" -> (bindgen / Compile / nativeLink).value.toString()
      )
    )
// --------------HELPERS-------------------------

def detectBinaryArtifacts: Map[String, (Artifact, File)] = if (
  sys.env.contains("BINARIES")
) {
  val folder = new File(sys.env("BINARIES"))

  def build(classifier: String, file: File): (String, (Artifact, File)) = {
    val artif = Artifact("bindgen", classifier)
      .withExtension("jar")
      .withType("jar")
      .withConfigurations(Vector(Compile))

    classifier -> (artif, file)
  }

  val artifacts = for {
    os <- Platform.OS.all
    arch <- Platform.Arch.all
    target = Platform.Target(os, arch)
    filename = os match {
      case Windows => "bindgen.exe"
      case _       => "bindgen"
    }
    file = folder / s"sn-bindgen-${target.coursierString}" / filename
    if file.exists()
  } yield build(target.string, file)

  artifacts.toMap
} else Map.empty

def environmentConfiguration(conf: NativeConfig): NativeConfig = {
  var modified = conf
  if (sys.env.contains("SN_RELEASE"))
    modified = modified.withMode(Mode.releaseFast)

  if (sys.env.contains("SN_SANITIZE")) {
    val opts =
      "-fsanitize=address -fno-omit-frame-pointer -fsanitize-address-use-after-return=always"
        .split(' ')
        .toList

    modified = modified
      .withLinkingOptions(modified.linkingOptions ++ opts)
      .withCompileOptions(modified.compileOptions ++ opts)
      .withOptimize(false)
      .withMode(Mode.debug)
      .withLTO(LTO.none)
  }

  if (sys.env.contains("SN_GC"))
    modified = modified.withGC(GC.apply(sys.env("SN_GC")))

  modified
}

def usesLibClang(conf: NativeConfig) = {
  val libraryName =
    if (Platform.os == Platform.OS.Windows) "libclang" else "clang"

  val detected = Platform.detectClangInfo(conf.clang)

  conf
    .withLinkingOptions(
      conf.linkingOptions ++
        Seq("-l" + libraryName) ++
        detected.llvmLib.map("-L" + _)
    )
    .withCompileOptions(
      conf.compileOptions ++ detected.llvmInclude.map("-I" + _)
    )
}

// --------------SETTINGS-------------------------

ThisBuild / resolvers += Resolver.sonatypeRepo("snapshots")

lazy val markdownDocuments = taskKey[Seq[java.nio.file.Path]]("")
markdownDocuments := {
  markdownDocuments.inputFiles
}

markdownDocuments / fileInputs ++=
  Seq(
    (docs / baseDirectory).value.toGlob / "**" / "*.md",
    (docs / baseDirectory).value.toGlob / "**" / "*.css",
    (
      docs / baseDirectory
    ).value.toGlob / "**" / "*.js"
  )

lazy val buildSite = inputKey[Unit]("")
buildSite := Def.inputTaskDyn {
  val defaultArgs =
    Seq("--destination", ((ThisBuild / baseDirectory).value / "_site").toString)
  val parsed = sbt.complete.DefaultParsers.spaceDelimited("<arg>").parsed

  val args = (defaultArgs ++ parsed).mkString(" ")

  val _ = markdownDocuments.value

  Def.taskDyn {
    (docs / Compile / runMain)
      .toTask(s" bindgen.docs.Docs build $args")
  }

}.evaluated

lazy val buildBinary = taskKey[File]("")

buildBinary := {
  val built = (bindgen / Compile / nativeLink).value
  val name =
    if (Platform.os == Platform.OS.Windows) "bindgen.exe" else "bindgen"
  val dest = (ThisBuild / baseDirectory).value / "bin" / name

  IO.copyFile(built, dest)

  dest
}

lazy val nativeCommon = Seq(
  scalaVersion := Versions.Scala3
)

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val versionDump =
  taskKey[Unit]("Dumps the version in a file named version")

versionDump := {
  val file = (ThisBuild / baseDirectory).value / "version"
  IO.write(file, (Compile / version).value)
}

lazy val clangInfo = taskKey[Platform.ClangInfo]("")

lazy val clangDetection = Seq(clangInfo := {
  val path = nativeClang.value.toPath()

  Platform.detectClangInfo(path)
})

addCommandAlias(
  "ci",
  "scalafmtCheckAll; scalafmtSbtCheck; test; plugin/scripted"
)

addCommandAlias(
  "devPublish",
  "publishLocal; localBindgenArtifact/publishLocal; show bindgen/version"
)

addCommandAlias("preCI", "scalafmtAll; scalafmtSbt;")
