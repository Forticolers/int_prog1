### Activité 006

#### 1)

- Copiez les fichiers **.bashrc** et **.profile** de votre répertoire principal en ***.save**

  - ```bash
    jeanbourquj@MC0-0315-JJU:~$ for f in .{bashrc,profile}; do cp "$f" ~/"$f".save;done
    jeanbourquj@MC0-0315-JJU:~$ ls -al | grep .save
    -rw-r--r--  1 jeanbourquj jeanbourquj  3771 mar  9 10:47 .bashrc.save
    -rw-r--r--  1 jeanbourquj jeanbourquj  3771 mar  9 10:47 .profile.save
    
    ```

- Créez un répertoire **~/test** Dans le répertoire test, à l’aide de la commande de redirection (>) créez un fichier **liste.lis** qui contient la liste détaillée des fichiers (fichiers “cachés” inclus) contenu de votre répertoire principale.

  - ```bash
    ---------------------------Création du répértoire
    jeanbourquj@MC0-0315-JJU:~$ mkdir ~/test/
    jeanbourquj@MC0-0315-JJU:~$ ls
    01-netcfg.yaml.old  Bureau     find.tmp  man      pier             test
    bashrc              Documents  images    Modèles  Public           test12.txt
    beuseu              find       Images    Musique  Téléchargements  Vidéos
    ---------------------------
    ```

- Créez l’alias **fin** qui permet d’afficher les 2 dernières lignes d’un fichier.

  - ```bash
    jeanbourquj@MC0-0315-JJU:~/test$ vim ~/.bash_aliases
    jeanbourquj@MC0-0315-JJU:~/test$ sourcesmj
    
    jeanbourquj@MC0-0315-JJU:~/test$ alias
    alias add_alias='sh -c '\''echo alias $1="\""$2"\"" >> ~/.bash_aliases '\'' _ '
    [...]
    alias fin2='tail -n 2'
    alias sourcesmj='source ~/.bashrc'
    alias ssh_lab='ssh jeanbourquj@lozan.labo.dhu'
    alias update='sudo apt-get update'
    alias upgrade='sudo apt-get upgrade'
    
    ```

- Vérifiez le fonctionnement de votre alias sur le fichier **liste.lis**

  - ```bash
    jeanbourquj@MC0-0315-JJU:~/test$ fin2 list.lis
    -rw-------  1 jeanbourquj jeanbourquj  2884 mar  9 09:39 .xsession-errors
    -rw-------  1 jeanbourquj jeanbourquj  2691 mar  9 09:44 .xsession-errors.old
    ```

####  2)

- Créez l’alias **up** qui permet de remonter d’un niveau de répertoire

  - ```bash
    jeanbourquj@MC0-0315-JJU:~$ vim ~/.bash_aliases
    alias up='cd ..'
    ```

- Créez l’alias **user** qui permet d’afficher votre nom d’utilisateur

  - ```bash
    jeanbourquj@MC0-0315-JJU:~$ vim ~/.bash_aliases
    alias user='echo $USER'
    ```

- Affichez la liste complète des alias définis dans votre environnement

  - ```bash
    jeanbourquj@MC0-0315-JJU:~$ alias
    alias add_alias='sh -c '\''echo alias $1="\""$2"\"" >> ~/.bash_aliases '\'' _ '
    alias alert='notify-send --urgency=low -i "$([ $? = 0 ] && echo terminal || echo error)" "$(history|tail -n1|sed -e '\''s/^\s*[0-9]\+\s*//;s/[;&|]\s*alert$//'\'')"'
    alias egrep='egrep --color=auto'
    alias fgrep='fgrep --color=auto'
    alias fin2='tail -n 2'
    alias grep='grep --color=auto'
    alias l='ls -CF'
    alias la='ls -A'
    alias ll='ls -alF'
    alias ls='ls --color=auto'
    alias sourcesmj='source ~/.bashrc'
    alias ssh_lab='ssh jeanbourquj@lozan.labo.dhu'
    alias up='cd ..'
    alias update='sudo apt-get update'
    alias upgrade='sudo apt-get upgrade'
    alias user='echo jeanbourquj'
    
    ```

    

- Affichez la définition de l’alias **fin**

  - ```bash
    jeanbourquj@MC0-0315-JJU:~$ alias fin2
    alias fin2='tail -n 2'
    ```

#### 3)

- Créez un alias **ls** qui exécute la commande **ls –la** puis exécutez la commande **ls** sans paramètre. Quelle constatation ?

  - ```bash
    jeanbourquj@MC0-0315-JJU:~$ alias ls='ls -la'
    jeanbourquj@MC0-0315-JJU:~$ ls
    total 172
    drwxr-xr-x 23 jeanbourquj jeanbourquj  4096 mar  9 11:24 .
    drwxr-xr-x  4 root        root         4096 fév 16 15:23 ..
    -rw-r--r--  1 jeanbourquj jeanbourquj   195 fév 23 14:10 01-netcfg.yaml.old
    -rw-rw-r--  1 jeanbourquj jeanbourquj   298 mar  9 11:24 .bash_aliases
    -rw-------  1 jeanbourquj jeanbourquj 15643 mar  9 11:24 .bash_history
    -rw-r--r--  1 jeanbourquj jeanbourquj   220 fév 16 15:23 .bash_logout
    -rw-r--r--  1 jeanbourquj jeanbourquj  3771 mar  9 11:20 .bashrc
    -rw-rw-r--  1 jeanbourquj jeanbourquj     0 mar  9 09:07 bashrc
    [...]
    -rw-------  1 jeanbourquj jeanbourquj  2884 mar  9 09:39 .xsession-errors
    -rw-------  1 jeanbourquj jeanbourquj  2691 mar  9 09:44 .xsession-errors.old
    
    ```

    L'alias a remplacer le précédent `ls`

- Supprimez l’alias **ls** et vérifiez que ce dernier n’existe plus

  - ```bash
    jeanbourquj@MC0-0315-JJU:~$ unalias ls
    jeanbourquj@MC0-0315-JJU:~$ alias ls
    bash: alias: ls : non trouvé
    
    ```

#### 4)

- Créez la variable d’environnement **workdir** qui contient le nom du répertoire de **~/test** (chemin complet) que vous avez créé à l’exercice 1. Si ce répertoire n’existe pas recréez-le d’abord

  - ```bash
    jeanbourquj@MC0-0315-JJU:~$ workdir=~/"test"	
    ```

    

- Affichez le contenu de la variable **workdir**

  - ```bash
    jeanbourquj@MC0-0315-JJU:~$ echo $workdir
    /home/jeanbourquj/test
    ```

    

- Affichez le contenu de toutes les variables d’environnement définies

  - ```bash
    jeanbourquj@MC0-0315-JJU:~$ printenv
    SHELL=/bin/bash
    SESSION_MANAGER=local/MC0-0315-JJU:@/tmp/.ICE-unix/1681,unix/MC0-0315-JJU:/tmp/.ICE-unix/1681
    WINDOWID=77594627
    QT_ACCESSIBILITY=1
    COLORTERM=truecolor
    XDG_CONFIG_DIRS=/etc/xdg/xdg-ubuntu:/etc/xdg
    [...]
    XDG_DATA_DIRS=/usr/share/ubuntu:/usr/local/share:/usr/share:/var/lib/snapd/desktop
    PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin
    GDMSESSION=ubuntu
    DBUS_SESSION_BUS_ADDRESS=unix:path=/run/user/1000/bus
    GIO_LAUNCHED_DESKTOP_FILE_PID=258107
    GIO_LAUNCHED_DESKTOP_FILE=/usr/share/applications/xfce4-terminal.desktop
    OLDPWD=/home/jeanbourquj/.ssh
    _=/usr/bin/printenv
    
    ```

    

#### 5)

Dans le répertoire **~/test**, créez un fichier **monScript.sh** dans lequel vous définissez la variable d’environnement `moninvite` avec un texte de votre choix. exemple: “Bienvenue au cours Unix” Dans ce même script et après la définition de cette variable, insérez la commande qui permet de visualiser le contenu de la variable `moninvite` Faites le nécessaire pour que vous puissiez exécuter ce script Lancez ce script et vérifier le résultat. Après avoir exécuté le script, vérifiez si la variable d’environnement `moninvite` existe. Constatation ?

```bash
jeanbourquj@MC0-0315-JJU:~$ cat ~/test/monScript.sh 
moninvite="Bienvenu dans ce fichier script"

echo $moninvite;
jeanbourquj@MC0-0315-JJU:~$ . ~/test/monScript.sh
Bienvenu dans ce fichier script

jeanbourquj@MC0-0315-JJU:~$ printenv | grep moninvite
jeanbourquj@MC0-0315-JJU:~$ 

```

La variable n'existe pas.

#### 6)

Dans le répertoire **~/test** créez un fichier script **demo** qui contient la commande

```
ls –l
```

Vérifiez le fonctionnement de votre script Tapez la commande `cd` sans paramètre pour retourner sur votre répertoire de home Faites le nécessaire pour que le fichier `demo` puisse s’exécuter depuis votre répertoire de `home` en tapant simplement la commande

```
$ demo
```

#### 7)

Lorsque vous vous connecté au système, vous désirez toujours disposer de l’alias `fin` (voir exercice 1). Faites le nécessaire pour réaliser cette fonctionnalité. Vérifiez le fonctionnement en vous reconnectant au système. Lorsque vous vous connecté au système, vous désirez toujours disposer d’un environnement de commande qui permettent d’exécuter les scripts placés sur le répertoire `~/test` et ceci sans taper le chemin complet du fichier (voir exercice 6). Faites le nécessaire pour réaliser cette fonctionnalité. Vérifiez le fonctionnement en vous reconnectant au système et en lançant le script `demo` par la commande

```
$ demo
```

Il faut modifier le fichier `~/.bashrc` ou idéalement `~/.bash_aliases` puis redémarrer le terminal. Accésoirement pour réussir a réutiliser les nouveaux aliases, on peut utiliser la commande `source ~/.bashrc`

#### 8)

Script et variable d’environnements

- Définissez un script, se nommant `AffVar`, qui permet de d’afficher une variable nommée `ma_var`.

- Définissez dans le shell la variable `ma_var="ma variable est accessible"`

- Exécuter votre script `AffVar`. Constatation.

- Recommencer en exportant `ma_var`. : `export ma_var`

- Exécuter votre script `AffVar`. Constatations et conclusions.

  ```bash
  jeanbourquj@MC0-0315-JJU:~$ ma_var="ma variable est accesible"
  jeanbourquj@MC0-0315-JJU:~$ . ./test/AffVar
  ma variable est accesible
  
  -------------
  jeanbourquj@MC0-0315-JJU:~$ export ma_var
  jeanbourquj@MC0-0315-JJU:~$ . ./test/AffVar
  ma variable est accesible
  
  
  ```

  export semble implémenter la nouvelle variable dans la liste affiché par `printenv`

#### 9)

Coder le script suivant :

```bash
!/bin/bash

clear
message="Le traitements des arguments !"

echo 
echo "$message"
echo
echo "$0 $1 $2 $3"
echo
echo "Les 3 premiers arguments sont: $1 $2 $3 !"

echo
echo "Tous les arguments sont : $@"
echo 
echo "$! arguments"

echo
echo -n "Vous êtes "; whoami ; echo  "Votre UID est $UID"
```

Nommé ce script `ligneCmd` et faire les appels suivants :

```bash
./ligneCmd analyser ce script
jeanbourquj@MC0-0315-JJU:~/test$ ./ligneCmd analyser ce script

Le traitements des arguments !

./ligneCmd analyser ce script

Les 3 premiers arguments sont: analyser ce script !

Tous les arguments sont : analyser ce script

 arguments

Vous êtes jeanbourquj
Votre UID est 1000
jeanbourquj@MC0-0315-JJU:~/test$ 

----------------------------------------
./ligneCmd je comprends comment ca marche

jeanbourquj@MC0-0315-JJU:~/test$ ./ligneCmd je comprends comment ca marche

Le traitements des arguments !

./ligneCmd je comprends comment

Les 3 premiers arguments sont: je comprends comment !

Tous les arguments sont : je comprends comment ca marche

 arguments

Vous êtes jeanbourquj
Votre UID est 1000
jeanbourquj@MC0-0315-JJU:~/test$ 

```

Constatations ?

ce script va récupérer et utiliser les 3 premiers mots séparer par des espaces comme étant des arguments séparer.

## Scripts

### Table de multiplication

- Écrire un script qui affiche la table de multiplication d’un nombre passer en paramètres pour les valeurs de 1 à 12.

```
$ ./tableMult.sh 6
1x6=6
2x6=12
...
12x6=72
```

### Carré de multiplication

- Écrire un script qui affiche toutes les tables de multiplications de 1 à 12 sous forme d’un carré. L’instruction `printf` permet de formater.

```
$ ./carreTableMult.sh
      1   2   3   4   5   6   7   8   9  10  11  12
   ------------------------------------------------
 1:   1   2   3   4   5   6   7   8   9  10  11  12
 2:   2   4   6   8  10  12  14  16  18  20  22  24
 3:   3   6   9  12  15  18  21  24  27  30  33  36
 4:   4   8  12  16  20  24  28  32  36  40  44  48
 5:   5  10  15  20  25  30  35  40  45  50  55  60
 6:   6  12  18  24  30  36  42  48  54  60  66  72
 7:   7  14  21  28  35  42  49  56  63  70  77  84
 8:   8  16  24  32  40  48  56  64  72  80  88  96
 9:   9  18  27  36  45  54  63  72  81  90  99 108
10:  10  20  30  40  50  60  70  80  90 100 110 120
11:  11  22  33  44  55  66  77  88  99 110 121 132
12:  12  24  36  48  60  72  84  96 108 120 132 144
```

### Beuseu

Écrire un script bash qui affiche dans la console tout les nombres compris entre 0 et un nombre saisi par l’utilisateur.

- Si le nombre est un multiple du chiffre 7 afficher le mot **Beuseu** à sa place.
- Si le nombre contient le chiffre 7 afficher également le mot **Beuseu** à la place.

```
$ ./beuseu.sh 20
1
2
3
4
5
6
Beuseu
8
9
10
11
12
13
Beuseu
15
16
Beuseu
18
19
20
```

### Compilation en C et génération d’un projet C

> Pour avoir les outils de programmation C, installer le paquet ci-dessous
>
> ```
> sudo apt-get install build-essential
> ```

- structure de projet

```
-projet
 +-src
 | `-helloworld.c
 |
 +-build         ! dossier créé par build.sh
 | +-* .o        ! fichiers objet
 | `-helloworld  ! exécutable
 |
 +-build.sh
 `-clean.sh
```

- Script de construction des programmes C
- Écrire un script `./build.sh` permettant de compiler le programme `helloworld.c`
- Écrire un script `./clean.sh` permettant de supprimer les fichiers généré lors de la compilation.
- Écrire un script **creerProjet.sh** permettant de créer l’arborescence de projet ci-dessous.

```
$ ./creerProjet.sh <nom du projet>
./<nom du projet>
 +-src
 | `-<nom du projet>.c
 |
 +-build.sh
 `-clean
 .sh
```

- opération de compilation

```
cd ./build
gcc -ansi -c ../src/helloworld.c
gcc -o helloworld * .o
cd -
```

> Pour les étudiants avancés, refaire le même exercice en utilisant **make** en écrivant un **makefile**!

### Génération d’un projet en java

Écrire un script permettant de créer une arborescence de base d’un projet java.

- Affiche la syntax de la commande

```
$ ./creerProjetJava.sh
   
usage : creerProjetJava.sh [--type=(ant|bash)] --projet=<nomProjet>
        --type=bash par défaut.
```

- Génère un projet java avec les scripts bash

```
$ ./creerProjetJava.sh --type=bash --projet=test
$ tree
.
└── test
    ├── build.sh
    ├── clean.sh
    ├── run.sh
    └── src
        └── test
            └── Main.java
dom@domx1:scripts$ cat test/build.sh 
!/bin/bash
#
# auteur : dominique huguenin (dominique.huguenin@rpn.ch)
#

BUILD_PATH=build
SRC_PATH=src
CLASS_DEST=$BUILD_PATH/classes
CLASS_PATH=$CLASS_DEST
DOC_DEST=$BUILD_PATH/doc
API_DEST=$DOC_DEST/api
API_PACKAGE=test
LIB_DEST=$BUILD_PATH/lib
JAR_NAME=test.jar

MAIN_FILE=$SRC_PATH/test/Main.java

# compilation du programme

mkdir -p $CLASS_DEST
javac -d $CLASS_DEST -sourcepath $SRC_PATH -classpath $CLASS_PATH $MAIN_FILE

# création de l'archive

mkdir $LIB_DEST
jar cf $LIB_DEST/$JAR_NAME -C $CLASS_DEST .

# génération de la documention technique

javadoc -sourcepath $SRC_PATH -subpackages $API_PACKAGE -d $API_DEST
dom@domx1:scripts$ cat test/clean.sh 
!/bin/bash
#
# auteur : dominique huguenin (dominique.huguenin@rpn.ch)
#

if [ -d "build" ]; then
  rm -r build
fi
dom@domx1:scripts$ cat test/run.sh 
!/bin/bash
#
# auteur : dominique huguenin (dominique.huguenin@rpn.ch)
#

CLASS_PATH=build/lib/test.jar
java -classpath $CLASS_PATH test.Main
```

- Génère un projet java avec le fichier build.xml pour ant

```
dom@domx1:scripts$ ./creerProjetJava.sh --type=ant --projet=test
dom@domx1:scripts$ tree
.
└── test
    ├── build.xml
    └── src
        └── test
            └── Main.java
dom@domx1:scripts$ cat test/build.xml 
<?xml version="1.0" encoding="UTF-8" ?>
<!-- 

    auteur : dominique huguenin (dominique.huguenin@rpn.ch)
    
-->
<project name="test" default="core" basedir="." >
    <property name="jar.name" value="${ant.project.name}.jar"/>
    <property name="javadoc.packagenames" value="test.* "/>
    <property name="dist.name" value="${ant.project.name}"/>
    <property name="src.dir" value="src"/>
    
    <property name="build.dir" value="build"/>
    <property name="build.classes" value="${build.dir}/classes"/>
    <property name="build.lib" value="${build.dir}/lib"/>
    <property name="build.docs" value="${build.dir}/docs"/>
    <property name="build.javadocs" value="${build.docs}/api"/>
    
    <property name="dist.dir" value="dist"/>
    
    <property name="main.class" value="test.Main"/>
  <!-- 
    ==========================================================
    compile des fichiers java
    ==========================================================
  -->
  <target name="compile">
    <mkdir dir="${build.dir}" />
    <mkdir dir="${build.classes}" />
    <javac
      srcdir="${src.dir}"
      destdir="${build.classes}"
      debug="on">
    </javac>
  </target>
  
   <!-- 
    ==========================================================
    construit les archives jar du projet
    ==========================================================
  -->
  <target name="jar">
    <mkdir dir="${build.lib}" />
    <jar jarfile="${build.lib}/${jar.name}"
       basedir="${build.classes}"
    />
  </target>
  <!-- 
    ==========================================================
    construit la documentation du projet
    ==========================================================
  -->
  <target name="javadoc">
    <mkdir dir="${build.docs}" />
    <mkdir dir="${build.javadocs}" />
    
    <javadoc sourcepath="${src.dir}"
           destdir="${build.javadocs}"
       packagenames="${javadoc.packagenames}"
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
    <delete dir="${build.dir}" />
    <delete dir="${dist.dir}" />
    <delete file="${dist.name}-bin.zip" />
    <delete file="${dist.name}-src.zip" />
    <!-- détruit les fichiers avec les extensions log, 
         bak et comprenant un ~ dans l\'extension -->
    <delete>
      <fileset dir="${src.dir}">
        <include name="* * /* .log" />
        <include name="* * /* .bak" />
        <include name="* * /* .* ~" />
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
    
    <zip destfile="${dist.name}-bin.zip" basedir="${dist.dir}">
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
        <echo>${ant.project.name}</echo>
			
        <mkdir dir="${ant.project.name}"/>
			
        <copy todir="${ant.project.name}">
            <fileset dir="${basedir}">
                <include name="* * " />
                <exclude name="${ant.project.name}" />
            </fileset>
        </copy>                
			
        <zip destfile="${ant.project.name}-src.zip">
            <fileset dir="${basedir}">
                <include name="${ant.project.name}/" />
            </fileset>            
        </zip>    
            
        <delete dir="${ant.project.name}"/>        
    </target>        
  
  
  <!-- 
    ==========================================================
    création d\'un dossier contenant uniquement les fichiers
    d\'une distribution de l\'application
    ==========================================================
  -->
 <target name="dist" depends="core"
    description="construit un dossier contenant uniquement les fichiers pour la distribution">
    <copy todir="${dist.dir}/doc">
      <fileset dir="${build.docs}"/>
    </copy>
    <copy todir="${dist.dir}/lib">
      <fileset dir="${build.lib}"/>
    </copy>
    
    <echo file="${dist.dir}/run.sh" append="false">

!/bin/bash

CLASS_PATH=./lib/${jar.name}
java -classpath $CLASS_PATH ${main.class}
    </echo>
    
  </target>
  
 <!-- 
    ==========================================================
    Exécution du programme
    ==========================================================
  -->
 <target name="run" depends="compile"
    description="execute le programme">
       <java classname="${main.class}" fork="true" >
         <classpath>
           <pathelement path="${build.classes}"/>
         </classpath>
       </java>  
  </target>
  
 <target name="run-jar" depends="compile"
    description="execute le programme dans l'archive">
       <java classname="${main.class}" fork="true" >
         <classpath>
           <pathelement path="${build.lib}/${jar.name}"/>
         </classpath>
       </java>  
  </target>
  
  
 </project>
```

