#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<string.h>

#define NBR_CHILD 2

char *concat_string(char *s1,char *s2)
{
     char *s3=NULL;
     s3=(char *)malloc((strlen(s1)+strlen(s2))*sizeof(char));
     strcpy(s3,s1);
     strcat(s3,s2);
     return s3;
}


int main(int argc , char* argv[])
{
	int pid1,i;
	int status,s;
	char* s1 = "/bin/";
	

	for(i=1 ; i<= NBR_CHILD ; i++)
	{
		pid1 = fork() ;

		if(pid1 == -1){
			printf("fork error");
			exit(0);
		}

		if(pid1 == 0){
		//the child is running
		
			
			printf("I'm the child N° %d my pid = %d, my father's pid = %d and i'm executing the commande : %s \n",i,getpid(),getppid(),argv[i]);

		//probleme de concatenation

			
			execl(concat_string(s1,argv[i]),argv[i], NULL);
			printf("error at the exec commande !! \n");
			exit(i);

		}
	}
	
	//the father is running
	printf("I'm the father my pid = %d and i'm waiting for my children! \n",getpid());
		for(i=1 ; i<= NBR_CHILD ; i++)
	{
		wait(&status) ;
		if(WIFEXITED (status)){//fin normale
			
			printf("I'm the father my child N° = %d  execut commande: %s ,ended with status = %d \n",i,argv[i],WEXITSTATUS (status));
		}
		else{
			printf("the child N° = %d with commande %s didn't end normaly !! \n",i,argv[i]);
		}
		
	}


	return 0;
	
}
	
