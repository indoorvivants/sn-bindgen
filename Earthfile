VERSION 0.7


llvm-base:
    FROM eclipse-temurin:17-focal
    COPY build /scripts
    RUN /scripts/setup-debian.sh 14
    SAVE IMAGE --push sn-bindgen-llvm-base:14

bindgen:
    FROM +llvm-base
    WORKDIR /sources
    
    # SBT dependencies
    COPY build.sbt /sources
    COPY project/*.sbt /sources/project/
    COPY project/build.properties /sources/project/
    RUN sbt update
    
    SAVE ARTIFACT bin/bindgen AS LOCAL bin/sn-bindgen-aarch64-pc-linux
