import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> presencas = new HashSet<>();

        while(true) {
            System.out.println("\n=== Controle de Presença ===");
            System.out.println("1 - Registrar presença");
            System.out.println("2 - Listar presentes (ordenado)");
            System.out.println("3 - Buscar aluno");
            System.out.println("0 - Sair");
            System.out.println("Escolha: ");

            String  option = scanner.nextLine();

            switch (option) {
                case "1" :
                    System.out.println("Nome do aluno: ");
                    String nome = scanner.nextLine().trim();
                    if (presencas.add(nome)) {
                        System.out.println("Presença registrada!");
                    } else {
                        System.out.println("Aluno já registrado.");
                    }
                    break;
                case "2" :
                    System.out.println("\n--- Lista de alunos presentes ---");
                    presencas.stream()
                             .sorted()
                             .forEach(System.out::println);
                    break;
                case "3" :
                    System.out.println("Nome para buscar: ");
                    String busca = scanner.nextLine().trim();

                    boolean encontrado = presencas.stream().anyMatch(n -> n.equalsIgnoreCase(busca));

                    System.out.println(encontrado ? "Aluno presente!" : "Aluno não encontrado.");
                    break;
                case "0" :
                    System.out.println("Encerrado.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
