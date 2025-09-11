import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Criar lista de jogadores
        List<Player> players = Arrays.asList(
            new Player("Michael", 100),
            new Player("Ana", 200),
            new Player("Carlos", 150),
            new Player("Bruna", 250),
            new Player("Diego", 180)
        );

        // Ordernar por score decrescente
        List<Player> ranking = players.stream()
            .sorted((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()))
            .collect(Collectors.toList());

        // Filtrar jogadores com score maior que 150
        Predicate<Player> highScore = p -> p.getScore() >= 150;
        List<Player> filteredRanking = ranking.stream()
            .filter(highScore)
            .collect(Collectors.toList());

        // Mostrar ranking completo
        System.out.println(" 🏆 Full Ranking:");
        ranking.forEach(p -> System.out.println(p));

        System.out.println("\n🔥 High Score (>=150):");
        filteredRanking.forEach(p -> System.out.println(p));
    }
}
