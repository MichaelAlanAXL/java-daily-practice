import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> products = Arrays.asList(
            new Product("Laptop", 2500.0),
            new Product("Smartphone", 1500.0),
            new Product("Notebook", 15.0),
            new Product("Mouse", 50.0),
            new Product("Headphones", 200.0)
        );

        Map<Product, Integer> cart = new HashMap<>();

        while (true) { 
            System.out.println("\n===== MENU =====");
            for(int i = 0; i < products.size(); i++) {
                System.out.printf("%d - %s\n", i + 1, products.get(i));
            }
            System.out.println("0 - Finalizar compra");

            System.out.print("Escolha um produto: ");
            int choice = scanner.nextInt();

            if(choice == 0) break;
            if (choice < 0 || choice > products.size()) {
                System.out.println("Opção inválida!");
                continue;
            }

            Product chosen = products.get(choice - 1);
            cart.put(chosen, cart.getOrDefault(chosen, 0) + 1);
            System.out.println(chosen.getName() + " adicionado ao carrinho!");            
        }

        System.out.println("\n===== SEU CARRINHO =====");
        double total = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            double subtotal = p.getPrice() * qty;
            total += subtotal;
            System.out.printf("%s | Quantidade: %d | Unitário: R$ %.2f | Subtotal: R$ %.2f\n", 
                p.getName(), qty, p.getPrice(), subtotal); 
        }

        System.out.println("------------------------------");
        System.out.printf("TOTAL GERAL: R$ %.2f\n", total);
        System.out.println("Obrigado pela compra!");

        scanner.close();

    }
}
