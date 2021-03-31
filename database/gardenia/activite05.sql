--Nombre d'evenements non-quittance SEVERE, INFO ou WARNING
DROP INDEX IF EXISTS IDX_etre_quittancee;

SELECT COUNT(*), e.level
FROM evenements e
WHERE NOT e.etre_quittance AND
e.level not in ('CONFIG')
GROUP BY e.level
;

EXPLAIN VERBOSE SELECT COUNT(*), e.level
FROM evenements e
WHERE NOT e.etre_quittance AND
e.level not in ('CONFIG')
GROUP BY e.level
;

EXPLAIN ANALYZE VERBOSE SELECT COUNT(*), e.level
FROM evenements e
WHERE NOT e.etre_quittance AND
e.level not in ('CONFIG')
GROUP BY e.level
;

CREATE INDEX IDX_etre_quittancee ON evenements (etre_quittance);

SELECT COUNT(*), e.level
FROM evenements e
WHERE NOT e.etre_quittance AND
e.level not in ('CONFIG')
GROUP BY e.level
;

EXPLAIN VERBOSE SELECT COUNT(*), e.level
FROM evenements e
WHERE NOT e.etre_quittance AND
e.level not in ('CONFIG')
GROUP BY e.level
;

EXPLAIN ANALYZE VERBOSE SELECT COUNT(*), e.level
FROM evenements e
WHERE NOT e.etre_quittance AND
e.level not in ('CONFIG')
GROUP BY e.level
;

-- Evenements non-quittance SEVERE entre 01-01-2020 00:00 et 02-02-2020 00:00

DROP INDEX IF EXISTS IDX_date_creation;

SELECT * FROM evenements e
WHERE NOT e.etre_quittance AND
e.level = 'SEVERE' AND
e.date_creation BETWEEN '2020-01-01 00:00' AND '2020-02-02 00:00'
;

EXPLAIN VERBOSE SELECT * FROM evenements e
WHERE NOT e.etre_quittance AND
e.level = 'SEVERE' AND
e.date_creation BETWEEN '2020-01-01 00:00' AND '2020-02-02 00:00'
;

EXPLAIN ANALYZE VERBOSE SELECT * FROM evenements e
WHERE NOT e.etre_quittance AND
e.level = 'SEVERE' AND
e.date_creation BETWEEN '2020-01-01 00:00' AND '2020-02-02 00:00'
;

CREATE INDEX IDX_date_creation ON evenements (date_creation);

SELECT * FROM evenements e
WHERE NOT e.etre_quittance AND
e.level = 'SEVERE' AND
e.date_creation BETWEEN '2020-01-01 00:00' AND '2020-02-02 00:00'
;

EXPLAIN VERBOSE SELECT * FROM evenements e
WHERE NOT e.etre_quittance AND
e.level = 'SEVERE' AND
e.date_creation BETWEEN '2020-01-01 00:00' AND '2020-02-02 00:00'
;

EXPLAIN ANALYZE VERBOSE SELECT * FROM evenements e
WHERE NOT e.etre_quittance AND
e.level = 'SEVERE' AND
e.date_creation BETWEEN '2020-01-01 00:00' AND '2020-02-02 00:00'
;

--Mesures de moins de 18 °C entre le 01-01-2020 00:00 et 02-02-2020 00:00
DROP INDEX IF EXISTS IDX_date;
DROP INDEX IF EXISTS IDX_mesures_value;

SELECT * FROM mesures m
WHERE m.valeur < 18 AND
m.date BETWEEN '2020-01-01 00:00' AND '2020-02-02 00:00'
;

EXPLAIN VERBOSE SELECT * FROM mesures m
WHERE m.valeur < 18 AND
m.date BETWEEN '2020-01-01 00:00' AND '2020-02-02 00:00'
;

EXPLAIN ANALYZE VERBOSE SELECT * FROM mesures m
WHERE m.valeur < 18 AND
m.date BETWEEN '2020-01-01 00:00' AND '2020-02-02 00:00'
;

CREATE INDEX IDX_date ON mesures (date);
CREATE INDEX IDX_mesures_value ON mesures (valeur);

SELECT * FROM mesures m
WHERE m.valeur < 18 AND
m.date BETWEEN '2020-01-01 00:00' AND '2020-02-02 00:00'
;

EXPLAIN VERBOSE SELECT * FROM mesures m
WHERE m.valeur < 18 AND
m.date BETWEEN '2020-01-01 00:00' AND '2020-02-02 00:00'
;

EXPLAIN ANALYZE VERBOSE SELECT * FROM mesures m
WHERE m.valeur < 18 AND
m.date BETWEEN '2020-01-01 00:00' AND '2020-02-02 00:00'
;