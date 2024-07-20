rec {
  description = "sn-bindgen";

  inputs = {
    devshell = {
      url = "github:numtide/devshell";
      inputs = {
        flake-utils.follows = "flake-utils";
        nixpkgs.follows = "nixpkgs";
      };
    };

    nixpkgs.url = "github:NixOS/nixpkgs";

    sbt = {
      url = "github:zaninime/sbt-derivation/master";
      inputs = {
        nixpkgs.follows = "nixpkgs";
      };
    };

    flake-utils = {
      url = "github:numtide/flake-utils";
    };

    typelevel-nix = {
      url = "github:typelevel/typelevel-nix";
      inputs = {
        devshell.follows = "devshell";
        flake-utils.follows = "flake-utils";
        nixpkgs.follows = "nixpkgs";
      };
    };

  };


  outputs =
    { self
    , devshell
    , flake-utils
    , nixpkgs
    , sbt
    , typelevel-nix
    }: flake-utils.lib.eachDefaultSystem (system:
    let
      pkgs = import nixpkgs { inherit system; overlays = [ devshell.overlays.default ]; };
    in
    {
      packages.default = sbt.mkSbtDerivation.${system} {
        pname = "sn-bindgen";
        version = "0.1.4-SNAPSHOT";
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
        depsSha256 = "sha256-MzLW1vTuPi0WRNoV806cotaz5D2DoKKiOTW6aIzmbIc=";
        buildPhase = ''
          sbt 'show buildBinary'
        '';
        depsWarmupCommand = ''
          sbt 'update'
          sbt 'iface/compile ; iface2_12/compile ; iface3/compile'
          sbt 'ifaceNative/compile ; ifaceNative2_12/compile ; ifaceNative3/compile'
        '';
        installPhase = ''
          mkdir -p $out/bin
          cp bin/bindgen $out/bin/
        '';
        buildInputs = with pkgs; [
          libclang
        ];
        nativeBuildInputs = with pkgs; [
          clang
          libunwind
          stdenv
          which
          zlib
        ];
        meta.mainProgram = "bindgen";
      };


      devShell = pkgs.devshell.mkShell rec {
        name = description;
        imports = [ typelevel-nix.typelevelShell ];

        packages = [
          pkgs.clang
          (pkgs.scalafix.override { jre = typelevelShell.jdk.package; })
        ];

        typelevelShell = {
          jdk.package = pkgs.graalvm-ce;

          native = {
            enable = true;
            libraries = [
              pkgs.libclang
              pkgs.libunwind
              pkgs.zlib
            ];
          };

          nodejs.enable = false;
          sbtMicrosites.enable = false;
        };
      };

      overlays.default = final: prev: {
        sn-bindgen = self.packages.${final.system}.default;
      };
    });
}
