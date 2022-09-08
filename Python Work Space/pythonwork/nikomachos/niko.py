#coding=<utf-8>
import sys
a=int(input("알아보고 싶은 수를 입력하세요."))
#ex)a**2는 a의 2제곱이라는 뜻
#P(n):n^3=(n^2-n+1)+...+(n^2+n-1)
b=a**2-a+1
c=a**2+a-1
print("{0}의 세제곱을 홀수의 합으로 표현하면 ".format(a), end='')
print("{0}^3 = {1} = {2}".format(a,a**3,b),end='')
b=b+2
a=a-3
while a>=0:
    print(" + {0}".format(b),end='')
    b=b+2
    a=a-1
print(" + {0}".format(c))
#더해질 홀수들을 나열했을때 수열에서 맨처음값과 끝값만 안다면 a의 값이 홀수들의 개수이다.
#그러므로 처음값을 b로 +2씩 a번만큼 더하면 마지막값 c가 나오며 모든 홀수들의 값을 알 수가 있다.