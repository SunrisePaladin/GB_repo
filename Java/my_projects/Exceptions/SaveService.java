import java.io.IOException;

package Exceptions;

public class SaveService {
    public void save(){
        System.out.println("Сейв в процессе");
        try (FileWriter writer = new FileWriter("text")){
            throw new IOException("Operation failed");
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
