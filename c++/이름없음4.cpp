#include<stdio.h>
int main(){
	int n,c[1000],m,sum;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d",&c[i]);
	}
	scanf("%d",&m);
	for(int i=0;i<n;i++){
		if(sum+c[i]<=m){
			sum=sum+c[i];
		}
	}
	printf("%d",sum);
}
