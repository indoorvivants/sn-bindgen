# Bindings generator for Scala 3 Native

[![bindgen-interface Scala version support](https://index.scala-lang.org/indoorvivants/sn-bindgen/bindgen-interface/latest.svg)](https://index.scala-lang.org/indoorvivants/sn-bindgen/bindgen-interface)

Distributed as a SBT plugin and a CLI program, this project generates idiomatic
Scala 3 Native bindings to C libraries using libclang.

- [Documentation](https://sn-bindgen.indoorvivants.com/index.html)
- [Template](https://github.com/keynmol/sn-bindgen-template)
- [Sample bindings and usage examples](https://github.com/keynmol/sn-bindgen-examples) - Postgres, Sqlite, Tree Sitter, cJSON, Git, Lua, Redis, RocksDB, DuckDB, libuv, Cmark, s2, OpenSSL, etc.

**Status (February 2024)**: project it actively maintained, and is used in several applications

- Generates glue C code to work around Scala Native's missing interop features
- Strongly typed (where possible) interfaces to structs, unions, and functions
- Supports named enums
- Collects unnamed enums into a single location
- Extra flags to work around compiler deficiencies
