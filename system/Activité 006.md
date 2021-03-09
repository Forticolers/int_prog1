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

#### 5

Dans le répertoire **~/test**, créez un fichier **monScript.sh** dans lequel vous définissez la variable d’environnement `moninvite` avec un texte de votre choix. exemple: “Bienvenue au cours Unix” Dans ce même script et après la définition de cette variable, insérez la commande qui permet de visualiser le contenu de la variable `moninvite` Faites le nécessaire pour que vous puissiez exécuter ce script Lancez ce script et vérifier le résultat. Après avoir exécuté le script, vérifiez si la variable d’environnement `moninvite` existe. Constatation ?

#### 6

Dans le répertoire **~/test** créez un fichier script **demo** qui contient la commande

```
ls –l
```

Vérifiez le fonctionnement de votre script Tapez la commande `cd` sans paramètre pour retourner sur votre répertoire de home Faites le nécessaire pour que le fichier `demo` puisse s’exécuter depuis votre répertoire de `home` en tapant simplement la commande

```
$ demo
```

#### 7

Lorsque vous vous connecté au système, vous désirez toujours disposer de l’alias `fin` (voir exercice 1). Faites le nécessaire pour réaliser cette fonctionnalité. Vérifiez le fonctionnement en vous reconnectant au système. Lorsque vous vous connecté au système, vous désirez toujours disposer d’un environnement de commande qui permettent d’exécuter les scripts placés sur le répertoire `~/test` et ceci sans taper le chemin complet du fichier (voir exercice 6). Faites le nécessaire pour réaliser cette fonctionnalité. Vérifiez le fonctionnement en vous reconnectant au système et en lançant le script `demo` par la commande

```
$ demo
```

#### 8

Script et variable d’environnements

- Définissez un script, se nommant `AffVar`, qui permet de d’afficher une variable nommée `ma_var`.
- Définissez dans le shell la variable `ma_var="ma variable est accessible"`
- Exécuter votre script `AffVar`. Constatation.
- Recommencer en exportant `ma_var`. : `export ma_var`
- Exécuter votre script `AffVar`. Constatations et conclusions.