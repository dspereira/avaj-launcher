#!/bin/bash

FILE=$1

find src * -name "*.java" > sources.txt
javac @sources.txt
java -cp src pt.dspereira.avajlauncher.Main "$FILE"