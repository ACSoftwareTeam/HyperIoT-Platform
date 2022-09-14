#!/bin/bash

set -e

TAG=1.0.0

build() {
    NAME=$1
    IMAGE=nexus.acsoftware.it:18079/hyperiot/spark-$NAME:$TAG
    cd $([ -z "$2" ] && echo "./$NAME" || echo "$2")
    echo '--------------------------' building $IMAGE in $(pwd)
    docker build -t $IMAGE .
    cd -
}

build base
build master
build worker
# build submit
# build java-template template/java
# build scala-template template/scala
# build python-template template/python
