public class build_string {
    public static void main(String[] args){
        //task1

        // int n=500_000;
        // char c1 = 's';
        // char c2 = 'W';
        //String s = "aaaaaabbbccddddeeeeeee";

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
