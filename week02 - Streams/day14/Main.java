
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite  um número: ");
        int limite = scanner.nextInt();

        System.out.println("Números primos até " + limite + ":");

        IntStream.rangeClosed(2, limite)
                 .filter(Main::isPrime)
                 .forEach(n -> System.out.print(n + " "));

        scanner.close();
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        return IntStream.rangeClosed(2, (int)Math.sqrt(num))
                        .allMatch(i -> num % i != 0);
    }
  
}
