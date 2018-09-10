#include <stdio.h>
#include <stdlib.h>
#include <time.h>

 int main()
 {

	long int i,N,S;

   	clock_t start_t, end_t;
   	double total_t;


	printf("Donner N = ");
	scanf("%Ld",&N);

    start_t = clock();

	S=0; i=1;

	do
	{
		S = S + i;
		i = i + 1;
	} while(i <= N);

   	end_t = clock();
	printf("La somme S = %Ld\n",S);

   	total_t = (double) (end_t - start_t) / CLOCKS_PER_SEC;
	printf("pour %ld Iteration le programme prends %lf\n", N, total_t);

	return 0;
}
