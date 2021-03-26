DROP INDEX IDX_etre_quittancee;

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