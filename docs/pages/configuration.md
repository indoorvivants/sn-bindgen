---
title: Configuration 
mdoc: true
order: 2
---


## SBT plugin

### Choosing a different version

Use `bindgenVersion` to choose another version of bindgen (by default it matches the plugin version)

### Overriding path to bindgen binary

`bindgenBinary` (`File`) 

By default it's resolved from Sonatype for your particular platform.

```scala
bindgenBinary := baseDirectory.value / "my-custom-binary"
```

### Different modes of operation 

```scala
bindgenMode: bindgen.interface.bindgenMode
```

This parameter controls the way the bindgen is invoked and the location where the generated files will be placed

### Source/resource generator mode 

Value `ResourceGenerator`, the **default**.

In this mode the bindings will be regenerated automatically when the project is compiled or run.

The generated files are put in locations that are usually ignored by VCS (under `target`).

### Manual mode 

Value `Manual(scalaDir: File, cDir: File)`.

In this mode you control the location of generated Scala/C files, and you need to manually invoke the generator
by calling `bindgenGenerateScalaSources` and `bindgenGenerateCSources`.

This mode is useful for bindings you don't intend to modify often, and want to the sources available in checked in 
code.

For example, the bindings to libclang which underpin this very project are generated using this mode and checked in on Github.


## CLI

```scala mdoc:passthrough
println(bindgen.BindgenRender.help())
```

