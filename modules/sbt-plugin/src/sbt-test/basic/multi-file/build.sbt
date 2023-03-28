enablePlugins(BindgenPlugin, ScalaNativePlugin, ScalaNativeJUnitPlugin)

import bindgen.interface.Binding
import java.util.concurrent.atomic.AtomicReference

scalaVersion := "3.2.2"

bindgenBindings := {
  Seq(
    Binding(
      headerFile =
        baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
      packageName = "bindings",
      multiFile = true
    )
  )
}
