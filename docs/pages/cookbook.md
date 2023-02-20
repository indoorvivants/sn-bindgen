---
title: Cookbook
---

<!--toc:start-->
- [Generating bindings from multiple header files](#generating-bindings-from-multiple-header-files)
- [Rendering the binding as multiple files](#rendering-the-binding-as-multiple-files)
- [(advanced) Splitting the binding into multiple packages](#advanced-splitting-the-binding-into-multiple-packages)
  - [By definition header file location](#by-definition-header-file-location)
  - [By definition name](#by-definition-name)
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
bindgenBindings += {
    Binding
      .builder(
        (Compile / baseDirectory).value / "openssl-amalgam.h",
        "openssl"
      )
      .withCImports(List("openssl/sha.h", "openssl/evp.h"))
      .withClangFlags(List("-I" + vcpkgConfigurator.value.includes("openssl")))
      .build
}
```

Example taken from [sn-bindgen-examples](https://github.com/indoorvivants/sn-bindgen-examples/blob/82c109aac423c1adacaf1a2a1458d6d0afdea7b6/build.sbt#L374)

## Rendering the binding as multiple files

In case of really big bindings (think Glib from Gnome), a single file may be unwieldy and take a very long time 
to compile.

You can help the situation by using the multi-file mode - where the bindgen will treat `--out` parameter 
as a folder and create several files there with definitions broken down by type.

- To enable multi-file mode in CLI, use `--multi-file` parameter.
- To enable multi-file mode in SBT, use `multiFile = true` in Binding specification.

## (advanced) Splitting the binding into multiple packages

_Note: this technique is annoyingly manual, prone to errors and should only be used if rendering the binding as a single entity breaks the compiler_

This option was heavily inspired by Gtk bindings, which are actually comprised of:

1. Glib, which itself consists of 
   - Glib itself
   - GIO
   - GObject
2. Pango (which depends on Glib)
3. Cairo
4. Harfbuzz
5. etc.

Because of how includes in C work, you get _all_ of those libraries bundled in the binding, which can be very annoying and difficult for compiler to work with.

To work around it, we can build bindings to constituent libraries separately, and then,
when building the Gtk bindings, tell the generator to not render Pango, Cairo, etc. definitions again, but rather assume that they will come from a certain package.

We can indicate this binding splitting in two ways - by header file location, or by definition name.

### By definition header file location

In the CLI: `--render.external-path */glib-2.0/*=glib`

In the Binding builder: `.withExternalPaths(Map("*/glib-2.0/*" -> "glib"))`

This will ensure that for all definitions that are defined in header files that match `*/glib-2.0/*` glob, they will be rendered as references in package `glib` instead.

### By definition name

In the CLI: `--render.external-name Gtk*=gtk`

In the Binding builder: `.withExternalNames(Map("Gtk*" -> "gtk"))`

This will ensure that all definitions that whose name matches `Gtk*` will be rendered as references in package `gtk` instead.
