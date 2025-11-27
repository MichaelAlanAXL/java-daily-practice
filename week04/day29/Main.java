import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Calculadora de IMC ===");
            System.out.println("1 - Adicionar pessoa");
            System.out.println("2 - Listar todas");
            System.out.println("3 - FIltrar IMC > 25");
            System.out.println("4 - Filtrar IMC < 18.5");
            System.out.println("0 - Sair");
            System.out.println("Escolha: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine().trim();

                    System.out.print("Peso (kg): ");
                    double peso = Double.parseDouble(scanner.nextLine());

                    System.out.print("Altura (m): ");
                    double altura = Double.parseDouble(scanner.nextLine());

                    pessoas.add(new Pessoa(nome, peso, altura));
                    System.out.println("Pessoa adicionada!");
                    break;
                case "2": 
                    System.out.println("\n--- Todas as pessoas ---");
                    pessoas.forEach(System.out::println);
                    break;
                case "3":
                    System.out.println("\n--- IMC acima de 25 (sobrepeso/obesidade) ---");
                    pessoas.stream()
                            .filter(p -> p.getImc() > 25)
                            .forEach(System.out::println);
                    break;
                case "4":
                    System.out.println("\n--- IMC abaixo de 18.5 (baixo peso) ---");
                    pessoas.stream()
                            .filter(p -> p.getImc() < 18.5)
                            .forEach(System.out::println);
                    break;
                case "0":
                    System.out.println("Encerrado.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }        
    }
}