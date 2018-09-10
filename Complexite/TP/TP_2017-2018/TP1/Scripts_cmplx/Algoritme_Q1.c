 
 Algorithme_Somme_Iteratif_tant_que
 
 VAR
 i,N,S : entier;				//3 mots mémoire
 
 Debut
	ecrire("Donner N = ");		//1 mot mémoire
	lire(N);					//1 mot mémoire
	
	S = 0;						//1 mot mémoire
	i = 1;						//1 mot mémoire
	
	tant que(i <= N)			//1 mot mémoire
	  faire
		S = S + i;				//2 mots mémoire
		i = i + 1;				//2 mots mémoire
	  fait;
	  
	ecrire("La somme = ",S);	//1 mot mémoire
	
 Fin.
 
  Algorithme_Somme_Iteratif_pour
 
 VAR
 i,N,S : entier;				//3 mots mémoire
 
 Debut
	ecrire("Donner N = ");		//1 mot mémoire
	lire(N);					//1 mot mémoire
	
	S = 0;						//1 mot mémoire
	
	pour(i=1 ; i <= N ; i++)	//4 mots mémoire
	  faire
		S = S + i;				//2 mots mémoire
	  fait;
	  
	ecrire("La somme = ",S);	//1 mot mémoire
	
 Fin.
 
 
  Algorithme_Somme_Iteratif_répéter_jusqu'a
 
 VAR
 i,N,S : entier;				//3 mots mémoire
 
 Debut
	ecrire("Donner N = ");		//1 mot mémoire
	lire(N);					//1 mot mémoire
	
	S = 0;						//1 mot mémoire
	i = 1;						//1 mot mémoire
	
	répéter
		S = S + i;				//2 mots mémoire
		i = i + 1;				//2 mots mémoire
	  jusqu'à(i > N);			//1 mot mémoire
	  
	ecrire("La somme = ",S);	//1 mot mémoire
	
 Fin.