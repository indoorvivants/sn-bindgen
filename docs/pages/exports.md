---
title: Exports 
mdoc: true
mdoc-version: 2.3.7
---

## Exporting binary interface to Scala Native code

You can use bindgen not only to interface with C libraries,
but also to define the C-compatible interface of a Scala Native
project built as a dynamic or shared library.

Scala Native itself supports it via [`@exported` family of annotations](https://scala-native.org/en/stable/user/interop.html#exported-methods).

Say you want to expose your Scala Native code as a dynamic/shared 
library. You could manually define your functions like this:

```scala
import scalanative.unsafe.*

@exported
def MYLIB_func1(): CString = c"hello!"

@exported
def MYLIB_func2(i: Int, b: Long): Long = i * b
```

And for a simple interface with primitive types that's exactly what 
we recommend doing.

But what if your functions are more complex? They could involve structs, enums, and more complex C types than just primitives. Especially if your target runtime supports complex C types - like Swift, for example, that can work directly with header files and handle lots of different C types.

In this case, Bindgen supports a special export mode, which will do the 
following, assuming you generate bindings in package `libtest`:

1. Generate a regular Scala trait `libtest.ExportedFunctions` which will
contain all the functions from the header file 
2. Generate a `libtest.functions` object that extends `libtest.ExportedFunctions`, where each function is given a body, which invokes `libtest.impl.Implementations.<funcName>` - where `libtest.impl.Implementations` _also_ extends `libtest.ExportedFunctions` - that's where you can define implementations for your functions.

In CLI, this mode can be activated by using the `--export` flag.

If this sounds confusing, let's take a look at a very simple example, where the interface doesn't use anything other than primitive types:

```scala mdoc:passthrough
val cSource = 
    """
    |long myThing(int n, long i);
    """.trim.stripMargin
println(bindgen.BindgenRender.render(cSource, "libtest", "--export"))
```

If you attempt to compile the generated Scala code as is, it won't work - because you need to provide implementations. 

The reason implementations are expected in a separate file is to allow you to edit the header file (which defines your binary interface) separately from implementations. And the `ExportedFunctions` trait
exists to assist in defining said implementations - making it IDE friendly.

Here's an example of how you can define `Implementations`:

```scala
package libtest.impl 

import libtest.all.*

object Implementations extends libtest.ExportedFunctions:
  override def myThing(n: Int, i: Long): Long = 
    n * i
```

Now that you saw this trivial example, here's a more complex one, which uses structs. Usual restrictions
still apply - structs have to be received by address (`param: Ptr[MyStruct]`), not by value (`param: MyStruct`): 


```scala mdoc:nest:passthrough
val cSource = 
    """
    |typedef struct {
    |  int length;
    |  const char *str;
    |} MyStuff;
    |
    |long myThing(int n, const MyStuff* str);
    """.trim.stripMargin
println(bindgen.BindgenRender.render(cSource, "libtest", "--export"))
```

## On static libraries and `ScalaNativeInit`

If you read [the section about native exports](https://scala-native.org/en/stable/user/interop.html#exported-methods), you can see a reminder to call `ScalaNativeInit()` function to 
initialise the Scala Native GC runtime. 

Therefore if you are interacting with an ecosystem that handles C header files natively (like Swift),
it's convenient to put `ScalaNativeInit` into the header file that defines your binary interface.

Bindgen recognises that and doesn't render this function as part of the bindings. 
The function has to exactly match the `int ScalaNativeInit(void)` type to be filtered out.
