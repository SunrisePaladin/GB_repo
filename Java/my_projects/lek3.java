// import java.util.ArrayList;
// import java.util.List;
import java.util.*;

public class lek3{
    public static void main(String[] args){
        System.out.println(Sum(1,2));
        System.out.println(Sum(1.0, 2));
        System.out.println(Sum(1,2.0));
        System.out.println(Sum(1.0,2.0));

        // List<Integer> arr = new ArrayList<Integer>();
        // arr.add(2809);
        // for (Object o: arr){
        //     System.out.println(o);
        // };

        // (1+2*3*4)*(10/5) - 20
        // 1 2 3 * 4 * +  5 10 / * 20 -
        
        //var exp = "20 30 - 10 *".split(" "); // (20-30)*10
        var exp = "1 2 3 * 4 * +  5 10 / * 20 -".split(" "); // (1 + 2) * 3
        
        //var exp = "1 2 3 * +".split(" "); // 1 + 2 * 3
        int res = 0;
        //System.out.println(exp);
        
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < exp.length; i++) {

            if (isDigit(exp[i])) {
                st.push(Integer.parseInt(exp[i]));
            } else {
                switch (exp[i]) {
                    case "+":
                        res = st.pop() + st.pop();
                        st.push(res);
                        break;
                    case "-":
                        res = -st.pop() + st.pop();
                        st.push(res);
                        break;
                    case "*":
                        res = st.pop() * st.pop();
                        st.push(res);
                        break;
                    case "/":
                        res =  st.pop()/ st.pop();
                        st.push(res);
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.printf("%d\n", st.pop());

    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static Object Sum(Object a, Object b){
        if (a instanceof Integer && b instanceof Integer){return (Object)((Integer) a + (Integer)b);}
        else if (a instanceof Integer && b instanceof Double){return (Object)((Integer) a + (Double)b);}
        else if (a instanceof Double && b instanceof Integer){return (Object)((Double) a + (Integer)b);}
        else if (a instanceof Double && b instanceof Double){return (Object)((Double) a + (Double)b);}
        else return 0;
    }
}