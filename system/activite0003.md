[Back to README](https://mylos.cifom.ch/gitlab/JeanbourquJ/int_prog1/-/tree/master)

### 1)

_Exercer les commandes cat, head, tail, less et more. Pour less exercer ses propres sous-commandes._

* Cat
	- Permet de concaténer des fichiers où l'entrée standard et les afficher dans la sortie standard
* Head
	- Affiche les 10 premières lignes de chaque fichiers sur la sortie standard. L'entrée standard est lu si fichier est omis ou vaut '-'
* Tail
	- Comme head mais les 10 dernières lignes
* Less
	- Permet de paginer un texte sans devoir lire le fichier complet.
* More
	- Permet de paginer un texte, est moins puissant que less,


### 2)
_Prendre deux fichiers texte identiques, en modifier un et lister les différences ( diff et cmp )._

#### 2.1) Commande :

```
---Avant modification---
jeanbourquj@lozan:~$ cat file1.txt
file1.txt
S2Partages
S2Personnel
trav1
trav2
===== diff
jeanbourquj@lozan:~$ diff file1.txt file2.txt
>No return
===== cmp
jeanbourquj@lozan:~$ cmp file1.txt file2.txt
>No return
-------------------
jeanbourquj@lozan:~$ diff file1.txt file2.txt
5c5,6
< trav2
---
> trav2-Ligne modifié
> Ligne ajoutée
============= cmp
jeanbourquj@lozan:~$ cmp file1.txt file2.txt
file1.txt file2.txt differ: byte 45, line 5
```

### 3)
_Que fournissent les commandes suivantes ? Écrire une phrase compréhensible par une personne extérieure du domaine._

```
wc -l /etc/passwd
more /etc/passwd
grep li /etc/passwd
grep ^li /etc/passwd
grep 0 /etc/passwd
cut -d: -f1,4 /etc/passwd 
more /etc/group
cut -d: -f1,3 /etc/group
```

##### 3.1)
* wc -l /etc/passwd
	* Affiche le nombre de lignes du fichier  /etc/passwd
	
	```
	jeanbourquj@lozan:~$ wc -l /etc/passwd
31 /etc/passwd
	```	

* more /etc/passwd 
	- Affiche le contenu du fichier /etc/passwd de manière paginer simple
<details>
	  <summary markdown="span">Commande ``` jeanbourquj@lozan:~$ more /etc/passwd ```</summary>
	
		```
root:x:0:0:root:/root:/bin/bash
daemon:x:1:1:daemon:/usr/sbin:/usr/sbin/nologin
bin:x:2:2:bin:/bin:/usr/sbin/nologin
sys:x:3:3:sys:/dev:/usr/sbin/nologin
sync:x:4:65534:sync:/bin:/bin/sync
games:x:5:60:games:/usr/games:/usr/sbin/nologin
man:x:6:12:man:/var/cache/man:/usr/sbin/nologin
lp:x:7:7:lp:/var/spool/lpd:/usr/sbin/nologin
mail:x:8:8:mail:/var/mail:/usr/sbin/nologin
news:x:9:9:news:/var/spool/news:/usr/sbin/nologin
uucp:x:10:10:uucp:/var/spool/uucp:/usr/sbin/nologin
proxy:x:13:13:proxy:/bin:/usr/sbin/nologin
www-data:x:33:33:www-data:/var/www:/usr/sbin/nologin
backup:x:34:34:backup:/var/backups:/usr/sbin/nologin
list:x:38:38:Mailing List Manager:/var/list:/usr/sbin/nologin
irc:x:39:39:ircd:/var/run/ircd:/usr/sbin/nologin
gnats:x:41:41:Gnats Bug-Reporting System (admin):/var/lib/gnats:/usr/sbin/nologin
nobody:x:65534:65534:nobody:/nonexistent:/usr/sbin/nologin
systemd-network:x:100:102:systemd Network Management,,,:/run/systemd/netif:/usr/sbin/nologin
systemd-resolve:x:101:103:systemd Resolver,,,:/run/systemd/resolve:/usr/sbin/nologin
syslog:x:102:106::/home/syslog:/usr/sbin/nologin
messagebus:x:103:107::/nonexistent:/usr/sbin/nologin
_apt:x:104:65534::/nonexistent:/usr/sbin/nologin
lxd:x:105:65534::/var/lib/lxd/:/bin/false
uuidd:x:106:110::/run/uuidd:/usr/sbin/nologin
dnsmasq:x:107:65534:dnsmasq,,,:/var/lib/misc:/usr/sbin/nologin
landscape:x:108:112::/var/lib/landscape:/usr/sbin/nologin
sshd:x:109:65534::/run/sshd:/usr/sbin/nologin
pollinate:x:110:1::/var/cache/pollinate:/bin/false
ubuntu:x:1000:1000:Ubuntu:/home/ubuntu:/bin/bash
nagios:x:111:115::/var/lib/nagios:/usr/sbin/nologin
	```
	  
</details>	 

* grep li /etc/passwd
	- Affiche les lignes contenant le motif 'li' du fichier /etc/passwd
<details>
	  <summary markdown="span">Commande ``` jeanbourquj@lozan:~$ grep li /etc/passwd ```</summary>
	
		```
		list:x:38:38:Mailing List Manager:/var/list:/usr/sbin/nologin
		gnats:x:41:41:Gnats Bug-Reporting System (admin):/var/lib/gnats:/usr/sbin/nologin
		lxd:x:105:65534::/var/lib/lxd/:/bin/false
		dnsmasq:x:107:65534:dnsmasq,,,:/var/lib/misc:/usr/sbin/nologin
		landscape:x:108:112::/var/lib/landscape:/usr/sbin/nologin
		pollinate:x:110:1::/var/cache/pollinate:/bin/false
		nagios:x:111:115::/var/lib/nagios:/usr/sbin/nologin
		``` 
</details>	 

* grep \^li /etc/passwd
	- Affiche les lignes commençant par le motif 'li' dans le fichier /etc/passwd
	
	```
	jeanbourquj@lozan:~$ grep ^li /etc/passwd
list:x:38:38:Mailing List Manager:/var/list:/usr/sbin/nologin
	```
	
* grep 0 /etc/passwd
	- Affiche les lignes contenant le motif '0' dans le fichier /etc/passwd
	<details>
	  <summary markdown="span">Commande ``` jeanbourquj@lozan:~$ grep 0 /etc/passwd```</summary>
	
		```
		root:x:0:0:root:/root:/bin/bash
		games:x:5:60:games:/usr/games:/usr/sbin/nologin
		uucp:x:10:10:uucp:/var/spool/uucp:/usr/sbin/nologin
		systemd-network:x:100:102:systemd Network Management,,,:/run/systemd/netif:/usr/sbin/nologin
		systemd-resolve:x:101:103:systemd Resolver,,,:/run/systemd/resolve:/usr/sbin/nologin
		syslog:x:102:106::/home/syslog:/usr/sbin/nologin
		messagebus:x:103:107::/nonexistent:/usr/sbin/nologin
		_apt:x:104:65534::/nonexistent:/usr/sbin/nologin
		lxd:x:105:65534::/var/lib/lxd/:/bin/false
		uuidd:x:106:110::/run/uuidd:/usr/sbin/nologin
		dnsmasq:x:107:65534:dnsmasq,,,:/var/lib/misc:/usr/sbin/nologin
		landscape:x:108:112::/var/lib/landscape:/usr/sbin/nologin
		sshd:x:109:65534::/run/sshd:/usr/sbin/nologin
		pollinate:x:110:1::/var/cache/pollinate:/bin/false
		ubuntu:x:1000:1000:Ubuntu:/home/ubuntu:/bin/bash
		```
	  
</details>	 

* cut -d: -f1,4 /etc/passwd 
	- Afficher les collones '1' et '4' des lignes en les découpant ayant ':' comme délimiteur 
	<details>
	  <summary markdown="span">Commande ```jeanbourquj@lozan:~$ cut -d: -f1,4 /etc/passwd```</summary>
	
		```
	root:0
	daemon:1
	bin:2
	sys:3
	sync:65534
	games:60
	man:12
	lp:7
	mail:8
	news:9
	uucp:10
	proxy:13
	www-data:33
	backup:34
	list:38
	irc:39
	gnats:41
	nobody:65534
	systemd-network:102
	systemd-resolve:103
	syslog:106
	messagebus:107
	_apt:65534
	lxd:65534
	uuidd:110
	dnsmasq:65534
	landscape:112
	sshd:65534
	pollinate:1
	ubuntu:1000
	nagios:115
		```
	  
</details>
 
* more /etc/group
	- Affiche de manière paginer les lignes du fichier /etc/group
		<details>
	  <summary markdown="span">Commande ``` jeanbourquj@lozan:~$ more /etc/group```</summary>
	
		```
		root:x:0:
		daemon:x:1:
		bin:x:2:
		sys:x:3:
		adm:x:4:syslog,ubuntu
		tty:x:5:
		disk:x:6:
		lp:x:7:
		mail:x:8:
		news:x:9:
		uucp:x:10:
		man:x:12:
		proxy:x:13:
		kmem:x:15:
		dialout:x:20:ubuntu
		fax:x:21:
		voice:x:22:
		cdrom:x:24:ubuntu
		floppy:x:25:ubuntu
		tape:x:26:
		sudo:x:27:ubuntu
		audio:x:29:ubuntu
		dip:x:30:ubuntu
		www-data:x:33:
		backup:x:34:
		operator:x:37:
		list:x:38:
		irc:x:39:
		src:x:40:
		gnats:x:41:
		shadow:x:42:
		utmp:x:43:
		video:x:44:ubuntu
		sasl:x:45:
		plugdev:x:46:ubuntu
		staff:x:50:
		games:x:60:
		users:x:100:
		nogroup:x:65534:
		systemd-journal:x:101:
		systemd-network:x:102:
		systemd-resolve:x:103:
		input:x:104:
		crontab:x:105:
		syslog:x:106:
		messagebus:x:107:
		lxd:x:108:ubuntu
		mlocate:x:109:
		uuidd:x:110:
		ssh:x:111:
		landscape:x:112:
		admin:x:113:
		netdev:x:114:ubuntu
		ubuntu:x:1000:
		nagios:x:115:
		winbindd_priv:x:116:
		```
	  
</details>
	
* cut -d: -f1,3 /etc/group
	- Affiche les collones '1' et '3' des ligne du fichier /etc/group en délimitant les collones par ':'
		<details>
	  <summary markdown="span">Commande ``` 		jeanbourquj@lozan:~$ cut -d: -f1,3 /etc/group```</summary>
	
		```
		root:0
		daemon:1
		bin:2
		sys:3
		adm:4
		tty:5
		disk:6
		lp:7
		mail:8
		news:9
		uucp:10
		man:12
		proxy:13
		kmem:15
		dialout:20
		fax:21
		voice:22
		cdrom:24
		floppy:25
		tape:26
		sudo:27
		audio:29
		dip:30
		www-data:33
		backup:34
		operator:37
		list:38
		irc:39
		src:40
		gnats:41
		shadow:42
		utmp:43
		video:44
		sasl:45
		plugdev:46
		staff:50
		games:60
		users:100
		nogroup:65534
		systemd-journal:101
		systemd-network:102
		systemd-resolve:103
		input:104
		crontab:105
		syslog:106
		messagebus:107
		lxd:108
		mlocate:109
		uuidd:110
		ssh:111
		landscape:112
		admin:113
		netdev:114
		ubuntu:1000
		nagios:115
		winbindd_priv:116
		```
	  
</details>
	
### 4)
_Exécuter les commandes ci-dessous, comprendre ce qu’il se passe. Écrire une phrase compréhensible par une personne extérieure du domaine._

```
cat /etc/passwd | cut -d: -f1
cat /etc/passwd | cut -d: -f1,6
cat /etc/passwd | cut -d: -f1,6 | less
cat /etc/passwd | cut -d: -f1,4 | grep ':101$'
cat /etc/group | grep ^user
cat /etc/passwd | cut -d: -f1,6 | tee ./liste_comptes 
sort < ./liste_comptes > ./liste_comptes.triee 
cat /etc/passwd | cut -d: -f1,6 | tee ./liste_comptes | less
cat /etc/passwd | cut -d: -f1,4 >> ./liste_comptes
```

#### 4.1)

*	cat /etc/passwd | cut -d: -f1
	-	Affiche la première collone délimité par ':' du fichier /etc/passwd
	
		<details>
	  <summary markdown="span">Commande ``` jeanbourquj@lozan:~$ cat /etc/passwd | cut -d: -f1```</summary>
	
		```
root
daemon
bin
sys
sync
games
man
lp
mail
news
uucp
proxy
www-data
backup
list
irc
gnats
nobody
systemd-network
systemd-resolve
syslog
messagebus
_apt
lxd
uuidd
dnsmasq
landscape
sshd
pollinate
ubuntu
nagios
		```
	  
</details>

* jeanbourquj@lozan:~$ cat /etc/passwd | cut -d: -f1,6
	- Affiche les collones '1' et '6' délimité par ':' du fichier /etc/passwd.
		<details>
	  <summary markdown="span">Commande ``` jeanbourquj@lozan:~$ cat /etc/passwd | cut -d: -f1,6```</summary>
	
		```
root:/root
daemon:/usr/sbin
bin:/bin
sys:/dev
sync:/bin
games:/usr/games
man:/var/cache/man
lp:/var/spool/lpd
mail:/var/mail
news:/var/spool/news
uucp:/var/spool/uucp
proxy:/bin
www-data:/var/www
backup:/var/backups
list:/var/list
irc:/var/run/ircd
gnats:/var/lib/gnats
nobody:/nonexistent
systemd-network:/run/systemd/netif
systemd-resolve:/run/systemd/resolve
syslog:/home/syslog
messagebus:/nonexistent
_apt:/nonexistent
lxd:/var/lib/lxd/
uuidd:/run/uuidd
dnsmasq:/var/lib/misc
landscape:/var/lib/landscape
sshd:/run/sshd
pollinate:/var/cache/pollinate
ubuntu:/home/ubuntu
nagios:/var/lib/nagios
		```
</details>

* cat /etc/passwd | cut -d: -f1,6 | less
	- Affiche la même chose mais de manière paginer
		<details>
	  <summary markdown="span">Commande ``` jeanbourquj@lozan:~$ cat /etc/passwd | cut -d: -f1,6 | less```</summary>
	
		```
		root:/root
daemon:/usr/sbin
bin:/bin
sys:/dev
sync:/bin
games:/usr/games
man:/var/cache/man
lp:/var/spool/lpd
mail:/var/mail
news:/var/spool/news
uucp:/var/spool/uucp
proxy:/bin
www-data:/var/www
backup:/var/backups
list:/var/list
irc:/var/run/ircd
gnats:/var/lib/gnats
nobody:/nonexistent
systemd-network:/run/systemd/netif
systemd-resolve:/run/systemd/resolve
syslog:/home/syslog
messagebus:/nonexistent
_apt:/nonexistent
lxd:/var/lib/lxd/
uuidd:/run/uuidd
dnsmasq:/var/lib/misc
landscape:/var/lib/landscape
sshd:/run/sshd
pollinate:/var/cache/pollinate
ubuntu:/home/ubuntu
nagios:/var/lib/nagios
~
~
~
~
~
~
~
~
~
~
(END)
		```
	  
</details>	

* cat /etc/passwd | cut -d: -f1,4 | grep ':101$'
	- Affiche les collonnes '1' et '4' délimité par ':' du fichier /etc/passwd qui contienne le motif ':101$' (:101 en fin de ligne)

		```
		jeanbourquj@lozan:~$ cat /etc/passwd | cut -d: -f1,4 | grep ':101$'
		>No return
		```
* cat /etc/group | grep \^user
	- Affiche les lignes du fichier /etc/group dont les lignes commencent par 'user'
	
	```
	jeanbourquj@lozan:~$ cat /etc/group | grep ^user
users:x:100:
	```
* 	cat /etc/passwd | cut -d: -f1,6 | tee ./liste_comptes
	*	Affiche les collonnes '1' et '6' délimité par ':' du fichier /etc/passwd et créer un fichier 'liste_comptes' avec le contenu affiché
	
	<details>
	  <summary markdown="span">Commande ``` jeanbourquj@lozan:~$ cat /etc/passwd | cut -d: -f1,6 | tee ./liste_comptes```</summary>
	  
	```
		root:/root
		daemon:/usr/sbin
		bin:/bin
		sys:/dev
		sync:/bin
		games:/usr/games
		man:/var/cache/man
		lp:/var/spool/lpd
		mail:/var/mail
		news:/var/spool/news
		uucp:/var/spool/uucp
		proxy:/bin
		www-data:/var/www
		backup:/var/backups
		list:/var/list
		irc:/var/run/ircd
		gnats:/var/lib/gnats
		nobody:/nonexistent
		systemd-network:/run/systemd/netif
		systemd-resolve:/run/systemd/resolve
		syslog:/home/syslog
		messagebus:/nonexistent
		_apt:/nonexistent
		lxd:/var/lib/lxd/
		uuidd:/run/uuidd
		dnsmasq:/var/lib/misc
		landscape:/var/lib/landscape
		sshd:/run/sshd
		pollinate:/var/cache/pollinate
		ubuntu:/home/ubuntu
		nagios:/var/lib/nagios
		```
	  
</details>

* sort < ./liste_comptes > ./liste_comptes.triee 
	- Créer un fichier en triant les lignes par ordre alphabétique (avec les caractère spéciaux en premier (comme '_' ))
	
	```
	jeanbourquj@lozan:~$ sort < ./liste_comptes > ./liste_comptes.triee
	>No return
	```
	<details>
	  <summary markdown="span">Commande de vérification ``` jeanbourquj@lozan:~$ cat liste_comptes.triee```</summary>
	
	```
		_apt:/nonexistent
		backup:/var/backups
		bin:/bin
		daemon:/usr/sbin
		dnsmasq:/var/lib/misc
		games:/usr/games
		gnats:/var/lib/gnats
		irc:/var/run/ircd
		landscape:/var/lib/landscape
		list:/var/list
		lp:/var/spool/lpd
		lxd:/var/lib/lxd/
		mail:/var/mail
		man:/var/cache/man
		messagebus:/nonexistent
		nagios:/var/lib/nagios
		news:/var/spool/news
		nobody:/nonexistent
		pollinate:/var/cache/pollinate
		proxy:/bin
		root:/root
		sshd:/run/sshd
		sync:/bin
		sys:/dev
		syslog:/home/syslog
		systemd-network:/run/systemd/netif
		systemd-resolve:/run/systemd/resolve
		ubuntu:/home/ubuntu
		uucp:/var/spool/uucp
		uuidd:/run/uuidd
		www-data:/var/www
		```
	  
</details>

* cat /etc/passwd | cut -d: -f1,6 | tee ./liste_comptes | less
	- Affiche de manière paginé les collonnes '1' et '6' délimité par ':' du fichier /etc/passwd et créer un fichier 'liste_comptes' avec le contenu affiché
	
	
		<details>
	  <summary markdown="span">Commande ``` jeanbourquj@lozan:~$ cat /etc/passwd | cut -d: -f1,6 | tee ./liste_comptes | less```</summary>
	
		```
		root:/root
daemon:/usr/sbin
bin:/bin
sys:/dev
sync:/bin
games:/usr/games
man:/var/cache/man
lp:/var/spool/lpd
mail:/var/mail
news:/var/spool/news
uucp:/var/spool/uucp
proxy:/bin
www-data:/var/www
backup:/var/backups
list:/var/list
irc:/var/run/ircd
gnats:/var/lib/gnats
nobody:/nonexistent
systemd-network:/run/systemd/netif
systemd-resolve:/run/systemd/resolve
syslog:/home/syslog
messagebus:/nonexistent
_apt:/nonexistent
lxd:/var/lib/lxd/
uuidd:/run/uuidd
dnsmasq:/var/lib/misc
landscape:/var/lib/landscape
sshd:/run/sshd
pollinate:/var/cache/pollinate
ubuntu:/home/ubuntu
nagios:/var/lib/nagios
(END)
		```  
		</details>
		
			
		<details>
			  <summary markdown="span">Commande de vérification ```jeanbourquj@lozan:~$ cat liste_comptes```</summary>
			
		```
				root:/root
				daemon:/usr/sbin
				bin:/bin
				sys:/dev
				sync:/bin
				games:/usr/games
				man:/var/cache/man
				lp:/var/spool/lpd
				mail:/var/mail
				news:/var/spool/news
				uucp:/var/spool/uucp
				proxy:/bin
				www-data:/var/www
				backup:/var/backups
				list:/var/list
				irc:/var/run/ircd
				gnats:/var/lib/gnats
				nobody:/nonexistent
				systemd-network:/run/systemd/netif
				systemd-resolve:/run/systemd/resolve
				syslog:/home/syslog
				messagebus:/nonexistent
				_apt:/nonexistent
				lxd:/var/lib/lxd/
				uuidd:/run/uuidd
				dnsmasq:/var/lib/misc
				landscape:/var/lib/landscape
				sshd:/run/sshd
				pollinate:/var/cache/pollinate
				ubuntu:/home/ubuntu
				nagios:/var/lib/nagios
		```
			  
</details>