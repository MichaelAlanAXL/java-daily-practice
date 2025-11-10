import java.util.LinkedList;
import java.util.Queue;

public class ExemploBasicoFila {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        fila.add("Cliente 1");
        fila.add("Cliente 2");
        fila.add("Cliente 3");

        System.out.println("Fila atual: " + fila);

        // Atende (remove o primeiro da fila)
        String atendido = fila.poll(); // retorna e remove o primeiro elemento
        System.out.println("Atendendo: " + atendido);
        System.out.println("Fila após atendimento: " + fila);

        // Ver o próximo da fila
        System.out.println("Próximo da fila: " + fila.peek());
    }
}