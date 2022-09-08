#include<stdio.h>
int main(){
	int n,m,a[10],b[10];
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	scanf("%d",&m);
	for(int i=0;i<m;i++){
		scanf("%d",b[i]);
	}
	for(int i=0;i<m;i++){
		int k=0;
		for(int j=0;j<n;j++){
		if(b[i]==a[j]){
			printf("%d ",j+1);
			k++;
			break;
			}
		}
		if(k==0){
			printf("-1 ");
		}
	}	
}
