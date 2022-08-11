enablePlugins(BindgenPlugin, ScalaNativePlugin)

import bindgen.interface.Binding
import java.util.concurrent.atomic.AtomicReference

scalaVersion := "3.1.1"

bindgenBindings := {
  Seq(
    Binding(
      baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
      getPackageName.value.get
    )
  )
}

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
