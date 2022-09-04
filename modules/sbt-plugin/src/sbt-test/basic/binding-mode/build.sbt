enablePlugins(BindgenPlugin, ScalaNativePlugin, ScalaNativeJUnitPlugin)

import bindgen.interface.Binding
import java.util.concurrent.atomic.AtomicReference

scalaVersion := "3.2.0"

bindgenBindings := {
  Seq(
    Binding(
      headerFile =
        baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
      packageName = "bindings"
    )
  )
}

Test / bindgenBindings := {
  Seq(
    Binding(
      headerFile =
        baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
      packageName = "testbindings"
    )
  )
}

import bindgen.plugin.BindgenMode

bindgenMode := {
  val scalaFolder = sourceDirectory.value / "main" / "scala" / "generated"
  val cFolder = (Compile / resourceDirectory).value / "scala-native"

  BindgenMode.Manual(scalaFolder, cFolder)
}

Test / bindgenMode := {
  val scalaFolder = sourceDirectory.value / "test" / "scala" / "generated"
  val cFolder = (Test / resourceDirectory).value / "scala-native"

  BindgenMode.Manual(scalaFolder, cFolder)
}
