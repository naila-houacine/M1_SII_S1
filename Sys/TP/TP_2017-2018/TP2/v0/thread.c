#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <sys/wait.h>
#include <sys/types.h>

int thread_function(int n) { 
//le code a executer par un thread
	printf("Je suis le thread de tid : %p, mon pid est :%d \n", pthread_self() ,getpid());
	sleep(6);
	printf("Au revoir du thread de tid :%p \n", pthread_self()) ;
	pthread_exit((void*)42);
	//exit(0);
}


int main(){
int i;
pthread_t tid;
pthread_create(&tid, NULL, thread_function(5), NULL);
printf("Thread principal de (pid, tid) :(%d, %p), creation d’un thread de tid %p \n",getpid(),pthread_self(),tid);
pthread_join(tid, (void **)&i);//similaire au wait et recupere le retour du fils
//printf("Thread principal, la valeure de retour du thread %p est: %d\n",tid,i);
return 0;
 }
