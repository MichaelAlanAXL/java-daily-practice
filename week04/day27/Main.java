import service.ChatService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChatService chat = new ChatService();
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String usuario = sc.nextLine();

        int opcao;
        do {
            System.out.println("\n === Mini Chat ===");
            System.out.println("1 - Enviar mensagem");
            System.out.println("2 - Ver histórico (limite últimas 5 mais recentes)");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpa buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Mensagem: ");
                    String conteudo = sc.nextLine();
                    chat.enviarMensagem(usuario, conteudo);
                }
                case 2 -> chat.mostrarHistorio();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
    
}
