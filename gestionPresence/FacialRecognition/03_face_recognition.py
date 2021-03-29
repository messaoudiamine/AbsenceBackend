import cv2
import numpy as np
import os 
import pathlib
import array as arr 
import sys

nameImage = "imageTest2"
# nameImage = sys.argv[1]

path_abs = str(pathlib.Path(__file__).parent.absolute())
cascadePath = path_abs+"/haarcascade_frontalface_default.xml"
faceCascade = cv2.CascadeClassifier(cascadePath)
recognizer = cv2.face.LBPHFaceRecognizer_create()
recognizer.read(path_abs+'/trainingData.yml')
font = cv2.FONT_HERSHEY_SIMPLEX

#iniciate id counter
id = 0
confidence = 0
presence = [] 



# Define min window size to be recognized as a face
# minW = 0.1*cam.get(3)
# minH = 0.1*cam.get(4)

# while True:
img=cv2.imread(path_abs+'/image/'+nameImage+'.jpg')#test_img path

gray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)

faces = faceCascade.detectMultiScale( 
    gray,
    scaleFactor = 1.2,
    minNeighbors = 5,
    # minSize = (250, 250),
    )
for(x,y,w,h) in faces:
    print("a")
    cv2.rectangle(img, (x,y), (x+w,y+h), (0,255,0), 2)

    id, confidence = recognizer.predict(gray[y:y+h,x:x+w])
    # Check if confidence is less them 100 ==> "0" is perfect match 
    if (confidence > 37):
        if id in presence:
            continue
        else:
            presence.append(id)
    else:
        id = "unknown"
    # presence.append(id)
    
    cv2.putText(img, str(id), (x+5,y-5), font, 1, (255,255,255), 2)
    cv2.putText(img, str(confidence), (x+5,y+h-5), font, 1, (255,255,0), 1)  

# cv2.imshow('camera',img) 

# num_list = presence.tolist() # list 
print(presence)

cv2.waitKey(0)
cv2.destroyAllWindows()
