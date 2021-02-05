[Back to README](https://mylos.cifom.ch/gitlab/JeanbourquJ/int_prog1/-/tree/master)
# int prog1 BDD

## Activité n° 1 
##### _BDD utilisée : [magasinDB](https://mylos.cifom.ch/gitlab/dhu.cours/intbasdb/activites/intbasdb.schema-magasin)_
---
### Recherche par correspondance de motif
---
#### 1) LIKE 
* Usage
	* \<chaîne> (NOT) LIKE \<motif> \[ESCAPE caractère d'échappement] 
 	* LIKE permet, s'il n'y a pas de signe pourcent (%) ou tiret bas (_), d'effectuer une recherche sur la chaîne elle-même. 
 	* le % correspond à un seul caractère alors que _ correspond à toutes les chaînes de zéro à plusieurs caractères.
* Particularité
	* Pour rechercher les caractère spéciaux (% et _), il faut utiliser un cractère d'échappement.
	* Par défaut celui-ci est \ (backslash) mais peut être spécifiée dans la clause ESCAPE du LIKE.

##### 1.1) Exemple

```
(Retourne une liste des articles commençant par PESE)
 SELECT nom FROM articles WHERE nom LIKE 'PESE%';
        nom
-------------------
 PESE-LETTRE1-500
 PESE-LETTRE1-1000
 PESE-LETTRE1-500
 PESE-LETTRE1-1000
(4 rows)
```

#### 2) SIMILAR TO
* Usage
	* \<chaîne> (NOT) SIMILAR TO \<motif> \[ESCAPE caractère d'échappement]
	* Assez similaire to LIKE sauf que SIMILAR TO interpète les motifs en utilisant les expression rationnelle SQL
	* Il utilise également les caractère spéciaux % et _ ainsi que :
		* | qui dénote une alternative (une des deux possibilité)
		* \* qui dénote la répétition d'éléments précédents (0 ou plusieurs fois)
		* \+ qui dénote la répétion d'éléments précédents (une ou plusieurs fois)
		* les parenthèses qui premettent de grouper des éléments en un seul élément logique
		* Les expression entre crochet \[...] qui délimite une classe de caractère. Comme les expressions régulière POSIX.

##### 2.1) Exemple

```
(Retourne une liste des articles contenant 2 F consecutif ou commençant par PESE)
SELECT nom FROM articles WHERE nom SIMILAR TO '(%FF%)|(PESE%)';
        nom
-------------------
 PESE-LETTRE1-500
 PESE-LETTRE1-1000
 PESE-LETTRE1-500
 PESE-LETTRE1-1000
 COFFRET SIMPLE
 COFFRET LUXE
(6 rows)
```


#### 3) Expression régulière POSIX
Note : Comme il y a une grande quantité d'"opérateur" je met le liens vers [la documentation postgres](https://docs.postgresql.fr/8.2/functions-matching.html#functions-posix-regexp).

* Usage
	* Opérateur
		- **~** Fais correspondre deux expession en tenant compte de la casse
		- **~*** Correspond deux expression, sans prendre compte de la casse
		- **!~** Non-correspondance en tenant compte de la casse
		- **!~*** Non-correspondance sans tenir compte de la casse
	* Atomes
		- les atomes sont ce qui composent les différentes branches d'une expression régulière.
		- Quantificateur
		- Contrainte
	* Échappements
	


##### 3.1) Exemple

```
SELECT ;
```


### Conslusion
Pour les correspondance relativement simple, l'usage du LIKE est largement suffisant. Puis SIMILAR TO offre la possibilité de faire correspondres plusieurs choses ensemble, mais garde une certaine limite.

POSIX permet de faire à peu près tout le reste.