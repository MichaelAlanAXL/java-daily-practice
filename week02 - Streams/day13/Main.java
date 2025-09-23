import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat fmt = new DecimalFormat("#0.00");

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        boolean run = true;

        while (run) {
            clearScreen();
            printHeader();
            printMenu();
            System.out.print("Choose option: ");
            String opt = scanner.nextLine().trim();

            try {
                switch (opt) {
                    case "1" -> convert("Celsius", "Fahrenheit", Converter.C_TO_F);
                    case "2" -> convert("Fahrenheit", "Celsius", Converter.F_TO_C);
                    case "3" -> convert("Celsius", "Kelvin", Converter.C_TO_K);
                    case "4" -> convert("Kelvin", "Celsius", Converter.K_TO_C);
                    case "5" -> convert("Fahrenheit", "Kelvin", Converter.F_TO_K);
                    case "6" -> convert("Kelvin", "Fahrenheit", Converter.K_TO_F);
                    case "7" -> showCompositionExamples();
                    case "0" -> run = false;
                    default -> {
                        System.out.println("Invalid option. Press Enter to continue...");
                        scanner.nextLine();
                    }
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid number format. Press Enter to continue...");
                scanner.nextLine();
            }
        }

        System.out.println("\nBye -- converter closed.");
        scanner.close();
    }

    private static void convert(String fromLabel, String toLabel, Function<Double, Double> fn) {
        System.out.print("Enter value in " + fromLabel + ": ");
        String line = scanner.nextLine().trim();
        double input = Double.parseDouble(line);

        // optional physical check: Kelvin cannot be negative
        if (fromLabel.equalsIgnoreCase("Kelvin") && input < 0) {
            System.out.println("Warning: Kelvin can't be negative physically. Press Enter to continue...");
            scanner.nextLine();
            return;
        }

        double result = fn.apply(input);

        // If target is Kelvin and result < 0, still display but warn (rare)
        System.out.println("\n" + input + " " + shortUnit(fromLabel) + " -> " + fmt.format(result) + " " + shortUnit(toLabel));
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void showCompositionExamples() {
        System.out.println("\nComposition examples using Function.andThen():");
        System.out.println("F -> K (composed)  : example 32°F -> " + fmt.format(Converter.F_TO_K.apply(32.0)) + " K");
        System.out.println("K -> F (composed)  : example 273.15K -> " + fmt.format(Converter.K_TO_F.apply(273.15)) + " °F");
        System.out.println("\nNote: f.andThen(g) means g(f(x)). Press Enter to continue...");
        scanner.nextLine();
    }

    private static String shortUnit(String label) {
        return switch (label.toLowerCase()) {
            case "celsius" -> "°C";
            case "fahrenheit" -> "°F";
            case "kelvin" -> "K";
            default -> "";
        };
    }

    private static void printHeader() {
        System.out.println("==================================");
        System.out.println("     Temperature Converter Day13  ");
        System.out.println("==================================\n");
    }

    private static void printMenu() {
        System.out.println("1 - Celsius -> Fahrenheit");
        System.out.println("2 - Fahrenheit -> Celsius");
        System.out.println("3 - Celsius -> Kelvin");
        System.out.println("4 - Kelvin -> Celsius");
        System.out.println("5 - Fahrenheit -> Kelvin");
        System.out.println("6 - Kelvin -> Fahrenheit");
        System.out.println("7 - Show composition examples (andThen)");
        System.out.println("0 - Exit\n");
    }

    private static void clearScreen() {
        System.out.print("\n\n");
    }
}
