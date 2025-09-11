import java.util.List;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        List<Integer> pontos = List.of(50, 30, 70, 20);

        BinaryOperator<Integer> somaPontos = (p1, p2) -> p1 + p2;

        int total = pontos.stream().reduce(0, somaPontos);

        System.out.println("Total de pontos acumulados: " + total);

        BinaryOperator<Integer> maxPontos = BinaryOperator.maxBy(Integer::compare);
        int maior = pontos.stream().reduce(0, maxPontos);

        System.out.println("Maior pontuação: " + maior);
    }
}