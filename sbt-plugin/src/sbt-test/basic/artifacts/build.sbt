enablePlugins(BindgenPlugin, ScalaNativePlugin, ScalaNativeJUnitPlugin)

import bindgen.interface.Binding
import java.util.concurrent.atomic.AtomicReference

scalaVersion := "3.1.1"

bindgenBindings := {
  Seq(
    Binding(
      headerFile =
        baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
      packageName = getPackageName.value.get
    )
  )
}

Test / bindgenBindings := {
  Seq(
    Binding(
      headerFile =
        baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
      packageName = "gentests"
    )
  )
}

testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-s", "-v")

val changePackageName = taskKey[Unit]("")

changePackageName := {
  println(getPackageName.value.set("libtest2"))
}

val revertPackageName = taskKey[Unit]("")

revertPackageName := {
  getPackageName.value.set("libtest")
}

val getPackageName = settingKey[AtomicReference[String]]("")

getPackageName := {
  new AtomicReference[String]("libtest")
}
