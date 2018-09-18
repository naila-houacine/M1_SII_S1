#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>

typedef union semun {
    int val;    /* Value for SETVAL */
    struct semid_ds *buf;    /* Buffer for IPC_STAT, IPC_SET */
    unsigned short  *array;  /* Array for GETALL, SETALL */
    struct seminfo  *__buf;  /* Buffer for IPC_INFO (Linux-specific) */
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

/*  la valeur du sémaphore est décrémentée de 1 s'il est différent
 *  de 0 sinon, le processus appelant est bloqué et est placé dans une 
 *  file d'attente liée au sémaphore */
 
void P(int semid , int n) {

  struct sembuf sempar ;

  sempar.sem_num = n ;
  sempar.sem_op = -1 ;
  sempar.sem_flg = 0 ; //SEM_UNDO

  if ( semop(semid,&sempar,1) == -1)
    perror("Erreur lors du down") ;
}

/************************************************************/

void Ptimed(int semid , int n) {

  struct sembuf sempar ;

  sempar.sem_num = n ;
  sempar.sem_op = -1 ;
  sempar.sem_flg = SEM_UNDO;

  struct timespec timeout;

  timeout.tv_sec = 7;
  timeout.tv_nsec = 0;

  semtimedop(semid,&sempar,1,&timeout);
}

/************************************************************/

/* la valeur du semaphore est incremente de 1 s'il n'y a pas de processus  
   dans la file d'attente sinon, s reste inchangee et on libere le premier  
   processus de la file d'attente */

void V(int semid , int n) {

  struct sembuf sempar ;

  sempar.sem_num = n ;
  sempar.sem_op = 1 ;
  sempar.sem_flg = 0 ;

  if (semop(semid,&sempar,1) ==-1)
    perror("Erreur lors du up") ;
}

/************************************************************/

void semdelete(int semid){

  printf("destruction du s\\'emaphore %d \n",semid) ;

  if(semctl(semid,0,IPC_RMID,0) == -1)
    perror("Erreur lors de la destruction du semaphore") ;
}
