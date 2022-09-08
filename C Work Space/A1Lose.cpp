#include<stdio.h>
int main(){
	char a[2],b[2],now[2],Acount=0,Bcount=0,ABcount=0,Ocount=0;
	scanf("%c%c %c%c",&a[0],&a[1],&b[0],&b[1]);
	for(int i=0;i<2;i++){
		for(int j=0;j<2;j++){
			now[2]=a[i]+b[j];
			if(now[0]== 'A' and now[1]=='A' and Acount==0){
				printf("A ");
				Acount++;
			}
			else if(now[0]== 'A' and now[1]=='O' and Acount==0){
				printf("A ");
				Acount++;
			}
			else if(now[1]=='A' and now[0]=='A' and Acount==0){
				printf("A ");
				Acount++;
			}
			else if(now[1]=='A' and now[0]=='O' and Acount==0){
				printf("A ");
				Acount++;
			}
			else if(now[0]=='B' and now[1]=='B' and Bcount==0){
				printf("B ");
				Bcount++;
			}
			else if(now[0]=='B' and now[1]=='O' and Bcount==0){
				printf("B ");
				Bcount++;
			}
			else if(now[1]=='B' and now[0]=='B' and Bcount==0){
				printf("B ");
				Bcount++;
			}
			else if(now[1]=='B' and now[0]=='O' and Bcount==0){
				printf("B ");
				Bcount++;
			}
			else if(now[0]=='A' and now[1]=='B' and ABcount==0){
				printf("AB ");
				ABcount++;
			}
			else if(now[1]=='A' and now[0]=='B' and ABcount==0){
				printf("AB ");
				ABcount++;
			}
			else if(now[0]=='O' and now[1]=='O' and Ocount==0){
				printf("O ");
				Ocount++;
			}
		}
	}
}
