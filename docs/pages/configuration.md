---
title: Configuration 
mdoc:true

---

# SBT plugin 

## `bindgenVersion`: _String_

Use this to choose another version of bindgen (by default it matches the plugin version)

## `bindgenBinary`: _java.io.File_

Use this to override the path to bindgen binary.
By default it's resolved from Sonatype for your particular platform.

```scala
bindgenBinary := baseDirectory.value / "my-custom-binary"
```

## CLI

```scala mdoc:passthrough
println(bindgen.BindgenRender.help())
```

