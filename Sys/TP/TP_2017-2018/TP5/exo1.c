#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
int main(void)
{ 
int p[2];
pid_t pid , pid1;
char buf[50];

if (pipe(p))
{ perror("pipe"); exit(1);
}

if ((pid = fork())== -1)
{ perror("fork"); exit(1);
}

if (pid>0)//le pere
{ 
close(p[0]);
//le pere ferme descripteur lecture

if ((pid1 = fork())== -1)
{ perror("fork"); exit(1);
}
if (pid1>0)//le pere
{ 
close(p[0]);
close(p[1]);
	wait(NULL); //attendre 
	wait(NULL); //attendre 
}

else{//le fils 1
close(p[0]);
write(p[1],"Bonjour frere!\n", strlen("Bonjour frere!\n"));
printf("Processus frere1- message ecris.\n");
fflush(NULL);
close(p[1]);

}
}
else //le fils 2
{ 
close(p[1]);
//ferme descripteur ecriture
while(read(p[0],buf, 20)>0){
printf("Processus frere2-message lu est:%s\n",buf);
}
printf("Processus fils2-FIN \n");

close(p[0]);
}
return 0;
}


