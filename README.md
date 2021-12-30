# sn-libclang


TODO:

- [ ] unnamed enums should be exported into the global scope (sokol for example)
- [x] regular typedef enums for some reason are interpreted as structs
      this is part of a larger problem in relying on typedefs at top level
- [ ] FileWriter for some reason truncates the output - SN issue
- [x] Fix recursive structs
- [ ] implement unions (i.e. Nuklear depends on it)
