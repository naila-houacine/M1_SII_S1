#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <pthread.h>

int nbThreads = 10;
int N;

void* verifier(void* input) {
	int *pointer = (int *) input;
	int threadNumber = *pointer;
	int start = 2 + threadNumber * N / nbThreads;
	int end = 2 + (threadNumber + 1) * N / nbThreads;
	printf("\n*************** Debut Thread %d **********************\n", threadNumber);
	printf("Threan number %d, Je vais vérfire de %d ----> %d\n", threadNumber, start, end);
	int prem = 1;
	while(start < end && prem){
		if(N % start == 0)
			{
				printf("Diviseur trouvé %d / %d = %d\n", N, start, N %start);
				prem = 0;
			}
		else start = start + 1;
	}
	printf("Thread number %d, prem = %d\n", threadNumber, prem);
	printf("\n*************** Fin Thread %d **********************\n", threadNumber);
	pthread_exit((void*) &prem);
}

int main(int argc, char const *argv[])
{
	printf("donner la valeur de N = ");
	scanf("%d",&N);
	pthread_t threads[nbThreads];
	for (int i = 0; i < nbThreads; i++) {
		int *threadNumber = malloc(sizeof(int));
		*threadNumber = i;
		printf("Creation de thread %d\n", i, *threadNumber);
		pthread_create(&threads[i], NULL, (void*) verifier, (void*) threadNumber);
	}


	for (int i = 0; i < nbThreads; i++) {
		int* result = malloc(sizeof(int));
		pthread_join(threads[i], (void**) result);
		printf("Le thread %d return %d\n", i, *result);
		if (! *result) {
			printf("result = %d\n", *result);
        	printf("Le nombre saisi : %d n'est pas premier! \n",N);	
        	return 0;
		}
	}
	printf("Le nombre saisi : %d est premier! \n",N);	
	return 0;
}