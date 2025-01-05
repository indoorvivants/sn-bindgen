FROM ubuntu@sha256:2e863c44b718727c860746568e1d54afd13b2fa71b160f5cd9058fc436217b30

ENV LLVM_VERSION=17
ENV JDK_VERSION=17

RUN apt update && apt install -y curl && \
    curl -Lo llvm.sh https://apt.llvm.org/llvm.sh && \
    chmod +x llvm.sh && \
    apt install -y lsb-release wget software-properties-common gnupg autopoint libtool git && \
    ./llvm.sh $LLVM_VERSION && \
    apt install libclang-$LLVM_VERSION-dev &&  \
    apt install -y gpg wget && \
    wget -qO - https://packages.adoptium.net/artifactory/api/gpg/key/public | gpg --dearmor | tee /etc/apt/trusted.gpg.d/adoptium.gpg > /dev/null && \
    echo "deb https://packages.adoptium.net/artifactory/deb $(awk -F= '/^VERSION_CODENAME/{print$2}' /etc/os-release) main" | tee /etc/apt/sources.list.d/adoptium.list && \
    apt update && apt install -y temurin-$JDK_VERSION-jdk && \
    curl -Lo /usr/local/bin/sbt https://raw.githubusercontent.com/sbt/sbt/1.10.x/sbt && chmod +x /usr/local/bin/sbt

WORKDIR /tmp-source

COPY build.sbt . 
COPY project/build.properties project/build.properties
COPY project/plugins.sbt project/plugins.sbt
COPY project/LLVMInfo.scala project/LLVMInfo.scala

ENV LLVM_BIN=/usr/lib/llvm-$LLVM_VERSION/bin

RUN sbt update

WORKDIR /source

ENTRYPOINT ["sbt", "buildPlatformBinary"]
