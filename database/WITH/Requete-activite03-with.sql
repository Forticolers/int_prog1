WITH personne as
(SELECT prenom, parents_couples_uuid from personnes 
where parents_couples_uuid IS NOT null)
SELECT personne.prenom from personne
;

WITH RECURSIVE personnes_en_couple(couples_uuid, personnes_uuid) AS (
        SELECT uuid, partenaire1_personnes_uuid personnes_uuid
            FROM couples
            WHERE partenaire1_personnes_uuid IS NOT NULL
        UNION 
        SELECT uuid, partenaire2_personnes_uuid personnes_uuid
            FROM couples
            WHERE partenaire2_personnes_uuid IS NOT NULL
),
enfants(parent_personnes_uuid, uuid, prenom, date_naissance) AS(
    SELECT parents.uuid, enfants.uuid, enfants.prenom, enfants.date_naissance
    FROM personnes enfants
        INNER JOIN personnes_en_couple couples ON couples.couples_uuid = enfants.parents_couples_uuid
        INNER JOIN personnes parents ON parents.uuid = couples.personnes_uuid
),
descendants(parent_personnes_uuid, uuid, prenom, date_naissance, niveau_parente, path) AS(
    SELECT parents.uuid, enfants.uuid, enfants.prenom, enfants.date_naissance,1,ARRAY[parents.prenom]
        FROM enfants
            INNER JOIN personnes parents ON parents.uuid = enfants.parent_personnes_uuid
        WHERE parents.prenom = 'elsbeth'
    UNION
    SELECT parents.uuid, enfants.uuid, enfants.prenom, enfants.date_naissance, descendants.niveau_parente+1, path || parents.prenom 
        FROM enfants
            INNER JOIN personnes parents ON parents.uuid = enfants.parent_personnes_uuid
            INNER JOIN descendants ON descendants.uuid = parents.uuid
)
SELECT descendants.*
FROM descendants
;

WITH personnes_en_couple(couples_uuid, personnes_uuid) AS (
	 SELECT uuid, partenaire1_personnes_uuid personnes_uuid
	    FROM couples
	    WHERE partenaire1_personnes_uuid IS NOT NULL
	 UNION 
	 SELECT uuid, partenaire2_personnes_uuid personnes_uuid
	    FROM couples
	    WHERE partenaire2_personnes_uuid IS NOT NULL
     ),    
     parents(enfants_uuid, uuid, prenom, date_naissance) AS(
     SELECT enfants.uuid, parents.uuid, parents.prenom, parents.date_naissance
        FROM personnes parents
        INNER JOIN personnes_en_couple couples ON couples.personnes_uuid = parents.uuid
        INNER JOIN personnes enfants ON enfants.parents_couples_uuid = couples.couples_uuid
     ),
     ancetres(enfants_uuid, uuid, prenom, date_naissance) AS(
     SELECT enfants.uuid, parents.uuid, parents.prenom, parents.date_naissance
        FROM parents
        INNER JOIN personnes enfants ON enfants.uuid = parents.enfants_uuid
        WHERE enfants.prenom = 'dominique'
     )
SELECT ancetres.*
FROM ancetres
;
s