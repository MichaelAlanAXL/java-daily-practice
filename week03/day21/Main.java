
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> usuarios = Arrays.asList(
            "ana@gmail.com",
            "pedro@hotmail.com",
            "maria@gmail.com",
            "ana@gmail.com",
            "ana@gmail.com",
            "lucas@outlook.com"
        );

        Set<String> unicos = usuarios.stream()
            .map(String::toLowerCase)
            .distinct()
            .collect(Collectors.toSet());

        System.out.println("Usuários únicos no sistema:");
        unicos.forEach(System.out::println);

    }
}
