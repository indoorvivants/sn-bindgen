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
          linkName: String
      )
      val binary = (bindgen / Compile / nativeLink).value
      val headerFilesBase = baseDirectory.value / "libraries"
      val destinationScalaBase =
        baseDirectory.value / "src" / "main" / "scala" / "bindings"
      val destinationCBase =
        baseDirectory.value / "src" / "main" / "resources" / "scala-native"

      val mapping = Map(
        "cJSON.h" -> "libcjson",
        "raylib.h" -> "libraylib",
        "sokol_gfx.h" -> "libsokol",
        "Clang-Index.h" -> "libclang",
        "nuklear.h" -> "libnuklear"
      ).map { case (headerFile, packageName) =>
        Binding(
          headerFilesBase / headerFile,
          packageName,
          destinationScalaBase / s"$packageName.scala",
          destinationCBase / s"$packageName.c",
          packageName.replaceFirst("lib", "")
        )
      }

      List("scala", "c").foreach { lang =>
        mapping.foreach { binding =>
          val cmd = List(
            binary.toString,
            binding.packageName,
            binding.linkName,
            binding.headerFile.toString,
            lang
          )
          import scala.sys.process.Process


          val destination = if(lang == "scala") binding.scalaFile else binding.cFile

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
