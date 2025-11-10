import java.util.concurrent.ConcurrentLinkedQueue;

public class FilaPedidos {
    private static final ConcurrentLinkedQueue<String> filaPedidos = new ConcurrentLinkedQueue<>();

    public static void receberPedido(String pedido) {
        filaPedidos.add(pedido);
        System.out.println("Pedido recebido: " + pedido);
    }

    public static void processarPedidos() {
        new Thread(() -> {
            while (!filaPedidos.isEmpty()) {
                String pedido = filaPedidos.poll();
                System.out.println("Processando: " + pedido);
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
            System.out.println("Todos os pedidos foram processados!");
        }).start();
    }

    public static void main(String[] args) {
        receberPedido("Pedido #001");
        receberPedido("Pedido #002");
        receberPedido("Pedido #003");

        processarPedidos();
    }
}
