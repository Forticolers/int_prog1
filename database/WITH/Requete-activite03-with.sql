WITH personne as
(SELECT prenom, parents_couples_uuid from personnes 
where parents_couples_uuid IS NOT null)
SELECT personne.prenom from personne
;

