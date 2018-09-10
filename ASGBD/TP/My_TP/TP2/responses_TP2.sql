 
 /** 1 **/
 
	CREATE USER Admin IDENTIFIED BY Admin ;
		
SQL> CREATE USER Admin IDENTIFIED BY Admin ;

User created.

 /** important **/
 
	Alter user Admin quota unlimited on INTERVENTION_TBS;
	Alter user Admin quota unlimited on SYSTEM;
 
 SQL> Alter user Admin quota unlimited on INTERVENTION_TBS;

User altered.

 /** 2 **/
 
	connect Admin/Admin
 
SQL> connect Admin/Admin
ERROR:
ORA-01045: user ADMIN lacks CREATE SESSION privilege; logon denied


 /** 3 **/
 
	GRANT CREATE SESSION TO Admin;
	connect Admin/Admin;
	
SQL>    GRANT CREATE SESSION TO Admin;

Grant succeeded.

SQL>    connect Admin/Admin;
Connected.

/** 4 **/

	connect DBAINTERVENTION/DBAINTERVENTION;
	GRANT CREATE USER TO Admin;
	GRANT CREATE TABLE TO Admin;

SQL> GRANT CREATE USER TO Admin;

Grant succeeded.

SQL> GRANT CREATE TABLE TO Admin;

Grant succeeded.

/*vérification*/

	connect Admin/Admin;
	
	CREATE TABLE My_TABLE(
	my_num INTEGER PRIMARY KEY,
	my_name VARCHAR2(30)
	);
	
	CREATE USER USER0 IDENTIFIED BY USER0;
	
SQL>    connect Admin/Admin;
Connected.

SQL>    CREATE TABLE My_TABLE(	
		my_num INTEGER PRIMARY KEY,	
		my_name VARCHAR2(30)	
		);

Table created.
	
SQL>    CREATE USER USER1 IDENTIFIED BY USER1;

User created.
	
	
/** 5 **/

	Select * from DBAINTERVENTION.EMPLOYE ;
	
	SQL> Select * from DBAINTERVENTION.EMPLOYE
Select * from DBAINTERVENTION.EMPLOYE
                              *
ERROR at line 1:
ORA-00942: table or view does not exist

/* l'utilisateur Admin n'a pas pu effectuer la lecture sur la table EMPLOYE 
car il n'a que les droits de création de table et pas de lecture
d'ailleur oracle n'avou meme pas l'existance des tables */

/** 6 **/

	connect DBAINTERVENTION/DBAINTERVENTION;
	GRANT SELECT ON EMPLOYE TO Admin;
	
	connect Admin/Admin;
	Select * from DBAINTERVENTION.EMPLOYE ;
	
	
	SQL>    connect DBAINTERVENTION/DBAINTERVENTION;
Connected.
SQL>    GRANT SELECT ON EMPLOYE TO Admin;

Grant succeeded.

SQL>
SQL>    connect Admin/Admin;
Connected.
SQL>    Select * from DBAINTERVENTION.EMPLOYE ;

NUMEMPLOYE  PRENOMEMP        NOMEMP    CATEGORIE    SALAIRE
-----------------------------------------------------------
        53    lachemi        bouzid   MECANICIEN      25000

        54  bouchemla         elias    ASSISTANT      10000

        55       hadj        zouhir    ASSISTANT      12000

        56   oussedik         hakim   MECANICIEN      20000

        57       abad    abdelhamid    ASSISTANT      13000

        58     babaci         tayeb   MECANICIEN      21300

        59  belhamidi        mourad   MECANICIEN      19500

        60   igoudjil      redouane    ASSISTANT      15000

        61      koula         bahim   MECANICIEN      23100

        62     rahali        ahcene   MECANICIEN      24000

        63     chaoui        ismail    ASSISTANT      13000

        64       badi         hatem    ASSISTANT      14000

        65  mohammedi      mustapha   MECANICIEN      24000

        66      fekar     abdelaziz    ASSISTANT      13500

        67   saidouni         wahid   MECANICIEN      25000

        68   boularas         farid    ASSISTANT      14000

        69     chaker        nassim   MECANICIEN      26000

        71      terki        yacine   MECANICIEN      23000

        72    tebibel         ahmed    ASSISTANT      17000

        80  lardjoune         karim                   25000


20 rows selected.

/** 7 **/

/** 7. Le centre de gestion des interventions augmente les salaires 
des employés dont le nombre total des interventions est supérieur à 5.
 Que faut-il faire ? Que remarquez-vous ? **/
 
 /* il faut d'abord comptabiliser le nombre de d'interventions de chaque employé apartenant a la table 
 INTERVENANT puis comparer la valeur avec 5 dans le cas ou le nbr d'intervention est supperieur a 5 alors 
 on passe a la recherche de l'emplye en question dans la table EMPLOYE puis d'ajouter la somme au salaire */
 
	UPDATE DBAINTERVENTION.EMPLOYE E 
	SET E.SALAIRE = E.SALAIRE + 1000 
	WHERE E.NUMEMPLOYE IN 
		(SELECT I.NUMEMPLOYE 
		FROM DBAINTERVENTION.INTERVENANT I 
		WHERE (SELECT COUNT(NUMINTERVENTION) 
			   FROM DBAINTERVENTION.INTERVENANT II
			   WHERE I.NUMEMPLOYE = II.NUMEMPLOYE
			   GROUP BY NUMEMPLOYE 
			   )>5
		);
		
		
		SQL>    UPDATE DBAINTERVENTION.EMPLOYE E
        SET E.SALAIRE = E.SALAIRE + 1000
        WHERE E.NUMEMPLOYE IN
                (SELECT I.NUMEMPLOYE
                FROM DBAINTERVENTION.INTERVENANT I
                WHERE (SELECT COUNT(NUMINTERVENTION)
                           FROM DBAINTERVENTION.INTERVENANT II
                           WHERE I.NUMEMPLOYE = II.NUMEMPLOYE
                           GROUP BY NUMEMPLOYE
                           )>5
                );
        UPDATE DBAINTERVENTION.EMPLOYE E
                               *
ERROR at line 1:
ORA-00942: table or view does not exist

/* l'utilisateur n'a ni les droits de modification (mise a jours) sur la table EMPLOYE
 ni les droits de lecture sur la table INTERVENANT 
 d'ailleur oracle n'avou meme pas l'existance des tables */


/** 8 **/
	
	connect DBAINTERVENTION/DBAINTERVENTION;
	
	GRANT UPDATE ON EMPLOYE TO Admin;
	GRANT SELECT ON INTERVENANT TO Admin;
	
	connect Admin/Admin;
	
	UPDATE DBAINTERVENTION.EMPLOYE E 
	SET E.SALAIRE = E.SALAIRE + 1000 
	WHERE E.NUMEMPLOYE IN 
		(SELECT I.NUMEMPLOYE 
		FROM DBAINTERVENTION.INTERVENANT I 
		WHERE (SELECT COUNT(NUMINTERVENTION) 
			   FROM DBAINTERVENTION.INTERVENANT II
			   WHERE I.NUMEMPLOYE = II.NUMEMPLOYE
			   GROUP BY NUMEMPLOYE 
			   )>5
		);


 SQL>    connect DBAINTERVENTION/DBAINTERVENTION;
Connected.
SQL>
SQL>    GRANT UPDATE ON EMPLOYE TO Admin;

Grant succeeded.

SQL>    GRANT SELECT ON INTERVENANT TO Admin;

Grant succeeded.

 
 SQL>    connect Admin/Admin;
Connected.
SQL>
SQL>    UPDATE DBAINTERVENTION.EMPLOYE E
        SET E.SALAIRE = E.SALAIRE + 1000
        WHERE E.NUMEMPLOYE IN
                (SELECT I.NUMEMPLOYE
                FROM DBAINTERVENTION.INTERVENANT I
                WHERE (SELECT COUNT(NUMINTERVENTION)
                           FROM DBAINTERVENTION.INTERVENANT II
                           WHERE I.NUMEMPLOYE = II.NUMEMPLOYE
                           GROUP BY NUMEMPLOYE
                           )>5
                );

0 rows updated.


/*une fois les droits de l'utilisateur Admin ajustés , la requete est executée 
et le résultat est que aucune ligne n'est modifiée */ 

/** 9 **/ 


	CREATE INDEX NOMEMP_IX ON DBAINTERVENTION.EMPLOYE(NOMEMP);
	
SQL> CREATE INDEX NOMEMP_IX ON DBAINTERVENTION.EMPLOYE(NOMEMP);
CREATE INDEX NOMEMP_IX ON DBAINTERVENTION.EMPLOYE(NOMEMP)
                                          *
ERROR at line 1:
ORA-01031: insufficient privileges

/*on remarque que l'utilisateur Admin n'a pas le droit a la creation d'index sur la table
EMPLOYE , pour cela le privileges de creation d'index sur ma table en question doit lui etre attribué
aussi ici oracle reconnait que la table EMPLOYE existe mais que l'utilisateur n'a pas le droit a la creation d'un index la dessus*/
	
	
/** 10 **/

	connect DBAINTERVENTION/DBAINTERVENTION;
	GRANT INDEX ON EMPLOYE TO Admin;
	
	connect Admin/Admin;
	CREATE INDEX NOMEMP_IX ON DBAINTERVENTION.EMPLOYE(NOMEMP);
	
SQL> connect DBAINTERVENTION/DBAINTERVENTION;
Connected.
SQL> GRANT INDEX ON EMPLOYE TO Admin;

Grant succeeded.

SQL> connect Admin/Admin;
Connected.
SQL> CREATE INDEX NOMEMP_IX ON DBAINTERVENTION.EMPLOYE(NOMEMP);

Index created.

/* Une fois le privilége de création d'index sur la table EMPLOYE accordé à l'Admin, la création 
de déroule normalement */

/** 11 **/

	connect DBAINTERVENTION/DBAINTERVENTION;
	REVOKE SELECT ON EMPLOYE FROM Admin;
	REVOKE UPDATE ON EMPLOYE FROM Admin;
	REVOKE SELECT ON INTERVENANT FROM Admin;
	REVOKE INDEX ON EMPLOYE FROM Admin;

	
SQL> connect DBAINTERVENTION/DBAINTERVENTION;
Connected.
SQL> REVOKE ALL PRIVILEGES ON EMPLOYE FROM Admin;

Revoke succeeded.

SQL> REVOKE ALL PRIVILEGES ON INTERVENANT FROM Admin;

Revoke succeeded.
	
	/* en utilisant revoke all privileges sur les 2 tables citée nous retirons tous les
	privileres accordés a l'Admin */
	
	
/** 12 **/ 
/*à faire*/
/* montons que les privileges ont bien été retirés*/

CONNECT Admin/Admin
SELECT * FROM DBAINTERVENTION.EMPLOYE
ERROR at line 1:
ORA-00942: table or view does not exist

UPDATE DBAINTERVENTION.EMPLOYE SET SALAIRE=0 WHERE SALAIRE > 1000;
ERROR at line 1:
ORA-00942: table or view does not exist

SELECT * FROM DBAINTERVENTION.INTERVENANT
ERROR at line 1:
ORA-00942: table or view does not exist

CREATE INDEX NOMEMP_IX ON DBAINTERVENTION.EMPLOYE(NOMEMP);
ERROR at line 1:
ORA-00942: table or view does not exist


/** 13 **/
/*la creation d'un profile permet la réstriction des ressources a un ustilisateur*/

CREATE PROFILE Interv_Profil
LIMIT SESSIONS_PER_USER 3 
CPU_PER_SESSION DEFAULT 
CPU_PER_CALL 35 CONNECT_TIME 
90 IDLE_TIME 30 
LOGICAL_READS_PER_SESSION DEFAULT 
LOGICAL_READS_PER_CALL 1200 
COMPOSITE_LIMIT DEFAULT
PRIVATE_SGA 25K
FAILED_LOGIN_ATTEMPTS 5
PASSWORD_LIFE_TIME 50
PASSWORD_REUSE_TIME 40
PASSWORD_REUSE_MAX UNLIMITED
PASSWORD_LOCK_TIME 1 
PASSWORD_GRACE_TIME 5 ;


SQL> CREATE PROFILE Interv_Profil
   LIMIT SESSIONS_PER_USER 3
   CPU_PER_SESSION DEFAULT
   CPU_PER_CALL 35 CONNECT_TIME
   90 IDLE_TIME 30
   LOGICAL_READS_PER_SESSION DEFAULT
   LOGICAL_READS_PER_CALL 1200
   COMPOSITE_LIMIT DEFAULT
   PRIVATE_SGA 25K
   FAILED_LOGIN_ATTEMPTS 5
   PASSWORD_LIFE_TIME 50
   PASSWORD_REUSE_TIME 40
   PASSWORD_REUSE_MAX UNLIMITED
   PASSWORD_LOCK_TIME 1
   PASSWORD_GRACE_TIME 5 ;

Profile created.
 
 /** 14 **/
 
 ALTER USER Admin PROFILE Interv_Profil;
 
 
 SQL> ALTER USER Admin PROFILE Interv_Profil;

User altered.

/** 15 **/
/*a la creation d'un role on d'affecte un ensemble de privileges 
puis se role peut etre affecté a plusieurs users */
	
	CREATE ROLE GESTIONNAIRE_DES_INTERVENTIONS IDENTIFIED BY ADMIN ;
	GRANT SELECT ON EMPLOYE TO GESTIONNAIRE_DES_INTERVENTIONS;
	GRANT SELECT ON VEHICULE TO GESTIONNAIRE_DES_INTERVENTIONS;
	GRANT SELECT ON CLIENT TO GESTIONNAIRE_DES_INTERVENTIONS;

	GRANT UPDATE ON INTERVENTIONS TO GESTIONNAIRE_DES_INTERVENTIONS;
	GRANT UPDATE ON INTERVENANT TO GESTIONNAIRE_DES_INTERVENTIONS;



SQL> CREATE ROLE GESTIONNAIRE_DES_INTERVENTIONS IDENTIFIED BY ADMIN ;

Role created.

SQL> GRANT SELECT ON EMPLOYE TO GESTIONNAIRE_DES_INTERVENTIONS;

Grant succeeded.

SQL> GRANT SELECT ON VEHICULE TO GESTIONNAIRE_DES_INTERVENTIONS;

Grant succeeded.

SQL> GRANT SELECT ON CLIENT TO GESTIONNAIRE_DES_INTERVENTIONS;

Grant succeeded.

SQL>
SQL> GRANT UPDATE ON INTERVENTIONS TO GESTIONNAIRE_DES_INTERVENTIONS;

Grant succeeded.

SQL> GRANT UPDATE ON INTERVENANT TO GESTIONNAIRE_DES_INTERVENTIONS;

Grant succeeded.
 
 
 
 /** 16 **/
 
 
 
 
	GRANT GESTIONNAIRE_DES_INTERVENTIONS TO Admin;
 
 
 SQL>  GRANT GESTIONNAIRE_DES_INTERVENTIONS TO Admin;

Grant succeeded.

/* vérification que les privileges transmis à l'Admin via le role 'GESTIONNAIRE_DES_INTERVENTIONS' fonctionnent*/ 
 
 CONNECT Admin/Admin
SELECT COUNT(NUMEMPLOYE) FROM DBAINTERVENTION.EMPLOYE;
SELECT COUNT(NUMVEHICULE) FROM DBAINTERVENTION.VEHICULE;
SELECT COUNT(NUMCLIENT) FROM DBAINTERVENTION.CLIENT;
UPDATE DBAINTERVENTION.INTERVENTIONS SET COUTINTERV=COUTINTERV+100;
UPDATE DBAINTERVENTION.INTERVENANT SET DATEDEBUT=DATEDEBUT+2;
 
 
 