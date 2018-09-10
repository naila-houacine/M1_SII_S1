 
Procedure_Somme_Récursif(N , S : entier)
 
 VAR
 
 Debut									
 
	Si( N <= 0)										//1 mot mémoire
		Alors ecrire("La Somme S = ",S);			//1 mot mémoire
		Sinon   S = S + N;							//2 mots mémoire
				Algorithme_Somme_Récursif(N - 1,S);	//2 mots mémoire
	FinSi;
	
 Fin.
 
 
 Algorithme_Somme_Récursif()
 
 VAR
 
 Debut
	N: entier;										//1 mot mémoire

    ecrire("Donner N = ");							//1 mot mémoire
	lire(N);										//1 mot mémoire

	Procedure_Somme_Récursif(N , 0);				//1 mot mémoire
 Fin.