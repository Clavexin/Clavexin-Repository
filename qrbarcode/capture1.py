import cv2
import pyzbar.pyzbar as pyzbar
from playsound import playsound
from datetime import datetime
import os
print('시작합니다')
x= datetime.now()
pathtime = "{0}y {1}m {2}d".format(x.year, x.month, x.day)
#폴더 생성때 쓰이는 datetime

os.makedirs(pathtime, exist_ok=True)
f = open("{0}\{1}.txt".format(pathtime,pathtime), 'w')
data_list = []
used_codes = []
try:
    f= open("pathtime\qrbarcode data.txt", "r", encoding="utf8")
    data_list= f.readlines()
except FileNotFoundError:
    pass
else:
    f.close()
# 0=내장 카메라,1=외장 카메라
capture = cv2.VideoCapture(0 + cv2.CAP_DSHOW)

for i in data_list:
    used_codes.append(i.rsplit('\n'))

while True:
    success, frame = capture.read()
    now = str(datetime.now())
    cv2.putText(frame, now, (60, 70), cv2.FONT_HERSHEY_SCRIPT_SIMPLEX, 1, (0, 0, 255))
    if success:
        for code in pyzbar.decode(frame):
            my_code = code.data.decode('utf-8')
            file = '{0}\{1}.png'.format(pathtime,my_code)
            if os.path.isfile(file):
                print("오늘 이미 먹었습니다.")
                playsound("beep.mp3")
            else:
                print("인식 성공 : ",my_code)
                playsound("beep.mp3")
                used_codes.append(my_code)
                f2 = open("{0}\{1}.txt".format(pathtime,pathtime), "a",  encoding="utf8")
                f2.write(my_code+'\n')
                f2.close()
            cv2.imwrite('{0}\{1}.png'.format(pathtime,my_code), frame)
    cv2.imshow("DinnerChecker", frame)
    key = cv2.waitKey(1)
    if key == 27:
        break
        
# 카메라 객체 반환
capture.release()
cv2.destroyAllWindows()
