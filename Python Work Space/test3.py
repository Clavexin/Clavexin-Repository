import matplotlib.pyplot as plt
year=[1950,1960,1970,1980,1990,2000,2010]
gdp=[67,80,257,1686,6505,11865,22105]
plt.plot(year,gdp,color='green',marker='o',linestyle='solid')
plt.title("KR GDP per capita")
plt.xlabel("year")
plt.ylabel("dollars")
plt.show()