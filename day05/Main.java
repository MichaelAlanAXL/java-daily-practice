import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<List<Integer>, Double> averageFunction = numbers -> {
            if (numbers.isEmpty()) return 0.0;
            double sum = 0;
            for (int n : numbers) {
                sum += n;
            }
            return sum / numbers.size();
        };

        List<Integer> numbers = new ArrayList<>();
        System.out.println("Digite quantos numeros quiser para calcular a média (type 'done' to finish):");

        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }
        scanner.close();

        double average = averageFunction.apply(numbers);

        System.out.println("Números: " + numbers);
        System.out.println("Média: " + average);
    }
}
