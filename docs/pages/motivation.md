---
title: Motivation
---

As an offering, Scala Native is in an interesting place.

On the one hand, it can leverage the power of LLVM, a huge project, with literal
_thousands_ of contributors.

On the other, it has to find a place among the many new (-ish) languages, designed
from scratch to compile to machine code, with memory and execution semantics 
tailored to fit this type of execution.

Scala Native, therefore, is most attractive to developers already familiar 
with Scala, and interested in exploring the unfamiliar (after JVM) world of 
native code, dynamic and static libraries etc.

Additionally, competing with the absolutely enormous ecosystem of JVM libraries,
both written in Java and Scala, is hard.

What is also important to recognise is that (rightly or wrongly, I can't say), C 
emerged as the lingua franca for definition of binary interfaces.

Languages like [Zig](https://ziglearn.org/chapter-4/#abi), [Rust](https://doc.rust-lang.org/std/keyword.extern.html), [Go](https://pkg.go.dev/cmd/cgo#hdr-Go_references_to_C) have ways of calling external C code. Doing so requires
careful consideration with regards to the memory layout of arguments, their sizes, their positions, etc. so that an external function written in C, for example, can be invoked correctly.

It was therefore important for me to explore the ability of writing idiomatic Scala 3
code designed to leverage the power of existing C libraries, or C interfaces to 
libraries in other languages.

---

_This is the beginning of opinions, bias all over the place_

---

Short history
----

I was acutely aware of the existing [Scala 2 binding generator](https://github.com/scala-native/scala-native-bindgen/). At one point I started to dig into it to help 
move it to Scala Native 0.4.x. What I quickly realised is that I struggle to write
C++ code. And because of interaction with the compiler frontend, C++ code is almost half of the bindgen project.

So this project started as an experiment with two main goals:

1. Leveraging Scala 3 features as much as possible
   
   Things like opaque types, strict inlining, and extension methods
   are absolutely paramount to the compiletime safety of generated code 
   and runtime performance.

   See [below](#why-scala-3)

2. Minimising the amount of non-Scala code in project
   
   I am willing to bet that people who will try out Scala Native won't be
   seasoned C++ programmers (in their absolute majority), and therefore 
   will be more comfortable with Scala - sticking to it should minimise the 
   barrier of entry to contributors, which can ensure project's sustainability.

   Also, I can't write C++ or C, so there's that also.

After the initial bootstrapped binding to libclang showed me how the generated code
could look like, I continued to experiment with the C's AST, eventually arriving at a
half-baked generator with no tests that was held together by prayers alone.

What spurred me into action was figuring out (staring a lot at [sbt-protoc](https://github.com/thesamet/sbt-protoc) helped) how to publish platform-specific binaries and 
resolve them using coursier alone - after that the generation process started taking shape.

#### Why Scala 3?

At the time of writing, Scala Native is at version 0.4.4. While the ecosystem
of cross-built libraries is growing, the real-world usage remains low - which is perfectly understandable for a project so recently revived.

Multi-threading will arrive in 0.5.x, and 1.0.x is not planned yet.
All this to say that Scala Native is a very, very exciting project in its early
days, if it proves its feasibility, it is a player in the market of the near future.

So is Scala 3. The amount of improvements and new features compared to Scala 2 is hard to overestimate - and it will take some time for those features to be 
proved out in the wild, and polished enough for widespread usage.

As such, I believe that Scala Native + Scala 3 is a very powerful combination, one that
takes the experimental nature of both, and even right now provides a solid foundation for 
experiments and even user facing application.

So keeping the code generator focused on Scala 3, we can better shape the near future where 
(hopefully) this combination will become at least as popular as Scala.js.

That said, it's not a hill I will die on. It's just Scala 2 frontend is not something I will 
actively pursue - there's plenty of my own stupid bugs to keep me busy.
