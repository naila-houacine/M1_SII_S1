#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <math.h>

int main()
{

	long int i,j,prem;
	clock_t deb,fin;
	double total;

	long int tab[]={1000003, 2000003,	4000037,	8000009,	16000057,	32000011,	64000031,
	128000003,	256000001,	512000009,	1024000009,	2048000011};





for(j=0 ; j<12 ; j++)
{

	deb = clock();
	i=2;
	prem = 1;

	while( i <= sqrt(tab[j])-1 && prem == 1){

		if( tab[j]%i == 0)
			prem = 0;
		else
			i = i + 1;
	}

	fin = clock();

	if(prem == 1)
    {
        printf("Le nombre saisie : %ld est premier! \n",tab[j]);
    }
	else{
        printf("Le nombre saisie : %ld n'est pas premier! \n",tab[j]);
	}

	total = (double) (fin - deb)/CLOCKS_PER_SEC;
	printf("temps d'exécution = %lf \n",total);

}

return 0;

}

/**


Le nombre saisie : 1000003 est premier!
temps d'ex├®cution = 0.000000
Le nombre saisie : 2000003 est premier!
temps d'ex├®cution = 0.000000
Le nombre saisie : 4000037 est premier!
temps d'ex├®cution = 0.000000
Le nombre saisie : 8000009 est premier!
temps d'ex├®cution = 0.000000
Le nombre saisie : 16000057 est premier!
temps d'ex├®cution = 0.000000
Le nombre saisie : 32000011 est premier!
temps d'ex├®cution = 0.001000
Le nombre saisie : 64000031 est premier!
temps d'ex├®cution = 0.000000
Le nombre saisie : 128000003 est premier!
temps d'ex├®cution = 0.001000
Le nombre saisie : 256000001 est premier!
temps d'ex├®cution = 0.002000
Le nombre saisie : 512000009 est premier!
temps d'ex├®cution = 0.002000
Le nombre saisie : 1024000009 est premier!
temps d'ex├®cution = 0.002000
Le nombre saisie : 2048000011 est premier!
temps d'ex├®cution = 0.003000

**/
