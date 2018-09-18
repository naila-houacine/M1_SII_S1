#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>

#define NBR_CHILD 2

int main(int argc , char* argv[])
{
	int pid1,i;
	int statut;

	for(i=1 ; i<= NBR_CHILD ; i++)
	{
		pid1 = fork() ;

		if(pid1 == -1){
			printf("fork error");
			exit(0);
		}

		if(pid1 == 0){
		//the child is running
		
			printf("I'm the child N° %d my pid = %d, my father's pid = %d  \n and i'm executing the commande : %s",i,getpid(),getppid(),argv[i]);
			i = execl( "/bin"+argv[i],argv[i], NULL);
			printf("error at the exec commande !! \n");
			exit(i);

		}
	}
	
	//the father is running
	printf("I'm the father my pid = %d and i'm waiting for my children! \n",getppid());
		for(i=0 ; i< NBR_CHILD ; i++)
	{
		wait (&status) ;
		if(WIFEXITED (status)){//fin normale
			
			printf("I'm the father my child N° = %d with pid = %d execut commande	: %s ,ended with statut = %d \n",i,WTERMSIG (status),argv[i],WEXITSTATUS (status));
		}
		else{
			printf("the child N° = %d didn't end normaly !! ",i);
		}
		
	}


	return 0;
	
}
	