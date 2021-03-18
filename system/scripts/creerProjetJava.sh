#!/bin/bash
function printUsage {
	printf "Help: Create Java project structure\n"
	printf "\t$0 [--type=(maven|bash)] --projet=<nomProjet>\n"
	printf "\t--type=maven par défaut.\n"
}
function isSourced {
    if [ $1 == 'exit' ];
                then
                    printf 'Exiting program. . .\n'
            fi;
    if [[ "${BASH_SOURCE[0]}" == "${0}" ]]; 
        then                       
            "$1"
        else
            printf "${BASH_SOURCE[0]} is being sourced.\nUse of return instead of exit (expect some echo)\n"
            return
    fi;
}
function main {
    TYPE="maven"
    PROJECT=
    for i in "$@"
            do
            case $i in
                    -h|--help)
                            printUsage 
                            isSourced exit
                                                       
                    ;;
                    -p=*|--projet=*|--project=*)
                            PROJECT="${i#*=}"
                    ;;
                    -t=*|--type=*)
                            TYPE="${i#*=}"
                    ;;
                    *)
                            printf "%s\n" "$i is an invalid argument."
                            printUsage
                            isSourced exit
                            
                            
                    ;;
            esac
    done
    if [ "$TYPE" != "bash" ] && [ "$TYPE" != "maven" ]; then
		printf "%s\n" "The type $TYPE is not valid."
        printUsage
		isSourced exit
        
	fi
    if [ -z "$PROJECT" ]; then
		printf "%s\n" "Project name not in parameters {$@}"
		printUsage
        isSourced exit
	fi
    createProject "$PROJECT" "$TYPE"
}
function createProject {
	PROJ_NAME="$1"
	PROJECT_DIRECTORY="$1"
	API_PACKAGE="$(echo "$PROJ_NAME" | sed 's/[[:space:]]//g')"
	SOURCE_DIRECTORIES="$PROJECT_DIRECTORY/src/$API_PACKAGE"
	JAVA_FILE="$SOURCE_DIRECTORIES/Main.java"
	JAVA_FILE_REL="./src/$API_PACKAGE/Main.java"
    AUTHOR="Jeanbourquin Julien"
	BUILD_SCRIPT="$PROJ_NAME/build.sh"
	CLEAN_SCRIPT="$PROJ_NAME/clean.sh"
	RUN_SCRIPT="$PROJ_NAME/run.sh"

	MAVEN_SCRIPT="$PROJ_NAME/pom.xml"
    SUN_CHECK="$PROJ_NAME/sun_check.xml"
	echo "Project name: $PROJ_NAME"
	echo "Project directory: $PROJECT_DIRECTORY"
	echo "Source directories: $SOURCE_DIRECTORIES"
	echo "Main file: $JAVA_FILE"

	createDirectories
	createMainFile

	if [ $2 = "maven" ]; then
		createMavenFile
	else
		createBashFiles
	fi
}

function createDirectories {
	if [ ! -d "$PROJECT_DIRECTORY" ]; then
		echo "Create project directory $PROJECT_DIRECTORY"
		mkdir "$PROJECT_DIRECTORY"
	fi

	if [ ! -d "$SOURCE_DIRECTORIES" ]; then
		mkdir -p "$SOURCE_DIRECTORIES"
	fi
}

function createMainFile {
	# Create files
	if [ ! -f "$JAVA_FILE" ]; then
		echo "Create main file $JAVA_FILE"

		cat <<-HELLOWORLDFUNC > "$JAVA_FILE"
			package $(echo "$PROJ_NAME" | sed 's/[[:space:]]//g');
			
			public class Main {
			    public static void main(String[] args){
			        System.out.println("Hello World !");
			    }
			}			
		HELLOWORLDFUNC
	fi
}
function createBashFiles {
	# Create build.sh
	echo "Create bash script $BUILD_SCRIPT"
	cat <<-ENDOFSCRIPT > "$BUILD_SCRIPT"
		#!/bin/bash
		#
		# auteur : $AUTHOR
		#

		BUILD_PATH="./build"
		SRC_PATH="./src"

		CLASS_DEST="\$BUILD_PATH/classes"
		CLASS_PATH="\$CLASS_DEST"

		DOC_DEST="\$BUILD_PATH/doc"
		API_DEST="\$DOC_DEST/api"
		API_PACKAGE="$API_PACKAGE"

		LIB_DEST="\$BUILD_PATH/lib"
		JAR_NAME="$API_PACKAGE.jar"


		MAIN_FILE="$JAVA_FILE_REL"

		# compilation du programme
		mkdir -p \$CLASS_DEST
		javac -d \$CLASS_DEST -sourcepath \$SRC_PATH -classpath \$CLASS_PATH \$MAIN_FILE

		# création de l'archive
		mkdir \$LIB_DEST
		jar cf \$LIB_DEST/\$JAR_NAME -C \$CLASS_DEST .

		# génération de la documention technique
		javadoc -sourcepath \$SRC_PATH -subpackages \$API_PACKAGE -d \$API_DEST
	ENDOFSCRIPT
	chmod u+x "$BUILD_SCRIPT"

	# Create clean.sh
	echo "Create bash script $CLEAN_SCRIPT"
	cat <<-ENDOFSCRIPT > "$CLEAN_SCRIPT"
		#!/bin/bash
		#
		# auteur : $AUTHOR
		#
		if [ -d "./build" ]; then
		  rm -r "./build"
		fi
	ENDOFSCRIPT
	chmod u+x "$CLEAN_SCRIPT"

	# Create run.sh
	echo "Create bash script $RUN_SCRIPT"
	cat <<-ENDOFSCRIPT > "$RUN_SCRIPT"
		#!/bin/bash
		#
		# auteur : $AUTHOR
		#
		CLASS_PATH="./build/lib/$API_PACKAGE.jar"
		java -classpath \$CLASS_PATH "$API_PACKAGE.Main"
	ENDOFSCRIPT
	chmod u+x "$RUN_SCRIPT"
}
function createMavenFile {
    make_sunchecks

	# Create pom.xml
	echo "Create maven script $MAVEN_SCRIPT"
	cat <<-ENDOFSCRIPT > "$MAVEN_SCRIPT"
<?xml version="1.0" encoding="UTF-8"?>
        <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
            <modelVersion>4.0.0</modelVersion>

            <groupId>$(echo "$API_PACKAGE" | sed 's/[[:space:]]//g')</groupId>
            <artifactId>$(echo "$PROJ_NAME" | sed 's/[[:space:]]//g')</artifactId>
            <version>1.0-SNAPSHOT</version>

            <name>$(echo "$PROJ_NAME" | sed 's/[[:space:]]//g')</name>
            <!-- FIXME change it to the project's website -->
            <url>http://www.example.com</url>

            <properties>
                <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
                <maven.compiler.source>1.7</maven.compiler.source>
                <maven.compiler.target>1.7</maven.compiler.target>
            </properties>

            <dependencies>
                <dependency>
                    <groupId>junit</groupId>
                    <artifactId>junit</artifactId>
                    <version>4.13</version>
                    <scope>test</scope>
                    <type>jar</type>
                </dependency>
                <dependency>
                    <groupId>org.hamcrest</groupId>
                    <artifactId>hamcrest-core</artifactId>
                    <version>1.3</version>
                    <scope>test</scope>
                </dependency>
            </dependencies>

            <build>
                <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
                    <plugins>
                        <!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
                        <plugin>
                            <artifactId>maven-clean-plugin</artifactId>
                            <version>3.1.0</version>
                        </plugin>
                        <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
                        <plugin>
                            <artifactId>maven-resources-plugin</artifactId>
                            <version>3.0.2</version>
                        </plugin>
                        <plugin>
                            <artifactId>maven-compiler-plugin</artifactId>
                            <version>3.8.0</version>
                        </plugin>
                        <plugin>
                            <artifactId>maven-surefire-plugin</artifactId>
                            <version>2.22.1</version>
                        </plugin>
                        <plugin>
                            <artifactId>maven-jar-plugin</artifactId>
                            <version>3.0.2</version>
                        </plugin>
                        <plugin>
                            <artifactId>maven-install-plugin</artifactId>
                            <version>2.5.2</version>
                        </plugin>
                        <plugin>
                            <artifactId>maven-deploy-plugin</artifactId>
                            <version>2.8.2</version>
                        </plugin>
                        <!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
                        <plugin>
                            <artifactId>maven-site-plugin</artifactId>
                            <version>3.7.1</version>
                        </plugin>
                        <plugin>
                            <artifactId>maven-project-info-reports-plugin</artifactId>
                            <version>3.0.0</version>
                        </plugin>
                    </plugins>
                </pluginManagement>
                <plugins>
                    <plugin>
                        <groupId>org.jacoco</groupId>
                        <artifactId>jacoco-maven-plugin</artifactId>
                        <version>0.8.6</version>
                        <executions>
                            <execution>
                                <id>pre-unit-test</id>
                                <goals>
                                    <goal>prepare-agent</goal>
                                </goals>
                            </execution>
                            <execution>
                                <id>post-unit-test</id>
                                <phase>test</phase>
                                <goals>
                                    <goal>report</goal>
                                </goals>
                            </execution>                
                        </executions>
                    </plugin>            
                </plugins>
            </build>
            
            
            <reporting>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-checkstyle-plugin</artifactId>
                        <version>3.1.1</version>
                        <configuration>
                            <configLocation>${basedir}/sun_checks.xml</configLocation>
                        </configuration>            
                    </plugin>
                </plugins>
            </reporting>
        </project>
	ENDOFSCRIPT
}
function make_sunchecks {
    # Create sun_check.xml
    echo "Create maven script $SUN_CHECK"
    echo <<-\ENDOFSCRIPT > "$SUN_CHECK"
<?xml version="1.0"?>
<!DOCTYPE module PUBLIC "-//Checkstyle//DTD Checkstyle Configuration 1.3//EN" "https://checkstyle.org/dtds/configuration_1_3.dtd">

<!--

  Checkstyle configuration that checks the sun coding conventions from:

    - the Java Language Specification at
      https://docs.oracle.com/javase/specs/jls/se11/html/index.html

    - the Sun Code Conventions at https://www.oracle.com/java/technologies/javase/codeconventions-contents.html

    - the Javadoc guidelines at
      https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html

    - the JDK Api documentation https://docs.oracle.com/en/java/javase/11/

    - some best practices

  Checkstyle is very configurable. Be sure to read the documentation at
  https://checkstyle.org (or in your downloaded distribution).

  Most Checks are configurable, be sure to consult the documentation.

  To completely disable a check, just comment it out or delete it from the file.
  To suppress certain violations please review suppression filters.

  Finally, it is worth reading the documentation.

-->

<module name="Checker">
    <!--
        If you set the basedir property below, then all reported file
        names will be relative to the specified directory. See
        https://checkstyle.org/config.html#Checker
  
        <property name="basedir" value="${basedir}"/>
    -->
    <property name="severity" value="error"/>

    <property name="fileExtensions" value="java, properties, xml"/>

    <!-- Excludes all 'module-info.java' files              -->
    <!-- See https://checkstyle.org/config_filefilters.html -->
    <module name="BeforeExecutionExclusionFileFilter">
        <property name="fileNamePattern" value="module\-info\.java$"/>
    </module>

    <!-- https://checkstyle.org/config_filters.html#SuppressionFilter -->
    <module name="SuppressionFilter">
        <property name="file" value="${org.checkstyle.sun.suppressionfilter.config}"
                  default="checkstyle-suppressions.xml" />
        <property name="optional" value="true"/>
    </module>

    <!-- Checks that a package-info.java file exists for each package.     -->
    <!-- See https://checkstyle.org/config_javadoc.html#JavadocPackage -->
    <module name="JavadocPackage"/>

    <!-- Checks whether files end with a new line.                        -->
    <!-- See https://checkstyle.org/config_misc.html#NewlineAtEndOfFile -->
    <module name="NewlineAtEndOfFile"/>

    <!-- Checks that property files contain the same keys.         -->
    <!-- See https://checkstyle.org/config_misc.html#Translation -->
    <module name="Translation"/>

    <!-- Checks for Size Violations.                    -->
    <!-- See https://checkstyle.org/config_sizes.html -->
    <module name="FileLength"/>
    <module name="LineLength">
        <property name="fileExtensions" value="java"/>
    </module>

    <!-- Checks for whitespace                               -->
    <!-- See https://checkstyle.org/config_whitespace.html -->
    <module name="FileTabCharacter"/>

    <!-- Miscellaneous other checks.                   -->
    <!-- See https://checkstyle.org/config_misc.html -->
    <module name="RegexpSingleline">
        <property name="format" value="\s+$"/>
        <property name="minimum" value="0"/>
        <property name="maximum" value="0"/>
        <property name="message" value="Line has trailing spaces."/>
    </module>

    <!-- Checks for Headers                                -->
    <!-- See https://checkstyle.org/config_header.html   -->
    <!-- <module name="Header"> -->
    <!--   <property name="headerFile" value="${checkstyle.header.file}"/> -->
    <!--   <property name="fileExtensions" value="java"/> -->
    <!-- </module> -->

    <module name="TreeWalker">

        <!-- Checks for Javadoc comments.                     -->
        <!-- See https://checkstyle.org/config_javadoc.html -->
        <module name="InvalidJavadocPosition"/>
        <module name="JavadocMethod">
            <property name="scope" value="public"/>
        </module>
        <module name="JavadocType">
            <property name="scope" value="public"/>
        </module>
        <module name="JavadocVariable">
            <property name="scope" value="public"/>
        </module>
        <module name="JavadocStyle">
            <property name="scope" value="public"/>            
        </module>
        <module name="MissingJavadocMethod"/>

        <!-- Checks for Naming Conventions.                  -->
        <!-- See https://checkstyle.org/config_naming.html -->
        <module name="ConstantName"/>
        <module name="LocalFinalVariableName"/>
        <module name="LocalVariableName"/>
        <module name="MemberName"/>
        <module name="MethodName"/>
        <module name="PackageName"/>
        <module name="ParameterName"/>
        <module name="StaticVariableName"/>
        <module name="TypeName"/>

        <!-- Checks for imports                              -->
        <!-- See https://checkstyle.org/config_imports.html -->
        <module name="AvoidStarImport"/>
        <module name="IllegalImport"/> <!-- defaults to sun.* packages -->
        <module name="RedundantImport"/>
        <module name="UnusedImports">
            <property name="processJavadoc" value="false"/>
        </module>

        <!-- Checks for Size Violations.                    -->
        <!-- See https://checkstyle.org/config_sizes.html -->
        <module name="MethodLength"/>
        <module name="ParameterNumber"/>

        <!-- Checks for whitespace                               -->
        <!-- See https://checkstyle.org/config_whitespace.html -->
        <module name="EmptyForIteratorPad"/>
        <module name="GenericWhitespace"/>
        <module name="MethodParamPad"/>
        <module name="NoWhitespaceAfter"/>
        <module name="NoWhitespaceBefore"/>
        <module name="OperatorWrap"/>
        <module name="ParenPad"/>
        <module name="TypecastParenPad"/>
        <module name="WhitespaceAfter"/>
        <module name="WhitespaceAround"/>

        <!-- Modifier Checks                                    -->
        <!-- See https://checkstyle.org/config_modifiers.html -->
        <module name="ModifierOrder"/>
        <module name="RedundantModifier"/>

        <!-- Checks for blocks. You know, those {}'s         -->
        <!-- See https://checkstyle.org/config_blocks.html -->
        <module name="AvoidNestedBlocks"/>
        <module name="EmptyBlock"/>
        <module name="LeftCurly"/>
        <module name="NeedBraces"/>
        <module name="RightCurly"/>

        <!-- Checks for common coding problems               -->
        <!-- See https://checkstyle.org/config_coding.html -->
        <module name="EmptyStatement"/>
        <module name="EqualsHashCode"/>

        <module name="HiddenField">
            <property name="ignoreConstructorParameter" value="true"/>
            <property name="ignoreSetter" value="true"/>
            <property name="setterCanReturnItsClass" value="true"/>
        </module>

        <module name="IllegalInstantiation"/>
        <module name="InnerAssignment"/>
        <module name="MagicNumber"/>
        <module name="MissingSwitchDefault"/>
        <module name="MultipleVariableDeclarations"/>
        <module name="SimplifyBooleanExpression"/>
        <module name="SimplifyBooleanReturn"/>

        <!-- Checks for class design                         -->
        <!-- See https://checkstyle.org/config_design.html -->
        <!--
        <module name="DesignForExtension"/>
        -->
        <module name="FinalClass"/>
        <module name="HideUtilityClassConstructor"/>
        <module name="InterfaceIsType"/>
        <module name="VisibilityModifier"/>

        <!-- Miscellaneous other checks.                   -->
        <!-- See https://checkstyle.org/config_misc.html -->
        <module name="ArrayTypeStyle"/>
        <module name="FinalParameters"/>
        <module name="TodoComment"/>
        <module name="UpperEll"/>

        <!-- https://checkstyle.org/config_filters.html#SuppressionXpathFilter -->
        <module name="SuppressionXpathFilter">
            <property name="file" value="${org.checkstyle.sun.suppressionxpathfilter.config}"
                      default="checkstyle-xpath-suppressions.xml" />
            <property name="optional" value="true"/>
        </module>

    </module>

</module>

	ENDOFSCRIPT
}

main "$@"