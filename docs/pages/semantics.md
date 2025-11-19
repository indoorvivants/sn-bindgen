---
title: Semantics 
mdoc: true
mdoc-version: 2.3.7
order: 3
---

## Structs are converted to opaque types

For those types, we generate getters, setters, `Tag` definition, and two `apply` methods:

1. A constructor, which takes all the parameters as arguments
2. An allocator, which only creates an instance on the heap, without initialising it

```scala mdoc:passthrough
val cSource = 
"""
|typedef struct {
|  long long number;
|} Small;
|
|typedef struct {
|  int x;
|  char* hello;
|  Small sm;
|} Big;
""".trim.stripMargin
println(bindgen.BindgenRender.render(cSource, "libtest"))
```


### You can disable constructor generation 

Some bindings (libnotify, gtk, nuklear) have such deep type hierarchies, that apply methods 
on some structs trigger an exception during bytecode generation (when compiling the generated 
code):

```
java.lang.IllegalArgumentException: UTF8 string too large
```

To work around it, you can disable constructor generation by passing a comma-separated 
list of struct names using the `--render.no-constructor` option in CLI, and `noConstructor`
parameter in the `Binding(...)` specification.

```scala mdoc:nest:passthrough
val cSource = 
"""
|typedef struct {
|  int x;
|  char* hello;
|} Enabled;
|
|typedef struct {
|  int x;
|  char* hello;
|} Disabled;
""".trim.stripMargin
println(bindgen.BindgenRender.render(cSource, "libtest", "--render.no-constructor", "Disabled"))
```


## Unions are converted to opaque types

For a union with `N` members, `N` constructors will be generated,
along with getters and setters.

```scala mdoc:nest:passthrough
val cSource = 
"""
|typedef struct {
|  long long number;
|} Small;
|
|typedef union {
|  int x;
|  char* hello;
|  Small sm;
|} Big;
""".trim.stripMargin
println(bindgen.BindgenRender.render(cSource, "libtest"))
```

## Simple functions are converted to direct `@extern` functions

Where "Simple" means "not passing naked `structs`", because Scala Native cannot handle that (passing by pointer is okay)


```scala mdoc:nest:passthrough
val cSource = 
"""
|typedef struct {
|  long long number;
|} Small;
|
|long simple(int x, char *y);
|Small* with_pointers(Small *x, int y);
""".trim.stripMargin

println(bindgen.BindgenRender.render(cSource, "libtest"))
```

## Problematic functions generate C forwarders

Where "Problematic" means having a struct as one of its arguments or return type.
In this case we generate several variations of public Scala functions,
but they all delegate to an external C function which takes its arguments as **pointers**, and (optionally) returns its value in a provided heap-allocated location.

```scala mdoc:nest:passthrough
val cSource = 
"""
|typedef struct {
|  long long number;
|} Small;
|
|void bad_arguments(Small n, Small n2);
|Small bad_return_type();
""".trim.stripMargin

println(bindgen.BindgenRender.render(cSource, "libtest"))
```

## Enums are generated for specific C type

Whatever type clang reports for a particular enum - that's the type that will be
used for the enum.

This is important, as on Windows enums are `int` by default, whereas on Linux and OS X they are `unsigned int` (if there's no negative elements).

This documentation is built on Linux.

```scala mdoc:nest:passthrough
val cSource = 
"""
|typedef enum {
|  U_X = 1,
|  U_Y = 4,
|  U_Z = 228
|} MyUnsigned;
|
|typedef enum {
|  X = -1,
|  Y = 4,
|  Z = 228
|} MySigned;
""".trim.stripMargin

println(bindgen.BindgenRender.render(cSource, "libtest"))
```

## Function pointers are defined as opaque types

The inlining in `apply` method is important - it's a restricting of Scala Native 
that the function must be statically known.

```scala mdoc:nest:passthrough
val cSource = 
"""
|typedef void* Cursor;
|typedef int (*Visitor)(Cursor*);
""".trim.stripMargin

println(bindgen.BindgenRender.render(cSource, "libtest"))
```

## Recursive structs are rewritten with opaque pointers

This is invisible to the user, so doesn't impact the experience, but 
can complicate reading the code.

Scala cannot have recursive type aliases.

```scala mdoc:nest:passthrough
val cSource = 
"""
|typedef struct Arr;
|
|typedef struct {
|  struct Arr* nested;
|} Arr;
""".trim.stripMargin
println(bindgen.BindgenRender.render(cSource, "libtest"))
```

## Global enums are rendered as constants

```scala mdoc:nest:passthrough
val cSource = 
"""
|enum {
|  HELLO = 25,
|  BYEBYE = 11
|};
|
|enum {
|  HOW=-1,
|  DOESTHIS=-2,
|  WORK=0
|};
""".trim.stripMargin

println(bindgen.BindgenRender.render(cSource, "libtest"))
```

## Anonymous unions/structs are rendered in enclosing companion object

In this example, we have several anonymous definitions as part of the struct.

If the anonymous union/struct/enum is attached to a named field, that field's 
name will be used as heuristic for naming the anonymous definition.

Otherwise, `Union0`, `Struct1`, etc. naming scheme will be used.

In the example below, `StructExample.Greeting`, `StructExample.Test`, `StructExample.Hello`,
and `StructExample.Union0` will be generated

Deep field access (e.g. calling `.x` on `StructExample` directly, like what C allows, is not supported yet,
but planned.

```scala mdoc:nest:passthrough
val cSource = 
"""
|typedef struct {
|  struct {int hello;} greeting;
|  union {int x;};
|  union {char z;} *test;
|  enum {A, B, C} hello;
|} StructExample;
""".trim.stripMargin
println(bindgen.BindgenRender.render(cSource, "libtest"))
```

