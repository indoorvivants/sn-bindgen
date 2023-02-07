# Bindings generator for Scala 3 Native

Distributed as a SBT plugin and a CLI program, this project generates idiomatic
Scala 3 Native bindings to C libraries.

- [Documentation](https://sn-bindgen.indoorvivants.com/index.html)
- [Template](https://github.com/keynmol/sn-bindgen-template)
- [Sample bindings and usage examples](https://github.com/keynmol/sn-bindgen-examples) - Postgres, Sqlite, Tree Sitter, cJSON, Git, Lua, Redis, RocksDB, DuckDB, libuv, Cmark, s2, OpenSSL, etc.

**Status (February 2023)**: project is actively maintained, CLI interface is considered more stable than the interface in build tool plugins, but both aren't guaranteed to not change until v0.1.0

- Generates glue C code to work around Scala Native's missing interop features
- Strongly typed (where possible) interfaces to structs, unions, and functions
- Supports named enums
- Collects unnamed enums into a single location
- Extra flags to work around compiler deficiencies

![2023-02-07 13 48 03](https://user-images.githubusercontent.com/1052965/217313089-4d943f24-721e-47d0-a1c7-5afa48fbae38.gif)

_FAQ:_

- Generated bindings **do not** run on the JVM, only on [Scala Native](https://scala-native.readthedocs.io/en/latest/)
- In cases where Scala Native [cannot encode certain C idioms](https://sn-bindgen.indoorvivants.com/limitations/index.html), glue C code is generated
- The generator itself is implemented in Scala 3 Native with some C glue code to [libclang](https://clang.llvm.org/doxygen/group__CINDEX.html)
- Only C header files are supported
- Due to lack of Apple M1 runners, I am not able to build binaries for that platform. For local work, you can checkout the repo at the version you want and run 
  
  ```
  $ sbt devPublish
  ```

  Which will build the binary for your platform and publish it locally
