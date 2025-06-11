enablePlugins(BindgenPlugin, ScalaNativePlugin)

import bindgen.interface.Binding

scalaVersion := "3.2.1"

bindgenBindings := {
  Seq(
    Binding(
      baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
      "bindings"
    ).addCImport("header.h")
  )
}
bindgenVersion := sys.props("stable.bindgen.version")

val runBindgen = taskKey[Unit]("")

runBindgen := {
  if (sys.props("stable.bindgen.version") == "") {
    System.err.println(
      "⚠️ Scripted test for Scala Native 0.4 was not actually run, because no stable bindgen version is available"
    )
  } else {
    (Compile / bindgenGenerateAll).value
  }
}
