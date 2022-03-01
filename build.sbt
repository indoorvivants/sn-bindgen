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
  val decline = "2.2.0"
  val scalaNative = nativeVersion
  val junit = "0.11"

  val Scala212 = "2.12.15"
  val Scala213 = "2.13.8"
  val Scala2 = List(Scala212, Scala213)
  val Scala3 = "3.1.1"
}

// --------------MODULES-------------------------
lazy val root = project
  .in(file("."))
  .aggregate(bindgen, libclang)
  .aggregate(iface.projectRefs*)
  .aggregate(plugin.projectRefs*)
  .settings(
    publish / skip := true,
    publishLocal / skip := true
  )

lazy val iface = projectMatrix
  .in(file("interface"))
  .someVariations(
    Versions.Scala2 :+ Versions.Scala3,
    List(VirtualAxis.jvm) // todo may be publish native interfaces as well
  )(MatrixAction.ForScala(_.isScala2).Settings(scalacOptions += "-Xsource:3"))
  .settings(
    moduleName := "bindgen-interface",
    libraryDependencies += "com.novocode" % "junit-interface" % Versions.junit % Test,
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-s", "-v"),
    Test / fork := true,
    Test / envVars += "BINARY" -> (bindgen / Compile / nativeLink).value.toString,
    Compile / resourceGenerators += Def.task {
      val out =
        (Compile / managedResourceDirectories).value.head / "sn-bindgen.properties"

      val props = new java.util.Properties()

      props.setProperty("sn-bindgen.version", version.value)

      IO.write(props, "SN bindgen properites file", out)

      List(out)
    }
  )

val generateCSources = taskKey[Seq[File]]("")
val generateScalaSources = taskKey[Seq[File]]("")

lazy val bindgen = project
  .in(file("bindgen"))
  .dependsOn(libclang)
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)
  .settings(Compile / nativeConfig ~= environmentConfiguration)
  .settings(nativeConfig ~= usesLibClang)
  .settings(Test / nativeConfig ~= usesLibClang)
  .settings(
    Test / nativeLink / artifactPath := crossTarget.value / "test-bindgen-out"
  )
  .settings(clangDetection)
  .settings(
    moduleName := "bindgen",
    libraryDependencies += ("com.monovore" %%% "decline" % Versions.decline cross CrossVersion.for3Use2_13)
      .excludeAll(ExclusionRule("org.scala-native")),
    // test settings for Scala Native
    libraryDependencies += "org.scala-native" %%% "junit-runtime" % Versions.scalaNative % Test,
    addCompilerPlugin(
      "org.scala-native" % "junit-plugin" % Versions.scalaNative cross CrossVersion.full
    ),
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-s", "-v"),
    // Scala 3 hack around the issue with docs
    Compile / doc / scalacOptions ~= { opts =>
      opts.filterNot(_.contains("-Xplugin"))
    },
    // end of Scala 3 hack around the issue with docs
    Test / watchedHeaders / fileInputs +=
      baseDirectory.value.toGlob / "src" / "test" / "resources" / "scala-native" / "*.h",
    Test / watchedHeaders := {
      val path =
        baseDirectory.value / "src" / "test" / "resources" / "scala-native"
      val glob = path.toGlob / "*.h"

      import scala.collection.JavaConverters.*
      Files
        .walk(path.toPath, 1)
        .collect(Collectors.toList())
        .asScala
        .filter(glob.matches)
        .map(h => h.toFile -> path.toPath.relativize(h).toString.dropRight(2))
        .toMap
    },
    Test / generateScalaSources := {
      val scalaFiles = (Test / sourceManaged).value
      val headersPath =
        baseDirectory.value / "src" / "test" / "resources" / "scala-native"
      val binary = (Compile / nativeLink).value
      val headerSpec = (Test / watchedHeaders).value
      val expectedScalaFiles =
        headerSpec.map { case (headerFile, name) =>
          headerFile -> (scalaFiles / s"lib_test_$name.scala")
        }

      val changes = (Test / watchedHeaders).inputFileChanges
      val missing = expectedScalaFiles.filterNot(_._2.exists()).map(_._1)
      val toRebuild =
        changes.created.map(_.toFile) ++
          changes.modified.map(_.toFile) ++
          missing
      val builder = new BindingBuilder(binary)

      val existing = (expectedScalaFiles -- toRebuild).map(_._2)

      val defined = toRebuild.map { header =>
        val name = headerSpec(header)
        Binding(header, s"lib_test_$name", logLevel = LogLevel.Trace)
      }

      builder
        .generate(
          defined,
          scalaFiles,
          BindingLang.Scala,
          clangInfo.value
        ) ++ existing

    },
    Test / generateCSources := {
      val cFiles = (Test / resourceManaged).value / "scala-native"
      val headersPath =
        baseDirectory.value / "src" / "test" / "resources" / "scala-native"
      val binary = (Compile / nativeLink).value
      val headerSpec = (Test / watchedHeaders).value
      val expectedCFiles =
        headerSpec.map { case (headerFile, name) =>
          headerFile -> (cFiles / s"lib_test_$name.c")
        }

      val changes = (Test / watchedHeaders).inputFileChanges
      val missing = expectedCFiles.filterNot(_._2.exists()).map(_._1)
      val toRebuild =
        changes.created.map(_.toFile) ++
          changes.modified.map(_.toFile) ++
          missing
      val builder = new BindingBuilder(binary)

      val existing = (expectedCFiles -- toRebuild).map(_._2)

      val defined = toRebuild.map { header =>
        val name = headerSpec(header)
        Binding(
          header,
          s"lib_test_$name",
          cImports = List(s"$name.h"),
          logLevel = LogLevel.Trace
        )
      }

      builder
        .generate(defined, cFiles, BindingLang.C, clangInfo.value) ++ existing
    },
    Test / sourceGenerators += (Test / generateScalaSources),
    Test / resourceGenerators += (Test / generateCSources)
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

def getHeaders(path: File): Seq[String] = {
  /* val path = */
  /*   baseDirectory.value / "src" / "test" / "resources" / "scala-native" */
  val glob = path.toGlob / "*.h"

  import scala.collection.JavaConverters.*
  Files
    .walk(path.toPath, 1)
    .collect(Collectors.toList())
    .asScala
    .filter(glob.matches)
    .map(h => path.toPath.relativize(h).toString)
    .map(_.dropRight(2)) // remove ".h"
    .toSeq
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
  .in(file("sbt-plugin"))
  .defaultAxes(VirtualAxis.scalaABIVersion(Versions.Scala212), VirtualAxis.jvm)
  .allVariations(List(Versions.Scala212), List(VirtualAxis.jvm))
  .dependsOn(iface)
  .settings(
    sbtPlugin := true,
    addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.4.3"),
    pluginCrossBuild / sbtVersion := "1.6.1",
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
  .in(file("libclang"))
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

lazy val examples = project
  .in(file("examples"))
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)
  .settings(clangDetection)
  .settings(nativeConfig ~= usesLibClang)
  .settings(
    Compile / sourceGenerators += Def.taskIf {
      if (sys.env.contains("BINARY")) {
        val ci = clangInfo.value
        generateExampleBindings(
          (Compile / sourceManaged).value,
          baseDirectory.value,
          new File(sys.env("BINARY")),
          BindingLang.Scala,
          ci
        )
      } else {
        val ci = clangInfo.value
        generateExampleBindings(
          (Compile / sourceManaged).value,
          baseDirectory.value,
          (bindgen / Compile / nativeLink).value,
          BindingLang.Scala,
          ci
        )
      }
    },
    Compile / resourceGenerators += Def.taskIf {
      if (sys.env.contains("BINARY")) {
        val ci = clangInfo.value
        generateExampleBindings(
          (Compile / resourceManaged).value / "scala-native",
          baseDirectory.value,
          new File(sys.env("BINARY")),
          BindingLang.C,
          ci
        )
      } else {
        val ci = clangInfo.value
        generateExampleBindings(
          (Compile / resourceManaged).value / "scala-native",
          baseDirectory.value,
          (bindgen / Compile / nativeLink).value,
          BindingLang.C,
          ci
        )
      }
    }
  )

lazy val docs =
  project
    .in(file("docs"))
    .enablePlugins(SubatomicPlugin)
    .settings(
      scalaVersion := Versions.Scala3,
      fork := true,
      publish / skip := true,
      // To react to asset changes
      watchSources += WatchSource(
        (ThisBuild / baseDirectory).value / "docs" / "assets"
      ),
      watchSources += WatchSource(
        (ThisBuild / baseDirectory).value / "docs" / "pages"
      ),
      watchSources += WatchSource(
        (ThisBuild / baseDirectory).value / "docs" / "blog"
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
      case Windows => "bindgen-out.exe"
      case _       => "bindgen-out"
    }
    file = folder / s"sn-bindgen-${target.string}" / filename
    if file.exists()
  } yield build(target.string, file)

  artifacts.toMap
} else Map.empty

def generateExampleBindings(
    destination: File,
    base: File,
    binary: File,
    lang: BindingLang,
    ci: ClangInfo
): Seq[File] = {

  val builder = new BindingBuilder(binary)

  val defined = sampleBindings(base / "libraries", builder, ci)

  builder.generate(defined, destination, lang, ci)
}

def environmentConfiguration(conf: NativeConfig): NativeConfig = {
  if (sys.env.contains("SN_RELEASE")) conf.withMode(Mode.releaseFast)
  else conf
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
def sampleBindings(location: File, builder: BindingBuilder, ci: ClangInfo) = {

  val clangInclude = ci.includePaths.map("-I" + _)
  val llvmInclude = ci.llvmInclude.map("-I" + _)

  Seq(
    Binding(location / "cJSON.h", "libcjson", Some("cjson"), List("cJSON.h")),
    Binding(
      location /
        "Clang-Index.h",
      "libclang",
      Some("clang"),
      List("clang-c/Index.h"),
      llvmInclude
    ),
    Binding(
      location /
        "tree-sitter.h",
      "libtreesitter",
      Some("treesitter"),
      cImports = List("tree_sitter/api.h"),
      llvmInclude ++
        clangInclude ++
        List("-std=gnu99")
    ),
    Binding(
      location /
        "raylib.h",
      "libraylib",
      Some("raylib"),
      List("raylib.h"),
      llvmInclude ++ clangInclude
    )
  )

}

// --------------SETTINGS-------------------------
ThisBuild / resolvers += Resolver.sonatypeRepo("snapshots")

addCommandAlias("buildSite", "docs/runMain bindgen.docs.Docs build")
addCommandAlias("buildBlog", "docs/runMain bindgen.docs.DevBlog build")

lazy val nativeCommon = Seq(
  scalaVersion := Versions.Scala3
)

lazy val watchedHeaders =
  taskKey[Map[File, String]]("Header files watched by bindgen's tests")

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

inThisBuild(
  Seq(
    concurrentRestrictions ++= {
      if (Platform.os == Platform.OS.Windows && sys.env.contains("CI"))
        Seq(Tags.limitAll(1))
      else Seq.empty
    },
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
