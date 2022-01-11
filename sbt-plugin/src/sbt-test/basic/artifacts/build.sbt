enablePlugins(BindgenPlugin, ScalaNativePlugin)

scalaVersion := "3.1.0"

Bindgen.bindings := { builder =>
  builder.define(baseDirectory.value / "header.h", "libtest")
}
