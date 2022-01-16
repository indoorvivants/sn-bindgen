#!/bin/bash

PLATFORM="$(uname)"

if [ $PLATFORM == "Darwin" ]; then
  echo "It's a Mac"
  brew install llvm
else
  echo "It's a linux"
  sudo apt update
  sudo apt install lsb-release wget software-properties-common
  wget -O - https://apt.llvm.org/llvm-snapshot.gpg.key | sudo apt-key add -
  sudo add-apt-repository "deb http://apt.llvm.org/focal/     llvm-toolchain-focal-13   main"
  sudo apt-get update 
  sudo apt-get install clang-13 lldb-13 libclang-13-dev llvm-13-dev
fi

