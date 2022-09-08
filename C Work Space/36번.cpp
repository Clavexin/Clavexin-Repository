#include<stdio.h>
#define SWAP(x, y, temp) ( (temp)=(x), (x)=(y), (y)=(temp) )
void selection_sort(int list[], int n){
  int i, j, least, temp;

  for(i=0; i<n-1; i++){
    least = i;

    for(j=i+1; j<n; j++){
      if(list[j]<list[least])
        least = j;
    }

    if(i != least){
        SWAP(list[i], list[least], temp);
    }
  }
}

int main(){
	int n,list[100],lista[100];
	char name[1000][100];
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%s %d",&name[i],&lista[i]);
	}
	for(int i=0;i<n;i++){
	list[i]=lista[i];
	}
	selection_sort(list, n);           
	for(int i=0;i<n;i++){
		if(list[n-2]==lista[i]){
			printf("%s",name[i]);
			break;
		}
	}
	return 0;
}
