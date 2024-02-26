
import java.util.*;

public class sem3{

    static List<ArrayList<String>> list = new ArrayList();

    public static void main(String[] args){
        task1(7, 1, 7);
        task2();
        addBook("Ужасы", "ывывффыв");
        addBook("Ужасы", "ыsdыв");
        addBook("Ужасы", "ывывsdaв");
        addBook("Биография", "ывaв");
        addBook("Наука", "ывaфырфырв");
        addBook("Детективы", "ывдзбждрв");
        addBook("Детективы", "зрозщщров");
        System.out.println(list);
    }
    static void task1(int n, int min, int max){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            list.add(new Random().nextInt(min, max+1));
        }
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }

    static void task2(){
        List list = new ArrayList();
        list.add(122);
        list.add("fsmsajsa");
        list.add("12.34");
        list.add(121221);
        list.add("567890");

        Iterator it = list.iterator();
        while (it.hasNext()){
            Object o = it.next();
            if (o instanceof Integer){
                it.remove();
            }
        }
        System.out.println(list);
    }

    static void addBook(String genre, String name){
        ArrayList<String> book = new ArrayList<>();
        for (ArrayList<String> s : list){
            if (s.contains(genre)){ //s.get(0).equals(genre)
                book = s;
                book.add(name);
                return;
            }
        }
        book = new ArrayList<>();
        book.add(genre);
        book.add(name);
        list.add(book);
    }
}