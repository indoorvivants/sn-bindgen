enablePlugins(BindgenPlugin, ScalaNativePlugin, ScalaNativeJUnitPlugin)

import bindgen.interface.Binding
import java.util.concurrent.atomic.AtomicReference

scalaVersion := "3.8.3"

bindgenBindings := {
  Seq(
    Binding(
      baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
      getPackageName.value.get
    )
  )
}

Test / bindgenBindings := {
  Seq(
    Binding(
      baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
      "gentests"
    )
  )
}

testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-s", "-v")

@transient
val changePackageName = taskKey[Unit]("")

changePackageName := {
  println(getPackageName.value.set("libtest2"))
}

@transient
val revertPackageName = taskKey[Unit]("")

revertPackageName := {
  getPackageName.value.set("libtest")
}

val getPackageName = settingKey[AtomicReference[String]]("")

getPackageName := {
  new AtomicReference[String]("libtest")
}
