#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>

int main(int avrgc , char* argv[])
{
	int pid1,i;

	pid1 = fork() ;

	if(pid1 == -1){
		printf("error");
		exit(0);
	}

	if(pid1 == 0){
	//the child is running
	
		printf("I'm the child my pid = %d, my father's pid = %d \n");
		i = execl( "/bin/ls","ls", 0);
		printf("error de l execution du exec !! \n");

	}
	
	//the father is running
	printf("I'm the father my pid = %d and i'm waiting for my children! \n");
	wait();


	return 0;
	
}
	