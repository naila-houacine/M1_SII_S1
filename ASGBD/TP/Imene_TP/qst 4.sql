/* *****************4 ***************************************************/
--4.1******************
Alter table Hotel add Total_Gains number(10);
--Initialisation
update hotel set total_gains=0;
--4.2********************
Create or replace trigger  TOTAL_GAINS
After insert on reservation
For each row
DECLARE
prix_nuit number;
duree_reservation number;   
montant_reservation number;    
BEGIN
-- calcul de la durée de la nouvelle reservation
duree_reservation := :new.datedepart - :new.datearrivee;
dbms_output.put_line('Durée de la reservation: '||duree_reservation);

-- réccupération du prix de la chambre reservée 
select prixnuit 
into prix_nuit 
from chambre 
where numchambre = :new.numchambre 
and numhotel = :new.numhotel ;
dbms_output.put_line('Prix de la chambre reservé: '||prix_nuit);

-- calcul du prix total (motant) de la reservation 
montant_reservation := duree_reservation * prix_nuit;
dbms_output.put_line('Montant total: '||montant_reservation);

-- Mise à jour du total de gains dans la table hotel
update hotel
set total_gains =total_gains + montant_reservation 
where numHotel = :new.numHotel;
dbms_output.put_line('Mise à jour du gain total effectuée ');

END;
/

/* ******************test***************/
Insert into Reservation values (4,6,'10/02/2016','20/02/2016',1); 

select * from hotel;