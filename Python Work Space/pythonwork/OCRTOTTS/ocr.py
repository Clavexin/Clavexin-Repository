import cv2
from PIL import Image
import pytesseract
from gtts import gTTS
import speech_recognition as sr
import playsound
import os
import time
capture = cv2.VideoCapture(0)
pytesseract.pytesseract.tesseract_cmd=r'C:\Program Files\Tesseract-OCR\tesseract.exe'
while True:
    success, frame = capture.read()
    if success:
            cv2.imshow("OCRTOTTS", frame)
            key = cv2.waitKey(1)
            if key == 27:
                break
            if key == 32:
                cv2.imwrite('a.png', frame)
                text = pytesseract.image_to_string(Image.open("a.png"))
                print(text)
                tts = gTTS(text)
                tts.save('voice.mp3')
                playsound.playsound('voice.mp3')
capture.release()
cv2.destroyAllWindows() 