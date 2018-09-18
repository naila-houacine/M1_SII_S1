#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main(void)
{
int p1[2] , p2[2];
pid_t pid1 , pid2 , pid3;
char buf1[50] , buf2[50];

if (pipe(p1) || pipe(p2))
{ perror("pipe"); exit(1);
}

if ((pid1 = fork())== -1)
{ perror("fork"); exit(1);
}

if(pid1 > 0)//c'est le pere
{
	if ((pid2 = fork())== -1)
	{ perror("fork"); exit(1);
	}
	if(pid2 > 0)//c'est le pere
	{
		if ((pid3 = fork())== -1)
		{ perror("fork"); exit(1);
		}
		if(pid3 > 0)//c'est le pere
		{
			//le pere ferme les 2 pipes
			close(p1[0]);
			close(p1[1]);
			close(p2[0]);
			close(p2[1]);
		}
		else//fils 1
		{
			//fermer le pipe 2 et fermer la lecture du pipe1
			close(p1[0]);
			close(p2[0]);
			close(p2[1]);
			//modifier la sortie standard (ecriture)
			dup2(p1[1] , 1);
			//la fonction a executer
			execlp("/bin/ps","ps","aux",NULL); 
		}
	}
	else//fils 2
	{
		//fermer la lecture pipe 2 et fermer l'ecriture du pipe1
		close(p1[1]);
		close(p2[0]);

		//modifier la sortie standard (ecriture et lecture)
		dup2(p1[0] , 0);
		dup2(p2[1] , 1);

		//la fonction a executer
		execlp("grep","grep","root",NULL);
	}
}
else//fils 3
{
	//fermer l'ecriture du pipe 2 et fermer le pipe1
	close(p1[0]);
	close(p1[1]);
	close(p2[1]);

	//modifier la sortie standard (lecture)
	dup2(p2[0] , 0);

	//la fonction a executer
	execlp("wc","wc","-l",NULL);
}





	return 0;
}
