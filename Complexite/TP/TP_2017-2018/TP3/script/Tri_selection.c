#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include<time.h>

int nbInputs = 4;
long int inputs[] = {50000 , 100000 , 200000 , 400000 , 800000 , 3200000 , 6400000 , 12800000 , 25600000 , 1024000000 , 2048000000};
               
double sortedTime(long int n) {
    
  long int *array = malloc(n*sizeof(long int));
  long int i;
  
  for (i = 0; i < n; i++)
  {
      array[i] = i;
  }
  clock_t start = clock();
  selectionSort(array, n); //replace with your function 
  clock_t end = clock();
  
  return (double) (end - start)/CLOCKS_PER_SEC;
}

double inversedTime(long int n) {
    
  long int *array = malloc(n*sizeof(long int));
  long int i;
  
  for (i = 0; i < n; ++i)
  {
    array[i] = n - i;
  }
  clock_t start = clock();
  selectionSort(array, n); //replace with your function 
  clock_t end = clock();

  return (double) (end - start)/CLOCKS_PER_SEC;
}

double randomTime(long int n) {
    
  long int *array = malloc(n*sizeof(long int));
  long int i;
  
  for (i = 0; i < n; ++i)
  {
    array[i] = (int) rand()%n;
  }
  clock_t start = clock();
  selectionSort(array, n); //replace with your function 
  clock_t end = clock();

  return (double) (end - start)/CLOCKS_PER_SEC;
}



  void saveResults(double array[], long int n, char* name) {

     long int i;
     FILE * fp;
     fp = fopen ("tp3_results","a");
     fprintf(fp, name);
     fprintf(fp, "[");

     for(i = 0;i<n;i++) {
      fprintf(fp, "%lf, ",array[i]);
     }

     fprintf(fp, "]\n");
     fclose (fp);
  }

void selectionSort(long int *t, long int n){
    long int i,j,min,imin;
    for(i=0;i<n-1;i++){
        imin=i;
        for(j=i+1;j<n;j++){
           if(t[imin]>t[j]){
              min=t[j];
              imin= j;
           }
        }
        if(imin != i){
           t[imin]=t[i];
           t[i]=min;
        }
    }
}

int main(int argc, char const *argv[])
  {
  double *inversedTimes = malloc(nbInputs*sizeof(double));
  double *sortedTimes = malloc(nbInputs*sizeof(double));
  double *randomTimes = malloc(nbInputs*sizeof(double));
  int i;

  for (i = 0; i < nbInputs; i++)
  {
    inversedTimes[i] = inversedTime(inputs[i]);
    sortedTimes[i] = sortedTime(inputs[i]);
    randomTimes[i] = randomTime(inputs[i]);
  }

  saveResults(inversedTimes,nbInputs, "inversed = ");
  saveResults(sortedTimes,nbInputs, "sorted = ");
    saveResults(randomTimes,nbInputs, "random = ");

  return 0;
  }
  
  /**
inversed = [5.308000, 21.059000, 87.593000, 342.122000, ]
sorted = [4.813000, 19.649000, 79.942000, 318.696000, ]
random = [5.025000, 20.328000, 81.150000, 292.308000, ]
**/