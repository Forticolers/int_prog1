# Recette de cuisine (analyse)

## Description du besoin

Créer un modèle de données permettant de mémoriser des recettes de cuisine. Les sites de cuisines comme [Betty Bossi](https://www.bettybossi.ch/fr/Rezept/List) ou [marmiton](https://www.marmiton.org/recettes/) contiennent des exemples de recettes permettant de valider le modèle.

### Démarche

1. D’après les informations et les exemples fournis, listez les entités potentielles. 
1. D’après la liste des entités, identifiez les associations. 
1. Aux extrémités de chaque association, identifiez les cardinalités minimum et maximum. 
1. D’après le texte et les exemples, placez au mieux les propriétés dans les entités correspondantes.
1. Pour chaque entité, désignez l’identifiant métier qui distinguera chaque tuple des autres tuples.
1. Dessinez correctement le modèle conceptuel de données.
1. Lisez votre modèle et posez-vous des questions : 
   1. Est-ce vraiment la réalité des choses ? 
   1. Les dimensions des associations sont-elles adéquates ? 
   1. N’y-a-t’il plus de redondances ? 
   1. Chaque propriété est-elle atomique ? 
   1. Les identifiants métier sont-ils uniques ? 
   1. N’y-a-til aucune propriété calculée ? 
   1. Etc.
1. Valider le schéma avec les utilisateurs

### A Faire

* Faire le document d'analyse contenant 
    * le modèle conceptuel de données (MCD)
    * le modèle logique de données (MLD)
    * le modèle de classe
    * les maquettes d'écrans permettant la visualisation/ajout/modification des données
    * les exemples pertinents de données (min 3 par entité) 

## Maquette

### Recettes 

![diagramme de navigation](navigation-recette.svg)

#### Liste des recettes (Liste)

```
Liste des recettes
==================

[rechercher] : ________________________

[ajouter une recette]

+--------+-------------------+--------------------------
| action | nom               |  detail 
+--------+-------------------+--------------------------
| [voir] | Aubergines au four|Ces aubergines gratinées 
|        |                   |garnies de tomates, feta 
|        |                   |et mûres sont un régal pour l’œil 
|        |                   |et les papilles.
+--------+-------------------+--------------------------
| [voir] | Poires aux        |Une poire habillée de lanières 
|        | amandes en chemise|feuilletées et fourrée d’amandes. 
|        |                   |Difficile de résister!
+--------+-------------------+--------------------------
| [voir] | Poivrons au four  |Super pratique à faire au four: 
|        |et cuisses de      |poulet au paprika sur 
|        |poulet             |poivrons avec feta et noix de cajou.
+--------+-------------------+--------------------------
| [voir] | Sauce aux tomates |Sauce tomate - avec des herbes 
|        |                   |aromatiques
+--------+-------------------+--------------------------
```

####  Détail d'une recette (Détail\<\<visualisation>>)

```
Détail d'une recette
====================

[quitter] [modifier] [supprimer]

nom
---
Aubergines au four

détail 
-----------
Ces aubergines gratinées garnies 
de tomates, feta et mûres sont 
un régal pour l’œil et les papilles.

préparation
-----------
Préchauffer le four à 220°C. 

Partager les aubergines dans la longueur et, à l’aide d’un couteau, inciser 
en croisillons sur env. 2 cm de profondeur, disposer sur une plaque chemisée 
de papier cuisson. Arroser d’un filet d’huile, saler, poivrer.

Cuisson: env. 25 min au milieu du four. Retirer.

Râper le zeste du citron, presser 2 c.s. de jus, mélanger avec l’huile 
dans un grand bol, saler, poivrer. Couper les tomates en deux, émietter la feta,
effeuiller le thym, incorporer à la sauce avec les mûres, répartir sur les
aubergines.

ingrédients pour 4 personnes
----------------------------
Quan   Unité   Ingrédients        commentaire     Actions
------+-------+------------------+--------------+-------
4 	       aubergines         d'env. 250g  
4      c.s.    huile                           
0.75   c.c.    sel                             
                poivre             un peu       

1 	      citron bio                      
3      c.s.   huile                           
0.25   c.c.   sel                             
                poivre              un peu      
250    g      tomates cerises                 
200    g      feta                            
4      brins  thym                            
250    g      mûres                           

Médias
------
| vignette |  détail                     |  actoins
+----------+-----------------------------+--------------
| média    |  préparation des aubergines | [voir média]
| média    |  préparation de la farce    | [voir média]

```

####  Détail d'une recette (Détail\<\<suppresion>>)

```
Détail d'une recette
====================

[quitter] [valider suppression]

nom
---
Aubergines au four

détail 
-----------
Ces aubergines gratinées garnies 
de tomates, feta et mûres sont 
un régal pour l’œil et les papilles.

préparation
-----------
Préchauffer le four à 220°C. 

Partager les aubergines dans la longueur et, à l’aide d’un couteau, inciser 
en croisillons sur env. 2 cm de profondeur, disposer sur une plaque chemisée 
de papier cuisson. Arroser d’un filet d’huile, saler, poivrer.

Cuisson: env. 25 min au milieu du four. Retirer.

Râper le zeste du citron, presser 2 c.s. de jus, mélanger avec l’huile 
dans un grand bol, saler, poivrer. Couper les tomates en deux, émietter la feta,
effeuiller le thym, incorporer à la sauce avec les mûres, répartir sur les
aubergines.

ingrédients pour 4 personnes
----------------------------
Quan   Unité   Ingrédients        commentaire     Actions
------+-------+------------------+--------------+-------
4 	       aubergines         d'env. 250g  
4      c.s.    huile                           
0.75   c.c.    sel                             
                poivre             un peu       

1 	      citron bio                      
3      c.s.   huile                           
0.25   c.c.   sel                             
                poivre              un peu      
250    g      tomates cerises                 
200    g      feta                            
4      brins  thym                            
250    g      mûres                           

Médias
------
| vignette |  détail                     |  actoins
+----------+-----------------------------+--------------
| média    |  préparation des aubergines | [voir média]
| média    |  préparation de la farce    | [voir média]

```

####  Détail d'une recette (Détail\<\<Modification>>)

```
Détail d'une recette
====================

[quitter] [valider modification]

nom
---
Aubergines au four____

détail 
-----------
Ces aubergines gratinées garnies 
de tomates, feta et mûres sont 
un régal pour l’œil et les papilles.______

préparation
-----------
__Préchauffer le four à 220°C. 

Partager les aubergines dans la longueur et, à l’aide d’un couteau, inciser 
en croisillons sur env. 2 cm de profondeur, disposer sur une plaque chemisée 
de papier cuisson. Arroser d’un filet d’huile, saler, poivrer.

Cuisson: env. 25 min au milieu du four. Retirer.

Râper le zeste du citron, presser 2 c.s. de jus, mélanger avec l’huile 
dans un grand bol, saler, poivrer. Couper les tomates en deux, émietter la feta,
effeuiller le thym, incorporer à la sauce avec les mûres, répartir sur les
aubergines.________


ingrédients pour 4__ personnes
----------------------------
Quan   Unité   Ingrédients        commentaire     Actions
------+-------+------------------+--------------+-------
4____ 	       aubergines         d'env. 250g__  [voir ingrédient] [supprimer ingrédient]
4____  c.s._V  huile              _____________  [voir ingrédient] [supprimer ingrédient] 
0.75_  c.c._V  sel                _____________  [voir ingrédient] [supprimer ingrédient] 
_____  _____V  poivre             un peu_______  [voir ingrédient] [supprimer ingrédient] 

1____  _____V  citron bio         _____________  [voir ingrédient] [supprimer ingrédient] 
3____  c.s._V  huile              _____________  [voir ingrédient] [supprimer ingrédient] 
0.25_  c.c._V  sel                _____________  [voir ingrédient] [supprimer ingrédient] 
_____  _____V  poivre             un peu_______  [voir ingrédient] [supprimer ingrédient] 
250__  g____V  tomates cerises    _____________  [voir ingrédient] [supprimer ingrédient] 
200__  g____V  feta               _____________  [voir ingrédient] [supprimer ingrédient] 
4____  brinsV  thym               _____________  [voir ingrédient] [supprimer ingrédient] 
250__  g____V  mûres              _____________  [voir ingrédient] [supprimer ingrédient] 
______ _____V  _________________V _____________  [ajouter ingrédient]

Médias
------
| vignette |  détail                      | Action
+----------+------------------------------+-----
| média    | préparation des aubergines   | [voir média] [supprimer media]
| média    | préparation de la farce      | [voir média] [supprimer media] 
|          | ___________________________V | [ajouter média]

```

####  Détail d'une recette (Détail\<\<création>>)

```
Détail d'une recette
====================

[quitter] [valider création]

nom
---
_____

détail 
-----------
_____

préparation
-----------
_____


ingrédients pour 4__ personnes
----------------------------
Quan   Unité   Ingrédients        commentaire     Actions
------+-------+------------------+--------------+-------
______ _____V  _________________V _____________  [ajouter ingrédient]

Média
-----
| vignette |  détail                      | Action
+----------+------------------------------+-----
|          | ___________________________V | [ajouter média]
```
### Ingrédients 

![diagramme de navigation](navigation-ingrédient.svg)


#### Liste des ingrédients

```
Liste des ingérdients
=====================

[rechercher] : ________________________

[ajouter un ingrédient]

+--------+-------------------+--------------------------
| action | nom               |  detail 
+--------+-------------------+--------------------------
| [voir] | aubergine         |
| [voir] | sauce au tomates  | Sauce tomate - avec des herbes 
|        |                   | aromatiques
```

#### Détail d'un ingédient (Détail \<\<visualisation>>)

```
Détail d'un ingrédient
======================

[quitter] [modifier] [supprimer]

nom
---
sauce au tomates

détail 
-----------
Sauce au tomates - avec des herbes  aromatiques

Recette
-------
Sauce au tomates [voir recette]


Médias
------
| vignette |  détail                      | Action
+----------+------------------------------+-----
| média    | sauce tomate                 | [voir média]
| média    | gros plan sur le bocal       | [voir média]

```

#### Détail d'un ingédient (Détail \<\<suppression>>)

```
Détail d'un ingrédient
======================

[annuler] [valider suppression]

nom
---
sauce au tomates

détail 
-----------
Sauce au tomates - avec des herbes  aromatiques

Recette
-------
Sauce au tomates [voir recette]


Médias
------
| vignette |  détail                      | Action
+----------+------------------------------+-----
| média    | sauce tomate                 | [voir média]
| média    | gros plan sur le bocal       | [voir média]

```


#### Détail d'un ingrédient (Détail \<\<création>>)

```
Détail d'un ingrédient
======================

[annuler] [valider création]

nom
---
____

détail 
-----------
____

Recette
-------
___________V [voir recette]

Médias
------
| vignette |  détail                      | Action
+----------+------------------------------+-----
|          | ___________________________V | [ajouter média]
```

#### Détail d'un ingrédient (Détail \<\<modification>>)

```
Détail d'un ingrédient
======================

[annuler] [valider modification]

nom
---
sauce au tomates____

détail 
-----------
Sauce au tomates - avec des herbes  aromatiques____

Recette
-------
Sauce au tomates__V [voir recette]

Médias
------
| vignette |  détail                      | Action
+----------+------------------------------+-----
| média    | sauce tomate                 | [voir média] [supprimer media]
| média    | gros plan sur le bocal       | [voir média] [supprimer media]
|          | ___________________________V | [ajouter média]
```

### Unités

![diagramme de navigation](navigation-unite.svg)

#### Liste des unités

```
Liste des unités
================

[rechercher] : ________________________

[ajouter une unité]

+--------+-------------
| action | code        
+--------+-------------
| [voir] | c.c         
| [voir] | c.s
| [voir] | g           
```

#### Détail d'une unité (Détail \<\<visualisation>>)

```
Détail d'une unité
==================

[quitter] [modifier] [supprimer]

code
----
c.c
```

#### Détail d'une unité (Détail \<\<suppression>>)

```
Détail d'une unité
==================

[annuler] [valider suppression]

code
----
c.c
```


#### Détail d'une unité (Détail \<\<création>>)

```
Détail d'une unité
==================

[annuler] [valider création]

code
----
____

```

#### Détail d'une unité (Détail \<\<modification>>)

```
Détail d'une unité
==================

[annuler] [valider modification]

code
----
c.c____

```


## Références

1. [recette de la sauce tomate, Betty Bossi](https://www.bettybossi.ch/fr/Rezept/ShowRezept/BB_BBZJ041115_0024F-40-fr)
1. [recette des aubergines au four, Betty Bossi](https://www.bettybossi.ch/fr/Rezept/ShowRezept/BB_BBZH190915_0013A-40-fr)