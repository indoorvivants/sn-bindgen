---
title: Reporting issues
mdoc: true
order: 6
---

## Reporting issues

Sometimes, sn-bindgen just doesn't work for a particular header file. Either it encounters a shape of C code it hasn't seen before, or the system header detection logic is faulty, or any of the heuristic algorithms for naming anonymous definitions breaks. 

The expectation is that **sn-bindgen should be able to handle any pure C header file** and generate code that compiles and runs. If that doesn't happen, it might be a bug. Please report it.

An ideal bug report would contain a minimised, self-contained, small C header code that directly reproduces the issue. Sometimes that's not possible or too difficult – perhaps the library in question has a lot of interconnected files and definitions, or a complicated dependency setup. 

In that case, a good bug report would use this [Dockerfile](https://docs.docker.com/reference/dockerfile/) below and modify it just enough to trigger the issue. The person working on the issue should be able to just 

1. grab the Dockerfile contents from the issue, 
2. put it in a `Dockerfile` file in an empty folder,
3. run `docker build .`,
4. see bindgen or compilation failing 

```dockerfile
FROM ubuntu:22.04

ENV BINDGEN_VERSION=@STABLE_VERSION@
ENV LLVM_VERSION=17
ENV SCALA_NATIVE_VERSION=0.5.6
ENV SCALA_VERSION=3.6.3

RUN apt update && apt install -y wget curl lsb-release software-properties-common gnupg && \
  wget https://github.com/indoorvivants/sn-bindgen/releases/download/v$BINDGEN_VERSION/sn-bindgen-$(uname -m)-pc-linux && \
  mv sn-bindgen-$(uname -m)-pc-linux /usr/bin/sn-bindgen && chmod +x /usr/bin/sn-bindgen

RUN wget https://apt.llvm.org/llvm.sh && chmod +x llvm.sh && ./llvm.sh $LLVM_VERSION

ENV LLVM_BIN=/usr/lib/llvm-$LLVM_VERSION/bin

RUN curl -Lo /usr/bin/scala-cli https://raw.githubusercontent.com/VirtusLab/scala-cli/refs/heads/main/scala-cli.sh && chmod +x /usr/bin/scala-cli && \
    scala-cli run -e "println()" -S $SCALA_VERSION --native --native-version $SCALA_NATIVE_VERSION --server=false

WORKDIR /reproduction

# Modify the commands below to reproduce the issue

# 1. Generate Scala file
RUN sn-bindgen --header /usr/include/z3.h \
               --package z3 --scala --out z3.scala \
               --llvm-bin $LLVM_BIN

# 2. Generate C file
RUN sn-bindgen --header /usr/include/z3.h \
               --package z3 --c --out z3-glue.c \
               --llvm-bin $LLVM_BIN

# 3. Make sure Scala code compiles
RUN scala-cli compile . --native --native-version $SCALA_NATIVE_VERSION -S $SCALA_VERSION --server=false
```
