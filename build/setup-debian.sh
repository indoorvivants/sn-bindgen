#!/usr/bin/sh

LLVM_VERSION=$1

apt update && apt install -y curl && \
    curl -Lo /usr/local/bin/sbt https://raw.githubusercontent.com/sbt/sbt/1.8.x/sbt && \
    chmod +x /usr/local/bin/sbt && \
    curl -Lo llvm.sh https://apt.llvm.org/llvm.sh && \
    chmod +x llvm.sh && \
    apt install -y lsb-release wget software-properties-common gnupg autopoint libtool git && \
    ./llvm.sh $LLVM_VERSION && \
    apt install libclang-$LLVM_VERSION-dev
