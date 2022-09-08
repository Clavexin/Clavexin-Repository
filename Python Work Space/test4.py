import csv
a = input("지역을 입력하십시오.")
f = open('2021-07.csv')
data = csv.reader(f)
header=next(data)
value=[]
m_ppm, m_loc,m_date=0,'',''

for row in data:
    if row[1]==a:

        if row[8]== '':
            ppm=0
        else:
            ppm = int(row[8])
        if m_ppm < ppm:
            m_ppm,m_date,m_loc=ppm,row[0],row[1]+row[2]
print(m_date,m_loc,'지역의 미세먼지 농도가',m_ppm,'로 가장 높았습니다')