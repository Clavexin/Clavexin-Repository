array = [[0 for col in range(11)] for row in range(11)]
for i in range(10):
    array[i]=list(map(int,input().split()))
x,y=int(1),int(1)

while True:
    if array[y][x]==2:
        array[y][x]=9
        break
    if array[y][x+1]==1:
        if array[y+1][x]==0:
            array[y][x]=9
            y+=1
        else:
            if array[y+1][x]==2:
                array[y+1][x]=9
                array[y][x]=9
                break
            elif array[y][x+1]==2:
                array[y][x+1]=9
                array[y][x]=9
                break
            else:
                array[y][x]=9
                break
    else:
        array[y][x]=9
        x+=1
for i in range(10):
    for j in range(10):
        print(array[i][j],end=' ')
    print()