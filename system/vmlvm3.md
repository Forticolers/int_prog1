#### Historique de commandes pour la création de la vm vmLvm3 (pour la création d'une doc plus tard)

SI nécessaire, consulter la commande `history` sur la machine Ubuntu pour les cours system

```
1868  resize2fs /dev/MC0-0315-JJU-VG/vm3
 1869  sudo resize2fs /dev/MC0-0315-JJU-VG/vm3
 1870  sudo vgs
 1871  sudo lvs
 1872  fdisk
 1873  fdisk -l
 1874  sudo fdisk -l
 1875  sudo vgdisplay -v
 1876  sudo fdisk -l
 1877  sudo ext2online /dev/MC0-0315-JJU-VG/vm3
 1878  sudo ext2online /dev/MC0-0315-JJU-VG
 1879  df -h
 1880  virsh start vm3
 1881  virsh console vm3
 1882  sudo vgdisplay
 1883  virsh dumpxml vmLvm1
 1884  sudo lvdisplay
 1885  cd ..
 1886  mkdir poolDir
 1887  ls
 1888  cp poolDir pool
 1889  cp -r poolDir pool
 1890  ls
 1891  rmdir poolDir/
 1892  virsh pool-define-as poolDir --type dir --target /home/jeanbourquj/virtualisation/pool
 1893  virsh pool-dumpxml poolTmp
 1894  virsh pool-dumpxml vmLvm1
 1895  virsh pool-dumpxml poolDir
 1896  virsh pool-define-as poolLvm logigal --source-dev /dev/MC0-0315-JJU-VG/ --source-format lvm2
 1897  virsh pool-define-as poolLvm logical --source-dev /dev/MC0-0315-JJU-VG/ --source-format lvm2
 1898  virsh pool-dumpxml poolDir
 1899  virsh pool-dumpxml poolLvm
 1900  virsh vol-create-as poolLvm vmLvm3 4G --format raw
 1901  virsh pool
 1902  virsh
 1903  virsh pool-dumpxml poolLvm
 1904  virsh pool-dumpxml poolDir
 1905  ls /dev/poolLvm
 1906  ls /dev | grep lv
 1907  virsh pool-edit poolLvm
 1908  virsh pool-start poolLvm
 1909  virsh pool-undefine poolLvm
 1910  virsh pool-list --all
 1911  virsh pool-define-as poolLvm logical --source-dev /dev/MC0-0315-JJU-VG/ --source-format lvm2 --target /home/jeanbourquj/virtualisation/pool/
 1912  virsh pool-start poolLvm
 1913  virsh pool-list --all
 1914  virsh pool-dumpxml poolLvm
 1915  virsh vol-create poolLvm vmLvm3 4G --format raw
 1916  virsh vol-create-as poolLvm vmLvm3 4G --format raw
 1917  virsh
 1918  tree
 1919  virsh pool-undefine poolDir
 1920  virsh pool-destroy pooldDir
 1921  virsh pool-destroy poolDir
 1922  virsh pool-undefine poolDir
 1923  virsh pool-undefine poolLvm
 1924  virsh pool-list --all
 1925  virsh list --all
 1926  ls /var/lib/libvirt/images/
 1927  sudo ls /var/lib/libvirt/images/
 1928  virsh pool-define-as poolDir --type dir --target /home/jeanbourquj/virtualisation/pool/
 1929  virsh pool-define-as poolLvm logical --source-dev /dev/MC0-0315-JJU-VG/vmLvm3 --source-format lvm2
 1930  virsh vol-create-as poolLvm vmLvm3 4G --format raw
 1931  virsh pool-start poolLvm
 1932  virsh pool-undefine poolLvm
 1933  virsh pool-define-as poolLvm logical --source-dev /dev/MC0-0315-JJU-VG/ --source-format lvm2
 1934  virsh pool-list --all
 1935  virsh pool-edit poolDir
 1936  virsh pool-start poolDir
 1937  virsh pool-start poolLvm
 1938  virsh pool-list --all
 1939  virsh pool-autostart poolDir
 1940  virsh pool-list --all
 1941  virsh pool-define-as poolLvmTest logical --target /dev/MC0-0315-JJU-VG/ --source-format lvm2
 1942  virsh vol-create-as poolLvm vmLvm3 4G --format raw
 1943  sudo lvdisplay
 1944  virsh vol-list poolLvm
 1945  virsh vol-list default
 1946  virsh vol-download --pool default vmLvm1.img ./virtdisk/vmLvm1.img
 1947  virsh vol-upload vmLvm3 ./vmLvm1.img --pool poolLvm
 1948  virsh vol-upload vmLvm3 ./virtdisk/vmLvm1.img --pool poolLvm
 1949  sudo vgdisplay
 1950  virsh vol-create-as poolLvm vmLvm3 4G --format raw
 1951  sudo lvdisplay
 1952  virsh vol-create-as poolLvm vmLvm3 4G --format raw
 1953  virsh pool-list
 1954  /dev/MC0-0315-JJU-VG/vmLvm3
 1955  ls /dev/MC0-0315-JJU-VG/
 1956  virsh vol-create-as poolLvm vmLvm3 4G --format raw
 1957  virsh vol-upload vmLvm3 ./virtdisk/vmLvm1.img --pool poolLvm
 1958  virsh vol-create-as poolLvm vmLvm3 5G --format raw
 1959  virsh vol-upload vmLvm3 ./virtdisk/vmLvm1.img --pool poolLvm
 1960  tree --help
 1961  ll virtdisk/
 1962  virsh -c qemu:///system dumpxml vmLvm1 > ./vms/vmLvm3.xml
 1963  vim ./vm/vmLvm3.xml
 1964  vim vm/vmLvm3.xml
 1965  tree
 1966  vim ./vms/vmLvm3.xml
 1967  virsh -c qemu:///system define ./vms/vmLvm3.xml
 1968  virsh start vmLvm3
 1969  virsh console vmLvm3

```

