[Back to README](https://mylos.cifom.ch/gitlab/JeanbourquJ/int_prog1/-/tree/master)
# int_prog1
## Requêtes avec WITH

### Qu'est-ce que WITH

L'instruction `WITH` offre la possibilité de construire des requêtes impliquant des sous-requêtes. Ces sous-requêtes peuvent être, par récursivité, des résultats de la première itération de la requête.


### Usage

#### Simple

```
WITH R AS 
(SELECT 1 AS n) 
SELECT n + 1 FROM R
;
```

Cette requête appelé `R` va selectionner '1' et l'appelé `n` puis va appliquer une autre requête pour incrémenté `n` de 1 ce qui va retourner '2'

```
genealogieDB=> WITH R AS
genealogieDB-> (SELECT 1 AS n)
genealogieDB-> SELECT n + 1 FROM R
genealogieDB-> ;
 ?column?
----------
        2
(1 row)
```

#### Recursif 

```
WITH RECURSIVE countUp AS 
(SELECT 1 AS n 
UNION ALL 
SELECT n+1 FROM countUp WHERE n < 5)
SELECT * FROM countUp
;
```

Cette requête appelé `countUp` va séléctionné '1' et l'appelé `n` puis va unir une autre requête pour incrémenté `n` tant qu'il est inférieur à '5', va retourner une liste des nombre de 1 à 5

```
genealogieDB=> WITH RECURSIVE countUp AS
genealogieDB-> (SELECT 1 AS n
genealogieDB(> UNION ALL
genealogieDB(> SELECT n+1 FROM countUp WHERE n < 5)
genealogieDB-> SELECT * FROM countUp
genealogieDB-> ;
 n
---
 1
 2
 3
 4
 5
(5 rows)
```

## Bibliographie

[Recursion in SQL Explained Visually](https://medium.com/swlh/recursion-in-sql-explained-graphically-679f6a0f143b)

[Requêtes `WITH` (Common Table Expressions)](https://docs.postgresql.fr/10/queries-with.html)