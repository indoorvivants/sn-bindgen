---
title: Configuration 
mdoc:true

---

# SBT plugin 

<!--toc:start-->
- [SBT plugin](#sbt-plugin)
  - [`bindgenVersion`: _String_](#bindgenversion-string)
  - [`bindgenBinary`: _java.io.File_](#bindgenbinary-javaiofile)
  - [`bindgenMode`: `bindgen.interface.BindgenMode`](#bindgenmode-bindgeninterfacebindgenmode)
    - [Source/resource generator mode](#sourceresource-generator-mode)
    - [Manual mode](#manual-mode)
  - [CLI](#cli)
<!--toc:end-->

## `bindgenVersion`: _String_

Use this to choose another version of bindgen (by default it matches the plugin version)

## `bindgenBinary`: _java.io.File_

Use this to override the path to bindgen binary.
By default it's resolved from Sonatype for your particular platform.

```scala
bindgenBinary := baseDirectory.value / "my-custom-binary"
```

## `bindgenMode`: `bindgen.interface.BindgenMode`

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

