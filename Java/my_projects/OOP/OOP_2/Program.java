package OOP.OOP_2;

public class Program {

    static void A(){
        System.out.println("AAAAAAAAAAAAAA");
    }
    public static void main(String[] args){
        Foo f1 = new Foo();
        f1.value = 111;
        //System.out.println(f1.value);
        f1.printCount();
        Foo.count = 9999;

        Foo f2 = new Foo();
        f2.value = 222;
        //System.out.println(f2.value);
        f2.printCount();

        Foo f3 = new Foo();
        f3.value = 1111;
        //System.out.println(f3.value);
        f3.printCount();
    }
}
