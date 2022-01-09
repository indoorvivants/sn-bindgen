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
  .settings({
    nativeConfig ~= {
      { conf =>
        conf
          .withLinkingOptions(
            conf.linkingOptions ++ Seq(
              "-lclang",
              "-lraylib"
            ) ++ llvmLib
          )
          .withCompileOptions(conf.compileOptions ++ llvmInclude(10 to 13))
      }
    }
  })
  .settings(
    bindings := {
      import complete.DefaultParsers.*
      val rawArgs = spaceDelimited("<arg>").parsed
      val cmd = rawArgs.head
      val args = rawArgs.tail

      case class Binding(
          headerFile: File,
          packageName: String,
          scalaFile: File,
          cFile: File,
          linkName: String,
          cImports: List[String],
          clangFlags: List[String]
      ) {
        def toCommand: String = {
          val sb = new StringBuilder
          sb.append(s"--header $headerFile ")
          sb.append(s"--package $packageName ")
          sb.append(s"--link-name $linkName ")
          cImports.foreach { cimp =>
            sb.append(s"--c-import $cimp ")
          }
          clangFlags.foreach { clangFlag =>
            sb.append(s"--clang $clangFlag ")
          }

          sb.append(" --info ")

          sb.result
        }
      }
      val binary = (bindgen / Compile / nativeLink).value
      val headerFilesBase = baseDirectory.value / "libraries"
      val destinationScalaBase =
        (Compile / managedSourceDirectories).value.head / "bindings"
      val destinationCBase =
        (Compile / managedResourceDirectories).value.head / "scala-native"

      def define(
          headerFile: String,
          packageName: String,
          linkName: String,
          cImports: List[String],
          clangFlags: List[String] = Nil,
          platformTest: String => Boolean = _ => true
      ) =
        Option(
          Binding(
            headerFile = headerFilesBase / headerFile,
            packageName = packageName,
            linkName = linkName,
            cFile = destinationCBase / s"$packageName.c",
            scalaFile = destinationScalaBase / s"$packageName.scala",
            cImports = cImports,
            clangFlags = clangFlags
          )
        ).filter(_ => platformTest(osName))

      val mapping = List(
        define("cJSON.h", "libcjson", "cjson", List("cJSON.h")),
        define("test.h", "libtest", "test", List("test.h")),
        define(
          "Clang-Index.h",
          "libclang",
          "clang",
          List("clang-c/Index.h"),
          llvmInclude(10 to 13)
        ),
        define(
          "raylib.h",
          "libraylib",
          "raylib",
          List("raylib.h"),
          llvmInclude(10 to 13) ++ clangInclude(10 to 13),
          platformTest = _ != "mac"
        ),
        define(
          "curl.h",
          "libcurl",
          "curl",
          List("curl.h"),
          clangInclude(10 to 13) ++
            includes(ifMac =
              List(
                "/opt/homebrew/opt/curl/include/curl",
                "/usr/local/opt/curl/include/curl"
              )
            ),
          platformTest = _ != "linux"
        ),
        define(
          "nuklear.h",
          "libnuklear",
          "nuklear",
          List("nuklear.h"),
          List("-DNK_IMPLEMENTATION=1", "-DNK_INCLUDE_FIXED_TYPES=1")
        )
        /* define("sokol_gfx.h", "libsokol", "sokol", List("sokol_gfx.h")) */
      ).flatten

      val argsWithoutRemoved = args.filterNot(_.startsWith("-"))

      val requested =
        mapping
          .filter(binding =>
            argsWithoutRemoved.isEmpty &&
              !args.contains(s"-${binding.packageName}") ||
              args
                .contains(binding.packageName)
          )

      List("scala", "c").foreach { lang =>
        requested.foreach { binding =>
          if (cmd.trim.toLowerCase == "gen") {
            import scala.sys.process.Process

            val destination =
              if (lang == "scala") binding.scalaFile else binding.cFile

            val cmd = binary.toString + " " + binding.toCommand + s" --$lang"

            println(s"Executing $cmd")

            Using.fileWriter()(destination) { wr =>
              val logger = ProcessLogger.apply(
                (o: String) => wr.write(o + "\n"),
                (e: String) => println(e)
              )

              val result = Process(cmd).run(logger).exitValue()

              if (result == 0)
                println(
                  s"Successfully regenerated binding ($lang) for ${binding.packageName}, $result"
                )
              else
                throw new Exception(s"Process failed with code $result")
            }
          } else if (cmd.trim.toLowerCase == "clean") {
            val toDelete =
              if (lang == "scala") binding.scalaFile else binding.cFile
            println(s"Deleting $toDelete: ${toDelete.delete()}")
          }
        }
      }

    }
  )

val Samples = new {}

val bindings = inputKey[Unit]("Regenerate known bindings")
// --------------SETTINGS-------------------------
lazy val nativeCommon = Seq(
  resolvers += Resolver.sonatypeRepo("snapshots"),
  scalaVersion := "3.1.0"
  /* libraryDependencies += ("org.scalameta" %%% "munit" % "1.0.0-M1" cross CrossVersion.for3Use2_13) % Test */
)
