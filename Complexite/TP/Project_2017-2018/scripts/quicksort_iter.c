#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define NBR 100000
//50000 , 100000 , 200000 , 400000 , 800000 , 3200000 , 6400000 , 12800000 , 25600000 , 1024000000 , 2048000000

int nbInputs = 12;
long int inputs[] = {50000 , 100000 , 200000 , 400000 , 800000 , 3200000 , 6400000 , 12800000 , 25600000 , 1024000000 , 2048000000};



void permuter(long int* a,long int* b)
{
	long int temp = *a;
	*a = *b;
	*b = temp;
}

long int Partition(long int* data, long int left, long int right)
{
	long int x = data[right];
	long int i = (left - 1);
	long int j;

	for ( j = left; j <= right - 1; ++j)
	{
		if (data[j] <= x)
		{
			++i;
			permuter(&data[i], &data[j]);
		}
	}

	permuter(&data[i + 1], &data[right]);

	return (i + 1);
}

void quickSort(long int* data, long int count) {
	long int startIndex = 0;
	long int endIndex = count - 1;
	long int top = -1;
	long int* stack = (long int*)malloc(sizeof(long int) * count);

	stack[++top] = startIndex;
	stack[++top] = endIndex;

	while (top >= 0)
	{
		endIndex = stack[top--];
		startIndex = stack[top--];

		long int p = Partition(data, startIndex, endIndex);

		if (p - 1 > startIndex)
		{
			stack[++top] = startIndex;
			stack[++top] = p - 1;
		}

		if (p + 1 < endIndex)
		{
			stack[++top] = p + 1;
			stack[++top] = endIndex;
		}
	}

	free(stack);
}



/********************************************************************************************/


/********************************************************************************************/



double bestTime(long int n) {
	long int *array = malloc(n*sizeof(long int));
	long int i;
	for (i = 0; i < n; i++)
	{
		array[i] = i;
	}
	clock_t start = clock();
	quickSort(array, n);
	clock_t end = clock();

	return (double) (end - start)/CLOCKS_PER_SEC;
}

double worstTime(long int n) {
	long int *array = malloc(n*sizeof(long int));
	long int i;
	for ( i = 0; i < n; i++)
	{
		array[i] = n - i;
	}
	clock_t start = clock();
	quickSort(array, n);
	clock_t end = clock();

	return (double) (end - start)/CLOCKS_PER_SEC;
}

double randomTime(long int n) {
	long int *array = malloc(n*sizeof(long int));
	long int i;
	for ( i = 0; i < n; i++)
	{
		array[i] = (long int) rand()%n;
	}
	clock_t start = clock();
	quickSort(array, n);
	clock_t end = clock();

	return (double) (end - start)/CLOCKS_PER_SEC;
}

void saveResults(double array[], long int n, char* name) {
   long int i;
   FILE * fp;
   fp = fopen ("results","a");
   fprintf(fp, name);
   fprintf(fp, "[");
   for(i = 0;i<n;i++) {
	  fprintf(fp, "%ld ",array[i]);
   }
   fprintf(fp, "]\n");
   fclose (fp);
}



				/********************************************************************************************/



int main(int argc, char const *argv[])
{
	double *worstTimes = malloc(nbInputs*sizeof(double));
	double *bestTimes = malloc(nbInputs*sizeof(double));
	double *randomTimes = malloc(nbInputs*sizeof(double));
	int i;

	for (i = 0; i < nbInputs; i++)
	{
		worstTimes[i] = worstTime(inputs[i]);
		bestTimes[i] = bestTime(inputs[i]);
		randomTimes[i] = randomTime(inputs[i]);

	}

	saveResults(worstTimes,nbInputs, "worst case : ");
	saveResults(bestTimes,nbInputs, "best case : ");
	saveResults(randomTimes,nbInputs, "random case : ");

	return 0;
}


