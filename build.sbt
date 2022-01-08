import sbt.io.Using
import scala.sys.process.ProcessLogger
import scala.scalanative.build.LTO
Global / onChangedBuildSource := ReloadOnSourceChanges

// --------------MODULES-------------------------
lazy val root = project.in(file(".")).aggregate(bindgen, libclang, examples)

lazy val bindgen = project
  .in(file("bindgen"))
  .dependsOn(libclang)
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)
  .settings(nativeConfig ~= { conf =>
    conf
      .withOptimize(false)
      .withLTO(LTO.none)
      /* .withDump(true) */
      .withLinkingOptions(conf.linkingOptions ++ Seq("-lclang") ++ llvmLib)
      .withCompileOptions(llvmInclude(10 to 13))
  })
  .settings(
    libraryDependencies += ("com.monovore" %%% "decline" % "2.2.0" cross CrossVersion.for3Use2_13)
      .excludeAll(ExclusionRule("org.scala-native"))
  )

lazy val libclang = project
  .in(file("libclang"))
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)

def osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux")   => "linux"
  case n if n.startsWith("Mac")     => "mac"
  case n if n.startsWith("Windows") => "win"
  case _                            => throw new Exception("Unknown platform!")
}

def llvmInclude(versions: Seq[Int]): List[String] = {
  osName match {
    case "linux" =>
      versions.toList.flatMap(v => List(s"/usr/lib/llvm-$v/include/"))
    case "mac" =>
      List("/opt/homebrew/opt/llvm/include", "/usr/local/opt/llvm/include")
  }
}.map(s => s"-I$s")

def clangInclude(versions: Seq[Int]): List[String] = {
  osName match {
    case "linux" =>
      versions.toList.flatMap(v => List(s"/usr/lib/llvm-$v/include/"))
    case "mac" =>
      List("/opt/homebrew/Cellar/llvm/13.0.0_2/lib/clang/13.0.0/include")
  }
}.map(s => s"-I$s")

def llvmLib = {
  osName match {
    case "linux" => List.empty
    case "mac" =>
      if (System.getProperty("os.arch").contains("x86"))
        List("/usr/local/opt/llvm/lib")
      else
        List("/opt/homebrew/opt/llvm/lib")

  }
}.map(lib => s"-L$lib")

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

          sb.append(" --trace ")

          sb.result
        }
      }
      val binary = (bindgen / Compile / nativeLink).value
      val headerFilesBase = baseDirectory.value / "libraries"
      val destinationScalaBase =
        baseDirectory.value / "src" / "main" / "scala" / "bindings"
      val destinationCBase =
        baseDirectory.value / "src" / "main" / "resources" / "scala-native"

      def define(
          headerFile: String,
          packageName: String,
          linkName: String,
          cImports: List[String],
          clangFlags: List[String] = Nil
      ) =
        Binding(
          headerFile = headerFilesBase / headerFile,
          packageName = packageName,
          linkName = linkName,
          cFile = destinationCBase / s"$packageName.c",
          scalaFile = destinationScalaBase / s"$packageName.scala",
          cImports = cImports,
          clangFlags = clangFlags
        )

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
          clangInclude(10 to 13)
        ),
        define(
          "curl.h",
          "libcurl",
          "curl",
          List("curl.h"),
          clangInclude(10 to 13) ++ List(
            "-I/Library/Developer/CommandLineTools/SDKs/MacOSX.sdk/usr/include/curl"
          )
        ),
        define(
          "nuklear.h",
          "libnuklear",
          "nuklear",
          List("nuklear.h"),
          List("-DNK_IMPLEMENTATION=1", "-DNK_INCLUDE_FIXED_TYPES=1")
        )
        /* define("sokol_gfx.h", "libsokol", "sokol", List("sokol_gfx.h")) */
      )

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
