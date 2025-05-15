import scala.scalanative.build
import sbt.internal.bsp.BuildTarget
import scala.collection.immutable
import _root_.bindgen.plugin.BindgenMode
import scala.scalanative.build.GC
import coursierapi.ResolutionParams
import coursierapi.Repository
import sbt.io.Using
import java.util.stream.Collectors
import java.nio.file.Files
import scala.scalanative.build.Mode
import scala.scalanative.build.NativeConfig
import scala.scalanative.build.LTO
import commandmatrix.extra.*
import com.indoorvivants.detective.Platform
import Platform.*
import scala.scalanative.build.*

import _root_.bindgen.interface.*
import ArtifactNames.*

import java.nio.file.Paths

lazy val Versions = new {
  val decline = "2.5.0"
  val scribe = "3.15.3"
  val scalaNative = nativeVersion
  val junit = "0.13.3"
  val scalameta = "4.5.13"
  val pluginTargetSN = "0.5.6"
  val pluginTargetSBT = "1.10.7"
  val detective = "0.1.0"
  val opaqueNewtypes = "0.1.0"

  val Scala3 = "3.3.4"
  val Scala212 = "2.12.20"
  val Scala213 = "2.13.16"
  val Scala2 = List(Scala212, Scala213)

}

inThisBuild(
  Seq(
    semanticdbIncludeInJar := false,
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

// --------------MODULES-------------------------
lazy val root = project
  .in(file("."))
  .aggregate(bindgen, libclang)
  .aggregate(iface.projectRefs*)
  .aggregate(plugin.projectRefs*)
  .aggregate(tests.projectRefs*)
  .settings(remoteCacheSettings, noPublish)

lazy val iface = projectMatrix
  .in(file("modules/interface"))
  .settings(remoteCacheMatrixSettings)
  .someVariations(
    Versions.Scala2 :+ Versions.Scala3,
    List(
      VirtualAxis.jvm,
      VirtualAxis.native
    )
  )(
    MatrixAction.ForScala(_.isScala2).Settings(scalacOptions += "-Xsource:3"),
    MatrixAction
      .ForPlatform(VirtualAxis.native)
      .Configure(_.enablePlugins(ScalaNativeJUnitPlugin)),
    MatrixAction
      .ForPlatform(VirtualAxis.jvm)
      .Settings(
        Seq(
          Test / fork := true,
          libraryDependencies += "com.github.sbt" % "junit-interface" % Versions.junit % Test
        )
      )
  )
  .settings(
    moduleName := "bindgen-interface",
    libraryDependencies += "com.indoorvivants.detective" %%% "platform" % Versions.detective,
    scalacOptions += "-deprecation",
    scalacOptions += {
      if (scalaBinaryVersion.value.startsWith("2.12")) "-Ywarn-unused-import"
      else "-Wunused:imports"
    }
  )
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoPackage := "bindgen.interface",
    buildInfoKeys := Seq[BuildInfoKey](
      version,
      scalaVersion,
      scalaBinaryVersion
    )
  )
  .settings(noTests)

lazy val bindgen = project
  .in(file("modules/bindgen"))
  .dependsOn(libclang)
  .enablePlugins(ScalaNativePlugin, ScalaNativeJUnitPlugin, BuildInfoPlugin)
  .settings(nativeCommon)
  .settings(Compile / nativeConfig ~= environmentConfiguration)
  .settings(nativeConfig ~= usesLibClang)
  .settings(
    nativeConfig ~= (_.withIncrementalCompilation(true)
      .withSourceLevelDebuggingConfig(SourceLevelDebuggingConfig.enabled))
  )
  .settings(remoteCacheSettings)
  .settings(
    buildInfoPackage := "bindgen",
    buildInfoKeys := Seq[BuildInfoKey](
      version,
      scalaVersion,
      scalaBinaryVersion,
      BuildInfoKey("nativeVersion" -> nativeVersion)
    ),
    moduleName := "bindgen",
    libraryDependencies += "com.indoorvivants.detective" %%% "platform" % Versions.detective,
    libraryDependencies += "com.monovore" %%% "decline" % Versions.decline,
    libraryDependencies += "com.outr" %%% "scribe" % Versions.scribe,
    libraryDependencies += "com.indoorvivants" %%% "opaque-newtypes" % Versions.opaqueNewtypes,
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-s", "-v"),
    scalacOptions += "-Wunused:all"
  )
  .settings {
    detectBinaryArtifacts
      .map { case (_, (artifact, file)) =>
        addArtifact(Def.setting(artifact), Def.task(file))
      }
      .toSeq
      .flatten
  }
  .settings(
    checkDetectedArtifacts := {
      import Platform.*, Target.*, OS.*, Arch.*, Bits.*
      val expected = Seq(
        Target(Windows, Intel, x64),
        Target(MacOS, Intel, x64),
        Target(Linux, Intel, x64)
      ).map(jarString)
      val packaged = packagedArtifacts.value

      expected.foreach { classifier =>
        assert(
          packaged.exists(_._1.classifier.contains(classifier)),
          s"Artifact with $classifier was not found"
        )
      }
    }
  )

val checkDetectedArtifacts = taskKey[Unit]("")

lazy val binaryArtifacts = project
  .in(file("build/binary-artifacts"))
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)
  .settings(noTests)
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
      Def.setting(build(jarString(Platform.target))),
      Def.task { (bindgen / Compile / nativeLink).value }
    )
  }

lazy val plugin = projectMatrix
  .in(file("modules/sbt-plugin"))
  .dependsOn(iface)
  .defaultAxes(VirtualAxis.scalaABIVersion(Versions.Scala212), VirtualAxis.jvm)
  .allVariations(List(Versions.Scala212), List(VirtualAxis.jvm))
  .settings(remoteCacheMatrixSettings)
  .settings(
    sbtPlugin := true,
    addSbtPlugin(
      "org.scala-native" % "sbt-scala-native" % Versions.pluginTargetSN
    ),
    pluginCrossBuild / sbtVersion := Versions.pluginTargetSBT,
    moduleName := "bindgen-sbt-plugin",
    scriptedLaunchOpts := {
      scriptedLaunchOpts.value ++
        Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
    },
    scalacOptions += "-Ywarn-unused-import",
    scriptedBufferLog := false,
    publishLocal := publishLocal
      .dependsOn(
        localBindgenArtifact / publishLocal
      )
      .value
  )
  .enablePlugins(ScriptedPlugin, SbtPlugin)

lazy val libclang = project
  .in(file("modules/libclang"))
  .enablePlugins(ScalaNativePlugin, BindgenPlugin)
  .disablePlugins(ScalafixPlugin)
  .settings(nativeCommon)
  .settings(nativeConfig ~= usesLibClang)
  .settings(remoteCacheSettings)
  .settings(
    moduleName := "bindgen-libclang",
    bindgenMode := BindgenMode.Manual(
      scalaDir = ((Compile / sourceDirectory).value / "scala" / "generated"),
      cDir = (Compile / resourceDirectory).value / "scala-native" / "generated"
    ),
    bindgenBinary := sys.env
      .get("SN_BINDGEN_BINARY_OVERRIDE")
      .map(new File(_))
      .get,
    // .getOrElse((LocalProject("bindgen") / Compile / nativeLink).value),
    bindgenBindings := {
      val detected =
        llvmFolder(nativeConfig.value.clang.toAbsolutePath()).llvmInclude

      detected match {
        case head :: tl =>
          val include = new File(head)
          Seq(
            Binding(include / "clang-c" / "Index.h", "libclang")
              .withClangFlags(List(s"-I$head", "-fsigned-char"))
              .addCImport("clang-c/Index.h")
              .withMultiFile(true)
              .withFlavour(Flavour.ScalaNative05)
          )
        case immutable.Nil =>
          sLog.value.error(
            "Failed to detect LLVM installation - you won't be able to link the binary and regenerate libclang bindings. " +
              "Please use LLVM_BIN environment variable to point at the `bin/` folder of your LLVM installation"
          )
          Seq.empty
      }
    }
  )

val runExportTests = taskKey[Unit]("")

lazy val exportTestsLibrary: Project = project
  .in(file("modules/export-tests/library"))
  .enablePlugins(ScalaNativePlugin, BindgenPlugin)
  .settings(
    scalaVersion := Versions.Scala3,
    bindgenBinary := (bindgen / Compile / nativeLink).value,
    bindgenBindings := {
      val dir = (Compile / sourceDirectory).value / "c"

      collectBindings(dir)
    },
    nativeConfig ~= (_.withBuildTarget(build.BuildTarget.libraryDynamic)),
    noPublish,
    runExportTests := {

      if (Platform.os != Platform.OS.Windows) {
        val library = (Compile / nativeLink).value
        val clang = (Compile / nativeConfig).value.clang
        val sourcesDir = (Compile / sourceDirectory).value / "c"
        val workDir = library.getParentFile()
        import scala.sys.process.*

        val destination = workDir / "a.out"
        val cmd = Seq(
          clang,
          sourcesDir / "run_tests.c",
          "-o",
          destination,
          "-lexporttestslibrary",
          s"-L${workDir}"
        ).map(_.toString())

        val stderr = List.newBuilder[String]
        val stdout = List.newBuilder[String]

        val logger = ProcessLogger.apply(
          (o: String) => stdout += o,
          (e: String) => stderr += e
        )

        val errPrintln: String => Unit = s => System.err.println(s)

        val process = new java.lang.ProcessBuilder(cmd*)
          .directory(workDir)
          .start()

        scala.io.Source
          .fromInputStream(process.getErrorStream())
          .getLines()
          .foreach(errPrintln(_))

        assert(
          process.waitFor() == 0,
          "Building export tests binary (with clang) failed"
        )

        val testsProcessB = (new java.lang.ProcessBuilder(destination.toString))
          .directory(workDir)

        testsProcessB.environment().put("LD_LIBRARY_PATH", workDir.toString)
        testsProcessB.environment().put("DYLD_LIBRARY_PATH", workDir.toString)

        val testsProcess = testsProcessB.start()

        scala.io.Source
          .fromInputStream(testsProcess.getErrorStream())
          .getLines()
          .foreach(errPrintln(_))

        assert(
          testsProcess.waitFor() == 0,
          "Running export tests failed"
        )
      } else
        System.err.println("Skipping export tests on windows")
    }
  )

lazy val tests = projectMatrix
  .in(file("modules/tests"))
  .dependsOn(iface)
  .settings(remoteCacheMatrixSettings)
  .someVariations(
    Versions.Scala2 :+ Versions.Scala3,
    List(
      VirtualAxis.jvm,
      VirtualAxis.native
    )
  )(
    MatrixAction((sv, axes) =>
      sv.isScala2 && axes.contains(VirtualAxis.native)
    ).Skip,
    MatrixAction.ForScala(_.isScala2).Settings(scalacOptions += "-Xsource:3"),
    MatrixAction
      .ForPlatform(VirtualAxis.native)
      .Configure(
        _.enablePlugins(ScalaNativeJUnitPlugin, BindgenPlugin)
          .settings(nativeCommon)
          .settings(Compile / nativeConfig ~= environmentConfiguration)
          .settings(
            Compile / bindgenBinary := (bindgen / Compile / nativeLink).value,
            Test / bindgenBinary := (bindgen / Compile / nativeLink).value,
            bindgenBindings := Seq.empty,
            bindgenBinary := (bindgen / Compile / nativeLink).value,
            Test / bindgenBindings := {
              collectBindings((Test / resourceDirectory).value / "scala-native")
            }
          )
      ),
    MatrixAction
      .ForPlatform(VirtualAxis.jvm)
      .Settings(
        Seq(
          Test / fork := true,
          Test / envVars += "BINARY" -> (bindgen / Compile / nativeLink).value.toString,
          Test / envVars += "BINDGEN_CLANG_PATH" -> (bindgen / Compile / nativeConfig).value.clang.toString,
          libraryDependencies += "com.github.sbt" % "junit-interface" % Versions.junit % Test
        )
      )
  )
  .settings(
    publish / skip := true,
    publishLocal / skip := true,
    testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-s", "-v"),
    Test / sources := {
      val defaults = (Test / sources).value
      if (Platform.os == Platform.OS.Windows)
        defaults.filterNot(_.toString.toLowerCase.contains("no-windows"))
      else defaults
    }
  )

lazy val scalaNativeLibParser = project
  .in(file("modules/scalaNativeLib"))
  .settings(scalaVersion := Versions.Scala213)
  .settings(
    libraryDependencies += "org.scalameta" %% "scalameta" % Versions.scalameta,
    scalacOptions += "-Xsource:3"
  )

lazy val docs =
  project
    .in(file("docs"))
    .enablePlugins(SubatomicPlugin)
    .settings(
      scalaVersion := Versions.Scala3,
      fork := true,
      publish / skip := true,
      Compile / run / envVars := Map(
        "BINDGEN_BINARY" -> (bindgen / Compile / nativeLink).value.toString()
      ),
      subatomicMdocVariables ++= previousStableVersion.value
        .map("STABLE_VERSION" -> _)
        .toMap,
      libraryDependencies += "com.lihaoyi" %% "scalatags" % "0.12.0"
    )
// --------------HELPERS-------------------------

def artifactFileNames: Map[Target, String] = {
  import Platform.OS
  import Platform.Arch
  import Platform.Bits

  val artifacts = for {
    os <- Seq(OS.Windows, OS.Linux, OS.MacOS)
    arch <- Seq(Arch.Intel, Arch.Arm)
    bits <- Seq(Bits.x32, Bits.x64)
    target = Platform.Target(os, arch, bits)
    ext = os match {
      case OS.Windows => ".exe"
      case _          => ""
    }
    fileName = s"sn-bindgen-${coursierString(target)}$ext"
  } yield target -> fileName

  artifacts.toMap
}

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

  import scala.collection.JavaConverters.*

  val allFiles = Files
    .walk(folder.toPath)
    .filter(path => path.toFile().isFile())
    .collect(Collectors.toList())
    .asScala
    .map { path =>
      path.getFileName().toString -> path.toFile
    }
    .toMap

  artifactFileNames.flatMap { case (target, fileName) =>
    allFiles.get(fileName).map { file =>
      build(jarString(target), file)
    }
  }.toMap

} else Map.empty

def environmentConfiguration(conf: NativeConfig): NativeConfig = {
  var modified = conf
  if (sys.env.contains("SN_RELEASE"))
    modified = modified.withMode(Mode.releaseFast)

  if (sys.env.contains("SN_SANITIZE")) {
    val opts =
      "-fsanitize=address -fno-omit-frame-pointer -fsanitize-address-use-after-return=always"
        .split(' ')
        .toList

    modified = modified
      .withLinkingOptions(modified.linkingOptions ++ opts)
      .withCompileOptions(modified.compileOptions ++ opts)
      .withOptimize(false)
      .withMode(Mode.debug)
      .withLTO(LTO.none)
  }

  if (sys.env.contains("SN_GC"))
    modified = modified.withGC(GC.apply(sys.env("SN_GC")))

  modified
}

def usesLibClang(conf: NativeConfig) = {
  val libraryName =
    if (Platform.os == Platform.OS.Windows) "libclang" else "clang"

  val detected = llvmFolder(conf.clang.toAbsolutePath())

  val arm64 =
    if (Platform.arch == Platform.Arch.Arm) Seq("-arch", "arm64") else Seq.empty

  conf
    .withLinkingOptions(
      conf.linkingOptions ++
        Seq("-l" + libraryName) ++
        detected.llvmLib.map("-L" + _) ++ arm64
    )
    .withCompileOptions(
      conf.compileOptions ++ detected.llvmInclude.map("-I" + _) ++ arm64
    )
}

// --------------SETTINGS-------------------------

ThisBuild / resolvers ++= Resolver.sonatypeOssRepos("snapshots")

lazy val markdownDocuments = taskKey[Seq[java.nio.file.Path]]("")
markdownDocuments := {
  markdownDocuments.inputFiles
}

markdownDocuments / fileInputs ++=
  Seq(
    (docs / baseDirectory).value.toGlob / "**" / "*.md",
    (docs / baseDirectory).value.toGlob / "**" / "*.css",
    (
      docs / baseDirectory
    ).value.toGlob / "**" / "*.js"
  )

lazy val buildBinary = inputKey[File]("")
buildBinary := {
  import complete.DefaultParsers.*
  val args: Seq[String] = spaceDelimited("<arg>").parsed

  val built = (bindgen / Compile / nativeLink).value
  val name =
    args.headOption.getOrElse {
      if (Platform.os == Platform.OS.Windows) "bindgen.exe" else "bindgen"
    }
  val dest = (ThisBuild / baseDirectory).value / "bin" / name

  IO.copyFile(built, dest)

  dest
}

lazy val buildPlatformBinary = taskKey[File]("")
buildPlatformBinary := {

  val target = Platform.target
  val name = artifactFileNames(target)

  val built = (bindgen / Compile / nativeLink).value
  val dest = (ThisBuild / baseDirectory).value / "bin" / name

  IO.copyFile(built, dest)

  sLog.value.info(s"Platform binary built in ${dest}")

  dest
}

lazy val nativeCommon = Seq(
  scalaVersion := Versions.Scala3
)

lazy val noTests = Seq(
  test := {}
)

lazy val noPublish = Seq(
  publish / skip := true,
  publishLocal / skip := true
)

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val versionDump =
  taskKey[Unit]("Dumps the version in a file named version")

versionDump := {
  val file = (ThisBuild / baseDirectory).value / "version"
  IO.write(file, (Compile / version).value)
}

def collectBindings(headersPath: File) = {
  val files = headersPath.toGlob / "**" / "*.h"
  import scala.collection.JavaConverters.*
  val headerSpec = Files
    .walk(headersPath.toPath, 1)
    .collect(Collectors.toList())
    .asScala
    .filter(_.toFile().isFile())
    .filter(_.toFile.ext == "h")
    .map(h =>
      h.toFile -> headersPath.toPath
        .relativize(h)
        .toString
        .dropRight(2)
    )
    .toMap

  def directives(pref: String, lines: List[String]): List[String] =
    lines
      .map(_.trim)
      .filter(_.startsWith(pref))
      .map(_.stripPrefix(pref).trim)
      .flatMap(_.split(" "))
      .map(_.trim)

  headerSpec.toSeq.map { case (header, name) =>
    val lines = IO.readLines(header)
    val contents = directives("//!bindgen:", lines)
    val pkg = directives("//!bindgen-package:", lines).headOption
    val multiFileFlag = "--multi-file"
    val isMultiFile = contents.contains(multiFileFlag)

    Binding(header, pkg.getOrElse(s"lib_test_$name"))
      .addCImport(s"$name.h")
      .withBindgenArguments(contents.filterNot(_ == multiFileFlag))
      .withMultiFile(isMultiFile)
      .addClangFlag("-fsigned-char")
  }
}

def llvmFolder(clangPath: java.nio.file.Path): LLVMInfo = {
  import Platform.OS.*

  val LLVM_MAJOR_VERSION = "17"

  Platform.os match {
    case MacOS =>
      val detected =
        sys.env
          .get("LLVM_BIN")
          .map(Paths.get(_))
          .map(_.getParent)
          .filter(_.toFile.exists)
          .toList

      val speculative =
        if (detected.isEmpty)
          List(
            Paths.get(s"/usr/local/opt/llvm@$LLVM_MAJOR_VERSION"),
            Paths.get("/usr/local/opt/llvm"),
            Paths.get(s"/opt/homebrew/opt/llvm@$LLVM_MAJOR_VERSION"),
            Paths.get("/opt/homebrew/opt/llvm")
          )
        else Nil

      val all = (detected ++ speculative).dropWhile(!_.toFile.exists())

      val includes = all
        .map(_.resolve("include"))
        .map(_.toAbsolutePath().toString)

      val lib = all
        .map(_.resolve("lib"))
        .map(_.toAbsolutePath().toString)

      LLVMInfo(
        llvmInclude = includes,
        llvmLib = lib
      )
    case Linux | Windows =>
      // <llvm-path>/bin/clang
      val realPath = clangPath.toRealPath()
      val binFolder = realPath.getParent()
      val llvmFolder = binFolder.getParent()

      if (llvmFolder.toFile.exists())
        LLVMInfo(
          llvmInclude = List(llvmFolder.resolve("include").toString),
          llvmLib = List(llvmFolder.resolve("lib").toString)
        )
      else LLVMInfo(Nil, Nil)
    case _ => LLVMInfo(Nil, Nil)
  }
}

import sbtwelcome.*

logo :=
  s"""
     | C Binding generator for Scala 3 Native
     |
     | ######                                       
     | #     # # #    # #####   ####  ###### #    # 
     | #     # # ##   # #    # #    # #      ##   # 
     | ######  # # #  # #    # #      #####  # #  # 
     | #     # # #  # # #    # #  ### #      #  # # 
     | #     # # #   ## #    # #    # #      #   ## 
     | ######  # #    # #####   ####  ###### #    # 
     |
     |Version: ${version.value}
     |Scala Native: ${nativeVersion}
     |
     |${scala.Console.YELLOW}Scala ${(bindgen / scalaVersion).value}${scala.Console.RESET}
     |
     |""".stripMargin

usefulTasks := Seq(
  UsefulTask("buildBinary", "Build bindgen binary and copy it into bin/ folder")
    .alias("bb"),
  UsefulTask(
    "interfaceTests",
    "Run tests for JVM artifacts that interact with CLI (Scala 2.12, 2.13, 3)"
  ).alias("itt"),
  UsefulTask("cliTests", "Run tests for just the CLI flags parsing").alias(
    "ctt"
  ),
  UsefulTask(
    "generatorTests",
    "Tests for generated code and its runtime correctness"
  ).alias("gtt"),
  UsefulTask(
    "pluginTests",
    "Run SBT plugin tests"
  ).alias("ptt"),
  UsefulTask(
    "exportTests",
    "Tests for generated exported definitions"
  ).alias("ett"),
  UsefulTask(
    "buildWebsite",
    "Build the website"
  ).alias("bw"),
  UsefulTask(
    "buildWebsiteQuick",
    "Build the website (quick, no mdoc)"
  ).alias("bwq"),
  UsefulTask(
    "devPublish",
    "Build and publish everything sn-bindgen needs to your local cache"
  ).alias("dp"),
  UsefulTask(
    "ci",
    "Run exactly what CI runs"
  ),
  UsefulTask(
    "preCI",
    "Run formatting/scalafix"
  )
)

addCommandAlias("generatorTests", "testsNative3/clean; testsNative3/test")
addCommandAlias("cliTests", "bindgen/test")
addCommandAlias("pluginTests", "plugin/scripted")
addCommandAlias(
  "exportTests",
  "exportTestsLibrary/runExportTests"
)
addCommandAlias("interfaceTests", "tests/test; tests3/test; tests2_12/test")
addCommandAlias(
  "ci",
  "clean; scalafixEnable; scalafmtCheckAll; scalafmtSbtCheck; cliTests;" +
    "interfaceTests; pluginTests; generatorTests; exportTests"
)

addCommandAlias(
  "devPublish",
  "publishLocal; localBindgenArtifact/publishLocal; show bindgen/version"
)

val scalafixRules = Seq(
  "OrganizeImports",
  "DisableSyntax",
  "LeakingImplicitClassVal",
  "NoValInForComprehension"
).mkString(" ")

val PrepareCICommands = Seq(
  "scalafixEnable",
  s"scalafix --rules $scalafixRules",
  "scalafmtAll",
  "scalafmtSbt"
)
addCommandAlias("preCI", PrepareCICommands.mkString(";"))

logoColor := scala.Console.MAGENTA

lazy val buildWebsite = taskKey[Unit]("Build website in _site folder")
buildWebsite := Def.taskDyn {
  val root = (ThisBuild / baseDirectory).value / "_site"

  (docs / Compile / run).toTask(
    s" build --destination ${root.toString} --force"
  )
}.value

lazy val buildWebsiteQuick =
  taskKey[Unit]("Build website in _site folder (without Mdoc)")
buildWebsiteQuick := Def.taskDyn {
  val root = (ThisBuild / baseDirectory).value / "_site"

  (docs / Compile / run).toTask(
    s" build --destination ${root.toString} --force --disable-mdoc"
  )
}.value

def artifactName(nm: String, axes: Seq[VirtualAxis]) = {
  nm + axes
    .sortBy[Int] {
      case _: VirtualAxis.ScalaVersionAxis => 0
      case _: VirtualAxis.PlatformAxis     => 1
      case _: VirtualAxis.StrongAxis       => 2
      case _: VirtualAxis.WeakAxis         => 3
    }
    .map(_.idSuffix)
    .mkString("-", "-", "")
}

lazy val remoteCacheMatrixSettings = Seq(
  pushRemoteCacheTo := Some(
    MavenCache(
      "local-cache",
      (ThisBuild / baseDirectory).value / "target" / "remote-cache"
    )
  ),
  Compile / packageCache / moduleName := artifactName(
    moduleName.value,
    virtualAxes.value
  )
)

lazy val remoteCacheSettings = Seq(
  pushRemoteCacheTo := Some(
    MavenCache(
      "local-cache",
      (ThisBuild / baseDirectory).value / "target" / "remote-cache"
    )
  )
)

lazy val generateScalaNativeDefinitions = taskKey[Unit]("")

generateScalaNativeDefinitions := Def.taskDyn {
  val tg = (scalaNativeLibParser / Keys.target).value / "github"
  val destination = tg / "scala-native"
  IO.createDirectory(destination)

  import sys.process.*
  def fetchTags =
    Process(s"git fetch --tags", destination).!

  def checkout =
    Process(s"git checkout v${nativeVersion}", destination).!

  def clone =
    Process(
      s"git clone https://github.com/scala-native/scala-native.git $destination",
      tg
    ).!!

  if ((destination / "build.sbt").isFile()) {
    fetchTags; checkout
  } else {
    println(clone); fetchTags; checkout
  }

  val targetFile =
    (bindgen / sourceDirectory).value / "main" / "scala" / "BuiltinType.scala"
  assert(targetFile.isFile(), s"$targetFile must exist (or was it renamed?)")

  (scalaNativeLibParser / Compile / run).toTask(s" $destination $targetFile")
}.value
