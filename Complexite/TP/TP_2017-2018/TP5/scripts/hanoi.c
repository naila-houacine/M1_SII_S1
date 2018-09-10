
//USTHB, Année 2014/2015
//1ère année Master  Informatique, Semestre 1
//Module : Conception et Complexité des Algorithmes
//Série Travaux Pratiques n°5 (TP n°5)
//Archivage: D:\BC45\M1_RSD_Complexité_2015\TP5.cpp)
//Ce programme résout le problème des tours de Hanoi.
//Ce programme est récursif

//développé par Mr. AMANI

#include <stdlib.h>
#include <stdio.h>
#include <time.h>

//Déclaration de la fonction hanoi(int, int, int, int)
void hanoi(int, int, int, int);

int nb;				//nb est une variable globale

int main(void)
{
  int n;				//n = nombre de disques
  //int nb;              		//nb = nombre de déplacement des disques
  clock_t t1, t2;		//clock_t désigne le type temps
  double delta;			//delta mesure la durée d'exécution du programme entre
				//les points t1 et t2
  //Partie 1: Lecture des données

  printf("\nDonner le nombre de disques: n = ");
  scanf("%d", &n);		//le format "%d" permet de lire le type entier en
				//en simple précision sur 2 octets = 16 bits
  //Partie 2: Traitement
  nb=0;
  t1=clock();			//La variable t1 reçoit la valeur du temps fournie par la
				//la fonction clock(). C'est le début de la mesure du temps.
  hanoi(n, 1, 3, 2);          	//appel de la fonction hanoi(n, 1, 3, 2)
				//On suppose : A=1, B=2 et C=3
  t2=clock();			//La variable t2 reçoit la valeur du temps fournie par la
				//la fonction clock(). C'est la fin de la mesure du temps.










  delta=(double)(t2-t1)/CLOCKS_PER_SEC;	//formule permettant de calculer la
				//durée d'exécution du programme entre les points t1 et t2

  printf("\n temps = %lf ", delta);
  printf("\n\nEntrer une touche quelconque pour terminer le programme: ");
  getchar(); getchar();
  return(0);
}//fin du programme

//Définition de la fonction hanoi(int n, int A, int C, int B)
void hanoi(int n, int A, int C, int B)
{
  if (n >= 1)
    {
        hanoi(n-1, A, B, C);
        //printf("Déplacer le disque restant de %d vers %d\n", A, B);
                                               			//La tour A devient vide
        nb=nb+1;		//Lors des mesures du temps, ces 2 instructions doivent être
				//bloquées (par exemple mises en commentaires)
        hanoi(n-1, B, A, C);
    }
}//fin de la fonction hanoi(int n, int A, int C, int B)




/**
Donner le nombre de disques: n = 2
D├®placer le disque restant de 1 vers 3
D├®placer le disque restant de 1 vers 2
D├®placer le disque restant de 2 vers 3

 nb=3 deplacements


Donner le nombre de disques: n = 3
D├®placer le disque restant de 1 vers 3
D├®placer le disque restant de 1 vers 2
D├®placer le disque restant de 3 vers 2
D├®placer le disque restant de 1 vers 3
D├®placer le disque restant de 2 vers 1
D├®placer le disque restant de 2 vers 3
D├®placer le disque restant de 1 vers 3

 nb=7 deplacements
1 ->
2 ->
3 ->
4 ->
5 ->
6 ->
7 ->
8 ->
9 -> 0

12 -> 0.001000

17 -> 0.002000
18 -> 0.004000
19 -> 0.009000
20 -> 0.031000
21 -> 0.048000
22 -> 0.086000
23 -> 0.117000
24 -> 0.203000
25 -> 0.381000
26 -> 0.734000
27 ->

 **/
