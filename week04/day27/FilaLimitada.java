import java.util.LinkedList;
import java.util.Queue;

public class FilaLimitada {
    private static final int LIMITE = 3;
    private static final Queue<String> historico = new LinkedList<>();

    public static void adicionarMensagem(String msg) {
        if (historico.size() == LIMITE) {
            historico.poll(); // remove o mais antigo (o primeiro addicionado)
        }
        historico.add(msg);
    }

    public static void main(String[] args) {
        adicionarMensagem("Oi!");
        adicionarMensagem("Tudo bem?");
        adicionarMensagem("Como vai?");
        adicionarMensagem("Nova mensagem...");

        System.out.println("Histórico atual (máx " + LIMITE + "): " + historico);
    }
    
}
