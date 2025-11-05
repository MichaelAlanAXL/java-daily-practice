import java.time.LocalDateTime;

public class Appointment {
    private String title;
    private LocalDateTime dateTime;

    public Appointment(String title, LocalDateTime dateTime) {
        this.title = title;
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return title + " - " + dateTime;
    }
}