                #include<stdio.h>
				#include<stdlib.h>
				#include<time.h>
				#define NBR 50000



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

void QuickSortIterative(long int* data, long int count) {
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

				int main(void)
				{
					long int i;
					long int n = NBR;
					clock_t start1,end1,start2,end2,start3,end3;
					double total1,total2,total3;

					long int tab1[n]; //dans l'ordre
					long int tab2[n]; //dans l'ordre invers
					long int tab3[n]; //aléatoire

					for( i = 0 ; i < NBR ; i++)
					{
						tab1[i] = i;
						tab2[i] = n;
						tab3[i] = (int) rand()%NBR;
						n--;
					}

					start1 = clock();
						QuickSortIterative(tab1, NBR);
					end1 = clock();

					total1 = (double) (end1 - start1)/CLOCKS_PER_SEC;

                    /**
					for(i = 0; i < NBR; i++)
					{
					printf("%d ", tab1[i]);
					}
					**/


					printf("\n *************************************** \n");
                    printf("temps d'exe tab1 = %lf \n",total1);

					start2 = clock();
						quickSort(tab2, 0, NBR);
					end2 = clock();

					total2 = (double) (end2 - start2)/CLOCKS_PER_SEC;
					printf("temps d'exe tab2 = %lf \n",total2);

                    /**
					for(i = 0; i < NBR; i++)
					{
					printf("%d ", tab2[i]);
					}
                    **/

					printf("\n *************************************** \n");




					start3 = clock();
						quickSort(tab3, 0, NBR);
					end3 = clock();

					total3 = (double) (end3 - start3)/CLOCKS_PER_SEC;
					printf("temps d'exe tab3 = %lf \n",total3);

                    /**
					for(i = 0; i < NBR; i++)
					{
					printf("%d ", tab3[i]);
					}

					printf("\n *************************************** \n");

					**/

					putchar('\n');



					return 0;
				}

/**
NBR = 50000 => temps d'exe = 14.776000

**/
