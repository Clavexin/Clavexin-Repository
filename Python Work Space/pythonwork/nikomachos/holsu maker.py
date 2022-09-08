a=1

f = open("테스트.txt", 'w')
while a <= 99:
    a = a+2
    f.write('{0} '.format(a))
f.close()