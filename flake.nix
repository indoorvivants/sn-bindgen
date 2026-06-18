{
  description = "sn-bindgen";

  inputs.nixpkgs.url = "github:NixOS/nixpkgs";

  inputs.sbt.url = "github:zaninime/sbt-derivation/master";
  inputs.sbt.inputs.nixpkgs.follows = "nixpkgs";

  inputs.systems.url = "github:nix-systems/default";

  outputs =
    { self
    , nixpkgs
    , sbt
    , systems
    }:
    let
      eachSystem = nixpkgs.lib.genAttrs (import systems);
    in
    {
      packages = eachSystem (system:
        let pkgs = nixpkgs.legacyPackages.${system}; in
        {
          default = sbt.mkSbtDerivation.${system} {
            pname = "sn-bindgen";
            version = "0.1.0";
            src = with pkgs.lib.fileset; toSource {
              root = ./.;
              fileset = unions [
                ./build
                ./docs
                ./modules
                ./project
                ./build.sbt
              ];
            };
            depsSha256 = "sha256-27RfMT4XrPWOOJ6+RXBRs0LVnROs7m1+a4oRLqnf0GI=";
            buildPhase = ''
              sbt 'show buildBinary'
            '';
            depsWarmupCommand = ''
              sbt 'update'
              sbt 'iface/compile ; iface2_12/compile ; iface3/compile'
              sbt 'ifaceNative/compile ; ifaceNative2_12/compile ; ifaceNative3/compile'
              sbt 'bindgen/compile'
            '';
            installPhase = ''
              mkdir -p $out/bin
              cp bin/bindgen $out/bin/
            '';
            buildInputs = with pkgs; [
              llvmPackages_17.libclang
            ];
            nativeBuildInputs = with pkgs; [
              clang_17
              libunwind
              stdenv
              which
              zlib
            ];
            meta.mainProgram = "bindgen";
          };
        }
      );
      overlays.default = final: prev: {
        sn-bindgen = self.packages.${final.system}.default;
      };
    };
}
