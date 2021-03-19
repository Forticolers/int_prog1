#!/bin/bash
#
# auteur : Jeanbourquin Julien
#

BUILD_PATH="./build"
SRC_PATH="./src"

CLASS_DEST="$BUILD_PATH/classes"
CLASS_PATH="$CLASS_DEST"

DOC_DEST="$BUILD_PATH/doc"
API_DEST="$DOC_DEST/api"
API_PACKAGE="test"

LIB_DEST="$BUILD_PATH/lib"
JAR_NAME="test.jar"


MAIN_FILE="./src/test/Main.java"

# compilation du programme
mkdir -p $CLASS_DEST
javac -d $CLASS_DEST -sourcepath $SRC_PATH -classpath $CLASS_PATH $MAIN_FILE

# création de l'archive
mkdir $LIB_DEST
jar cf $LIB_DEST/$JAR_NAME -C $CLASS_DEST .

# génération de la documention technique
javadoc -sourcepath $SRC_PATH -subpackages $API_PACKAGE -d $API_DEST
