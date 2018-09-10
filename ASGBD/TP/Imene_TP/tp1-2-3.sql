-- Part  2 --
create table HOTEL ( 
NumHotel Number(3), 
Nom varchar(50), 
Ville varchar(20), 
Etoiles number(1), 
constraint pk_hotel primary key (NumHotel), 
constraint check_etoiles check (Etoiles>0 AND Etoiles<6)
);


create table CLIENT(
NumClient number(5),
Nom varchar(20),
Prenom varchar(20),
constraint prk_client primary key (NumClient)
);

create table CHAMBRE ( 
NumChambre Number(3), 
NumHotel number(3), 
Etage number(3),
TypeChambre varchar(10),
PrixNuit number(5), 
constraint pk_chambre primary key (NumHotel,NumChambre), 
constraint fk_hotel foreign key (NumHotel) references HOTEL(NumHotel) on delete cascade,
constraint check_TypeChambre check (TypeChambre IN ('simple','double','triple','suite','autre'))
);

create table RESERVATION (
NumClient number(5),
NumHotel number(3),
DateArrivee date,
DateDepart date,
NumChambre number(3),
constraint pk_reservation primary key(NumHotel, NumClient, DateArrivee),
constraint fk_chambre foreign key (NumHotel,NumChambre) references CHAMBRE(NumHotel,NumChambre) on delete cascade,
constraint fk_client foreign key (NumClient) references CLIENT(NumClient) on delete cascade,
constraint check_date check (DateArrivee<DateDepart)
);

Alter table CLIENT ADD AdresseClient varchar(50);
Alter table CHAMBRE RENAME COLUMN ETAGE TO ETAGECHAMBRE;
Alter table HOTEL MODIFY Etoiles number(1) NOT NULL; 
Alter table CHAMBRE MODIFY TypeChambre varchar(10) NOT NULL; 
Alter table HOTEL MODIFY Ville varchar(50); 
Alter table HOTEL MODIFY Ville varchar(20); 
Alter table CHAMBRE DROP COLUMN PrixNuit; 
Alter table CHAMBRE ADD PrixNuit number(5);
Alter table CHAMBRE add constraint check_prix check( PrixNuit>=2000 and PrixNuit<20000);

/********************************************************************************/
--Part 3 --
--Hotel
insert into hotel values (1,'Renaissance','Tlemcen',5) ;
insert into hotel values(2,'Seybouse','Annaba',3);	
insert into hotel values (3,'Hôtel Novotel','Constantine',4);		
insert into hotel values (4,'Saint George d''Alger','Alger',5);
insert into hotel values(5,'Ibis Alger Aéroport','Alger',2);
insert into hotel values(6,'El Mountazah Annaba','Annaba',3);
insert into hotel values(7,'Hôtel Albert 1er','Alger',3);
insert into hotel values(8,'Chems','Oran',2);
insert into hotel values(9,'Colombe','Oran',3);
insert into hotel values(10,'Mercure','Alger',4);
insert into hotel values(11,'Le Méridien','Oran',5);
insert into hotel values(12,'Hôtel Sofitel','Alger',5);
--Client
insert into Client values (1,'BOUROUBI','Taous',NULL);
insert into Client values (2,'BOUZIDI','AMEL',NULL);
insert into Client values (3,'LACHEMI','Bouzid',NULL);
insert into Client values (4,'BOUCHEMLA','Elias',NULL);
insert into Client values (5,'HADJ','Zouhir',NULL);
insert into Client values (6,'OUSSEDIK','Hakim',NULL);
insert into Client values (7,'AAKOUB','Fatiha',NULL);
insert into Client values (8,'ABAD','Abdelhamid',NULL);
insert into Client values (9,'ABADA','Mohamed',NULL);
insert into Client values (10,'ABAYAHIA','Abdelkader',NULL);
insert into Client values (11,'ABBACI','Abdelmadjid',NULL);	 
insert into Client values (12,'ABBAS','Samira',NULL);	 
insert into Client values (13,'ABBOU','Mohamed',NULL);	 
insert into Client values (14,'ABDELAZIZ','Ahmed',NULL);	 
insert into Client values (15,'ABDELMOUMEN','Nassima',NULL);	 
insert into Client values (16,'ABDELOUAHAB','OUAHIBA',NULL);	 
insert into Client values (17,'ABDEMEZIANE','Madjid',NULL);	 
insert into Client values (18,'ABERKANE','Aicha',NULL);	 
insert into Client values (19,'AZOUG','Dalila',NULL);	 
insert into Client values (20,'BENOUADAH','Mohammed',NULL);	 
insert into Client values (21,'ACHAIBOU','Rachid',NULL);
insert into Client values (22,'ADDAD','Fadila',NULL);
insert into Client values (23,'AGGOUN','Khadidja',NULL);
insert into Client values (24,'AISSAT','Salima',NULL);	 
insert into Client values (25,'AMARA','Dahbia',NULL);	 
 insert into Client values (26,'AROUEL','Leila',NULL);	 
 insert into Client values (27,'BAALI','Souad',NULL);	 
 insert into Client values (28,'BABACI','Mourad',NULL);	 
 insert into Client values (29,'BACHA','Nadia',NULL);	 
 insert into Client values (30,'BAHBOUH','Naima',NULL);	 
 insert into Client values (31,'BADI','Hatem',NULL);	 
 insert into Client values (32,'BAKIR','ADEL',NULL);	 
 insert into Client values (33,'BALI','Malika',NULL);	 
 insert into Client values (34,'BASSI','Fatima',NULL);	 
 insert into Client values (35,'BEHADI','Youcef',NULL);	 
 insert into Client values (36,'BEKKAT','Hadia',NULL);	 
 insert into Client values (37,'BELABES','Abdelkader',NULL);	 
 insert into Client values (38,'BELAKERMI','Mohammed',NULL);	 
 insert into Client values (39,'BELGHALI','Mohammed',NULL);	 
 insert into Client values (40,'BELHAMIDI','Mustapha',NULL);	 
 insert into Client values (41,'BELKACEMI','Hocine',NULL);	 
 insert into Client values (42,'BELKOUT','Tayeb',NULL);	 
 insert into Client values (43,'RAHALI','Ahcene',NULL);	 
 insert into Client values (44,'FERAOUN','Houria',NULL);	 
 insert into Client values (45,'TERKI','Amina',NULL);	 
 insert into Client values (46,'CHAOUI','Farid',NULL);	 
 insert into Client values (47,'BENDALI','Hacine',NULL);	 
 insert into Client values (48,'CHAKER','Nadia',NULL);  
 insert into Client values (49,'BELHAMIDI','Mustapha',NULL);  
 insert into Client values (50,'BELKACEMI','Hocine',NULL);  
 insert into Client values (51,'BELKOUT','Tayeb',NULL);  
 insert into Client values (52,'RAHALI','Ahcene',NULL);  
 insert into Client values (53,'FERAOUN','Houria',NULL);  
 insert into Client values (54,'TERKI','Amina',NULL);  
 insert into Client values (55,'CHAOUI','Farid',NULL);  
 insert into Client values (56,'BENDALI','Hacine',NULL);  
 insert into Client values (57,'CHAKER','Nadia',NULL);  
 insert into Client values (58,'BOULARAS','Fatima',NULL);  
 insert into Client values (59,'IGOUDJIL','Redouane',NULL);  
 insert into Client values (60,'GHEZALI','Lakhdar',NULL);  
 insert into Client values (61,'KOULA','Brahim',NULL);  
 insert into Client values (62,'BELAID','Layach',NULL);  
 insert into Client values (63,'CHALABI','Mourad',NULL);  
 insert into Client values (64,'MOHAMMEDI','Mustapha',NULL); 
 insert into Client values (65,'FEKAR','Abdelaziz',NULL);  
 insert into Client values (66,'SAIDOUNI','Wafa',NULL);  
 insert into Client values (67,'Yalaoui','Lamia',NULL);  
 insert into Client values (68,'AYATA','Samia',NULL);  
 insert into Client values (69,'TEBIBEL','Nabila',NULL);  
--Chambre
insert into Chambre values (1,2,1,'simple',4500); 
insert into Chambre values (1,4,0,'autre',13000);
insert into Chambre values (1,5,0,'triple',7000); 
insert into Chambre values (1,6,1,'double',6000); 
insert into Chambre values (1,9,1,'simple',3100);
insert into Chambre values (1,11,0,'simple',7800); 
insert into Chambre values (2,2,1,'simple',4800);
insert into Chambre values (2,5,1,'simple',4000);
insert into Chambre values (2,6,1,'double',6000); 
insert into Chambre values (2,9,1,'simple',3100);
insert into Chambre values (2,11,0,'simple',7800);
insert into Chambre values (3,2,1,'double',7100);
insert into Chambre values (3,5,1,'double',5500);
insert into Chambre values (3,6,1,'double',6000);  
insert into Chambre values (3,9,1,'simple',3200);
insert into Chambre values (3,11,0,'simple',7800);
insert into Chambre values (4,2,1,'simple',5400);
insert into Chambre values (4,6,2,'double',6200);
insert into Chambre values (4,9,2,'simple',3200);
insert into Chambre values (4,11,0,'simple',7800);
insert into Chambre values (5,2,2,'double',8600);
insert into Chambre values (5,6,2,'double',6200);
insert into Chambre values (5,9,2,'simple',3200);
insert into Chambre values (5,11,0,'simple',7800);
insert into Chambre values (6,2,2,'simple',5800);
insert into Chambre values (6,6,2,'double',6200);
insert into Chambre values (6,9,2,'double',4800);
insert into Chambre values (6,11,0,'simple',7800);
insert into Chambre values (7,2,2,'simple',5800);
insert into Chambre values (7,11,0,'simple',7800);
insert into Chambre values (8,2,2,'double',8600);
insert into Chambre values (8,11,0,'simple',7800);
insert into Chambre values (9,2,3,'suite',16000);
insert into Chambre values (9,11,0,'simple',7800);
insert into Chambre values (10,1,1,'simple',7100);
insert into Chambre values (10,2,3,'suite',16500);
insert into Chambre values (10,7,1,'simple',3100);
insert into Chambre values (10,11,0,'simple',7800);
insert into Chambre values (11,1,1,'simple',7100);
insert into Chambre values (11,4,1,'simple',8400);
insert into Chambre values (11,7,1,'simple',3100);
insert into Chambre values (11,11,0,'simple',7800); 
insert into Chambre values (12,1,1,'double',8800);
insert into Chambre values (12,4,1,'simple',8400);
insert into Chambre values (12,7,1,'double',4200);
insert into Chambre values (12,11,0,'double',9100);
insert into Chambre values (13,1,1,'simple',6200);
insert into Chambre values (13,4,1,'simple',8600);
insert into Chambre values (13,11,0,'double',9100); 
insert into Chambre values (14,4,1,'simple',9000);
insert into Chambre values (14,11,1,'double',9100);
insert into Chambre values (15,11,1,'double',9100);
insert into Chambre values (16,11,1,'simple',7700);
insert into Chambre values (17,11,1,'simple',7700); 
insert into Chambre values (18,11,1,'simple',7700);
insert into Chambre values (19,11,1,'simple',7700); 
insert into Chambre values (20,1,2,'double',9000);
insert into Chambre values (20,7,2,'simple',3100);

insert into Chambre values (20,11,1,'simple',7700);
insert into Chambre values (21,1,2,'simple',6800);
insert into Chambre values (21,4,2,'double',12000);
insert into Chambre values (21,7,2,'simple',3100);
insert into Chambre values (21,11,1,'simple',7500);
insert into Chambre values (22,1,2,'simple',6800);
insert into Chambre values (22,4,2,'double',13000);
insert into Chambre values (22,7,2,'double',4200);
insert into Chambre values (22,11,1,'simple',7500);
insert into Chambre values (23,1,2,'double',8900);
insert into Chambre values (23,11,1,'simple',7500);
insert into Chambre values (24,11,1,'double',8000);
insert into Chambre values (25,11,1,'double',8000);
insert into Chambre values (26,11,1,'double',8000);
insert into Chambre values (27,11,2,'triple',10900);
insert into Chambre values (28,11,2,'triple',10900);
insert into Chambre values (29,11,2,'simple',7200);
insert into Chambre values (30,7,3,'simple',3100);
insert into Chambre values (30,11,2,'simple',7200);
insert into Chambre values (31,4,3,'triple',14500);
insert into Chambre values (31,7,3,'simple',3100);
insert into Chambre values (31,11,2,'simple',7200);
insert into Chambre values (32,4,3,'simple',9000);
insert into Chambre values (32,7,3,'double',4200);
insert into Chambre values (32,11,2,'simple',7200);
insert into Chambre values (40,7,4,'simple',2000);
insert into Chambre values (41,7,4,'simple',2000);
insert into Chambre values (42,7,4,'simple',2000);
insert into Chambre values (43,7,4,'simple',1800);
insert into Chambre values (44,7,4,'simple',1800);
insert into Chambre values (100,8,1,'simple',2900);
insert into Chambre values (100,10,1,'double',9700);
insert into Chambre values (101,3,1,'simple',3200);
insert into Chambre values (101,8,1,'simple',2900);
insert into Chambre values (101,10,1,'double',11000);
insert into Chambre values (101,12,1,'double',13000);
insert into Chambre values (102,3,1,'simple',3200);

insert into Chambre values (20,11,1,'simple',7700);
insert into Chambre values (21,1,2,'simple',6800);
insert into Chambre values (21,4,2,'double',12000);
insert into Chambre values (21,7,2,'simple',3100);
insert into Chambre values (21,11,1,'simple',7500);
insert into Chambre values (22,1,2,'simple',6800);
insert into Chambre values (22,4,2,'double',13000);
insert into Chambre values (22,7,2,'double',4200);
insert into Chambre values (22,11,1,'simple',7500);
insert into Chambre values (23,1,2,'double',8900);
insert into Chambre values (23,11,1,'simple',7500);
insert into Chambre values (24,11,1,'double',8000);
insert into Chambre values (25,11,1,'double',8000);
insert into Chambre values (26,11,1,'double',8000);
insert into Chambre values (27,11,2,'triple',10900);
insert into Chambre values (28,11,2,'triple',10900);
insert into Chambre values (29,11,2,'simple',7200);
insert into Chambre values (30,7,3,'simple',3100);
insert into Chambre values (30,11,2,'simple',7200);
insert into Chambre values (31,4,3,'triple',14500);
insert into Chambre values (31,7,3,'simple',3100);
insert into Chambre values (31,11,2,'simple',7200);
insert into Chambre values (32,4,3,'simple',9000);
insert into Chambre values (32,7,3,'double',4200);
insert into Chambre values (32,11,2,'simple',7200);
insert into Chambre values (40,7,4,'simple',2000);
insert into Chambre values (41,7,4,'simple',2000);
insert into Chambre values (42,7,4,'simple',2000);
insert into Chambre values (43,7,4,'simple',1800);
insert into Chambre values (44,7,4,'simple',1800);
insert into Chambre values (100,8,1,'simple',2900);
insert into Chambre values (100,10,1,'double',9700);
insert into Chambre values (101,3,1,'simple',3200);
insert into Chambre values (101,8,1,'simple',2900);
insert into Chambre values (101,10,1,'double',11000);
insert into Chambre values (101,12,1,'double',13000);
insert into Chambre values (102,3,1,'simple',3200);
insert into Chambre values (102,8,1,'simple',2800);
insert into Chambre values (102,12,1,'double',13000);
insert into Chambre values (103,3,1,'simple',3300);
insert into Chambre values (103,12,1,'double',13000);
insert into Chambre values (104,12,1,'double',13000);
insert into Chambre values (105,12,1,'double',13000);
insert into Chambre values (106,12,1,'double',14500);
insert into Chambre values (107,12,1,'double',14500);
insert into Chambre values (200,8,2,'simple',2800);
insert into Chambre values (200,10,2,'double',9700);
insert into Chambre values (201,3,2,'simple',3200);
insert into Chambre values (201,8,2,'simple',2900);
insert into Chambre values (201,10,2,'double',9700);
insert into Chambre values (201,12,2,'double',14500);
insert into Chambre values (202,3,2,'simple',3200);
insert into Chambre values (202,8,2,'simple',2900);
insert into Chambre values (202,10,2,'triple',14100);
insert into Chambre values (202,12,2,'double',14500);
insert into Chambre values (203,3,2,'simple',3300);
insert into Chambre values (203,12,2,'double',11800);
insert into Chambre values (204,12,2,'double',11800);
insert into Chambre values (205,12,2,'double',13000);
insert into Chambre values (206,12,2,'double',14500);
insert into Chambre values (207,12,2,'double',14500);
insert into Chambre values (300,8,3,'simple',3000);
insert into Chambre values (301,3,3,'simple',3400);
insert into Chambre values (301,8,3,'simple',3100);
insert into Chambre values (301,12,3,'suite',19500);
insert into Chambre values (302,3,3,'simple',3400);
insert into Chambre values (302,8,3,'double',3700);
insert into Chambre values (302,12,3,'suite',19500);
insert into Chambre values (303,3,3,'simple',3400);
insert into Chambre values (303,12,3,'suite',19500);
insert into Chambre values (401,3,4,'double',4200);
insert into Chambre values (401,8,4,'double',3700);
insert into Chambre values (402,3,4,'double',4200);
insert into Chambre values (402,8,4,'simple',2000);
insert into Reservation values (1,5,to_date('2016-05-11','yyyy-mm-dd'),to_date('2016-05-05','yyyy-mm-dd'),1);
insert into Reservation values (2,5,to_date('2016-04-11','yyyy-mm-dd'),to_date('2016-04-18','yyyy-mm-dd'),2);
insert into Reservation values (6,5,to_date('2016-04-05','yyyy-mm-dd'),to_date('2016-04-06','yyyy-mm-dd'),2);
insert into Reservation values (6,7,to_date('2016-04-27','yyyy-mm-dd'),to_date('2016-05-01','yyyy-mm-dd'),30);
insert into Reservation values (6,10,to_date('2016-06-11','yyyy-mm-dd'),to_date('2016-06-14','yyyy-mm-dd'),100);
insert into Reservation values (13,6,to_date('2016-05-02','yyyy-mm-dd'),to_date('2016-05-10','yyyy-mm-dd'),2);
insert into Reservation values (14,6,to_date('2016-04-28','yyyy-mm-dd'),to_date('2016-05-01','yyyy-mm-dd'),2);
insert into Reservation values (14,4,to_date('2016-05-12','yyyy-mm-dd'),to_date('2016-05-13','yyyy-mm-dd'),21);
insert into Reservation values (23,6,to_date('2016-05-04','yyyy-mm-dd'),to_date('2016-05-09','yyyy-mm-dd'),1);
insert into Reservation values (28,8,to_date('2016-04-30','yyyy-mm-dd'),to_date('2016-05-03','yyyy-mm-dd'),100);
insert into Reservation values (28,9,to_date('2016-04-13','yyyy-mm-dd'),to_date('2016-04-14','yyyy-mm-dd'),3);
insert into Reservation values (16,8,to_date('2016-05-01','yyyy-mm-dd'),to_date('2016-05-03','yyyy-mm-dd'),301);
insert into Reservation values (20,9,to_date('2016-05-03','yyyy-mm-dd'),to_date('2016-05-20','yyyy-mm-dd'),2);
insert into Reservation values (15,9,to_date('2016-04-15','yyyy-mm-dd'),to_date('2016-04-20','yyyy-mm-dd'),3);
insert into Reservation values (12,11,to_date('2016-05-09','yyyy-mm-dd'),to_date('2016-05-10','yyyy-mm-dd'),8);
insert into Reservation values (3,11,to_date('2016-04-06','yyyy-mm-dd'),to_date('2016-04-08','yyyy-mm-dd'),9);
insert into Reservation values (7,11,to_date('2016-05-07','yyyy-mm-dd'),to_date('2006-05-12','yyyy-mm-dd'),7);
insert into Reservation values (47,11,to_date('2016-04-04','yyyy-mm-dd'),to_date('2016-04-08','yyyy-mm-dd'),20);
insert into Reservation values (44,11,to_date('2016-04-07','yyyy-mm-dd'),to_date('2016-05-07','yyyy-mm-dd'),5);
insert into Reservation values (40,11,to_date('2016-04-11','yyyy-mm-dd'),to_date('2016-04-14','yyyy-mm-dd'),9);
insert into Reservation values (40,2,to_date('2016-05-01','yyyy-mm-dd'),to_date('2016-05-05','yyyy-mm-dd'),8);
insert into Reservation values (40,1,to_date('2016-05-09','yyyy-mm-dd'),to_date('2016-05-13','yyyy-mm-dd'),23);
insert into Reservation values (22,11,to_date('2016-04-04','yyyy-mm-dd'),to_date('2016-04-05','yyyy-mm-dd'),25);
insert into Reservation values (26,11,to_date('2016-04-22','yyyy-mm-dd'),to_date('2016-04-26','yyyy-mm-dd'),25);
insert into Reservation values (29,11,to_date('2016-04-04','yyyy-mm-dd'),to_date('2016-04-08','yyyy-mm-dd'),1);
insert into Reservation values (29,12,to_date('2016-05-04','yyyy-mm-dd'),to_date('2016-05-09','yyyy-mm-dd'),205);
insert into Reservation values (35,12,to_date('2016-04-04','yyyy-mm-dd'),to_date('2016-05-06','yyyy-mm-dd'),205);
insert into Reservation values (35,5,to_date('2016-05-17','yyyy-mm-dd'),to_date('2016-05-23','yyyy-mm-dd'),2);
insert into Reservation values (35,6,to_date('2016-05-27','yyyy-mm-dd'),to_date('2016-06-02','yyyy-mm-dd'),2);
insert into Reservation values (37,12,to_date('2016-05-11','yyyy-mm-dd'),to_date('2016-05-18','yyyy-mm-dd'),202);
/****************************************************/

update hotel set Etoiles=5 where nom='El Mountazah Annaba';
update chambre set prixnuit = prixnuit+1000 where numhotel in (select numhotel from hotel where etoiles=4);
select nom,ville from hotel ;
/*********************************************/
create view v (hotel,nb) as 
							(select numhotel,count(*) from reservation group by numhotel);
select hotel from v  where nb!=0;

select nom, numhotel from hotel where numhotel in (select numhotel from reservation);

Select distinct Nom from HOTEL h, RESERVATION r where h.NUMHOTEL=r.NUMHOTEL;
/********************************************/
select numclient from reservation where numchambre in (select numchambre from chambre where etage=1 ) minus 
select numclient from reservation where numchambre in (select numchambre from chambre where etage!=1 );
/*********************************************/
create view v1 (numhotel,prix) as 
							(select numhotel, prixnuit from chambre where typechambre='suite' group by numhotel, prixnuit);
							
select hotel.nom, hotel.ville, v1.prix from hotel, v1 where hotel.numhotel in (select v1.numhotel from v1);
/**********************************************/
			create view res_type (hotel,typechambre,nb_reservation) as 
			(select c.numhotel ,c.typechambre,count(r.numchambre) 
			 from chambre c , reservation r 
			 where c.numchambre = r.numchambre 
			 group by (c.numhotel , c.typechambre)
			 );
select v.typechambre 
from res_type v, hotel h 
where v.hotel= h.numhotel 
and h.ville='Alger' 
and  v.nb_reservation = (select max(nb_reservation) from res_type);
/* ************************************************************************************************* */
create tablespace tp5_tbs datafile 'C:\Users\im\Desktop\M1 SII\ASGBD\TP5\tp5_tbs.dat' size 100M autoextend on online;
create temporary tablespace tp5_temp tempfile 'C:\Users\im\Desktop\M1 SII\ASGBD\TP5\tp5_temp.dat' size 100M autoextend on;
create user tp5 identified by tp51234 default tablespace tp5_tbs temporary tablespace tp5_temp;
create user rougab identified by imene default tablespace tp_tbs temporary tablespace tp_temp;
grant all privileges to rougab;
grant create session to adminhotel;
alter user adminhotel quota unlimited on tp2_tbs;
grant create table, create user to adminhotel;
/* create table */
grant select on chambre to adminhotel;
Select * from  rougab.CHAMBRE ; 

update rougab.chambre 
set prixnuit=prixnuit+1000 
where  chambre.numhotel in 
(select hotel.numhotel 
from rougab.hotel 
where nom='Renaissance'
);
grant select on HOTEL to adminhotel;
grant update on CHAMBRE to adminhotel;
create index chambretype_ix on rougab.chambre(typechambre);
grant index on chambre to adminhotel;
revoke index on chambre from adminhotel;

create profile hotel_profil
LIMIT
SESSIONS_PER_USER 3
CPU_PER_CALL 3500
CONNECT_TIME 90
LOGICAL_READS_PER_CALL 1200
PRIVATE_SGA 25K
IDLE_TIME 30
FAILED_LOGIN_ATTEMPTS 5
PASSWORD_LIFE_TIME 50
PASSWORD_REUSE_TIME 40
PASSWORD_REUSE_MAX UNLIMITED
PASSWORD_LOCK_TIME 1/24
PASSWORD_GRACE_TIME 5;
alter user adminhotel profile hotel_profil;

create role GESTIONNAIRE_DE_RESERVATIONS ;
grant select on CHAMBRE to GESTIONNAIRE_DE_RESERVATIONS;
grant select on CLIENT to GESTIONNAIRE_DE_RESERVATIONS;
grant SELECT on HOTEL to GESTIONNAIRE_DE_RESERVATIONS;
grant update on RESERVATION to GESTIONNAIRE_DE_RESERVATIONS;

grant GESTIONNAIRE_DE_RESERVATIONS to adminhotel;

update rougab.reservation set DateDepart='20/04/2016' where numhotel=5 and numclient=2 and numchambre=2;
/* ******************************************************************************************************************************* */

/* ********tp3******************** */
/*1*/ 
SELECT * FROM DICT;
DESC DICT;
SELECT COUNT(*) FROM DICT;
/*2*/
DESC ALL_TAB_COLUMNS;
DESC USER_USERS;
DESC ALL_CONSTRAINTS;
DESC USET_TAB_PRIVS;
/*3*/
SELECT USER FROM USER_USERS;
/*4*/
DESC ALL_TAB_COLUMNS; 
DESC USER_TAB_COLUMNS;
/*CONNECTE WITH TP1'S USER */
/*5*/
SELECT DISTINCT TABLE_NAME FROM ALL_TABLES;
SELECT * FROM USER_TABLES ;
SELECT TABLE_NAME, TABLESPACE_NAME CLUSTER_NAME FROM USER_TABLES ;
/*6*/
SELECT DISTINCT TABLE_NAME FROM ALL_TABLES WHERE OWNER='SYSTEM';
SELECT DISTINCT TABLE_NAME FROM ALL_TABLES WHERE OWNER='ADMINHOTEL';
/*7*/
SELECT COLUMN_NAME, DATA_TYPE, DATA_LENGTH FROM USER_TAB_COLUMNS WHERE TABLE_NAME='RESERVATION';
SELECT COLUMN_NAME FROM USER_TAB_COLUMNS WHERE TABLE_NAME='CLIENT';
/*8*/
SELECT CONSTRAINT_NAME, FROM USER_CONSTRAINTS WHERE TABLE_NAME='RESERVATION';
/*9*/
SELECT * FROM USER_CONSTRAINTS ;
SELECT TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE FROM USER_CONSTRAINTS;
/*10*/
/* LES ATTROBUTS*/
SELECT COLUMN_NAME, DATA_TYPE, DATA_LENGTH 
FROM USER_TAB_COLUMNS 
WHERE TABLE_NAME='RESERVATION';
/*LES CONTRAINTES*/
SELECT U.CONSTRAINT_NAME, U.CONSTRAINT_TYPE, A.COLUMN_NAME 
FROM USER_CONSTRAINTS U, ALL_CONS_COLUMNS A 
WHERE A.TABLE_NAME='RESERVATION' 
AND U.CONSTRAINT_NAME=A.CONSTRAINT_NAME;
/*11*/
SELECT PRIVILEGE, TABLE_NAME FROM USER_TAB_PRIVS WHERE GRANTEE='ADMINHOTEL';
/*12*/
/*CONNECTER AUTANT QUE ADMINHOTEL*/
SELECT GRANTED_ROLE FROM USER_ROLE_PRIVS;
/*13*/
SELECT * FROM USER_OBJECTS;
SELECT OBJECT_NAME FROM USER_OBJECTS;
SELECT OBJECT_NAME FROM ALL_OBJECTS WHERE OWNER='ADMINHOTEL'; /* SI CONNECTE AVEC UN AUTRE USER*/
/*14*/
SELECT OWNER FROM ALL_TABLES WHERE TABLE_NAME='RESERVATION';
/*15*/
SELECT BYTES/1024 AS SIZE_TABLE_KO FROM USER_SEGMENTS WHERE SEGMENT_NAME='RESERVATION';

/* **************************TP4 ***************************************************** */


