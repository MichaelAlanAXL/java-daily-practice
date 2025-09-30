import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<LocalDateTime> logins = Arrays.asList(
            LocalDateTime.of(2025, 9, 20, 10, 30),
            LocalDateTime.of(2025, 9, 25, 9, 15),
            LocalDateTime.of(2025, 9, 27, 18, 45),
            LocalDateTime.of(2025, 9, 29, 8, 5)
        );

        // Ultimo login feito
        LocalDateTime lastLogin = logins.stream()
            .max(Comparator.naturalOrder())
            .orElse(null);

        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");        

        System.out.println("Histórico de logins:");
        logins.forEach(login -> System.out.println(login.format(formatterBR)));

        System.out.println("\nÚltimo login: " + lastLogin.format(formatterBR));
    }
}
