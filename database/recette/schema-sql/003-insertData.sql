/*
    Recettes - Script d'insertion des données de demonstration
    
    dominique huguenin (dominique.huguenin AT rpn.ch)

    La base de données recetteDB doit contenir l'extension "uuid-ossp" 
    pour la génération des uuid avec la fonction uuid_generate_v4().

    CREATE EXTENSION "uuid-ossp";

    select uuid_generate_v4();
*/

INSERT INTO unites (uuid, code)
VALUES (uuid_generate_v4(),'c.s'),
       (uuid_generate_v4(),'c.c'),
       (uuid_generate_v4(),'g'),
       (uuid_generate_v4(),'brins')
;

INSERT INTO recettes (uuid, nom, detail, preparation, nombre_personnes)
VALUES(uuid_generate_v4(),'Aubergines au four',
 'Ces aubergines gratinées garnies de tomates, feta et mûres sont un régal pour l’oeil et les papilles',
 'Préchauffer le four à 220°C. 

  Partager les aubergines dans la longueur et, à l’aide d’un couteau, inciser 
  en croisillons sur env. 2 cm de profondeur, disposer sur une plaque chemisée 
  de papier cuisson. Arroser d’un filet d’huile, saler, poivrer.

  Cuisson: env. 25 min au milieu du four. Retirer.

  Râper le zeste du citron, presser 2 c.s. de jus, mélanger avec l’huile 
  dans un grand bol, saler, poivrer. Couper les tomates en deux, émietter la feta,
  effeuiller le thym, incorporer à la sauce avec les mûres, répartir sur les
  aubergines.',
  4)
;  

INSERT INTO recettes (uuid, nom, detail, preparation, nombre_personnes)
VALUES(uuid_generate_v4(),'Poires aux amandes en chemise', 
  'Une poire habillée de lanières feuilletées et fourrée d’amandes. Difficile de résister!',
  null,
  4)
;

INSERT INTO recettes (uuid, nom, detail, preparation, nombre_personnes)
VALUES(uuid_generate_v4(),'Poivrons au four et cuisses de poulet', 
  'Super pratique à faire au four: poulet au paprika sur poivrons avec feta et noix de cajou.',
  null,
  4)
;

INSERT INTO recettes (uuid, nom, detail, preparation, nombre_personnes)
VALUES(uuid_generate_v4(),'Sauce aux tomates', 
  'Sauce tomate - avec des herbes aromatiques',
  null,
  4)
;

INSERT INTO ingredients ( uuid, nom, detail, recettes_uuid)
VALUES (uuid_generate_v4(),'aubergine', null,null),
       (uuid_generate_v4(),'huile',null,null),
       (uuid_generate_v4(),'sel',null,null),
       (uuid_generate_v4(),'poivre',null,null),
       (uuid_generate_v4(),'citron bio',null,null),
       (uuid_generate_v4(),'tomate cerise',null,null),
       (uuid_generate_v4(),'feta',null,null),
       (uuid_generate_v4(),'thym',null,null),
       (uuid_generate_v4(),'mûre',null,null)
;       

INSERT INTO ingredients ( uuid, nom, detail, recettes_uuid)
SELECT uuid_generate_v4(),'sauce au tomates', 'Sauce tomate - avec des herbes aromatique', uuid
FROM recettes
WHERE nom ='Sauce aux tomates'
;

INSERT INTO composants (recettes_uuid, numero, ordre, quantite, commentaire, 
                        ingredients_uuid, unites_uuid)
SELECT (SELECT r.uuid recettes_uuid
        FROM recettes r
        WHERE r.nom = 'Aubergines au four'),
        1 numero,
        1,
        4,
        'd''env. 250g',
        (SELECT i.uuid ingredients_uuid
        FROM ingredients i
        WHERE i.nom = 'aubergine'),
        NULL
;
INSERT INTO composants (recettes_uuid, numero, ordre, quantite, commentaire, 
                        ingredients_uuid, unites_uuid)
SELECT (SELECT r.uuid recettes_uuid
        FROM recettes r
        WHERE r.nom = 'Aubergines au four'),
        2 numero,
        2,
        4,
        NULL,
        (SELECT i.uuid ingredients_uuid
        FROM ingredients i
        WHERE i.nom = 'huile'),
        (SELECT u.uuid unites_uuid
        FROM unites u
        WHERE u.code = 'c.s')
;

INSERT INTO composants (recettes_uuid, numero, ordre, quantite, commentaire, 
                        ingredients_uuid, unites_uuid)
SELECT (SELECT r.uuid recettes_uuid
        FROM recettes r
        WHERE r.nom = 'Aubergines au four'),
        3 numero,
        3,
        0.75,
        NULL,
        (SELECT i.uuid ingredients_uuid
        FROM ingredients i
        WHERE i.nom = 'sel'),
        (SELECT u.uuid unites_uuid
        FROM unites u
        WHERE u.code = 'c.c')
;

INSERT INTO composants (recettes_uuid, numero, ordre, quantite, commentaire, 
                        ingredients_uuid, unites_uuid)
SELECT (SELECT r.uuid recettes_uuid
        FROM recettes r
        WHERE r.nom = 'Aubergines au four'),
        4 numero,
        4,
        NULL,
        'un peu',
        (SELECT i.uuid ingredients_uuid
        FROM ingredients i
        WHERE i.nom = 'poivre'),
        NULL
;

INSERT INTO composants (recettes_uuid, numero, ordre, quantite, commentaire, 
                        ingredients_uuid, unites_uuid)
SELECT (SELECT r.uuid recettes_uuid
        FROM recettes r
        WHERE r.nom = 'Aubergines au four'),
        5 numero,
        5,
        1,
        NULL,
        (SELECT i.uuid ingredients_uuid
        FROM ingredients i
        WHERE i.nom = 'citron bio'),
        NULL
;

INSERT INTO composants (recettes_uuid, numero, ordre, quantite, commentaire, 
                        ingredients_uuid, unites_uuid)
SELECT (SELECT r.uuid recettes_uuid
        FROM recettes r
        WHERE r.nom = 'Aubergines au four'),
        6 numero,
        6,
        3,
        NULL,
        (SELECT i.uuid ingredients_uuid
        FROM ingredients i
        WHERE i.nom = 'huile'),
        (SELECT u.uuid unites_uuid
        FROM unites u
        WHERE u.code = 'c.s')
;

INSERT INTO composants (recettes_uuid, numero, ordre, quantite, commentaire, 
                        ingredients_uuid, unites_uuid)
SELECT (SELECT r.uuid recettes_uuid
        FROM recettes r
        WHERE r.nom = 'Aubergines au four'),
        7 numero,
        7,
        0.25,
        NULL,
        (SELECT i.uuid ingredients_uuid
        FROM ingredients i
        WHERE i.nom = 'sel'),
        (SELECT u.uuid unites_uuid
        FROM unites u
        WHERE u.code = 'c.c')
;

INSERT INTO composants (recettes_uuid, numero, ordre, quantite, commentaire, 
                        ingredients_uuid, unites_uuid)
SELECT (SELECT r.uuid recettes_uuid
        FROM recettes r
        WHERE r.nom = 'Aubergines au four'),
        8 numero,
        8,
        NULL,
        'un peu',
        (SELECT i.uuid ingredients_uuid
        FROM ingredients i
        WHERE i.nom = 'poivre'),
        NULL
;

INSERT INTO composants (recettes_uuid, numero, ordre, quantite, commentaire, 
                        ingredients_uuid, unites_uuid)
SELECT (SELECT r.uuid recettes_uuid
        FROM recettes r
        WHERE r.nom = 'Aubergines au four'),
        9 numero,
        9,
        250.0,
        NULL,
        (SELECT i.uuid ingredients_uuid
        FROM ingredients i
        WHERE i.nom = 'tomate cerise'),
        (SELECT u.uuid unites_uuid
        FROM unites u
        WHERE u.code = 'g')
;

INSERT INTO composants (recettes_uuid, numero, ordre, quantite, commentaire, 
                        ingredients_uuid, unites_uuid)
SELECT (SELECT r.uuid recettes_uuid
        FROM recettes r
        WHERE r.nom = 'Aubergines au four'),
        10 numero,
        10,
        200,
        NULL,
        (SELECT i.uuid ingredients_uuid
        FROM ingredients i
        WHERE i.nom = 'feta'),
        (SELECT u.uuid unites_uuid
        FROM unites u
        WHERE u.code = 'g')
;

INSERT INTO composants (recettes_uuid, numero, ordre, quantite, commentaire, 
                        ingredients_uuid, unites_uuid)
SELECT (SELECT r.uuid recettes_uuid
        FROM recettes r
        WHERE r.nom = 'Aubergines au four'),
        11 numero,
        11,
        4,
        NULL,
        (SELECT i.uuid ingredients_uuid
        FROM ingredients i
        WHERE i.nom = 'thym'),
        (SELECT u.uuid unites_uuid
        FROM unites u
        WHERE u.code = 'brin')
;

INSERT INTO composants (recettes_uuid, numero, ordre, quantite, commentaire, 
                        ingredients_uuid, unites_uuid)
SELECT (SELECT r.uuid recettes_uuid
        FROM recettes r
        WHERE r.nom = 'Aubergines au four'),
        12 numero,
        12,
        250,
        NULL,
        (SELECT i.uuid ingredients_uuid
        FROM ingredients i
        WHERE i.nom = 'mûre'),
        (SELECT u.uuid unites_uuid
        FROM unites u
        WHERE u.code = 'g')
;

\lo_import './aubergines.jpg' 'aubergines'
\set OID :LASTOID
INSERT INTO medias (uuid, nom, detail, type, data)
SELECT  uuid_generate_v4(),
          'aubergine',
          NULL,
          'image/jpeg', 
          lo_get(:OID)::bytea
;

INSERT INTO medias_ingredients(medias_uuid, ingredients_uuid)
SELECT  (SELECT m.uuid
           FROM medias m
           WHERE m.nom = 'aubergine'),
          (SELECT i.uuid
           FROM ingredients i
           WHERE i.nom = 'aubergine')
;

SELECT lo_unlink(:OID)
;

\lo_import './aubergines_au_four.jpg' 'Aubergines au four'
\set OID :LASTOID
INSERT INTO medias (uuid, nom, detail, type, data)
SELECT uuid_generate_v4(),
       'Aubergines au four',
       NULL,
       'image/jpeg', 
       lo_get(:OID)::bytea
;

SELECT lo_unlink(:OID)
;

INSERT INTO medias_recettes(medias_uuid, recettes_uuid)
SELECT  (SELECT m.uuid
           FROM medias m
           WHERE m.nom = 'Aubergines au four'),
          (SELECT r.uuid
           FROM recettes r
           WHERE r.nom = 'Aubergines au four')
;

\lo_import './sauce_tomate.jpg' 'Sauce aux tomates'
\set OID :LASTOID

INSERT INTO medias (uuid, nom, detail, type, data)
SELECT uuid_generate_v4(),
        'Sauce aux tomates',
        NULL,
        'image/jpeg', 
        lo_get(:OID)::bytea
;

SELECT lo_unlink(:OID)
;

INSERT INTO medias_recettes(medias_uuid, recettes_uuid)
SELECT  (SELECT m.uuid
           FROM medias m
           WHERE m.nom = 'Sauce aux tomates'),
          (SELECT r.uuid
           FROM recettes r
           WHERE r.nom = 'Sauce aux tomates')
;

INSERT INTO medias_ingredients(medias_uuid, ingredients_uuid)
SELECT  (SELECT m.uuid
           FROM medias m
           WHERE m.nom = 'Sauce aux tomates'),
          (SELECT i.uuid
           FROM ingredients i
           WHERE i.nom = 'sauce au tomates')
;



