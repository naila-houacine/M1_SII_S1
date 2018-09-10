  
 
 /** 1**/
 
 SELECT COUNT(*) FROM DICT;
 
 /** il contient n instance 
 
 2551 rows selected.
**/
 
 /* le structure du cataloge DICT est : */
 
DESC DICT;
/**
 Name                                      Null?    Type
 ----------------------------------------- -------- ------------------
 TABLE_NAME                                         VARCHAR2(30)
 COMMENTS                                           VARCHAR2(4000)
 **/
 /** 2 **/
SELECT * FROM DICT 
WHERE TABLE_NAME IN ('ALL_TAB_COLUMNS','USER_USERS', 'ALL_CONSTRAINTS', 'USER_TAB_PRIVS');

/*
TABLE_NAME		       COMMENTS
------------------------------ -------------------------------------------------
ALL_CONSTRAINTS 	       Constraint definitions on accessible tables
ALL_TAB_COLUMNS 	       Columns of user s tables, views and clusters
USER_TAB_PRIVS		       Grants on objects for which the user is the owner
USER_USERS		       	   Information about the current user
*/

DESC ALL_TAB_COLUMNS;

/**
 Name                                      Null?    Type
 ----------------------------------------- -------- ---------------

 OWNER                                     NOT NULL VARCHAR2(30)
 TABLE_NAME                                NOT NULL VARCHAR2(30)
 COLUMN_NAME                               NOT NULL VARCHAR2(30)
 DATA_TYPE                                          VARCHAR2(106)
 DATA_TYPE_MOD                                      VARCHAR2(3)
 DATA_TYPE_OWNER                                    VARCHAR2(120)
 DATA_LENGTH                               NOT NULL NUMBER
 DATA_PRECISION                                     NUMBER
 DATA_SCALE                                         NUMBER
 NULLABLE                                           VARCHAR2(1)
 COLUMN_ID                                          NUMBER
 DEFAULT_LENGTH                                     NUMBER
 DATA_DEFAULT                                       LONG
 NUM_DISTINCT                                       NUMBER
 LOW_VALUE                                          RAW(32)
 HIGH_VALUE                                         RAW(32)
 DENSITY                                            NUMBER
 NUM_NULLS                                          NUMBER
 NUM_BUCKETS                                        NUMBER
 LAST_ANALYZED                                      DATE
 SAMPLE_SIZE                                        NUMBER
 CHARACTER_SET_NAME                                 VARCHAR2(44)
 CHAR_COL_DECL_LENGTH                               NUMBER
 GLOBAL_STATS                                       VARCHAR2(3)
 USER_STATS                                         VARCHAR2(3)
 AVG_COL_LEN                                        NUMBER
 CHAR_LENGTH                                        NUMBER
 CHAR_USED                                          VARCHAR2(1)
 V80_FMT_IMAGE                                      VARCHAR2(3)
 DATA_UPGRADED                                      VARCHAR2(3)
 HISTOGRAM                                          VARCHAR2(15)
 **/
 
DESC USER_USERS;

/**
SQL> DESC USER_USERS;
 Name                                      Null?    Type
 ----------------------------------------- -------- -----------------
 USERNAME                                  NOT NULL VARCHAR2(30)
 USER_ID                                   NOT NULL NUMBER
 ACCOUNT_STATUS                            NOT NULL VARCHAR2(32)
 LOCK_DATE                                          DATE
 EXPIRY_DATE                                        DATE
 DEFAULT_TABLESPACE                        NOT NULL VARCHAR2(30)
 TEMPORARY_TABLESPACE                      NOT NULL VARCHAR2(30)
 CREATED                                   NOT NULL DATE
 INITIAL_RSRC_CONSUMER_GROUP                        VARCHAR2(30)
 EXTERNAL_NAME                                      VARCHAR2(4000)
 **/
 
DESC ALL_CONSTRAINTS;

/**
SQL> DESC ALL_CONSTRAINTS;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------

 OWNER                                              VARCHAR2(120)
 CONSTRAINT_NAME                           NOT NULL VARCHAR2(30)
 CONSTRAINT_TYPE                                    VARCHAR2(1)
 TABLE_NAME                                NOT NULL VARCHAR2(30)
 SEARCH_CONDITION                                   LONG
 R_OWNER                                            VARCHAR2(120)
 R_CONSTRAINT_NAME                                  VARCHAR2(30)
 DELETE_RULE                                        VARCHAR2(9)
 STATUS                                             VARCHAR2(8)
 DEFERRABLE                                         VARCHAR2(14)
 DEFERRED                                           VARCHAR2(9)
 VALIDATED                                          VARCHAR2(13)
 GENERATED                                          VARCHAR2(14)
 BAD                                                VARCHAR2(3)
 RELY                                               VARCHAR2(4)
 LAST_CHANGE                                        DATE
 INDEX_OWNER                                        VARCHAR2(30)
 INDEX_NAME                                         VARCHAR2(30)
 INVALID                                            VARCHAR2(7)
 VIEW_RELATED                                       VARCHAR2(14)
 **/

DESC USER_TAB_PRIVS;

 /**
 SQL> DESC USER_TAB_PRIVS;
  Name                                      Null?    Type
 ----------------------------------------- -------- --------------------
 GRANTEE                                   NOT NULL VARCHAR2(30)
 OWNER                                     NOT NULL VARCHAR2(30)
 TABLE_NAME                                NOT NULL VARCHAR2(30)
 GRANTOR                                   NOT NULL VARCHAR2(30)
 PRIVILEGE                                 NOT NULL VARCHAR2(40)
 GRANTABLE                                          VARCHAR2(3)
 HIERARCHY                                          VARCHAR2(3)
**/




 /** 3 **/
 
 
 SELECT USERNAME FROM USER_USERS ; 
 
 /**
USERNAME
------------------------------
SYSTEM
 **/
 /** 4 **/
DESC ALL_TAB_COLUMNS;
DESC USER_TAB_COLUMNS;
/*la structure des tables est presque le meme la suele difference c'est l'attribut OWNER dans la table ALL_TAB_COLUMNS*/
SELECT COUNT(*) FROM ALL_TAB_COLUMNS;
SELECT COUNT(*) FROM USER_TAB_COLUMNS;
/*
La table \texttt{ALL_TAB_COLUMNS} contient beaucoup de lignes par rapport à la table \texttt{USER_TAB_COLUMNS}
ceci est justifier par le fait que cette denière contient que les information concernant les tables de l'utilisateur actualle 
tandis que la première contient  les information de toutes tables que l'utlisateur a un acces
*/

 /** 5 **/
 
 DESC ALL_TABLES;
 /**
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------
 OWNER                                     NOT NULL VARCHAR2(30)
 TABLE_NAME                                NOT NULL VARCHAR2(30)
 TABLESPACE_NAME                                    VARCHAR2(30)
 CLUSTER_NAME                                       VARCHAR2(30)
 IOT_NAME                                           VARCHAR2(30)
 STATUS                                             VARCHAR2(8)
 PCT_FREE                                           NUMBER
 PCT_USED                                           NUMBER
 INI_TRANS                                          NUMBER
 MAX_TRANS                                          NUMBER
 INITIAL_EXTENT                                     NUMBER
 NEXT_EXTENT                                        NUMBER
 MIN_EXTENTS                                        NUMBER
 MAX_EXTENTS                                        NUMBER
 PCT_INCREASE                                       NUMBER
 FREELISTS                                          NUMBER
 FREELIST_GROUPS                                    NUMBER
 LOGGING                                            VARCHAR2(3)
 BACKED_UP                                          VARCHAR2(1)
 NUM_ROWS                                           NUMBER
 BLOCKS                                             NUMBER
 EMPTY_BLOCKS                                       NUMBER
 AVG_SPACE                                          NUMBER
 CHAIN_CNT                                          NUMBER
 AVG_ROW_LEN                                        NUMBER
 AVG_SPACE_FREELIST_BLOCKS                          NUMBER
 NUM_FREELIST_BLOCKS                                NUMBER
 DEGREE                                             VARCHAR2(40)
 INSTANCES                                          VARCHAR2(40)
 CACHE                                              VARCHAR2(20)
 TABLE_LOCK                                         VARCHAR2(8)
 SAMPLE_SIZE                                        NUMBER
 LAST_ANALYZED                                      DATE
 PARTITIONED                                        VARCHAR2(3)
 IOT_TYPE                                           VARCHAR2(12)
 TEMPORARY                                          VARCHAR2(1)
 SECONDARY                                          VARCHAR2(1)
 NESTED                                             VARCHAR2(3)
 BUFFER_POOL                                        VARCHAR2(7)
 FLASH_CACHE                                        VARCHAR2(7)
 CELL_FLASH_CACHE                                   VARCHAR2(7)
 ROW_MOVEMENT                                       VARCHAR2(8)
 GLOBAL_STATS                                       VARCHAR2(3)
 USER_STATS                                         VARCHAR2(3)
 DURATION                                           VARCHAR2(15)
 SKIP_CORRUPT                                       VARCHAR2(8)
 MONITORING                                         VARCHAR2(3)
 CLUSTER_OWNER                                      VARCHAR2(30)
 DEPENDENCIES                                       VARCHAR2(8)
 COMPRESSION                                        VARCHAR2(8)
 COMPRESS_FOR                                       VARCHAR2(12)
 DROPPED                                            VARCHAR2(3)
 READ_ONLY                                          VARCHAR2(3)
 SEGMENT_CREATED                                    VARCHAR2(3)
 RESULT_CACHE                                       VARCHAR2(7)
 **/
 
SELECT TABLE_NAME  FROM ALL_TABLES WHERE OWNER = 'DBAINTERVENTION' ;

/**
TABLE_NAME
------------------------------
CLIENT
EMPLOYE
MARQUE
MODELE
VEHICULE
INTERVENTIONS
INTERVENANT
 
7 rows selected.
**/


 SELECT * FROM ALL_TABLES WHERE OWNER = 'DBAINTERVENTION';
 
 /*vu que le nbr d'infos est très important nous allons afficher que 3 colonnes qui sont:
 le nom de la table , le nom de la table space dans la quelle les tables ont été crées
 et le nom du proporiétaire de la table*/ 

 SELECT TABLE_NAME, TABLESPACE_NAME, OWNER FROM ALL_TABLES WHERE OWNER = 'DBAINTERVENTION';

 /**
TABLE_NAME                     TABLESPACE_NAME				OWNER 
-------------------------------------------------------------------
CLIENT                         INTERVENTION_TBS				DBAINTERVENTION
EMPLOYE                        INTERVENTION_TBS				DBAINTERVENTION
MARQUE                         INTERVENTION_TBS				DBAINTERVENTION
MODELE                         INTERVENTION_TBS				DBAINTERVENTION
VEHICULE                       INTERVENTION_TBS				DBAINTERVENTION
INTERVENTIONS                  INTERVENTION_TBS				DBAINTERVENTION
INTERVENANT                    INTERVENTION_TBS				DBAINTERVENTION
7 rows selected.
**/
 
 /** 6 **/ 
SELECT TABLE_NAME  FROM ALL_TABLES WHERE OWNER = 'SYSTEM' ;
SELECT TABLE_NAME  FROM ALL_TABLES WHERE OWNER = 'DBAINTERVENTION' ;

/**

TABLE_NAME
------------------------------
LOGMNR_GLOBAL$
LOGMNR_RESTART_CKPT_TXINFO$
LOGMNR_SESSION_ACTIONS$
LOGMNR_SESSION_EVOLVE$
LOGSTDBY$FLASHBACK_SCN
LOGMNR_PARAMETER$
LOGMNR_SESSION$
LOGMNR_FILTER$
MVIEW$_ADV_WORKLOAD
MVIEW$_ADV_BASETABLE
MVIEW$_ADV_SQLDEPEND
MVIEW$_ADV_PRETTY
MVIEW$_ADV_TEMP
MVIEW$_ADV_FILTER
MVIEW$_ADV_LOG
MVIEW$_ADV_FILTERINSTANCE
MVIEW$_ADV_LEVEL
MVIEW$_ADV_ROLLUP
MVIEW$_ADV_AJG
MVIEW$_ADV_FJG
MVIEW$_ADV_GC
MVIEW$_ADV_CLIQUE
MVIEW$_ADV_ELIGIBLE
MVIEW$_ADV_OUTPUT
MVIEW$_ADV_EXCEPTIONS
MVIEW$_ADV_PARAMETERS
MVIEW$_ADV_INFO
MVIEW$_ADV_JOURNAL
MVIEW$_ADV_PLAN
AQ$_QUEUE_TABLES
AQ$_QUEUES
AQ$_SCHEDULES
AQ$_INTERNET_AGENTS
AQ$_INTERNET_AGENT_PRIVS
DEF$_ERROR
DEF$_DESTINATION
DEF$_CALLDEST
DEF$_DEFAULTDEST
DEF$_LOB
DEF$_PROPAGATOR
DEF$_ORIGIN
DEF$_PUSHED_TRANSACTIONS
DEF$_AQCALL
DEF$_AQERROR
REPCAT$_REPCAT
REPCAT$_FLAVORS
REPCAT$_REPSCHEMA
REPCAT$_SNAPGROUP
REPCAT$_REPOBJECT
REPCAT$_REPCOLUMN
REPCAT$_KEY_COLUMNS
REPCAT$_GENERATED
REPCAT$_REPPROP
REPCAT$_REPCATLOG
REPCAT$_DDL
REPCAT$_REPGROUP_PRIVS
REPCAT$_PRIORITY_GROUP
REPCAT$_PRIORITY
REPCAT$_COLUMN_GROUP
REPCAT$_GROUPED_COLUMN
REPCAT$_CONFLICT
REPCAT$_RESOLUTION_METHOD
REPCAT$_RESOLUTION
REPCAT$_RESOLUTION_STATISTICS
REPCAT$_RESOL_STATS_CONTROL
REPCAT$_PARAMETER_COLUMN
REPCAT$_AUDIT_ATTRIBUTE
REPCAT$_AUDIT_COLUMN
REPCAT$_FLAVOR_OBJECTS
REPCAT$_TEMPLATE_STATUS
REPCAT$_TEMPLATE_TYPES
REPCAT$_REFRESH_TEMPLATES
REPCAT$_USER_AUTHORIZATIONS
REPCAT$_OBJECT_TYPES
REPCAT$_TEMPLATE_REFGROUPS
REPCAT$_TEMPLATE_OBJECTS
REPCAT$_TEMPLATE_PARMS
REPCAT$_OBJECT_PARMS
REPCAT$_USER_PARM_VALUES
REPCAT$_TEMPLATE_SITES
REPCAT$_SITE_OBJECTS
REPCAT$_RUNTIME_PARMS
REPCAT$_TEMPLATE_TARGETS
REPCAT$_EXCEPTIONS
REPCAT$_INSTANTIATION_DDL
REPCAT$_EXTENSION
REPCAT$_SITES_NEW
LOGMNR_SPILL$
LOGSTDBY$EVENTS
LOGMNR_UID$
LOGMNR_LOG$
LOGMNR_ERROR$
LOGMNR_PROCESSED_LOG$
LOGMNR_RESTART_CKPT$
LOGMNRC_DBNAME_UID_MAP
LOGMNR_AGE_SPILL$
LOGMNR_INTEGRATED_SPILL$
LOGSTDBY$PARAMETERS
LOGSTDBY$APPLY_MILESTONE
LOGSTDBY$SCN
LOGSTDBY$PLSQL
LOGSTDBY$SKIP_TRANSACTION
LOGSTDBY$SKIP
LOGSTDBY$SKIP_SUPPORT
LOGSTDBY$HISTORY
LOGSTDBY$EDS_TABLES
INTERVENTIONS
INTERVENANT
SQLPLUS_PRODUCT_PROFILE
HELP
CLIENT
TABLEERREURS
EMPLOYE
MARQUE
MODELE
VEHICULE
LOGMNR_GT_TAB_INCLUDE$
LOGMNR_GT_USER_INCLUDE$
LOGMNR_GT_XID_INCLUDE$
LOGMNRT_MDDL$
OL$
OL$HINTS
OL$NODES
LOGMNR_DICTSTATE$
LOGMNRC_GTLO
LOGMNRC_GTCS
LOGMNRC_GSII
LOGMNRC_GSBA
LOGMNR_SEED$
LOGMNR_DICTIONARY$
LOGMNR_OBJ$
LOGMNR_TAB$
LOGMNR_COL$
LOGMNR_ATTRCOL$
LOGMNR_TS$
LOGMNR_IND$
LOGMNR_USER$
LOGMNR_TABPART$
LOGMNR_TABSUBPART$
LOGMNR_TABCOMPART$
LOGMNR_TYPE$
LOGMNR_COLTYPE$
LOGMNR_ATTRIBUTE$
LOGMNR_LOB$
LOGMNR_CDEF$
LOGMNR_CCOL$
LOGMNR_ICOL$
LOGMNR_LOBFRAG$
LOGMNR_INDPART$
LOGMNR_INDSUBPART$
LOGMNR_INDCOMPART$
LOGMNR_LOGMNR_BUILDLOG
LOGMNR_NTAB$
LOGMNR_OPQTYPE$
LOGMNR_SUBCOLTYPE$
LOGMNR_KOPM$
LOGMNR_PROPS$
LOGMNR_ENC$
LOGMNR_REFCON$
LOGMNR_PARTOBJ$
LOGMNRP_CTAS_PART_MAP
LOGSTDBY$APPLY_PROGRESS

162 rows selected.

**/

/**
TABLE_NAME
------------------------------
CLIENT
EMPLOYE
MARQUE
MODELE
VEHICULE
INTERVENTIONS
INTERVENANT

7 rows selected.

**/

 /** 7 **/
 
 DESC USER_TAB_COLUMNS;
 
 /**
 Name                                      Null?    Type
 ----------------------------------------- -------- -----------------------
 TABLE_NAME                                NOT NULL VARCHAR2(30)
 COLUMN_NAME                               NOT NULL VARCHAR2(30)
 DATA_TYPE                                          VARCHAR2(106)
 DATA_TYPE_MOD                                      VARCHAR2(3)
 DATA_TYPE_OWNER                                    VARCHAR2(120)
 DATA_LENGTH                               NOT NULL NUMBER
 DATA_PRECISION                                     NUMBER
 DATA_SCALE                                         NUMBER
 NULLABLE                                           VARCHAR2(1)
 COLUMN_ID                                          NUMBER
 DEFAULT_LENGTH                                     NUMBER
 DATA_DEFAULT                                       LONG
 NUM_DISTINCT                                       NUMBER
 LOW_VALUE                                          RAW(32)
 HIGH_VALUE                                         RAW(32)
 DENSITY                                            NUMBER
 NUM_NULLS                                          NUMBER
 NUM_BUCKETS                                        NUMBER
 LAST_ANALYZED                                      DATE
 SAMPLE_SIZE                                        NUMBER
 CHARACTER_SET_NAME                                 VARCHAR2(44)
 CHAR_COL_DECL_LENGTH                               NUMBER
 GLOBAL_STATS                                       VARCHAR2(3)
 USER_STATS                                         VARCHAR2(3)
 AVG_COL_LEN                                        NUMBER
 CHAR_LENGTH                                        NUMBER
 CHAR_USED                                          VARCHAR2(1)
 V80_FMT_IMAGE                                      VARCHAR2(3)
 DATA_UPGRADED                                      VARCHAR2(3)
 HISTOGRAM                                          VARCHAR2(15)
 **/
 
  SELECT * FROM USER_TAB_COLUMNS WHERE (TABLE_NAME = 'VEHICULE' OR TABLE_NAME = 'INTERVENTIONS');
  
  /* vu que la quantité d'infos est grande nous nous contenterons d'afficher uniquement 5 infos qui sont : */
 
 
 SELECT TABLE_NAME, COLUMN_NAME, NULLABLE, DATA_TYPE, DATA_LENGTH FROM USER_TAB_COLUMNS WHERE (TABLE_NAME = 'VEHICULE' OR TABLE_NAME = 'INTERVENTIONS');
 
 /**
 TABLE_NAME            COLUMN_NAME               N		DATA_TYPE		DATA_LENGTH
-------------------------------------------------------------------------------------
INTERVENTIONS          NUMINTERVENTION           N		NUMBER	         22
INTERVENTIONS          NUMVEHICULE               Y		NUMBER	         22
INTERVENTIONS          TYPEINTERVENTION          Y		VARCHAR2         40
INTERVENTIONS          DATEDEBINTERV             Y		DATE	          7
INTERVENTIONS          DATEFININTERV             Y		DATE	          7
INTERVENTIONS          COUTINTERV                Y		FLOAT	         22
VEHICULE               NUMVEHICULE               N		NUMBER	         22
VEHICULE               NUMCLIENT                 Y		NUMBER	         22
VEHICULE               NUMMODELE                 Y		NUMBER	         22
VEHICULE               NUMIMMAT                  Y		NUMBER	         22
VEHICULE               ANNEE                     Y		VARCHAR2	      4
11 rows selected.
**/
 
 
 /** 8 **/ 
 /*1. chercher dans le dictionaire touts les tables qui contient le mot CONSTRAINTS*/
 SELECT * FROM DICT WHERE TABLE_NAME LIKE '%CONSTRAINTS%'
 /*
 2. à partir de la description des tables on extrait les noms des tables qui peuvent contenir l'information concerntant la containte demandé
 dans ce cas : USER_CONSTRAINTS
 */
 /*
 3. afficher le chema de la table
 */
 DESC USER_CONSTRAINTS;
 /*
 4. écriture de la reqûte qui vérifie l'existense du contrainte
 */
 SELECT CONSTRAINT_NAME
 FROM USER_CONSTRAINTS
 WHERE CONSTRAINT_TYPE = 'R' AND TABLE_NAME = 'VEHICULE' OR TABLE_NAME = 'INTERVENTIONS';
 
/**
CONSTRAINT_NAME
-----------------------------
FK_VEHICULE_CLIENT
FK_VEHICULE_MODELE
PK_INTERVENTIONS
FK_INTERVENTIONS_VEHICULE
CHK_DATEINTERV

**/
 
 /** 9 **/
 
 DESC USER_CONSTRAINTS;
 
 /**
  Name                                      Null?    Type
 ----------------------------------------- -------- --------------------
 OWNER                                              VARCHAR2(120)
 CONSTRAINT_NAME                           NOT NULL VARCHAR2(30)
 CONSTRAINT_TYPE                                    VARCHAR2(1)
 TABLE_NAME                                NOT NULL VARCHAR2(30)
 SEARCH_CONDITION                                   LONG
 R_OWNER                                            VARCHAR2(120)
 R_CONSTRAINT_NAME                                  VARCHAR2(30)
 DELETE_RULE                                        VARCHAR2(9)
 STATUS                                             VARCHAR2(8)
 DEFERRABLE                                         VARCHAR2(14)
 DEFERRED                                           VARCHAR2(9)
 VALIDATED                                          VARCHAR2(13)
 GENERATED                                          VARCHAR2(14)
 BAD                                                VARCHAR2(3)
 RELY                                               VARCHAR2(4)
 LAST_CHANGE                                        DATE
 INDEX_OWNER                                        VARCHAR2(30)
 INDEX_NAME                                         VARCHAR2(30)
 INVALID                                            VARCHAR2(7)
 VIEW_RELATED                                       VARCHAR2(14)
**/
 
 
 
 SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME IN ('EMPLOYE','VEHICULE','MARQUE','MODELE','INTERVENTIONS','INTERVENANT','CLIENT');
 
/*EN RAISON DU NBR IMPORANT D'INFO NOUS N'AFFICHERONS QUE LES COLONNES SVTES / */

  SELECT  CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, STATUS  FROM USER_CONSTRAINTS WHERE TABLE_NAME IN ('EMPLOYE','VEHICULE','MARQUE','MODELE','INTERVENTIONS','INTERVENANT','CLIENT');
 
 /**
 CONSTRAINT_NAME                C TABLE_NAME                     STATUS
------------------------------ - ------------------------------ --------
CH_EMPLOYE                     C EMPLOYE                        ENABLED
FK_VEHICULE_MODELE             R VEHICULE                       ENABLED
FK_VEHICULE_CLIENT             R VEHICULE                       ENABLED
FK_MODELE_MARQUE               R MODELE                         ENABLED
FK_INTERVENTIONS_VEHICULE      R INTERVENTIONS                  ENABLED
FK_INTERVENANT_INTERVENTIONS   R INTERVENANT                    ENABLED
FK_INTERVENANT_EMPLOYE         R INTERVENANT                    ENABLED
PK_VEHICULE                    P VEHICULE                       ENABLED
PK_MODELE                      P MODELE                         ENABLED
PK_MARQUE                      P MARQUE                         ENABLED
PK_INTERVENTIONS               P INTERVENTIONS                  ENABLED
PK_INTERVENANT                 P INTERVENANT                    ENABLED
PK_EMPLOYE                     P EMPLOYE                        ENABLED
PK_CLIENT                      P CLIENT                         ENABLED
CHK_DATEINTERV                 C INTERVENTIONS                  DISABLED
15 rows selected.
**/
 
 /** 10 **/ 
 DESC INTERVENTIONS;
 SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, STATUS, R_OWNER , R_CONSTRAINT_NAME  FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'INTERVENTIONS';
 SELECT  OWNER ,INDEX_NAME ,INDEX_TYPE ,TABLE_OWNER ,TABLE_TYPE   FROM ALL_INDEXES WHERE TABLE_NAME = 'INTERVENTIONS';
 SELECT * FROM ALL_IND_COLUMNS WHERE TABLE_NAME = 'INTERVENTIONS';
 SELECT * FROM ALL_TAB_PRIVS WHERE TABLE_NAME = 'INTERVENTIONS' ;
 
 


 /**
 SQL> DESC INTERVENTIONS;
 Name                                      Null?    Type
 ----------------------------------------- -------- ---------------

 NUMINTERVENTION                           NOT NULL NUMBER(38)
 NUMVEHICULE                                        NUMBER(38)
 TYPEINTERVENTION                                   VARCHAR2(40)
 DATEDEBINTERV                                      DATE
 DATEFININTERV                                      DATE
 COUTINTERV                                         FLOAT(63)
 
 
 SQL>  SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, STATUS, R_OWNER , R_CONSTRAINT_NAME  FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'INTERVENTIONS';
 
CONSTRAINT_NAME                C TABLE_NAME           STATUS	R_OWNER  		  R_CONSTRAINT_NAME
------------------------------ - -------------------- --------- ----------------- -----------------
FK_INTERVENTIONS_VEHICULE      R INTERVENTIONS        ENABLED   SYSTEM            PK_VEHICULE
FK_INTERVENTIONS_VEHICULE      R INTERVENTIONS        ENABLED   DBAINTERVENTION   PK_VEHICULE
PK_INTERVENTIONS               P INTERVENTIONS        ENABLED
PK_INTERVENTIONS               P INTERVENTIONS        ENABLED
CHK_DATEINTERV                 C INTERVENTIONS        DISABLED

7 rows selected.
 

 SQL>  SELECT  OWNER ,INDEX_NAME ,INDEX_TYPE ,TABLE_OWNER ,TABLE_TYPE   FROM ALL_
INDEXES WHERE TABLE_NAME = 'INTERVENTIONS';

OWNER              INDEX_NAME	  	 INDEX_TYPE      TABLE_OWNER       TABLE_TYPE
------------------ ----------------- --------------- ----------------- ----------
SYSTEM             PK_INTERVENTIONS  NORMAL          SYSTEM            TABLE
DBAINTERVENTION    PK_INTERVENTIONS  NORMAL          DBAINTERVENTION   TABLE


SQL> SELECT * FROM ALL_IND_COLUMNS WHERE TABLE_NAME = 'INTERVENTIONS';

 INDEX_OWNER     INDEX_NAME	       TABLE_OWNER      TABLE_NAME     COLUMN_NAME      C_P C_L CHAR_L DESC
---------------- ----------------- ---------------- -------------- ---------------- --- --- ------ ----
SYSTEM           PK_INTERVENTIONS  SYSTEM           INTERVENTIONS  NUMINTERVENTION  1   22  0      ASC
DBAINTERVENTION  PK_INTERVENTIONS  DBAINTERVENTION  INTERVENTIONS  NUMINTERVENTION  1   22  0      ASC
 
 
 
 SQL>  SELECT * FROM ALL_TAB_PRIVS WHERE TABLE_NAME = 'INTERVENTIONS' ;

GRANTOR GRANTEE					        TABLE_SCHEMA  TABLE_NAME	 PRIVILEGE  GRA  HIE
------- ------------------------------- ------------- -------------- ---------- ---- ---
SYSTEM  GESTIONNAIRE_DES_INTERVENTIONS	 SYSTEM        INTERVENTIONS  UPDATE     NO   NO
**/
 
 
 /** 11 **/
 
 
 
 
 SELECT PRIVILEGE, TABLE_NAME FROM ALL_TAB_PRIVS WHERE GRANTEE = 'ADMIN';
 
 /**
no rows selected
**/

/* car nous avions retiré ts les privileges a l'Admin */

/** 12 **/


DESC DBA_ROLE_PRIVS;

/**
 Name                                      Null?    Type
 ----------------------------------------- -------- ---------------
 GRANTEE                                            VARCHAR2(30)
 GRANTED_ROLE                              NOT NULL VARCHAR2(30)
 ADMIN_OPTION                                       VARCHAR2(3)
 DEFAULT_ROLE                                       VARCHAR2(3)
**/



SELECT GRANTED_ROLE 
FROM DBA_ROLE_PRIVS 
WHERE GRANTEE = 'ADMIN';

/**
GRANTED_ROLE
------------------------------
GESTIONNAIRE_DES_INTERVENTIONS
 **/
 
 /** 13 **/
 
 DESC ALL_OBJECTS;
 /**
 Name                                      Null?    Type
 ----------------------------------------- -------- ---------------
 OWNER                                     NOT NULL VARCHAR2(30)
 OBJECT_NAME                               NOT NULL VARCHAR2(30)
 SUBOBJECT_NAME                                     VARCHAR2(30)
 OBJECT_ID                                 NOT NULL NUMBER
 DATA_OBJECT_ID                                     NUMBER
 OBJECT_TYPE                                        VARCHAR2(19)
 CREATED                                   NOT NULL DATE
 LAST_DDL_TIME                             NOT NULL DATE
 TIMESTAMP                                          VARCHAR2(19)
 STATUS                                             VARCHAR2(7)
 TEMPORARY                                          VARCHAR2(1)
 GENERATED                                          VARCHAR2(1)
 SECONDARY                                          VARCHAR2(1)
 NAMESPACE                                 NOT NULL NUMBER
 EDITION_NAME                                       VARCHAR2(30)
 
**/
 
 
SELECT OBJECT_NAME 
FROM ALL_OBJECTS 
WHERE OWNER = 'ADMIN' ;

/**
OBJECT_NAME
---------------------------------------------
NOMEMP_IX
SYS_C007170
MY_TABLE
**/

/** 14 **/
SELECT OWNER FROM ALL_TABLES WHERE TABLE_NAME = 'INTERVENTIONS';

/**
OWNER
------------------------------
DBAINTERVENTION
**/

 
/** 15 **/ 

 DESC USER_EXTENTS;
 /**
  Name                                      Null?    Type
 ----------------------------------------- -------- --------------
 SEGMENT_NAME                                       VARCHAR2(81)
 PARTITION_NAME                                     VARCHAR2(30)
 SEGMENT_TYPE                                       VARCHAR2(18)
 TABLESPACE_NAME                                    VARCHAR2(30)
 EXTENT_ID                                          NUMBER
 BYTES                                              NUMBER
 BLOCKS                                             NUMBER
**/

 
SELECT BYTES/1024 AS Taille_Ko FROM USER_EXTENTS WHERE SEGMENT_NAME = 'INTERVENTIONS';
 
 /**
 
 TAILLE_KO
----------
        64
 
 **/

 /** 16 ***/

 /*avant création du user testeur, de la table table_tester, de l'ajout de la colonne prenom_testeur, ajout de la contrainte nbr >0
 , grant select privilège on table table_testeur,  revoker le privilège a testeur */
 
SQL> SELECT USERNAME FROM ALL_USERS ;

USERNAME
------------------------------
XS$NULL
ADMIN
USER0
USER1
APEX_040000
APEX_PUBLIC_USER
FLOWS_FILES
HR
MDSYS
ANONYMOUS
XDB
CTXSYS
OUTLN
SYSTEM
SYS
ME
DBAINTERVENTION

17 rows selected.

SQL> CREATE USER TESTEUR IDENTIFIED BY TESTEUR;

User created.

SQL> SELECT USERNAME FROM ALL_USERS ;

USERNAME
------------------------------
XS$NULL
TESTEUR
ADMIN
USER0
USER1
APEX_040000
APEX_PUBLIC_USER
FLOWS_FILES
HR
MDSYS
ANONYMOUS
XDB
CTXSYS
OUTLN
SYSTEM
SYS
ME
DBAINTERVENTION

18 rows selected.

/******************************************************************/

 
 SQL> SELECT * FROM USER_TABLES WHERE TABLE_NAME = 'TABLE_TESTEUR' ;

no rows selected



SQL> CREATE TABLE TABLE_TESTEUR (ID_TESTEUR INTEGER PRIMARY KEY, NOM_TESTEUR VAR
CHAR2(30), NBR INTEGER DEFAULT(0));

Table created.
 
 SQL> SELECT TABLE_NAME,TABLESPACE_NAME, STATUS FROM USER_TABLES WHERE TABLE_NAME
 = 'TABLE_TESTEUR' ;

TABLE_NAME                     TABLESPACE_NAME                STATUS
------------------------------ ------------------------------ --------
TABLE_TESTEUR                  SYSTEM                         VALID
 
 
 /******************************************************************/
 
 SQL> SELECT TABLE_NAME ,COLUMN_NAME , DATA_LENGTH FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'TABLE_TESTEUR';
 
 TABLE_NAME                     COLUMN_NAME                    DATA_LENGTH
------------------------------ ------------------------------ -----------
TABLE_TESTEUR                  ID_TESTEUR                              22
TABLE_TESTEUR                  NOM_TESTEUR                             30
TABLE_TESTEUR                  NBR                                     22

 
 SQL>  ALTER TABLE TABLE_TESTEUR ADD PRENOM_TESTEUR VARCHAR2(30) ;

Table altered.


SQL>  SELECT TABLE_NAME ,COLUMN_NAME , DATA_LENGTH FROM USER_TAB_COLUMNS WHERE T
ABLE_NAME = 'TABLE_TESTEUR';

TABLE_NAME                     COLUMN_NAME                    DATA_LENGTH
------------------------------ ------------------------------ -----------
TABLE_TESTEUR                  ID_TESTEUR                              22
TABLE_TESTEUR                  NOM_TESTEUR                             30
TABLE_TESTEUR                  NBR                                     22
TABLE_TESTEUR                  PRENOM_TESTEUR                          30
 
 
 
 /******************************************************************/
 
 SELECT CONSTRAINT_NAME FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TABLE_TESTEUR';
 
 
 CONSTRAINT_NAME
------------------------------
SYS_C007211



SQL>  ALTER TABLE TABLE_TESTEUR ADD CONSTRAINT CH_NBR8POSITIF CHECK ( NBR > 0);

Table altered.


SQL>  SELECT CONSTRAINT_NAME FROM ALL_CONSTRAINTS WHERE TABLE_NAME = 'TABLE_TES
EUR';

CONSTRAINT_NAME
------------------------------
SYS_C007211
CH_NBR8POSITIF


 /*********************************************************************/
 
 SELECT * FROM ALL_TAB_PRIVS WHERE TABLE_NAME = 'TABLE_TESTEUR'; 
 
 no rows selected
 
 
SQL> GRANT SELECT ON TABLE_TESTEUR TO TESTEUR;

Grant succeeded.



SQL>   SELECT * FROM ALL_TAB_PRIVS WHERE TABLE_NAME = 'TABLE_TESTEUR';

GRANTOR      GRANTEE   TABLE_SCHEMA     TABLE_NAME      PRIVILEGE     GRA HIE
------------ --------- ---------------- --------------- ------------- --- ---
SYSTEM       TESTEUR   SYSTEM           TABLE_TESTEUR   SELECT        NO  NO



/************************************************************************/


SQL>   SELECT * FROM ALL_TAB_PRIVS WHERE TABLE_NAME = 'TABLE_TESTEUR';

GRANTOR      GRANTEE   TABLE_SCHEMA     TABLE_NAME      PRIVILEGE     GRA HIE
------------ --------- ---------------- --------------- ------------- --- ---
SYSTEM       TESTEUR   SYSTEM           TABLE_TESTEUR   SELECT        NO  NO



SQL> REVOKE SELECT ON TABLE_TESTEUR FROM TESTEUR;

Revoke succeeded.



SQL>   SELECT * FROM ALL_TAB_PRIVS WHERE TABLE_NAME = 'TABLE_TESTEUR';

no rows selected
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 