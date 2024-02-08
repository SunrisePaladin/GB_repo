from data_create import input_user_data

def input_data():
    name, surname, phone, address = input_user_data()
    ver = int(input("Укажите формат записи \n"
                    f'1 ver\n'
                    f'{name}\n'
                    f'{surname}\n'
                    f'{phone}\n'
                    f'{address}\n\n'
                    f'2 ver\n'
                    f'{name}, {surname}, {phone}, {address}\n\n'
                    f'ver: '))
    if ver == 1:
        fstream = open('data_first_variant.csv', 'a', encoding='utf-8')
        fstream.write(f'{name}\n'
                    f'{surname}\n'
                    f'{phone}\n'
                    f'{address}\n\n')
    elif ver == 2:
        with open('data_first_variant.csv', 'a', encoding='utf-8') as fstream:
            fstream.write(f'{name}\n'
                        f'{surname}\n'
                        f'{phone}\n'
                        f'{address}\n\n')

def print_data():
    print('1 file:')
    with open('data_first_variant.csv', 'r', encoding='utf-8') as fstream:
        data = fstream.readlines()
        print(''.join(data))

    print('2 file:')
    with open('data_second_variant.csv', 'r', encoding='utf-8') as fstream:
        data = fstream.readlines()
        print(''.join(data))