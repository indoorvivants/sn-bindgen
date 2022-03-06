---
title: Semantics 
mdoc: true
---

### Structs are converted to opaque types

For those types, we generate getters, setters, `Tag` definition, and two constructors, with and without parameters, allocating the struct on the heap.

```scala mdoc:passthrough
val cSource = 
"""
typedef struct {
  long long number;
} Small;

typedef struct {
  int x;
  char* hello;
  Small sm;
} Big;
"""
println(bindgen.BindgenRender.render(cSource, "libtest"))
```

### Unions are converted to opaque types

For a union with `N` members, `N` constructors will be generated,
along with getters and setters.

```scala mdoc:nest:passthrough
val cSource = 
"""
typedef struct {
  long long number;
} Small;

typedef union {
  int x;
  char* hello;
  Small sm;
} Big;
"""
println(bindgen.BindgenRender.render(cSource, "libtest"))
```

### Simple functions are converted to direct `@extern` functions

Where "Simple" means "not passing naked `structs`", because Scala Native cannot handle that (passing by pointer is okay)


```scala mdoc:nest:passthrough
val cSource = 
"""
typedef struct {
  long long number;
} Small;

long simple(int x, char *y);
Small* with_pointers(Small *x, int y);
"""
println(bindgen.BindgenRender.render(cSource, "libtest"))
```

### Problematic functions generate C forwarders

Where "Problematic" means having a struct as one of its arguments or return type.
In this case we generate several variations of public Scala functions,
but they all delegate to an external C function which takes its arguments as **pointers**, and (optionally) returns its value in a provided heap-allocated location.

```scala mdoc:nest:passthrough
val cSource = 
"""
typedef struct {
  long long number;
} Small;

void bad_arguments(Small n, Small n2);
Small bad_return_type();
"""
println(bindgen.BindgenRender.render(cSource, "libtest"))
```
