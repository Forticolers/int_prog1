[Back to README](https://mylos.cifom.ch/gitlab/JeanbourquJ/int_prog1/-/tree/master)

### 1)

_Créez 3 fichiers dans `~`_

*	file1
*	file2
*	file3

Vérifier les droits par défaut.

##### 1.1)


```
jeanbourquj@lozan:~/tmp/activite0004$ touch file{1..3}
-----
jeanbourquj@lozan:~/tmp/activite0004$ ls -l
total 2
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 14:05 file1
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 14:05 file2
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 14:05 file3
```

### 2)

_Assignez les droits suivants grâce à la forme littérale_

```
file1 rwx------
file2 r—-r—----
file3 r----x--x
```

#### 2.1)

```
jeanbourquj@lozan:~/tmp/activite0004$ chmod u=rwx,g=,o= file1;chmod u=r,g=r,o= file2;chmod u=r,g=x,o=x file3;

---------------------
jeanbourquj@lozan:~/tmp/activite0004$ ls -l
total 2
-rwx------ 1 jeanbourquj domain users 0 fév  9 14:29 file1
-r--r----- 1 jeanbourquj domain users 0 fév  9 14:29 file2
-r----x--x 1 jeanbourquj domain users 0 fév  9 14:29 file3
```

### 3)

_A l’aide de la forme octale , définissez les droits d’accès comme suit :_

```
file1 r-x-----x
file2 -w--w--w-
file3 ---rwx--x
```

#### 3.1)

```
jeanbourquj@lozan:~/tmp/activite0004$ chmod 501 file1 ; chmod 222 file2; chmod 071 file3

----------

jeanbourquj@lozan:~/tmp/activite0004$ ls -l
total 2
-r-x-----x 1 jeanbourquj domain users 0 fév  9 14:29 file1
--w--w--w- 1 jeanbourquj domain users 0 fév  9 14:29 file2
----rwx--x 1 jeanbourquj domain users 0 fév  9 14:29 file3
```


### 4)
1.	_Ajouter un texte dans le fichier file1. Constatations ?_
2. _Idem pour file2. Constatations ?_
3. _Idem pour file3. Constatations ?_

#### 4.1)

```
4.1.1) impossible (pas de droit d'écriture pour user)

jeanbourquj@lozan:~/tmp/activite0004$ echo test > file1
-bash: file1: Permission denied

4.1.2) possible 

jeanbourquj@lozan:~/tmp/activite0004$ echo test > file2

4.1.3) impossible (pas de droit d'écriture pour user)

jeanbourquj@lozan:~/tmp/activite0004$ echo test > file3
-bash: file3: Permission denied
```

### 5)
_Assigner les droits suivants:_

```
file1 ---------
file2 r--------
file3 rw-------
```

1.	_Copier le fichier file1 en file4. Constations ?_
2.	_Copier le fichier file2 en file5 et regarder les droits d’accès. Constatations ?_
3.	_Supprimez les fichiers file1 à file5. Constations ?_

#### 5.1)

```
jeanbourquj@lozan:~/tmp/activite0004$ chmod 000 file1 ; chmod 400 file2; chmod 600 file3

---------

jeanbourquj@lozan:~/tmp/activite0004$ cp file1 file4
cp: cannot open 'file1' for reading: Permission denied

--------

jeanbourquj@lozan:~/tmp/activite0004$ cp file2 file5

----------

jeanbourquj@lozan:~/tmp/activite0004$ rm file{1..5}
rm: remove write-protected regular empty file 'file1'? y
rm: remove write-protected regular file 'file2'? y
rm: cannot remove 'file4': No such file or directory
rm: remove write-protected regular file 'file5'? y
```

### 6)

_Créez un répertoire ~/test avec les droits suivants :_

`test drwx------`

1. _Dans le répertoire test, créez les fichier file1,file2,file5,file6,file7_
2. _Dans le répertoire test, créez un fichier testdroit.txt. Droits par défaut ?_
3. _Ajouter un texte dans ce fichier. Constatations?_
4. _Supprimer le fichier file1 . Constatations_

#### 6.1)

```

jeanbourquj@lozan:~/tmp/activite0004$ mkdir -m 700 test
jeanbourquj@lozan:~/tmp/activite0004$ ls
test
-------------------------

jeanbourquj@lozan:~/tmp/activite0004/test$ touch file{1,2,5,6,7}

jeanbourquj@lozan:~/tmp/activite0004/test$ ls

file1  file2  file5  file6  file7
-------------------------

jeanbourquj@lozan:~/tmp/activite0004/test$ touch testdroit.txt

jeanbourquj@lozan:~/tmp/activite0004/test$ ls -l

total 3
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 15:08 file1
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 15:08 file2
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 15:08 file5
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 15:08 file6
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 15:08 file7
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 15:08 testdroit.txt
-------------------------

jeanbourquj@lozan:~/tmp/activite0004/test$ echo test > testdroit.txt

jeanbourquj@lozan:~/tmp/activite0004/test$ cat testdroit.txt

test
-------------------------

jeanbourquj@lozan:~/tmp/activite0004/test$ rm file1

jeanbourquj@lozan:~/tmp/activite0004/test$ ls -l

total 3
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 15:08 file2
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 15:08 file5
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 15:08 file6
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 15:08 file7
-rw-r--r-- 1 jeanbourquj domain users 5 fév  9 15:09 testdroit.txt

```

### 7)

_Positionnez-vous sur le répertoire « parent » de test et modifier les droits comme suit : `test drw-------`_

```
jeanbourquj@lozan:~$ chmod go-rwx,u+rw ./test
jeanbourquj@lozan:~$ ls -l
total 33
[...]
drw------- 2 jeanbourquj domain users     4 fév  9 07:50 test
[...]

```

#### 7.1)
_Visualisez le contenu du répertoire test et vérifiez les droits d’accès du fichier testdroit.txt. Constatation ?_

Droit refusé car pas d'accès d'éxecution.

```
jeanbourquj@lozan:~/tmp/activite0004$ ls -l ./test/
ls: cannot access './test/file7': Permission denied
ls: cannot access './test/testdroit.txt': Permission denied
ls: cannot access './test/file6': Permission denied
ls: cannot access './test/file2': Permission denied
ls: cannot access './test/file5': Permission denied
total 0
-????????? ? ? ? ?            ? file2
-????????? ? ? ? ?            ? file5
-????????? ? ? ? ?            ? file6
-????????? ? ? ? ?            ? file7
-????????? ? ? ? ?            ? testdroit.txt

```

#### 7.2)

_Créer un nouveau fichier testdroit1.txt dans le répertoire test. Constations ?_

Droit refusé car pas d'accès d'éxecution.

```
jeanbourquj@lozan:~/tmp/activite0004$ touch ./test/testdroit1.txt
touch: cannot touch './test/testdroit1.txt': Permission denied

```

#### 7.3)

_Supprimez le fichier file2. Constations ?_

Droit refusé car pas d'accès d'éxecution.

```
jeanbourquj@lozan:~/tmp/activite0004$ rm ./test/file2
rm: cannot remove './test/file2': Permission denied

```

### 8)

_Positionnez-vous sur le répertoire « parent » de test et modifier les droits comme suit : `test d-w-------`_


```
jeanbourquj@lozan:~/tmp/activite0004$ chmod u-r ./test/
jeanbourquj@lozan:~/tmp/activite0004$ ls -l
total 1
d-w------- 2 jeanbourquj domain users 7 fév  9 15:09 test

```

#### 8.1)

_Visualisez le contenu du répertoire test et vérifiez les droits d’accès aux fichiers contenus dans ce répertoire. Constatation ?_

Pas d'accès au dossier car pas de droit de lecture.

```
jeanbourquj@lozan:~/tmp/activite0004$ ls -l ./test/
ls: cannot open directory './test/': Permission denied
```

### 9)

_Positionnez-vous sur le répertoire « parent » de test et modifier les droits comme suit : `test dr--------`_

```
jeanbourquj@lozan:~/tmp/activite0004$ chmod u-w,u+r ./test
jeanbourquj@lozan:~/tmp/activite0004$ ls -l
total 1
dr-------- 2 jeanbourquj domain users 7 fév  9 15:09 test
```

#### 9.1)

_Visualisez le contenu du répertoire test et vérifiez les droits d’accès aux fichiers contenus dans ce répertoire. Constatation ?_

Possibilité de lecture du dossier, mais toujours pas d'execution.

```
jeanbourquj@lozan:~/tmp/activite0004$ ls -l ./test/
ls: cannot access './test/file7': Permission denied
ls: cannot access './test/testdroit.txt': Permission denied
ls: cannot access './test/file6': Permission denied
ls: cannot access './test/file2': Permission denied
ls: cannot access './test/file5': Permission denied
total 0
-????????? ? ? ? ?            ? file2
-????????? ? ? ? ?            ? file5
-????????? ? ? ? ?            ? file6
-????????? ? ? ? ?            ? file7
-????????? ? ? ? ?            ? testdroit.txt
```

### 10)

_Positionnez-vous sur le répertoire « parent » de test et modifier les droits comme suit : `test dr-x------`_

```
jeanbourquj@lozan:~/tmp/activite0004$ chmod u+x ./test
jeanbourquj@lozan:~/tmp/activite0004$ ls -l
total 1
dr-x------ 2 jeanbourquj domain users 7 fév  9 15:09 test
```

#### 10.1)

_Visualisez le contenu du répertoire test et vérifiez les droits d’accès aux fichiers contenus dans ce répertoire. Constatation ?_

On peut à nouveau executé les commandes dans le dossier.

```
jeanbourquj@lozan:~/tmp/activite0004$ ls -l ./test/
total 3
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 15:08 file2
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 15:08 file5
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 15:08 file6
-rw-r--r-- 1 jeanbourquj domain users 0 fév  9 15:08 file7
-rw-r--r-- 1 jeanbourquj domain users 5 fév  9 15:09 testdroit.txt
```

#### 10.2)

_Créez un nouveau fichier testdroit5.txt dans le répertoire test. Remarques ?_

On ne peut pas cérer un nouveau fichier car on a pas les droit d'écriture.

```
jeanbourquj@lozan:~/tmp/activite0004$ touch ./test/testdroit5.txt
touch: cannot touch './test/testdroit5.txt': Permission denied
```

#### 10.3)

_Ajoutez un texte au fichier file5. Constations ?_

On peut écrire dans le fichier, ainsi que le lire car le fichier en lui même en a les droits (`-rw-r--r-- 1 jeanbourquj domain users 17 fév 15 23:37 file5`)

```
jeanbourquj@lozan:~/tmp/activite0004$ echo "Exemple de texte" >> ./test/file5
jeanbourquj@lozan:~/tmp/activite0004$ cat ./test/file5
Exemple de texte
```

#### 10.4)

_Supprimez le fichier file5. Constatations ?_

On a pas les droit d'execution sur le fichier, mais on l'a sur le dossier.

```
jeanbourquj@lozan:~/tmp/activite0004$ rm ./test/file5
rm: cannot remove './test/file5': Permission denied
```

### 11)

_Positionnez-vous sur le répertoire « parent » de test et modifier les droits comme suit : `test d--x------`_

```
jeanbourquj@lozan:~/tmp/activite0004$ chmod u-r ./test
jeanbourquj@lozan:~/tmp/activite0004$ ls -l
total 1
d--x------ 2 jeanbourquj domain users 7 fév  9 15:09 test

```

#### 11.1)

_Visualisez le contenu du répertoire test et vérifiez les droits d’accès aux fichiers contenus dans ce répertoire. Constatations ?_

```
jeanbourquj@lozan:~/tmp/activite0004$ ls -l ./test/
ls: cannot open directory './test/': Permission denied
```

#### 11.2)

_Créez un fichier testdroit6.txt dans test. Constatations ?_

```
jeanbourquj@lozan:~/tmp/activite0004$ touch ./test/testdroit6.txt
touch: cannot touch './test/testdroit6.txt': Permission denied

```

#### 11.3)

_Ajoutez un texte de votre choix au fichier file6. Constatations ?_

```
jeanbourquj@lozan:~/tmp/activite0004$ echo "Text" >> ./test/file6
jeanbourquj@lozan:~/tmp/activite0004$ cat ./test/file6
Text

```

#### 11.4)

_Supprimez le fichier file6. Constatations ?_

```
jeanbourquj@lozan:~/tmp/activite0004$ rm ./test/file6
rm: cannot remove './test/file6': Permission denied
```

### 12)

_Positionnez-vous sur le répertoire « parent » de test et modifier les droits comme suit : `test d-wx------`_

```
jeanbourquj@lozan:~/tmp/activite0004$ chmod u+w ./test
jeanbourquj@lozan:~/tmp/activite0004$ ls -l
total 1
d-wx------ 2 jeanbourquj domain users 7 fév  9 15:09 test
```

#### 12.1)

_Visualisez le contenu du répertoire test et vérifiez les droits d’accès aux fichiers contenus dans ce répertoire. Constatations ?_

```
jeanbourquj@lozan:~/tmp/activite0004$ ls -l ./test/
ls: cannot open directory './test/': Permission denied
```

#### 12.2)

Créez un fichier testdroit7.txt dans test. Constatations ?

On peut le créer mais pas vérifier sîl a été correctement créer.

```
jeanbourquj@lozan:~/tmp/activite0004$ touch ./test/testdroit7.text
```

#### 12.3)

Ajoutez un texte de votre choix au fichier file7. Constatations ?

```
jeanbourquj@lozan:~/tmp/activite0004$ echo "Texte au choix" >> ./test/file7
jeanbourquj@lozan:~/tmp/activite0004$ cat ./test/file7
Texte au choix
```

#### 12.4)

_Supprimez le fichier file7. Constatations ?_

```
jeanbourquj@lozan:~/tmp/activite0004$ rm ./test/file7
jeanbourquj@lozan:~/tmp/activite0004$ rm ./test/file7
rm: cannot remove './test/file7': No such file or directory
```

### 13)

_Créer un sous-répertoire test_sec et y placer quelques fichiers._

```
jeanbourquj@lozan:~/tmp/activite0004$ touch ./test/test_sec/file{00..05}
jeanbourquj@lozan:~/tmp/activite0004$ ls ./test/test_sec/
file00  file01  file02  file03  file04  file05
```

### 14)

_Placer les bons codes de protection à votre répertoire test_sec et à ses fichiers afin de permettre aux membres de votre groupe de:_

1.	lire le contenu des fichiers
2.	lister les fichiers sans pouvoir lire leur contenu
3.	lire le contenu d’un fichier connu sans pouvoir faire la liste des fichiers
4. modifier un fichier existant
5. ajouter et effacer un fichier