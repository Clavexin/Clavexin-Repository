#include<stdio.h>
// ���� ����
void insertion_sort(int list[], int n){
  int i, j, key;

  // ���ؽ� 0�� �̹� ���ĵ� ������ �� �� �ִ�.
  for(i=1; i<n; i++){
    key = list[i]; // ���� ���Ե� ������ i��° ������ key ������ ����

    // ���� ���ĵ� �迭�� i-1�����̹Ƿ� i-1��°���� �������� �����Ѵ�.
    // j ���� ������ �ƴϾ�� �ǰ�
    // key ������ ���ĵ� �迭�� �ִ� ���� ũ�� j��°�� j+1��°�� �̵�
    for(j=i-1; j>=0 && list[j]>key; j--){
      list[j+1] = list[j]; // ���ڵ��� ���������� �̵�
    }

    list[j+1] = key;
  }
}
int main(){
	int list[10],o=0,e=0,odd[10],even[10];
	for(int i=0;i<10;i++){
	scanf("%d",&list[i]);
	}
	for(int i=0;i<10;i++){
		if(list[i]%2==0){
			odd[o]=list[i];
			o++;
		}
		else{
			even[e]=list[i];
			e++;
		}
	}
	insertion_sort(odd,o-1);
	insertion_sort(even,e-1);
	printf("%d %d",odd[0],even[0]);
}
