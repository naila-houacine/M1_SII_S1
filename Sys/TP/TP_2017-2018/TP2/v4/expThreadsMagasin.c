
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <string.h>
#include <unistd.h>

#define INITIAL_STOCK   20
#define NB_CLIENTS      5
 
 
/* Structure stockant les informations des threads clients et du magasin. */
typedef struct
{
   int stock;
 
   pthread_t thread_magasinier;
   pthread_t thread_clients[NB_CLIENTS];
} store_t ;

store_t store;  
 
/* Fonction pour tirer un nombre au sort entre 0 et max. */
 int get_random (int max)
{
   double val;
 
   val = (double) max * rand ();
   val = val / (RAND_MAX + 1.0);
 
   return ((int) val);
}
 
/* Fonction pour le thread magasinier. */
 void * fonction_magasinier (void * data)
{
   while (1)
   {
      if (store.stock <= 0)
      {
         store.stock = INITIAL_STOCK;
         printf ("Remplissage du stock de %d articles !\n", store.stock);
      }
   }
 
   return NULL;
}
 
 
/* Fonction pour les threads des clients. */
 void * fonction_clients (void * data)
{
   int nb = (int) data;
 
   while (1)
   {
      int val = get_random (6);
 
      sleep (get_random (3));
 
	if(store.stock >= val){
      store.stock = store.stock - val;
      printf (
         "Client %d prend %d du stock, reste %d en stock !\n",
         nb, val, store.stock );
	}else{
	printf("stock insufisant !!!!!");
	}
   }
 
   return NULL;
}
 
 
int main (void)
{
   store.stock=INITIAL_STOCK; 
   int i = 0;
   int ret = 0;
 
   /* Creation du thread du magasin. */
   printf ("Creation du thread du magasin !\n");
   ret = pthread_create (
      & store.thread_magasinier, NULL,
      fonction_magasinier, NULL
   );
 
   /* Creation des threads des clients si celui du magasin a reussi. */
   if (! ret)
   {
      printf ("Creation des threads clients !\n");
      for (i = 0; i < NB_CLIENTS; i++)
      {
         ret = pthread_create (
            & store.thread_clients [i], NULL,
            fonction_clients, (void *) i
         );
 
         if (ret)
         {  //on affiche le msg d'erreur 
            fprintf (stderr, "%s", strerror (ret));
         }
      }
   }
   else
   {
      fprintf (stderr, "%s", strerror (ret));
   }
 
 
   /* Attente de la fin des threads. */
   i = 0;
   for (i = 0; i < NB_CLIENTS; i++)
   {
      pthread_join (store.thread_clients [i], NULL);
   }
   pthread_join (store.thread_magasinier, NULL);
 
 
   return EXIT_SUCCESS;
}


/*
ptread_mutex_t init;
init = PTHREAD_MUTEX_INITIALIZER;
attendre un mutex avant la SC
pthread_mutex_wait(&init);
a la sortie de la SC
ptread_mutex_unless(&init)
