 #include<stdio.h>
 #include<stdlib.h>

 void SommeRecursive(long int N,long int S)
 {
	if(N <= 0)
	{
		printf("La somme S = %Ld \n",S);
	}else
	{
		S = S + N;
		SommeRecursive(N - 1,S);
	}
 }


int main()
{
    long int N;

    printf("Donner N = ");
	scanf("%Ld",&N);

	SommeRecursive(N,0);

	return 0;
}
