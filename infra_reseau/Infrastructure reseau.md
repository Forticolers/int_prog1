```bash
-------+-----------+-------------+------------+-----------+-----------+----------+---------virbr1 192.168.200.0/24
       |           |             |            |           |           |          |         antiterre-network
       |           |             |            |           |           |          |         réseau avec nat
       |           |             |            |           |           |          |         sans DHCP
       |           |             |            |           |           |ip        |ip
     .1|           |.8           |.10         |.20        |.30        |dynamique |dynamique
     .-+--+-.    .-+----.      .-+--+-.     .-+----.    .-+----.    .-+----.   .-+----.
 NAT |      |    |      |DHCP  |      |NS   |      |AS  |      |FS  |      |   |      |
     | hôte |    | lxc  |PXE   | lxc  |     | lxc  |    | kvm  |    | kvm  |   | kvm  |
     |      |    |      |      |      |     |      |    |      |    |      |   |      |
     `--+---'    `------'      `------'     `------'    `------'    `------'   `------'
        |eth0     atomium   blossfeldtstad galatograd   urbicande     cavi       luna
        |         serveur       serveur      serveur     serveur     desktop    desktop
        |
 -------+----------------------------------------S2 157.26.229.0/24
```



```bash
Would you like to use LXD clustering? (yes/no) [default=no]: 
Do you want to configure a new storage pool? (yes/no) [default=yes]:  
Name of the new storage pool [default=default]: 
Name of the storage backend to use (btrfs, dir, lvm, zfs, ceph) [default=zfs]: 
Create a new ZFS pool? (yes/no) [default=yes]: no
Name of the existing ZFS pool or dataset: dpool/lxd
Would you like to connect to a MAAS server? (yes/no) [default=no]: 
Would you like to create a new local network bridge? (yes/no) [default=yes]: 
What should the new bridge be called? [default=lxdbr0]: 
What IPv4 address should be used? (CIDR subnet notation, “auto” or “none”) [default=auto]: 
What IPv6 address should be used? (CIDR subnet notation, “auto” or “none”) [default=auto]: none
Would you like the LXD server to be available over the network? (yes/no) [default=no]: yes
Address to bind LXD to (not including port) [default=all]: 
Port to bind LXD to [default=8443]: 
Trust password for new clients: 
Again: 
Would you like stale cached images to be updated automatically? (yes/no) [default=yes] 
Would you like a YAML "lxd init" preseed to be printed? (yes/no) [default=no]: yes
config:
  core.https_address: '[::]:8443'
  core.trust_password: A1234567890*
networks:
- config:
    ipv4.address: auto
    ipv6.address: none
  description: ""
  name: lxdbr0
  type: ""
storage_pools:
- config:
    source: dpool/lxd
  description: ""
  name: default
  driver: zfs
profiles:
- config: {}
  description: ""
  devices:
    eth0:
      name: eth0
      network: lxdbr0
      type: nic
    root:
      path: /
      pool: default
      type: disk
  name: default
cluster: null

```

```bash
jeanbourquj@MC0-0315-JJU:~/GIT_REPO/int_prog1$ lxc profile show antiterre
config: {}
description: Antiterre LXD profile
devices:
  eth0:
    nictype: bridged
    parent: virbr1
    type: nic
  root:
    path: /
    pool: default
    type: disk
name: antiterre
used_by: []

```

