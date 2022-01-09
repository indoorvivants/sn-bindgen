import java.util.stream.Collectors
import java.nio.file.Files
import scala.scalanative.build.Mode
import scala.scalanative.build.NativeConfig
import sbt.io.Using
import scala.sys.process.ProcessLogger
import scala.scalanative.build.LTO

Global / onChangedBuildSource := ReloadOnSourceChanges

// --------------MODULES-------------------------
lazy val root = project.in(file(".")).aggregate(bindgen, libclang)

def environmentConfiguration(conf: NativeConfig): NativeConfig = {
  if (sys.env.contains("SN_RELEASE")) conf.withMode(Mode.releaseFast)
  else conf
}

def usesLibClang(conf: NativeConfig) =
  conf
    .withLinkingOptions(conf.linkingOptions ++ Seq("-lclang") ++ llvmLib)
    .withCompileOptions(llvmInclude(10 to 13))

lazy val bindgen = project
  .in(file("bindgen"))
  .dependsOn(libclang)
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)
  .settings(nativeConfig ~= environmentConfiguration)
  .settings(nativeConfig ~= usesLibClang)
  .settings(
    libraryDependencies += ("com.monovore" %%% "decline" % "2.2.0" cross CrossVersion.for3Use2_13)
      .excludeAll(ExclusionRule("org.scala-native")),
    libraryDependencies += "org.scala-native" %%% "junit-runtime" % "0.4.3-RC1",
    addCompilerPlugin(
      "org.scala-native" % "junit-plugin" % "0.4.3-RC1" cross CrossVersion.full
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

lazy val watchedHeaders =
  taskKey[Seq[String]]("Header files watched by bindgen's tests")

lazy val libclang = project
  .in(file("libclang"))
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)
  .settings(nativeConfig ~= usesLibClang)

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

lazy val examples = project
  .in(file("examples"))
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)
  .settings(nativeConfig ~= usesLibClang)
  .settings(
    Compile / sourceGenerators += Def.task {
      val scalaFiles = (Compile / sourceManaged).value
      val binary = new File(
        sys.env.getOrElse(
          "BINARY",
          throw new Exception("BINARY environment variable is not set")
        )
      )

      val builder = new BindingBuilder(binary)

      sampleBindings(baseDirectory.value / "libraries", builder)

      builder.generate(scalaFiles, BindingLang.Scala)
    },
    Compile / resourceGenerators += Def.task {
      val cFiles = (Compile / resourceManaged).value / "scala-native"
      val binary = new File(
        sys.env.getOrElse(
          "BINARY",
          throw new Exception("BINARY environment variable is not set")
        )
      )

      val builder = new BindingBuilder(binary)

      sampleBindings(baseDirectory.value / "libraries", builder)

      builder.generate(cFiles, BindingLang.C)
    }
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

val bindings = inputKey[Unit]("Regenerate known bindings")
// --------------SETTINGS-------------------------
lazy val nativeCommon = Seq(
  resolvers += Resolver.sonatypeRepo("snapshots"),
  scalaVersion := "3.1.0"
  /* libraryDependencies += ("org.scalameta" %%% "munit" % "1.0.0-M1" cross CrossVersion.for3Use2_13) % Test */
)
