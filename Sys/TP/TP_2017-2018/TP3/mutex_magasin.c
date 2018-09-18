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
 
   pthread_t thread_store;
   pthread_t thread_clients[NB_CLIENTS];
 
   pthread_mutex_t mutex_stock;
   pthread_cond_t cond_stock;
   pthread_cond_t cond_clients;
}
store_t;
 
static store_t store =
{
   .stock = INITIAL_STOCK,
   .mutex_stock = PTHREAD_MUTEX_INITIALIZER,
   .cond_stock = PTHREAD_COND_INITIALIZER,
   .cond_clients = PTHREAD_COND_INITIALIZER,
};
 
 
/* Fonction pour tirer un nombre au sort entre 0 et max. */
static int get_random (int max)
{
   double val;
 
   val = (double) max * rand ();
   val = val / (RAND_MAX + 1.0);
 
   return ((int) val);
}
 
 
/* Fonction pour le thread du magasin. */
static void * fn_store (void * p_data)
{
   while (1)
   {
      /* Debut de la zone protegee. */
      pthread_mutex_lock (& store.mutex_stock);
	  /* Attendre que le stock soit insuffisant pour le remplir */
      pthread_cond_wait (& store.cond_stock, & store.mutex_stock);
 
      store.stock = INITIAL_STOCK;
      printf ("Remplissage du stock de %d articles !\n", store.stock);
 
      pthread_cond_signal (& store.cond_clients);
	  /* reveiller les clients une fois le stock pleine pour qu'ils continuent a retirer */
      pthread_mutex_unlock (& store.mutex_stock);
      /* Fin de la zone protegee. */
   }
 
   return NULL;
}
 
 
/* Fonction pour les threads des clients. */
static void * fn_clients (void * p_data)
{
int state = PTHREAD_CANCEL_ENABLE;
int oldstate;
pthread_setcancelstate (state, &oldstate);

   int nb = (int) p_data;
 
   while (1)
   {
      int val = get_random(6);
 
      sleep(get_random(3));
 
      /* Debut de la zone protegee. */
      pthread_mutex_lock (& store.mutex_stock);
 
      if (val > store.stock)
      {
         pthread_cond_signal (& store.cond_stock);
         pthread_cond_wait (& store.cond_clients, & store.mutex_stock);
      }
 
      store.stock = store.stock - val;
      printf ("Client %d prend %d du stock, reste %d en stock !\n",nb, val, store.stock );
 
      pthread_mutex_unlock(& store.mutex_stock);
      /* Fin de la zone protegee. */
   }

state = PTHREAD_CANCEL_DISABLE;
pthread_setcancelstate (state, &oldstate);
  
 
   return NULL;
}
 
 
int main (void)
{
   int i = 0;
   int ret = 0;
 
 
   /* Creation des threads. */
   printf("Creation du thread du magasin !\n");
   ret = pthread_create (
      & store.thread_store, NULL,
      fn_store, NULL
   );
 
   /* Creation des threads des clients si celui du magasinn a reussi. */
   if (! ret)
   {
      printf ("Creation des threads clients !\n");
      for (i = 0; i < NB_CLIENTS; i++)
      {
         ret = pthread_create(& store.thread_clients [i], NULL,fn_clients, (void *) i);
 
         if (ret)
         {
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
      if(i == 1 || i == 3 || i == 4)pthread_cancel(store.thread_clients[3]);
      else pthread_join(store.thread_clients[i], NULL);
   }
   pthread_join(store.thread_store, NULL);
 
	
 pthread_cond_destroy(&store.cond_stock) ;
 pthread_cond_destroy(&store.cond_clients) ;
 pthread_mutex_destroy(&store.mutex_stock);

   return EXIT_SUCCESS;
}
