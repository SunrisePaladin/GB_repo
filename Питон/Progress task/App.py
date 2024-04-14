# from __future__ import unicode_literals
import json
import dateutil.parser as dparser
from datetime import *

# Передайте номер для чтения заметки по номеру
def readNote(number=date.today()):
    ifstream = open("notes.json", 'r')
    if isinstance(number, int):
        for i in range(number):
            # дата, заголовок, содержимое
            ifstream.readline()
            ifstream.readline()
            ifstream.readline()
        resline = ifstream.readline()
        print(resline)
    else:
        #реализовать фильтрацию по дате
        pass
    ifstream.close()

def writeNote():
    ofstream = open("./Progress task/notes.txt", 'a')
    line = input("Введите заметку: ")
    if line != "":
        ofstream.write("\n" + line)
        print("написал")
    else:
        print("Ошибочный ввод!")
        ofstream.close()

def readNotes():
    ifstream = open("notes.json", 'r')
    for line in ifstream.readlines():
        print(line)


print("================================")
print("Заметочник запущен!")
print("================================")

while True:
    print("Команды:\n1. Написать заметку\n2. Прочитать заметку по номеру/дате/все заметки\n3. Редактировать заметку\n4. Удалить заметку")
    com = int(input("Введите номер команды: "))
    match com:
        case 1:
            writeNote()
        case 2:
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
        case _:
            pass
        

