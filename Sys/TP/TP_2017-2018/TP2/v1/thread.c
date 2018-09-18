#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <sys/wait.h>
#include <sys/types.h>

void *thread_function(int *v) { 
//le code a executer par un thread

	int i = v;
	i = i*i;

	printf("Je suis le thread de tid : %p, mon pid est :%d \n", pthread_self() ,getpid());
	printf("Au revoir du thread de tid :%p \n", pthread_self()) ;
	pthread_exit((void*)i);
	//exit(0);
	//exit = elle va terminer tte l application et sortir
}


int main(){
int i,j,n=5;
pthread_t tid[5];


//pthread_create(&tid, NULL, thread_function, 5);
// on ne peut passer qu 1 seul parametre qui doit etre caste avec (void*)


for(j=1 ; j<=n ; j++){

	printf("Thread principal de (pid, tid) :(%d, %p), creation d’un thread de tid %p \n",getpid(),pthread_self(),tid);
	pthread_create(&tid[j], NULL, thread_function, j);
}

for(j=1 ; j<=n ; j++){

	pthread_join(tid[j], (void **)&i);//similaire au wait et recupere le retour du fils
	printf("Thread principal, la valeure de retour du thread numero %d de tid = %p est: %d\n",j,tid[j],i);
}
return 0;
 }
