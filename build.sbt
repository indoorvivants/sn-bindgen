import _root_.bindgen.interface.Platform
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
  val scalaNative = "0.4.3-RC2"
  val junit = "0.11"

  val Scala212 = "2.12.15"
  val Scala213 = "2.13.8"
  val Scala2 = List(Scala212, Scala213)
  val Scala3 = List("3.1.0")
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
    Versions.Scala2 ++ Versions.Scala3,
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
  .settings(Compile / nativeConfig ~= usesLibClang)
  .settings(Test / nativeConfig ~= usesLibClang)
  .settings(
    Test / nativeLink / artifactPath := crossTarget.value / "test-bindgen-out"
  )
  .settings(
    moduleName := "bindgen",
    libraryDependencies += ("com.monovore" %%% "decline" % Versions.decline cross CrossVersion.for3Use2_13)
      .excludeAll(ExclusionRule("org.scala-native")),
    // test settings for Scala Native
    libraryDependencies += "org.scala-native" %%% "junit-runtime" % Versions.scalaNative,
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
  .settings(nativeConfig ~= usesLibClang)
  .settings(
    Compile / sourceGenerators += Def.taskIf {
      Using.fileWriter()
      if (sys.env.contains("BINARY")) {
        generateExampleBindings(
          (Compile / sourceManaged).value,
          baseDirectory.value,
          new File(sys.env("BINARY")),
          BindingLang.Scala
        )
      } else
        generateExampleBindings(
          (Compile / sourceManaged).value,
          baseDirectory.value,
          (bindgen / Compile / nativeLink).value,
          BindingLang.Scala
        )
    },
    Compile / resourceGenerators += Def.taskIf {
      if (sys.env.contains("BINARY")) {
        generateExampleBindings(
          (Compile / resourceManaged).value / "scala-native",
          baseDirectory.value,
          new File(sys.env("BINARY")),
          BindingLang.C
        )
      } else
        generateExampleBindings(
          (Compile / resourceManaged).value / "scala-native",
          baseDirectory.value,
          (bindgen / Compile / nativeLink).value,
          BindingLang.C
        )
    }
  )

// --------------HELPERS-------------------------

def detectBinaryArtifacts: Map[String, (Artifact, File)] = if (
  sys.env.contains("BINARIES")
) {
  val folder = new File(sys.env("BINARIES"))

  val apple_x86 = folder / "sn-bindgen-x86_64-apple-darwin" / "bindgen-out"
  val linux_x86 = folder / "sn-bindgen-x86_64-pc-linux" / "bindgen-out"

  val builder = Map.newBuilder[String, (Artifact, File)]

  def build(classifier: String, file: File): (String, (Artifact, File)) = {
    val artif = Artifact("bindgen", classifier)
      .withExtension("jar")
      .withType("jar")
      .withConfigurations(Vector(Compile))

    classifier -> (artif, file)
  }

  if (apple_x86.exists())
    builder += build("osx-x86_64", apple_x86)

  if (linux_x86.exists())
    builder += build("linux-x86_64", linux_x86)

  builder.result()
} else Map.empty

def generateExampleBindings(
    destination: File,
    base: File,
    binary: File,
    lang: BindingLang
): Seq[File] = {

  val builder = new BindingBuilder(binary)

  sampleBindings(base / "libraries", builder)

  builder.generate(destination, lang)
}

def environmentConfiguration(conf: NativeConfig): NativeConfig = {
  if (sys.env.contains("SN_RELEASE")) conf.withMode(Mode.releaseFast)
  else conf
}

def usesLibClang(conf: NativeConfig) = {
  val llvmLibs =
    if (sys.env.contains("LIBCLANG_STATIC"))
      List(
        "-Lbuild/libclang-static-build/lib",
        "-lclang_bundled",
        "-lz"
      )
    else llvmLib ++ List("-lclang")

  conf
    .withLinkingOptions(conf.linkingOptions ++ llvmLibs)
    .withCompileOptions(conf.compileOptions ++ llvmInclude ++ clangInclude)
}

def includes(
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
}.filter(s => Paths.get(s).toFile.exists).map(s => s"-I$s")

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

def llvmInclude: List[String] = {
  includes(
    ifLinux =
      (10 to 13).toList.flatMap(v => List(s"/usr/lib/llvm-$v/include/")),
    ifMac =
      List("/opt/homebrew/opt/llvm/include", "/usr/local/opt/llvm/include")
  )
}

def clangInclude: List[String] = {
  val majorVersion = sys.env.getOrElse("CLANG_VERSION", "13")
  includes(
    /* ifLinux = */
    /*   List(s"/usr/lib/llvm-$majorVersion/lib/clang/$majorVersion.0.0/include"), */
    ifMac =
      if (Platform.target.arch == Platform.Arch.x86_64)
        List(
          // on X86 macs
          s"/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/lib/clang/$majorVersion.0.0/include",
          "/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include",
          "/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/include"
        )
      else
        List(
          // on M1 macs
          s"/Library/Developer/CommandLineTools/usr/lib/clang/$majorVersion.0.0/include",
          "/Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/include",
          "/Library/Developer/CommandLineTools/usr/include"
        )
  )
}

def llvmLib = {
  val majorVersion = sys.env.getOrElse("CLANG_VERSION", "13")
  linking(
    ifLinux = List(s"/usr/lib/llvm-$majorVersion/lib/"),
    ifMac =
      if (Platform.target.arch == Platform.Arch.x86_64)
        List("/usr/local/opt/llvm/lib")
      else
        List("/opt/homebrew/opt/llvm/lib")
  )
}

def sampleBindings(location: File, builder: BindingBuilder) = {
  import builder.define

  define(
    location / "cJSON.h",
    "libcjson",
    Some("cjson"),
    List("cJSON.h"),
    clangFlags = clangInclude
  )
  define(
    location /
      "Clang-Index.h",
    "libclang",
    Some("clang"),
    List("clang-c/Index.h"),
    clangFlags = llvmInclude ++ clangInclude
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

  if (Platform.target.os != Platform.OS.Linux)
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
  scalaVersion := "3.1.0"
)

lazy val watchedHeaders =
  taskKey[Seq[String]]("Header files watched by bindgen's tests")

Global / onChangedBuildSource := ReloadOnSourceChanges

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

lazy val fetchedBinary = taskKey[Unit]("")
