#!/bin/bash
#
# Script de création d'une projet java
# 
# -nomProjet
#  +-src
#  |  +-nomProjet
#  |     +-Main.java #Classe principale
#  |
#  +-build.xml #construction du projet si type ant
#  +-build.sh #construction du projet 
#  +-clean.sh #suppression des fichiers générés
#
#
# usage : creerProjetJava.sh [--type=(ant|bash)] --projet=<nomProjet>
#        --type=bash par défaut.
#
# dominique huguenin (dominique.huguenin AT rpn.ch)
# 

AUTEUR="dominique huguenin (dominique.huguenin@rpn.ch)"
SRC_DIR="src"
BUILD_DIR="build"
EXTENSION=".java"
BUILD_SH="build.sh"
CLEAN_SH="clean.sh"
RUN_SH="run.sh"
ANTFILE="build.xml"
POMFILE="pom.xml"
TYPE_PARAM="--type"
PROJET_PARAM="--projet"

MAIN_CLASSE="Main"
MAIN_FILE=${MAIN_CLASSE}${EXTENSION}

TYPE_BASH="bash"
TYPE_ANT="ant"
TYPE_MAVEN="maven"

#--------------------------------------------------------
function afficherUsage {
   cat << _EOF_ >&2
   
usage : creerProjetJava.sh [$TYPE_PARAM=(ant|bash|maven)] $PROJET_PARAM=<nomProjet>
        $TYPE_PARAM=bash par défaut.

_EOF_
}

#--------------------------------------------------------
function creerClasseMain {
   nomProjet=$1
   
   if [ ! -d "$1/$SRC_DIR/${nomProjet}" ]; then
      mkdir -p "$1/$SRC_DIR/${nomProjet}"
   fi
 
   fichier="$1/${SRC_DIR}/${nomProjet}/${MAIN_FILE}"

   cat << _EOF_ > "$fichier"
/**
 *
 * @author $AUTEUR
 */
package ${nomProjet};
 
public class ${MAIN_CLASSE} {
    static public void main( String[] args ) {
        System.out.println("Hello world!");
    }      
}
_EOF_

}

#--------------------------------------------------------
function creerBuild {

   nomProjet=$1
   fichier=$nomProjet/$BUILD_SH

   cat << _EOF_ > "$fichier"
#!/bin/bash
#
# auteur : $AUTEUR
#

BUILD_PATH=${BUILD_DIR}
SRC_PATH=${SRC_DIR}

CLASS_DEST=\$BUILD_PATH/classes
CLASS_PATH=\$CLASS_DEST

DOC_DEST=\$BUILD_PATH/doc
API_DEST=\$DOC_DEST/api
API_PACKAGE=$nomProjet

LIB_DEST=\$BUILD_PATH/lib
JAR_NAME=$nomProjet.jar


MAIN_FILE=\$SRC_PATH/$nomProjet/$MAIN_FILE

# compilation du programme
mkdir -p \$CLASS_DEST
javac -d \$CLASS_DEST -sourcepath \$SRC_PATH -classpath \$CLASS_PATH \$MAIN_FILE

# création de l'archive
mkdir \$LIB_DEST
jar cf \$LIB_DEST/\$JAR_NAME -C \$CLASS_DEST .

# génération de la documention technique
javadoc -sourcepath \$SRC_PATH -subpackages \$API_PACKAGE -d \$API_DEST
_EOF_

   chmod +x "$fichier"

}

#--------------------------------------------------------
function creerClean {

   fichier=$1/$CLEAN_SH

   cat << _EOF_ > "$fichier"
#!/bin/bash
#
# auteur : $AUTEUR
#
if [ -d "${BUILD_DIR}" ]; then
  rm -r ${BUILD_DIR}
fi
_EOF_

   chmod +x "$fichier"

}

#--------------------------------------------------------
function creerRun {
 
   nomProjet=$1

   fichier=$nomProjet/$RUN_SH

   cat << _EOF_ > "$fichier"
#!/bin/bash
#
# auteur : $AUTEUR
#
CLASS_PATH=${BUILD_DIR}/lib/$nomProjet.jar

java -classpath \$CLASS_PATH $nomProjet.$MAIN_CLASSE
_EOF_

   chmod +x "$fichier"

}

#--------------------------------------------------------
function creerAntfile {
   nomProjet=$1
   fichier=$nomProjet/$ANTFILE

   cat << _EOF_ > "$fichier"
<?xml version="1.0" encoding="UTF-8" ?>
<!-- 

    auteur : $AUTEUR
    
-->
<project name="$nomProjet" default="core" basedir="." >

    <property name="jar.name" value="\${ant.project.name}.jar"/>
    <property name="javadoc.packagenames" value="$nomProjet.*"/>
    <property name="dist.name" value="\${ant.project.name}"/>

    <property name="src.dir" value="$SRC_DIR"/>
    
    <property name="build.dir" value="$BUILD_DIR"/>
    <property name="build.classes" value="\${build.dir}/classes"/>
    <property name="build.lib" value="\${build.dir}/lib"/>
    <property name="build.docs" value="\${build.dir}/docs"/>
    <property name="build.javadocs" value="\${build.docs}/api"/>
    
    <property name="dist.dir" value="dist"/>
    
    <property name="main.class" value="$nomProjet.$MAIN_CLASSE"/>

  <!-- 

    ==========================================================
    compile des fichiers java
    ==========================================================

  -->
  <target name="compile">

    <mkdir dir="\${build.dir}" />
    <mkdir dir="\${build.classes}" />

    <javac
      srcdir="\${src.dir}"
      destdir="\${build.classes}"
      debug="on">
    </javac>

  </target>
  
   <!-- 

    ==========================================================
    construit les archives jar du projet
    ==========================================================

  -->
  <target name="jar">
    <mkdir dir="\${build.lib}" />

    <jar jarfile="\${build.lib}/\${jar.name}"
       basedir="\${build.classes}"
    />
  </target>

  <!-- 

    ==========================================================
    construit la documentation du projet
    ==========================================================

  -->
  <target name="javadoc">

    <mkdir dir="\${build.docs}" />
    <mkdir dir="\${build.javadocs}" />
    
    <javadoc sourcepath="\${src.dir}"
           destdir="\${build.javadocs}"
       packagenames="\${javadoc.packagenames}"
       version="true"
       protected="true"
       author="true"
       use="true" >
    </javadoc>
  </target>
  
  
  <!-- 

    ==========================================================
    construit tous les fichiers du projet
    ==========================================================
  
  -->
  <target name="core" depends="compile,jar,javadoc" 
    description="construit tous les fichiers du projet">
  </target>
  
   <!-- 

    ==========================================================
    détruit des dossiers et fichiers générés
    ==========================================================

   -->
  <target name="clean"
    description="efface les dossiers et fichiers générés">
    <tstamp />
    <delete dir="\${build.dir}" />
    <delete dir="\${dist.dir}" />
    <delete file="\${dist.name}-bin.zip" />
    <delete file="\${dist.name}-src.zip" />

    <!-- detruit les fichiers avec les extensions log, 
         bak et comprenant un ~ dans l\'extension -->
    <delete>
      <fileset dir="\${src.dir}">
        <include name="**/*.log" />
        <include name="**/*.bak" />
        <include name="**/*.*~" />
      </fileset>
    </delete>
  </target>
  
<!-- 

    ==========================================================
    création des archive de distribution
    ==========================================================

  -->
  <target name="dist-bin" depends="clean, dist"
    description="crée l'archive contenant l'application">
    
    <zip destfile="\${dist.name}-bin.zip" basedir="\${dist.dir}">
    </zip>
    
  </target>  
  
<!-- 

    ==========================================================
    création des archive des sources
    ==========================================================

  -->
    <target name="dist-src" 
            description="Crée un archive pour la distribution des sources" 
            depends="clean" >
        <echo>\${ant.project.name}</echo>
			
        <mkdir dir="\${ant.project.name}"/>
			
        <copy todir="\${ant.project.name}">
            <fileset dir="\${basedir}">
                <include name="**" />
                <exclude name="\${ant.project.name}" />
            </fileset>
        </copy>                
			
        <zip destfile="\${ant.project.name}-src.zip">
            <fileset dir="\${basedir}">
                <include name="\${ant.project.name}/" />
            </fileset>            
        </zip>    
            
        <delete dir="\${ant.project.name}"/>        
    </target>        
  
  
 <!-- 

    ==========================================================
    création d\'un dossier contenant uniquement les fichiers
    d\'une distribution de l\'application
    ==========================================================

  -->
 <target name="dist" depends="core"
    description="construit un dossier contenant uniquement les fichiers pour la distribution">

    <copy todir="\${dist.dir}/doc">
      <fileset dir="\${build.docs}"/>
    </copy>

    <copy todir="\${dist.dir}/lib">
      <fileset dir="\${build.lib}"/>
    </copy>
    
    <echo file="\${dist.dir}/run.sh" append="false">
#!/bin/bash
CLASS_PATH=./lib/\${jar.name}
java -classpath \$CLASS_PATH \${main.class}
    </echo>
    
  </target>
  
 <!-- 

    ==========================================================
    Exécution du programme
    ==========================================================

  -->
 <target name="run" depends="compile"
    description="execute le programme">

       <java classname="\${main.class}" fork="true" >
         <classpath>
           <pathelement path="\${build.classes}"/>
         </classpath>
       </java>  
  </target>
  
 <target name="run-jar" depends="compile"
    description="execute le programme dans l'archive">

       <java classname="\${main.class}" fork="true" >
         <classpath>
           <pathelement path="\${build.lib}/\${jar.name}"/>
         </classpath>
       </java>  
  </target>
  
  
 </project>


_EOF_

}

#--------------------------------------------------------
function creerPomfile {
   nomProjet=$1
   fichier=$nomProjet/$POMFILE

   cat << _EOF_ > "$fichier"
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>$nomProjet</groupId>
    <artifactId>$nomProjet</artifactId>
    <name>$nomProjet</name>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
        </dependency>
    </dependencies>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
    </properties>
</project>   
_EOF_

}

#--------------------------------------------------------
function creerClasseMainForMaven {
   nomProjet=$1
   sourceDir="$1/$SRC_DIR/main/java/"
   
   if [ ! -d "$sourceDir/${nomProjet}" ]; then
      mkdir -p "$sourceDir/${nomProjet}"
   fi
 
   fichier="$sourceDir/${nomProjet}/${MAIN_FILE}"

   cat << _EOF_ > "$fichier"
/**
 *
 * @author $AUTEUR
 */
package ${nomProjet};
 
public class ${MAIN_CLASSE} {
    static public void main( String[] args ) {
        System.out.println("Hello world!");
    }      
}
_EOF_
}


#==============================================
#-------------------------------------------
# Précondition
#
if [ $# -eq 0 ]; then
   afficherUsage
   exit 1
fi


for param in "$@"; do
        #Extrait le nom du projet
	if [[ "$param" =~ $PROJET_PARAM=.* ]]; then
	 	nomProjet=$(echo "$param" | grep -oP "(?i)$PROJET_PARAM"'=\K(.*)')
	fi
	
	#Extrait le type de projet
	if [[ "$param" =~ $TYPE_PARAM=.* ]]; then
	 	typeProjet=$(echo "$param" | grep -oP "(?i)$TYPE_PARAM"'=\K(.*)')
	fi
done

if [ -z "$typeProjet" ]; then
   typeProjet=$TYPE_BASH
fi

if [ -z "$nomProjet" ]; then
   afficherUsage
   exit 1
fi

#-------------------------------------------
# Traitement
#
if [ ! -d "$nomProjet" ]; then
   mkdir -p "$nomProjet"
fi
 

case $typeProjet in
	$TYPE_ANT)
		creerAntfile "$nomProjet"
		creerClasseMain "$nomProjet"
		;;
	$TYPE_BASH)
		creerBuild "$nomProjet"
		creerClean "$nomProjet"
		creerRun "$nomProjet"
		creerClasseMain "$nomProjet"
		;;
	$TYPE_MAVEN)
		creerPomfile "$nomProjet"
		creerClasseMainForMaven "$nomProjet"
		;;
  *) 
		afficherUsage
		;;
esac		



