enablePlugins(BindgenPlugin, ScalaNativePlugin)

import bindgen.interface.Binding

scalaVersion := "3.1.1"

bindgenBindings := {
  Seq(
    Binding(
      baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
      "libtest"
    )
  )
}
