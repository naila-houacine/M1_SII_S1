#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <stdio.h>
#include <stdlib.h>

typedef union semun {
    int              val;    /* Value for SETVAL */
    struct semid_ds *buf;    /* Buffer for IPC_STAT, IPC_SET */
    unsigned short  *array;  /* Array for GETALL, SETALL */
    struct seminfo  *__buf;  /* Buffer for IPC_INFO
                                  (Linux-specific) */
           }semun;

/***********************************************************/

int semcreate (key_t key, int n){

int semid = semget(key , n , IPC_CREAT | IPC_EXCL | 0666 );

if(semid == -1){
	semid=semget(key , n ,0);
	printf("groupe de sémaphore deja crée et son id = %d \n",semid);
		}

return semid;
}

/************************************************************/

int seminit(int semid , int semnum, int initval){

int ret = semctl(semid, semnum , SETVAL , initval);
if(ret == -1) perror("seminit error !\n");
return ret;
}

/************************************************************/


int main()
{
semun s;

key_t key =ftok ("/home/ubuntu/Desktop", 'u');
int semid = semcreate(key,4);
printf("le semid= %d \n",semid);

seminit(semid ,0, 1);

int semval = semctl(semid , 0 , GETVAL);
printf("la valeur = %d \n",semval);

//initialiser un groupe de sem entier

unsigned short tab[4] = {1,1,2,4};
s.array = tab;
semctl(semid , 0 , SETALL , s);

//deduire le semaphore 
semctl(semid , 0 , IPC_EXCL); 


	
return 0;

}
