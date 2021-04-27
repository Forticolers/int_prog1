/*
    recettes - Script de suppression du schéma
    
    dominique huguenin (dominique.huguenin AT rpn.ch)
*/

DROP TABLE IF EXISTS medias_ingredients CASCADE
;

DROP TABLE IF EXISTS medias_recettes CASCADE
;

DROP TABLE IF EXISTS medias CASCADE
;

DROP TABLE IF EXISTS composants CASCADE
;

DROP TABLE IF EXISTS ingredients CASCADE
;

DROP TABLE IF EXISTS recettes CASCADE
;

DROP TABLE IF EXISTS unites CASCADE
;
