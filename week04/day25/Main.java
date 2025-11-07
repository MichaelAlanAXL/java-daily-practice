import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        System.out.println("=== Estatísticas de Números ===");
        System.out.println("Digite números inteiros (0 para finalizar):");

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            numeros.add(n);
        }

        if (numeros.isEmpty()) {
            System.out.println("Nenhum número inserido!");
            return;
        }

        // IntSummaryStatistics faz toda a mágica
        IntSummaryStatistics stats = numeros.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.println("\n RESULTADOS:");
        System.out.println("Quantidade: " + stats.getCount());
        System.out.println("Soma: " + stats.getSum());
        System.out.println("Média: " + stats.getAverage());
        System.out.println("Mínimo: " + stats.getMin());
        System.out.println("Máximo: " + stats.getMax());

        System.out.println("\n Estatísticas calculadas com sucesso!");
    }
}
