Global / onChangedBuildSource := ReloadOnSourceChanges

// --------------MODULES-------------------------
lazy val bindgen = project
  .in(file("bindgen"))
  .dependsOn(libclang)
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)

lazy val libclang = project
  .in(file("libclang"))
  .enablePlugins(ScalaNativePlugin)
  .settings(nativeCommon)

// --------------SETTINGS-------------------------
lazy val nativeCommon = Seq(
  resolvers += Resolver.sonatypeRepo("snapshots"),
  scalaVersion := "3.1.0",
  nativeConfig ~= { conf =>
    conf
      .withDump(true)
      .withLinkingOptions(Seq("-lclang", "-L/opt/homebrew/opt/llvm/lib"))
      .withCompileOptions(Seq("-I/opt/homebrew/opt/llvm/include"))
  }
)
