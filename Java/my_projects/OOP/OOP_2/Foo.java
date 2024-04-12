package OOP.OOP_2;

public class Foo{
    public Integer value;
    public static Integer count=0;

    public Foo(){
        //count++;
    }

    public void printCount(){
        System.out.println(count);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
