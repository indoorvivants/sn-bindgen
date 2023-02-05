---
title: Cookbook
---

<!--toc:start-->
- [Generating bindings from multiple header files](#generating-bindings-from-multiple-header-files)
<!--toc:end-->

## Generating bindings from multiple header files

Some libraries break apart their functionality among several header files, that you are supposed to pick and choose.

The tools provided by clang to figure out which definition came from which file are quite crude, and the logic 
to merge results would be quite complex to be attempted.

You can use the amalgam pattern, by pointing the binding generator not at a file in the library, but your own header file that includes them.

For example, with OpenSSL, I would write a `openssl-amalgam.h`:

```c
#include "openssl/sha.h"
#include "openssl/evp.h"
```

And point the binding generator at it:

```scala
bindgenBindings := {
  Seq(
    Binding(
      (Compile / baseDirectory).value / "openssl-amalgam.h",
      "openssl",
      cImports = List("openssl/sha.h", "openssl/evp.h"),
      clangFlags = List("-I" + vcpkgConfigurator.value.includes("openssl"))
    )
  )
}
```

Example taken from [sn-bindgen-examples](https://github.com/indoorvivants/sn-bindgen-examples/blob/82c109aac423c1adacaf1a2a1458d6d0afdea7b6/build.sbt#L374)

## Rendering the binding as multiple files

In case of really big bindings (think Glib from Gnome), a single file may be unwieldy and take a very long time 
to compile.

You can help the situation by using the multi-file mode - where the bindgen will treat `--out` parameter 
as a folder and create several files there with definitions broken down by type.

To enable multi-file mode in CLI, use `--multi-file` parameter.
To enable multi-file mode in SBT, use `multiFile = true` in Binding specification.
