/*
    Recettes - requêtes utilisées dans l'interface utilisateur
    
    Jeanbourquin Julien (jeanbourquj@rpn.ch)

*/

-- Ajout des champs d'audit dans les tables.
--- Table Recette

ALTER TABLE recettes 
ADD 
	ajUser TEXT DEFAULT NULL, 
	ajDate TIMESTAMP DEFAULT NULL, 
	moUser TEXT DEFAULT NULL, 
	moDate TIMESTAMP DEFAULT NULL 
;