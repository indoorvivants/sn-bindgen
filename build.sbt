import _root_.bindgen.interface.Platform
import _root_.bindgen.interface.Platform.ClangInfo
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
        .map(h => path.toPath.relativize(h).toString)
        .map(_.dropRight(2)) // remove ".h"
        .toSeq
    },
    Test / sourceGenerators += Def.task {

      val scalaFiles = (Test / sourceManaged).value
      val path =
        baseDirectory.value / "src" / "test" / "resources" / "scala-native"
      val binary = (Compile / nativeLink).value

      val builder = new BindingBuilder(binary)

      (Test / watchedHeaders).value.foreach { header =>
        builder.define(path / s"$header.h", s"lib_test_$header")
      }

      builder.generate(scalaFiles, BindingLang.Scala)
    },
    Test / resourceGenerators += Def.task {
      val cFiles = (Test / resourceManaged).value / "scala-native"
      val path =
        baseDirectory.value / "src" / "test" / "resources" / "scala-native"
      val binary = (Compile / nativeLink).value

      val builder = new BindingBuilder(binary)

      (Test / watchedHeaders).value.foreach { header =>
        builder.define(
          path / s"$header.h",
          s"lib_test_$header",
          cImports = List(s"$header.h")
        )
      }

      builder.generate(cFiles, BindingLang.C)
    }
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
  .in(file("sbt-plugin"))
  .defaultAxes(VirtualAxis.scalaABIVersion(Versions.Scala212), VirtualAxis.jvm)
  .allVariations(List(Versions.Scala212), List(VirtualAxis.jvm))
  .dependsOn(iface)
  .settings(
    sbtPlugin := true,
    pluginCrossBuild / sbtVersion := "1.5.7",
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
    file = folder / s"sn-bindgen-${target.string}" / "bindgen-out"
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

  sampleBindings(base / "libraries", builder, ci)

  builder.generate(destination, lang)
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

def includes(
    ifLinux: List[String] = Nil,
    ifMac: List[String] = Nil,
    ifWindows: List[String] = Nil,
    all: List[String] = Nil
): List[String] = {
  Platform.target.os match {
    case Platform.OS.Linux   => ifLinux
    case Platform.OS.MacOS   => ifMac
    case Platform.OS.Windows => ifWindows
    case _                   => Nil
  }
}.++(all).filter(s => Paths.get(s).toFile.exists).map(s => s"-I$s")

def linking(
    ifLinux: List[String] = Nil,
    ifMac: List[String] = Nil,
    ifWindows: List[String] = Nil
): List[String] = {
  Platform.target.os match {
    case Platform.OS.Linux   => ifLinux
    case Platform.OS.MacOS   => ifMac
    case Platform.OS.Windows => ifWindows
    case _                   => Nil
  }
}.map(s => s"-L$s")

def sampleBindings(location: File, builder: BindingBuilder, ci: ClangInfo) = {
  import builder.define

  val clangInclude = ci.includePaths.map("-I" + _)
  val llvmInclude = ci.llvmInclude.map("-I" + _)

  define(location / "cJSON.h", "libcjson", Some("cjson"), List("cJSON.h"))

  define(
    location /
      "Clang-Index.h",
    "libclang",
    Some("clang"),
    List("clang-c/Index.h"),
    llvmInclude
  )
  define(
    location /
      "tree-sitter.h",
    "libtreesitter",
    Some("treesitter"),
    cImports = List("tree_sitter/api.h"),
    llvmInclude ++
      clangInclude ++
      List("-std=gnu99")
  )

  define(
    location /
      "raylib.h",
    "libraylib",
    Some("raylib"),
    List("raylib.h"),
    llvmInclude ++ clangInclude
  )
  /* define( */
  /*   location / */
  /*     "sokol_gfx.h", */
  /*   "sokol_gfx", */
  /*   Some("sokol_gfx"), */
  /*   List("sokol_gfx.h"), */
  /*   llvmInclude ++ clangInclude */
  /* ) */

  if (Platform.target.os == Platform.OS.MacOS)
    define(
      location /
        "curl.h",
      "libcurl",
      Some("curl"),
      List("curl.h"),
      clangInclude ++
        includes(ifMac =
          List(
            "/opt/homebrew/opt/curl/include/curl",
            "/usr/local/opt/curl/include/curl"
          )
        )
    )
  // Compiling this monster crashes the compiler :shrug:
  /* define( */
  /*   location / */
  /*     "nuklear.h", */
  /*   "libnuklear", */
  /*   Some("nuklear"), */
  /*   List("nuklear.h"), */
  /*   List("-DNK_IMPLEMENTATION=1", "-DNK_INCLUDE_FIXED_TYPES=1") */
  /* ) */
}

// --------------SETTINGS-------------------------
lazy val nativeCommon = Seq(
  scalaVersion := Versions.Scala3
)

lazy val watchedHeaders =
  taskKey[Seq[String]]("Header files watched by bindgen's tests")

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
addCommandAlias("preCI", "scalafmtAll; scalafmtSbt;")

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
