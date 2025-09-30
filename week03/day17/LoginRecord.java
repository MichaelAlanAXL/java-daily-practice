
import java.time.LocalDateTime;

public class LoginRecord {
    private final String username;
    private final LocalDateTime loginDate;

    public LoginRecord(String username, LocalDateTime loginDate) {
        this.username = username;
        this.loginDate = loginDate;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getLoginDate() {
        return loginDate;
    }

    @Override
    public String toString() {
        return username + " -> " + loginDate;
    }
}
