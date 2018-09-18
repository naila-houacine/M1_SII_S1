#include "semaphores2.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>



int main(int argc , char *argv[])
{
	key_t key =ftok("/home/izan/Desktop/Naila/Sys/TP4", 'h');
	int sem = semcreate(key,1);
	int refresh = 0;
	seminit(sem ,refresh, 0);

	pid_t pid;
	int Val ,preVal= 11, i = 0,j = 0;
	int s = (int) atoi(argv[1]);
	char* c = (char*) argv[1];

	while(1)
	{
		pid = fork() ;
		if(pid == -1)
		{
			printf("fork error");
			exit(0);
		}

		if(pid == 0 )//precessus fils1
		{
			P(sem,refresh);//attendre d'etre reveillé par le pere

			execlp("ipcs","ipcs","-s","-i",c,NULL);
			printf("error at the exec commande !! \n");
			exit(0);
			//sleep(2);

		}
		else//le pere
		{
			Val = semctl(s, 0 , GETVAL , Val);			

			if(preVal != Val)//s'il y'a une modification sur le semaphore dont le pid et en entrée
			{
				preVal = Val;   //ces 2 variables nous permetent de comparer
						//l'ancien et nouvel etat du groupe de sémaphore
						//dont le semid est en etrée.

				V(sem,refresh);	//reveille le fils pour afficher le nouveau resultat
				
				wait();			
			}

		}
	
	sleep(1);
	}
	return 0;
	
}
	
