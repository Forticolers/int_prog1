INSERT INTO personnes(uuid, prenom, dateNaissance, couples_uuid)
VALUES	('0001', 'Jean', TO_DATE('1912/01/01', 'YYYY/MM/DD'), null),
		('0002', 'Susane', TO_DATE('1912/01/01','YYYY/MM/DD'), null),
		('0003' ,'Waler' ,TO_DATE('1902/01/01', 'YYYY/MM/DD'), null),
		('0004', 'Susanne', TO_DATE('1902/01/01', 'YYYY/MM/DD'), null)
;

INSERT INTO couples(uuid, partenaire1_personne_uuid, partenaire2_personne_uuid, dateDebut, dateFin)
VALUE	('100001' ,'0001' ,'0002' ,TO_DATE('1936/01/01','YYYY/MM/DD') , null),
		('100002' ,'0003' ,'0004' ,TO_DATE('1932/01/01','YYYY/MM/DD') , null)
;

INSERT INTO personnes(uuid, prenom, dateNaissance, couples_uuid)
VALUES	('0011', 'Josette', TO_DATE('1948/01/01', 'YYYY/MM/DD'), '100001'),
		('0012', 'Pierre-André', TO_DATE('1936', 'YYYY/MM/DD'), '100001'),
		('0013', 'Jean', TO_DATE('1936/01/01', 'YYYY/MM/DD'), '100001'),
		
		('0014', 'Elisabeth', TO_DATE('1942/01/01', 'YYYY/MM/DD'), '100002'),
		('0015', 'Walter', TO_DATE('1934/01/01', 'YYYY/MM/DD'), '100002'),
		('0016', 'Margrit', TO_DATE('1932/01/01', 'YYYY/MM/DD'), '100002')
;

INSERT INTO couples(uuid, partenaire1_personne_uuid, partenaire2_personne_uuid, dateDebut, dateFin)
VALUE	('100011' ,'0011' ,null ,TO_DATE('1970/01/01','YYYY/MM/DD'), null),
		('100012' ,'0013' ,'0014' ,TO_DATE('1964/01/01','YYYY/MM/DD') , null)
;

INSERT INTO personnes(uuid, prenom, dateNaissance, couples_uuid)
VALUES	('0101', 'Isabelle', TO_DATE('1975/01/01', 'YYYY/MM/DD'), null),
		('0102', 'Patrice', TO_DATE('1970/01/01', 'YYYY/MM/DD'), '100011'),
		('0103', 'Ilona', TO_DATE('1972/01/01', 'YYYY/MM/DD'), null)
		('0104', 'Dominique', TO_DATE('1965/01/01', 'YYYY/MM/DD'), '100012'),
		('0105', 'Laurent', TO_DATE('1969/01/01', 'YYYY/MM/DD'), '100012'),
		('0106', 'Christiane', TO_DATE('1974/01/01', 'YYYY/MM/DD'), null)
;

INSERT INTO couples(uuid, partenaire1_personne_uuid, partenaire2_personne_uuid, dateDebut, dateFin)
VALUE	('100101' ,'0101' ,'0102' ,TO_DATE('1997/01/01','YYYY/MM/DD') , TO_DATE('2010/01/01','YYYY/MM/DD')),
		('100102' ,'0103' ,'0104' ,TO_DATE('1997/01/01','YYYY/MM/DD') , null),
		('100103' ,'0105' ,'0106' ,TO_DATE('2002/01/01','YYYY/MM/DD') , TO_DATE('2012/01/01','YYYY/MM/DD'))
;

INSERT INTO personnes(uuid, prenom, dateNaissance, couples_uuid)
VALUES	('1001', 'Alexis', TO_DATE('1999/01/01', 'YYYY/MM/DD'), '100101'),
		('1002', 'Mahelle', TO_DATE('2002/01/01', 'YYYY/MM/DD'), '100101'),
		('1003', 'Jagoda', TO_DATE('2002/01/01', 'YYYY/MM/DD'), '100102'),
		('1004', 'Witek', TO_DATE('2005/01/01', 'YYYY/MM/DD'), '100102'),
		('1005', 'Noémie', TO_DATE('2011/01/01', 'YYYY/MM/DD'), '100103')
;
