
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
            new Produto("Notebook", 5, 3500.0),
            new Produto("Mouse", 50, 80.0),
            new Produto("Teclado", 2, 150.0),
            new Produto("Monitor", 8, 1200.0),
            new Produto("Cadeira Gamer", 1, 900.0)
        );

        System.out.println("=== Produtos com estoque baixo (menos de 10) ===");
        produtos.stream()
            .filter(p -> p.getQuantidade() < 10)
            .forEach(System.out::println);
    }
}