 /*
 #include<stdio.h>
 #include<stdlib.h>

 int main()
 {
	long int i,N,S;

	printf("Donner N = ");
	scanf("%Ld",&N);

	S=0;
	i=1;

	while(i <= N)
	{
		S = S + i;
		i = i + 1;
	}

	printf("La somme S = %Ld",S);

	return 0;
 }*/

/**************************************************/

 #include<stdio.h>
 #include<stdlib.h>

 int main()
 {
	long int i,N,S;

	printf("Donner N = ");
	scanf("%Ld",&N);

	S=0; i=1;

	Do
	{
		S = S + i;
		i = i + 1;
	}while(i > N)

	printf("La somme S = %Ld",S);
	return 0;
 }

 /***********************************************/

/*
 #include<stdio.h>
 #include<stdlib.h>

 int main()
 {
	long int i,N,S;

	printf("Donner N = ");
	scanf("%Ld",&N);

	S=0;

	for(i=1 ; i <= N ; i++)
	{
		S = S + i;
	}

	printf("La somme S = %Ld",S);
	return 0;
 }
*/
