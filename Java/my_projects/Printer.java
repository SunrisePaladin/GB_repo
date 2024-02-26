
class Answer {  
    public static StringBuilder answer(String QUERY, String PARAMS){
      // Напишите свое решение ниже
        StringBuilder sb = new StringBuilder(QUERY); 
        String[] data = PARAMS.split(",");
        System.out.println(data.length);
        String field = "";
        String value = "";
        int it = 0;
        for (String string : data) {
            //it = 0;
            field = "";
            value = "";
            System.out.println(string);
            String[] tmp = string.split(":");
            field = tmp[0].trim().replaceAll("[{\"}]", "");
            value = tmp[1].trim().replaceAll("[{\"}]", "");
            ++it;
            System.out.println(it);
            if (!value.equals("null")){
                sb.append(field).append("='").append(value).append("'");
                
            }
            if (it < (int)data.length-1) sb.append(" and ");           
        }
        return sb;
    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
	public static void main(String[] args) { 
        String QUERY = "";
        String PARAMS = "";
        
    if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        QUERY = "select * from students where ";
        PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
    }
    else{
        QUERY = args[0];
        PARAMS = args[1];
    }     
        Answer ans = new Answer();      
        System.out.println(ans.answer(QUERY, PARAMS));
	}
}