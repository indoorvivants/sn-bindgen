Global / onChangedBuildSource := ReloadOnSourceChanges

// --------------MODULES-------------------------
lazy val bindgen = project
  .in(file("bindgen"))
  .dependsOn(libclang)
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)
  .settings(nativeConfig ~= { conf =>
    conf
      .withDump(true)
      .withLinkingOptions(Seq("-lclang", "-L/opt/homebrew/opt/llvm/lib"))
      .withCompileOptions(Seq("-I/opt/homebrew/opt/llvm/include"))
  })

lazy val libclang = project
  .in(file("libclang"))
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)

lazy val examples = project
  .in(file("examples"))
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)
  .settings(
    regenerate := {
      case class Binding(
          headerFile: File,
          packageName: String,
          scalaFile: File,
          cFile: File,
          linkName: String,
          cImports: List[String]
      )
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
          cImports: List[String]
      ) =
        Binding(
          headerFile = headerFilesBase / headerFile,
          packageName = packageName,
          linkName = linkName,
          cFile = destinationCBase / s"$packageName.c",
          scalaFile = destinationScalaBase / s"$packageName.scala",
          cImports = cImports
        )

      val mapping = List(
        define("cJSON.h", "libcjson", "cjson", List("cJSON.h")),
        /* define("Clang-Index.h", "libclang", "clang", List("clang-c/Index.h")), */
        define("raylib.h", "libraylib", "raylib", List("raylib.h")),
        /* define("nuklear.h", "libnuklear", "nuklear", List("nuklear.h")), */
        /* define("sokol_gfx.h", "libsokol", "sokol", List("sokol_gfx.h")) */
      )

      List("scala", "c").foreach { lang =>
        mapping.foreach { binding =>
          val cmd = List(
            binary.toString,
            binding.packageName,
            binding.cImports.mkString(","),
            binding.linkName,
            binding.headerFile.toString,
            lang
          )
          import scala.sys.process.Process

          val destination =
            if (lang == "scala") binding.scalaFile else binding.cFile

          println(s"Executing ${cmd.mkString(" ")}")

          val result = (Process(cmd) #> file(destination.toString)) !

          println(
            s"Successfully regenerated binding ($lang) for ${binding.packageName}, $result"
          )
        }
      }

    }
  )

val regenerate = taskKey[Unit]("Regenerate known bindings")
// --------------SETTINGS-------------------------
lazy val nativeCommon = Seq(
  resolvers += Resolver.sonatypeRepo("snapshots"),
  scalaVersion := "3.1.0"
  /* libraryDependencies += ("org.scalameta" %%% "munit" % "1.0.0-M1" cross CrossVersion.for3Use2_13) % Test */
)
