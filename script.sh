#!/usr/bin/bash

ARG1="$PWD/corretor-automatico/corretor-automatico.jar"
ARG2="java -jar $PWD/target/t1-1.0-SNAPSHOT-jar-with-dependencies.jar"
ARG3="gcc"
ARG4="$PWD/tmp"
ARG5="$PWD/casos-de-teste"
ARG6="111111,222222,769734"
ARG7="t1"

chmod +x $PWD/target/t1-1.0-SNAPSHOT-jar-with-dependencies.jar
java -jar $ARG1 "$ARG2" $ARG3 $ARG4 $ARG5 $ARG6 $ARG7