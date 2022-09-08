import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
data = pd.read_csv('born_per year.csv', encoding='ANSI')
value = []
x=data.columns[1:51]
x=x.to_numpy()
x=pd.to_numeric(x)
print(x)
y=data.loc[0, '1970':'2019']
y=pd.to_numeric(y.to_numpy())
print(y)
plt.figure(figsize=(20,6))
plt.scatter(x,y)
plt.plot(x,y)
mx=np.mean(x)
my=np.mean(y)
print("x의 평균값:", mx)
print("y의 평균값:",my)
divisor=sum([(mx-i)**2 for i in x])
def top(x,mx,y,my):
    d = 0
    for i in range(len(x)):
        d += (x[i] - mx) * (y[i] - my)
    return d
dividend = top(x,mx,y,my)
a=dividend / divisor
b=my-(mx*a)
print("기울기 a=",a)
print("y 절편 b =",b)

y_pred=a*x+b
plt.scatter(x,y)
plt.plot(x,a*x+b,color='b')
plt.show()
print('2020년도의 추정 신생아 수:',2020*a+b)