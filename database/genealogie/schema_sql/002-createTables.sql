/*
	Généalogie - Script de création de schéma
	
	Jeanbourquin Julien
	
*/

CREATE TABLE IF NOT EXISTS personnes (
	uuid TEXT NOT NULL,
	prenom TEXT NOT NULL,
	dateNaissance DATE NOT NULL,
	couples_uuid TEXT,
	
	CONSTRAINTS pk_personne
		PRIMARY KEY(uuid)
)
;

CREATE TABLE IF NOT EXISTS couples (
	uuid TEXT NOT NULL,
	partenaire1_personne_uuid TEXT,
	partenaire2_personne_uuid TEXT,
	dateDebut DATE NOT NULL,
	dateFin DATE,
	
	CONSTRAINTS pk_couple
		PRIMARY KEY(uuid)
)
;

ALTER TABLE IF EXISTS PERSONNE
	DROP CONSTRAINTS IF EXISTS fk1_couples_uuid(couples_uuid),
	ADD CONSTRAINTS fk1_couples_uuid
		FOREIGN KEY(couples_uuid)
		REFERENCES couples (uuid) ON DELETE CASCADE
;

ALTER TABLE IF EXISTS couples
	DROP CONSTANT IF EXISTS fk1_partenaire1(partenaire1_personne_uuid),
	ADD CONSTANT fk1_partenaire1(partenaire1_personne_uuid),
		FOREIGN KEY (partenaire1_personne_uuid)
		REFERENCES personnes (uuid) ON DELETE CASCADE,
	DROP CONSTANT IF EXISTS fk1_partenaire2(partenaire2_personne_uuid),
	ADD CONSTANT fk1_partenaire2(partenaire2_personne_uuid),
		FOREIGN KEY (partenaire2_personne_uuid)
		REFERENCES personnes (uuid) ON DELETE CASCADE
;