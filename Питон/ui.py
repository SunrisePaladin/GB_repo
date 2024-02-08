from logger import print_data, input_data

def priv_msg():
    print("Hello message\n ask something\n1-write\n2-read")
    command = int(input("Number: "))

    while command < 1 or command > 2:
        command = int(input("Number: "))

    if command == 1:
        input_data()
    elif command == 2:
        print_data()

priv_msg()