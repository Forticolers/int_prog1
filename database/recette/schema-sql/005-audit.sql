/*
    Recettes - requêtes utilisées dans l'interface utilisateur
    
    Jeanbourquin Julien (jeanbourquj@rpn.ch)

*/

-- Ajout des champs d'audit dans les tables.
--- Table Recette
CREATE OR REPLACE FUNCTION recette_audit_trigger_function()
RETURNS TRIGGER AS $trigger_recette_func$
BEGIN

	NEW.moDate = now();
	NEW.moUser = current_user;
	RETURN NEW;
	
END;
$trigger_recette_func$ language 'plpgsql';



ALTER TABLE recettes 

	ADD COLUMN	ajUser TEXT DEFAULT current_user,
	ADD COLUMN	ajDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	ADD COLUMN	moUser TEXT DEFAULT NULL, 
	ADD COLUMN	moDate TIMESTAMP DEFAULT NULL 

;

CREATE OR REPLACE FUNCTION recette_restrict_audit_column_function()
RETURNS TRIGGER AS $restric_func$
BEGIN
	if UPDATE (ajDate, ajUser, moDate, moUser) then
		RAISE EXCEPTION 'You can not modify those columns {ajDate, ajUser, moDate, moUser}';
	end if;
END;

$restric_func$ language 'plpgsql';
--REVOKE UPDATE (ajDate, ajUser, moDate, moUser) 
--ON recettes FROM recette;


--ALTER TABLE recettes ALTER COLUMN ajDate SET DEFAULT now();

--CREATE TRIGGER recettes_trigger_restrict_recettes
--BEFORE UPDATE ON recettes
--FOR EACH ROW EXECUTE FUNCTION recette_restrict_audit_column_function();

CREATE TRIGGER recettes_trigger_recettes
BEFORE INSERT OR UPDATE ON recettes
FOR EACH ROW EXECUTE FUNCTION recette_audit_trigger_function();

ALTER TABLE composants 

	ADD COLUMN	ajUser TEXT DEFAULT current_user, 
	ADD COLUMN	ajDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	ADD COLUMN	moUser TEXT DEFAULT NULL, 
	ADD COLUMN	moDate TIMESTAMP DEFAULT NULL 
;

--REVOKE UPDATE (ajDate, ajUser, moDate, moUser) 
--ON composants FROM recette;
--ALTER TABLE composants ALTER COLUMN ajDate SET DEFAULT now();

--CREATE TRIGGER recettes_trigger_restrict_composants
--BEFORE UPDATE ON composants
--FOR EACH ROW EXECUTE FUNCTION recette_restrict_audit_column_function();

CREATE TRIGGER recettes_trigger_composants
BEFORE INSERT OR UPDATE ON composants
FOR EACH ROW EXECUTE FUNCTION recette_audit_trigger_function();


ALTER TABLE medias 

	ADD COLUMN	ajUser TEXT DEFAULT current_user, 
	ADD COLUMN	ajDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	ADD COLUMN	moUser TEXT DEFAULT NULL, 
	ADD COLUMN	moDate TIMESTAMP DEFAULT NULL 
;

--REVOKE UPDATE (ajDate, ajUser, moDate, moUser) 
--ON medias FROM recette;
--ALTER TABLE medias ALTER COLUMN ajDate SET DEFAULT now();

--CREATE TRIGGER recettes_trigger_restrict_medias
--BEFORE UPDATE ON medias
--FOR EACH ROW EXECUTE FUNCTION recette_restrict_audit_column_function();

CREATE TRIGGER recettes_trigger_medias
BEFORE INSERT OR UPDATE ON medias
FOR EACH ROW EXECUTE FUNCTION recette_audit_trigger_function();