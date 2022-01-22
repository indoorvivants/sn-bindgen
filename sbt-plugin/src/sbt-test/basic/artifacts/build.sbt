enablePlugins(BindgenPlugin, ScalaNativePlugin)

scalaVersion := "3.1.1"

Bindgen.bindings := { builder =>
  builder.define(baseDirectory.value / "header.h", "libtest")
}
