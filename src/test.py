import speech_recognition as sr
import pyttsx3
from googletrans import Translator

r = sr.Recognizer()

def record_text():
    while(1):
        try:
            # Sử dụng microphone làm nguồn đầu vào.
            with sr.Microphone() as source:
                r.adjust_for_ambient_noise(source, duration=0.2)

                # Lắng nghe âm thanh từ người dùng
                audio = r.listen(source)
                text = r.recognize_google(audio, language='vi-VN')
                return text
        except sr.RequestError as e:
            print("Không thể yêu cầu kết quả; {0}".format(e))
        except sr.UnknownValueError:
            print("Đã xảy ra lỗi không xác định")

def translate_text(text):
    translator = Translator()
    translated_text = translator.translate(text, src='vi', dest='en')
    return translated_text.text

def output_text(text):
    #print("Tiếng Việt: ", text)
    translated_text = translate_text(text)
    print( translated_text)

count = 0
while(count<1):
    text = record_text()
    output_text(text)
    count=count+1

# count = 0
# while(count<1):
#     text = record_text()
#     output_text(text)
#     count=count+1
   