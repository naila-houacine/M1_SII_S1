#include<unistd.h>
#include<stdlib.h>
#include<stdio.h>
void main(){
int pid1,pid2,pid3,pid4,pid5,i;

/*the P0 create P1 and P2*/

pid2 = fork() ;

if(pid2 == -1){
	printf("error");
	exit(0);
}
if(pid2 == 0){
//P2
printf("i\'m the process 2 my PID = %d and my PPID = %d  \n",getpid(),getppid());
sleep(10);exit(0);
}
if(pid2 > 0){
//P0
 pid1 = fork();
	if(pid1 == -1){
	printf("error");
	exit(0);
	}
	if(pid1 == 0){//P1
	printf("i\'m the process 1 my PID = %d and my PPID = %d  \n",getpid(),getppid());

	pid3 = fork();
	
	if(pid3 == -1){
	printf("error");
	exit(0);
	}
	if(pid3 == 0){//P3
	printf("i\'m the process 3 my PID = %d and my PPID = %d  \n",getpid(),getppid());
	sleep(10);exit(0);
	}

	if(pid3 > 0){//P1
	
	pid4 = fork();

	if(pid4 == -1){
	printf("error");
	exit(0);
	}
	if(pid4 == 0){//P4
	printf("i\'m the process 4 my PID = %d and my PPID = %d  \n",getpid(),getppid());
	sleep(10);exit(0);
	}
	wait();wait();
	sleep(5);exit(0);
	}
	}


//P0
 pid5 = fork();
	if(pid5 == -1){
	printf("error");
	exit(0);
	}
	if(pid5 == 0){//P5
	printf("i\'m the process 5 my PID = %d and my PPID = %d  \n",getpid(),getppid());
	wait();wait();sleep(10);exit(0);
	}

wait();wait();wait();
printf("i\'m the process 0 my PID = %d \n",getpid());



	
}

}
