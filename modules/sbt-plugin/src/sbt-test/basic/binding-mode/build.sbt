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
      .addCImport("header.h")
      .build
  )
}

Test / bindgenBindings := {
  Seq(
    Binding
      .builder(
        baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
        "testbindings"
      )
      .addCImport("header.h")
      .addClangFlag(
        "-I" + (baseDirectory.value / "src" / "main" / "resources" / "scala-native").toString
      )
      .build
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

Test / nativeConfig := {
  val config = (Test / nativeConfig).value
  config.withCompileOptions(
    config.compileOptions :+ ("-I" + (baseDirectory.value / "src" / "main" / "resources" / "scala-native").toString)
  )
}
