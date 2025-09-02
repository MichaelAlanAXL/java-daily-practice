
import java.security.SecureRandom;
import java.util.function.Supplier;

public class PasswordGenerator {
    public static Supplier<String> getSupplier(int length, boolean useSymbols) {
        return () -> {
            String letters = "ABSDEFGHIJKLMNOPQRSTUVWXYZabcdefgh8ijklmnopqrstuvwxyz";
            String numbers = "0123456789";
            String symbols = "!@#$%&*";

            String chars = letters + numbers;
            if (useSymbols) {
                chars += symbols;
            }

            SecureRandom random = new SecureRandom();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(chars.length());
                sb.append(chars.charAt(index));
            }
            return sb.toString();
        };
    }
}
