#!/bin/bash

PLATFORM="$(uname)"

if [ $PLATFORM == "Darwin" ]; then
  echo "It's a Mac"
  brew install llvm
else
  echo "It's a linux"
  sudo apt update
  sudo apt install lsb-release wget software-properties-common
  wget https://apt.llvm.org/llvm.sh
  chmod +x llvm.sh
  sudo ./llvm.sh 13
  sudo apt install libclang-13-dev
fi

