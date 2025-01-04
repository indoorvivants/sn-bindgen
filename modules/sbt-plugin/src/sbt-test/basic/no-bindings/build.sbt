enablePlugins(BindgenPlugin, ScalaNativePlugin, ScalaNativeJUnitPlugin)

import bindgen.interface.Binding
import java.util.concurrent.atomic.AtomicReference

scalaVersion := "3.3.4"

testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-s", "-v")
