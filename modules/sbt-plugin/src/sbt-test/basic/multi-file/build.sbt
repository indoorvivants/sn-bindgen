enablePlugins(BindgenPlugin, ScalaNativePlugin, ScalaNativeJUnitPlugin)

import bindgen.interface.Binding
import java.util.concurrent.atomic.AtomicReference

scalaVersion := "3.3.4"

bindgenBindings := {
  Seq(
    Binding
      .builder(
        baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
        "bindings"
      )
      .withMultiFile(true)
      .addCImport("header.h")
      .build
  )
}
