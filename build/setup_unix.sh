#!/bin/bash

PLATFORM="$(uname)"

if [ $PLATFORM == "Darwin" ]; then
  echo "It's a Mac"
  brew install llvm
else
  echo "It's a linux"
  sudo apt update
  sudo apt install clang llvm llvm-dev libclang-dev
fi

