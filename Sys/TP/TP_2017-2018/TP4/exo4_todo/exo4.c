#include <stdio.h>
# include <unistd.h>
#include <sys/shm.h>

typedef struct data{
int a;
int b;
int tab[10];
}sdata;

int main(){

//creation du segment a faire dans un seul processus puis passer l'identifiant aux autres

key_t key=ftok("/home/ubuntu/Desktop",3); //modifier le chemin
int shmid=shmget(key,sizeof(sdata),IPC_CREAT|IPC_EXCL|0666);

if(shmid==-1){
//la zone existe deja !
shmid=shmget(key,sizeof(sdata),0); //recuperer son id
printf("Segment existe deja d’id:%d\n",shmid);
}else printf("Segment mémoire d’id:%d crée \n",shmid);

//tout les processus doivent appeler shmat pour attacher une adresse a la zone memoire le 
//pointeur permet par la suite d'ecrire directement des donnes dans la zone partagée.

sdata *sd= NULL;
//pour eviter le seg default
sd = shmat(shmid,sd,0);

//maintenant on peut ecrire dans la zone via la structure.

//sd->a=10;
//sd->b=5;
//si on commente des deux ligne au dessus (a et b) et que l'on réexécute avec le meme identifiant les valeurs seront les memes , car la zone de memoire est tjrs active
//printf("val écrites:%d, %d\n",sd->a,sd->b);

return 0;

}












