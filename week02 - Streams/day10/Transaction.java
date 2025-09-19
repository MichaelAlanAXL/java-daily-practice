
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private final String type;
    private final double amount;
    private final Date when;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.when = new Date();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getWhen() {
        return when;
    }

    @Override
    public String toString() {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(when);
        return String.format("%s | %s | %.2f", time, type.toUpperCase(), amount);
    }
}
