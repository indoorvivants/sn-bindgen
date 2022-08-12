enablePlugins(BindgenPlugin, ScalaNativePlugin, ScalaNativeJUnitPlugin)

import bindgen.interface.Binding
import java.util.concurrent.atomic.AtomicReference

scalaVersion := "3.1.1"

testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-s", "-v")
