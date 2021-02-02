[Back to README](https://mylos.cifom.ch/gitlab/JeanbourquJ/int_prog1/-/tree/master)
### 1)

_Créer trois sous-répertoires dans votre «home directory»: trav1, trav2 et trav3._

#### 1.1) Commande :
 
```
jeanbourquj@lozan:~$ mkdir trav{1..3}

``` 

#### 1.2) Vérification :
 
```
jeanbourquj@lozan:~$ ls -d trav*
trav1  trav2  trav3
``` 
### 2)

_Copier dans le répertoire trav1 tous les fichiers .h dont le nom commence par a, b, c ou d et qui se trouvent dans le répertoire /usr/include._

#### 2.1) Commande :

```
jeanbourquj@lozan:~$ cp /usr/include/[a-d]*.h ~/trav1

``` 

#### 2.2) Vérification :

```
jeanbourquj@lozan:~$ ls trav1/[a-d]*.h
trav1/aio.h      trav1/alloca.h  trav1/argz.h  trav1/assert.h    trav1/cifsidmap.h  trav1/cpio.h   trav1/dirent.h
trav1/Aliases.h  trav1/argp.h    trav1/ar.h    trav1/byteswap.h  trav1/complex.h    trav1/ctype.h  trav1/dlfcn.h
```

### 3)

_Copier dans le répertoire trav2 tous les fichiers dont le nom commence par 3 caractères quelconques suivis d’un caractère compris entre e et z et se terminant par .h. Les fichiers sources se trouvent dans le répertoire /usr/include._

#### 3.1) Commande :

```
jeanbourquj@lozan:~$ cp /usr/include/???[e-z]?.h ~/trav2

```
#### 3.2) Vérification :
 
```
jeanbourquj@lozan:~$ ls trav2/???[e-z]?.h
trav2/crypt.h  trav2/errno.h  trav2/fcntl.h  trav2/iconv.h  trav2/paths.h  trav2/sched.h  trav2/spawn.h  trav2/utime.h
trav2/ctype.h  trav2/error.h  trav2/gconv.h  trav2/libio.h  trav2/regex.h  trav2/sgtty.h  trav2/stdio.h  trav2/utmpx.h
```

### 4)
_Lister le contenu de ces répertoires._

#### 4.1) Commande :

```
jeanbourquj@lozan:~$ tree
.
├── trav1
│   ├── aio.h
│   ├── aliases.h
[...]
│   ├── dirent.h
│   └── dlfcn.h
├── trav2
│   ├── crypt.h
│   ├── ctype.h
[...]
│   ├── utime.h
│   └── utmpx.h
└── trav3

3 directories, 30 files
```

### 5)

_Visualiser votre répertoire de travail courant et choisir trav3._

#### 5.1) Commande :

```shell
jeanbourquj@lozan:~$ pwd && cd \trav3
/home/S2/jeanbourquj
jeanbourquj@lozan:~/trav3$
```

#### 5.2) Vérification :

```bash
jeanbourquj@lozan:~/trav3$ pwd
/home/S2/jeanbourquj/trav3
```

### 6)

_Copier dans trav3 les fichiers a.out.h, crypt.h et math.h qui se trouvent dans l’un de vos répertoires._

#### 6.1) Commande :

```
jeanbourquj@lozan:~$ cp /*/*/{a.out.h,crypt.h,math.h} ~/trav3
cp: cannot stat '/*/*/a.out.h': No such file or directory

```

#### 6.2) Vérification :

```

jeanbourquj@lozan:~$ tree trav3/
trav3/
├── crypt.h
└── math.h

0 directories, 2 files

```

### 7)

_Renommer le fichier aliases.h du répertoire trav1 et math.h du répertoire trav3 en Aliases.H et Math.H._

#### 7.1) Commande :

```
jeanbourquj@lozan:~$ mv trav1/aliases.h trav1/Aliases.h | mv trav3/math.h trav3/Math.h

```

#### 7.2) Vérification :

```
jeanbourquj@lozan:~$ ls trav[1,3]/[A,M]*.h
trav1/Aliases.h trav3/Math.h

```

### 8)

_Effacer tous les fichiers dont le nom commence par cry et qui se trouvent dans le répertoire trav1._

#### 8.1) Commande :

```
jeanbourquj@lozan:~$ tree \trav1
trav1
├── aio.h
[...]
├── cifsidmap.h
├── complex.h
├── cpio.h
├── crypt.h
├── ctype.h
├── dirent.h
└── dlfcn.h

0 directories, 15 files
------
jeanbourquj@lozan:~$ rm trav1/cry*.*

```

#### 8.2) Vérification :

```
jeanbourquj@lozan:~$ tree trav1/
trav1/
├── aio.h
[...]
├── cifsidmap.h
├── complex.h
├── cpio.h
├── ctype.h
├── dirent.h
└── dlfcn.h

0 directories, 14 files
```

### 9)

_Supprimer le répertoire trav3._


#### 9.1) Commande :

```
jeanbourquj@lozan:~$ rm -r trav3/
```

#### 9.2) Vérification :

```
jeanbourquj@lozan:~$ ls
trav1  trav2
```