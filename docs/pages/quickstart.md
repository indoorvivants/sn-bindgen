---
title: Quick start
mdoc: true
---

# Installation

## SBT

**project/plugins.sbt**
```scala
// only add this line if you're living on the edge and using 
// a version that has "SNAPSHOT" in it
resolvers += Resolver.sonatypeRepo("snapshots")

addSbtPlugin("com.indoorvivants" % "bindgen-sbt-plugin" % "@VERSION@")
```

**build.sbt**

```scala
// only add this line if you're living on the edge and using 
// a version that has "SNAPSHOT" in it
resolvers += Resolver.sonatypeRepo("snapshots")
scalaVersion := "3.1.1"

enablePlugins(ScalaNativePlugin, BindgenPlugin)

Bindgen.bindings := { builder =>
  builder.define(
  /* 1 */  baseDirectory.value / "src" / "main" / "resources" / "scala-native" / "header.h",
  /* 2 */  "libtest",
  /* 3 */  cImports = List("header.h")
  )
}
```

1. Path to the header file
2. Package name where generated definitions will be put
3. List of imports that will be added to generated C files (if there are any, see [Semantics](/semantics) page for details)

There are more settings available, see [Configuration](/configuration#sbt-plugin) page for details
