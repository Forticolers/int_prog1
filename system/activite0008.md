### 1.

Créer l’utilisateur `gest` manuellement en modifiant les fichiers

_Fais ensemble [ref : Gestion des utilisateurs et des groupes](https://mylos.cifom.ch/cours/int-sys1-nix/mise-en-route-systeme-exploitation/user-group/)_

### 2.

Connectez-vous au système.

Afficher l’ UID, et les GID’s de l’utilisateur courant.

```bash
jeanbourquj@MC0-0315-JJU:~$ id
uid=1000(jeanbourquj) gid=1000(jeanbourquj) groupes=1000(jeanbourquj),4(adm),24(cdrom),27(sudo),30(dip),46(plugdev),108(lxd),113(lpadmin),114(sambashare)

```

### 3.

Créer les comptes pour `Jeannette` et `Lucien` avec les commandes `adduser` ou `useradd`

1. Vérifier que ces comptes soient fonctionnels.

2. Vérifier les groupes auxquels appartiennent `Jeannette` et `Lucien`.

   ```bash
   jeanbourquj@MC0-0315-JJU:~$ sudo -s
   ##################################################### Ajout jeannette
   root@MC0-0315-JJU:/home/jeanbourquj# useradd -m jeannette
   root@MC0-0315-JJU:/home/jeanbourquj# passwd jeannette
   Nouveau mot de passe : #jeannette
   Retapez le nouveau mot de passe : #jeannette 
   passwd : le mot de passe a été mis à jour avec succès
   ##################################################### Ajout lucien
   root@MC0-0315-JJU:/home/jeanbourquj# useradd -m lucien
   root@MC0-0315-JJU:/home/jeanbourquj# passwd lucien
   Nouveau mot de passe : #lucien
   Retapez le nouveau mot de passe : #lucien
   passwd : le mot de passe a été mis à jour avec succès
   ##################################################### Vérification
   root@MC0-0315-JJU:/home/jeanbourquj# id lucien
   uid=1012(lucien) gid=1012(lucien) groupes=1012(lucien)
   root@MC0-0315-JJU:/home/jeanbourquj# id jeannette
   uid=1011(jeannette) gid=1011(jeannette) groupes=1011(jeannette)
   ```

   

### 4.

1. Ajouter les groupes `stock`, `comptabilite`, `eleves` au système.
2. Effectuer les assignations suivante pour l’utilisateur`lucien`et vérifier pour chaque situation:
   1. `users`, `stock`, `comptabilite`
   2. `stock`
   3. `users`, `stock`
   4. `users`, `comptabilite`
   5. `users`, `comptabilite`, `eleves`

Remarques. Le premier groupe de chaque situation est le groupe initial de lucien

```bash

```



### 5.

> Rétablir la situation de l’exercice précèdent et connectez-vous en `lucien` au système. Lucien appartient aux groupes `users`, `comptabilite`

1. Créez un fichier `testgroupe` dans votre répertoire personnel.
2. Vérifier les propriétés du fichier `testgroupe`.
3. Changer l’appartenance du fichier `testgroupe` au groupe `comptabilite`. Constatations ?
4. Changer l’appartenance du fichier `testgroupe` au groupe `eleves`. Constatations ?

### 6.

Créer les utilisateurs jack et joe et réaliser cette arborescence

```
/-home  
  +-jack  
  | `-projet  
  |   `-main_jack.cpp  
  `-joe 
     `-projet      
       `-main_joe.cpp  
```

- Joe et Jack désirent partager leur répertoire projet respectif et les fichiers qu’il contient uniquement entre eux. (tout autre utilisateurs du système ne pourra pas y accéder)

  - Indiquer les demandes à faire à l’administrateur et les commandes qu’il doit taper.

  - Indiquer les commandes que doit taper Joe.

  - Indiquer les commandes que doit taper Jack.

    ```
    créer les utilsateur joe et jack
    créer l'arborescence
    créer un groupe en commun
    appliquer le groupe au dossier en communs
    appliquer le groupe aux utilisateur joe et jack
    ```

    

### 7.

Écrire un script permettant de créer ou de supprimer 100 comptes utilisateurs.

1. Vérifier le fonctionnement.
   - il est possible de s’identifier avec un utilisateur
2. Vérifier la syntax avec shellcheck