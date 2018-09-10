SET SERVEROUTPUT ON

/** 1 **/
DECLARE 
cursor cr is SELECT marque , COUNT(*) AS nbr FROM MARQUE MA, MODELE MO WHERE MA.NUMMARQUE = MO.NUMMARQUE GROUP BY MA.MARQUE ;
c cr%rowtype;
vide exception;

BEGIN
for c in cr LOOP
	dbms_output.put_line('La marque : '|| c.marque || ' posséde ' || c.nbr || ' modeles .' );
	exit when cr%notfound;
END LOOP; 

EXCEPTION WHEN vide THEN
	dbms_output.put_line('Aucune marque n est trouvé ! ');

END;
/

/**
La marque : maserati posséde 1 modeles .
La marque : cadilac posséde 1 modeles .
La marque : lotus posséde 1 modeles .
La marque : peugeot posséde 2 modeles .
La marque : saab posséde 1 modeles .
La marque : lamborghini posséde 1 modeles .
La marque : mercedes posséde 2 modeles .
La marque : rolls-royce posséde 1 modeles .
La marque : ferrari posséde 2 modeles .
La marque : porsche posséde 2 modeles .
La marque : chrysler posséde 1 modeles .
La marque : audi posséde 2 modeles .
La marque : renault posséde 1 modeles .
La marque : venturi posséde 2 modeles .
La marque : volvo posséde 1 modeles .
La marque : bmw posséde 1 modeles .
La marque : alfa-romeo posséde 2 modeles .
La marque : toyota posséde 1 modeles .
La marque : jaguar posséde 1 modeles .
La marque : lexus posséde 1 modeles .

PL/SQL procedure successfully completed.
**/

/** 2 **/

/** a **/
/* ajout de la contrainte de salaire */

ALTER TABLE EMPLOYE ADD CONSTRAINT LIMIT_SALAIRE CHECK(SALAIRE >= 10000 AND SALAIRE <= 30000)


/**
Table altered.
**/

/* désactiver la contrainte */

ALTER TABLE EMPLOYE DISABLE CONSTRAINT LIMIT_SALAIRE;

/**
Table altered.
**/

/* procedure d'ajout des salaires */
CREATE OR REPLACE PROCEDURE Augmentation_salaire
AS

cursor cr is select NUMEMPLOYE,NOMEMP,PRENOMEMP,CATEGORIE,SALAIRE FROM EMPLOYE ;
s INTEGER ;
c cr%rowtype ;
vide exception ;

BEGIN

for c in cr LOOP
	if (c.CATEGORIE = 'MECANICIEN')
	then
		s:= c.SALAIRE * 1.50;
	else
		s:= c.SALAIRE * 1.30;
	end if;
	
	dbms_output.put_line('L employe : ' || c.NOMEMP || ' ' || c.PRENOMEMP || ' de catégorie : ' || c.CATEGORIE || ' passe d un salaire de: ' || c.SALAIRE || ' à ' || s || '.');
	UPDATE EMPLOYE E SET SALAIRE = s WHERE E.NUMEMPLOYE = c.NUMEMPLOYE ;
	
	exit when cr%notfound;
	
END LOOP;

EXCEPTION WHEN vide THEN
	dbms_output.put_line('Aucun employé n est trouvé ! ');


END;
/

/**
Procedure created.
**/

show errors procedure Augmentation_salaire

/**
No errors.
**/

EXECUTE Augmentation_salaire;

/**
L employe : bouzid lachemi de catégorie : MECANICIEN passe d un salaire de: 25000 à 37500.
L employe : elias bouchemla de catégorie : ASSISTANT passe d un salaire de: 10000 à 13000.
L employe : zouhir hadj de catégorie : ASSISTANT passe d un salaire de: 12000 à 15600.
L employe : hakim oussedik de catégorie : MECANICIEN passe d un salaire de: 20000 à 30000.
L employe : abdelhamid abad de catégorie : ASSISTANT passe d un salaire de: 13000 à 16900.
L employe : tayeb babaci de catégorie : MECANICIEN passe d un salaire de: 21300 à 31950.
L employe : mourad belhamidi de catégorie : MECANICIEN passe d un salaire de: 19500 à 29250.
L employe : redouane igoudjil de catégorie : ASSISTANT passe d un salaire de: 15000 à 19500.
L employe : bahim koula de catégorie : MECANICIEN passe d un salaire de: 23100 à 34650.
L employe : ahcene rahali de catégorie : MECANICIEN passe d un salaire de: 24000 à 36000.
L employe : ismail chaoui de catégorie : ASSISTANT passe d un salaire de: 13000 à 16900.
L employe : hatem badi de catégorie : ASSISTANT passe d un salaire de: 14000 à 18200.
L employe : mustapha mohammedi de catégorie : MECANICIEN passe d un salaire de: 24000 à 36000.
L employe : abdelaziz fekar de catégorie : ASSISTANT passe d un salaire de: 13500 à 17550.
L employe : wahid saidouni de catégorie : MECANICIEN passe d un salaire de: 25000 à 37500.
L employe : farid boularas de catégorie : ASSISTANT passe d un salaire de: 14000 à 18200.
L employe : nassim chaker de catégorie : MECANICIEN passe d un salaire de: 26000 à 39000.
L employe : yacine terki de catégorie : MECANICIEN passe d un salaire de: 23000 à 34500.
L employe : ahmed tebibel de catégorie : ASSISTANT passe d un salaire de: 17000 à 22100.
L employe : karim lardjoune de catégorie :  passe d un salaire de: 25000 à 32500.

PL/SQL procedure successfully completed.
**/


/** 3 **/ 
CREATE OR REPLACE PROCEDURE Verification(AN VEHICULE.ANNEE%type)
AS
cursor cr is select V.ANNEE,V.NUMVEHICULE,DATEDEBINTERV,DATEFININTERV 
FROM INTERVENTIONS I,VEHICULE V 
WHERE I.NUMVEHICULE = V.NUMVEHICULE AND V.ANNEE =AN;

c cr%rowtype;
vide exception;

BEGIN

for c in cr LOOP
	if(c.DATEDEBINTERV < c.DATEFININTERV)
	then
		dbms_output.put_line('vérification positive !');
	else
		dbms_output.put_line('vérification négative !');
	end if;
	
	exit when cr%notfound;

END LOOP;

EXCEPTION WHEN vide THEN
	dbms_output.put_line('Aucun vehicule trouvé !!');

END;
/

/**
Procedure created.
**/

EXECUTE Verification('1998');

/**
vérification positive !
vérification négative !

PL/SQL procedure successfully completed.
**/

/*vérification que la procedure fonctionne correctement */

select V.ANNEE,V.NUMVEHICULE,DATEDEBINTERV,DATEFININTERV 
FROM INTERVENTIONS I,VEHICULE V 
WHERE I.NUMVEHICULE = V.NUMVEHICULE AND V.ANNEE ='1998';

/**

ANNE NUMVEHICULE DATEDEBI DATEFINI
---- ----------- -------- --------
1998          25 06/04/06 09/04/06
1998          22 04/03/06 22/02/06
**/


/** 4 **/

CREATE OR REPLACE FUNCTION Nombre_interv(num in EMPLOYE.NUMEMPLOYE%type )
return number
IS 

cursor cr is SELECT I.NUMEMPLOYE, E.NOMEMP , E.PRENOMEMP, COUNT(*) AS NBR
FROM INTERVENANT I, EMPLOYE E 
WHERE E.NUMEMPLOYE = num
AND I.NUMEMPLOYE = E.NUMEMPLOYE
GROUP BY I.NUMEMPLOYE, E.NOMEMP , E.PRENOMEMP;

c cr%rowtype;
vide exception;
i binary_integer;

BEGIN

for c in cr LOOP
	dbms_output.put_line('L emplyé : '|| c.NOMEMP || ' ' || c.PRENOMEMP || ' a fait ' || c.NBR || ' inteventions. ');
	
	return(c.NBR);
END LOOP;

END;
/

/**
Function created.
**/



SELECT Nombre_interv(55) from dual;

/**
NOMBRE_INTERV(55)
-----------------
                2

L emplyé : zouhir hadj a fait 2 inteventions.
**/

SELECT Nombre_interv(60) from dual;

/**
NOMBRE_INTERV(60)
-----------------
                3

L emplyé : redouane igoudjil a fait 3 inteventions.
**/

SELECT Nombre_interv(59) from dual;

/**
NOMBRE_INTERV(59)
-----------------
                4

L emplyé : mourad belhamidi a fait 4 inteventions.
**/

SELECT Nombre_interv(67) from dual;

/**
NOMBRE_INTERV(67)
-----------------
                1

L emplyé : wahid saidouni a fait 1 inteventions.
**/



/** 5 **/
/**
Créer une procédure qui permet d’ajouter une intervention à partir de tous les attributs nécessaires.
 N’oublier pas de vérifier l’unicité de la clé et l’existence de clé étrangère vers véhicule. 
 
 Affichez les messages d’erreurs en cas de problèmes.
**/

CREATE OR REPLACE PROCEDURE Ajout_interv(num INTERVENTIONS.NUMINTERVENTION%type,numv INTERVENTIONS.NUMVEHICULE%type , t INTERVENTIONS.TYPEINTERVENTION%type ,dd INTERVENTIONS.DATEDEBINTERV%type , df INTERVENTIONS.DATEFININTERV%type ,cout INTERVENTIONS.COUTINTERV%type )
AS
cursor cr1 is SELECT NUMINTERVENTION,COUNT(*) AS N1 FROM INTERVENTIONS WHERE NUMINTERVENTION = num GROUP BY NUMINTERVENTION;
cursor cr2 is SELECT NUMVEHICULE,COUNT(*) AS N2 FROM VEHICULE  WHERE NUMVEHICULE = numv GROUP BY NUMVEHICULE;

c1 cr1%rowtype;
c2 cr2%rowtype;

i binary_integer;
j binary_integer;

vide1 exception;
vide2 exception;

BEGIN
i := 0;
j := 0;

for c1 in cr1 LOOP
	i := i+1;
END LOOP;

if(i = 0)
then
	
	for c2 in cr2 LOOP
		j := j+1;
	END LOOP;
	
	if(j > 0)
	then
		INSERT INTO INTERVENTIONS (NUMINTERVENTION ,NUMVEHICULE ,TYPEINTERVENTION ,DATEDEBINTERV ,DATEFININTERV ,COUTINTERV ) VALUES (num , numv , t , dd , df , cout);
		dbms_output.put_line('Intervention ajouté ! ');
	else
		dbms_output.put_line('ERREUR : violation de la clé étrangère, le numéro du véhicule saisie n existe pas dans la table VEHICULE ! ');
	end if;
	
else
	close cr1;
	dbms_output.put_line('ERREUR : violation de la clé primaire, une intervention de meme numéro existe déja ! ');
end if;

END;
/

/**
Procedure created.
**/
/*clé primaire non unique*/
EXECUTE Ajout_interv(13,8,'réparation systeme',to_date('2006-05-12 14:00:00','YYYY-MM-DD HH24:MI:SS' ),to_date('2006-05-12 18:00:00','YYYY-MM-DD HH24:MI:SS' ),17846);

/**
ERREUR : violation de la clé primaire, une intervention de meme numéro existe déja !

PL/SQL procedure successfully completed.
**/

/*clé étrangère non existante*/
EXECUTE Ajout_interv(20,52,'réparation systeme',to_date('2006-05-12 14:00:00','YYYY-MM-DD HH24:MI:SS' ),to_date('2006-05-12 18:00:00','YYYY-MM-DD HH24:MI:SS' ),17846);

/**
ERREUR : violation de la clé étrangère, le numéro du véhicule saisie n existe
pas dans la table VEHICULE !

PL/SQL procedure successfully completed.
**/

/* ajout réussit */
EXECUTE Ajout_interv(25,8,'réparation systeme',to_date('2006-05-12 14:00:00','YYYY-MM-DD HH24:MI:SS' ),to_date('2006-05-12 18:00:00','YYYY-MM-DD HH24:MI:SS' ),200000);

/**
Intervention ajouté !

PL/SQL procedure successfully completed.
**/

/*vérification*/
SELECT * FROM interventions WHERE NUMINTERVENTION = 25;

/**
NUMINTERVENTION NUMVEHICULE TYPEINTERVENTION             DATEDEBI	DATEFINI COUTINTERV
--------------- ----------- ---------------------------- ---------- -------- ----------
             25           8 réparation systeme           12/05/06	12/05/06     200000
**/










