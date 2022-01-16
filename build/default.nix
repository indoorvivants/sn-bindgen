{ pkgs ? import (fetchTarball "https://github.com/NixOS/nixpkgs/archive/9e27e2e6bbc1e72f73fff75f669b7be53d0bba62.tar.gz") {} }:

pkgs.mkShell {
  buildInputs = [
    pkgs.which
    pkgs.htop
    pkgs.zlib
    pkgs.llvmPackages_13.libllvm
    pkgs.sbt
  ];
}
