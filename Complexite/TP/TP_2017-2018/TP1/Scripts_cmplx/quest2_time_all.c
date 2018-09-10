#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

 int main()
 {
	double i,j,N,S;
	clock_t start_t, end_t;
    double total_t;
	double tab[14]={pow(10,6),2*pow(10,6),pow(10,7),2*pow(10,7),pow(10,8),2*pow(10,8),
	pow(10,9),2*pow(10,9),pow(10,10),2*pow(10,10),pow(10,11),2*pow(10,11),pow(10,12),2*pow(10,12)};

	printf("L'algorithme itératif avec boucle do .. while \n\n");

	for(j=0 ; j < 14 ; j++) {

        start_t = clock();
    //	printf("Donner N = ");
    //	scanf("%Ld",&N);

        S=0; i=1;

        do
        {
            S = S + i;
            i = i + 1;
        } while(i <= tab[(long int)j+1]);

        end_t = clock();

        printf("La somme S = %lf \n",S);
        total_t = (double) (end_t - start_t) / CLOCKS_PER_SEC;
        printf("pour %lf Iteration le programme prends %lf\n\n", tab[(long int)j], total_t);

    }
	return 0;
}
