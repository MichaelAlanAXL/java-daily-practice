import service.CupomService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CupomService service = new CupomService();
        service.carregarDoArquivo();

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Gerador de Cupons ===");
            System.out.println("1 - Gerar novo cupom");
            System.out.println("2 - Listar cupons");
            System.out.println("3 - Salvar cupons");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> service.gerarNovoCupom();
                case 2 -> service.listarCupons();
                case 3 -> service.salvarEmArquivo();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
                
            }

        } while (opcao != 0);

        sc.close();
    }
    
}