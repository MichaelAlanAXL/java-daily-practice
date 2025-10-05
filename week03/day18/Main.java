
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            TagGenerator generator = new TagGenerator("text.txt");

            List<String> uniqueWordsDistinct = generator.getUniqueWordsWithDistinct();
            System.out.println("Palavras únicas com distinct():");
            uniqueWordsDistinct.forEach(System.out::println);

            System.out.println("\n===========================\n");

            Set<String> uniqueWordsSet = generator.getUniqueWordsWithSet();
            System.out.println("Palavras únicas com Set (ordenadas):");
            uniqueWordsSet.forEach(System.out::println);
            
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }    

}