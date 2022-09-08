from PIL import Image
import pytesseract 
pytesseract.pytesseract.tesseract_cmd = r'C:\Program Files\Tesseract-OCR\tesseract' 
img = Image.open('test.png') 
text = pytesseract.image_to_string(img,lang='kor+eng') 
print (text)