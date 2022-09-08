w,h=map(int,input().split())
array = [[0 for col in range(101)] for row in range(101)]
n=int(input())
l=[]
d=[]
x=[]
y=[]
for i in range(n):
    l.append(0)
    d.append(0)
    x.append(0)
    y.append(0)

for i in range(n):
    l[i],d[i],y[i],x[i]=map(int,input().split())

for i in range(n):
    if d[i]==0:
        for j in range(l[i]):
            array[x[i]+j][y[i]]=1
    if d[i]==1:
        for j in range(l[i]):
            array[x[i]][y[i]+j]=1

for i in range(w):
    for j in range(h):
        print(array[j+1][i+1],end=' ')
    print()