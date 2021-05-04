#### 6) cloner un conteneur LXC dans un conteneur LVM LXC

* Copie des fichier d'un conteneur LXC

  ```bash
  jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo cp -R /var/lib/lxc/C1 /var/lib/lxc/P1
  
  -----------------------
  jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo tree /var/lib/lxc/P1
  /var/lib/lxc/P1
  ├── config
  └── rootfs
  
  ```
  
  * Modification du fichier de config 
  
  ```bash
  jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo vim /var/lib/lxc/P1/config
  -----------------
  jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo cat /var/lib/lxc/P1/config
  # Template used to create this container: /usr/share/lxc/templates/lxc-download
  # Parameters passed to the template:
  # For additional config options, please look at lxc.container.conf(5)
  
  # Uncomment the following line to support nesting containers:
  #lxc.include = /usr/share/lxc/config/nesting.conf
  # (Be aware this has security implications)
  
  
  # Distribution configuration
  lxc.include = /usr/share/lxc/config/common.conf
  
  # For Ubuntu 14.04
  lxc.mount.entry = /sys/kernel/debug sys/kernel/debug none bind,optional 0 0
  lxc.mount.entry = /sys/kernel/security sys/kernel/security none bind,optional 0 0
  lxc.mount.entry = /sys/fs/pstore sys/fs/pstore none bind,optional 0 0
  lxc.mount.entry = mqueue dev/mqueue mqueue rw,relatime,create=dir,optional 0 0
  lxc.arch = linux64
  
  # Container specific configuration
  lxc.rootfs.path = lvm:/dev/MC0-0315-JJU-VG/lxc-P1
  lxc.uts.name = P1
  
  # Network configuration
  lxc.net.0.type = veth
  lxc.net.0.link = lxcbr0
  lxc.net.0.flags = up
  lxc.net.0.hwaddr = 00:14:3f:9a:00:0a
  
  ```
  
    
  
  * Création du volume logique
  
  ```bash
  jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo cp -R /var/lib/lxc/C1 /var/lib/lxc/P1
  ------------------------------------
  jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo lvdisplay MC0-0315-JJU-VG/lxc-P1
    --- Logical volume ---
    LV Path                /dev/MC0-0315-JJU-VG/lxc-P1
    LV Name                lxc-P1
    VG Name                MC0-0315-JJU-VG
    LV UUID                lcXhMF-CBoc-WAgj-y4QK-YD1r-xF9l-BRzEdu
    LV Write Access        read/write
    LV Creation host, time MC0-0315-JJU, 2021-05-04 13:33:19 +0200
    LV Status              available
    # open                 0
    LV Size                2.00 GiB
    Current LE             512
    Segments               1
    Allocation             inherit
    Read ahead sectors     auto
    - currently set to     256
    Block device           253:10
  ```
  
  * Formatage du volume logique
  
  ```bash
  jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo mkfs.ext4 /dev/MC0-0315-JJU-VG/lxc-P1
  mke2fs 1.45.5 (07-Jan-2020)
  En train de créer un système de fichiers avec 524288 4k blocs et 131072 i-noeuds.
  UUID de système de fichiers=2b39e058-5cf9-46ff-b076-f7f50ea9d0b0
  Superblocs de secours stockés sur les blocs : 
  	32768, 98304, 163840, 229376, 294912
  
  Allocation des tables de groupe : complété                            
  Écriture des tables d'i-noeuds : complété                            
  Création du journal (16384 blocs) : complété
  Écriture des superblocs et de l'information de comptabilité du système de
  fichiers : complété
  
  ```
  
  * Monter `/mnt` sur le volume logique
  
  ```bash
  jeanbourquj@MC0-0315-JJU:/mnt$ sudo mount /dev/MC0-0315-JJU-VG/lxc-P1 /mnt
  ----------------
  jeanbourquj@MC0-0315-JJU:/mnt$ df -h | grep P1
  /dev/mapper/MC0--0315--JJU--VG-lxc--P1   2.0G    617M  1.2G  34% /mnt
  ```
  
  * Copie des fichier dans le système de fichier monté
  
  ```bash
  jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo rsync -av /var/lib/lxc/CN/rootfs/ /mnt/P1/rootfs/
  
  -------------------
  jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo tree /mnt-L 3
  /mnt/P1
  └── ├── bin -> usr/bin
      ├── boot
      ├── dev
      │   └── pts
      ├── etc
      │   ├── adduser.conf
      │   ├── alternatives
      │   ├── apparmor
      │   ├── apparmor.d
      │   ├── apt
      │   ├── bash.bashrc
      │   ├── bindresvport.blacklist
      │   ├── binfmt.d
      │   ├── ca-certificates
      │   ├── ca-certificates.conf
      │   ├── ca-certificates.conf.dpkg-old
      │   ├── console-setup
      │   ├── cron.d
      │   ├── cron.daily
      │   ├── cron.hourly
      │   ├── cron.monthly
      │   ├── crontab
      │   ├── cron.weekly
      │   ├── dbus-1
      │   ├── debconf.conf
      │   ├── debian_version
      │   ├── default
      │   ├── deluser.conf
      │   ├── depmod.d
      │   ├── dhcp
      │   ├── dpkg
      │   ├── e2scrub.conf
      │   ├── environment
      │   ├── ethertypes
      │   ├── fstab
      │   ├── fuse.conf
      │   ├── gai.conf
      │   ├── group
      │   ├── group-
      │   ├── gshadow
      │   ├── gshadow-
      │   ├── gss
      │   ├── host.conf
      │   ├── hostname
      │   ├── hosts
      │   ├── hosts.allow
      │   ├── hosts.deny
      │   ├── init.d
      │   ├── inputrc
      │   ├── iproute2
      │   ├── issue
      │   ├── issue.net
      │   ├── kernel
      │   ├── ld.so.cache
      │   ├── ld.so.conf
      │   ├── ld.so.conf.d
      │   ├── legal
      │   ├── libaudit.conf
      │   ├── locale.alias
      │   ├── locale.gen
      │   ├── localtime -> /usr/share/zoneinfo/Etc/UTC
      │   ├── logcheck
      │   ├── login.defs
      │   ├── logrotate.conf
      │   ├── logrotate.d
      │   ├── lsb-release
      │   ├── machine-id
      │   ├── magic
      │   ├── magic.mime
      │   ├── mailcap
      │   ├── mailcap.order
      │   ├── mime.types
      │   ├── mke2fs.conf
      │   ├── modprobe.d
      │   ├── modules
      │   ├── modules-load.d
      │   ├── mtab -> ../proc/self/mounts
      │   ├── netplan
      │   ├── networkd-dispatcher
      │   ├── networks
      │   ├── newt
      │   ├── nsswitch.conf
      │   ├── opt
      │   ├── os-release -> ../usr/lib/os-release
      │   ├── pam.conf
      │   ├── pam.d
      │   ├── passwd
      │   ├── passwd-
      │   ├── profile
      │   ├── profile.d
      │   ├── protocols
      │   ├── python3
      │   ├── python3.8
      │   ├── rc0.d
      │   ├── rc1.d
      │   ├── rc2.d
      │   ├── rc3.d
      │   ├── rc4.d
      │   ├── rc5.d
      │   ├── rc6.d
      │   ├── rcS.d
      │   ├── resolv.conf -> ../run/systemd/resolve/stub-resolv.conf
      │   ├── rmt -> /usr/sbin/rmt
      │   ├── rpc
      │   ├── rsyslog.conf
      │   ├── rsyslog.d
      │   ├── security
      │   ├── selinux
      │   ├── services
      │   ├── shadow
      │   ├── shadow-
      │   ├── shells
      │   ├── skel
      │   ├── ssh
      │   ├── ssl
      │   ├── subgid
      │   ├── subuid
      │   ├── sudoers
      │   ├── sudoers.d
      │   ├── sysctl.conf
      │   ├── sysctl.d
      │   ├── systemd
      │   ├── terminfo
      │   ├── timezone
      │   ├── tmpfiles.d
      │   ├── ubuntu-advantage
      │   ├── ucf.conf
      │   ├── udev
      │   ├── ufw
      │   ├── update-motd.d
      │   ├── vim
      │   ├── vtrgb -> /etc/alternatives/vtrgb
      │   ├── wgetrc
      │   ├── X11
      │   ├── xattr.conf
      │   └── xdg
      ├── home
      │   └── ubuntu
      ├── lib -> usr/lib
      ├── lib32 -> usr/lib32
      ├── lib64 -> usr/lib64
      ├── libx32 -> usr/libx32
      ├── media
      ├── mnt
      ├── opt
      ├── proc
      ├── root
      ├── run
      ├── sbin -> usr/sbin
      ├── srv
      ├── sys
      ├── tmp
      ├── usr
      │   ├── bin
      │   ├── games
      │   ├── include
      │   ├── lib
      │   ├── lib32
      │   ├── lib64
      │   ├── libx32
      │   ├── local
      │   ├── sbin
      │   ├── share
      │   └── src
      └── var
          ├── backups
          ├── cache
          ├── lib
          ├── local
          ├── lock
          ├── log
          ├── mail
          ├── opt
          ├── run -> /run
          ├── spool
          └── tmp
  
  106 directories, 71 files
  ```
  
  > Démarrer la machine et tout devrait fonctionner.

#### 7) Agrandir de 1G le volume logique du conteneur C3

```bash
---Avant
jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo lvdisplay /dev/MC0-0315-JJU-VG/C3
 --- Logical volume ---
  LV Path                /dev/MC0-0315-JJU-VG/C3
  LV Name                C3
  VG Name                MC0-0315-JJU-VG
  LV UUID                mo3ZpO-oKZy-wzQR-HjIA-hx2X-iAya-w9t5Au
  LV Write Access        read/write
  LV Creation host, time MC0-0315-JJU, 2021-05-04 11:31:03 +0200
  LV Status              available
  # open                 0
  LV Size                1.00 GiB
  Current LE             256
  Segments               1
  Allocation             inherit
  Read ahead sectors     auto
  - currently set to     256
  Block device           253:9

```



```bash
jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo lvresize -L +1G /dev/MC0-0315-JJU-VG/C3
  Size of logical volume MC0-0315-JJU-VG/C3 changed from 1.00 GiB (256 extents) to 2.00 GiB (512 extents).
  Logical volume MC0-0315-JJU-VG/C3 successfully resized.
```

```bash
-------Après
jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo lvdisplay /dev/MC0-0315-JJU-VG/C3
  --- Logical volume ---
  LV Path                /dev/MC0-0315-JJU-VG/C3
  LV Name                C3
  VG Name                MC0-0315-JJU-VG
  LV UUID                mo3ZpO-oKZy-wzQR-HjIA-hx2X-iAya-w9t5Au
  LV Write Access        read/write
  LV Creation host, time MC0-0315-JJU, 2021-05-04 11:31:03 +0200
  LV Status              available
  # open                 0
  LV Size                2.00 GiB
  Current LE             512
  Segments               2
  Allocation             inherit
  Read ahead sectors     auto
  - currently set to     256
  Block device           253:9

```

Redimensionnement du volume logique

```bash
jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo e2fsck -f /dev/MC0-0315-JJU-VG/C3
e2fsck 1.45.5 (07-Jan-2020)
Passe 1 : vérification des i-noeuds, des blocs et des tailles
Passe 2 : vérification de la structure des répertoires
Passe 3 : vérification de la connectivité des répertoires
Passe 4 : vérification des compteurs de référence
Passe 5 : vérification de l'information du sommaire de groupe
/dev/MC0-0315-JJU-VG/C3 : 21355/65536 fichiers (0.2% non contigus), 155902/262144 blocs
jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo resize2fs /dev/MC0-0315-JJU-VG/C3
resize2fs 1.45.5 (07-Jan-2020)
En train de redimensionner le système de fichiers sur /dev/MC0-0315-JJU-VG/C3 à 524288 (4k) blocs.
Le système de fichiers sur /dev/MC0-0315-JJU-VG/C3 a maintenant une taille de 524288 blocs (4k).

```

```bash
----Avant
ubuntu@C3:~$ df -h
Filesystem               Size  Used Avail Use% Mounted on
/dev/MC0-0315-JJU-VG/C3  976M  561M  348M  62% /
none                     492K     0  492K   0% /dev
tmpfs                    7.8G     0  7.8G   0% /dev/shm
tmpfs                    1.6G  112K  1.6G   1% /run
tmpfs                    5.0M     0  5.0M   0% /run/lock
tmpfs                    7.8G     0  7.8G   0% /sys/fs/cgroup
tmpfs                    1.6G     0  1.6G   0% /run/user/1000

-----Après
ubuntu@C3:~$ df -h
Filesystem               Size  Used Avail Use% Mounted on
/dev/MC0-0315-JJU-VG/C3  2.0G  562M  1.3G  31% /
none                     492K     0  492K   0% /dev
tmpfs                    7.8G     0  7.8G   0% /dev/shm
tmpfs                    1.6G  112K  1.6G   1% /run
tmpfs                    5.0M     0  5.0M   0% /run/lock
tmpfs                    7.8G     0  7.8G   0% /sys/fs/cgroup
tmpfs                    1.6G     0  1.6G   0% /run/user/1000

```



#### 8) ajouter un deuxième interface réseau.

Éditer le fichier config dans `var/lib/lxc/C3/config`

```bash
jeanbourquj@MC0-0315-JJU:~/virtualisation$ sudo cat /var/lib/lxc/C3/config
# Template used to create this container: /usr/share/lxc/templates/lxc-download
# Parameters passed to the template: -d ubuntu -r focal -a amd64
# For additional config options, please look at lxc.container.conf(5)
# Uncomment the following line to support nesting containers:
#lxc.include = /usr/share/lxc/config/nesting.conf
# (Be aware this has security implications)
# Distribution configuration
lxc.include = /usr/share/lxc/config/common.conf
# For Ubuntu 14.04
lxc.mount.entry = /sys/kernel/debug sys/kernel/debug none bind,optional 0 0
lxc.mount.entry = /sys/kernel/security sys/kernel/security none bind,optional 0 0
lxc.mount.entry = /sys/fs/pstore sys/fs/pstore none bind,optional 0 0
lxc.mount.entry = mqueue dev/mqueue mqueue rw,relatime,create=dir,optional 0 0
lxc.arch = linux64
# Container specific configuration
# Network configuration
lxc.net.0.type = veth
lxc.net.0.link = lxcbr0
lxc.net.0.flags = up
lxc.net.0.hwaddr = 00:16:3e:4b:ca:1f
lxc.net.0.name = eth0
lxc.rootfs.path = lvm:/dev/MC0-0315-JJU-VG/C3
lxc.uts.name = C3

# Network configuration
 lxc.net.1.type = veth
 lxc.net.1.link = virbr0
 lxc.net.1.flags = up
 lxc.net.1.name = eth1
 lxc.net.1.hwaddr = 00:16:3e:x:x:x

```

Ajout de la configuration dhcp à netplan

```bash
ubuntu@C3:~$ sudo vim /etc/netplan/10-lxc.yaml 
----------------
ubuntu@C3:~$ sudo cat /etc/netplan/10-lxc.yaml 
network:
  version: 2
  ethernets:
    eth0:
      dhcp4: true
      dhcp-identifier: mac
    eth1:
      dhcp4: true
      dhcp-identifier: mac


```

Vérification

```bash
ubuntu@C3:~$ ip a
1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
    inet 127.0.0.1/8 scope host lo
       valid_lft forever preferred_lft forever
    inet6 ::1/128 scope host 
       valid_lft forever preferred_lft forever
2: eth0@if44: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc noqueue state UP group default qlen 1000
    link/ether 00:16:3e:4b:ca:1f brd ff:ff:ff:ff:ff:ff link-netnsid 0
    inet 10.0.3.106/24 brd 10.0.3.255 scope global dynamic eth0
       valid_lft 3590sec preferred_lft 3590sec
    inet6 fe80::216:3eff:fe4b:ca1f/64 scope link 
       valid_lft forever preferred_lft forever
3: eth1@if45: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc noqueue state UP group default qlen 1000
    link/ether 00:16:3e:05:00:0d brd ff:ff:ff:ff:ff:ff link-netnsid 0
    inet 192.168.122.244/24 brd 192.168.122.255 scope global dynamic eth1
       valid_lft 3595sec preferred_lft 3595sec
    inet6 fe80::216:3eff:fe05:d/64 scope link 
       valid_lft forever preferred_lft forever

```

### 9) Configurer la machine C3 pour que les fichiers dans `/S2MesDocuments` soit stocker sur le dossier personnel S2

```
-----Creation du dossier
jeanbourquj@MC0-0315-JJU:~$ sudo mkdir -p /mnt/hote/S2MesDocuments
---Création du point de montage
root@MC0-0315-JJU:/home/jeanbourquj# sudo mount -t cifs //s2msrvelell.s2.rpn.ch/Classes/jeanbourquj /mnt/hote/S2MesDocuments -o username=jeanbourquj,domain=s2,uid=1000,gid=1000

-----------Ajout d'une ligne dans config de C3

jeanbourquj@MC0-0315-JJU:~$ sudo cat /var/lib/lxc/C3/config
# Template used to create this container: /usr/share/lxc/templates/lxc-download
# Parameters passed to the template: -d ubuntu -r focal -a amd64
# For additional config options, please look at lxc.container.conf(5)
# Uncomment the following line to support nesting containers:
#lxc.include = /usr/share/lxc/config/nesting.conf
# (Be aware this has security implications)
# Distribution configuration
lxc.include = /usr/share/lxc/config/common.conf
# For Ubuntu 14.04
lxc.mount.entry = /sys/kernel/debug sys/kernel/debug none bind,optional 0 0
lxc.mount.entry = /sys/kernel/security sys/kernel/security none bind,optional 0 0
lxc.mount.entry = /sys/fs/pstore sys/fs/pstore none bind,optional 0 0
lxc.mount.entry = mqueue dev/mqueue mqueue rw,relatime,create=dir,optional 0 0
lxc.arch = linux64
# Container specific configuration
# Network configuration
lxc.net.0.type = veth
lxc.net.0.link = lxcbr0
lxc.net.0.flags = up
lxc.net.0.hwaddr = 00:16:3e:4b:ca:1f
lxc.net.0.name = eth0
lxc.rootfs.path = lvm:/dev/MC0-0315-JJU-VG/C3
lxc.uts.name = C3

# Network configuration
 lxc.net.1.type = veth
 lxc.net.1.link = virbr0
 lxc.net.1.flags = up
 lxc.net.1.name = eth1
 lxc.net.1.hwaddr = 00:16:3e:x:x:x


lxc.mount.entry = /mnt/hote/S2MesDocuments S2MesDocuments none rw,bind 0 0

------Vérification (après reboot)
ubuntu@C3:/S2MesDocuments$ ls
'~$RA.dotx'                                ICT340                           PHP                    Sagano-Bamboo-Forest-Arashiyama-Kyoto-Japan-photo-5.jpg
'$RECYCLE.BIN'                             Interesting                      piante-bamboo.jpg      SendMessage.sh
'~$Report.dotx'                           'Inventaire hardware.xlsx'        PPo                   'site pour eleves'
 ASP                                       Jeanbourquin-organigramme.vsdx   Pratique               SocieterNonCollectif.docx
'Charte Logo'                              Modele2emeInstance.dotx         'Pratique C#'           Softwares
'Comptabilité en partie double - 1.ac2'   'Modèle word'                    'Pratique multimédia'   test
 ConnexionADO                              Module                          'Pratique PPO'          TicTacToe-master
 desktop.ini                              'Module 153'                      pyCam.py               TPI
'Dossier Santé-20170421T120807Z-001.zip'  'My Music'                       'Quiz PO'              'Trucs ecg'
 DROIT                                    'My Pictures'                     RA.dotx                wacomcreativestylus.jpg
 Eco                                      'My Videos'                      'Rapport Module.docx'   wacom_logo_nb_c.png
 FAVORIS                                   Organigramme.vsdx                Report.dotx           'Winpe ch-fr.txt'

```

