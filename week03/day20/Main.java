
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Contestant> contestant = Arrays.asList(
            new Contestant("Alice", 85.0),
            new Contestant("Bob", 92.5),
            new Contestant("Charlie", 78.0),
            new Contestant("Diana", 95.0),
            new Contestant("Eve", 88.5)
        );

        System.out.println("Lista de participantes:");
        contestant.forEach(System.out::println);
        System.out.println("================================\n");   
        
        System.out.println("Ordenado (crescente):");
        contestant.stream()
            .sorted(Comparator.comparing(Contestant::getScore))
            .forEach(System.out::println);
        System.out.println("================================\n");

        System.out.println("Ordenado (decrescente):");
        contestant.stream()
            .sorted(Comparator.comparing(Contestant::getScore).reversed())
            .forEach(System.out::println);
        System.out.println("================================\n");

        System.out.println("Lista dos classificados:");
        List<Contestant> top3 = contestant.stream()
            .sorted(Comparator.comparing(Contestant::getScore).reversed())
            .limit(3)
            .collect(Collectors.toList());
            
        top3.forEach(System.out::println);
        System.out.println("================================\n");

        // Média das notas
        double average = contestant.stream()
            .mapToDouble(Contestant::getScore)
            .average()
            .orElse(0.0);

        System.out.println("Médias das notas: " + average);

        
        
    }
}
