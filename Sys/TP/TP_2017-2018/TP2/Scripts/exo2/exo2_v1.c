#include<stdio.h>
#include<unistd.h>
#include<math.h>

#define nb 18446743979220271

int main(void)
{
register unsigned long long sqrt_nb ;
register unsigned long long i 

sqrt_nb = sqrt(nb);

	for(i=2;i<sqrt_nb; i++)

		if (!(nb % i))
		{
			printf(" %llu est un diviseur de %llu \n",i,nb);
			return 0 ;
		}
	
	return 1 ;
}