import java.io.FileWriter;

public class build_string {
    public static void main(String[] args){
        
        // int n=500_000;
        // char c1 = 's';
        // char c2 = 'W';
        //String s = "aaaaaabbbccddddeeeeeee";
        //String pal = "amogus";

        //task1
        // long start = System.currentTimeMillis();
        // //System.out.println(getAlternatingCharsStr(n, c1, c2));
        // getAlternatingCharsStr(n, c1, c2);
        // System.out.println(System.currentTimeMillis() - start);
        // start = System.currentTimeMillis();
        // getAlternatingCharsSb(n, c1, c2);
        // //System.out.println(getAlternatingCharsSb(n, c1, c2));
        // System.out.println(System.currentTimeMillis() - start);

        //task2
        //System.out.println(pack(s));

        //task3
        //System.out.println(Is_pal(pal));

        //task4
        //String out = (repeat_word(pal, 100));
        //System.out.println(out);
        //write_to_file(out, "amogus.txt");

        //task5
    }

    public static void write_to_file(String s, String filename){
        try(FileWriter fout = new FileWriter(filename, false)){
            fout.write(s);
        }
        catch(Exception e){
            e.printStackTrace();
        }


        // FileWriter fout = null;
        // try{
        //     fout = new FileWriter(filename, false);
        //     fout.write(s);
        // }
        // catch(Exception e){
        //     e.printStackTrace();
        // }
        // finally{
        //     try{
        //         fout.close();
        //     }
        //     catch(Exception e){
        //         e.printStackTrace();
        //     }
        // }
    }

    public static String repeat_word(String word, int count){
        StringBuilder sb = new StringBuilder();
        //String res = String.join("", Collections.nCopies(count, word));
        //return res;
        for(int i=0; i<count; i++){
            sb.append(word);
        }
        return sb.toString();
    }

    public static Boolean Is_pal(String s){
        for (int i=0, k = s.length()-1; i<k; i++, k--){
            if (s.charAt(i) != s.charAt(k)) return false;
        }
        return true;
    }

    public static String pack(String s){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char next_char=s.charAt(1);
        for (int i=0; i < s.length()-1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                count++;
            }
            else{
                sb.append(s.charAt(i)).append(count);
                count = 1;
            }
            next_char = s.charAt(i+1);
        }
        if (next_char != sb.charAt(sb.length()-2)){
            sb.append(s.charAt(s.length()-1)).append(count);
        }
        return sb.toString();
    }

    public static String getAlternatingCharsStr(int n, char c1, char c2) {
        String str = "";
        for (int i=0; i < n/2; i++){
            str += Character.toString(c1) + Character.toString(c2);
        }
        return str;
    }

    public static String getAlternatingCharsSb(int n, char c1, char c2) {
        StringBuilder sb = new StringBuilder(n);
        for (int i=0; i < n/2; i++){
            sb.append(c1).append(c2);
        }
        return sb.toString();
    }
}
