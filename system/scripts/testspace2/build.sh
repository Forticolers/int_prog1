#!/bin/bash
#
# auteur : Jeanbourquin Julien
#

BUILD_PATH="testspace2/build"
SRC_PATH="testspace2/src"

CLASS_DEST="$BUILD_PATH/classes"
CLASS_PATH="$CLASS_DEST"

DOC_DEST="$BUILD_PATH/doc"
API_DEST="$DOC_DEST/api"
API_PACKAGE="testspace2"

LIB_DEST="$BUILD_PATH/lib"
JAR_NAME="testspace2.jar"


MAIN_FILE="testspace2/src/testspace2/Main.java"

# compilation du programme
mkdir -p $CLASS_DEST
javac -d $CLASS_DEST -sourcepath $SRC_PATH -classpath $CLASS_PATH $MAIN_FILE

# création de l'archive
mkdir $LIB_DEST
jar cf $LIB_DEST/$JAR_NAME -C $CLASS_DEST .

# génération de la documention technique
javadoc -sourcepath $SRC_PATH -subpackages $API_PACKAGE -d $API_DEST
