import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {        
        List<Product> catalog = Arrays.asList(
            new Product(1, "Laptop", 2500.0, "Electronics"),
            new Product(2, "Smartphone", 1500.0, "Electronics"),
            new Product(3, "Notebook", 15.0, "Stationery")
        );

        catalog.stream()
            .forEach(p -> {
                double discountedPrice = p.getPrice() * 0.9; // 10% de desconto'
                System.out.printf("%s: ~~~R$ %.2f~~~ -> R$ %.2f%n", p.getName(), p.getPrice(), discountedPrice);
            });
    }
}