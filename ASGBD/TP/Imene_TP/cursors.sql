DECLARE      
cursor cr is select  nom from hotel where ville='Alger';     	
 c_rec cr%rowtype;     						
i binary_integer; 
vide EXCEPTION;							
BEGIN 
    i := 1;      
    for c_rec in cr loop  						
     	dbms_output.put_line('Lhôtel N°' ||i|| 'est' || c_rec.nom);
     	i := i+1; 
    	exit when cr%notfound;      
    end loop;
if(i<2) then RAISE vide;
else
i := i-1; 
dbms_output.put_line('La ville dAlger contient' ||i|| 'est hôtels');
end if;
EXCEPTION     WHEN vide THEN 
      dbms_output.put_line('la ville dAlger ne contient aucun hôtel');
END;
/* ********************************************* */
DECLARE      
cursor cr is select  nom, count(*) as a 
from hotel, chambre 
where hotel.numhotel=chambre.numhotel 
group by(hotel.nom,chambre.numhotel);   
  	
c_rec cr%rowtype;     						
i binary_integer; 
vide EXCEPTION;							
BEGIN 
    i := 1;      
    for c_rec in cr loop  						
     	dbms_output.put_line('Lhôtel - ' ||c_rec.nom|| ' - contient ' || c_rec.a || ' chambres.');
     	i := i+1; 
    	exit when cr%notfound;      
    end loop;
EXCEPTION WHEN vide THEN
dbms_output.put_line('Aucune ligne n a été détectée');
END;
/* ----------------------------- */
DECLARE
cursor cr is select nom 
from hotel, chambre 
where hotel.numhotel=chambre.numhotel 
order by nom;

c_rec hotel.nom%type;
c_recnow hotel.nom%type;
i binary_integer;
j binary_integer;
vide EXCEPTION;
BEGIN
i:=0;
open cr;
fetch cr into c_rec;
c_recnow := c_rec;
while cr%found loop
 if(c_rec = c_recnow) then i:=i+1;
 fetch cr into c_rec;
 else 
	j:=i+1;
	dbms_output.put_line('l hotel - '||c_recnow|| ' - contient '||j||' chambres.');
	i:=0;
	fetch cr into c_rec;
	c_recnow := c_rec;
 end if;
end loop;
close cr;
EXCEPTION WHEN vide THEN
dbms_output.put_line('Aucune ligne n a été détectée');
END;

/*  --------------------------------------------------- */
