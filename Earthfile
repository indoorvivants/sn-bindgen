VERSION 0.7


dependencies-base:
    FROM eclipse-temurin:17-focal
    COPY build /scripts
    RUN /scripts/setup-debian.sh 14
    WORKDIR /sources

    
    # SBT dependencies
    COPY build.sbt /sources
    COPY project/*.sbt /sources/project/
    COPY project/*.scala /sources/project/
    COPY project/build.properties /sources/project/
    RUN sbt update

    SAVE IMAGE --push sn-bindgen-deps-base:14

bindgen:
    FROM +dependencies-base
    ARG BUILD_COMMAND="ci; buildBinary"
    ARG BINARY_NAME="bindgen"

    ENV LLVM_BIN=/usr/lib/llvm-14/bin
    ENV CC=/usr/lib/llvm-14/bin/clang
    ENV CXX=/usr/lib/llvm-14/bin/clang++
    ENV SN_RELEASE "fast"
    ENV CI "true"

    COPY . /sources
    RUN sbt "${BUILD_COMMAND}"
    
    SAVE ARTIFACT bin/bindgen AS LOCAL bin/$BINARY_NAME
