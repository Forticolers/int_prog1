[Back to README](https://mylos.cifom.ch/gitlab/JeanbourquJ/int_prog1/-/tree/master)

### 1)

_Affiche la liste de personnes qui ont vécus ou vivent en couple._

```sql
WITH personnes_en_couple(uuid) AS (
select p.uuid
from personnes p
inner join couples cp1 ON p.uuid = cp1.partenaire1_personnes_uuid
union all
select p.uuid
from personnes p
inner join couples cp2 ON p.uuid = cp2.partenaire2_personnes_uuid
)
select * from personnes
where uuid in (select uuid from personnes_en_couple)
```

### 2)

_Afficher la liste des personnes qui n’ont jamais été en couple_

```sql
WITH personnes_pas_en_couple(uuid) AS (
select p.uuid
from personnes p
inner join couples cp1 ON p.uuid = cp1.partenaire1_personnes_uuid
union all
select p.uuid
from personnes p
inner join couples cp2 ON p.uuid = cp2.partenaire2_personnes_uuid
)
select * from personnes
where uuid NOT in (select uuid from personnes_en_couple)
```

### 3)

_Affiche la liste des enfants de ‘elsbeth’_

```sql
WITH couple_de_uuid (uuid) AS (
SELECT c.uuid FROM couples c
WHERE 
c.partenaire1_personnes_uuid = '00000000-0000-0000-0000-000000000014' OR
c.partenaire2_personnes_uuid = '00000000-0000-0000-0000-000000000014'
)
SELECT * FROM personnes p
where p.parents_couples_uuid in (select uuid from couple_de_uuid)

```

### 4)

_Affiche la liste des enfants de ‘jean’._

```sql
WITH couple_de_uuid (uuid) AS (
SELECT c.uuid FROM couples c
WHERE 
c.partenaire1_personnes_uuid = '00000000-0000-0000-0000-000000000013' OR
c.partenaire2_personnes_uuid = '00000000-0000-0000-0000-000000000013'
)
SELECT * FROM personnes p
where p.parents_couples_uuid in (select uuid from couple_de_uuid)
;

```

