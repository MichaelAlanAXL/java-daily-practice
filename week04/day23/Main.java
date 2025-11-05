import service.CidadeService;

public class Main {
    public static void main(String[] args) {
        CidadeService service = new CidadeService();

        var cidades = service.carregarCidades();

        System.out.println("Cidades mais populosas do mundo:\n");

        cidades.stream()
            .sorted((c1, c2) -> Long.compare(c2.getPopulacao(), c1.getPopulacao()))
            .limit(3)
            .forEach(System.out::println);
    }
}
