import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> chat = message -> System.out.println("User said: " + message);

        System.out.println("=== Fake Chat ===");
        System.out.println("Type a message (type 'exit' to quit):");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Chat closed.");
                break;
            }

            chat.accept(input);

        }

        scanner.close();
    }
}
