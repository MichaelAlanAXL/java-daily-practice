import service.FileService;
import service.ShoppingService;
import model.Item;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        FileService fileService = new FileService();
        List<Item> lista = fileService.carregar();
        ShoppingService shopping = new ShoppingService(lista);

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Lista de Compras ===");
            System.out.println("1 - Adicionar item");
            System.out.println("2 - Listar por categoria");
            System.out.println("3 - Ranking de categorias");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    shopping.adicionar(nome, categoria, qtd);
                    fileService.salvar(shopping.getLista());
                    break;
                case 2:
                    shopping.listarPorCategoria();
                    break;

                case 3:
                    shopping.rankingCategorias();
                    break;
            }
        } while (opcao != 0);

        fileService.salvar(shopping.getLista());
        System.out.println("Até amanhã!");

    }
}
