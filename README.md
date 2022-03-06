# Bindings generator for Scala 3 Native

Distributed as a SBT plugin and a CLI program, this project generates idiomatic
Scala 3 Native bindings to C libraries.

- [Documentation](https://sn-bindgen.indoorvivants.com/index.html)
- [Template](https://github.com/keynmol/sn-bindgen-template)
- [Sample bindings and usage examples](https://github.com/keynmol/sn-bindgen-examples) - Postgres, Sqlite, Tree Sitter, cJSON, Git, etc.

**Status (March 2022)**: project is actively developed and maintained, interface is considered **very** unstable until v0.1.0

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
