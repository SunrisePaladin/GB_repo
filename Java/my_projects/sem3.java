
import java.util.*;

public class sem3{
    public static void main(String[] args){
        task1(7, 1, 7);

    }
    static void task1(int n, int min, int max){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            list.add(new Random().nextInt(min, max+1));
        }
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}