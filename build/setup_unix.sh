#!/bin/bash

PLATFORM="$(uname)"
LLVM_VERSION="${LLVM_VERSION:-17}"

echo "Installing LLVM $LLVM_VERSION"

if [ $PLATFORM == "Darwin" ]; then
  echo "It's a Mac"
  brew install llvm@$LLVM_VERSION
else
  echo "It's a linux"
  sudo apt update
  sudo apt install -y lsb-release wget software-properties-common
  wget -O - https://apt.llvm.org/llvm-snapshot.gpg.key | sudo apt-key add -
  sudo add-apt-repository "deb http://apt.llvm.org/focal/     llvm-toolchain-focal-$LLVM_VERSION   main"
  sudo apt-get update 
  sudo apt-get -y install clang-$LLVM_VERSION libclang-$LLVM_VERSION-dev llvm-$LLVM_VERSION-dev
fi

