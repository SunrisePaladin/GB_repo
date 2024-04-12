import java.util.*;

class PhoneLine{
    String name;
    ArrayList<Integer> phone_numbers = new ArrayList<>();

    PhoneLine(String _name, int _num) {
        // System.out.println("Constuct: "+name);
        name = _name;
        phone_numbers.add(_num);
    }

    public ArrayList<Integer> getPhones() {
        return this.phone_numbers;
    }

    public int getPhoneNumberCounter() {
        return this.getPhones().size();
    }
}

class PhoneBook{
    private static HashMap<Integer, PhoneLine> phoneBook = new HashMap<>(); //номер + запись
    private int counter = 1;
    public void add(String name, Integer phoneNum) {
        Boolean[] isExist = {false};
        phoneBook.forEach((k,v)->{
            if (v.name.equals(name)) {
                isExist[0] = true;
                // ArrayList<Integer> curPhones = v.getPhones();
                // curPhones.add(phoneNum);
                v.phone_numbers.add(phoneNum);
            }
        });
        if (isExist[0] == false) {
            phoneBook.put(counter, new PhoneLine(name, phoneNum));
        }

    }

    public static HashMap<Integer, PhoneLine> getPhoneBook() {
        return phoneBook;
    }
}


public class progress2 {
    public static void main(String[] args) {
        String name1;
        String name2;
        int phone1;
        int phone2;
        int phone3;

        if (args.length == 0) {
            name1 = "Ivanov";
            name2 = "Petrov";
            phone1 = 123456;
            phone2 = 654321;
            phone3 = 164321;
        } else {
            name1 = args[0];
            name2 = args[1];
            phone1 = Integer.parseInt(args[2]);
            phone2 = Integer.parseInt(args[3]);
            phone3 = Integer.parseInt(args[4]);
        }
        
        PhoneBook myPhoneBook = new PhoneBook();
        
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);
        myPhoneBook.add(name2, phone1);
        myPhoneBook.add(name2, phone3);
        
        System.out.println();

        Map<Integer, PhoneLine> pb = PhoneBook.getPhoneBook();
        //LinkedHashMap<Integer, PhoneLine> newMap = new LinkedHashMap<>(pb);
        List<PhoneLine> lines = new ArrayList<>(pb.values());
        Collections.sort(lines, Comparator.comparing(PhoneLine::getPhoneNumberCounter));
        for (PhoneLine p : lines) {
            System.out.println(p.name + " " + p.getPhones());
        }
    }
}
