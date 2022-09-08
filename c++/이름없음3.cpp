#include<stdio.h>
int main(){
	int k,n,m,a[11],b[11],sum=0;
	scanf("%d %d %d",&k,&n,&m);
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	for(int i=0;i<m;i++){
		scanf("%d",&b[i]);
	}
	int ja=0,jb=0,i=0;
while(i<k){
	if(a[ja]>=b[jb] && ja<=n){
		sum=sum+a[ja];
		ja++;
		i++;
	}
	else if(b[jb]>a[ja] && jb<=m){
		sum=sum+b[jb];
		jb++;
		i++;
	}
	else{
		break;
	}
}
	printf("%d",sum);
}
