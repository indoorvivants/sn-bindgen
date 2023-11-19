FROM ubuntu:20.04

RUN apt update -y && apt install -y openjdk-17-jdk wget sudo

WORKDIR /source

COPY ./build/setup_unix.sh .

RUN ./setup_unix.sh 

RUN wget https://raw.githubusercontent.com/sbt/sbt/1.9.x/sbt && chmod +x sbt && ./sbt --sbt-create version && mv sbt /usr/local/bin/sbt

ENV LLVM_BIN=/usr/lib/llvm-14/bin

