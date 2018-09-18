#include "semaphores2.h"


int main()
{
//creation d'un groupe de sémaphores binaire init a 1

semun s;

key_t key =ftok("/home/izan/Desktop/Naila", 'p');
int semid = semcreate(key,1);
printf("le semid= %d \n",semid);
seminit(semid ,0, 1);


//creation de N fils
int i,N,pid;
int t = rand() % 4;
printf("donner le nombre de fils a créer N = ");
scanf("%d",&N);

for(i=1 ; i<= N ; i++)
{
	pid = fork() ;
	if(pid == -1){
		printf("fork error");
		exit(0);
	}

	if(pid == 0){
	//the child is running
	//c'est le fils
	printf("processus pid= %d , en attente pour l'impression\n",getpid());

	//verrouillage p(semid)
	P(semid,0);
	printf("processus de pid = %d , en train d'imprimer , durant %d seconds \n",getpid(),t);
	sleep(t);

	//deverouillage v(semid)
	V(semid,0);
	printf("processus de pid = %d , a fini l'impression \n",getpid());

	exit(0);
	}


}

semdelete(semid);


return 0;
}

