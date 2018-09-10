

/***********************************************************************************************************************************/
/** 1 **/
/** Création d'un trigger qui affiche « un nouveau client est ajouté» après chaque insertion d’un client. 
Répétez la même chose pour la modification ou la suppression.**/

CREATE OR REPLACE TRIGGER INSERT_CLIENT 
AFTER INSERT ON CLIENT 
FOR EACH ROW
BEGIN
	dbms_output.put_line('un nouveau client est ajouté');
END;
/

/**
Trigger created.
**/

CREATE OR REPLACE TRIGGER UPDATE_CLIENT 
AFTER UPDATE ON CLIENT 
FOR EACH ROW
BEGIN
	dbms_output.put_line('Les informations d un client sont mises a jours');
END;
/

/**
Trigger created.
**/

CREATE OR REPLACE TRIGGER DELETE_CLIENT 
AFTER DELETE ON CLIENT 
FOR EACH ROW
BEGIN
	dbms_output.put_line('un client est supprimé');
END;
/

/**
Trigger created.
**/


/** tester les trigger **/
/** d'abord activer les affichages avec la commande : SET SERVEROUTPUT ON **/

SET SERVEROUTPUT ON

/** l'insertion **/
INSERT INTO CLIENT 
VALUES(40,'MME','Adjaout','feriel',to_date('21/01/1995', 'DD/MM/YYYY'),'cite 2110 logts bt 5 alger','0561381877','0565568716','');

/**
un nouveau client est ajouté

1 row created.
**/

/** la modification **/
UPDATE CLIENT 
SET PRENOMCLIENT = 'ADJAOUTE' 
WHERE NUMCLIENT = 40 ;

/**
Les informations d un client sont mises a jours

1 row updated.
**/

/** la suppression **/
DELETE FROM CLIENT 
WHERE NUMCLIENT = 40 ;

/**
un client est supprimé

1 row deleted.
**/

/***********************************************************************************************************************************/
/** 2 **/

/***********************************************************************************************************************************/
/** 3 **/
/**3. Création d'un trigger qui vérifie que lors de la modification du salaire d’un employé, 
la nouvelle valeur ne peut jamais être inférieure à la précédente.**/

/** Le before permet de remettre en cause la mise a jours contenu dans le trigger **/

/** pour cela l'on doit arreter la modification avant son exécution , donc utiliser le BEFORE 
puis l'on compare la nouvelle valeur du SALAIRE  que l'on souhaite mettre (NEW) avec l'ancienne existante (OLD)
et l'on génére une interruption (erreur) avec la fonction "raise_application_error" pour empecher la modification dans le cas ou
NEW < OLD**/

CREATE OR REPLACE TRIGGER UPDATE_SALAIRE
BEFORE UPDATE OF SALAIRE ON EMPLOYE 
FOR EACH ROW
BEGIN
	IF :NEW.SALAIRE < :OLD.SALAIRE
	THEN raise_application_error(-20001, 'Le nouveau salaire ne doit pas etre inférieure a l`ancien!') ;
	END IF;
END;
/ 

/**
Trigger created.
**/

/** tester la modification du salaire d'un employé **/
UPDATE EMPLOYE SET SALAIRE = SALAIRE - 100 WHERE NUMEMPLOYE = 53 ;

/**
ERROR at line 1:
ORA-20001: Le nouveau salaire ne doit pas etre inférieure a l`ancien!
ORA-06512: at "SYSTEM.UPDATE_SALAIRE", line 3
ORA-04088: error during execution of trigger 'SYSTEM.UPDATE_SALAIRE'
**/

/**  Le trigger a arreté le programme et invalidé la mise a jours, Il a ainsi protégé l'integrité de la base de données */

/***********************************************************************************************************************************/
/** 4 **/

CREATE OR REPLACE TRIGGER CHECK_PERIODE_INTER 
BEFORE INSERT OR UPDATE OF DATEDEBUT,DATEFIN ON INTERVENANT
FOR EACH ROW

DECLARE
INTER_ROW INTERVENTIONS%ROWTYPE;

BEGIN

IF(INSERTING) THEN
  SELECT * INTO INTER_ROW FROM INTERVENTIONS WHERE NUMINTERVENTION = :NEW.NUMINTERVENTION;
  IF((INTER_ROW.DATEDEBINTERV <= :NEW.DATEDEBUT) AND (INTER_ROW.DATEFININTERV >= :NEW.DATEFIN ))
	THEN
		DBMS_OUTPUT.PUT_LINE('PERIODE VALIDE POUR L EMPLOYE :'||:NEW.NUMEMPLOYE ||'  POUR L INTERVENTION :'|| INTER_ROW.NUMINTERVENTION);
	
	ELSE RAISE_APPLICATION_ERROR(-20002,'PERIODE INVALIDE POUR L EMPLOYE INTERVENANT :'||:NEW.NUMEMPLOYE ||'  POUR L INTERVENTION :'|| INTER_ROW.NUMINTERVENTION);
  END IF;
  
  ELSE
  
    SELECT * INTO INTER_ROW FROM INTERVENTIONS WHERE NUMINTERVENTION = :NEW.NUMINTERVENTION;
  IF((INTER_ROW.DATEDEBINTERV <= :NEW.DATEDEBUT) AND (INTER_ROW.DATEFININTERV >= :NEW.DATEFIN ))
	THEN
		DBMS_OUTPUT.PUT_LINE('PERIODE VALIDE POUR L EMPLOYE :'||:NEW.NUMEMPLOYE ||'  POUR L INTERVENTION :'|| INTER_ROW.NUMINTERVENTION);
	
	ELSE RAISE_APPLICATION_ERROR(-20002,'PERIODE INVALIDE POUR L EMPLOYE INTERVENANT :'||:NEW.NUMEMPLOYE ||'  POUR L INTERVENTION :'|| INTER_ROW.NUMINTERVENTION);
  END IF;
  
  
  END IF;

END;
/
/**
Trigger created.
**/

INSERT INTO INTERVENTIONS VALUES (59,8,'réparation systeme',to_date('2006-05-12 09:00:00','YYYY-MM-DD HH24:MI:SS' ),to_date('2006-05-12 12:00:00','YYYY-MM-DD HH24:MI:SS' ),17846);
INSERT INTO INTERVENANT VALUES (59,54,to_date('2006-05-12 09:00:00','YYYY-MM-DD HH24:MI:SS' ),to_date('2006-05-12 12:00:00','YYYY-MM-DD HH24:MI:SS' ));

/**

1 row created.

PERIODE VALIDE POUR L EMPLOYE :54  POUR L INTERVENTION :59

1 row created.
**/


INSERT INTO INTERVENTIONS VALUES (60,8,'réparation systeme',to_date('2006-05-11 09:00:00','YYYY-MM-DD HH24:MI:SS' ),to_date('2006-05-12 12:00:00','YYYY-MM-DD HH24:MI:SS' ),17846);
INSERT INTO INTERVENANT VALUES (60,54,to_date('2006-02-12 09:00:00','YYYY-MM-DD HH24:MI:SS' ),to_date('2006-05-12 12:00:00','YYYY-MM-DD HH24:MI:SS' ));

/**
1 row created.

ERROR at line 1:
ORA-20002: PERIODE INVALIDE POUR L EMPLOYE INTERVENANT :54  POUR L INTERVENTION
:60
ORA-06512: at "SYSTEM.CHECK_PERIODE_INTER", line 12
ORA-04088: error during execution of trigger 'SYSTEM.CHECK_PERIODE_INTER'

**/





/***********************************************************************************************************************************/
/** 5 **/

/**5. Afin que l’administrateur puisse connaitre le nombre total des interventions pour chaque employé. 
Pour cela, nous ajoutons l'attribut TOTAL_INTERVENTIONS dans la table employé.
Puis nous créons le trigger TOTAL_INTERVENTIONS_TRIGGER qui met à jour l’attribut TOTAL_ INTERVENTIONS.**/



ALTER TABLE EMPLOYE ADD (TOTAL_INTERVENTIONS INTEGER DEFAULT 0);

/**
Table altered.
**/

/** le trigger suivant incrémente la valeur de l'attribut TOTAL_INTERVENTIONS lorsqu'un employé participe a une nouvelle intervention,
c'est à dire lorsque un element (tuple) est inséré dans la table INTERVENANT **/

CREATE OR REPLACE TRIGGER TOTAL_INTERVENTIONS_TRIGGER
AFTER INSERT ON INTERVENANT
FOR EACH ROW
BEGIN
	UPDATE EMPLOYE E
	SET TOTAL_INTERVENTIONS = TOTAL_INTERVENTIONS + 1 
	WHERE E.NUMEMPLOYE = :NEW.NUMEMPLOYE ;
END;
/

/**
Trigger created.
**/


/** tester le trigger **/
/** affichage du nombre d'intervention avant l'insertion **/
SELECT TOTAL_INTERVENTIONS FROM EMPLOYE WHERE NUMEMPLOYE = 53;
/**
TOTAL_INTERVENTIONS
-------------------
                  0
**/

/** insertion dans la table INTERVENANT **/
INSERT INTO INTERVENANT VALUES (1,53,to_date('2017-01-27 08:00:00','YYYY-MM-DD HH24:MI:SS' ),to_date('2017-02-09 14:00:00','YYYY-MM-DD HH24:MI:SS' ));
/**
1 row created.
**/

/** affichage du nombre d'intervention après l'insertion **/
SELECT TOTAL_INTERVENTIONS FROM EMPLOYE WHERE NUMEMPLOYE = 53;
/**
TOTAL_INTERVENTIONS
-------------------
                  1
**/

/** effectivement après l'insertion le nombre totale d'intervention à été incrémenté **/




/***********************************************************************************************************************************/
/** 6 **/
















