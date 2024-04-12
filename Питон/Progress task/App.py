import json
import dateutil.parser as dparser
from datetime import *

# Передайте номер для чтения заметки по номеру
def readNote(number=date.today()):
    ifstream = open("notes.txt", 'r', "UTF-8")
    if isinstance(number, int):
        for i in range(number):
            ifstream.readline()
        resline = ifstream.readline()
        print(resline)
    else:
        #реализовать фильтрацию по дате
        pass

def writeNote():
    ofstream = open("notes.txt", 'a+', "UTF-8")
    line = input("Введите заметку: ")
    if line != "":
        ofstream.write(line)
    else:
        print("Ошибочный ввод!")

def readNotes():
    ifstream = open("notes.txt", 'r', "UTF-8")
    for line in ifstream.readlines():
        print(line)


print("================================")
print("Заметочник запущен!")
print("================================")

while True:
    print("Команды:\n1. Написать заметку\n2. Прочитать заметку по номеру/дате/все заметки\n3. Редактировать заметку\n4. Удалить заметку")
    com = int(input("Введите номер команды"))
    match com:
        case 1:
            writeNote()
            break;
        case range(2):
            res = input("Все? [Y|N]")
            if res.lower() == "y": readNotes()
            else:
                res = input("По номеру? [Y|N]")
                if res.lower() == "y":
                    num = int(input("Номер записки: "))
                    readNote(num)
                else:
                    msgdate = input("Введите дату сообщения: ")
                    dt = dparser.parse(msgdate)
                    if dt is not None:
                        readNote(dt)

