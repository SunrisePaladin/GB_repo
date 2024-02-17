/**
 * program
 */
import java.util.Scanner;
public class program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("name: ");
        String name = scanner.nextLine();

        System.out.printf("Hello %s", name);
    }
}

