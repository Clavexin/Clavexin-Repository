#include<stdio.h>
int main(){
	long long int bomal,dageumbari,a,b,c;
	scanf("%lld",&bomal);
	scanf("%lld %lld %lld",&a,&b,&c);
	dageumbari=bomal/12*a/8*b/5*c;
	printf("%lld",dageumbari);
}
