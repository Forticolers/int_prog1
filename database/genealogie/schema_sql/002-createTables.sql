/*
	Généalogie - Script de création de schéma
	
	Jeanbourquin Julien
	
*/

CREATE TABLE IF NOT EXISTS personnes (
	uuid TEXT NOT NULL,
	prenom TEXT NOT NULL,
	dateNaissance DATE NOT NULL,
	couples_uuid TEXT,
	
	CONSTRAINT pk_personne
		PRIMARY KEY (uuid)
)
;

CREATE TABLE IF NOT EXISTS couple (
	uuid TEXT NOT NULL,
	partenaire1_personne_uuid TEXT,
	partenaire2_personne_uuid TEXT,
	dateDebut DATE NOT NULL,
	dateFin DATE,
	
	CONSTRAINT pk_couple
		PRIMARY KEY (uuid)
)
;

ALTER TABLE IF EXISTS PERSONNE
	DROP CONSTRAINT IF EXISTS fk1_couples_uuid,
	ADD CONSTRAINT fk1_couples_uuid
		FOREIGN KEY (couples_uuid)
		REFERENCES couple (uuid) ON DELETE CASCADE
;

ALTER TABLE IF EXISTS couple
	DROP CONSTRAINT IF EXISTS fk1_partenaire1,
	ADD CONSTRAINT fk1_partenaire1
		FOREIGN KEY (partenaire1_personne_uuid)
		REFERENCES personnes (uuid) ON DELETE CASCADE,
	DROP CONSTRAINT IF EXISTS fk1_partenaire2,
	ADD CONSTRAINT fk1_partenaire2
		FOREIGN KEY (partenaire2_personne_uuid)
		REFERENCES personnes (uuid) ON DELETE CASCADE
;