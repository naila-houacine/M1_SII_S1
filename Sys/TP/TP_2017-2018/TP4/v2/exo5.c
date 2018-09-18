#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <stdio.h>
#include <stdlib.h>
#include "semaphores2.h"

/************************************************************/
/**
existe deja
typedef Sembuf 
{
           unsigned short sem_num;  
           short          sem_op;   
           short          sem_flg;  
} Sembuf;
**/

/** semop > 0 => V
    semop < 0 => P
    semop = 0 => Z
**/

/************************************************************/


int main()
{
semun s,ss;



key_t key =ftok ("/home/ubuntu/Desktop", 'q');
int semid = semcreate(key,4);
printf("le semid= %d \n",semid);

seminit(semid ,0, 1);

int semval = semctl(semid , 0 , GETVAL);
printf("la valeur = %d \n",semval);

//initialiser un groupe de sem entier

unsigned short tab[4] = {1,1,2,4};
s.array = tab;
semctl(semid , 0 , SETALL , s);
semctl(semid , 0 , GETALL , ss);

int i;
for(i=0 ; i<4 ; i++)
{
printf(" element %d = %d \n ",i,ss.array[i]);
}

printf("semid = %d \n",semid);


/*****************************/

struct sembuf op;
op.sem_num = 0;
op.sem_op = -1;
op.sem_flg = 0;

int ret = semop(semid , &op ,1);
if(ret == -1) printf("error ! \n " );




//detruir le semaphore 
semctl(semid , 0 , IPC_EXCL); 
semctl(semid , 0 , IPC_RMID , 0);

//getpid() pour connaitre le dernier processus ayant modifié le semaphore.
	
return 0;

}
