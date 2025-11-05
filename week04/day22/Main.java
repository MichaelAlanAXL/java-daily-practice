import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm, EEEE", 
            new Locale("pt", "BR"));

        List<Appointment> appointments = List.of(
            new Appointment("Dentista", LocalDateTime.of(2025, 11, 10, 15, 0)),
            new Appointment("Reunião com o chefe", LocalDateTime.of(2025, 11, 4, 14, 30)),
            new Appointment("Academia", LocalDateTime.of(2025, 11, 5, 9, 0)),
            new Appointment("Churrasco", LocalDateTime.of(2025, 11, 7, 19, 0)),
            new Appointment("Consulta Geral", LocalDateTime.of(2025, 11, 4, 9, 45))
        );

        System.out.println("Agenda original:\n");
        appointments.forEach(a -> 
            System.out.println(a.getTitle() + " - " + a.getDateTime().format(formatter))
        );

        System.out.println("\n Agenda ordenada por data:\n");

        appointments.stream()
            .sorted(Comparator.comparing(Appointment::getDateTime))
            .forEach(a -> System.out.println(a.getTitle() + " - " + a.getDateTime().format(formatter)));
    }
}