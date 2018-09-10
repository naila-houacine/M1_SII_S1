#include <stdlib.h>
#include <stdio.h>
#include <time.h>

int main()
{

	long int i,j,prem ;
	clock_t deb,fin;
	double total;

	long int tab[]={1000003, 2000003,	4000037,	8000009,	16000057,	32000011,	64000031,
	128000003,	256000001,	512000009,	1024000009,	2048000011};



for(j=0 ; j<12 ; j++)
{

	deb = clock();
	i=2;
	prem = 1;

	while( i <= tab[j]-1 && prem == 1){

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
	printf("temps d'exe = %lf \n",total);

}

return 0;

}

/**


Le nombre saisie : 1000003 est premier!
temps d'exe = 0.009000
Le nombre saisie : 2000003 est premier!
temps d'exe = 0.009000
Le nombre saisie : 4000037 est premier!
temps d'exe = 0.013000
Le nombre saisie : 8000009 est premier!
temps d'exe = 0.026000
Le nombre saisie : 16000057 est premier!
temps d'exe = 0.051000
Le nombre saisie : 32000011 est premier!
temps d'exe = 0.102000
Le nombre saisie : 64000031 est premier!
temps d'exe = 0.205000
Le nombre saisie : 128000003 est premier!
temps d'exe = 0.411000
Le nombre saisie : 256000001 est premier!
temps d'exe = 0.820000
Le nombre saisie : 512000009 est premier!
temps d'exe = 1.642000
Le nombre saisie : 1024000009 est premier!
temps d'exe = 3.289000
Le nombre saisie : 2048000011 est premier!
temps d'exe = 6.576000

**/
