
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho da senha: ");
        int length = scanner.nextInt();

        System.out.print("Deseja incluir símbolos: (s/n): ");
        boolean useSymbols = scanner.next().equalsIgnoreCase("s");

        var supplier = PasswordGenerator.getSupplier(length, useSymbols);

        System.out.println("\nGerando 3 senhas...");
        for (int i = 1; i <=3; i++) {
            System.out.println("Senha " + i + ": " + supplier.get());
        }

        scanner.close();
    }
}
