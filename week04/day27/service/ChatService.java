package service;

import model.Mensagem;
import java.util.LinkedList;
import java.util.Queue;

public class ChatService {
    private static final int LIMITE_HISTORICO = 5;
    private final Queue<Mensagem> historico = new LinkedList<>();

    public void enviarMensagem(String usuario, String conteudo) {
        if (historico.size() == LIMITE_HISTORICO) {
            historico.poll(); // se ja tiver 5 remove a mensagem mais antiga
        }
        historico.add(new Mensagem(usuario, conteudo));
    }

    public void mostrarHistorio() {
        System.out.println("\n=== Histórico de Mensagens ===");
        if (historico.isEmpty()) {
            System.out.println("Nenhuma mensagem ainda.");
            return;
        }
        historico.forEach(System.out::println);
    }
    
}
