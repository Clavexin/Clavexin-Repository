array = [[0 for col in range(20)] for row in range(20)]
for i in range(19):
    array[i]=list(map(int,input().split()))
count=int(input())
for i in range(count):
    x,y=map(int,input().split())
    for j in range(19):
        for i in range(19):
            if i==x-1:
                if array[i][j]==0:
                    array[i][j]=1
                else:
                    array[i][j]=0
            if j==y-1:
                if array[i][j]==0:
                    array[i][j]=1
                else:
                    array[i][j]=0
for i in range(19):
    for j in range(19):
        print(array[i][j],end=' ')
    print()