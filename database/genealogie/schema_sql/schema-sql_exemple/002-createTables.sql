/*
    Recettes - Script de création du schéma
    
    dominique huguenin (dominique.huguenin AT rpn.ch)

    La base de données recetteDB doit contenir l'extension "uuid-ossp" 
    pour la génération des uuid avec la fonction uuid_generate_v4().

    CREATE EXTENSION "uuid-ossp";

    select uuid_generate_v4();
*/
-- Création de tables
CREATE TABLE IF NOT EXISTS unites (
    uuid UUID, -- aid
    code TEXT NOT NULL,

    CONSTRAINT pk_unites
        PRIMARY KEY (uuid)
)
;

CREATE TABLE IF NOT EXISTS recettes (
    uuid UUID, -- aid
    nom TEXT NOT NULL,
    detail TEXT,
    preparation TEXT,    
    nombre_personnes INTEGER DEFAULT 4,    

    CONSTRAINT pk_recettes
        PRIMARY KEY (uuid)
)
;

CREATE TABLE IF NOT EXISTS ingredients (
    uuid UUID, -- aid
    nom TEXT NOT NULL,
    detail TEXT,
    recettes_uuid UUID, -- aid

    CONSTRAINT pk_ingredients
        PRIMARY KEY (uuid)
)
;

CREATE TABLE IF NOT EXISTS composants (
    recettes_uuid UUID NOT NULL, -- aid
    numero INTEGER NOT NULL, --aid
    ordre INTEGER NOT NULL,
    quantite NUMERIC(8,2),
    commentaire TEXT,
    ingredients_uuid UUID NOT NULL, -- aid
    unites_uuid UUID, -- aid

    CONSTRAINT pk_composants
        PRIMARY KEY (recettes_uuid,numero)
)
;

CREATE TABLE IF NOT EXISTS medias (
    uuid UUID, -- aid
    nom TEXT NOT NULL,
    detail TEXT,
    type TEXT,
    data bytea,

    CONSTRAINT pk_medias
        PRIMARY KEY (uuid)
)
;

CREATE TABLE IF NOT EXISTS medias_ingredients (
    medias_uuid UUID NOT NULL, -- aid
    ingredients_uuid UUID NOT NULL, -- aid

    CONSTRAINT pk_medias_ingredients
        PRIMARY KEY (medias_uuid, ingredients_uuid)
)
;

CREATE TABLE IF NOT EXISTS medias_recettes (
    medias_uuid UUID NOT NULL, -- aid
    recettes_uuid UUID NOT NULL, -- aid

    CONSTRAINT pk_medias_recettes
        PRIMARY KEY (medias_uuid, recettes_uuid)
)
;

ALTER TABLE IF EXISTS unites
    DROP CONSTRAINT IF EXISTS nid1_unites_fcode,
    ADD CONSTRAINT nid1_unites_fcode
            UNIQUE (code)
;

ALTER TABLE IF EXISTS recettes
    DROP CONSTRAINT IF EXISTS u1_recettes_nom,
    ADD CONSTRAINT u1_recettes_nom
            UNIQUE (nom)
;

ALTER TABLE IF EXISTS ingredients
    DROP CONSTRAINT IF EXISTS fk1_ingredients_recettes,
    ADD CONSTRAINT fk1_ingredients_recettes
            FOREIGN KEY (recettes_uuid)
            REFERENCES recettes (uuid),
    DROP CONSTRAINT IF EXISTS u1_ingredients_nom,
    ADD CONSTRAINT u1_ingredients_nom
            UNIQUE (nom),
    DROP CONSTRAINT IF EXISTS u2_ingredients_recettes_uuid,
    ADD CONSTRAINT u2_ingredients_recettes_uuid
            UNIQUE (recettes_uuid)
;

ALTER TABLE IF EXISTS composants
    DROP CONSTRAINT IF EXISTS fk1_composants_recettes,
    ADD CONSTRAINT fk1_composants_recettes
            FOREIGN KEY (recettes_uuid)
            REFERENCES recettes (uuid) ON DELETE CASCADE,
    DROP CONSTRAINT IF EXISTS fk2_composants_ingredients,
    ADD CONSTRAINT fk2_composants_ingredients
            FOREIGN KEY (ingredients_uuid)
            REFERENCES ingredients (uuid),
    DROP CONSTRAINT IF EXISTS fk3_composants_unites,
    ADD CONSTRAINT fk3_composants_unites
            FOREIGN KEY (unites_uuid)
            REFERENCES unites (uuid),
    DROP CONSTRAINT IF EXISTS u1_composants_ordre,
    ADD CONSTRAINT u1_composants_ordre
            UNIQUE (recettes_uuid,ordre)
;

ALTER TABLE IF EXISTS medias
    DROP CONSTRAINT IF EXISTS u1_medias_nom,
    ADD CONSTRAINT u1_medias_nom
            UNIQUE (nom)
;

ALTER TABLE IF EXISTS medias_ingredients
    DROP CONSTRAINT IF EXISTS fk1_medias_ingredients_medias,
    ADD CONSTRAINT fk1_medias_ingredients_medias
            FOREIGN KEY (medias_uuid)
            REFERENCES medias (uuid) ON DELETE CASCADE,
    DROP CONSTRAINT IF EXISTS fk1_medias_ingredients_ingredients,
    ADD CONSTRAINT fk1_medias_ingredients_ingredients
            FOREIGN KEY (ingredients_uuid)
            REFERENCES ingredients (uuid) ON DELETE CASCADE
;

ALTER TABLE IF EXISTS medias_recettes
    DROP CONSTRAINT IF EXISTS fk1_medias_recettes_medias,
    ADD CONSTRAINT fk1_medias_recettes_medias
            FOREIGN KEY (medias_uuid)
            REFERENCES medias (uuid) ON DELETE CASCADE,
    DROP CONSTRAINT IF EXISTS fk1_medias_recettes_recettes,
    ADD CONSTRAINT fk1_medias_recettes_recettes
            FOREIGN KEY (recettes_uuid)
            REFERENCES recettes (uuid) ON DELETE CASCADE
;
