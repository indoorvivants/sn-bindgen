resolvers += Resolver.sonatypeRepo("snapshots")
scalaVersion := "3.1.0"

enablePlugins(ScalaNativePlugin)
Global / onChangedBuildSource := ReloadOnSourceChanges
nativeConfig ~= { conf =>
  conf
    .withDump(true)
    .withLinkingOptions(Seq("-lclang", "-L/opt/homebrew/opt/llvm/lib"))
    .withCompileOptions(Seq("-I/opt/homebrew/opt/llvm/include"))
}

/* scalacOptions += "-Yretain-trees" */
