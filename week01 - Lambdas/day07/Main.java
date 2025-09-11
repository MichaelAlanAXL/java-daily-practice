
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Pessoa, LocalDate> aniversarios = new HashMap<>();

        Pessoa p1 = new Pessoa("Alice");
        Pessoa p2 = new Pessoa("Bob");
        Pessoa p3 = new Pessoa("Carol");

        aniversarios.put(p1, LocalDate.of(1990, 5, 12));
        aniversarios.put(p2, LocalDate.of(1985, 8, 23));
        aniversarios.put(p3, LocalDate.of(2000, 1, 3));

        System.out.println("Agenda de aniversários:");
        aniversarios.forEach((pessoa, data) -> 
            System.out.println(pessoa.getNome() + " -> " + data)
        );
    }
}
