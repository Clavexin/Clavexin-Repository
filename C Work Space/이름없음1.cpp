#include<stdio.h>
int main(){
	char a[2],b[2];
	int acount=0,bcount=0,abcount=0,ocount=0;
	scanf("%c%c %c%c",&a[0],&a[1],&b[0],&b[1]);
	for(int i=0;i<2;i++){
		for(int j=0;j<2;j++){
			int now = a[i] + b[j];
			if((now==130 or now==144) and acount==0){
				printf("A ");
				acount++;
			}
			else if((now==132 or now==145) and bcount==0){
				printf("B ");
				bcount++;
			}
			else if(now==131 and abcount==0){
				printf("AB ");
				abcount++;
			}
			else if(now==158 and ocount==0){
				printf("O ");
				ocount++;
			}
		}
	}
}
