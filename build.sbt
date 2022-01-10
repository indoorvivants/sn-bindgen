import java.util.stream.Collectors
import java.nio.file.Files
import scala.scalanative.build.Mode
import scala.scalanative.build.NativeConfig
import scala.scalanative.build.LTO
import commandmatrix.extra.*

import _root_.bindgen.interface.{BindingBuilder, BindingLang}

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val Versions = new {
  val decline = "2.2.0"
  val scalaNative = "0.4.3-RC1"

  val Scala2 = List("2.12.15", "2.13.8")
  val Scala3 = List("3.1.0")
}

// --------------MODULES-------------------------
lazy val root = project
  .in(file("."))
  .aggregate(bindgen, libclang)
  .aggregate(iface.projectRefs*)

lazy val iface = projectMatrix
  .in(file("interface"))
  .someVariations(
    Versions.Scala2 ++ Versions.Scala3,
    List(VirtualAxis.jvm) // todo may be publish native interfaces as well
  )(MatrixAction.ForScala(_.isScala2).Settings(scalacOptions += "-Xsource:3"))

lazy val bindgen = project
  .in(file("bindgen"))
  .dependsOn(libclang)
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)
  .settings(nativeConfig ~= environmentConfiguration)
  .settings(nativeConfig ~= usesLibClang)
  .settings(
    libraryDependencies += ("com.monovore" %%% "decline" % Versions.decline cross CrossVersion.for3Use2_13)
      .excludeAll(ExclusionRule("org.scala-native")),
    libraryDependencies += "org.scala-native" %%% "junit-runtime" % Versions.scalaNative,
    addCompilerPlugin(
      "org.scala-native" % "junit-plugin" % Versions.scalaNative cross CrossVersion.full
    ),
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-s", "-v"),
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
  .settings(
    Test / nativeLink / artifactPath := crossTarget.value / "test-bindgen-out"
  )
  .settings(Test / nativeConfig ~= usesLibClang)

lazy val libclang = project
  .in(file("libclang"))
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)
  .settings(nativeConfig ~= usesLibClang)

lazy val examples = project
  .in(file("examples"))
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)
  .settings(nativeConfig ~= usesLibClang)
  .settings(
    Compile / sourceGenerators += Def.taskIf {
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

def usesLibClang(conf: NativeConfig) =
  conf
    .withLinkingOptions(conf.linkingOptions ++ Seq("-lclang") ++ llvmLib)
    .withCompileOptions(llvmInclude(10 to 13))

def osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux")   => "linux"
  case n if n.startsWith("Mac")     => "mac"
  case n if n.startsWith("Windows") => "win"
  case _                            => throw new Exception("Unknown platform!")
}

def includes(
    ifLinux: List[String] = Nil,
    ifMac: List[String] = Nil,
    ifWindows: List[String] = Nil
): List[String] = {
  osName match {
    case "linux" => ifLinux
    case "mac"   => ifMac
    case "win"   => ifWindows
  }
}.map(s => s"-I$s")

def linking(
    ifLinux: List[String] = Nil,
    ifMac: List[String] = Nil,
    ifWindows: List[String] = Nil
): List[String] = {
  osName match {
    case "linux" => ifLinux
    case "mac"   => ifMac
    case "win"   => ifWindows
  }
}.map(s => s"-L$s")

def llvmInclude(versions: Seq[Int]): List[String] = {
  includes(
    ifLinux = versions.toList.flatMap(v => List(s"/usr/lib/llvm-$v/include/")),
    ifMac =
      List("/opt/homebrew/opt/llvm/include", "/usr/local/opt/llvm/include")
  )
}

def clangInclude(versions: Seq[Int]): List[String] =
  includes(
    ifLinux = versions.toList.flatMap(v => List(s"/usr/lib/llvm-$v/include/")),
    ifMac =
      List("/opt/homebrew/opt/llvm/include", "/usr/local/opt/llvm/include")
  )

def llvmLib =
  linking(ifMac =
    if (System.getProperty("os.arch").contains("x86"))
      List("/usr/local/opt/llvm/lib")
    else
      List("/opt/homebrew/opt/llvm/lib")
  )

def sampleBindings(location: File, builder: BindingBuilder) = {
  import builder.define
  define(location / "cJSON.h", "libcjson", Some("cjson"), List("cJSON.h"))
  define(location / "test.h", "libtest", Some("test"), List("test.h"))
  define(
    location /
      "Clang-Index.h",
    "libclang",
    Some("clang"),
    List("clang-c/Index.h"),
    llvmInclude(10 to 13)
  )
  if (osName != "mac")
    define(
      location /
        "raylib.h",
      "libraylib",
      Some("raylib"),
      List("raylib.h"),
      llvmInclude(10 to 13) ++ clangInclude(10 to 13)
    )

  if (osName != "linux")
    define(
      location /
        "curl.h",
      "libcurl",
      Some("curl"),
      List("curl.h"),
      clangInclude(10 to 13) ++
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
  resolvers += Resolver.sonatypeRepo("snapshots"),
  scalaVersion := "3.1.0"
)

lazy val watchedHeaders =
  taskKey[Seq[String]]("Header files watched by bindgen's tests")
