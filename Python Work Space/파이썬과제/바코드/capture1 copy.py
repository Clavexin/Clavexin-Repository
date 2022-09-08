# -*- coding: utf-8 -*-
import cv2
import pyzbar.pyzbar as pyzbar
from playsound import playsound
from datetime import datetime
import os
time=datetime.now()
print('시작합니다')
def createFolder(directory):
    try:
        if not os.path.exists(directory):
            os.makedirs(directory)
    except OSError:
        print("ERROR:OSERROR")
createFolder('.\data\\{0}y{1}m{2}d'.format(time.year, time.month, time. day))
today='{0}y{1}m{2}d'.format(time.year, time.month, time. day)
# 카메라 캡쳐 객체, 0=내장 카메라


# 캡쳐 프레임 사이즈 조절
# capture.set(cv2.CAP_PROP_FRAME_WIDTH, 320)
# capture.set(cv2.CAP_PROP_FRAME_HEIGHT, 240)
data_list = []
used_codes = []
try:
    f= open(".\\pythonwork\\barcode\\qrbarcode data.txt", "r", encoding="utf8")
    data_list= f.readlines()
except FileNotFoundError:
    pass
else:
    f.close()

capture = cv2.VideoCapture(1 + cv2.CAP_DSHOW)

for i in data_list:
    used_codes.append(i.rsplit('\n'))

while True: # 특정 키를 누를 때까지 무한 반복
    # 한 프레임씩 읽기
    success, frame = capture.read()
    now = datetime.now()
    if success:
        for code in pyzbar.decode(frame):
            my_code = code.data.decode('utf-8')
            if my_code not in used_codes:
                if os.path.isfile('.\data\{0}\{1}.png'.format(today,my_code)):
                    print("인식 성공 : ",my_code)
                    playsound("beep.mp3")
                    used_codes.append(my_code)
                    f2 = open("qrbarcode_data.txt", "a",  encoding="utf-8")
                    f2.write(my_code+'\n')
                    f2.close()
                    cv2.imwrite('.\data\{0}\{1}.png'.format(today,my_code), frame)
                else:
                    print("오늘 이미 먹었습니다.")
                    playsound("beep.mp3")
            else:
                print("방금 먹었습니다.")
                playsound("beep.mp3")
    cv2.imshow("DinnerChecker", frame)
    key = cv2.waitKey(1)
    if key == 27:
        break

# 카메라 객체 반환
capture.release()
cv2.destroyAllWindows()