                #include<stdio.h>
				#include<stdlib.h>
				#include<time.h>
				#define NBR 50000
				//100000 , 200000 , 400000 , 800000 , 3200000 , 6400000 , 12800000 , 25600000 , 1024000000 , 2048000000
                int nbInputs = 12;
				long int inputs[] = {50000 , 100000 , 200000 , 400000 , 800000 , 3200000 , 6400000 , 12800000 , 25600000 , 1024000000 , 2048000000};
                //long int inputs[] = {5,10,20,40,80,160,320,640,1280,2560,10240,20480};



				void permuter(long int tableau[], long int a,long int b)
				{
					long int temp = tableau[a];
					tableau[a] = tableau[b];
					tableau[b] = temp;
				}

				/********************************************************************************************/

				void quickSort(long int tableau[], long int debut, long int fin)
				{
					long int gauche = debut-1;
					long int droite = fin+1;
					const long int pivot = tableau[debut];

					/* Si le tableau est de longueur nulle, il n'y a rien à faire. */
					if(debut >= fin)
						return;

					/* Sinon, on parcourt le tableau, une fois de droite à gauche, et une
					   autre de gauche à droite, à la recherche d'éléments mal placés,
					   que l'on permute. Si les deux parcours se croisent, on arrête. */
					while(1)
					{
						do droite--; while(tableau[droite] > pivot);
						do gauche++; while(tableau[gauche] < pivot);

						if(gauche < droite)
							permuter(tableau, gauche, droite);
						else break;
					}

					/* Maintenant, tous les éléments inférieurs au pivot sont avant ceux
					   supérieurs au pivot. On a donc deux groupes de cases à trier. On utilise
					   pour cela... la méthode quickSort elle-même ! */
					quickSort(tableau, debut, droite);
					quickSort(tableau, droite+1, fin);
				}

				/********************************************************************************************/



				double bestTime(long int n) {
					long int *array = malloc(n*sizeof(long int));
					long int i;
					for (i = 0; i < n; i++)
					{
						array[i] = i;
					}
					clock_t start = clock();
					quickSort(array, 0, n);
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
					quickSort(array, 0, n);
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
					quickSort(array, 0, n);
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

