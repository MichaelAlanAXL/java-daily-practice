import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            String content = Files.readString(Path.of("history-guide.txt"));

            List<String> palavras = Arrays.stream(content.toLowerCase().split("\\W+"))
                .filter(p -> !p.isBlank())
                .collect(Collectors.toList());
                        
            Map<String, Long> contagem = palavras.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                System.out.println("\n=== Top 20 palavras mais usadas ===");                
                contagem.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                    .limit(20)
                    .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

            System.out.println("\n=== Topo 20 palavras menos usadas ===");
            contagem.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(20)
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
            
            System.out.println("\n=== Todas as palavras (ordem alfabética) ===");
            contagem.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
            
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
        
    }
}
