#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

void SommeRecursive(long int N, long int S)
{
	if(N > 0)
	{
		S = S + N;
		SommeRecursive(N - 1, S);
	}
	else{
        return;
	}

}


int main()
{

	long int i,j,N,S;
	clock_t start_t, end_t;
    double total_t;

	long int tab[14]={pow(10,6),2*pow(10,6),pow(10,7),2*pow(10,7),pow(10,8),2*pow(10,8),
	pow(10,9),2*pow(10,9),pow(10,10),2*pow(10,10),pow(10,11),2*pow(10,11),pow(10,12),2*pow(10,12)};

	printf("L'algorithme recursif\n");

	for(j=0 ; j < 14 ; j++) {

        start_t = clock();

        S=0; i=1;

        SommeRecursive(tab[(long int) j],S);

        end_t = clock();

        printf("La somme S = %lf \n",S);
        total_t = (double) (end_t - start_t) / CLOCKS_PER_SEC;
        printf("Pour N = %lf le programme prend %lf\n\n", tab[(long int) j], total_t);
    }


    return 0;
}
