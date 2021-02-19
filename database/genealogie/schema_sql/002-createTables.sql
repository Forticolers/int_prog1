/*
	Généalogie - Script de création de schéma
	
	Jeanbourquin Julien
	
*/

CREATE TABLE IF NOT EXISTS personnes (
	uuid TEXT NOT NULL,
	prenom TEXT NOT NULL,
	dateNaissance NOT NULL,
	
	CONSTRAINTS pk_personne
		PRIMARY KEY(uuid)
)
;