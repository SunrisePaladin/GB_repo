def move_to(pos, source_file):
    pos -= 1
    if source_file == 1:
        with open('data_first_variant.csv', 'r', encoding='utf-8') as ifstream:
            data =''
            for i in range(pos):
                while data!='\n':
                    data = ifstream.readline()
                data = ''
            name = ifstream.readline()[:-1]+';'
            surname= ifstream.readline()[:-1]+';'
            phone= ifstream.readline()[:-1]+';'
            address = ifstream.readline()[:-1]+';'
            #print (name, surname, phone, address, sep =' ')
            ifstream.close()
        
        with open('data_second_variant.csv', 'a', encoding='utf-8') as ofstream:
            ofstream.write(f'\n{name}{surname}{phone}{address}\n')
            ofstream.close()
        
    if source_file == 2:
        with open('data_second_variant.csv', 'r', encoding='utf-8') as ifstream:
            data =''
            for i in range(pos):
                data = ifstream.readline()
                ifstream.readline()
            data = ifstream.readline().split(';')
            name, surname, phone, address = data
            #print(name, surname, phone, address)
            ifstream.close()
        with open('data_first_variant.csv', 'a', encoding='utf-8') as ofstream:
            ofstream.write(f'\n{name}\n'
                    f'{surname}\n'
                    f'{phone}\n'
                    f'{address}\n')
            ofstream.close()
#move_to(4, 2)