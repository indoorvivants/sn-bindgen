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
      .withDump(true)
      .withLinkingOptions(Seq("-lclang", "-L/opt/homebrew/opt/llvm/lib"))
      .withCompileOptions(Seq("-I/opt/homebrew/opt/llvm/include"))
  })
  .settings(
    libraryDependencies += ("com.monovore" %%% "decline" % "2.2.0" cross CrossVersion.for3Use2_13)
      .excludeAll(ExclusionRule("org.scala-native"))
  )

lazy val libclang = project
  .in(file("libclang"))
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)

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
              "-lraylib",
              "-L/opt/homebrew/opt/llvm/lib"
            )
          )
          .withCompileOptions(
            conf.compileOptions ++ Seq(
              "-I/opt/homebrew/opt/llvm/include"
              /* "-I/Users/velvetbaldmime/projects/libclang-scala3/examples/libraries", */
              /* "-DNK_IMPLEMENTATION=1" */
            )
          )
      }
    }
  })
  .settings(
    regenerate := {
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
        define(
          "Clang-Index.h",
          "libclang",
          "clang",
          List("clang-c/Index.h"),
          List("-I/opt/homebrew/opt/llvm/include")
        ),
        define(
          "raylib.h",
          "libraylib",
          "raylib",
          List("raylib.h"),
          List("-I/opt/homebrew/Cellar/llvm/13.0.0_2/lib/clang/13.0.0/include")
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

      List("scala", "c").foreach { lang =>
        mapping.foreach { binding =>
          import scala.sys.process.Process

          val destination =
            if (lang == "scala") binding.scalaFile else binding.cFile

          val cmd = binary.toString + " " + binding.toCommand + s" --$lang"

          println(s"Executing $cmd")

          val result =
            (Process(cmd) #> file(destination.toString)) !

          if (result == 0)
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
