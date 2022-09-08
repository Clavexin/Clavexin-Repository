text=input("압축할 텍스트를 입력하십시오:")
a=len(text)
b=list(text)
i=1
count=0
while i<a:
    count=count+1
    if (b[i-1] != b[i]):
        if count==1:
            print(b[i-1],end='')
        else:
            print("*{0}{1}".format(count,b[i-1]),end='')
        count=0
    i=i+1
if i==a:
    count=count+1
    if count==1:
        print(b[i-1],end='')
    else:
        print("*{0}{1}".format(count,b[i-1]),end='')