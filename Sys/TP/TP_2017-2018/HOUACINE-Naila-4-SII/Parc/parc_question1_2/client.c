#include <pthread.h>
#include <sys/shm.h>
#include "semaphores2.h"

//structure de la mémoire partagée
typedef struct data{
int nbEmbarques;
int nbDebarques;
}shdata;


//fonction embarquement
void Embarquement()
{
	printf("---> Client : %d , je vais monter. \n",getpid());
}

//fonction enBalade
void enBalade()
{
	printf("--- Client : %d , je suis en balade! --- \n",getpid());
	sleep(1);
}

//fonction debarquement
void Debarquement()
{
	printf("Client : %d , FIN de la balade, je desends ---> \n",getpid());
}

/*****************************PROGRAMME PRINCIPALE****************************/
int main()
{	
	int N,p=4;

	int semEmbarquement = 0; int semDebarquement = 1;
	int semTousDehors = 2; int semTousAbord = 3;
	
	pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER;
	pthread_mutex_t mutex2 = PTHREAD_MUTEX_INITIALIZER;
	
	//creation de la mm clé que dans voiture
	key_t key = ftok("/home/izan/Desktop",'q');

	//récupération de l'ID de l'espace paratgée
	int shmid = shmget(key,sizeof(shdata), 0);
	
	//attacher l'espace mémoire partagé 
	shdata *sd= NULL;
	sd = shmat(shmid,sd,0);
	
	//récuperer l'ID du groupe de sémaphore crée par la voiture
	int semid = semcreate(key,4);
	
	
	//donner au clavier le nombre de clients
	do{
	printf("Donner le nombre de clients : ");
	scanf("%d",&N);}while(N<p);

	printf("\n");
	
	pid_t pid[N],c;
	
for( c = 0 ; c < N ; c++)
{
	pid[c] = fork();

	if(pid[c] == -1)
	{
		printf("fork error! \n");
	}
	
	if(pid[c] == 0)
	{
		while(1){
			P(semid,semEmbarquement); //faire la chaine pour monter, attendre d’être libéré par le processus voiture
			Embarquement(); //affiche un message : “client pid: je vais monter”

			pthread_mutex_lock(&mutex1);
				sd->nbEmbarques+=1;

				if(sd->nbEmbarques == p)
				{
				V(semid,semTousAbord); // le dernier client qui monte va réveiller le processus voiture pour qu'il démarre
				sd->nbEmbarques = 0; //il remet le compteur a zero
				}

			pthread_mutex_unlock(&mutex1); //libere la SC

			enBalade(); //affiche un message “client pid: je suis en balade ” et sleep(1)
			P(semid, semDebarquement );  //se met en attente du debarquement (il fait la chaine) pour descendre
			Debarquement(); //affiche un message “client pid: FIN de la balade je descend”

			pthread_mutex_lock(&mutex2);

				sd->nbDebarques+=1;
				if(sd->nbDebarques == p)
				{ V(semid, semTousDehors); //réveiller le processus voiture, quand tout le monde est descendu pour qu'il charge a nouveau.
				sd->nbDebarques=0;
				}
				
			pthread_mutex_unlock(&mutex2);

			sleep((rand()%2) + 1);
		}
			exit(0);
	}

	
}

    //semdelete(semid); 

return 0;
}
