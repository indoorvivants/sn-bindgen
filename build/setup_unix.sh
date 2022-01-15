#!/bin/bash

PLATFORM="$(uname)"

if [ $PLATFORM == "Darwin" ]; then
  echo "It's a Mac"
  brew install llvm
  java -version
  curl -Lo /usr/local/bin/sbt https://raw.githubusercontent.com/sbt/sbt/v1.6.1/sbt
else
  echo "It's a linux"
  apt update
  apt install clang llvm llvm-dev libclang-dev
  java -version
  curl -Lo /usr/local/bin/sbt https://raw.githubusercontent.com/sbt/sbt/v1.6.1/sbt
fi

